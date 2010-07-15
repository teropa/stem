/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plate Carree Globe Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getAngularStep <em>Angular Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPlateCarreeGlobeGraphGenerator()
 * @model
 * @generated
 */
public interface PlateCarreeGlobeGraphGenerator extends LatticeGraphGenerator {
	/**
	 * Returns the value of the '<em><b>Angular Step</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Angular Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Angular Step</em>' attribute.
	 * @see #setAngularStep(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPlateCarreeGlobeGraphGenerator_AngularStep()
	 * @model default="10"
	 * @generated
	 */
	int getAngularStep();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PlateCarreeGlobeGraphGenerator#getAngularStep <em>Angular Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Angular Step</em>' attribute.
	 * @see #getAngularStep()
	 * @generated
	 */
	void setAngularStep(int value);

} // PlateCarreeGlobeGraphGenerator
