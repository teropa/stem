/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.core.graphgenerator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Lattice Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getXSize <em>XSize</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getYSize <em>YSize</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getUseNearestNeighbors <em>Use Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}</li>
 *   <li>{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isPeriodicBoundaries <em>Periodic Boundaries</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage#getLatticeGraphGenerator()
 * @model abstract="true"
 * @generated
 */
public interface LatticeGraphGenerator extends GraphGenerator {
	/**
	 * Returns the value of the '<em><b>XSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>XSize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>XSize</em>' attribute.
	 * @see #setXSize(int)
	 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage#getLatticeGraphGenerator_XSize()
	 * @model
	 * @generated
	 */
	int getXSize();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getXSize <em>XSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>XSize</em>' attribute.
	 * @see #getXSize()
	 * @generated
	 */
	void setXSize(int value);

	/**
	 * Returns the value of the '<em><b>YSize</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>YSize</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>YSize</em>' attribute.
	 * @see #setYSize(int)
	 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage#getLatticeGraphGenerator_YSize()
	 * @model
	 * @generated
	 */
	int getYSize();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getYSize <em>YSize</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>YSize</em>' attribute.
	 * @see #getYSize()
	 * @generated
	 */
	void setYSize(int value);

	/**
	 * Returns the value of the '<em><b>Use Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Nearest Neighbors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Nearest Neighbors</em>' attribute.
	 * @see #setUseNearestNeighbors(Boolean)
	 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage#getLatticeGraphGenerator_UseNearestNeighbors()
	 * @model
	 * @generated
	 */
	Boolean getUseNearestNeighbors();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#getUseNearestNeighbors <em>Use Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Nearest Neighbors</em>' attribute.
	 * @see #getUseNearestNeighbors()
	 * @generated
	 */
	void setUseNearestNeighbors(Boolean value);

	/**
	 * Returns the value of the '<em><b>Use Next Nearest Neighbors</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Next Nearest Neighbors</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Next Nearest Neighbors</em>' attribute.
	 * @see #setUseNextNearestNeighbors(boolean)
	 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage#getLatticeGraphGenerator_UseNextNearestNeighbors()
	 * @model
	 * @generated
	 */
	boolean isUseNextNearestNeighbors();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isUseNextNearestNeighbors <em>Use Next Nearest Neighbors</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Next Nearest Neighbors</em>' attribute.
	 * @see #isUseNextNearestNeighbors()
	 * @generated
	 */
	void setUseNextNearestNeighbors(boolean value);

	/**
	 * Returns the value of the '<em><b>Periodic Boundaries</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Periodic Boundaries</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Periodic Boundaries</em>' attribute.
	 * @see #setPeriodicBoundaries(boolean)
	 * @see org.eclipse.stem.core.graphgenerator.GraphgeneratorPackage#getLatticeGraphGenerator_PeriodicBoundaries()
	 * @model
	 * @generated
	 */
	boolean isPeriodicBoundaries();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.core.graphgenerator.LatticeGraphGenerator#isPeriodicBoundaries <em>Periodic Boundaries</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Periodic Boundaries</em>' attribute.
	 * @see #isPeriodicBoundaries()
	 * @generated
	 */
	void setPeriodicBoundaries(boolean value);

} // LatticeGraphGenerator
