package org.eclipse.stem.server;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.sequencer.Sequencer;

public class SimulationRun implements Runnable {

	private final Scenario scenario;
	private final CDOTransaction tx;

	public SimulationRun(Scenario scenarioToRun, CDOSession activeSession) {
		tx = activeSession.openTransaction();
		scenario = tx.getObject(scenarioToRun);
	}

	public void run() {
		try {
			scenario.addDecoratorAdaptors();
			final Sequencer sequencer = scenario.getSequencer();

			System.out.println("running simulation");
			System.out.println("seq start "+sequencer.getStartTime());
			System.out.println("seq end "+sequencer.getEndTime());

			while (!sequencer.isTimeToStop()) {
				assert scenario.sane();

				final STEMTime currentTime = sequencer.getCurrentTime();
				System.out.println("running at "+currentTime);

				if(scenario.getSolver().getDecorators() == null) scenario.getSolver().setDecorators(scenario.getCanonicalGraph().getDecorators());
				if(!scenario.getSolver().isInitialized()) {
					scenario.getSolver().initialize(sequencer.getNextTime());
				}

				scenario.step();

				try {
					tx.commit();
				} catch (CommitException ce) {
					throw new SimulationRunException(ce);
				}
			}
			System.out.println("ran simulation");
		} finally {
			tx.close();
		}
	}

}
