// WorldScenarioCreator.java
package org.eclipse.stem.tests.diseasemodels.scenarios;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.stem.core.Constants;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.model.NodeDecorator;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.tests.SequentialSequencerTest;
import org.eclipse.stem.definitions.nodes.NodesPackage;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.tests.DeterministicSIDiseaseModelTest;
import org.eclipse.stem.diseasemodels.standard.tests.SIDiseaseModelScenarioTest;
import org.eclipse.stem.tests.util.CountryGraphCreator;
import org.eclipse.stem.tests.util.CountryModelCreator;
import org.eclipse.stem.tests.util.CountryDirectoryUtilities.CountryCode;

/**
 * This class creates disease model scenarios.
 */
public class WorldScenarioCreator {

	/**
	 * The name of the directory that contains "model" sub-directories
	 */
	private static final String SCENARIO_DIR = "scenarios";

	/**
	 * This is the format string for the identifier of a country graph or model
	 * file
	 */
	public static final String IDENTIFIER_FORMAT = "{0}/" + SCENARIO_DIR
			+ "/{1}/{2}";

	private static final String ROOT_OUTPUT_DIR = "temp";

	/**
	 * This is the path to the country models directory
	 */
	public static final String WORLD_SCENARIO_PATH = ROOT_OUTPUT_DIR
			+ File.separator + SCENARIO_DIR;

	private static final String SCENARIO = "Scenario";

	private static final String ID_DISEASE_TEST_PLUGIN = Constants.ID_ROOT
			+ ".diseasemodels.tests";

	/**
	 * This is the prefix of the platform URI for geography graphs and models
	 */
	public static final String DISEASE_TEST_FILE_URI_PREFIX = "platform:/plugin/"
			+ ID_DISEASE_TEST_PLUGIN + "/data";

	/**
	 * The identifier used in world model record instances. It is like a
	 * {@link CountryCode} , but for the entire world.
	 */
	// private static final String SCENARIO_ID = "SCENARIO";
	private static final String ID_SCENARIO_CATEGORY = "foo";

	/**
	 * This is the id of the extension point extended by "world" models that are
	 * plugged into STEM
	 */
	public static final String ID_SCENARIO_WORLD_CATEGORY = ID_SCENARIO_CATEGORY
			+ "." + SCENARIO.toLowerCase();

	public static void main(String[] args) {

		final WorldScenarioCreator wsc = new WorldScenarioCreator();

		final List<Model> worldModels = wsc.getWorldModels();
		final List<StandardDiseaseModel> diseaseModels = wsc.getDiseaseModels();

		final List<ScenarioRecord> worldScenarioRecords = wsc
				.createWorldDiseaseModelScenarios(worldModels, diseaseModels);
		try {
			wsc.serializeScenarioModels(worldScenarioRecords,
					WORLD_SCENARIO_PATH);

			final File worldExtensionFile = new File(WORLD_SCENARIO_PATH
					+ CountryGraphCreator.GRAPH_EXTENSION_POINT_FILE_NAME);
			final File worldModelPluginPropertiesFile = new File(
					WORLD_SCENARIO_PATH
							+ CountryGraphCreator.GRAPH_PLUGIN_PROPERTIES_POINT_FILE_NAME);

			final BufferedWriter worldModelOut = new BufferedWriter(
					new FileWriter(worldExtensionFile));

			final BufferedWriter pluginOut = new BufferedWriter(new FileWriter(
					worldModelPluginPropertiesFile));
			// Create a snippet of xml that can be included in a plugin.xml file
			// to plug into STEM the scenarios we just serialized.
			wsc.generateModelExtensionPointXML(worldScenarioRecords,
					worldModelOut, pluginOut);
		} // try
		catch (IOException e) {
			e.printStackTrace();
		}

	} // main

	/**
	 * @return a list of the disease models for which scenarios will be created.
	 */
	private List<StandardDiseaseModel> getDiseaseModels() {
		final List<StandardDiseaseModel> retValue = new ArrayList<StandardDiseaseModel>();
		retValue.add(DeterministicSIDiseaseModelTest.createFixture());
		// retValue.add(DeterministicSIRDiseaseModelTest.createFixture());
		return retValue;
	} // getDiseaseModels

