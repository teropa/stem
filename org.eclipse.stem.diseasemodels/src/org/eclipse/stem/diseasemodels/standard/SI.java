// SI.java
package org.eclipse.stem.diseasemodels.standard;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.stem.core.graph.Node;

/**
 * A {@link DiseaseModel} with two states <em>Susceptible</em> and
 * <em>Infectious</em> (SI).
 * 
 * <p>
 * The basic <em>SI</em> (Susceptible, Infectious) disease model assumes a
 * uniform population at a single location and that the population members are
 * well "mixed", meaning that they are equally likely to meet and infect each
 * other. This model, for a normalized population, is defined by the two
 * equations below:
 * <ul>
 * <li><em>&Delta;s = &mu;  &minus; &beta;s i + &sigma;i &minus; &mu;s</em>
 * </li>
 * <li><em>&Delta;i = &beta;s i &minus; &sigma;i  &minus;  	i</em> </li>
 * </ul>
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
 * <em>Recover</em>. In this model <em>recovery</em> means becoming
 * <em>Susceptible</em> again.</li>
 * </ul>
 * </p>
 * <p>
 * In the first equation, the <em>Susceptible</em> population increases when
 * new members are born. This value is the birth rate &mu; multiplied by the
 * total population, which, because the values are normalized, is 1. It also
 * increases due to <em>Infectious</em> population members recovering. The
 * <em>Susceptible</em> population decreases by members who die. That value is
 * &mu;, the mortality rate, multiplied by the <em>Susceptible</em>
 * population, <em>s</em>. The <em>Susceptible</em> population also
 * decreases by having members become <em>infected</em>. The product of
 * <em>&beta;</em> and <em>i</em> gives the normalized number of
 * <em>Susceptible</em> population members that would become infected for each
 * <em>Infectious</em> population member assuming all population members are
 * in the <em>Susceptible</em> state. Multiplying that by <em>s</em>, the
 * fraction that actually are <em>Susceptible</em>, gives the normalized
 * amount that become <em>Infectious</em>.
 * </p>
 * <p>
 * In the second equation, the <em>Infectious</em> population increases by the
 * number of <em>Susceptible</em> population members that become
 * <em>Infectious</em> (the first term). It also decreases by the proportion
 * that <em>Recover</em> from the disease (middle term) and by the proportion
 * that die (last term).
 * </p>
 * <p>
 * Frequently, being infected by a disease will increase the likelihood that a
 * population member will die. The model above needs to be enhanced to include
 * the likelihood of a fatal infection and a potentially different rate at which
 * infected members die.
 * </p>
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
 * those that will eventually recover at rate <em>&sigma;</em>, and those
 * that will eventually die at rate <em>&mu;<sub>i</sub></em> (of course,
 * members in both states still die at the background rate <em>&mu;</em>).
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
 * <li><em>&Delta;s = &mu;  &minus; &beta;s i + &sigma;i <sup>R</sup>  &minus; &mu; s</em>
 * </li>
 * <li><em>&Delta;i <sup>R</sup> = (1-x)&beta;s i &minus; &sigma;i <sup>R</sup>  &minus; &mu;i <sup>R</sup></em>
 * </li>
 * <li><em>&Delta;i <sup>F</sup> = x &beta;s i &minus; (&mu; + &mu;<sub>i</sub>) i <sup>F</sup></em>
 * </li>
 * </ul>
 * </p>
 * <h3>Spatial Adaptation</h3>
 * <p>
 * The "SI" disease model computations in STEM enhance these equations by
 * adapting them to populations that are spatially distributed. This relaxes the
 * assumption that the populations are at a single location and opens up the
 * possibility that different locations could have different areas and numbers
 * of population members (i.e., different population densities). To accommodate
 * this situation STEM maintains separate disease state values for each location
 * and uses unnormalized versions of the equations presented above. We develop
 * those below.
 * <p>
 * To account for population differences at different locations, we define a new
 * parameter <em>P<sub>l</sub></em> which is the number of population
 * members at location <em>l</em> (Note: <em>P<sub>l</sub> = S + I</em>).
 * We also need to account for variability in the disease transmission
 * (infection) rate, &beta;, due to potentially different population densities.
 * This modification is based upon the assumption that locations with greater
 * population densities will have a higher effective transmission rates than
 * locations with lower densities (i.e., one value can't be used for all
 * locations). Thus, we need to replace the <em>&beta;</em> in the non-spatial
 * versions of the equations with a <em>&beta; <sub>l</sub></em> that is
 * specific to the location.
 * </p>
 * Making the substitution for <em>&beta;</em> and multiply both sides of the
 * equations by <em>P<sub>l</sub></em>, we obtain:
 * </p>
 * 
 * <ul>
 * <li><em>&Delta;s P<sub>l</sub>= &mu;P<sub>l</sub>  &minus; &beta;<sub>l</sub> s i P<sub>l</sub> + &sigma; i <sup>R</sup>P<sub>l</sub>  &minus; &mu; s P<sub>l</sub></em>
 * </li>
 * <li><em>&Delta;i <sup>R</sup> P<sub>l</sub> = (1-x)&beta;<sub>l</sub> s i P<sub>l</sub> &minus; &sigma; i <sup>R</sup> P<sub>l</sub> &minus; &mu;i <sup>R</sup> P<sub>l</sub></em>
 * </li>
 * <li><em>&Delta;i <sup>F</sup> P<sub>l</sub> = x &beta;<sub>l</sub>s i P<sub>l</sub> &minus; (&mu; + &mu;<sub>i</sub>) i <sup>F</sup> P<sub>l</sub></em>
 * </li>
 * </ul>
 * 
 * We choose the value for <em>&beta;<sub>l</sub></em> to be original
 * <em>&beta;</em> scaled by the ratio between the population density at the
 * location and the average population density of all locations.
 * <ul>
 * <li> <em> &beta;<sub>l</sub> = &beta; d<sub>l</sub>/APD</em></li>
 * </ul>
 * Where <em>d<sub>l</sub></em> is the population density at location
 * <em>l</em>, and <em>APD</em> is the average population density for all
 * locations.
 * 
 * 
 * 
 * 
 * <p>
 * Let <em>S<sub>l</sub> = s P<sub>l</sub></em> be the number of
 * <em>Susceptible</em> population members at location <em>l</em>. , let
 * <em>I<sub>l</sub> = i P<sub>l</sub></em> be the number of population
 * members at location <em>l</em> that are <em>Infectious</em> (both states
 * combined). For readability, we drop the <em>l</em> subscript and
 * substitute.
 * </p>
 * 
 * 
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; &beta;<sub>l</sub> S i + &sigma;I <sup>R</sup>  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)&beta;<sub>l</sub> S i &minus; &sigma;I <sup>R</sup> &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x &beta;<sub>l</sub>S i  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 * </ul>
 * 
 * Continuing with <em> i = I/P<sub>l</sub></em>, we have:
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; (&beta;<sub>l</sub>/P<sub>l</sub>) S I + &sigma;I <sup>R</sup>  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)(&beta;<sub>l</sub>/P<sub>l</sub>) S I &minus; &sigma;I <sup>R</sup>  &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x (&beta;<sub>l</sub>/P<sub>l</sub>) S I  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 * </ul>
 * 
 * Letting
 * <em>&beta;<sup>*</sup> = &beta;<sub>l</sub>/P<sub>l</sub> = &beta; (d<sub>l</sub>/(APD * P<sub>l</sub>))
 * </em>
 * gives:
 * 
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; &beta;<sup>*</sup> S I + &sigma;I <sup>R</sup>  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)&beta;<sup>*</sup> S I &minus; &sigma;I <sup>R</sup>  &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x &beta;<sup>*</sup> S I  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 * </ul>
 * 
 * <p>
 * Computing <em>&beta;<sup>*</sup></em> is straightforward. Let
 * <em>TSF<sub>l</sub> = (d<sub>l</sub>/(APD * P<sub>l</sub>)</em> be
 * the <em>transmission scale factor</em> at location <em>l</em>.
 * </p>
 * <p>
 * Thus
 * <ul>
 * <li><em>&beta;<sup>*</sup> = &beta; TSF<sub>l</sub></em></li>
 * </ul>
 * </p>
 * <p>
 * Substituting <em>P<sub>l</sub> = S + I</em>, <em>APD = P/Area</em> and
 * <em>d<sub>l</sub> = (S+I)/Area<sub>l</sub></em>, where <em>P</em> is
 * the total population for all locations, <em>Area<sub>l</sub></em> is the
 * area of location <em>l</em>, and <em>Area</em> is the total area of all
 * locations, we get:
 * <ul>
 * <li><em>TSF<sub>l</sub> = ((S+I)/Area<sub>l</sub>) / (P/Area *    (S+I))</em></li>
 * <li><em>TSF<sub>l</sub> = (1/Area<sub>l</sub>) / (P/Area )</em></li>
 * <li><em>TSF<sub>l</sub> = Area / (P *Area<sub>l</sub> )</em></li>
 * <li><em>TSF<sub>l</sub> = (1 / P)* (Area/Area<sub>l</sub> )</em></li>
 * </ul>
 * So the <em>TSF<sub>l</sub></em> is the product of the reciprocal of the
 * total population of all locations and the constant ratio between the area of
 * the location and the total area of all locations. The former can be computed
 * by accumulating the population of all locations as they are generated and the
 * later ratio can be computed once at the start of the simulation.
 * </p>
 * 
 * <h3>Neighboring Infectious Populations</h3>
 * <p>
 * The extension of the non-spatial model into a spatial one in STEM also needs
 * to account for infectious population members that reside in a location's
 * "neighbors". Consider a location with no infections that is physically
 * adjacent to several locations that have large infectious populations. This
 * physical adjacency would naturally lead to population-to-population contact
 * and eventually to disease transmission. We need to further extend the
 * equations we are here to incorporate this aspect of a spatially distributed
 * population.
 * </p>
 * <p>
 * In STEM, a location has another location as a neighbor <em>Relationship</em>
 * that links it to that location. If the <em>Relationship</em> represents the
 * exchange of of population members (i.e., some kind of
 * {@link TransportRelationshipLabel transportation relationship} like pathways,
 * roads or air travel) then it would be possible for <em>Infectious</em>
 * population members from a neighbor to "visit" a location. We need to account
 * for this potential by increasing the "effective" <em>Infectious</em>
 * population at a location when doing our computations. Each Relationship has a
 * rate at which population members travel from one location to another. It is
 * assumed that the visitors would have the same level of "infectious contact"
 * as an infectious member of the population at the current location (i.e., that
 * they could could be counted as an infectious member of the population at the
 * current location).
 * </p>
 * <p>
 * The equations become:
 * </p>
 * <ul>
 * <li><em>&Delta;S = &mu;P<sub>l</sub>  &minus; &beta;<sup>*</sup> S (I + I<sub>neighbor</sub>() ) + &sigma;I <sup>R</sup>  &minus; &mu; S</em>
 * </li>
 * <li><em>&Delta;I <sup>R</sup> = (1-x)&beta;<sup>*</sup> S (I + I<sub>neighbor</sub>() ) &minus; &sigma;I <sup>R</sup>  &minus; &mu;I <sup>R</sup> </em>
 * </li>
 * <li><em>&Delta;I <sup>F</sup> = x &beta;<sup>*</sup> S (I + I<sub>neighbor</sub>() )  &minus; (&mu; + &mu;<sub>i</sub>) I <sup>F</sup> </em>
 * </li>
 * </ul>
 * </p>
 * <p>
 * Where
 * <ul>
 * <li>
 * <em>I<sub>neighbor</sub>() = &sum; <sub>m</sub>   I <sub>m</sub>transport(m)/P<sub>m</sub></em>
 * is the number of <em>Infectious</em> visitors from neighbor <em>m</em>.</li>
 * <li>transport(m) = the the number of population members are transported from
 * neighbor <em>m</em></li>
 * <li>P<sub>m</sub> is the number of population members at neighbor
 * <em>m</em></li>
 * <li>I<sub>m</sub> is the number of <em>Infectious</em> population
 * members at neighbor <em>m</em></li>
 * </ul>
 * </p>
 * <p>
 * Specific statistics on the total number of births, deaths and deaths due to
 * the disease can be computed by adding the appropriate terms of the equations
 * above.
 * <ul>
 * <li><em>B= &mu; (S + I)</em>, is the number of <em>Births</em> </li>
 * <li><em>D = &mu; S + (&mu; + &mu;<sub>i</sub> )I<sup>F</sup> + &mu;I<sup>R</sup></em>,is
 * the total number of <em>Deaths</em></li>
 * <li><em>DD= &mu;<sub>i</sub> I<sup>F</sup></em>, is the number of
 * <em>Disease Deaths</em> </li>
 * </ul>
 * </p>
 * 
 * @see SIImpl#computeInfectiousMortalityRate(double, double)
 * @see SIRLabel
 * @see SIRLabel
 * @see SIRLabelValue
 * @see SEIR
 * @see SEIRLabel
 * @see SEIRLabelValue
 * 
 * @model abstract="true"
 */
