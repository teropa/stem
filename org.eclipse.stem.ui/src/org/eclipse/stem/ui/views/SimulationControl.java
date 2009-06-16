package org.eclipse.stem.ui.views;

/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: IBM Corporation - initial API and implementation
 ******************************************************************************/

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.FontRegistry;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.jobs.execution.IExecutable;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListener;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.stem.ui.Activator;
import org.eclipse.stem.ui.ISharedColors;
import org.eclipse.stem.ui.ISharedFonts;
import org.eclipse.stem.ui.ISharedImages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Text;

/**
 * This class is an SWT control that displays the status/state of an ISimulation
 * and allows the ISimulation to be managed.
 * 
 */
public class SimulationControl extends Composite implements
		ISimulationListener, ControlListener {

	/**
	 * This is the active simulation job to which this class is attached & has
	 * control upon.
	 */
	protected ISimulation simulation = null;

	
	/**
	 * Boolean used to keep track of resettings : We need this variable because
	 * sometimes after a reset there is still one or two complete_cycles from
	 * old simulation run (before resetting) that should not be processed.
	 * 
	 */
	private boolean reset = false;

	/**
	 * The Image registry manages images, creates them on-demand, and disposes
	 * them when the associated display is disposed.
	 */
	private static ImageRegistry imageRegistry = null;

	/**
	 * The color registry manages SWT colors, creates them on-demand, and takes
	 * care of disposal.
	 */
	private static ColorRegistry colorRegistry = null;

	/**
	 * JFace font registry
	 */
	private static FontRegistry fontRegistry = null;

	/**
	 * WIDGETS for simulation control
	 */

	/**
	 * The top level container for the simulation control
	 */
	private Composite mainContainer = null;

	private Composite btnContainer = null;

	private Text simulationProgressText;
	private Text  simulationStateText;
	private Text  simulationTimeText;

	private ProgressBar pb = null;
	// Progress bar for iteration progress
	private ProgressBar ipb = null;
	
	private Text simulationTitleText = null;

	/**
	 * Symbolic constant indicating no work has been done
	 */
	private static int BEGIN_WORK = 0;

	/**
	 * Boolean variable used to indicate whether we should build a progress bar
	 * using SWT.INDETERMINATE
	 */
	private boolean UNKNOWN_DURATION = false;

	/**
	 * Some constants we need to set preferred sizes of SWT controls and
	 * containers.
	 */

	private static final int STANDARD_LENGTH = 100;

	private static final int STANDARD_HEIGHT = 18;

	private static final int CONTAINER_HEIGHT = 225;
	
	private static final int MARGIN = 10;
	/**
	 * Constructor
	 * 
	 * @param parent
	 * @param simulation
	 * 
	 */
	public SimulationControl(Composite parent, ISimulation simulation) {
		super(parent, SWT.NONE);

		// First, register as a listener of simulation manager events
		simulation.addSimulationListener(this);

		// Sets the active simulation we are going to control
		this.simulation = simulation;

		
		Sequencer sequencer = simulation.getScenario().getSequencer();
		// Check to see if we have to create an indeterminate progress bar.
		UNKNOWN_DURATION = 
			(sequencer.getDuration() == Sequencer.UNKNOWN_DURATION) 
			? true : false;

		// Set the image registry
		if (imageRegistry == null) {
			Activator activator = Activator.getDefault();
			imageRegistry = activator.getImageRegistry();
		}
		// Set the color registry
		if (colorRegistry == null) {
			Activator activator = Activator.getDefault();
			colorRegistry = activator.getColorRegistry();
		}
		// Set the font registry
		if (fontRegistry == null) {
			Activator activator = Activator.getDefault();
			fontRegistry = activator.getFontRegistry();
		}

		// Set the layout data for the simulation control
		// The parent has been set to GridLayout() previously.
		this.setLayoutData(new GridData(SWT.FILL, SWT.NONE, true, false));
		
		// Now create all the widgets
		createContents(this);
		parent.redraw();
	}

	/**
	 * Compute the new bounds for the simulation control after resizing.
	 * 
	 * @param event
	 */
	public void controlResized(ControlEvent event) {
      
		
		final int MULTIPLIER = 5;

	
		// Get the client area boundaries.
		Rectangle clientBounds = null;
		if (this.getParent() != null) {
			if (this.getParent().getParent() != null) {
				clientBounds = this.getParent().getParent().getClientArea();
			}
		}

		// Make sure we don't get an NPE
		if (clientBounds == null) {
			return;
		}
        
        int width = clientBounds.width- (MARGIN * MULTIPLIER);
        int height = STANDARD_HEIGHT;
		// Compute the new displaying bounds.
		Rectangle pbBounds = this.computeTrim(pb.getBounds().x,
				pb.getBounds().y, width,height);
		Rectangle ipbBounds = this.computeTrim(ipb.getBounds().x,
				ipb.getBounds().y, width,height);
		Rectangle titleBounds = this.computeTrim(
				        simulationTitleText.getBounds().x, 
				        simulationTitleText.getBounds().y, width, height);
		Rectangle stateBounds = this.computeTrim(
				        simulationStateText.getBounds().x, 
				        simulationStateText.getBounds().y, width, height);
		Rectangle timeBounds = this.computeTrim(
		        simulationTimeText.getBounds().x, 
		        simulationTimeText.getBounds().y, width, height);
		Rectangle progressBounds = this.computeTrim(
		        simulationProgressText.getBounds().x, 
		        simulationProgressText.getBounds().y, width, height);
		Rectangle mainBounds = this.computeTrim(clientBounds.x, clientBounds.y,
				clientBounds.width - MARGIN, CONTAINER_HEIGHT);
		Rectangle btnBounds = this.computeTrim(btnContainer.getBounds().x, 
				btnContainer.getBounds().y,width,height+2*MARGIN);
		// Set the new boundaries.
		pb.setBounds(pbBounds);
		ipb.setBounds(ipbBounds);
		
		simulationTitleText.setBounds(titleBounds);
		
		simulationStateText.setBounds(stateBounds);
		simulationTimeText.setBounds(timeBounds);
		simulationProgressText.setBounds(progressBounds);
		
		btnContainer.setBounds(btnBounds);
		mainContainer.setBounds(mainBounds);
		// Redraw the widgets.
		
		mainContainer.redraw();
		
	}

	/**
	 * Event handler method for moved window events.
	 * 
	 * @param event
	 */
	public void controlMoved(ControlEvent event) {
		// DO NOTHING
	}

	/**
	 * Reset the progress bar to initial state
	 * 
	 */
	protected void resetProgressBar() {

		if (null == pb || pb.isDisposed() ) {
			return;
		}
//		if (UNKNOWN_DURATION) {
//			return;
//		}
		pb.setMinimum(BEGIN_WORK);
		pb.setMaximum(IExecutable.TOTAL_WORK);
		pb.setSelection(BEGIN_WORK);
		pb.redraw();
		ipb.setMinimum(BEGIN_WORK);
		ipb.setMaximum(IExecutable.TOTAL_WORK);
		ipb.setSelection(BEGIN_WORK);
		ipb.redraw();

	}

	/**
	 * Update simulation state label whenever simulation changes state
	 * 
	 * @param state
	 *            of simulation
	 */
	protected void updateStateLabel(SimulationState state) {

		if (null == simulationStateText || simulationStateText.isDisposed()) {
			return;
		}
        Rectangle bounds = simulationStateText.getBounds();
		if (state.equals(SimulationState.RUNNING) ||
				state.equals(SimulationState.COMPLETED_CYCLE) ) {
			simulationStateText.setText(Messages.getString("SCtrl.Running")); //$NON-NLS-1$
			simulationStateText.setBackground(colorRegistry
					.get(ISharedColors.GREEN));
			
		} else if (state.equals(SimulationState.PAUSED)) {
			simulationStateText.setText(Messages.getString("SCtrl.Paused")); //$NON-NLS-1$
			simulationStateText.setBackground(colorRegistry
					.get(ISharedColors.YELLOW));
		} else if (state.equals(SimulationState.RESET)) {
			simulationStateText.setText(Messages.getString("SCtrl.Reset")); //$NON-NLS-1$
			simulationStateText.setBackground(colorRegistry
					.get(ISharedColors.ORANGE));
			pb.setSelection(0);
		}
		
        simulationStateText.setBounds(bounds);
		simulationStateText.redraw();
	}

	/**
	 * Update progress bar and progress Label
	 * If no duration then use sequencer cycle count to 
	 * (modulo 100) to reflect the progress.
	 * If there is a duration then use the work completed 
	 * value.
	 * 
	 * @param workCompleted
	 * @param state  Simulation state (running, paused ...)
	 */

	protected void updateProgressLabel(int workCompleted, SimulationState state) {
		Rectangle bounds = simulationProgressText.getBounds();
		Sequencer sequencer = simulation.getScenario().getSequencer();
		int current = sequencer.getCycle() ;
			
		
		if (UNKNOWN_DURATION == true) {
			// WE HAVE UNKNOWN DURATION
			simulationProgressText.setText(
					Messages.getString("SCtrl.Progress") + 
					" : unknown duration"); //$NON-NLS-1$ //$NON-NLS-2$
			current = current%100;
			
		} else if (workCompleted <= IExecutable.TOTAL_WORK) {
			simulationProgressText.setText(
					Messages.getString("SCtrl.Progress") +
					" : " + workCompleted + "%"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}


		simulationProgressText.setBounds(bounds);
		simulationProgressText.redraw();
		pb.setSelection(current);
	}

	/**
	 * Update simulation time label
	 * 	 
	 * @param state Simulation state
	 */
	protected void updateTimeLabel(SimulationState state) {
		Rectangle bounds = simulationTimeText.getBounds();
		// Get the current time :
		Sequencer sequencer = simulation.getScenario().getSequencer();
		STEMTime time = sequencer.getCurrentTime();

		if ((state.name().equals("RUNNING") == false) //$NON-NLS-1$
				&& (state.name().equals("COMPLETED_CYCLE") == false)) { //$NON-NLS-1$
			// DONT UPDATE UNLESS STATE IS RUNNING OR COMPLETED_CYCLE
			//return;
		}

		if (sequencer.getCycle() > 0 && reset == true) {
			// DO NOTHING : ignore spurious completed cycles after a reset.
			reset = false;
			return;
		}
        String timeLabel= "[" + sequencer.getCycle() + "] " + 
                        Messages.getString("SCtrl.Time") + 
                        " : " + time.toString(); 
        //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$	
		simulationTimeText.setText(timeLabel);	
		simulationTimeText.setToolTipText(timeLabel);
		
		simulationTimeText.setBounds(bounds);
		simulationTimeText.redraw();

	}

	/**
	 * @return the simulation to which this control is attached or associated
	 */
	public ISimulation getSimulation() {
		return simulation;
	}

	/**
	 * This is where we create & initialize the components that go into the
	 * simulation control.
	 * 
	 * <pre>
	 * - Title of Simulation
	 * - Progress status
	 * - State (Running Paused)
	 * - progress bar
	 * - Control buttons
	 * 
	 * @param parent  SimulationControl Composite (ourselves)
	 * 
	 */
	private void createContents(Composite parent) {

		// Create the top level container for the SWT Widgets of the simulation
		// control
		mainContainer = new Composite(parent, SWT.SMOOTH | SWT.BORDER);
		// Set Layout data for MainContainer within SimulationControl
		mainContainer.setLayoutData(getMainContainerGridData());
		// Set the layout manager for the top level container
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		mainContainer.setLayout(gridLayout);
		

		simulationTitleText = new Text(mainContainer, SWT.MULTI | SWT.WRAP);
		simulationTitleText.setText(simulation.getNameWithSequenceNumber());
		simulationTitleText.setToolTipText(simulation.getName());
		simulationTitleText
				.setBackground(colorRegistry.get(ISharedColors.GRAY));
		simulationTitleText.setFont(fontRegistry.get(ISharedFonts.DEFAULT));
		simulationTitleText.setEditable(false);
		simulationTitleText.setLayoutData(getTextGridData());

		simulationProgressText = new Text(mainContainer, SWT.SMOOTH
				| SWT.BORDER);
		simulationProgressText.setBackground(colorRegistry
				.get(ISharedColors.GREEN));
		simulationProgressText.setEditable(false);
		simulationProgressText.setFont(fontRegistry.get(ISharedFonts.DEFAULT));
		simulationProgressText.setLayoutData(getTextGridData());

		simulationStateText = new Text(mainContainer, SWT.SMOOTH | SWT.BORDER);
		simulationStateText.setBackground(colorRegistry
				.get(ISharedColors.GREEN));
		simulationStateText.setEditable(false);
		simulationStateText.setFont(fontRegistry.get(ISharedFonts.DEFAULT));
		simulationStateText.setLayoutData(getTextGridData());


		pb = new ProgressBar(mainContainer, SWT.SMOOTH | SWT.BORDER);
		pb.setFont(fontRegistry.get(ISharedFonts.DEFAULT));
		pb.setLayoutData(getProgressBarGridData());

		ipb = new ProgressBar(mainContainer, SWT.SMOOTH | SWT.BORDER);
		ipb.setFont(fontRegistry.get(ISharedFonts.DEFAULT));
		ipb.setLayoutData(getProgressBarGridData());
		
		simulationTimeText = new Text(mainContainer, SWT.SMOOTH | SWT.BORDER);
		simulationTimeText.setBackground(colorRegistry
				.get(ISharedColors.GREEN));
		simulationTimeText.setEditable(false);
		simulationTimeText.setFont(fontRegistry.get(ISharedFonts.DEFAULT));
		simulationTimeText.setLayoutData(getTextGridData());

		createControlButtons(mainContainer);
		
		resetProgressBar(); // Set and display progress bar's initial value
		updateStateLabel(simulation.getSimulationState());
		updateProgressLabel(BEGIN_WORK, simulation.getSimulationState());
        updateTimeLabel(simulation.getSimulationState());
		//mainContainer.redraw();
	}

	/**
	 * Create a new grid data object with default values.
	 * 
	 * @return the new grid data object
	 */
	protected GridData getDefaultGridData() {
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.grabExcessVerticalSpace = false;
		gridData.heightHint = STANDARD_HEIGHT;
		gridData.minimumHeight = STANDARD_HEIGHT;
		gridData.widthHint = STANDARD_LENGTH;
		gridData.minimumWidth = STANDARD_LENGTH;
		gridData.horizontalAlignment = SWT.LEFT;
		return gridData;
	}

	/**
	 * Create a new grid data customized for a text field.
	 * 
	 * @return gridData the new grid data object
	 */
	protected GridData getTextGridData() {
		GridData gridData = new GridData(SWT.FILL, SWT.NONE, true, false);
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = false;
		gridData.heightHint = STANDARD_HEIGHT;
		gridData.minimumHeight = STANDARD_HEIGHT-2;
		gridData.widthHint = STANDARD_LENGTH;
		gridData.minimumWidth = STANDARD_LENGTH;
		gridData.horizontalAlignment = SWT.FILL;
		return gridData;
	}

	/**
	 * Create a new grid data customized for a progress bar.
	 * 
	 * @return gridData the new grid data object
	 */
	protected GridData getProgressBarGridData() {
		GridData gridData = new GridData(SWT.FILL, SWT.NONE, true, false);
		gridData.grabExcessHorizontalSpace = true;
		gridData.grabExcessVerticalSpace = false;
		gridData.horizontalAlignment = SWT.FILL;
		return gridData;
	}

	/**
	 * Create a new grid data customized for the main container of the
	 * simulation control.
	 * 
	 * @return gridData the new grid data object
	 */
	protected GridData getMainContainerGridData() {
		GridData gridData = new GridData();
		gridData.grabExcessVerticalSpace = false;
		gridData.grabExcessHorizontalSpace = true;
		// Set the preferred size.
		gridData.widthHint = STANDARD_LENGTH;
		gridData.minimumWidth = STANDARD_LENGTH;
		//gridData.heightHint = STANDARD_HEIGHT;
		//gridData.minimumHeight = STANDARD_HEIGHT;
		gridData.heightHint = CONTAINER_HEIGHT;
		gridData.minimumHeight = CONTAINER_HEIGHT;
		return gridData;
	}

	/**
	 * Create a new grid data customized for the push buttons.
	 * 
	 * @return gridData the new grid data object
	 */
	protected GridData getButtonGridData() {
		
		GridData gridData = new GridData();
		gridData.grabExcessVerticalSpace = false;
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.verticalAlignment = SWT.CENTER;
		gridData.heightHint = STANDARD_HEIGHT-2+MARGIN;
		gridData.minimumHeight = STANDARD_HEIGHT-2;
		return gridData;
	}

	/**
	 * Creates the array of SWT push buttons.
	 * btnContainer is a new Composite that will contain
	 * a row of 5 buttons.
	 * @param parent mainContainer
	 */
	protected void createControlButtons(Composite parent) {
		
		final int OFFSET = 16;
		btnContainer = new Composite(parent,0);
        //btnContainer.setSize(STANDARD_LENGTH, STANDARD_HEIGHT+OFFSET);
        
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 5;
		gridLayout.makeColumnsEqualWidth = true;
		btnContainer.setLayout(gridLayout);
        // set gridData for btnContainer within mainContainer
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = false;
		gridData.horizontalAlignment = GridData.FILL;
		gridData.verticalAlignment = GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		gridData.heightHint = STANDARD_HEIGHT + OFFSET+MARGIN;
		gridData.minimumHeight = STANDARD_HEIGHT+ OFFSET+MARGIN;
		gridData.widthHint = STANDARD_LENGTH;
		gridData.minimumWidth = STANDARD_LENGTH;
		btnContainer.setLayoutData(gridData);

		// create the simulation control buttons
		Button run = new Button(btnContainer, SWT.PUSH);
		Button pause = new Button(btnContainer, SWT.PUSH);
		Button reset = new Button(btnContainer, SWT.PUSH);
		Button step = new Button(btnContainer, SWT.PUSH);
		Button stop = new Button(btnContainer, SWT.PUSH);

		// set alignment and background color
		run.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		run.setToolTipText(Messages.getString("SCtrl.StartSim")); //$NON-NLS-1$
		run.setLayoutData(getButtonGridData());

		pause
				.setBackground(parent.getDisplay().getSystemColor(
						SWT.COLOR_GRAY));
		pause.setToolTipText(Messages.getString("SCtrl.PauseSim")); //$NON-NLS-1$
		pause.setLayoutData(getButtonGridData());

		reset
				.setBackground(parent.getDisplay().getSystemColor(
						SWT.COLOR_GRAY));
		reset.setToolTipText(Messages.getString("SCtrl.RestoreSim")); //$NON-NLS-1$
		reset.setLayoutData(getButtonGridData());

		step.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		step.setToolTipText(Messages.getString("SCtrl.StepSim")); //$NON-NLS-1$
		step.setLayoutData(getButtonGridData());

		stop.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_GRAY));
		stop.setToolTipText(Messages.getString("SCtrl.StopSim")); //$NON-NLS-1$
		stop.setLayoutData(getButtonGridData());

		run.setImage(imageRegistry.get(ISharedImages.RUN_ICON));
		pause.setImage(imageRegistry.get(ISharedImages.PAUSE_ICON));
		reset.setImage(imageRegistry.get(ISharedImages.RESET_ICON));
		step.setImage(imageRegistry.get(ISharedImages.STEP_ICON));
		stop.setImage(imageRegistry.get(ISharedImages.STOP_ICON));
        

		// set event listeners for buttons
		run.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					run();
					break;
				}
			}
		});
		pause.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					pause();
					break;
				}
			}
		});
		reset.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					reset();
					break;
				}
			}
		});
		step.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					step();
					break;
				}
			}
		});
		stop.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				switch (e.type) {
				case SWT.Selection:
					stop();
					break;
				}
			}
		});

	}

	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
        
		// Nullify all our references.
		if (simulation != null) {
			simulation.removeSimulationListener(this);
			simulation = null;
		}

		
		// Force disposal of the main widget for the simulation control.
		if (mainContainer != null) {
			mainContainer.dispose();
		}

	} // dispose

	/**
	 * This is where the simulation control hears about changes in the
	 * simulation it is managing. It is really only interested in all events
	 * generated by the active simulation
	 * 
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListener#simulationChanged(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	public void simulationChanged(SimulationEvent event) {

		// Get the current simulation state
		final SimulationState simulationState = event.getSimulationState();
        Sequencer sequencer = simulation.getScenario().getSequencer();
		// If sequencer is null, then we have disposed the widget.
		if (sequencer == null) {
			// Widget disposed, do nothing.
			return;
		}

		switch (simulationState) {
		case STOPPED:
			// We're done, we'll get an event from the SimulationManager telling
			// us that the Simulation is no longer around.
			return;

		case COMPLETED_CYCLE:
			final int workComplete = (int) sequencer.getWorkComplete();

			if (workComplete < IExecutable.TOTAL_WORK) {
				// Has the widget been disposed ?
				if (pb.isDisposed() == true) {
					// Yes, do nothing.
					return;
				}
				pb.setSelection(workComplete);
				updateProgressLabel(workComplete, simulationState);
			}
			break;
		case RUNNING:
			// Check the progress of the scenario and update the progress bar
			ipb.setSelection((int)(event.getIterationProgress()*IExecutable.TOTAL_WORK));
			break;	
		case COMPLETED_SEQUENCE:
		case PAUSED:
		case RESET:
			// Nothing
			break;

		} // switch simulation state
		updateStateLabel(simulationState);
		updateTimeLabel(simulationState);
	} // simulationChanged

	/**
	 * Reset the time label
	 * 
	 */
	protected void resetTimeLabel() {
		final int ZERO = 0;

		simulationTimeText
				.setText("[ " + ZERO + " ] " + Messages.getString("SCtrl.Time") + " : " + ZERO); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$  //$NON-NLS-4$
		
		simulationTimeText.redraw();
	}

	/**
	 * Run the simulation
	 * 
	 */
	public void run() {
		simulation.run();
	}

	/**
	 * Pause the simulation
	 * 
	 */
	public void pause() {
		simulation.pause();
	}

	/**
	 * Reset the simulation and the controls.
	 * 
	 */
	public void reset() {
		// Reset the simulation
		simulation.reset();

		// Turn flag for resets ON :
		reset = true;
		// Now reset the widget :
		resetTimeLabel();
	}

	/**
	 * Step the simulation
	 * 
	 */
	public void step() {
		simulation.step();
	}

	/**
	 * Stop the simulation
	 */
	public void stop() {
		simulation.stop();
	}

} // SimulationControl

