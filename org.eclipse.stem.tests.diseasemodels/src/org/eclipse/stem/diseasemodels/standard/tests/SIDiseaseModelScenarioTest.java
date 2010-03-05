// SIDiseaseModelScenarioTest.java
package org.eclipse.stem.diseasemodels.standard.tests;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.diseasemodels.standard.SI;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;

/**
 * This class is a JUnit test case for SI Disease Model Scenarios
 */
public abstract class SIDiseaseModelScenarioTest extends
		StandardDiseaseModelScenarioTest {

	/**
	 * The row index of the region to be infected.
	 */
	public static final int INFECTION_ROW_INDEX = 0;

	/**
	 * The column index of the region to e infected.
	 */
	public static final int INFECTION_COLUMN_INDEX = 0;

	/**
	 * The number of population members to infect.
	 */
	public static final int NUMBER_TO_INFECT = 1;

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.tests.DiseaseModelScenarioTest#getScenarioDecorators(Model)
	 */
	@Override
	public Collection<Decorator> getScenarioDecorators(final Model model) {
		return createInfectors(model);
	} // getScenarioDecorators

	/**
	 * Create an infector for each disease model in a model for the single node [{@link #INFECTION_ROW_INDEX}][{@link #INFECTION_COLUMN_INDEX}]
	 * 
	 * @param model
	 *            the model with the disease models
	 * @return a collection of the infectors
	 */
	public static Collection<Decorator> createInfectors(final Model model) {
		List<Decorator> retValue = new ArrayList<Decorator>();

		// Create an infector for each disease model in the model
		for (Iterator nodeDecoratorIter = model.getNodeDecorators().iterator(); nodeDecoratorIter
				.hasNext();) {
			final NodeDecorator nodeDecorator = (NodeDecorator) nodeDecoratorIter
					.next();
			// Is it a disease model?
			if (nodeDecorator instanceof SI) {
				// Yes
				final SI standardDiseaseModel = (SI) nodeDecorator;
				final URI targetURI = DiseaseModelTestUtil.createRegionNodeURI(
						INFECTION_ROW_INDEX, INFECTION_COLUMN_INDEX);

				final SIInfector infector = (SIInfector) standardDiseaseModel
						.createInfector();
				infector.getDublinCore().setTitle("Infector");
				infector.setTargetURI(targetURI);
				infector.setInfectiousCount(NUMBER_TO_INFECT);
				infector.setInfectPercentage(false);
				retValue.add(infector);
			} // if a standard disease
		} // for each node decorator

		return retValue;
	} // createInfectors

	/**
	 * @see org.eclipse.stem.diseasemodels.standard.tests.DiseaseModelScenarioTest#compareLabelValues(org.eclipse.stem.core.graph.LabelValue,
	 *      org.eclipse.stem.core.graph.LabelValue)
	 */
	@Override
	protected boolean compareLabelValues(LabelValue lableValue1,
			LabelValue lableValue2) {
		boolean retValue = super.compareLabelValues(lableValue1, lableValue2);
		final SILabelValue siLV1 = (SILabelValue) lableValue1;
		final SILabelValue siLV2 = (SILabelValue) lableValue2;

		retValue = retValue
				&& DiseaseModelTestUtil.closeEnough(siLV1.getS(), siLV2.getS());
		retValue = retValue
				&& DiseaseModelTestUtil.closeEnough(siLV1.getI(), siLV2.getI());
		return retValue;
	} // compareLabelValues

} // SIDiseaseModelScenarioTest
