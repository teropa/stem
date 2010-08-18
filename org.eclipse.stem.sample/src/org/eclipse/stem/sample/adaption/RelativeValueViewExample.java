// RelativeValueViewExample.java
package org.eclipse.stem.sample.adaption;

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

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

/**
 * This class is an example of how to run GUI code in Eclipse and monitor the
 * "selected" simulation, and how to extract the canonical graph from the
 * selected simulation and then extract data from it. In particular, this
 * example view illustrates how to explore the canonical graph and discover
 * property values of graph components that can be represented as a value
 * between 0.0 and 1.0 (inclusive) relative to other peer property values. For
 * instance, in the case of a disease model, the disease model label values
 * contain population numbers for population members in different disease states
 * (e.g., "susceptible", "exposed", "infectious", "recovered"). The number of
 * members in each state can be represented relative to the total population
 * figure (i.e., as a percentage of the sum of all the states). The relative
 * values can be interpreted by a generic graphical interface to display
 * different colors or intensities to represent the property value.
 * <p>
 * The discovery of properties and their conversion to relative values is
 * facilitated by an interface called {@link RelativeValueProvider}. Instances
 * of classes that implement this interface can provide a list of properties for
 * which relative values can be generated, and, given one of those properties,
 * can generate its relative value. The properties contain details such as the
 * name of the property and a text description, among other things. These values
 * could be presented to a user of a graphical interface in a menu to select the
 * (relative) property values to display. The trick, and the point of this
 * example, is obtaining {@link RelativeValueProvider}'s for components of the
 * graph.
 * <p>
 * Instances of {@link RelativeValueProvider} are created by an adapter factory
 * called {@link RelativeValueProviderAdapterFactory}. This adapter factory can
 * be given any component in a graph and, if possible, create a
 * {@link RelativeValueProvider} for it. If it can't, it simply returns
 * <code>null</code> as the result of the attempt. The factory can be
 * generically extended to encompass new graph components. This allows clients
 * of the factory to obtain adapters for future enhancements with no change to
 * the interface. An example of this is the
 * {@link org.eclipse.stem.diseasemodels.standard.provider.StandardRelativeValueProviderAdapterFactory}
 * which provides relative values for properties of the "standard" STEM disease
 * model components, in particular, for the disease model label values (e.g.,
 * {@link org.eclipse.stem.diseasemodels.standard.SILabelValue},
 * {@link org.eclipse.stem.diseasemodels.standard.SIRLabelValue}, and
 * {@link org.eclipse.stem.diseasemodels.standard.SEIRLabelValue}).
 * <p>
 * This example illustrates how to track which simulation is selected and then
 * how to extract the simulation's underlying
 * {@link org.eclipse.stem.core.scenario.Scenario} and then from that obtain
 * the <em>canonical graph</em>. The canonical graph is the actual graph used
 * to represent the simulation state information. The simulation proceeds by
 * updating the values of labels on edges and nodes in the graph. The example
 * shows how to obtain the decorators (e.g., disease models such as
 * {@link org.eclipse.stem.diseasemodels.standard.DeterministicSEIRDiseaseModel})
 * that update the state of the graph and then from those discover properties
 * that can have relative values. The example then shows how to use the adapter
 * factory to create {@link RelativeValueProvider}'s.
 * <p>
 * To see the example in action, you need to:
 * <ol>
 * <li> Run STEM</li>
 * <li> Open the "Relative Value View Example" view.
 * "Window->Show&nbsp;View->Other->STEM->Relative&nbsp;Value&nbsp;View&nbsp;Example"</li>
 * <li> Open the "Active Simulations" view.
 * "Window->Show&nbsp;View->Active&nbsp;Simulations"</li>.
 * 
 * <li> Go to the "Scenarios" view. It shows the STEM Scenarios that are plugged
 * into STEM. </li>
 * <li> Expand "Test->Disease&nbsp;Models->Standard" and you'll see disease
 * modeling scenarios that are plugged into STEM. </li>
 * <li> Double-click on a scenario in the list (e.g., "SEIR 1 x 1") it will
 * begin simulation and an entry will appear in the "Active Simulations" view.
 * </li>
 * <li> Single click on the entry in the Active Simulations view. This will
 * select that simulation and the relative values for that scenario will appear
 * in the Relative Value View Example view.</li>
 * </ol>
 * If you double-click on another plugged-in Scenario so that two entries are
 * displayed in the Active Simulations view and if you select both, you'll see
 * data from both simulations.
 * 
 */
