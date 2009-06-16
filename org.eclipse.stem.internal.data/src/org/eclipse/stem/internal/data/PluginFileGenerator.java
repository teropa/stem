// PluginFileGenerator.java
package org.eclipse.stem.internal.data;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.internal.data.specifications.IdentifiableSpecification;

/**
 * This class is responsible for generating the plug.xml and plugin.properties
 * files for the org.eclipse.stem.geography plugin.
 */
abstract public class PluginFileGenerator {

	/**
	 * The name of the plugin.xml file that is generated for the geography
	 * plugin
	 */

	public static final String PLUGIN_XML_FILE_NAME = "plugin.xml";

	/**
	 * The name of the plugin.properties file that is generated for the
	 * geography plugin.
	 */
	public static final String PLUGIN_PROPERTIES_FILE_NAME = "plugin.properties";

	/**
	 * The ID of the graph extension point.
	 */
	public static final String GRAPH_EXTENSION_POINT_ID = Constants.ID_ROOT
			+ ".core.graph";

	/**
	 * The ID of the model extension point.
	 */
	public static final String MODEL_EXTENSION_POINT_ID = Constants.ID_ROOT
			+ ".core.model";

	/**
	 * The ID of the scenario extension point.
	 */
	public static final String SCENARIO_EXTENSION_POINT_ID = Constants.ID_ROOT
			+ ".core.scenario";

	/**
	 * The id of the Graph category
	 */
	public static final String ID_GRAPH_CATEGORY = Constants.ID_ROOT
			+ ".core.graph";
	/**
	 * The id of the Model category
	 */
	public static final String ID_MODEL_CATEGORY = Constants.ID_ROOT
			+ ".core.model";

	/**
	 * The identifier for the Scenario category.
	 */
	public static final String ID_SCENARIO_CATEGORY = Constants.ID_ROOT
			+ ".core.scenario";

	/**
	 * 
	 */
	public static final String UI_STEM_CATEGORY_NAME = "_UI_Standard_Scenario_category";

	/**
	 * This is the name of the Standard category
	 */
	public static final String STEM_CATEGORY_NAME = "STEM";

	/**
	 * This is the name of the "Provider" that is put into the plugin.properties
	 * file.
	 */
	public static final String PROVIDER_NAME = "Eclipse.org";

	/**
	 * @param pluginWriter
	 */
	protected void outputPluginHeader(final PrintWriter pluginWriter) {
		pluginWriter.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		pluginWriter.println("<?eclipse version=\"3.3\"?>");
		pluginWriter.println("<plugin>");
		pluginWriter.println("<!-- Generated Content.  Do not Edit. -->");
		pluginWriter.println("<!-- Generated: " + createGeneratedDateComment()
				+ " -->");
	} // outputPluginHeader

	/**
	 * @param pluginWriter
	 */
	protected void outputPluginFooter(final PrintWriter pluginWriter) {
		pluginWriter.println("</plugin>");
	} // outputPluginFooter

	/**
	 * @param identifiableSpecification
	 * @param isoCatagoryID
	 * @param pluginWriter
	 */
	protected void outputDublinCore(
			final IdentifiableSpecification identifiableSpecification,
			final String isoCatagoryID, final PrintWriter pluginWriter) {

		final DublinCore dc = identifiableSpecification.getDublinCore();
		final StringBuilder sb = new StringBuilder();

		sb.append("<dublin_core ");
		sb.append("category_id=\"");
		sb.append(isoCatagoryID);
		sb.append("\" ");
		sb.append(dc.toString());
		sb.append("/>");
		pluginWriter.println(sb.toString());

	} // outputDublinCore

	/**
	 * @return
	 */
	protected String createGeneratedDateComment() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(Calendar
				.getInstance().getTime());
	} // createGeneratedDateComment
} // PluginFileGenerator
