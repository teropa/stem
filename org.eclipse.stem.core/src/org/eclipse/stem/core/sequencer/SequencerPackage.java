package org.eclipse.stem.core.sequencer;

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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.stem.core.common.CommonPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.stem.core.sequencer.SequencerFactory
 * @model kind="package"
 * @generated
 */
public interface SequencerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sequencer"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/eclipse/stem/core/sequencer.ecore"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.stem.core.sequencer"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SequencerPackage eINSTANCE = org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl <em>Sequencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.sequencer.impl.SequencerImpl
	 * @see org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl#getSequencer()
	 * @generated
	 */
	int SEQUENCER = 1;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__URI = CommonPackage.IDENTIFIABLE__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__TYPE_URI = CommonPackage.IDENTIFIABLE__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__DUBLIN_CORE = CommonPackage.IDENTIFIABLE__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__START_TIME = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__END_TIME = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Current Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__CURRENT_TIME = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Next Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__NEXT_TIME = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Time Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__TIME_DELTA = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__DURATION = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Time To Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__TIME_TO_STOP = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Work Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__WORK_COMPLETE = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Work Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__WORK_INCREMENT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER__CYCLE = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 9;

	/**
	 * The number of structural features of the '<em>Sequencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENCER_FEATURE_COUNT = CommonPackage.IDENTIFIABLE_FEATURE_COUNT + 10;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.sequencer.impl.SequentialSequencerImpl <em>Sequential Sequencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.sequencer.impl.SequentialSequencerImpl
	 * @see org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl#getSequentialSequencer()
	 * @generated
	 */
	int SEQUENTIAL_SEQUENCER = 2;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__URI = SEQUENCER__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__TYPE_URI = SEQUENCER__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__DUBLIN_CORE = SEQUENCER__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__START_TIME = SEQUENCER__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__END_TIME = SEQUENCER__END_TIME;

	/**
	 * The feature id for the '<em><b>Current Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__CURRENT_TIME = SEQUENCER__CURRENT_TIME;

	/**
	 * The feature id for the '<em><b>Next Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__NEXT_TIME = SEQUENCER__NEXT_TIME;

	/**
	 * The feature id for the '<em><b>Time Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__TIME_DELTA = SEQUENCER__TIME_DELTA;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__DURATION = SEQUENCER__DURATION;

	/**
	 * The feature id for the '<em><b>Time To Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__TIME_TO_STOP = SEQUENCER__TIME_TO_STOP;

	/**
	 * The feature id for the '<em><b>Work Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__WORK_COMPLETE = SEQUENCER__WORK_COMPLETE;

	/**
	 * The feature id for the '<em><b>Work Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__WORK_INCREMENT = SEQUENCER__WORK_INCREMENT;

	/**
	 * The feature id for the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__CYCLE = SEQUENCER__CYCLE;

	/**
	 * The feature id for the '<em><b>Time Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER__TIME_INCREMENT = SEQUENCER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sequential Sequencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEQUENTIAL_SEQUENCER_FEATURE_COUNT = SEQUENCER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.stem.core.sequencer.impl.RealTimeSequencerImpl <em>Real Time Sequencer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.stem.core.sequencer.impl.RealTimeSequencerImpl
	 * @see org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl#getRealTimeSequencer()
	 * @generated
	 */
	int REAL_TIME_SEQUENCER = 0;

	/**
	 * The feature id for the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__URI = SEQUENTIAL_SEQUENCER__URI;

	/**
	 * The feature id for the '<em><b>Type URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__TYPE_URI = SEQUENTIAL_SEQUENCER__TYPE_URI;

	/**
	 * The feature id for the '<em><b>Dublin Core</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__DUBLIN_CORE = SEQUENTIAL_SEQUENCER__DUBLIN_CORE;

	/**
	 * The feature id for the '<em><b>Start Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__START_TIME = SEQUENTIAL_SEQUENCER__START_TIME;

	/**
	 * The feature id for the '<em><b>End Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__END_TIME = SEQUENTIAL_SEQUENCER__END_TIME;

	/**
	 * The feature id for the '<em><b>Current Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__CURRENT_TIME = SEQUENTIAL_SEQUENCER__CURRENT_TIME;

	/**
	 * The feature id for the '<em><b>Next Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__NEXT_TIME = SEQUENTIAL_SEQUENCER__NEXT_TIME;

	/**
	 * The feature id for the '<em><b>Time Delta</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__TIME_DELTA = SEQUENTIAL_SEQUENCER__TIME_DELTA;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__DURATION = SEQUENTIAL_SEQUENCER__DURATION;

	/**
	 * The feature id for the '<em><b>Time To Stop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__TIME_TO_STOP = SEQUENTIAL_SEQUENCER__TIME_TO_STOP;

	/**
	 * The feature id for the '<em><b>Work Complete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__WORK_COMPLETE = SEQUENTIAL_SEQUENCER__WORK_COMPLETE;

	/**
	 * The feature id for the '<em><b>Work Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__WORK_INCREMENT = SEQUENTIAL_SEQUENCER__WORK_INCREMENT;

	/**
	 * The feature id for the '<em><b>Cycle</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__CYCLE = SEQUENTIAL_SEQUENCER__CYCLE;

	/**
	 * The feature id for the '<em><b>Time Increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER__TIME_INCREMENT = SEQUENTIAL_SEQUENCER__TIME_INCREMENT;

	/**
	 * The number of structural features of the '<em>Real Time Sequencer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_TIME_SEQUENCER_FEATURE_COUNT = SEQUENTIAL_SEQUENCER_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.sequencer.RealTimeSequencer <em>Real Time Sequencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Time Sequencer</em>'.
	 * @see org.eclipse.stem.core.sequencer.RealTimeSequencer
	 * @generated
	 */
	EClass getRealTimeSequencer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.sequencer.Sequencer <em>Sequencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequencer</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer
	 * @generated
	 */
	EClass getSequencer();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.sequencer.Sequencer#getStartTime <em>Start Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start Time</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getStartTime()
	 * @see #getSequencer()
	 * @generated
	 */
	EReference getSequencer_StartTime();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.sequencer.Sequencer#getEndTime <em>End Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End Time</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getEndTime()
	 * @see #getSequencer()
	 * @generated
	 */
	EReference getSequencer_EndTime();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.stem.core.sequencer.Sequencer#getCurrentTime <em>Current Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Current Time</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getCurrentTime()
	 * @see #getSequencer()
	 * @generated
	 */
	EReference getSequencer_CurrentTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.stem.core.sequencer.Sequencer#getNextTime <em>Next Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Time</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getNextTime()
	 * @see #getSequencer()
	 * @generated
	 */
	EReference getSequencer_NextTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.sequencer.Sequencer#getTimeDelta <em>Time Delta</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Delta</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getTimeDelta()
	 * @see #getSequencer()
	 * @generated
	 */
	EAttribute getSequencer_TimeDelta();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.sequencer.Sequencer#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getDuration()
	 * @see #getSequencer()
	 * @generated
	 */
	EAttribute getSequencer_Duration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.sequencer.Sequencer#isTimeToStop <em>Time To Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time To Stop</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#isTimeToStop()
	 * @see #getSequencer()
	 * @generated
	 */
	EAttribute getSequencer_TimeToStop();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.sequencer.Sequencer#getWorkComplete <em>Work Complete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Work Complete</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getWorkComplete()
	 * @see #getSequencer()
	 * @generated
	 */
	EAttribute getSequencer_WorkComplete();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.sequencer.Sequencer#getWorkIncrement <em>Work Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Work Increment</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getWorkIncrement()
	 * @see #getSequencer()
	 * @generated
	 */
	EAttribute getSequencer_WorkIncrement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.sequencer.Sequencer#getCycle <em>Cycle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cycle</em>'.
	 * @see org.eclipse.stem.core.sequencer.Sequencer#getCycle()
	 * @see #getSequencer()
	 * @generated
	 */
	EAttribute getSequencer_Cycle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.stem.core.sequencer.SequentialSequencer <em>Sequential Sequencer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sequential Sequencer</em>'.
	 * @see org.eclipse.stem.core.sequencer.SequentialSequencer
	 * @generated
	 */
	EClass getSequentialSequencer();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.stem.core.sequencer.SequentialSequencer#getTimeIncrement <em>Time Increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time Increment</em>'.
	 * @see org.eclipse.stem.core.sequencer.SequentialSequencer#getTimeIncrement()
	 * @see #getSequentialSequencer()
	 * @generated
	 */
	EAttribute getSequentialSequencer_TimeIncrement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SequencerFactory getSequencerFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.sequencer.impl.RealTimeSequencerImpl <em>Real Time Sequencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.sequencer.impl.RealTimeSequencerImpl
		 * @see org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl#getRealTimeSequencer()
		 * @generated
		 */
		EClass REAL_TIME_SEQUENCER = eINSTANCE.getRealTimeSequencer();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.sequencer.impl.SequencerImpl <em>Sequencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.sequencer.impl.SequencerImpl
		 * @see org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl#getSequencer()
		 * @generated
		 */
		EClass SEQUENCER = eINSTANCE.getSequencer();

		/**
		 * The meta object literal for the '<em><b>Start Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCER__START_TIME = eINSTANCE.getSequencer_StartTime();

		/**
		 * The meta object literal for the '<em><b>End Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCER__END_TIME = eINSTANCE.getSequencer_EndTime();

		/**
		 * The meta object literal for the '<em><b>Current Time</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCER__CURRENT_TIME = eINSTANCE.getSequencer_CurrentTime();

		/**
		 * The meta object literal for the '<em><b>Next Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEQUENCER__NEXT_TIME = eINSTANCE.getSequencer_NextTime();

		/**
		 * The meta object literal for the '<em><b>Time Delta</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCER__TIME_DELTA = eINSTANCE.getSequencer_TimeDelta();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCER__DURATION = eINSTANCE.getSequencer_Duration();

		/**
		 * The meta object literal for the '<em><b>Time To Stop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCER__TIME_TO_STOP = eINSTANCE.getSequencer_TimeToStop();

		/**
		 * The meta object literal for the '<em><b>Work Complete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCER__WORK_COMPLETE = eINSTANCE.getSequencer_WorkComplete();

		/**
		 * The meta object literal for the '<em><b>Work Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCER__WORK_INCREMENT = eINSTANCE.getSequencer_WorkIncrement();

		/**
		 * The meta object literal for the '<em><b>Cycle</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENCER__CYCLE = eINSTANCE.getSequencer_Cycle();

		/**
		 * The meta object literal for the '{@link org.eclipse.stem.core.sequencer.impl.SequentialSequencerImpl <em>Sequential Sequencer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.stem.core.sequencer.impl.SequentialSequencerImpl
		 * @see org.eclipse.stem.core.sequencer.impl.SequencerPackageImpl#getSequentialSequencer()
		 * @generated
		 */
		EClass SEQUENTIAL_SEQUENCER = eINSTANCE.getSequentialSequencer();

		/**
		 * The meta object literal for the '<em><b>Time Increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SEQUENTIAL_SEQUENCER__TIME_INCREMENT = eINSTANCE.getSequentialSequencer_TimeIncrement();

	}

} //SequencerPackage
