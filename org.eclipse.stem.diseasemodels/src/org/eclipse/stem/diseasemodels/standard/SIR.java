// SIR.java
package org.eclipse.stem.diseasemodels.standard;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;

/**
 * A {@link DiseaseModel} with three states <em>Susceptible</em>,
 * <em>Infectious</em> and <em>Recovered</em>(SIR).
 * 
 * <p>
 * The basic <em>SIR</em> (Susceptible, Infectious, Recovered) disease model
 * assumes a uniform population at a single location and that the population
 * members are well "mixed", meaning that they are equally likely to meet and
 * infect each other. This model, for a normalized population, is defined by the
 * three equations below:
 * <ul>
 * <li><em>&Delta;s = &mu;  &minus; &beta;s i + &gamma;r &minus; &mu;s</em>
 * </li>
 * <li><em>&Delta;i = &beta;s i &minus; &sigma;i  &minus; &mu;i</em> </li>
 * <li><em>&Delta;r =   &sigma;i &minus; &gamma;r &minus; &mu;r</em> </li>
 * </ul>
 * 
 * 
 * <p>
 * Where:
 * <ul>
 * <li><em>s</em> is the normalized <em>Susceptible</em> population </li>
 * <li> <em>i</em> is the normalized <em>Infectious</em> population</li>
 * <li>&mu; is the background mortality rate, and, because it is assumed that
 * the population was not growing or shrinking significantly before the onset of
 * the disease, &mu; is also assumed to be the birth rate. </li>
 * <li> <em>&beta;</em> is the disease transmission (infection) rate. This
 * coefficient determines the number of population members that become
 * infected/exposed per population member in the <em>Infectious</em> state,
 * assuming the entire population is in the <em>Susceptible</em> state. </li>
 * <li> &sigma; is the <em>Infectious</em> recovery rate. This coefficient
 * determines the rate at which <em>Infectious</em> population members
 * <em>Recover</em>.</li>
 * <li><em>&gamma;</em> is the immunity loss rate. This coefficient
 * determines the rate at which <em>Recovered</em> population members lose
 * their immunity to the disease and become <em>Susceptible</em> again.</li>
 * </ul>
 * </p>
 * Following basically the same derivation as outlined in {@link SI} for the SI
 * model, these become:
 * 
 * <p>
 * Let
 * <ul>
 * <li><em>x</em> be the <em>Infectious Mortality</em> which is the
 * proportion of the population members who become <em>Infectious</em> that
 * will eventually die.</li>
 * <li><em>&mu;<sub>i</sub></em> be the <em>Infectious Mortality Rate</em>.
 * This is the rate at which fatally infected population members die
 * specifically due to the disease. </li>
 * </ul>
 * Thus, we now have two types of <em>Infectious</em> population members,
 * those that will eventually recover at rate <em>&sigma;</em>, and those that
 * will eventually die at rate <em>&mu;<sub>i</sub></em> (of course, members
 * in all three states still die at the background rate <em>&mu;</em>).
 * </p>
 * <p>
 * Let
 * <ul>
 * <li><em> i <sup>R</sup></em> be the normalized infectious population that
 * will recover.</li>
 * <li><em> i <sup>F</sup></em> be the normalized infectious population that
 * will die from the disease.</li>
 * <li><em> i = i <sup>R</sup> +  i <sup>F</sup></em> be the total normalized
 * infectious population (as before).</li>
 * </ul>
 * </p>
 * 
 * <p>
 * We modify our model to include these additional states and rates.
 * <ul>
 * <li><em>&Delta;s = &mu;  &minus; &beta;s i + &gamma;r  &minus; &mu; s</em>
 * </li>
 * <li><em>&Delta;i <sup>R</sup> = (1-x)&beta;s i &minus; &sigma;i <sup>R</sup>  &minus; &mu;i <sup>R</sup></em>
 * </li>
 * <li><em>&Delta;i <sup>F</sup> = x &beta;s i &minus; (&mu; + &mu;<sub>i</sub>) i <sup>F</sup></em>
 * </li>
 * <li><em>&Delta;r =   &sigma;i<sup>R</sup> &minus; &gamma;r &minus; &mu;r</em>
 * </li>
 * 
 * </ul>
 * </p>
 * <h3>Spatial Adaptation</h3>
 * <p>
 * <ul>
 * <li><em>&Delta;s P<sub>l</sub>= &mu;P<sub>l</sub>  &minus; &beta;<sub>l</sub> s i P<sub>l</sub> + &gamma; r P<sub>l</sub>  &minus; &mu; s P<sub>l</sub></em>
 * </li>
 * <li><em>&Delta;i <sup>R</sup> P<sub>l</sub> = (1-x)&beta;<sub>l</sub> s i P<sub>l</sub> &minus; &sigma; i <sup>R</sup> P<sub>l</sub> &minus; &mu;i <sup>R</sup> P<sub>l</sub></em>
 * </li>
 * <li><em>&Delta;i <sup>F</sup> P<sub>l</sub> = x &beta;<sub>l</sub>s i P<sub>l</sub> &minus; (&mu; + &mu;<sub>i</sub>) i <sup>F</sup> P<sub>l</sub></em>
 * </li>
 * <li><em>&Delta;r P<sub>l</sub>=   &sigma;i<sup>R</sup>P<sub>l</sub> &minus; &gamma;r P<sub>l</sub>&minus; &mu;r P<sub>l</sub></em>
 * </li>
 * </ul>
 * 
 * <p>
 * Let <em>S<sub>l</sub> = s P<sub>l</sub></em> be the number of
 * <em>Susceptible</em> population members at location <em>l</em>.
 * Similarly, let <em>I<sub>l</sub> = i P<sub>l</sub></em> be the number
 * of population members at location <em>l</em> that are <em>Infectious</em>
 * (both states combined), and let
 * <em>r P<sub>l</sub> be the <em>Recovered</em> population.
 * For readability, we drop the <em>l</em> subscript and substitute.
 * </p>
 * Substituting
 *  
 * </p>
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; &beta;<sub>l</sub> S i + &gamma;R  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)&beta;<sub>l</sub> S i &minus; &sigma;I <sup>R</sup> &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x &beta;<sub>l</sub>S i  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 *  <li><em>&Delta;R=   &sigma;I<sup>R</sup> &minus; &gamma;R &minus; &mu;R</em> </li>
 * </ul>
 * 
 *   Continuing with <em> i = I/P<sub>l</sub></em>, we have:
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; (&beta;<sub>l</sub>/P<sub>l</sub>) S I + &gamma;R  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)(&beta;<sub>l</sub>/P<sub>l</sub>) S I &minus; &sigma;I <sup>R</sup>  &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x (&beta;<sub>l</sub>/P<sub>l</sub>) S I  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 *   <li><em>&Delta;R=   &sigma;I<sup>R</sup> &minus; &gamma;R &minus; &mu;R</em> </li>
 * </ul>
 * 
 * Letting
 * <em>&beta;<sup>*</sup> = &beta;<sub>l</sub>/P<sub>l</sub> = &beta; (d<sub>l</sub>/(APD * P<sub>l</sub>))
 * </em>
 * gives:
 * 
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; &beta;<sup>*</sup> S I + &gamma;R  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)&beta;<sup>*</sup> S I &minus; &sigma;I <sup>R</sup>  &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x &beta;<sup>*</sup> S I  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 *   <li><em>&Delta;R=   &sigma;I<sup>R</sup> &minus; &gamma;R &minus; &mu;R</em> </li>
 * </ul>
 * TSF
 * <ul>
 * <li><em>TSF<sub>l</sub> = ((S+I+R)/Area<sub>l</sub>) / (P/Area * (S+I+R))</em></li>
 * <li><em>TSF<sub>l</sub> = (1/Area<sub>l</sub>) / (P/Area )</em></li>
 * <li><em>TSF<sub>l</sub> = Area / (P *Area<sub>l</sub> )</em></li>
 * <li><em>TSF<sub>l</sub> = (1 / P)* (Area/Area<sub>l</sub> )</em></li>
 * </ul>
 * <h3>Neighboring Infectious Populations</h3>
 * </p>
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; &beta;<sup>*</sup> S (I + I<sub>neighbor</sub>() ) + &gamma;R  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)&beta;<sup>*</sup> S (I + I<sub>neighbor</sub>() ) &minus; &sigma;I <sup>R</sup>  &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x &beta;<sup>*</sup> S (I + I<sub>neighbor</sub>() )  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 * <li><em>&Delta;R=   &sigma;I<sup>R</sup> &minus; &gamma;R &minus; &mu;R</em> </li>
 * </ul>
 * 
 * Specific statistics on the total number of births, deaths and deaths due to
 * the disease can be computed by adding the appropriate terms of the equations
 * above.
 * <ul>
 * <li><em>B= &mu; (S + I + R)</em>, is the number of <em>Births</em> </li>
 * <li><em>D = &mu; S + (&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu;I<sup>R</sup> + &mu;R</em>,is
 * the total number of <em>Deaths</em></li>
 * <li><em>DD= &mu;<sub>i</sub> I<sup>F</sup></em>, is the number of
 * <em>Disease Deaths</em> </li>
 * </ul>
 * @see SI
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model abstract="true"
 */
