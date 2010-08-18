// UtilityView.java
package org.eclipse.stem.sample;

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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProvider;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLongProviderAdapterFactory;
import org.eclipse.stem.definitions.adapters.spatial.geo.LatLong.Segment;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.ViewPart;

/**
 * This class is an example of how to run GUI code in Eclipse and monitor the
 * "selected" simulation, and how to extract the canonical graph from the
 * selected simulation and then extract data from it.
 * <p>
 * It creats an Eclipse "View" called "View Example1" that simply "dumps" the
 * latitude and longitude data extracted from the canonical graph to the view's
 * window. The example is simple, but it helps to understand how a JFace
 * "Viewer" (not the same as an Eclipse "View") works with content and label
 * providers.
 * <p>
 * There are three classes defined in this example. The first is the parent
 * class that is a <code>ViewPart</code> and implements what is seen in the
 * view's window in Eclipse. It contains a JFace <code>ListViewer</code> which
 * basically maintains a list of Objects and creates a display that prints a
 * descriptive text string for each one. The method
 * <code>createPartControl</code> is the code that initializes the SWT
 * graphics for the display of the view. It is passed an SWT
 * <code>Composite</code> instance called <code>parent</code> that is used
 * to "contain" the SWT/JFace elements of the view's that make up the display in
 * the view. The method does three things, it first creates the
 * <code>ListViewer</code> instance, giving the parent as an argument to the
 * constructer (this makes it part of the display), it then creates and passes
 * to the <code>ListViewer</code> the "Content" and "Label" providers it
 * needs. The Content and Label providers are the other two classes in this
 * example.
 * <p>
 * The content provider class is {@link UtilityViewContentProvider}, while not
 * complex, it may not be obvious what's it's doing. It's job is to maintain the
 * contents of the <code>ListViewer</code>'s internal list of things to
 * display. It performs the "Controler" job in an "MVC" architecture. In our
 * example, the content provider is an {@link ISelectionListener} which means it
 * has a <code>selectionChanged</code> method. The idea behind the method is
 * that it is called whenever the user "selects" something in the Eclipse
 * interface. This doesn't happen automatically, an instance of the class must
 * be registered with the Eclipse "selection service" that serves as a central
 * dispatcher for selections. This registration is done in the
 * <code>createPartControl</code> method of the parent class. When something
 * is selected and the method is called, it must filter out the selections and
 * ignore those that are not instances of {@link ISimulation}. When it does
 * find a simulation instance, it removes the current contents of the list
 * maintained by the <code>ListViewer</code> and adds the newly selected
 * instances. It then tells the viewer to redraw itself.
 * <p>
 * The label provider class is {@link UtilityViewLabelProvider} and is the
 * easiest to understand, its is used by the <code>ListViewer</code> to
 * generate a text string for any of the <code>Objects</code> (i.e.,
 * <code>ISimulation</code> instances) it contains. The method
 * {@link UtilityViewLabelProvider#getText(Object)} does this and in this
 * example does the work to extract the latitude and longitude data from the
 * canonical graph used in the simulation. Then it just returns that data as a
 * (long) string to be displayed.
 * 
 * To see the example in action, you need to:
 * <ol>
 * <li> Run STEM</li>
 * <li> Open the "View Example 1" view.
 * "Window->Show&nbsp;View->Other->STEM->View&nbsp;Example&nbsp;1"</li>
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
 * select that simulation and the latitude/longitude data for that scenario will
 * appear in the View Example 1 view as a single (long) string. </li>
 * </ol>
 * If you double-click on another plugged-in Scenario so that two entries are
 * displayed in the Active Simulations view and the you select both, you'll see
 * two entries in the View Example 1 view, one for each of the selected
 * simulations.
 * 
 */
public class UtilityView extends ViewPart {

	/**
	 * The identifier of the View Example1 View. Nobody uses this right now, but
	 * it would be useful if we wanted to programmatically add this view to a
	 * perspective.
	 */
	public static final String ID_VIEW_EXAMPLE1_VIEW = "org.eclipse.stem.sample.adapters.UtilityView";

	/**
	 * This is the {@link ListViewer} that creates the display that will show up
	 * in the view's window. It contains a list of Objects, which in this
	 * example's case will be instances of ISimulation.
	 */
	protected ListViewer lv = null;