public interface SI extends StandardDiseaseModel {
	/**
	 * This is the segment of the type URI that prefixes all other segments in a
	 * standard disease model type URI.
	 */
	String URI_TYPE_STANDARD_SI_DISEASE_MODEL_SEGMENT = URI_TYPE_STANDARD_DISEASEMODEL_SEGMENT
			+ "/si";

	/**
	 * This is the proportion which <em>Infectious</em> population
	 * members die per time period. This is <em>&mu;<sub>i</sub></em>.
	 * 
	 * @return the increased rate at which infected population members that die per
	 *         time period.
	 * @see DiseaseModel#getBackgroundMortalityRate()
	 * @model default="0.0"
	 */
	double getInfectiousMortalityRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SI#getInfectiousMortalityRate <em>Infectious Mortality Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infectious Mortality Rate</em>' attribute.
	 * @see #getInfectiousMortalityRate()
	 * @generated
	 */
	void setInfectiousMortalityRate(double value);

	/**
	 * Compute the infectious mortality rate adjusted for a time delta
	 * potentially different from the time period specified for the rate.
	 * 
	 * @param timeDelta
	 *            the time period (milliseconds) to which the rate is to be
	 *            adjusted.
	 * @return the adjusted rate
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double getAdjustedInfectiousMortalityRate(final long timeDelta);

	/**
	 * This is the proportion of population members that become infected/exposed
	 * per population member in the <em>Infectious</em> state, assuming the
	 * entire population is in the <em>Susceptible</em> state, per time
	 * period.
	 * <p>
	 * In the rate equation this coefficient is normalize by the ratio of the
	 * Susceptible population to the total population. The final value may also
	 * be rescaled based on variations in local population density (above or
	 * below average). This is <em>&beta;</em>.
	 * </p>
	 * 
	 * @return the number of population members that become infected per time
	 *         period
	 * @model default="0.0"
	 */
	double getTransmissionRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SI#getTransmissionRate <em>Transmission Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transmission Rate</em>' attribute.
	 * @see #getTransmissionRate()
	 * @generated
	 */
	void setTransmissionRate(double value);

