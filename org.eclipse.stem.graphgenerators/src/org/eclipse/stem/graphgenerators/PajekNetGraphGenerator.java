/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.graphgenerators;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pajek Net Graph Generator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getDataFile <em>Data File</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getArea <em>Area</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getZoomFactor <em>Zoom Factor</em>}</li>
 *   <li>{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getColArea <em>Col Area</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator()
 * @model
 * @generated
 */
public interface PajekNetGraphGenerator extends GraphGenerator {
	/**
	 * Returns the value of the '<em><b>Data File</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data File</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data File</em>' attribute.
	 * @see #setDataFile(String)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator_DataFile()
	 * @model default=""
	 * @generated
	 */
	String getDataFile();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getDataFile <em>Data File</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data File</em>' attribute.
	 * @see #getDataFile()
	 * @generated
	 */
	void setDataFile(String value);

	/**
	 * Returns the value of the '<em><b>Area</b></em>' attribute.
	 * The default value is <code>"100"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Area</em>' attribute.
	 * @see #setArea(double)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator_Area()
	 * @model default="100"
	 * @generated
	 */
	double getArea();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getArea <em>Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Area</em>' attribute.
	 * @see #getArea()
	 * @generated
	 */
	void setArea(double value);

	/**
	 * Returns the value of the '<em><b>Zoom Factor</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Zoom Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Zoom Factor</em>' attribute.
	 * @see #setZoomFactor(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator_ZoomFactor()
	 * @model default="1000"
	 * @generated
	 */
	int getZoomFactor();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getZoomFactor <em>Zoom Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Zoom Factor</em>' attribute.
	 * @see #getZoomFactor()
	 * @generated
	 */
	void setZoomFactor(int value);

	/**
	 * Returns the value of the '<em><b>Col Area</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Col Area</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Col Area</em>' attribute.
	 * @see #setColArea(int)
	 * @see org.eclipse.stem.graphgenerators.GraphgeneratorsPackage#getPajekNetGraphGenerator_ColArea()
	 * @model
	 * @generated
	 */
	int getColArea();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.graphgenerators.PajekNetGraphGenerator#getColArea <em>Col Area</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Col Area</em>' attribute.
	 * @see #getColArea()
	 * @generated
	 */
	void setColArea(int value);

} // PajekNetGraphGenerator