public class RelativeValueViewExample extends ViewPart {

	/**
	 * The identifier of the Relative Value View Example View. Nobody uses this
	 * right now, but it would be useful if we wanted to programatically add
	 * this view to a perspective.
	 */
	public static final String ID_VIEW_EXAMPLE1_VIEW = "org.eclipse.stem.sample.adapter.relativevalueviewexample";

	private static final int NUMBER_OF_FRACTIONAL_DIGITS = 2;

	TreeViewer treeViewer = null;

	private static NumberFormat formatter = null;

	/**
	 * @return a number formatter
	 */
	protected static NumberFormat getFormatter() {
		// Is there already a formatter?
		if (formatter == null) {
			// No
			formatter = NumberFormat.getNumberInstance();
			formatter.setMaximumFractionDigits(NUMBER_OF_FRACTIONAL_DIGITS);
			formatter.setMinimumFractionDigits(NUMBER_OF_FRACTIONAL_DIGITS);
		}
		return formatter;
	} // getFormatter

	/**
	 * This method is called when the view is created and it has the
	 * responsibility for doing all of the initialization. It creates the
	 * TreeViewer and instances of the ContentProvider and LabelProvider for the
	 * viewer. It also gets a reference to the selection service and registers
	 * the content provider so it will be notified when something is selected.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		// Create the TreeViewer
		treeViewer = new TreeViewer(parent, SWT.FULL_SELECTION | SWT.H_SCROLL
				| SWT.V_SCROLL);

		final Tree tree = treeViewer.getTree();
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);

		final TreeColumn simulationColumn = new TreeColumn(tree, SWT.NONE);
		simulationColumn.setText("Simulation");
		simulationColumn.setResizable(true);
		simulationColumn.setWidth(200);
		simulationColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			SelectionEvent e) {
				((RelativeValueViewSorter) treeViewer.getSorter()).doSort(0);
				treeViewer.refresh(true);
			}
		});

		final TreeColumn decoratorColumn = new TreeColumn(tree, SWT.NONE);
		decoratorColumn.setText("Decorator");
		decoratorColumn.setResizable(true);
		decoratorColumn.setWidth(200);
		decoratorColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			SelectionEvent e) {
				((RelativeValueViewSorter) treeViewer.getSorter()).doSort(1);
				treeViewer.refresh(true);
			}
		});

		final TreeColumn nodeColumn = new TreeColumn(tree, SWT.NONE);
		nodeColumn.setText("Node");
		nodeColumn.setResizable(true);
		nodeColumn.setWidth(100);
		nodeColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			SelectionEvent e) {
				((RelativeValueViewSorter) treeViewer.getSorter()).doSort(2);
				treeViewer.refresh(true);
			}
		});

		final TreeColumn currentValueColumn = new TreeColumn(tree, SWT.NONE);
		currentValueColumn.setText("Current Values");
		currentValueColumn.setResizable(true);
		currentValueColumn.setWidth(100);
		currentValueColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			SelectionEvent e) {
				((RelativeValueViewSorter) treeViewer.getSorter()).doSort(3);
				treeViewer.refresh(true);
			}
		});

		final TreeColumn relativeValueColumn = new TreeColumn(tree, SWT.NONE);
		relativeValueColumn.setText("Relative Values");
		relativeValueColumn.setResizable(true);
		relativeValueColumn.setWidth(100);
		currentValueColumn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			SelectionEvent e) {
				((RelativeValueViewSorter) treeViewer.getSorter()).doSort(4);
				treeViewer.refresh(true);
			}
		});

		// Let the ListViewer know who its content and label providers are
		treeViewer.setContentProvider(new RelativeValueViewContentProvider());
		treeViewer.setLabelProvider(new RelativeValueViewLabelProvider());
		treeViewer.setSorter(new RelativeValueViewSorter());

		// This call tells the viewer's content provider where it should get the
		// source of its content. In this case it is the selection service.
		treeViewer.setInput(getSite().getWorkbenchWindow()
				.getSelectionService());

		// We also want to be able to have a user select a simluation from our
		// view and have that be seen by others. So we register the TreeViewer
		// instance as the view's selection provider. When you click on the view
		// in the interface it finds the underlying Object (i.e., ISimulation)
		// you selected and passes it to the selection service.
		// getSite().setSelectionProvider(treeViewer);

	} // createPartControl

	/**
	 * This is required by the interface, but we're not using it.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// nothing
	} // setFocus

	/**
	 * This class is the content provider.
	 */
	public class RelativeValueViewContentProvider implements
			ITreeContentProvider, ISelectionListener {

		ISelectionService ss = null;

		private TreeViewer viewer = null;

		private List<ISimulation> selectedSimulations;

		/**
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(Object inputElement) {
			return new Object[] { inputElement };
		} // getElements

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			// TODO Auto-generated method stub
		}

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// We remember the TreeViewer we're providing content for because
			// we'll have to change the list of things it contains in the
			// selectionChanged method.
			this.viewer = (TreeViewer) viewer;

			// Were we previously getting input from a different service?
			if (oldInput != null) {
				// Yes
				// Not any more.
				final ISelectionService oldSS = (ISelectionService) oldInput;
				oldSS.removePostSelectionListener(this);
			}

			// Is there some new input we should register with?
			if (newInput != null) {
				// Yes
				// Register us with the new service. Since there should only
				// really be one selection service in Eclipse, this would only
				// happen once, however, the code can handle a change if needed.
				ss = (ISelectionService) newInput;
				ss.addPostSelectionListener(this);
			}

		} // inputChanged

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
		 */
		public Object[] getChildren(Object parentElement) {
			Object[] retValue = null;
			if (parentElement instanceof ISelectionService) {
				retValue = selectedSimulations == null ? null
						: selectedSimulations.toArray();
			} else if (parentElement instanceof ISimulation) {
				ISimulation simulation = (ISimulation) parentElement;
				retValue = simulation.getScenario().getCanonicalGraph()
						.getDecorators().toArray();
			} else if (parentElement instanceof Decorator) {
				Decorator decorator = (Decorator) parentElement;
				retValue = decorator.getLabelsToUpdate().toArray();
			}

			// else if (parentElement instanceof Label) {
			// Label label = (Label) parentElement;
			// RelativeValueProvider rvp = (RelativeValueProvider)
			// RelativeValueProviderAdapterFactory.INSTANCE
			// .adapt(label, RelativeValueProvider.class);
			// retValue = rvp.getProperties().toArray();
			// }
			return retValue;
		} // getChildren

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
		 */
		@SuppressWarnings("null")
		public Object getParent(Object element) {
			Object retValue = null;
			if (element instanceof ISelectionService) {
				retValue = null;
			} else if (element instanceof ISimulation) {
				retValue = ss;
			} else if (element instanceof Decorator) {
				Decorator decorator = (Decorator) element;
				retValue = decorator.eContainer().eContainer();
			}
			// if (element instanceof Label) {
			// Label label = (Label) element;
			// label.g
			// }
			return retValue;
		} // getParent

		/**
		 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
		 */
		public boolean hasChildren(Object element) {
			boolean retValue = false;
			if (element instanceof ISelectionService) {
				retValue = selectedSimulations != null
						&& selectedSimulations.size() > 0;
			} else if (element instanceof ISimulation) {
				final ISimulation simulation = (ISimulation) element;
				final Graph canonicalGraph = simulation.getScenario()
						.getCanonicalGraph();
				// Do we have a canonical Graph yet?
				if (canonicalGraph != null) {
					// Yes
					retValue = canonicalGraph.getDecorators().size() > 0;
				} // if
			} else if (element instanceof Decorator) {
				Decorator decorator = (Decorator) element;
				retValue = decorator.getLabelsToUpdate().size() > 0;
			}

			// else if (element instanceof Label) {
			// Label label = (Label) element;
			// RelativeValueProvider rvp = (RelativeValueProvider)
			// RelativeValueProviderAdapterFactory.INSTANCE
			// .adapt(label, RelativeValueProvider.class);
			// retValue = rvp != null && rvp.getProperties().size() > 0;
			// }
			return retValue;
		} // hasChildren

		/**
		 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
		 *      org.eclipse.jface.viewers.ISelection)
		 */
		public void selectionChanged(IWorkbenchPart part, ISelection selection) {

			// Is this selection changed event coming from our view?
			if (part != RelativeValueViewExample.this) {
				// No
				// This will hold the new simulations that have been selected
				final List<ISimulation> temp = new ArrayList<ISimulation>();

				// Is it a structured selection?
				if (selection instanceof IStructuredSelection) {
					// Yes
					final List list = ((IStructuredSelection) selection)
							.toList();

					// Go through everything in the list of things that were
					// selected and pick out the ones that are ISimulations.
					for (final Iterator selectionIter = list.iterator(); selectionIter
							.hasNext();) {
						final Object obj = selectionIter.next();
						if (obj instanceof ISimulation) {
							temp.add((ISimulation) obj);
						}
					} // for each selected item
				} // if structured selection

				// Did we find any new simulations that were selected?
				if (temp.size() > 0) {
					// Yes
					// Tell the ListViewer not to redraw while we're changing
					// its list.
					viewer.getTree().setRedraw(false);
					try {
						// Do we have any old selections we should remove?
						if (selectedSimulations != null) {
							// Yes
							viewer.remove(selectedSimulations.toArray());
						}
						// Add the new selections to the ListViewer's list. It
						// will use the label provider to get a text string for
						// each one.
						viewer.add(ss, temp.toArray());

						// Remember what we added this time so we can remove it
						// next selection.
						selectedSimulations = temp;
					} // try
					finally {
						// The ListViewer should update itself now.
						viewer.getTree().setRedraw(true);
					}
				} // if any new simulations selected
			} // if selection changed event coming from our view?

		} // selectionChanged

	} // RelativeValueViewContentProvider

