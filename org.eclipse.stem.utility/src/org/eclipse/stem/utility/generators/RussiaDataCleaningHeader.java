package org.eclipse.stem.utility.generators;

/**
 * 
 * Relevant keys to the Russian dataset. Keys in this class are used during the
 * data cleaning process to extract only the relevant keys from the original
 * data source file for Russia. These keys are used when running an instance of
 * RussiaDataCleaner to perform data cleaning.
 * 
 */
public abstract class RussiaDataCleaningHeader {

	/**
	 * Administration ID (numeric)
	 */
	public static final int ID = 4;

	/**
	 * Total Area
	 */
	public static final int AREA = 5;
	
	/**
	 * Country identifier
	 */
	public static final int COUNTRY = 9;

	/**
	 * Location name 1
	 */
	public static final int NAME1 = 10;

	/**
	 * Location name 2
	 */
	public static final int NAME2 = 11;

	/**
	 * Location name 3
	 */
	public static final int NAME3 = 12;

	/**
	 * Population value (estimated population for 1995)
	 */
	public static final int POP1 = 14;

	/**
	 * Population value (concrete population)
	 */
	public static final int POP2 = 16;

}