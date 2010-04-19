/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#getXSize <em>XSize</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#getYSize <em>YSize</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNearestNeighbors <em>Use Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isPeriodicBoundaries <em>Periodic Boundaries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getLatticeGraphGenerator()
 * @model abstract="true"
 * @generated
 */
public interface LatticeGraphGenerator extends GraphGenerator {
	/**
	 * Returns the value of the '<em><b>XSize</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSize</em>' attribute.
	 * @see #setXSize(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getLatticeGraphGenerator_XSize()
	 * @model default="10"
	 * @generated
	 */
	int getXSize();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#getXSize <em>XSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XSize</em>' attribute.
	 * @see #getXSize()
	 * @generated
	 */
	void setXSize(int value);

	/**
	 * Returns the value of the '<em><b>YSize</b></em>' attribute.
	 * The default value is <code>"10"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YSize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YSize</em>' attribute.
	 * @see #setYSize(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getLatticeGraphGenerator_YSize()
	 * @model default="10"
	 * @generated
	 */
	int getYSize();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#getYSize <em>YSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YSize</em>' attribute.
	 * @see #getYSize()
	 * @generated
	 */
	void setYSize(int value);

	/**
	 * Returns the value of the '<em><b>Use Nearest Neighbors</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Nearest Neighbors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Nearest Neighbors</em>' attribute.
	 * @see #setUseNearestNeighbors(boolean)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getLatticeGraphGenerator_UseNearestNeighbors()
	 * @model default="true"
	 * @generated
	 */
	boolean isUseNearestNeighbors();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNearestNeighbors <em>Use Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Nearest Neighbors</em>' attribute.
	 * @see #isUseNearestNeighbors()
	 * @generated
	 */
	void setUseNearestNeighbors(boolean value);

	/**
	 * Returns the value of the '<em><b>Use Next Nearest Neighbors</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Next Nearest Neighbors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Next Nearest Neighbors</em>' attribute.
	 * @see #setUseNextNearestNeighbors(boolean)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getLatticeGraphGenerator_UseNextNearestNeighbors()
	 * @model default="false"
	 * @generated
	 */
	boolean isUseNextNearestNeighbors();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Next Nearest Neighbors</em>' attribute.
	 * @see #isUseNextNearestNeighbors()
	 * @generated
	 */
	void setUseNextNearestNeighbors(boolean value);

	/**
	 * Returns the value of the '<em><b>Periodic Boundaries</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Periodic Boundaries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Periodic Boundaries</em>' attribute.
	 * @see #setPeriodicBoundaries(boolean)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getLatticeGraphGenerator_PeriodicBoundaries()
	 * @model default="false"
	 * @generated
	 */
	boolean isPeriodicBoundaries();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.LatticeGraphGenerator#isPeriodicBoundaries <em>Periodic Boundaries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Periodic Boundaries</em>' attribute.
	 * @see #isPeriodicBoundaries()
	 * @generated
	 */
	void setPeriodicBoundaries(boolean value);

} // LatticeGraphGenerator