	/**
	 * This class is a Label provider
	 */
	public static class RelativeValueViewLabelProvider implements ILabelProvider,
			ITableLabelProvider, ITableColorProvider {

		private final List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(@SuppressWarnings("unused")
		Object element) {
			return null;
		} // getImage

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object element) {
			String retValue = "";
			if (element instanceof ISelectionService) {
				retValue = "Active Simulations";
			} else if (element instanceof ISimulation) {
				ISimulation simulation = (ISimulation) element;
				retValue = simulation.getName() + " ("
						+ simulation.getSequenceNumber() + ")";
			} else if (element instanceof Decorator) {
				Decorator decorator = (Decorator) element;
				// final String title = decorator.getDublinCore().getTitle();
				// final StringBuilder sb = new StringBuilder();
				retValue = decorator.toString();
			} else if (element instanceof NodeLabel) {
				NodeLabel nodeLabel = (NodeLabel) element;
				retValue = nodeLabel.getNode().getDublinCore().getTitle();
				retValue = retValue == null ? "Label" : retValue;
			} else if (element instanceof ItemPropertyDescriptor) {
				ItemPropertyDescriptor property = (ItemPropertyDescriptor) element;
				retValue = property.getDisplayName(null);
			}
			return retValue;
		} // getText

		/**
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object,
		 *      int)
		 */
		public Image getColumnImage(@SuppressWarnings("unused")
		Object element, @SuppressWarnings("unused")
		int columnIndex) {
			return null;
		} // getColumnImage

