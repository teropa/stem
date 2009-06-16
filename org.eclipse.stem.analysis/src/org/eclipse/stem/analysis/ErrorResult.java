/**
 * <copyright>
 * </copyright>
 *
 * $Id: ErrorResult.java,v 1.1 2009/03/25 00:50:28 sedlund Exp $
 */
package org.eclipse.stem.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.analysis.ErrorResult#getErrorByTimeStep <em>Error By Time Step</em>}</li>
 *   <li>{@link org.eclipse.stem.analysis.ErrorResult#getError <em>Error</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.analysis.AnalysisPackage#getErrorResult()
 * @model
 * @generated
 */
public interface ErrorResult extends EObject {

	/**
	 * Returns the value of the '<em><b>Error By Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error By Time Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error By Time Step</em>' attribute.
	 * @see #setErrorByTimeStep(EList)
	 * @see org.eclipse.stem.analysis.AnalysisPackage#getErrorResult_ErrorByTimeStep()
	 * @model many="false" transient="true"
	 * @generated
	 */
	EList<Double> getErrorByTimeStep();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.analysis.ErrorResult#getErrorByTimeStep <em>Error By Time Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error By Time Step</em>' attribute.
	 * @see #getErrorByTimeStep()
	 * @generated
	 */
	void setErrorByTimeStep(EList<Double> value);

	/**
	 * Returns the value of the '<em><b>Error</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Error</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Error</em>' attribute.
	 * @see #setError(double)
	 * @see org.eclipse.stem.analysis.AnalysisPackage#getErrorResult_Error()
	 * @model transient="true"
	 * @generated
	 */
	double getError();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.analysis.ErrorResult#getError <em>Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Error</em>' attribute.
	 * @see #getError()
	 * @generated
	 */
	void setError(double value);
} // ErrorResult
