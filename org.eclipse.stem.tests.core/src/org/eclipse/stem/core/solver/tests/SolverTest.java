package org.eclipse.stem.core.solver.tests;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.Calendar;

import junit.textui.TestRunner;

import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.tests.IdentifiableTest;
import org.eclipse.stem.core.model.Decorator;
import org.eclipse.stem.core.model.ModelFactory;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.tests.ModelTest;
import org.eclipse.stem.core.scenario.Scenario;
import org.eclipse.stem.core.scenario.ScenarioFactory;
import org.eclipse.stem.core.sequencer.Sequencer;
import org.eclipse.stem.core.sequencer.impl.SequencerImpl;
import org.eclipse.stem.core.solver.Solver;
import org.eclipse.stem.core.solver.SolverFactory;
import org.eclipse.stem.solvers.fd.FdFactory;
import org.eclipse.stem.solvers.fd.impl.FiniteDifferenceImpl;
import org.eclipse.stem.tests.util.decorators.DecoratorsFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Solver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.stem.core.solver.Solver#step(org.eclipse.stem.core.model.STEMTime, long, int) <em>Step</em>}</li>
 *   <li>{@link org.eclipse.stem.core.solver.Solver#reset() <em>Reset</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class SolverTest extends IdentifiableTest {

	/**
	 * URI for the Solver
	 */
	public static URI SOLVER_URI = STEMURI.createURI("solver/solverTest.solver");
	
	/**
	 * URI for the Sequencer in the Scenario
	 */
	private static final URI SEQUENCER_URI = URI.createURI("SEQUENCER/sequencer1.sequencer");


	/**
	 * URI for the Decorator in the test scenario
	 */
	private static final URI DECORATOR_URI = URI.createURI("decorator/decorator1.decorator");
		

	/**
	 * This is the title of the test scenario.
	 */
	public static final String TEST_SCENARIO_TITLE = "Test Scenario #1";

	@SuppressWarnings("unused")
	private static final URI SCENARIO_SERIALZATION_TEST_URI = URI.createURI("temp/testscenario1.scenario");

	
	/**
	 * This is the URI that will be the Identifier of the scenario
	 */
	private static final URI SCENARIO_URI = URI.createURI("platform:/plugin/"
			+ org.eclipse.stem.core.tests.Activator.PLUGIN_ID
			+ "/data/solvers/basic/testsolver.solver");
	
	

	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(SolverTest.class);
	}

	/**
	 * Constructs a new Solver test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolverTest(String name) {
		super(name);
	}
	
	/**
	 * TODO Why did this method note get generated??
	 * @return a scenario
	 * @generated NOT
	 */
	public static Solver createFixture() {
		final Scenario scenario = ScenarioFactory.eINSTANCE.createScenario();
		scenario.setModel(ModelTest.createFixture());
		scenario.setSequencer(getTestSequencer());
		scenario.setURI(SCENARIO_URI);
		final Decorator decorator = DecoratorsFactory.eINSTANCE.createTestScenarioGraphDecorator1();
		decorator.setURI(DECORATOR_URI);
		scenario.getScenarioDecorators().add(decorator);
		scenario.getDublinCore().populate();
		scenario.getDublinCore().setTitle(TEST_SCENARIO_TITLE);
		
		//scenario.initialize();
		
		Solver solver = FdFactory.eINSTANCE.createFiniteDifference();
		solver.setDecorators(scenario.getScenarioDecorators());
		scenario.setSolver(solver);
		solver.getDublinCore().setTitle("Solver");
		
		// REQUIRED for SANITY
		// TODO this should probably be handled by default in the Factory create method
		// 		For all types of solvers
		solver.setURI(SOLVER_URI);
		solver.getDublinCore().setIdentifier(SOLVER_URI.toString());
		
		assertTrue(solver.sane());
		
		return solver;
	} // createFixture

	/**
	 * Returns the fixture for this Solver test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Solver getFixture() {
		return createFixture();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		Solver s = SolverFactory.eINSTANCE.createSolver();
		s.setURI(SOLVER_URI);
		setFixture(s);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.solver.Solver#step(org.eclipse.stem.core.model.STEMTime, long, int) <em>Step</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.solver.Solver#step(org.eclipse.stem.core.model.STEMTime, long, int)
	 * @generated
	 */
	public void testStep__STEMTime_long_int() {
		FiniteDifferenceImpl solver = (FiniteDifferenceImpl) getFixture();
		STEMTime time = ModelFactory.eINSTANCE.createSTEMTime();
		long timeDelta = 1;
		int cycle = 1;
		solver.step(time, timeDelta, cycle);
	}

	/**
	 * Tests the '{@link org.eclipse.stem.core.solver.Solver#reset() <em>Reset</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.solver.Solver#reset()
	 * @generated NOT
	 */
	public void testReset() {
		FiniteDifferenceImpl solver = (FiniteDifferenceImpl) getFixture();
		solver.reset();
		assertTrue(!solver.isInitialized());
	}

	

	
	/**
	 * Create an instance of STEMTime
	 * 
	 * @return the instance
	 */
	private static STEMTime createSTEMTime(final int year, final int month,
			final int day) {
		final STEMTime retValue = ModelFactory.eINSTANCE.createSTEMTime();

		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		retValue.setTime(calendar.getTime());
		return retValue;
	} // createSTEMTime
	
	
	
	/**
	 * @return a <code>Sequencer</code> for testing.
	 */
	private static Sequencer getTestSequencer() {
		final Sequencer retValue = new SequencerImpl() { 

			protected long timeIncrement = STEMTime.Units.DAY.getMilliseconds();

			/**
			 * This is an accumulator of the work increment that keeps account of 
			 * the fraction of the work increments until they exceed 1.0
			 */
			private double workIncrementRunningTotal = 0.0;


			public long getTimeIncrement() {
				return timeIncrement;
			}
			
			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#getNextTime()
			 */
			@Override
			public STEMTime getNextTime() {
				setCurrentTime(getCurrentTime().addIncrement(getTimeIncrement()));
				setWorkComplete(Math.min(getWorkComplete() + getWorkIncrement(), 100));
				return getCurrentTime();
			}

			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#getTimeDelta()
			 */
			@Override
			public long getTimeDelta() {
				return super.getTimeDelta();
			}

			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#getWorkIncrement()
			 */
			@Override
			public int getWorkIncrement() {
				int retValue = 0;
				// Is there a work increment?
				if (getDuration() != UNKNOWN_DURATION) {
					// Yes
					// The work increment could be fractional (<1.0). If so then it will
					// not accumulate in the progress monitor. So, we keep a running sum
					// of the work increment and when it exceeds 1.0 we return the value less
					// the fractional part and keep that for the future.
					workIncrementRunningTotal += 100.0 * getTimeIncrement()
							/ getDuration();
					
					// Do we have more than 1.0?
					if (workIncrementRunningTotal >= 1.0) {
						// Yes
						//$ANALYSIS-IGNORE
						retValue = (int)workIncrementRunningTotal;
						workIncrementRunningTotal -= retValue;
					}
				}

				return retValue;
			}

			/**
			 * @see org.eclipse.stem.core.scenario.impl.SequencerImpl#isTimeToStop()
			 */
			@Override
			public boolean isTimeToStop() {
				boolean retValue = false;
				// Is there an end time?
				if (getEndTime() != null) {
					// Yes
					retValue = getCurrentTime().getTime().after(getEndTime().getTime());
				}
				return retValue;
			}

			@Override
			public int getCycle() {
				return 0;
			}

			
		};
		retValue.setStartTime(createSTEMTime(2000, 01, 01));
		retValue.getCurrentTime();
		retValue.setEndTime(createSTEMTime(2000, 01, 10));
		retValue.setURI(SEQUENCER_URI);
		return retValue;
	} // getTestSequencer
	
	
} //SolverTest