		/**
		 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object,
		 *      int)
		 */
		public String getColumnText(Object element, int columnIndex) {
			String retValue = "";
			if (columnIndex == 0 && element instanceof ISelectionService) {
				retValue = "Active Simulations";
			} else if (columnIndex == 0 && element instanceof ISimulation) {
				ISimulation simulation = (ISimulation) element;
				retValue = simulation.getName() + " ("
						+ simulation.getSequenceNumber() + ")";
			} else if (columnIndex == 1 && element instanceof Decorator) {
				Decorator decorator = (Decorator) element;
				// final String title = decorator.getDublinCore().getTitle();
				// final StringBuilder sb = new StringBuilder();
				retValue = decorator.toString();
			} else if (columnIndex == 2 && element instanceof NodeLabel) {
				NodeLabel nodeLabel = (NodeLabel) element;
				retValue = nodeLabel.getNode().getDublinCore().getTitle();
				retValue = retValue == null ? "Node" : retValue;
			}

			else if (columnIndex == 3 && element instanceof NodeLabel) {
				NodeLabel nodeLabel = (NodeLabel) element;
				retValue = nodeLabel.getCurrentValue().toString();
			} // else index = 3 && NodeLabel

			else if (columnIndex == 4 && element instanceof NodeLabel) {
				
				RelativeValueProvider rvp = (RelativeValueProvider) RelativeValueProviderAdapterFactory.INSTANCE
						.adapt(element, RelativeValueProvider.class);
				// Does the label have relative values?
				if (rvp != null) {
					// Yes

					final StringBuilder sb = new StringBuilder();
					for (Iterator propertyIter = rvp.getProperties().iterator(); propertyIter
							.hasNext();) {
						ItemPropertyDescriptor property = (ItemPropertyDescriptor) propertyIter
								.next();
						sb.append(property.getDisplayName(property));
						sb.append(": ");

						sb.append(getFormatter().format(
								rvp.getRelativeValue(property)));

						if (propertyIter.hasNext()) {
							sb.append(", ");
						}
					} // for each property
					retValue = sb.toString();
				} // if
				else {
					retValue = "";
				}
			} // else index = 4 && NodeLabel

			return retValue;
		} // getColumnText

