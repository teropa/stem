// IdentifiableTreeNode.java
package org.eclipse.stem.ui.views.explorer;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.core.resources.IProject;
import org.eclipse.stem.ui.wizards.NewSTEMProjectWizard;

/**
 * This class is used in the {@link org.eclipse.ui.navigator.CommonNavigator}
 * based STEM Project Explorer view to represent a group of one type of
 * {@link org.eclipse.stem.core.common.Identifiable} component (e.g.,
 * {@link org.eclipse.stem.core.model.Model},
 * {@link org.eclipse.stem.core.graph.Graph},
 * {@link org.eclipse.stem.core.model.Decorator},
 * {@link org.eclipse.stem.core.scenario.Scenario},
 * {@link org.eclipse.stem.core.sequencer.Sequencer} ,
 * {@link org.eclipse.stem.core.experiment.Experiment},
 * {@link org.eclipse.stem.core.trigger.Trigger},
 * {@link org.eclipse.stem.core.modifier.Modifier},
 * {@link org.eclipse.stem.core.predicate.Predicate}) that belong to a
 * particular STEM Project instance.
 */
abstract public class IdentifiableTreeNode {

	private final String componentName;
	private final String folderName;
	private final IProject project;
	private final String imageKey;

	/**
	 * @param project
	 *            the {@link IProject} that is the parent of this
	 *            {@link IdentifiableTreeNode}.
	 * @param componentName
	 *            the name of the component (e.g., "Scenarios")
	 * @param folderName
	 *            the non-NLS'd name of the folder in the project that
	 *            {@link org.eclipse.stem.core.common.Identifiable}s that correspond to this node are
	 *            serialized in.
	 * @param imageKey
	 *            the string that is used as a key into the
	 *            {@link org.eclipse.jface.resource.ImageRegistry} of the plug-in.
	 */
	public IdentifiableTreeNode(final IProject project,
			final String componentName, String folderName, String imageKey) {
		this.project = project;
		this.componentName = componentName;
		this.folderName = folderName;
		this.imageKey = imageKey;
	} // IdentifiableTreeNode

	/**
	 * @return the {@link IProject} associated with the
	 *         {@link IdentifiableTreeNode} instance. *
	 */
	public IProject getProject() {
		return project;
	}

	/**
	 * @return the name of the component
	 */
	public String getComponentName() {
		return componentName;
	}

	/**
	 * @return the non-NLS'd name of the folder in the project that
	 *         {@link org.eclipse.stem.core.common.Identifiable}s that correspond to this node are serialized
	 *         in.
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * @return the key used to find an image for the component in the shared
	 *         image registry
	 */
	public String getImageKey() {
		return imageKey;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder(componentName);
		return sb.toString();
	} // toString

	/**
	 * hashCode. Override to fix navigator problem. The navigator in eclipse stores the tree nodes
	 * in a hash table and we need to override hashCode and equals to make sure they can be
	 * found. A combination of the folder name and the project name is unique within STEM.
	 */
	
	@Override
	public int hashCode() {
		return folderName.hashCode()+project.getName().hashCode();
	}
	
	/**
	 * equals. Override to fix navigator problem
	 */
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof IdentifiableTreeNode)) return false;
		
		return (((IdentifiableTreeNode)o).getFolderName().equals(this.folderName) &&
				((IdentifiableTreeNode)o).getProject().getName().equals(this.getProject().getName()));
	}
	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.model.Decorator}s.
	 */
	public static class DecoratorsTreeNode extends IdentifiableTreeNode {

		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public DecoratorsTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.DECORATOR_FOLDER"),
					NewSTEMProjectWizard.DECORATORS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.DECORATOR_ICON);
		}
	} // DecoratorsTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.scenario.Scenario}s.
	 */
	public static class ScenariosTreeNode extends IdentifiableTreeNode {

		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public ScenariosTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.SCENARIO_FOLDER"),
					NewSTEMProjectWizard.SCEANARIOS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.SCENARIO_ICON);
		}
	} // ScenariosTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.experiment.Experiment}s.
	 */
	public static class ExperimentsTreeNode extends IdentifiableTreeNode {

		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public ExperimentsTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.EXPERIMENT_FOLDER"),
					NewSTEMProjectWizard.EXPERIMENTS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.EXPERIMENT_ICON);
		}
	} // ExperimentsTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.sequencer.Sequencer}s.
	 */
	public static class SequencersTreeNode extends IdentifiableTreeNode {

		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public SequencersTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.SEQUENCER_FOLDER"),
					NewSTEMProjectWizard.SEQUENCERS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.SEQUENCER_ICON);
		}
	} // SequencersTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.model.Model}s.
	 */
	public static class ModelsTreeNode extends IdentifiableTreeNode {

		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public ModelsTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.MODEL_FOLDER"), 
					NewSTEMProjectWizard.MODELS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.MODEL_ICON);
		}
	} // ModelsTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.graph.Graph}s.
	 */
	public static class GraphsTreeNode extends IdentifiableTreeNode {

		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public GraphsTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.GRAPH_FOLDER"), 
					NewSTEMProjectWizard.GRAPHS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.GRAPH_ICON);
		}
	} // GraphsTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.trigger.Trigger}s.
	 */
	public static class TriggersTreeNode extends IdentifiableTreeNode {

		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public TriggersTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.TRIGGER_FOLDER"), 
					NewSTEMProjectWizard.TRIGGERS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.TRIGGER_ICON);
		}
	} // TriggersTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.predicate.Predicate}s.
	 */
	public static class PredicatesTreeNode extends IdentifiableTreeNode {
	
		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public PredicatesTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.PREDICATE_FOLDER"), 
					NewSTEMProjectWizard.PREDICATES_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.PREDICATE_ICON);
		}
	} // PredicatesTreeNode

	/**
	 * This class is a {@link IdentifiableTreeNode} that represents
	 * {@link org.eclipse.stem.core.modifier.Modifier}s.
	 */
	public static class ModifiersTreeNode extends IdentifiableTreeNode {
		/**
		 * @param project
		 *            the {@link IProject} that is the parent of this
		 *            {@link IdentifiableTreeNode}.
		 */
		public ModifiersTreeNode(IProject project) {
			super(project, Messages.getString("EXPLORER.MODIFIER_FOLDER"), 
					NewSTEMProjectWizard.MODIFIERS_FOLDER_NAME,
					org.eclipse.stem.ui.ISharedImages.MODIFIER_ICON);
		}
	} // ModifiersTreeNode

} // IdentifiableTreeNode