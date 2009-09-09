/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package automaticexperiment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see automaticexperiment.AutomaticexperimentPackage
 * @generated
 */
public interface AutomaticexperimentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AutomaticexperimentFactory eINSTANCE = automaticexperiment.impl.AutomaticexperimentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Automatic Experiment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Automatic Experiment</em>'.
	 * @generated
	 */
	AutomaticExperiment createAutomaticExperiment();

	/**
	 * Returns a new object of class '<em>Modifiable Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Modifiable Parameter</em>'.
	 * @generated
	 */
	ModifiableParameter createModifiableParameter();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AutomaticexperimentPackage getAutomaticexperimentPackage();

} //AutomaticexperimentFactory
