package com.oschrenk.ab2batchgeo.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

import au.com.bytecode.opencsv.CSVWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class CsvWriter.
 */
public class CsvWriter {

	/** The Constant ENCODING. */
	private static final String ENCODING = "UTF-8";

	/** The Constant SEPERATOR. */
	private static final char SEPARATOR = '\t';

	/** The Constant QUOTE_CHARACTER. */
	private static final char QUOTE_CHARACTER = '\0';

	/** The Constant HEADER. */
	private static final String[] HEADER = { "Name", "Straße", "Stadt", "PLZ",
			"Land" };

	/** The path. */
	private final File path;

	/**
	 * Instantiates a new csv writer.
	 *
	 * @param path
	 *            the path
	 */
	public CsvWriter(final File path) {
		this.path = path;
	}

	/**
	 * Write.
	 *
	 * @param rows
	 *            the rows
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public void write(final List<String[]> rows) throws IOException {
		final CSVWriter csvWriter = new CSVWriter(new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(path), ENCODING)),
				SEPARATOR, QUOTE_CHARACTER);
		try {
			csvWriter.writeNext(HEADER);
			csvWriter.writeAll(rows);
		} finally {
			csvWriter.close();
		}

	}
}