		/**
		 * @see org.eclipse.jface.viewers.ITableColorProvider#getBackground(java.lang.Object,
		 *      int)
		 */
		public Color getBackground(@SuppressWarnings("unused")
		Object element, @SuppressWarnings("unused")
		int columnIndex) {
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.ITableColorProvider#getForeground(java.lang.Object,
		 *      int)
		 */
		public Color getForeground(@SuppressWarnings("unused")
		Object element, @SuppressWarnings("unused")
		int columnIndex) {
			return null;
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 */
		public void dispose() {
			// TODO Auto-generated method stub
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
		 *      java.lang.String)
		 */
		public boolean isLabelProperty(@SuppressWarnings("unused")
		Object element, @SuppressWarnings("unused")
		String property) {
			return false;
		}

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void addListener(ILabelProviderListener listener) {
			listeners.add(listener);
		} // addListener

		/**
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void removeListener(ILabelProviderListener listener) {
			listeners.remove(listener);
		} // removeListener

	} // RelativeValueViewLabelProvider

	/**
	 * This class implements the sorting of the RelativeValue View viewer
	 */
	public static class RelativeValueViewSorter extends ViewerSorter {
		private static final int ASCENDING = 0;

		private static final int DESCENDING = 1;

		private int column = -1;

		private int direction = ASCENDING;

		/**
		 * @param column
		 *            the column to sort
		 */
		public void doSort(int column) {
			direction = this.column == column ? 1 - direction : ASCENDING;
			this.column = column;
		}

		/**
		 * @see org.eclipse.jface.viewers.ViewerComparator#compare(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			int rc = super.compare(viewer, e1, e2);
			if (direction == DESCENDING) {
				rc = -rc;
			}
			return rc;
		} // compare

	} // RelativeValueViewSorter
} // RelativeValueViewExample
