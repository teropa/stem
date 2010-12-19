package org.eclipse.stem.jobs.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
	private PersistentHashMap labels = PersistentHashMap.EMPTY;
	
	public SimulationHistory(Simulation sim) {
		this.simulation = sim;
		init();
	}

	private void init() {
		this.simulation.addSimulationListener(this);
		registerDynamicLabels();
	}

	private void registerDynamicLabels() {
		ITransientMap work = labels.asTransient();
		Iterator<EObject> contentIt = this.simulation.getScenario().getCanonicalGraph().eAllContents();
		while (contentIt.hasNext()) {
			EObject nxt = contentIt.next();
			if (nxt instanceof DynamicLabel) {
				DynamicLabel label = (DynamicLabel)nxt;
				work = work.assoc(label, new DynamicLabelState(label.getCurrentValue(), label.getNextValue()));
			}
		}
		labels = (PersistentHashMap)work.persistent();
	}
	
	public void simulationChanged(SimulationEvent event) {
		System.out.println(simulation.getScenario().getSequencer().getCurrentTime());
		ITransientMap work = labels.asTransient();
		for (Object entry : labels.entrySet()) {
			DynamicLabel label = (DynamicLabel)((Map.Entry)entry).getKey();
			DynamicLabelState state = (DynamicLabelState)((Map.Entry)entry).getValue();
			if (!state.matches(label)) {
				work.assoc(label, new DynamicLabelState(label.getCurrentValue(), label.getNextValue()));
			}
		}
		labels = (PersistentHashMap)work.persistent();
	}

	private Set<DynamicLabel> getChangedLabels() {
		Set<DynamicLabel> changed = new HashSet<DynamicLabel>();
		for (Object entry : labels.entrySet()) {
			DynamicLabel label = (DynamicLabel)((Map.Entry)entry).getKey();
			DynamicLabelState state = (DynamicLabelState)((Map.Entry)entry).getValue();
			if (!state.matches(label)) {
				changed.add(label);
			}
		}
		return changed;
	}
	
}