	/**
	 * Compute the transmission rate adjusted for a time delta potentially
	 * different from the time period specified for the rate.
	 * 
	 * @param timeDelta
	 *            the time period (milliseconds) to which the rate is to be
	 *            adjusted.
	 * @return the adjusted rate
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double getAdjustedTransmissionRate(final long timeDelta);

	/**
	 * By default this exponent is one (1.0) and the rate of infection scales as
	 * the product of the Susceptible population and the Infectious population.
	 * In a nonlinear model (which captures saturation of the immune system for
	 * Susceptible population), the Infectious term is raise to this power (>=
	 * 1.0) This exponent should never be less than one (that would imply
	 * Susceptible population would become less susceptible as their probability
	 * of exposure increases.
	 * 
	 * @return the non-linearity coefficient
	 * @model default="1.0"
	 */
	double getNonLinearityCoefficient();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SI#getNonLinearityCoefficient <em>Non Linearity Coefficient</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Non Linearity Coefficient</em>' attribute.
	 * @see #getNonLinearityCoefficient()
	 * @generated
	 */
	void setNonLinearityCoefficient(double value);

	/**
	 * This coefficient determines the number of population members that recover
	 * from the disease per population member in the <em>Infectious</em>
	 * state. This is <em>&sigma;</em>.
	 * 
	 * @return the number of population members that recover per time period
	 * @model default="0.0"
	 */
	double getRecoveryRate();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SI#getRecoveryRate <em>Recovery Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery Rate</em>' attribute.
	 * @see #getRecoveryRate()
	 * @generated
	 */
	void setRecoveryRate(double value);

