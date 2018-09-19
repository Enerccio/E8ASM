package com.github.enerccio.e8.e8_asm;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

public class Compiler {
	
	public static void main(String[] args) throws Exception {
		
		Options options = new Options();
		
		options.addOption(new Option("h", false, "Prints this help"));
		options.addOption(new Option("i", true, "Source .e8a files to be assembled"));
		options.addOption(new Option("o", true, "Output file"));
		options.addOption(new Option("L", true, "Library locations, all e8l files in these directories will be assembled"));
		
		CommandLineParser parser = new DefaultParser();
		CommandLine cmd = parser.parse(options, args);
		
		if (cmd.getOptionValue('h') != null) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "java -jar e8asm", options);
			return;
		}
		
		String inputFiles = cmd.getOptionValue('i');
		String outputFile = cmd.getOptionValue('o');
		
		if (inputFiles == null) {
			System.err.println("No input files");
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "java -jar e8asm", options);
			return;
		}
		
		if (outputFile == null) {
			System.err.println("No output file");
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp( "java -jar e8asm", options);
			return;
		}
		
		List<AssemblerUnit> assembleUnits = new ArrayList<AssemblerUnit>();
	
		for (String split : inputFiles.split(Pattern.quote(" "))) {
			assembleUnits.add(new AssemblerUnit(new File(split), false));
		}
		
		String libs = cmd.getOptionValue('L');
		
		if (libs != null) {
			for (String libraryPath : libs.split(Pattern.quote(" "))) {
				File rootPath = new File(libraryPath);
				for (File f : FileUtils.listFiles(rootPath, new String[] {"e8l"}, true)) {
					assembleUnits.add(new AssemblerUnit(f, true));
				}
			}
		}
		
		new Compiler().compile(assembleUnits, outputFile);
	}

	private void compile(List<AssemblerUnit> assembleUnits, String outputFile) throws Exception {
		
		System.out.println("Starting assembly");
		
		ExecutorService assembler = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		List<AssembledUnit> units = Collections.synchronizedList(new ArrayList<AssembledUnit>());
		Map<AssemblerUnit, Throwable> exceptions = Collections.synchronizedMap(new HashMap<AssemblerUnit, Throwable>());
		
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
		l.link(outputFile);
	}

}
