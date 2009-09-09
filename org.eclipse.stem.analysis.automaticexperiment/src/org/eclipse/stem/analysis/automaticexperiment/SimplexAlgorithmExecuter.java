package org.eclipse.stem.analysis.automaticexperiment;

/**
 * Implementation was taken from: http://www.ee.ucl.ac.uk/~mflanaga/java/Minimisation.html#simplex
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.stem.analysis.ErrorFunction;
import org.eclipse.stem.analysis.ErrorResult;
import org.eclipse.stem.analysis.ScenarioInitializationException;
import org.eclipse.stem.analysis.impl.ReferenceScenarioDataMapImpl;
import org.eclipse.stem.analysis.util.CSVscenarioLoader;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.IntegrationDecorator;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.diseasemodels.standard.AggregatingSIDiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.util.loggers.views.CustomCSVLogger;

import automaticexperiment.AutomaticExperiment;
import automaticexperiment.ModifiableParameter;

public class SimplexAlgorithmExecuter 
	extends AbstractErrorAnalysisAlgorithm {
	
	private ISimulation simulation = null;
	private CustomCSVLogger csvLogger = null;
	private final static String SIMULATION_OUTPUT_DIR = Platform.getLocation() + File.separator + "AutoExpTempDir";
	private final static String LOG_FILE_NAME = SIMULATION_OUTPUT_DIR+File.separator+"resultLog.csv";
	static String LS = System.getProperty("line.separator"); 
	private final CustomSimulationManager simMgr = CustomSimulationManager.getManager();
	private ReferenceScenarioDataMapImpl ref;
	
	/**
	 * @see org.eclipse.stem.analysis.automaticexperiment.AbstractErrorAnalysisAlgorithm#execute()
	 */
	public void execute() {
		long before = System.currentTimeMillis();
		
		simplexAlgorithm.execute(simplexFnToMinimize, initialParamsValues, paramsInitialSteps, tolerance);
		long after = System.currentTimeMillis();
		System.out.println("\n\nTime to execute the Nedler-Mead Algorithm: " + (after-before)/1000 + " seconds");
		System.out.println("Minimum value: " + simplexAlgorithm.getMinimumFunctionValue());
		System.out.println("Parameters values: " + Arrays.toString(simplexAlgorithm.getMinimumParametersValues()));
	}
	
	@Override
	public void init(AutomaticExperiment automaticExperiment) {
		super.init(automaticExperiment);
		simplexFnToMinimize = new NedlearMeadSimplexFunction(parameters, baseScenario, errorFunction);
		try {
			CSVscenarioLoader loader1 = new CSVscenarioLoader(referenceDataDirectory);
			ref = loader1.parseAllFiles(2);
		} catch (ScenarioInitializationException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void setParameters(List<ModifiableParameter> parameters) {
		super.setParameters(parameters);
		
		//Set lower and upper bounds constraints for the parameters
		int paramIndex=0;
		for (final ModifiableParameter param:parameters) {
			simplexAlgorithm.setParameterLimits(paramIndex, param.getLowerBound(), param.getUpperBound());
			paramIndex++;
		}
	}
	
	/**
	 *
	 */
	public class NedlearMeadSimplexFunction
		implements SimplexFunction 
	{	
	    private ErrorFunction errorFunction = null;
	    private String[] parameterNames = null;
	    private FileWriter resultWriter;
	    
		public NedlearMeadSimplexFunction(
				final List<ModifiableParameter> parameters,
				final Scenario pBaseScenario, 
				final ErrorFunction errorFunction) {
			
			try {
				resultWriter = new FileWriter(LOG_FILE_NAME);
				baseScenario = pBaseScenario;
				this.errorFunction = errorFunction;
				if (parameters != null) {
					parameterNames = new String[parameters.size()];
					int i=0;
					for (final ModifiableParameter param:parameters) {
						parameterNames[i++] = param.getFeatureName();
						resultWriter.write(parameterNames[i-1]);
						resultWriter.write(",");
					}
					resultWriter.write("error");
					resultWriter.write(LS);
				}
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		public double getValue(double[] parameters) {
			if (simulation != null) {
				baseScenario.reset();
			}
			simulation = createSimulation(baseScenario);
			simulation.setSequenceNumber(simulation.getSequenceNumber()+1);
			
			// Descend into the Scenario looking for something with a double field
			final EList<Decorator> decorators = baseScenario.getCanonicalGraph().getDecorators();
	
			for (Decorator decorator : decorators) {
				if (decorator instanceof DiseaseModel) {
					DiseaseModel dm = (DiseaseModel)decorator;
					// Look through the attributes in the DiseaseModel
					for (EAttribute attribute : decorator.eClass().getEAllAttributes()) {
						for (int i=0; i<parameterNames.length; i++) {
							if (attribute.getName().equals(parameterNames[i])) {								
								dm.eSet(attribute, new Double(parameters[i]));
							}
						}
					}
					if(!(dm instanceof AggregatingSIDiseaseModel)) {
						csvLogger = new CustomCSVLogger(SIMULATION_OUTPUT_DIR, simulation, (IntegrationDecorator) dm);
					}
				}
			}
			
			//Run the simulation with the new parameters and return the error value
			System.out.println("Running the simulation with the following parameters: ");
			System.out.println("\tParameters Names: " + Arrays.toString(parameterNames));
			System.out.println("\tParameters Values: " + Arrays.toString(parameters));
			double error = 0.0;
			try {
				for(double val:parameters) resultWriter.write(val+",");
				runSimulation(simulation);
				
				error = getErrorValue(simulation.getUniqueIDString());
				System.out.println(" Error is: " + error);
				resultWriter.write(error+"");
				resultWriter.write(LS);
				resultWriter.flush();
			} catch(IOException ioe) {
				ioe.printStackTrace();
			}
			cleanup();
			
			return error;
		}
		
		private double getErrorValue(String simulationUniqueId) {
			ErrorResult result = null;
			try {
				CSVscenarioLoader loader2 = new CSVscenarioLoader(SIMULATION_OUTPUT_DIR + File.separator + simulationUniqueId + "/Flu");
				ReferenceScenarioDataMapImpl data = loader2.parseAllFiles(2);
	
				result = errorFunction.calculateError(ref, data);
			} catch (ScenarioInitializationException e) {
				e.printStackTrace();
			}
			return result.getError();
		}
		
		private void runSimulation(final ISimulation simulationToRun) {
			long before = System.currentTimeMillis();
			simulationToRun.run();
			try {
				simulationToRun.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			simulationToRun.stop();			
			
			long after = System.currentTimeMillis();
			System.out.println("It took " + (after-before)/1000 + " seconds to run the simulation");
		}
		
		private void cleanup() {
			if (csvLogger != null) {
				csvLogger.close();
				csvLogger = null;
			}
			simMgr.removeActiveSimulation(simulation);
			((Simulation)simulation).destroy();
			simulation = null;
			CustomSimulationManager.resetSimulationManager();
		}
		
		private ISimulation createSimulation(Scenario scenario) {
			Simulation simulation = (Simulation)simMgr.createSimulation(scenario, null);
			simulation.simulationSleep = false;
			return simulation;
		}
	}
}


