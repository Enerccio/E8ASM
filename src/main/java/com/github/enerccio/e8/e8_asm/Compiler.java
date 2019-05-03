package com.github.enerccio.e8.e8_asm;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.io.FileUtils;

import com.github.enerccio.e8.e8_asm.AssemblerUnit.MacroDef;

public class Compiler {

	private static boolean VERBOSE = false;

	public static void main(String[] args) throws Exception {

		Options options = new Options();

		options.addOption(new Option("h", false, "Prints this help"));
		options.addOption(new Option("v", false, "Verbose output"));
		options.addOption(new Option("d", false, "Create also disassembly file"));
		options.addOption(new Option("i", true, "Source .e8a files to be assembled"));
		options.addOption(new Option("o", true, "Output file"));
		options.addOption(
				new Option("L", true, "Library locations, all e8l/e8m files in these directories will be assembled"));

		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);

		if (cmd.hasOption('h')) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("java -jar " + getJarName(), options);
			return;
		}

		if (cmd.hasOption('v')) {
			VERBOSE = true;
		}

		String inputFiles = cmd.getOptionValue('i');
		String outputFile = cmd.getOptionValue('o');

		if (inputFiles == null) {
			System.err.println("No input files");
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("java -jar " + getJarName(), options);
			return;
		}

		if (outputFile == null) {
			System.err.println("No output file");
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("java -jar " + getJarName(), options);
			return;
		}

		List<AssemblerUnit> assembleUnits = new ArrayList<AssemblerUnit>();
		List<AssemblerUnit> macroSources = new ArrayList<AssemblerUnit>();
		Map<String, MacroDef> globalMacros = new ConcurrentHashMap<>();

		for (String split : inputFiles.split(Pattern.quote(" "))) {
			AssemblerUnit u = new AssemblerUnit(new File(split), false, false);
			u.setGlobalMacros(globalMacros);
			assembleUnits.add(u);
		}

		String libs = cmd.getOptionValue('L');

		if (libs != null) {
			for (String libraryPath : libs.split(Pattern.quote(" "))) {
				File rootPath = new File(libraryPath);
				for (File f : FileUtils.listFiles(rootPath, new String[] { "e8l" }, true)) {
					AssemblerUnit u = new AssemblerUnit(f, true, false);
					u.setGlobalMacros(globalMacros);
					assembleUnits.add(u);
				}
			}

			for (String libraryPath : libs.split(Pattern.quote(" "))) {
				File rootPath = new File(libraryPath);
				for (File f : FileUtils.listFiles(rootPath, new String[] { "e8m" }, true)) {
					AssemblerUnit u = new AssemblerUnit(f, true, true);
					u.setGlobalMacros(globalMacros);
					macroSources.add(u);
				}
			}
		}

		new Compiler().compile(assembleUnits, macroSources, outputFile, cmd.hasOption('d'));
	}

	private void compile(List<AssemblerUnit> assembleUnits, List<AssemblerUnit> macros, String outputFile, boolean includeDisassembly)
			throws Exception {

		System.out.println("Starting assembly");

		ExecutorService assembler = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<AssembledUnit> units = Collections.synchronizedList(new ArrayList<AssembledUnit>());
		Map<AssemblerUnit, Throwable> exceptions = Collections.synchronizedMap(new HashMap<AssemblerUnit, Throwable>());
		
		verbose("Starting macro assembly.");
		for (AssemblerUnit au : macros) {
			assembler.submit(() -> {
				try {
					au.assemble();
				} catch (Throwable t) {
					exceptions.put(au, t);
				}
			});
		}

		assembler.shutdown();
		assembler.awaitTermination(9999999, TimeUnit.DAYS);
		verbose("Macro assembly completed.");

		if (!exceptions.isEmpty()) {
			System.err.println("Some assembly units failed to assembly: \n");
			for (AssemblerUnit au : exceptions.keySet()) {
				Throwable t = exceptions.get(au);

				System.err.println(String.format("Exception in assembling %s: ", au.getSrcFile()));
				t.printStackTrace();
				System.err.println();
			}
		}

		assembler = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		verbose("Starting main assembly.");
		for (AssemblerUnit au : assembleUnits) {
			assembler.submit(() -> {
				try {
					units.addAll(au.assemble());
				} catch (Throwable t) {
					exceptions.put(au, t);
				}
			});
		}

		assembler.shutdown();
		assembler.awaitTermination(9999999, TimeUnit.DAYS);
		verbose("Main assembly completed.");

		if (!exceptions.isEmpty()) {
			System.err.println("Some assembly units failed to assembly: \n");
			for (AssemblerUnit au : exceptions.keySet()) {
				Throwable t = exceptions.get(au);

				System.err.println(String.format("Exception in assembling %s: ", au.getSrcFile()));
				t.printStackTrace();
				System.err.println();
			}
		}

		System.out.println("Linking assembled units");

		Linker l = new Linker(units);
		l.link(outputFile, includeDisassembly);
	}

	private static String getJarName() {
		try {
			return new java.io.File(Compiler.class.getProtectionDomain().getCodeSource().getLocation().getPath())
					.getName();
		} catch (Exception e) {
			return "unknown.jar";
		}
	}
	
	public static void verbose(String message) {
		if (VERBOSE) {
			System.out.println(Thread.currentThread().getName() + " (VERBOSE): " + message);
		}
	}
}
