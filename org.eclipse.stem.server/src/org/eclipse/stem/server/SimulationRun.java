package org.eclipse.stem.server;

import org.eclipse.emf.cdo.session.CDOSession;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.util.CommitException;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.sequencer.Sequencer;

public class SimulationRun implements Runnable {

	private Scenario scenario;
	private final CDOSession activeSession;

	public SimulationRun(Scenario scenarioToRun, CDOSession activeSession) {
		this.activeSession = activeSession;
		this.scenario = scenarioToRun;
	}

	public void run() {
		CDOTransaction tx = activeSession.openTransaction();
		try {
			scenario = tx.getObject(scenario);
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
		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			tx.close();
		}
	}

}