	/**
	 * @return the model of the world to use for the scenarios
	 */
	private List<Model> getWorldModels() {

		final List<Model> retValue = new ArrayList<Model>();

		// This code is running "stand alone" (i.e., not within eclipse), thus
		// the default factories for the extensions are not registered as they
		// would from their extension of
		// "org.eclipse.emf.ecore.extension_parser". So we need to register them
		// here.

		// This causes the model package to be registered.
		// GraphPackage.eINSTANCE.getNsURI();
		ModelPackage.eINSTANCE.getNsURI();
		NodesPackage.eINSTANCE.getNsURI();

		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("*", new XMIResourceFactoryImpl());
		resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().put(
				"platform", new XMIResourceFactoryImpl());

		final String uriStringPrefix = "../org.eclipse.stem.geography/"
				+ "resources/data/models/world/WORLD/";

		final String[] modelFileNames = new String[] { "WORLD_0_1_2.model",
				"WORLD_0.model", "WORLD_1.model", "WORLD_2.model" };
		for (String worldModelFileName : modelFileNames) {
			final URI worldModelURI = URI.createFileURI(uriStringPrefix
					+ worldModelFileName);

			final Resource resource = resourceSet.getResource(resourceSet
					.getURIConverter().normalize(worldModelURI), true);

			try {
				resource.load(null);
				retValue.add((Model) resource.getContents().get(0));
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} // catch
			catch (NullPointerException npe) {
				System.out.println(npe.getMessage());
			} // null pointer exception
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} // for each model filename
		return retValue;
	} // getWorldModel

	/**
	 * @return a list of Scenario Records for disease models on a world model
	 */
	private List<ScenarioRecord> createWorldDiseaseModelScenarios(
			List<Model> worldModels, List<StandardDiseaseModel> diseaseModels) {
		final List<ScenarioRecord> retValue = new ArrayList<ScenarioRecord>();

		int scenarioCounter = 0;

		for (Model model : worldModels) {
			for (StandardDiseaseModel diseaseModel : diseaseModels) {

				final Scenario scenario = ScenarioFactory.eINSTANCE
						.createScenario();
				final DublinCore dc = scenario.getDublinCore();
				dc.populate();
				dc.setTitle("Scenario: " + model.getDublinCore().getTitle()
						+ diseaseModel.getDublinCore().getTitle());
				dc.setFormat(ScenarioPackage.eNS_URI);

				// Add the disease model to the model
				final Model temp = (Model)EcoreUtil.copy(model);
				temp.getNodeDecorators().add((NodeDecorator)
						EcoreUtil.copy(diseaseModel));

				scenario.setModel(temp);

				// Add the sequencer to the scenario
				scenario.setSequencer(SequentialSequencerTest.createFixture());

				// Add infector(s) for each disease model to the scenario
				Collection<Decorator> infectors = SIDiseaseModelScenarioTest
						.createInfectors(temp);
				final Node nodeToInfect = pickNodeToInfect(scenario.getModel());
				for (Decorator decorator : infectors) {
					final Infector infector = (Infector) decorator;
					// Did we find a node?
					if (nodeToInfect != null) {
						// Yes
						infector.setTargetURI(nodeToInfect.getURI());
					}

				}
				scenario.getScenarioDecorators().addAll(infectors);

				final ScenarioRecord scenarioRecord = new ScenarioRecord(
						scenario, "WORLD", scenarioCounter++);

				final String uriString = MessageFormat.format(
						IDENTIFIER_FORMAT, DISEASE_TEST_FILE_URI_PREFIX,
						"WORLD", scenarioRecord.getSerializationFileName());
				dc.setIdentifier(uriString);
				scenario.setURI(URI.createURI(uriString));

				retValue.add(scenarioRecord);
			} // for each disease model
		} // for each model

		// for (int adminLevel = 0; adminLevel < modelsByAdminLevel.size();
		// adminLevel++) {
		//
		// final Model worldModel = ModelFactory.eINSTANCE.createModel();
		// final DublinCore dc = worldModel.getDublinCore();
		// dc.populate();
		// dc.setTitle("World Model (Level " + adminLevel + ", "
		// + modelsByAdminLevel.get(adminLevel).size() + " models)");
		//
		// for (CountryModelRecord modelRecord : modelsByAdminLevel
		// .get(adminLevel)) {
		// worldModel.getModels().add(modelRecord.getModel());
		// } // foreach ModelRecord at adminLevel
		//
		// final WorldModelRecord worldModelRecord = new WorldModelRecord(
		// worldModel, WORLD_ID, adminLevel);
		// worldModel.setURI(URI.createURI(MessageFormat.format(
		// IDENTIFIER_FORMAT,
		// CountryGraphCreator.GEOGRAPHY_FILE_URI_PREFIX, WORLD_ID,
		// worldModelRecord.getSerializationFileName())));
		//
		// retValue.add(worldModelRecord);
		// } // for adminLevel

		return retValue;
	} // createWorldDiseaseModelScenarios

