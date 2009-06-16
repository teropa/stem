package org.eclipse.stem.utility.generators;

/**
 * 
 * Relevant keys to the European dataset. Keys in this class are used during the
 * data cleaning process to extract only the relevant keys from the original
 * data source file for Europe. These keys are used when running an instance of
 * EuropeDataCleaner to perform data cleaning.
 * 
 */
public abstract class EuropeDataCleaningHeader {

	/**
	 * Numeric ID
	 */
	public static final int NUMID = 6;

	/**
	 * Name ID
	 */
	public static final int STRID = 7;

	/**
	 * Total Area
	 */
	public static final int AREA = 11;

	/**
	 * Population value 1
	 */
	public static final int POP1 = 15;

	/**
	 * Population value 2
	 */
	public static final int POP2 = 16;

	/**
	 * Population value 3
	 */
	public static final int POP3 = 17;

	/**
	 * Population value 4
	 */
	public static final int POP4 = 18;

	/**
	 * Alternative ID
	 */
	public static final int TEMPID = 20;

}