	/**
	 * This method is called when the view is created and it has the
	 * responsibility for doing all of the initialization. It creates the
	 * {@link ListViewer} and instances of the ContentProvider and
	 * {@link LabelProvider} for the viewer. It also gets a reference to the
	 * selection service and registers the content provider so it will be
	 * notified when something is selected.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		// Create the content provider
		UtilityViewContentProvider contentProvider = new UtilityViewContentProvider();
		// Create the ListViewer
		lv = new ListViewer(parent);

		// Let the ListViewer know who its content and label providers are
		lv.setContentProvider(contentProvider);
		lv.setLabelProvider(new UtilityViewLabelProvider());

		// This call tells the viewer's content provider where it should get the
		// source of its content. In this case it is the selection service.
		lv.setInput(getSite().getWorkbenchWindow().getSelectionService());

		// We also want to be able to have a user select a simulation from our
		// view and have that be seen by others. So we register the ListViewer
		// instance as the view's selection provider. When you click on the view
		// in the interface it finds the underlying Object (i.e., ISimulation)
		// you selected and passes it to the selection service.
		getSite().setSelectionProvider(lv);

	} // createPartControl

	/**
	 * This is required by the interface, but we're not using it.
	 * 
	 * @see org.eclipse.ui.part.WorkbenchPart#setFocus()
	 */
	@Override
	public void setFocus() {
		// Nothing
	} // setFocus

