/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.standard;

import org.eclipse.emf.common.util.EList;

import org.eclipse.stem.core.model.NodeDecorator;

import org.eclipse.stem.core.modifier.Modifiable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infector Inoculator Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.InfectorInoculatorCollection#getList <em>List</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.InfectorInoculatorCollection#getImportFolder <em>Import Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getInfectorInoculatorCollection()
 * @model
 * @generated
 */
public interface InfectorInoculatorCollection extends NodeDecorator, Modifiable {
	/**
	 * Returns the value of the '<em><b>List</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.stem.diseasemodels.standard.Infector}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' containment reference list.
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getInfectorInoculatorCollection_List()
	 * @model containment="true"
	 * @generated
	 */
	EList<Infector> getList();

	/**
	 * Returns the value of the '<em><b>Import Folder</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Folder</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Folder</em>' attribute.
	 * @see #setImportFolder(String)
	 * @see org.eclipse.stem.diseasemodels.standard.StandardPackage#getInfectorInoculatorCollection_ImportFolder()
	 * @model default=""
	 * @generated
	 */
	String getImportFolder();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.standard.InfectorInoculatorCollection#getImportFolder <em>Import Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Import Folder</em>' attribute.
	 * @see #getImportFolder()
	 * @generated
	 */
	void setImportFolder(String value);

} // InfectorInoculatorCollection
