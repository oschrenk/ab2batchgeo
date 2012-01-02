package com.oschrenk.ab2batchgeo.ui.cli;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.oschrenk.ab2batchgeo.io.CsvReader;
import com.oschrenk.ab2batchgeo.io.CsvWriter;

/**
 * The Class CommandLine.
 *
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class CommandLine {

	/** The Constant SIGILL. */
	private static final int SIGILL = 4;

	/**
	 * The main method.
	 *
	 * @param arguments
	 *            the arguments
	 */
	public static void main(final String[] arguments) {

		if (arguments.length < 2) {
			System.err.println("Too few arguments");
			// TODO print usage
			System.exit(SIGILL);
		}
		if (arguments.length > 2) {
			System.err.println("Too many arguments");
			// TODO print usage
			System.exit(SIGILL);
		}

		final File input = new File(arguments[0]);
		final File output = new File(arguments[1]);

		final CsvReader reader = new CsvReader();
		final CsvWriter writer = new CsvWriter(output);
		try {
			final List<String[]> rows = reader.read(input);
			writer.write(rows);
		} catch (final IOException e) {
			System.err.println("Error reading or writing files");
			System.exit(SIGILL);
		}

	}
}