public interface SIR extends SI {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard disease model type URI.
	 */
	String URI_TYPE_STANDARD_SIR_DISEASE_MODEL_SEGMENT = URI_TYPE_STANDARD_DISEASEMODEL_SEGMENT
			+ "/sir";

	/**
	 * The Type URI for the standard SIR disease model
	 */
	URI URI_TYPE_STANDARD_SIR_DISEASE_MODEL = STEMURI
			.createTypeURI(URI_TYPE_STANDARD_SIR_DISEASE_MODEL_SEGMENT);

	/**
	 * This coefficient determines the number of population members that lose
	 * their immunity to a disease and become Susceptible to the disease per
	 * population member in the <em>Recovered</em> state. A value of zero
	 * (0.0), the default, means the population members never lose their
	 * immunity. This is <em>&gamma;</em>.
	 * 
	 * @return the proportion of <em>Recovered</em> population members that
	 *         lose their immunity per time period.
	 * @model default="0.0"
	 */
	double getImmunityLossRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SIR#getImmunityLossRate <em>Immunity Loss Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Immunity Loss Rate</em>' attribute.
	 * @see #getImmunityLossRate()
	 * @generated
	 */
	void setImmunityLossRate(double value);

	/**
	 * Compute the immunity rate adjusted for a time delta potentially different
	 * from the time period specified for the rate.
	 * 
	 * @param timeDelta
	 *            the time period (milliseconds) to which the rate is to be
	 *            adjusted.
	 * @return the adjusted rate
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double getAdjustedImmunityLossRate(final long timeDelta);

} // SIR