	/**
	 * Compute the recovery rate adjusted for a time delta potentially different
	 * from the time period specified for the rate.
	 * 
	 * @param timeDelta
	 *            the time period (milliseconds) to which the rate is to be
	 *            adjusted.
	 * @return the adjusted rate
	 * 
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double getAdjustedRecoveryRate(final long timeDelta);

	/**
	 * Two <code>Node</code>s that share a border exchange population members
	 * through otherwise un-modeled transportation routes. This is the proportion
	 * of the infectious population members in any adjacent <code>Node</code>
	 * to include in the computations of another <code>Node</code>.
	 * 
	 * @return the proportion of the infectious population in physically
	 *         adjacent <code>Node</code>s that contribute to the effective
	 *         infectious population at the current <code>Node</code>.
	 * @model default="0.05"
	 */
	double getPhysicallyAdjacentInfectiousProportion();
	

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SI#getPhysicallyAdjacentInfectiousProportion <em>Physically Adjacent Infectious Proportion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Physically Adjacent Infectious Proportion</em>' attribute.
	 * @see #getPhysicallyAdjacentInfectiousProportion()
	 * @generated
	 */
	void setPhysicallyAdjacentInfectiousProportion(double value);

	/**
	 * This parameter adjust the strength of mixing of people between
	 * adjacent nodes <code>Node</code>s that are connected by one or more roads.
	 * Exchange of population members by the road network can add or, or augment, mixing
	 * based on  physical adjacency based on the relative strength of these independent
	 * mixing proportions. Two <code>Node</code>s that are connected by one or more roads exchange population members
	 * by road transport. This is the the proportion exchanged PER ROAD.
	 * An road transport edge may represent multiple roads in which case the value returned
	 * is scaled (multiplied) by the number of roads encoded by that edge.
	 * This product is then the proportion of the infectious population members in any adjacent <code>Node</code>
	 * to include in the computations of another <code>Node</code>.
	 * 
	 * @return the proportion of the infectious population in physically
	 *         adjacent <code>Node</code>s that contribute to the effective
	 *         infectious population at the current <code>Node</code>.
	 * @model default="0.01"
	 */
	double getRoadNetworkInfectiousProportion();

