/**
 * 
 */
package org.eclipse.stem.diseasemodels.standard.tests;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;

/**
 * @author kaufman
 *
 */
public class TestUtilities {
	
	public static final double TRANSMISSION_RATE_TO_TEST = 2.0;
	public static final double S_TO_TEST = 100.0;
	public static final double I_TO_TEST = 1.0;
	public static final double E_TO_TEST = 0.0;
	public static final double R_TO_TEST = 0.0;
	public static final double P_TO_TEST = S_TO_TEST+E_TO_TEST+I_TO_TEST+R_TO_TEST;
	public static final double GAIN_TO_TEST = 0.0; // noise zero for testing
	// Disease Model Test URI's
	public static final String MODEL = "DISEASEMODEL";
	public static final URI DEFAULT_URI = STEMURI.createURI(MODEL + "/" + "defaultTestURI");
	public static long TIME_ONE_DAY = 1;
	public static long TIME_TWO_DAY = 2;
	public static STEMTime getSTEMTime() {
		return ModelFactory.eINSTANCE.createSTEMTime();
	}


}
