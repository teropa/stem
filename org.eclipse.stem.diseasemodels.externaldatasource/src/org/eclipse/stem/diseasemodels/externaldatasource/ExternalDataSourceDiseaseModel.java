// ExternalDataSourceDiseaseModel.java
package org.eclipse.stem.diseasemodels.externaldatasource;

/*******************************************************************************
 * Copyright (c) 2007, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/


import java.io.File;

import org.eclipse.core.runtime.IPath;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.diseasemodels.Activator;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;

/**
 * This interface is an EMF Model.
 * 
 * @model
 */
public interface ExternalDataSourceDiseaseModel extends DiseaseModel, IntegrationDecorator {


	/**
     * default type of data to input
     */
	public static final String IMPORT_TYPE_SI = "SI";
	/**
     * default type of data to input
     */
	public static final String IMPORT_TYPE_SIR = "SIR";
	/**
     * default type of data to input
     */
	public static final String IMPORT_TYPE_SEIR = "SEIR";
	
	/**
	 * This is the Default ROOT folder for Import files.
	 * The User can change this but by default, and for testing,
	 * data will be in sub-folders of the disease model plug-in runtime preferences
	 */
	public static final IPath PATH = Activator.getDefault().getStateLocation();

	/**
	 * path separator
	 */
	public static final String sep = File.separator;
	
	/**
	 * This is the Default folder for Import files.
	 * The User can change this but by default, and for testing,
	 * data will be in sub-folders of the disease model plug-in runtime preferences
	 */
	public static final String PLAYBACK_SUBDIR = sep+"csv"+sep+"Import";
	
	/**
	 * This is the Default directory for Import files.
	 * The User can change this but by default, and for testing,
	 * data will be in sub-folders of the disease model plug-in runtime preferences
	 */	
	public static final String DEFAULT_DIR = PATH.toOSString() + PLAYBACK_SUBDIR+sep;
	
	/**
	 * Returns the value of the '<em><b>Data Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Path</em>' attribute.
	 * @see #setDataPath(String)
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourcePackage#getExternalDataSourceDiseaseModel_DataPath()
	 * @model
	 * @generated
	 */
	String getDataPath();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel#getDataPath <em>Data Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Path</em>' attribute.
	 * @see #getDataPath()
	 * @generated
	 */
	void setDataPath(String value);

	/**
	 * Returns the value of the '<em><b>Disease Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disease Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disease Type</em>' attribute.
	 * @see #setDiseaseType(String)
	 * @see org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourcePackage#getExternalDataSourceDiseaseModel_DiseaseType()
	 * @model
	 * @generated
	 */
	String getDiseaseType();

	/**
	 * Sets the value of the '{@link org.eclipse.stem.diseasemodels.externaldatasource.ExternalDataSourceDiseaseModel#getDiseaseType <em>Disease Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disease Type</em>' attribute.
	 * @see #getDiseaseType()
	 * @generated
	 */
	void setDiseaseType(String value);	

	
	
	
	
} // ExternalDataSourceDiseaseModel