	/**
	 * Select a Node from the model to infect
	 * 
	 * @param model
	 * @return a Node
	 */
	private Node pickNodeToInfect(Model model) {
		// Pick the first node with population members we find
		Node retValue = null;

		// Look in the graphs
		for (Iterator graphIter = model.getGraphs().iterator(); graphIter
				.hasNext();) {
			Graph graph = (Graph) graphIter.next();
			// Any nodes in this graph?
			for (Iterator nodeIter = graph.getNodesMap().values().iterator(); nodeIter
					.hasNext();) {
				Node node = (Node) nodeIter.next();
				// got one
				return node;
			}
		}
		// if we get here we didn't find one in the graphs
		for (Iterator modelIter = model.getModels().iterator(); retValue == null
				&& modelIter.hasNext();) {
			Model submodel = (Model) modelIter.next();
			retValue = pickNodeToInfect(submodel);
		}

		return retValue;
	} // pickNodeToInfect

	/**
	 * @param worldScenarioRecords
	 * @param worldScenarioOut
	 * @param pluginOut
	 */
	private void generateModelExtensionPointXML(
			List<ScenarioRecord> worldScenarioRecords,
			BufferedWriter worldScenarioOut, BufferedWriter pluginOut) {

		// The dublin core instances of the models likely share common
		// attributes, we can avoid duplicate entries in the files we
		// generate by finding the duplicate entries and only generating a
		// single key for the generated plugins file content.
		final Map<String, String> dcValueKeyMap = new HashMap<String, String>();

		try {
			worldScenarioOut
					.write("<!-- Generated content.  Do not modify -->\n");

			worldScenarioOut.write(MessageFormat.format(
					CountryGraphCreator.XML_EXTENSION_POINT_OPEN,
					new Object[] { Constants.ID_SCENARIO_EXTENSION_POINT }));
			worldScenarioOut.write("\n");

			pluginOut
					.write("#Model NLS Keys.  Automatically generated, do not modify. "
							+ Calendar.getInstance().getTime()
							+ " "
							+ System.getProperty("user.name") + "\n");

			// World Model
			CountryGraphCreator.outputCategory(ID_SCENARIO_WORLD_CATEGORY,
					SCENARIO, CountryModelCreator.ID_MODEL_POLITICAL_CATEGORY,
					CountryModelCreator.NLS_CATEGORY_KEY_FORMAT,
					worldScenarioOut, pluginOut);

			for (ScenarioRecord worldModelRecord : worldScenarioRecords) {
				CountryGraphCreator.outputDublinCore(worldModelRecord,
						ID_SCENARIO_WORLD_CATEGORY, dcValueKeyMap,
						worldScenarioOut, pluginOut);
			} // for each world model record

			worldScenarioOut
					.write(CountryGraphCreator.XML_EXTENSION_POINT_CLOSE);
			worldScenarioOut.close();
			pluginOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // generateModelExtensionPointXML

	/**
	 * @param worldModels
	 * @param uriPathString
	 *            the path to the root of the folder to serialize the models to
	 * @throws IOException
	 */
	private void serializeScenarioModels(
			final List<ScenarioRecord> worldScenarios,
			final String uriPathString) throws IOException {
		for (ScenarioRecord scenarioRecord : worldScenarios) {
			scenarioRecord.serialize(uriPathString);
		} // for each model record
	} // serializeWorldModels

	/**
	 * This class contains a world scenario and its metadata.
	 */
	public class ScenarioRecord extends CountryGraphCreator.Record {

		/**
		 * Constructor
		 */
		public ScenarioRecord() {
			super();
		}

		/**
		 * @param identifiable
		 * @param id
		 * @param adminLevel
		 */
		public ScenarioRecord(Identifiable identifiable, String id,
				int adminLevel) {
			super(identifiable, id, adminLevel);
		}

		/**
		 * @param identifiable
		 * @param id
		 * @param adminLevels
		 */
		public ScenarioRecord(Identifiable identifiable, String id,
				List<Integer> adminLevels) {
			super(identifiable, id, adminLevels);
		}

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getOutputType()
		 */
		@Override
		public String getOutputType() {
			return "scenario";
		} // getOutputType

		/**
		 * @see org.eclipse.stem.data.geography.graph.CountryGraphCreator.Record#getType()
		 */
		@Override
		public String getType() {
			return "scenario";
		} // getType

	} // ScenarioRecord

} // WorldScenarioCreator