	/**
	 * Returns the value of the '<em><b>Infectious Mortality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Infectious Mortality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Infectious Mortality</em>' attribute.
	 * @see #setInfectiousMortality(double)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getSI_InfectiousMortality()
	 * @model
	 * @generated
	 */
	double getInfectiousMortality();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.SI#getInfectiousMortality <em>Infectious Mortality</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Infectious Mortality</em>' attribute.
	 * @see #getInfectiousMortality()
	 * @generated
	 */
	void setInfectiousMortality(double value);

	/**
	 * This method replaces the onsiteInfectious value with an effectiveInfectious population
	 * size based on mixing with other sites. For example, 
	 * an implementation of this method replaces the onsiteInfectious value with an effectiveInfectious population
	 * size based on mixing with neighhboring sites. In this implementation the edges are bidirectional
	 * and have a fixed weight based on getPhysicallyAdjacentInfectiousProportion() (called in the helper method
	 * getInfectiousChangeFromMixing(). But the mixing is also weighted by the areas and populations of a site relative
	 * to the area and population of it's neighbors. Note that the value returned must be NORMALIZED by the total
	 * population because the product beta * S * Ieffective must have units of persons. Since S has units of persons
	 * the Ieffective must be dimensionless (normalized to the population). beta is the infection rate and has units
	 * of inverse time.
	 * @param node the node we are currently looking at to compute the next disease state
	 * @param diseaseLabel the label for the current disease computation
	 * @param onsiteInfectious the number of infectious people on site (at the node above)
	 * @return the number of infectious population members in <code>Node</code>s
	 *         that share a {@link CommonBorderRelationshipLabel} with this
	 *         <code>Node</code>.
	 * @model volatile="true" transient="true" changeable="false"
	 */
	double getNormalizedEffectiveInfectious(final Node node, final StandardDiseaseModelLabel diseaseLabel, final double onsiteInfectious);

} // SI
