/**
 * <copyright>
 * </copyright>
 *
 * $Id: AnalysisFactory.java,v 1.1 2009/03/25 00:50:28 sedlund Exp $
 */
package org.eclipse.stem.analysis;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.analysis.AnalysisPackage
 * @generated
 */
public interface AnalysisFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalysisFactory eINSTANCE = org.eclipse.stem.analysis.impl.AnalysisFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Error Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Function</em>'.
	 * @generated
	 */
	ErrorFunction createErrorFunction();

	/**
	 * Returns a new object of class '<em>Threshold Error Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Threshold Error Function</em>'.
	 * @generated
	 */
	ThresholdErrorFunction createThresholdErrorFunction();

	/**
	 * Returns a new object of class '<em>Reference Scenario Data Map</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reference Scenario Data Map</em>'.
	 * @generated
	 */
	ReferenceScenarioDataMap createReferenceScenarioDataMap();

	/**
	 * Returns a new object of class '<em>Simple Error Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Error Function</em>'.
	 * @generated
	 */
	SimpleErrorFunction createSimpleErrorFunction();

	/**
	 * Returns a new object of class '<em>Error Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Error Result</em>'.
	 * @generated
	 */
	ErrorResult createErrorResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnalysisPackage getAnalysisPackage();

} //AnalysisFactory