	/**
	 * This class is the content provider for the view. It is also a selection
	 * listener and uses the selection service as the source of its input. It
	 * looks for selected {@link ISimulation} instances and updates the list in
	 * the view's {@link ListViewer} instance with the current selection.
	 */
	public class UtilityViewContentProvider implements
			IStructuredContentProvider, ISelectionListener {

		// We remember the ListViewer that we're providing content for because
		// we need to manipulate its list in the method selectionChanged.
		private ListViewer viewer = null;

		// These are the simulations we added to the ListViewer, we remember
		// these so we can remove them when a different set of simulations is
		// selected.
		private List<ISimulation> selectedSimulations = null;

		/**
		 * This is used by the ListViewer to get the initial list of ISimulation
		 * instances.
		 * 
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 */
		public Object[] getElements(
				@SuppressWarnings("unused") Object inputElement) {
			Object[] retValue = new Object[] {};

			// Anything yet?
			if (selectedSimulations != null) {
				// Yes
				retValue = selectedSimulations.toArray();
			}
			return retValue;
		} // getElements

		/**
		 * This is called when the view is closed, we could remove ourselves as
		 * a selection service listener, but this is really for cleaning up SWT
		 * things. The method inputChanged will be called before dispose when
		 * the view is closed, we remove ourselves from the selection service
		 * there.
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 */
		public void dispose() {
			// Nothing to do
		} // dispose

		/**
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer,
		 *      java.lang.Object, java.lang.Object)
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			// We remember the ListViewer we're providing content for because
			// we'll have to change the list of things it contains in the
			// selectionChanged method.
			this.viewer = (ListViewer) viewer;

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
				final ISelectionService ss = (ISelectionService) newInput;
				ss.addPostSelectionListener(this);
			}

		} // inputChanged

		/**
		 * This method is called whenever ANYTHING is selected in the Eclipse
		 * workbench. It's job is to filter out selections of
		 * {@link ISimulation} instances and update the list in the
		 * {@link ListViewer}.
		 * 
		 * @see org.eclipse.ui.ISelectionListener#selectionChanged(org.eclipse.ui.IWorkbenchPart,
		 *      org.eclipse.jface.viewers.ISelection)
		 */
		public void selectionChanged(final IWorkbenchPart part,
				final ISelection selection) {

			// Is this selection changed event coming from our view?
			if (part != UtilityView.this) {
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
					viewer.getList().setRedraw(false);
					try {
						// Do we have any old selections we should remove?
						if (selectedSimulations != null) {
							// Yes
							viewer.remove(selectedSimulations.toArray());
						}
						// Add the new selections to the ListViewer's list. It
						// will use the label provider to get a text string for
						// each one.
						viewer.add(temp.toArray());

						// Remember what we added this time so we can remove it
						// next selection.
						selectedSimulations = temp;
					} // try
					finally {
						// The ListViewer should update itself now.
						viewer.getList().setRedraw(true);
					}
				} // if any new simulations selected
			} // if selection changed event coming from our view?
		} // selectionChanged

	} // UtilityViewContentProvider

	/**
	 * This class is the label provider for the view. It is used by the
	 * ListViewer to convert ISimulation instances to text strings.
	 */
	public static class UtilityViewLabelProvider implements ILabelProvider {

		/**
		 * This is called by the {@link ListViewer} for each {@link Object} in
		 * its list to generate a text {@link String} that represents that
		 * {@link Object}. This implementation digs into the {@link Simulation}
		 * to get the {@link Scenario} and then from that it obtains the
		 * canonical {@link Graph}. It then goes through the {@link Node}s of
		 * the {@link Graph} and using a {@link LatLongProviderAdapterFactory}
		 * creates a {@link LatLongProvider} for each {@link Node} that can
		 * return the latitude and longitude data of the {@link Node}. That
		 * data is just turned into a string and returned as the textual
		 * representation of the {@link Simulation}.
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		public String getText(Object element) {
			final StringBuilder sb = new StringBuilder();

			// Extract the scenario and then the canonical graph
			final ISimulation simulation = (ISimulation) element;
			final Scenario scenario = simulation.getScenario();
			final Graph canonicalGraph = scenario.getCanonicalGraph();

			// Get the nodes from the graph and iterate through them. Note that
			// the getNodes call returns a Map instance where the keys are the
			// URI's of the Node instances. We get the values of the map to
			// iterate through the nodes.
			// Map<String,Rectangle[]> map = new HashMap<String,Rectangle[]>();
			for (final Iterator nodeIter = canonicalGraph.getNodes().values()
					.iterator(); nodeIter.hasNext();) {
				final Node node = (Node) nodeIter.next();

				// We'd like to have access to lat/long data of the node if
				// there is any, to do that we use a factory to create an
				// adapter that knows about the inner details of nodes (it
				// really knows about all Identifiables) and implements the
				// LatLongProvider interface.
				final LatLongProvider latLongProvider = (LatLongProvider) LatLongProviderAdapterFactory.INSTANCE
						.adapt(node, LatLongProvider.class);

				// The node may or may not have lat/long data associated with
				// it, if it doesn't the list that's returned will be empty.
				final LatLong latLong = latLongProvider.getLatLong();

				// String name = node.getDublinCore().getIdentifier();
				// NeighborUtility.setBBox(map,name,latLong);

				// Now we just go through each segment and create a string.
				for (Segment segment : latLong.getSegments()) {

					sb.append(createStringOfLatLongData(segment));
					sb.append("///");
				} // for
			} // for
			// NeighborUtility.processBBox(map);
			// Now if we didn't find any lat/long data, we just return a simple
			// response. This will appear in the view instead of the data.
			String retValue = sb.toString();
			retValue = retValue.length() == 0 ? "No Lat/Long Data" : retValue;

			return retValue;
		} // getText

		/**
		 * We don't have any images associated with {@link Simulation}, but if
		 * we did we'd return them here. Returning null just tells the caller
		 * that there are no images.
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 */
		public Image getImage(@SuppressWarnings("unused") Object element) {
			return null;
		} // getImage

		/**
		 * Required by the interface, but not used by us.
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void addListener(
				@SuppressWarnings("unused") ILabelProviderListener listener) {
			// nothing
		}

		/**
		 * Required by the interface, but not used by us.
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 */
		public void dispose() {
			// nothing
		}

		/**
		 * Required by the interface, but not used by us.
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
		 *      java.lang.String)
		 */
		public boolean isLabelProperty(
				@SuppressWarnings("unused") Object element,
				@SuppressWarnings("unused") String property) {
			return false;
		}

		/**
		 * Required by the interface, but not used by us.
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 */
		public void removeListener(
				@SuppressWarnings("unused") ILabelProviderListener listener) {
			// nothing
		}
	} // UtilityViewLabelProvider

	/**
	 * @param segment
	 * @return a string of the lat/long points
	 */
	public static String createStringOfLatLongData(final Segment segment) {
		final StringBuilder sb = new StringBuilder();
		final int size = segment.size();
		for (int i = 0; i < size; i++) {
			sb.append("(");
			sb.append(segment.latitude(i));
			sb.append(", ");
			sb.append(segment.longitude(i));
			sb.append(")");
		} // for each lat/long pair
		return sb.toString();
	} // createStringOfLatLongData
} // UtilityView
