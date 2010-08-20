// RelativeValueHistoryPlotter.java
package org.eclipse.stem.ui.reports.views;

/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProvider;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapter;
import org.eclipse.stem.definitions.adapters.relativevalue.RelativeValueProviderAdapterFactory;
import org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.jobs.simulation.ISimulationListenerSync;
import org.eclipse.stem.jobs.simulation.Simulation;
import org.eclipse.stem.jobs.simulation.SimulationEvent;
import org.eclipse.stem.jobs.simulation.SimulationState;
import org.eclipse.stem.ui.reports.Activator;
import org.eclipse.stem.ui.reports.MonitorPreferences;
import org.eclipse.stem.ui.widgets.PropertySelector;
import org.eclipse.stem.ui.widgets.PropertySelector.PropertySelectionEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * This class is a SWT GUI component that uses BIRT to plot
 */
public class AggregateValueHistoryPlotter extends ReportControl implements ISimulationListenerSync {

	AggregateTimeSeriesCanvas aggregateSeriesCanvas;
	PropertySelector propertySelector;
	List<ItemPropertyDescriptor> selectedProperties;
	Set<ItemPropertyDescriptor> allProperties = new HashSet<ItemPropertyDescriptor>();
	Map<String,List<Double>> dataMap = new HashMap<String,List<Double>>();
	
	List<Double> aggregateReference = new ArrayList<Double>();
	Set<String> referenceIDs = new HashSet<String>();
	
	String selectedReferenceFile;
	
	HashMap<String, Set<RelativeValueProviderAdapter>> relativeValueProviderSet = new HashMap<String, Set<RelativeValueProviderAdapter>>();
	HashMap<String, Double> totalPopulation = new HashMap<String, Double>(); // key is population id
	/**
	 * this simulations graph
	 */
	Graph graph = null;
	int timeCount = 0;
	
	protected static final String REFERENCE_PROPERTY ="ref";
	Set<ISimulation> activeSimulations = new HashSet<ISimulation>();
	
	String populationId;
	
	/**
	 * This interface is implemented by classes that select out the properties
	 * to be displayed.
	 */
	public interface PropertySieve {
		/**
		 * @param dynamicLabel
		 *            the label that contains the candidate properties to be
		 *            displayed.
		 * @return a <code>List</code> of the properties that should be
		 *         displayed in the order that they should be displayed.
		 */
		List<ItemPropertyDescriptor> sieve(final DynamicLabel dynamicLabel);
	} // PropertySieve

	/**
	 * This sieve selects all of those properties that have relative values.
	 */
	private final PropertySieve propertySieve = new PropertySieve() {
		/**
		 * @see org.eclipse.stem.ui.widgets.PropertySelector.PropertySieve#sieve(org.eclipse.stem.core.graph.DynamicLabel)
		 */
		public List<ItemPropertyDescriptor> sieve(
				final DynamicLabel dynamicLabel) {
			final List<ItemPropertyDescriptor> retValue = new ArrayList<ItemPropertyDescriptor>();
			final RelativeValueProviderAdapter rvp = (RelativeValueProviderAdapter) RelativeValueProviderAdapterFactory.INSTANCE
					.adapt(dynamicLabel, RelativeValueProvider.class);

			// Does the label have relative values?
			if (rvp != null) {
				// Yes
				rvp.setTarget(dynamicLabel);

				for (final Object element : rvp.getProperties()) {
					final ItemPropertyDescriptor property = (ItemPropertyDescriptor) element;
					retValue.add(property);
				} // for each property
			} // if the label has relative values
			return retValue;
		} // sieve
	};

	/**
	 * @param parent
	 */
	public AggregateValueHistoryPlotter(final Composite parent) {
		super(parent, SWT.None);
		simulation = null;
		dataMap.put(REFERENCE_PROPERTY, aggregateReference); // put zeros for now
		createContents();
	} // RelativeValueHistoryPlotter

