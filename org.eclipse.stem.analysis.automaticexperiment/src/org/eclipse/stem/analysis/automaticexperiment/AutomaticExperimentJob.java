package org.eclipse.stem.analysis.automaticexperiment;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.stem.jobs.execution.Executable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import automaticexperiment.AutomaticExperiment;


public class AutomaticExperimentJob extends Executable {
	
	protected AutomaticExperiment automaticExperiment = null;
	protected Shell shell = PlatformUI.getWorkbench().getDisplay().getActiveShell();
	protected boolean isRunning = false;

	public AutomaticExperimentJob(String title, int sequenceNumber) {
		super(title == null ? "" : title, sequenceNumber);
	}
	
	public AutomaticExperimentJob(AutomaticExperiment toRun) {
		this(toRun.getDublinCore().getTitle(), 1);
		this.automaticExperiment = toRun;
	}

	/**
	 * @see org.eclipse.core.runtime.jobs.Job#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		IStatus retValue = Status.OK_STATUS;
//		isRunning = true;
//		
//		//Run
//		ErrorAnalysisAlgorithm algorithm = null;
//		String algorithmName = automaticExperiment.getErrorAnalysisAlgorithm();
//		if (algorithmName.equals("Nedler-Mead Algorithm")) {
//			algorithm = new SimplexAlgorithmExecuter(shell);
//		}
//		algorithm.setBaseScenario(automaticExperiment.getBaseScenario());
//		
//		int numOfParams = automaticExperiment.getParameters().size();
//		double[] initialParamsValues = new double[numOfParams]; 
//		double[] paramsSteps = new double[numOfParams];
//		String[] paramsNames = new String[numOfParams];
//		
//		int index = 0;
//		for (ModifiableParameter parameter:automaticExperiment.getParameters()) {
//			initialParamsValues[index] = parameter.getInitialValue();
//			paramsSteps[index] = parameter.getStep();
//			paramsNames[index] = parameter.getFeatureName();
//			index++;
//		}
//		algorithm.setInitialParametersValues(initialParamsValues);
//		algorithm.setParametersSteps(paramsSteps);
//		algorithm.setParameters(automaticExperiment.getParameters());
//		
//		double tolerance = automaticExperiment.getTolerance();
//		algorithm.setTolerance(tolerance);		
//		
//		ErrorFunction errorFunction = null;
//		String errorFunctionName = automaticExperiment.getErrorFunction();
//		if (errorFunctionName.equals("Threshold error function")) {
//			errorFunction = AnalysisFactory.eINSTANCE.createThresholdErrorFunction();
//		}
//		if (errorFunctionName.equals("Simple error function")) {
//			errorFunction = AnalysisFactory.eINSTANCE.createSimpleErrorFunction();
//		}		
//		algorithm.setErrorFunction(errorFunction);
//		
//		String refDir = automaticExperiment.getReferanceDataDir();
//		algorithm.setReferenceDataDirectory(refDir);
//		
//		algorithm.init();
//		
//		long before = System.currentTimeMillis();
//		algorithm.execute();
//		long after = System.currentTimeMillis();
//		System.out.println("Time to execute the Nedler-Mead Algorithm: " + (after-before)/1000 + " seconds");
//		System.out.println("Minimum value: " + algorithm.getResultValue());
//		System.out.print("Parameters values: ");
//		for (double param:algorithm.getResultParameters()) {
//			System.out.print(param + ", ");
//		}
//		System.out.println();
//		
//		isRunning = false;
		return retValue;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void pause() {
		// TODO Auto-generated method stub
		
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public void run() {		
		schedule();				
	}

	public void step() {
		// TODO Auto-generated method stub
		
	}

	public void stop() {
		// TODO Auto-generated method stub		
	}
	
}
