// ISharedImages.java
package org.eclipse.stem.ui;

/*******************************************************************************
 * Copyright (c) 2006, 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

/**
 * This interface contains identifiers used to mark images added to this
 * plug-in's image registry. This images are intended to be shared by
 * referencing the registry and using the identifiers defined here to select the
 * appropriate image.
 */
public interface ISharedImages {
	/**
	 * This image is the icon that represents a
	 * {@link org.eclipse.stem.core.graph.Graph}.
	 */
	String GRAPH_ICON = "graph.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a file that contains a
	 * {@link org.eclipse.stem.core.graph.Graph}.
	 */
	String GRAPH_MODEL_FILE_ICON = "graph_model_file.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents an
	 * {@link org.eclipse.stem.core.graph.Edge} in a
	 * {@link org.eclipse.stem.core.graph.Graph}.
	 */
	String EDGE_ICON = "edge.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a
	 * {@link org.eclipse.stem.core.graph.DynamicLabel} in a
	 * {@link org.eclipse.stem.core.graph.Graph}.
	 */
	String DYNAMIC_LABEL_ICON = "dynamic_label.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a static
	 * {@link org.eclipse.stem.core.graph.Label} in a
	 * {@link org.eclipse.stem.core.graph.Graph}.
	 */
	String STATIC_LABEL_ICON = "static_label.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a
	 * {@link org.eclipse.stem.core.graph.Node} in a
	 * {@link org.eclipse.stem.core.graph.Graph}.
	 */
	String NODE_ICON = "node.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a
	 * {@link org.eclipse.stem.core.model.Model}.
	 */
	String MODEL_ICON = "model.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a file that contains a
	 * {@link org.eclipse.stem.core.model.Model}.
	 */
	String MODEL_MODEL_FILE_ICON = "model_model_file.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a
	 * {@link org.eclipse.stem.core.scenario.Scenario}.
	 */
	String SCENARIO_ICON = "scenario.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a file that contains a
	 * {@link org.eclipse.stem.core.scenario.Scenario}.
	 */
	String SCENARIO_MODEL_FILE_ICON = "scenario_model_file.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a {@link Sequencer}.
	 */
	String SEQUENCER_ICON = "sequencer.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents an
	 * {@link org.eclipse.stem.core.experiment.Experiment}.
	 */
	String EXPERIMENT_ICON = "experiment.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents an
	 * {@link org.eclipse.stem.core.trigger.Trigger}.
	 */
	String TRIGGER_ICON = "trigger.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents an
	 * {@link org.eclipse.stem.core.predicate.Predicate}.
	 */
	String PREDICATE_ICON = "predicate.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents a
	 * {@link org.eclipse.stem.core.modifier.Modifier}.
	 */
	String MODIFIER_ICON = "modifier.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that represents an
	 * {@link org.eclipse.stem.core.model.Decorator}.
	 */
	String DECORATOR_ICON = "decorator.image"; //$NON-NLS-1$

	/**
	 * This image is the icon used to represent a STEM project.
	 */
	String STEM_PROJECT_ICON = "stem_project.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a RUN simulation event
	 */
	String RUN_ICON = "run.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a PAUSE simulation event
	 */
	String PAUSE_ICON = "pause.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a STEP simulation event
	 */
	String STEP_ICON = "step.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a RESET simulation event
	 */
	String RESET_ICON = "reset.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a STOP simulation event
	 */
	String STOP_ICON = "stop.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a disabled RUN simulation event
	 */
	String DISABLED_RUN_ICON = "disabled_run.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a disabled PAUSE simulation event
	 */
	String DISABLED_PAUSE_ICON = "disabled_pause.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a disabled STEP simulation event
	 */
	String DISABLED_STEP_ICON = "disabled_step.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a disabled RESET simulation event
	 */
	String DISABLED_RESET_ICON = "disabled_reset.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a disabled STOP simulation event
	 */
	String DISABLED_STOP_ICON = "disabled_stop.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent the STEM Project Explorer View
	 */
	String STEM_EXPLORER_VIEW_ICON = "stem_explorer.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a STEM project in the STEM Project
	 * Explorer
	 */
	String STEM_EXPLORER_PROJECT_ICON = "stem_project.image"; //$NON-NLS-1$

	/**
	 * This image is the icon to represent a delete file/folder operation in
	 * STEM Project Explorer
	 */
	String DELETE_FILE_ICON = "delete.image"; //$NON-NLS-1$

	/**
	 * This image is the icon that identifies the simulation control view
	 */
	String SIMULATION_CONTROL_VIEW_ICON = "simulation_control_view.image"; //$NON-NLS-1$

	/**
	 * This image is the icon associated with a simulation control
	 */
	String SIMULATION_CONTROL_ICON = "simulation_control.image"; //$NON-NLS-1$

	/**
	 * This image is the icon associated with
	 * {@link org.eclipse.stem.core.scenario.Scenario} files.
	 */
	String STEM_SCENARIO_FILE_ICON = "scenario_file.image"; //$NON-NLS-1$

	/**
	 * This image is the icon associated with
	 * {@link org.eclipse.stem.core.graph.Graph} files.
	 */
	String STEM_GRAPH_FILE_ICON = "generic_file.image"; //$NON-NLS-1$

	/**
	 * This image is the icon associated with
	 * {@link org.eclipse.stem.core.model.Model} files.
	 */
	String STEM_MODEL_FILE_ICON = "scenario_File.image"; //$NON-NLS-1$

	/**
	 * This image is the icon associated with
	 * {@link org.eclipse.stem.core.model.Model} files.
	 */
	String MAP_ICON = "map.image"; //$NON-NLS-1$

	// /**
	// * This image is the icon associated with files that store recorded {@link
	// * org.eclipse.stem.jobs.simulation.Simulation}s.
	// */
	//	String RECORDED_SIMULATION_FILE_ICON = "recorded_simulation_File.image"; //$NON-NLS-1$

	/**
	 * This image is the icon associated with recorded
	 * {@link org.eclipse.stem.jobs.simulation.Simulation}s.
	 */
	String RECORDED_SIMULATION_ICON = "recorded_simulation.image"; //$NON-NLS-1$

} // ISharedImages