	/**
	 * Create the contents of the plotter
	 */
	private void createContents() {
		setLayout(new FormLayout());
		timeCount = 0;
		identifiableTitle = new Label(this, SWT.NONE);
		aggregateSeriesCanvas = new AggregateTimeSeriesCanvas(this);
		aggregateSeriesCanvas.reset();
		propertySelector = new PropertySelector(this, SWT.NONE, true);

		
		removeButton = new Button(this, SWT.NONE);
		removeButton.setText(REMOVE_TEXT);
		
		addReferenceLabel = new Label(this,SWT.BORDER);
		String refFile = Activator.getDefault().getPreferenceStore().getString(MonitorPreferences.REFERENCE_FILE_KEY);
		if(refFile == null) refFile = "";
		this.selectedReferenceFile = refFile;
		addReferenceLabel.setText(refFile);
		
		addReferenceButton = new Button(this, SWT.NONE);
		addReferenceButton.setText(ADD_REFERENCE_TEXT);
		final Shell shell = this.getShell();
		final AggregateValueHistoryPlotter self = this;
	    addReferenceButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(@SuppressWarnings("unused")
			final SelectionEvent e) {
				final FileDialog dd = new FileDialog(
						shell, SWT.OPEN);
					dd.setText(Messages.getString("REPORTVIEW.SELECTREFENCEFOLDER")); //$NON-NLS-1$
					dd.setFilterPath(addReferenceLabel.getText());
					final String selected = dd.open();
					self.selectedReferenceFile = selected;
					addReferenceLabel.setText(selected);
					Activator.getDefault().getPreferenceStore().setValue(MonitorPreferences.REFERENCE_FILE_KEY, selected);
					try {
						AggregateReferenceFileLoader refLoader = new AggregateReferenceFileLoader(selected);
						aggregateReference = refLoader.getAggregateData();
						dataMap.put(REFERENCE_PROPERTY, aggregateReference);
						//referenceIDs = refLoader.getIdSet();
						
					} catch (Exception ex) {
						System.out.println("error "+ex);
						ex.printStackTrace();
						Activator.logError(ex.getMessage(), ex);
					}	
			}
		});
		
		
		final FormData titleFormData = new FormData();
		identifiableTitle.setLayoutData(titleFormData);
		titleFormData.top = new FormAttachment(0, 0);
		titleFormData.left = new FormAttachment(0, 0);
		titleFormData.right = new FormAttachment(100, 0);

		final FormData chartFormData = new FormData();
		aggregateSeriesCanvas.setLayoutData(chartFormData);
		chartFormData.top = new FormAttachment(identifiableTitle, 0);
		chartFormData.bottom = new FormAttachment(propertySelector, 0);
		chartFormData.left = new FormAttachment(0, 0);
		chartFormData.right = new FormAttachment(100, 0);

		// Property Selector
		final FormData propertySelectorFormData = new FormData();
		// propertySelectorFormData.top = new FormAttachment(aggregateSeriesCanvas,
		// 0);
		propertySelectorFormData.bottom = new FormAttachment(100, 0);
		propertySelectorFormData.left = new FormAttachment(0, 0);
		propertySelectorFormData.right = new FormAttachment(30, 0);
		propertySelector.setLayoutData(propertySelectorFormData);

		// RemoveButton
		final FormData removeButtonFormData = new FormData();
		removeButtonFormData.bottom = new FormAttachment(100, 0);
		removeButtonFormData.left = new FormAttachment(propertySelector, 0);
		removeButtonFormData.right = new FormAttachment(60, 0);
		removeButton.setLayoutData(removeButtonFormData);
		
		// AddReferenceButton
		final FormData addReferenceButtonFormData = new FormData();
		addReferenceButtonFormData.bottom = new FormAttachment(removeButton, 0);
		addReferenceButtonFormData.left = new FormAttachment(removeButton, 0);
		addReferenceButtonFormData.right = new FormAttachment(100, 0);
		addReferenceButton.setLayoutData(addReferenceButtonFormData);
		
		// AddReferenceLabel
		final FormData addReferenceLabelFormData = new FormData();
		addReferenceLabelFormData.top = new FormAttachment(addReferenceButton, 0);
		addReferenceLabelFormData.left = new FormAttachment(removeButton, 0);
		addReferenceLabelFormData.right = new FormAttachment(100, 0);
		addReferenceLabel.setLayoutData(addReferenceLabelFormData);

		propertySelector
				.addPropertySelectionListener(new PropertySelector.PropertySelectionListener() {

					/**
					 * @see org.eclipse.stem.ui.widgets.PropertySelector.PropertySelectionListener#propertySelected(org.eclipse.stem.ui.widgets.PropertySelector.PropertySelectionEvent)
					 */
					public void propertySelected(
							final PropertySelectionEvent propertySelectionEvent) {
						selectedDecorator = propertySelectionEvent
								.getDecorator();

						selectedProperties = getPropertiesToDisplay(selectedDecorator);
						populationId = propertySelectionEvent.getId();
						
					}
				});

		removeButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(
					@SuppressWarnings("unused") final SelectionEvent e) {
				fireRemoveEvent(identifiable);
				remove();
			}
		});

	} // createContents

	/**
	 * to remove the control e.g. by a remove button event
	 */
	@Override
	@SuppressWarnings("cast")
	public void remove() {
		removeListeners.clear();
		switchToRVHP(null);
		relativeValueHistoryExtended(null);
		identifiableTitle.setText("");
		propertySelector
				.setDecorators((List<Decorator>) Collections.EMPTY_LIST);
		dispose();
	}

	/**
	 * Setting the {@link Simulation} has the side-effect of causing the control
	 * to remove itself as a listener from any previously set {@link Simulation}
	 * and adding itself as a listener to the new one. It will also cause the
	 * image to be initialized from the contents of the new {@link Simulation}
	 * as appropriate.
	 * 
	 * @param simulation the simulation whose aggregate we will plot.
	 */
	public final void setSimulation(final ISimulation simulation) {
		// Any need to switch?
		if (this.simulation == simulation) {
			// No
			return;
		} // if no need to switch?

		// Should we remove ourselves as listeners from the current simulation?
		if (this.simulation != null) {
			// Yes
			this.simulation.removeSimulationListenerSync(this);
		}

		this.simulation = simulation;

		selection = null;
		// Was there a new simulation to switch to?
		if (this.simulation != null) {
			// Yes
			this.simulation.addSimulationListenerSync(this);
			initializeFromSimulation(this.simulation);

			ArrayList<Decorator>decorators = new ArrayList<Decorator>();
			for(Decorator d:graph.getDecorators())
				if(d instanceof DiseaseModel)decorators.add(d);
			propertySelector.setDecorators(decorators);
			
			// collect the set of relativeValueProviderAdapters from this
			// simulation
			// 1. get the nodes
			Map<Node, Integer> nodeLevelsMap = getNodeLevels(simulation);

			// 2. get the level to sum
			int level = getHighestResolution(nodeLevelsMap);
			
			// 3. iterate over all the nodes at this level in the map and get a
			// set of relative value providers
			Iterator<Node> iter = getNodeIterator(level, nodeLevelsMap);
			while ((iter != null) && (iter.hasNext())) {
				Node node = iter.next();
				EList<NodeLabel> labels = node.getLabels();
				for (int i = 0; i < labels.size(); ++i) {
					NodeLabel label = labels.get(i);

					if (label instanceof DiseaseModelLabel) {
						DiseaseModelLabel dynamicLabel = (DiseaseModelLabel) label;
						final RelativeValueProviderAdapter rvp = (RelativeValueProviderAdapter) RelativeValueProviderAdapterFactory.INSTANCE
								.adapt(dynamicLabel,
										RelativeValueProvider.class);
						
						
						// Does the label have relative values?
						if (rvp != null) {
							// Yes
							rvp.setTarget(dynamicLabel);
							
							// Get the population identifier for the label
							String populationIdentifier = dynamicLabel.getPopulationModelLabel().getPopulationIdentifier();
							if(totalPopulation.get(populationIdentifier) != null)
								totalPopulation.put(populationIdentifier, totalPopulation.get(populationIdentifier)+rvp.getDenominator(null));
							else totalPopulation.put(populationIdentifier, rvp.getDenominator(null));
							// remember this rvp to use for aggregation later
							if(relativeValueProviderSet.containsKey(populationIdentifier))
								relativeValueProviderSet.get(populationIdentifier).add(rvp);
							else {
								relativeValueProviderSet.put(populationIdentifier, new HashSet<RelativeValueProviderAdapter>());
								relativeValueProviderSet.get(populationIdentifier).add(rvp);
							}
							for (final Object element : rvp.getProperties()) {
								final ItemPropertyDescriptor property = (ItemPropertyDescriptor) element;
								allProperties.add(property);
							} // for each property

						}// if rvp !null

					} // if dyanmicLabel
				}// For each node label
			} // while have nodes
			
			for(String p:totalPopulation.keySet())
				if(totalPopulation.get(p) <= 0.0) {
					totalPopulation.put(p, 1.0);
				}
		} else {
			// No
			// Just display a blank screen
			//initializeFromSimulation(null);
			relativeValueProviderSet.clear();
			allProperties.clear();
		}

	} // setSimulation

	
	/**
	 * @param identifiable
	 *            the {@link Identifiable} to be the source of the data to be
	 *            plotted.
	 */
	@Override
	public void setIdentifiable(final Identifiable identifiable) {

		//  do nothing. Aggregate values aggregate over a set of identifiables.
		//  See simulationChangedSync
	} // setIdentifiable

	/**
	 * @see org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryExtendedListener#relativeValueHistoryExtended(org.eclipse.stem.definitions.adapters.relativevalue.history.RelativeValueHistoryProviderAdapter)
	 */
	public void relativeValueHistoryExtended(
			@SuppressWarnings("unused") final RelativeValueHistoryProviderAdapter rvhp) {
		//not used
	} // relativeValueHistoryExtended

	/**
	 * Initialize the control from a
	 * {@link org.eclipse.stem.jobs.simulation.Simulation} instance.
	 * 
	 * @param simulation
	 *            the {@link org.eclipse.stem.jobs.simulation.Simulation}
	 *            whose state will be visualized in the control.
	 */
	@Override
	protected void initializeFromSimulation(final ISimulation simulation) {
		graph = simulation.getScenario().getCanonicalGraph();
		//timeProvider = (TimeProvider) TimeProviderAdapterFactory.INSTANCE.adapt(graph, TimeProvider.class);
		timeCount = 0;
		redraw();
	} // initializeFromSimulation

	/**
	 * 
	 */
	@Override
	public void refresh2() {
		// nothing
	} // refresh2
	
	/**
	 * The number of properties to plot
	 * @return the number of properties
	 */
	public int getNumProperties() {
		return dataMap.keySet().size();
	}

	/**
	 * TODO implement this
	 * @param index 
	 * @return the property to plot
	 */
	public String getProperty(int index) {
		Object[] keys = dataMap.keySet().toArray();
		Arrays.sort(keys);
		return (String) keys[index];
	}
	
	/**
	 * TODO implement this
	 * @param property 
	 * @return the aggregate values to plot as an array of double
	 */
	public double[] getValues(String property) {
		if(populationId == null) {
			double [] ret = new double[1];
			ret[0]=1;
			return ret;
		}
		List<Double> valList = dataMap.get(property);
		double[] data = new double[timeCount];
		for (int i = 0; i < timeCount; i ++) {
			if ((valList!=null)&&(i < valList.size()) ){
				data[i] = valList.get(i).doubleValue();
				if(property.equalsIgnoreCase(REFERENCE_PROPERTY)) {	
					data[i] /= totalPopulation.get(populationId);
				}
			} else {
				// never add zero (need min nonzero value for log display)
				data[i] = 1.0/totalPopulation.get(populationId);
			}
		}
		return data;
	}

	
	/**
	 * @param decorator
	 *            a {@link Decorator} that modifies the state of the canonical
	 *            {@link Graph} in the
	 *            {@link org.eclipse.stem.jobs.simulation.Simulation}.
	 * @param simulation
	 *            the {@link org.eclipse.stem.jobs.simulation.Simulation}
	 * @return a {@link List} of the properties of the {@link Decorator} that
	 *         can should be displayed.
	 */
	List<ItemPropertyDescriptor> getPropertiesToDisplay(
			final Decorator decorator) {
		final List<ItemPropertyDescriptor> retValue = new ArrayList<ItemPropertyDescriptor>();
		// Got Decorator?
		if (decorator != null) {
			// Yes
			// Are there any labels to update?
			if (!decorator.getLabelsToUpdate().isEmpty()) {
				// Yes
				// The first one is good enough
				retValue.addAll(propertySieve.sieve(decorator
						.getLabelsToUpdate().get(0)));
			} // if labels to update
		} // if got decorator
		return retValue;
	} // getPropertiesToDisplay

	/**
	 * 
	 * @param node
	 * @return
	 */
	@SuppressWarnings("unused")
	private Graph getGraph(final Node node) {
		return (Graph) node.eContainer().eContainer();
	} // getGraph

	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListenerSync#simulationChangedSync(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	public void simulationChangedSync(final SimulationEvent event) {
		// Data to log ?
		
		if (event.getSimulationState() == SimulationState.RUNNING) {
			// The simulation just started. Make sure we have data. If not, reload again
			if(this.selectedReferenceFile == null)
				this.selectedReferenceFile = Activator.getDefault().getPreferenceStore().getString(MonitorPreferences.REFERENCE_FILE_KEY);
			if(aggregateReference == null || aggregateReference.size() == 0) { 
				try { 
					AggregateReferenceFileLoader refLoader = new AggregateReferenceFileLoader(this.selectedReferenceFile);
					aggregateReference = refLoader.getAggregateData();
					dataMap.put(REFERENCE_PROPERTY, aggregateReference);
					referenceIDs = refLoader.getIdSet();
				} catch(Exception e) {
					Activator.logError(e.getMessage(), e);
				}
			}
//			if ((logWriter != null) && (logWriter.needsHeader)) {
//				// This will write the headers and the first line of data before first cycle
//				logWriter.logHeader(this.simulation, this.diseaseModel, this.nodeLevels, timeProvider);
//			}
		} else if(event.getSimulationState() == SimulationState.COMPLETED_CYCLE) {
			// cycle complete
			sumData();
			aggregateSeriesCanvas.draw();
			redraw();
			timeCount ++;
		} else 
		// Is the Simulation stopping (i.e. being deleted?)
		if (event.getSimulationState() == SimulationState.STOPPED) {
			// Yes
			if(simulation==event.getSimulation()) {
				activeSimulations.remove(simulation);
				simulation.removeSimulationListener(this);
				simulation.removeSimulationListenerSync(this);
				simulation = null;
				identifiableTitle.setText("");
				propertySelector.setDecorators(Collections.EMPTY_LIST);
				timeCount = 0;
			}
//			dispose();
		} else if ((simulation == event.getSimulation())&&(event.getSimulationState() == SimulationState.RESET)) {
			// Yes
			aggregateSeriesCanvas.resetData();
			timeCount = 0;
		} // if

	} // simulationChangedSync
	
	/**
	 * @see org.eclipse.stem.jobs.simulation.ISimulationListener#simulationChanged(org.eclipse.stem.jobs.simulation.SimulationEvent)
	 */
	@SuppressWarnings("cast")
	public void simulationChanged(final SimulationEvent event) {
		if ((simulation == event.getSimulation())&&(event.getSimulationState() == SimulationState.RESET)) {
			// Yes
			aggregateSeriesCanvas.resetData();
			timeCount = 0;
		} // if
		// Is the Simulation stopping (i.e. being deleted?)
		if (event.getSimulationState() == SimulationState.STOPPED) {
			// Yes
			if(simulation==event.getSimulation()) {
				activeSimulations.remove(simulation);
				simulation.removeSimulationListener(this);
				simulation.removeSimulationListenerSync(this);
				simulation = null;
				identifiableTitle.setText("");
				propertySelector.setDecorators((List<Decorator>) Collections.EMPTY_LIST);
				timeCount = 0;
			}
			
		} // if
		
		if (event.getSimulationState() == SimulationState.STOPPED) {
			// Yes
			if(simulation==event.getSimulation()) {
				activeSimulations.remove(simulation);
				simulation.removeSimulationListener(this);
				simulation.removeSimulationListenerSync(this);
				simulation = null;
				identifiableTitle.setText("");
				propertySelector.setDecorators((List<Decorator>) Collections.EMPTY_LIST);
				timeCount = 0;
			}
			
		} // if

	} // simulationChanged



	/**
	 * @see org.eclipse.swt.widgets.Widget#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		if (this.rvhp != null) {
			// Yes
			rvhp.removeExtensionListener(this);
		} // if
		if (simulation != null) {
			// Yes
			simulation.removeSimulationListener(this);
		} // if
	} // dispose

	/**
	 * @see org.eclipse.stem.ui.reports.views.ReportControl#getIdentifiable()
	 */
	@Override
	public Identifiable getIdentifiable() {
		// This report control is linked to a simulation NOT to an identifiable
		return null;
	}

	/**
	 * This Control is associated with a Simulation
	 * @see org.eclipse.stem.ui.reports.views.ReportControl#getControlType()
	 */
	public String getControlType() {
		return ReportControlFactory.SIMULATION_TYPE;
	}
	
	

	/**
	 * Must implement this method to aggregate data in run thread
	 * 
	 */
	public void sumData() {
		
		Iterator<ItemPropertyDescriptor> iter = allProperties.iterator();
		while((iter!=null)&&(iter.hasNext())) {
			ItemPropertyDescriptor property = iter.next();
			String propertyKey = property.getDisplayName(property);
			if(!dataMap.containsKey(propertyKey)) {
				List<Double> newData = new ArrayList<Double>();
				// just in case, populate the data list
				for (int i = 0; i < timeCount; i ++) {
					newData.add(i,new Double(0.0));
				}
				dataMap.put(propertyKey,newData);
			}
			
			// now loop through all nodes and integrate the data for this property
			double totPop = 0.0;
			double sum = 0.0;
			if(relativeValueProviderSet.get(populationId) != null) {
				Iterator<RelativeValueProviderAdapter> iter2 = relativeValueProviderSet.get(populationId).iterator();
				while((iter2 !=null) && (iter2.hasNext())) {
					RelativeValueProviderAdapter rvp = iter2.next();
					double nodePopulation = rvp.getDenominator(null);
					totPop += nodePopulation;
					sum += (nodePopulation * rvp.getRelativeValue(property));
				}
			}
			if(totPop<= 0.0) totPop = 1.0; // avoid divide by zeros
			totalPopulation.put(populationId, totPop);
			aggregateSeriesCanvas.setMinYscale(1.0/totalPopulation.get(populationId));
			sum /= totPop;
			List<Double> aggregateList = dataMap.get(propertyKey);
			// add the new data point
			aggregateList.add(timeCount,new Double(sum));
			dataMap.put(propertyKey, aggregateList);
		}
	}// sumdata
	
	
	
	/**
	 * 
	 * @param nodeLevels
	 * @return highest resolution level in map
	 */
	private int getHighestResolution(Map<Node, Integer>nodeLevels) {
		int retVal = -1;
		Collection<Integer>vals = nodeLevels.values();
		for(int level:vals) {
			if(level >= retVal) retVal = level;
		}
		return retVal;
	}
	

	
	/*
	 * Return all nodes at the same level
	 */
	@SuppressWarnings("boxing")
	private Iterator<Node> getNodeIterator(int level, Map<Node, Integer>nodeLevels) {
		ArrayList<Node> list = new ArrayList();
		//Set<Node>ns = nodeLevels.keySet();
		//for(Node n:ns) {
		for (Entry<Node,Integer> entry : nodeLevels.entrySet()) {
			if(entry.getValue() == level) {
				list.add(entry.getKey());
			}
		}
		return list.iterator();
	}
	
	
	
	/**
	 * Return all nodes and their corresponding level. We use this to log data using 
	 * different resolutions.
	 * 
	 * @param simulation
	 * @return Map with node and level
	 */
	@SuppressWarnings("boxing")
	public Map<Node, Integer> getNodeLevels(ISimulation simulation) {
		Map<Node, Integer> result = new HashMap<Node, Integer>();
		final Graph graph = simulation.getScenario().getCanonicalGraph();
		if (graph != null) {
			final EMap<URI,Node> allNodes = graph.getNodes();
			final Set<URI> allGraphURIs = allNodes.keySet();
		    Iterator<URI> graphIter2 = allGraphURIs.iterator();
		  
		    while((graphIter2!=null)&&(graphIter2.hasNext())) {
		    	URI uri = graphIter2.next();
		    	Node node = allNodes.get(uri);
		    	String id =  node.getURI().toString();
		    	int level = getAdminLevel(id);
		    	result.put(node, level);
		    }
		} // graph not null
		return result;
	}
	

	private int getAdminLevel(String uriKey) {
		int retVal = 0;
		String test = uriKey;
		while(test.contains("-")) {
			retVal ++;
			int idx1 = test.indexOf("-");
			String test2 = test.substring(idx1+1, test.length());
			test = test2;
		}
		return retVal;
	}
	
} // RelativeValueHistoryPlotter
