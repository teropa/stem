/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.populationmodels.standard.impl;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.definitions.labels.EarthScienceLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.definitions.labels.PopulationLabelValue;
import org.eclipse.stem.populationmodels.standard.StandardPackage;
import org.eclipse.stem.populationmodels.standard.YetiPopulationInitializer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Yeti Population Initializer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class YetiPopulationInitializerImpl extends EarthSciencePopulationInitializerImpl implements YetiPopulationInitializer {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public YetiPopulationInitializerImpl() {
		super();
	}

	@Override
	protected void initializeLabel(PopulationLabel lab, STEMTime time, boolean zeroValue) {
		 PopulationLabelValue plv = lab.getCurrentPopulationValue();
		 if(zeroValue)  plv.setCount(0.0);
		 else {
			 // Get the elevation 
			 Node n = lab.getNode();
			 double elevation = -1;
			 for(NodeLabel nl:n.getLabels()) {
				 if(nl instanceof EarthScienceLabel && ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getDataType().equals("elevation")) {
					 elevation = ((EarthScienceLabel)nl).getCurrentEarthScienceValue().getData().get(0).doubleValue();
					 break;
				 }
			 }
			if(elevation == -1) 
				// no elevation data, so no yeti 
				plv.setCount(0.0);
			else {
				// There's one more yeti for each meter of elevation
				plv.setCount(elevation);
			}
		 }	 
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.YETI_POPULATION_INITIALIZER;
	}

} //YetiPopulationInitializerImpl
