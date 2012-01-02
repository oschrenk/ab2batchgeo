package com.oschrenk.ab2batchgeo.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

import com.google.common.base.Strings;

/**
 * The Class CsvReader.
 */
public class CsvReader {

	/** The Constant ENCODING. */
	private static final String ENCODING = "UTF-8";

	/** The Constant QUOTE_CHARACTER. */
	private static final char QUOTE_CHARACTER = '\"';

	/** The Constant SEPERATOR. */
	private static final char SEPARATOR = '\t';

	/** The Constant NUMBER_OF_HEADER_LINES. */
	private static final int NUMBER_OF_HEADER_LINES = 1;

	/**
	 * Read.
	 *
	 * @param path
	 *            the path
	 * @return the list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public List<String[]> read(final File path) throws IOException {
		final CSVReader csvReader = new CSVReader(new InputStreamReader(
				new FileInputStream(path), ENCODING), SEPARATOR,
				QUOTE_CHARACTER, NUMBER_OF_HEADER_LINES);
		try {
			final List<String[]> rows = new ArrayList<String[]>();
			String[] nextLine;
			while ((nextLine = csvReader.readNext()) != null) {

				final String forename = Strings.nullToEmpty(
						nextLine[Field.FORENAME.number()]).trim();
				final String surname = Strings.nullToEmpty(
						nextLine[Field.SURNAME.number()]).trim();
				final String company = Strings.nullToEmpty(
						nextLine[Field.COMPANY.number()]).trim();
				final String workStreet = Strings.nullToEmpty(
						nextLine[Field.WORK_STREET.number()]).trim();
				final String workCity = Strings.nullToEmpty(
						nextLine[Field.WORK_CITY.number()]).trim();
				final String workZipcode = Strings.nullToEmpty(
						nextLine[Field.WORK_ZIPCODE.number()]).trim();
				final String workCountry = Strings.nullToEmpty(
						nextLine[Field.WORK_COUNTRY.number()]).trim();
				final String privateStreet = Strings.nullToEmpty(
						nextLine[Field.PRIVATE_STREET.number()]).trim();
				final String privateCity = Strings.nullToEmpty(
						nextLine[Field.PRIVATE_CITY.number()]).trim();
				final String privateZipcode = Strings.nullToEmpty(
						nextLine[Field.PRIVATE_ZIPCODE.number()]).trim();
				final String privateCountry = Strings.nullToEmpty(
						nextLine[Field.PRIVATE_COUNTRY.number()]).trim();

				final String privateName = forename + " " + surname;
				final String companyName = privateName.trim().isEmpty() ? company
						: privateName;

				if (workStreet.isEmpty() && privateStreet.isEmpty()) {
					continue;
				}

				if (!workStreet.isEmpty()) {
					if (privateName.trim().isEmpty()) {

					}

					rows.add(new String[] { companyName, workStreet, workCity,
							workZipcode, workCountry });
				}

				if (!privateStreet.isEmpty()) {
					rows.add(new String[] { privateName, privateStreet,
							privateCity, privateZipcode, privateCountry });
				}

			}

			return rows;

		} finally {
			csvReader.close();
		}

	}

	public static enum Field {

		FORENAME(0), SURNAME(1), COMPANY(2), WORK_STREET(3), WORK_CITY(4), WORK_ZIPCODE(
				5), WORK_COUNTRY(6), PRIVATE_STREET(7), PRIVATE_CITY(8), PRIVATE_ZIPCODE(
				9), PRIVATE_COUNTRY(10);

		/** The field. */
		private final int number;

		/**
		 * Instantiates a new field.
		 *
		 * @param number
		 *            the number
		 */
		private Field(final int number) {
			this.number = number;
		}

		/**
		 * number.
		 *
		 * @return the int
		 */
		public int number() {
			return number;
		}

	}

}
