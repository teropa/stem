package org.eclipse.stem.jobs.simulation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.LabelValue;

import clojure.lang.ITransientMap;
import clojure.lang.PersistentHashMap;

public class SimulationHistory implements ISimulationListener {
	
	private static class DynamicLabelState {
		public final LabelValue current;
		public final LabelValue next;
		
		public DynamicLabelState(LabelValue current, LabelValue next) {
			this.current = current;
			this.next = next;
		}

		public boolean matches(DynamicLabel label) {
			return currentMatches(label) && nextMatches(label);
		}

		private boolean currentMatches(DynamicLabel label) {
			return (current == null ? label.getCurrentValue() == null : EcoreUtil.equals(current, label.getCurrentValue()));
		}
		
		private boolean nextMatches(DynamicLabel label) {
			return (next == null ? label.getNextValue() == null : EcoreUtil.equals(next, label.getNextValue()));
		}
	}
	
	private final Simulation simulation;
	
	private PersistentHashMap currentLabels = PersistentHashMap.EMPTY;
	private Map<Integer, PersistentHashMap> labelHistory = new HashMap<Integer, PersistentHashMap>();
	
	public SimulationHistory(Simulation sim) {
		this.simulation = sim;
		init();
	}

	private void init() {
		this.simulation.addSimulationListener(this);
		registerDynamicLabels();
	}

	private void registerDynamicLabels() {
		Iterator<EObject> contentIt = this.simulation.getScenario().getCanonicalGraph().eAllContents();
		ITransientMap workingCopy = currentLabels.asTransient();
		while (contentIt.hasNext()) {
			EObject nxt = contentIt.next();
			if (nxt instanceof DynamicLabel) {
				DynamicLabel label = (DynamicLabel)nxt;
				workingCopy = workingCopy.assoc(label, new DynamicLabelState(label.getCurrentValue(), label.getNextValue()));
			}
		}
		currentLabels = (PersistentHashMap)workingCopy.persistent();
	}
	
	public void simulationChanged(SimulationEvent event) {
		if (event.getSimulationState() == SimulationState.COMPLETED_CYCLE) {
			System.out.println(simulation.getScenario().getSequencer().getCycle());
			currentLabels = getNewLabels();
			labelHistory.put(new Integer(simulation.getScenario().getSequencer().getCycle()), currentLabels);
		}
	}
	
	private PersistentHashMap getNewLabels() {
		ITransientMap workingCopy = currentLabels.asTransient();
		for (Object entry : currentLabels.entrySet()) {
			DynamicLabel label = (DynamicLabel)((Map.Entry)entry).getKey();
			DynamicLabelState state = (DynamicLabelState)((Map.Entry)entry).getValue();
			if (!state.matches(label)) {
				workingCopy = workingCopy.assoc(label, new DynamicLabelState(label.getCurrentValue(), label.getNextValue()));
			}
		}
		return (PersistentHashMap)workingCopy.persistent();
	}
	
}
