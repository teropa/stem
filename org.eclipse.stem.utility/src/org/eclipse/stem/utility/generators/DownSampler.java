package org.eclipse.stem.utility.generators;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

/**
 * 
 * STEM II Data Migration/Generation Utilities : Instances of this class run a
 * SinglePassDownSampler object and if more than one pass is necessary it runs
 * an instance of MultiPassDownSampler. You can specify as arguments the
 * threshold (alpha degrees)
 * 
 * 
 * To configure, see configuration file :
 * org.eclipse.stem.utility/configuration/DownSampler.config
 * 
 * 
 * To run, add path to configuration file in the run profile (i.e.
 * C:\stemII\org.eclipse.stem.utility\configuration\DownSampler.config)
 * 
 * SET VMARGS TO : -Xms1024m -Xmx1024m
 * 
 */

public class DownSampler {

	/**
	 * Execution entry point
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// final int SINGLE_PASS = 1;
		// final int THRESHOLD = 0;
		// final int PASSES = 1;
		// final int ISO_3166_1 = 2;
		// final int ISO_3166_2 = 3;
		// final int FIX_FILE = 4;
		// final int SINGLE_PASS_TARGET_LIST = 5; // The path to the original
		// data
		// // file (single-pass downsampler only)
		// final int MULTI_PASS_TARGET_LIST = 6; // A list of alpha 3 codes for
		// // (multi-pass downsampler only)
		// final int LEX_DIR = 7;
		// final int OUTPUT_DIR = 8;
		// final int PARAMS = 9;
		//
		// if (args.length < PARAMS) {
		// System.out.println("--Wrong arguments--"); //$NON-NLS-1$
		// System.out
		// .println("\tTo run, please provide the following arguments : ");
		// //$NON-NLS-1$
		// System.out.println("\t\t Threshold (in degrees)"); //$NON-NLS-1$
		// System.out.println("\t\t Total iterations"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-1 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO 3166-2 file"); //$NON-NLS-1$
		// System.out.println("\t\t ISO fix file"); //$NON-NLS-1$
		// System.out.println("\t\t Single pass target countries file");
		// //$NON-NLS-1$
		// System.out.println("\t\t Multi pass target countries file");
		// //$NON-NLS-1$
		// System.out.println("\t\t Lexicographic sorting directory");
		// //$NON-NLS-1$$
		// System.out.println("\t\t Output directory"); //$NON-NLS-1$
		// return;
		// }
		//
		// // SinglePassDownSampler performs one pass, the first pass only.
		// SinglePassDownSampler simpleSampler = new SinglePassDownSampler(
		// args[THRESHOLD], args[ISO_3166_1], args[ISO_3166_2],
		// args[FIX_FILE], args[SINGLE_PASS_TARGET_LIST], args[LEX_DIR],
		// args[OUTPUT_DIR]);
		// simpleSampler.run();
		//
		// // If more than one pass is needed, then run MultiPassDownSampler.
		// if (Integer.parseInt(args[PASSES]) > SINGLE_PASS) {
		// MultiPassDownSampler multiSampler = new MultiPassDownSampler(
		// args[THRESHOLD], args[PASSES], args[ISO_3166_1],
		// args[ISO_3166_2], args[FIX_FILE],
		// args[MULTI_PASS_TARGET_LIST], args[LEX_DIR],
		// args[OUTPUT_DIR]);
		// multiSampler.run();
		// }

		final int CONFIG_FILE = 0;
		final int PARAMS = 1;

		if (args.length < PARAMS) {
			System.out.println("\t\t--Wrong arguments--"); //$NON-NLS-1$
			System.out
					.println("\t\tTo run, please provide the following argument(s) : "); //$NON-NLS-1$
			System.out.println("\t\t\t Configuration file"); //$NON-NLS-1$
			System.exit(1);
		}

		// SinglePassDownSampler performs one pass, the first pass only.
		SinglePassDownSampler s1 = new SinglePassDownSampler(args[CONFIG_FILE]);
		s1.run();

		// If more than one pass is needed, then run MultiPassDownSampler.
		// if (Integer.parseInt(args[PASSES]) > SINGLE_PASS) {
		MultiPassDownSampler s2 = new MultiPassDownSampler(args[CONFIG_FILE]);
		s2.run();
		// }

	}

} // main
