package org.eclipse.stem.diseasemodels.standard.impl;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.NodeLabel;
//import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.core.model.impl.NodeDecoratorImpl;
//import org.eclipse.stem.definitions.labels.AreaLabel;
import org.eclipse.stem.definitions.labels.PopulationLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getBackgroundMortalityRate <em>Background Mortality Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getPopulationIdentifier <em>Population Identifier</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getTimePeriod <em>Time Period</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getDiseaseName <em>Disease Name</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getStepSize <em>Step Size</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getCurrentX <em>Current X</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getRelativeTolerance <em>Relative Tolerance</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#isFiniteDifference <em>Finite Difference</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#isFrequencyDependent <em>Frequency Dependent</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#getBackgroundBirthRate <em>Background Birth Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DiseaseModelImpl extends NodeDecoratorImpl implements
		DiseaseModel {
	/**
	 * The default value of the '{@link #getBackgroundMortalityRate() <em>Background Mortality Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBackgroundMortalityRate()
	 * @generated
	 * @ordered
	 */
	protected static final double BACKGROUND_MORTALITY_RATE_EDEFAULT = 5.5E-5;

	/**
	 * The cached value of the '{@link #getBackgroundMortalityRate() <em>Background Mortality Rate</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBackgroundMortalityRate()
	 * @generated
	 * @ordered
	 */
	protected double backgroundMortalityRate = BACKGROUND_MORTALITY_RATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected static final String POPULATION_IDENTIFIER_EDEFAULT = "human";

	/**
	 * The cached value of the '{@link #getPopulationIdentifier() <em>Population Identifier</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPopulationIdentifier()
	 * @generated
	 * @ordered
	 */
	protected String populationIdentifier = POPULATION_IDENTIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getTimePeriod() <em>Time Period</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTimePeriod()
	 * @generated NOT
	 * @ordered
	 */
	protected static final long TIME_PERIOD_EDEFAULT = STEMTime.Units.DAY.getMilliseconds();

	/**
	 * The cached value of the '{@link #getTimePeriod() <em>Time Period</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTimePeriod()
	 * @generated
	 * @ordered
	 */
	protected long timePeriod = TIME_PERIOD_EDEFAULT;

	/**
	 * The default value of the '{@link #getDiseaseName() <em>Disease Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDiseaseName()
	 * @generated
	 * @ordered
	 */
	protected static final String DISEASE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDiseaseName() <em>Disease Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDiseaseName()
	 * @generated
	 * @ordered
	 */
	protected String diseaseName = DISEASE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected static final double STEP_SIZE_EDEFAULT = 1.0;

	/**
	 * The cached value of the '{@link #getStepSize() <em>Step Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepSize()
	 * @generated
	 * @ordered
	 */
	protected double stepSize = STEP_SIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCurrentX() <em>Current X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentX()
	 * @generated
	 * @ordered
	 */
	protected static final double CURRENT_X_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCurrentX() <em>Current X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentX()
	 * @generated
	 * @ordered
	 */
	protected double currentX = CURRENT_X_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelativeTolerance() <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeTolerance()
	 * @generated
	 * @ordered
	 */
	protected static final double RELATIVE_TOLERANCE_EDEFAULT = 1.0E-9;

	/**
	 * The cached value of the '{@link #getRelativeTolerance() <em>Relative Tolerance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelativeTolerance()
	 * @generated
	 * @ordered
	 */
	protected double relativeTolerance = RELATIVE_TOLERANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isFiniteDifference() <em>Finite Difference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFiniteDifference()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FINITE_DIFFERENCE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isFiniteDifference() <em>Finite Difference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFiniteDifference()
	 * @generated
	 * @ordered
	 */
	protected boolean finiteDifference = FINITE_DIFFERENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #isFrequencyDependent() <em>Frequency Dependent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFrequencyDependent()
	 * @generated
	 * @ordered
	 */
	protected static final boolean FREQUENCY_DEPENDENT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isFrequencyDependent() <em>Frequency Dependent</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isFrequencyDependent()
	 * @generated
	 * @ordered
	 */
	protected boolean frequencyDependent = FREQUENCY_DEPENDENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBackgroundBirthRate() <em>Background Birth Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundBirthRate()
	 * @generated
	 * @ordered
	 */
	protected static final double BACKGROUND_BIRTH_RATE_EDEFAULT = 5.5E-5;

	/**
	 * The cached value of the '{@link #getBackgroundBirthRate() <em>Background Birth Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundBirthRate()
	 * @generated
	 * @ordered
	 */
	protected double backgroundBirthRate = BACKGROUND_BIRTH_RATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected DiseaseModelImpl() {
		super();
	}

	/**
	 * @param standardDiseaseModel
	 *            the StandardDiseaseModel disease model to be initialized
	 * @param diseaseModelName
	 * @param backgroundMortalityRate
	 * @param immunityLossRate
	 * @param incubationRate
	 * @param nonLinearityCoefficient
	 * @param timePeriod
	 * @param populationIdentifier
	 */
	protected static DiseaseModel initializeDiseaseModel(
			final DiseaseModel diseaseModel, final String diseaseModelName,
			final double backgroundMortalityRate, final long timePeriod,
			final String populationIdentifier) {
		diseaseModel.setDiseaseName(diseaseModelName);
		diseaseModel.getDublinCore().setTitle(diseaseModelName);
		diseaseModel.setBackgroundMortalityRate(backgroundMortalityRate);
		diseaseModel.setTimePeriod(timePeriod);
		diseaseModel.setPopulationIdentifier(populationIdentifier);

		return diseaseModel;
	} // initializeDiseaseModel

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StandardPackage.Literals.DISEASE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTimePeriod() {
		return timePeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newTimePeriod
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimePeriod(long newTimePeriod) {
		long oldTimePeriod = timePeriod;
		timePeriod = newTimePeriod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__TIME_PERIOD, oldTimePeriod, timePeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPopulationIdentifier() {
		return populationIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newPopulationIdentifier
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPopulationIdentifier(String newPopulationIdentifier) {
		String oldPopulationIdentifier = populationIdentifier;
		populationIdentifier = newPopulationIdentifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__POPULATION_IDENTIFIER, oldPopulationIdentifier, populationIdentifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBackgroundMortalityRate() {
		return backgroundMortalityRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param newBackgroundMortalityRate
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundMortalityRate(double newBackgroundMortalityRate) {
		double oldBackgroundMortalityRate = backgroundMortalityRate;
		backgroundMortalityRate = newBackgroundMortalityRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE, oldBackgroundMortalityRate, backgroundMortalityRate));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getDiseaseName() {
		return diseaseName;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiseaseName(String newDiseaseName) {
		String oldDiseaseName = diseaseName;
		diseaseName = newDiseaseName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__DISEASE_NAME, oldDiseaseName, diseaseName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStepSize() {
		return stepSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepSize(double newStepSize) {
		double oldStepSize = stepSize;
		stepSize = newStepSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__STEP_SIZE, oldStepSize, stepSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCurrentX() {
		return currentX;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentX(double newCurrentX) {
		double oldCurrentX = currentX;
		currentX = newCurrentX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__CURRENT_X, oldCurrentX, currentX));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRelativeTolerance() {
		return relativeTolerance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelativeTolerance(double newRelativeTolerance) {
		double oldRelativeTolerance = relativeTolerance;
		relativeTolerance = newRelativeTolerance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__RELATIVE_TOLERANCE, oldRelativeTolerance, relativeTolerance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFiniteDifference() {
		return finiteDifference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFiniteDifference(boolean newFiniteDifference) {
		boolean oldFiniteDifference = finiteDifference;
		finiteDifference = newFiniteDifference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__FINITE_DIFFERENCE, oldFiniteDifference, finiteDifference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isFrequencyDependent() {
		return frequencyDependent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFrequencyDependent(boolean newFrequencyDependent) {
		boolean oldFrequencyDependent = frequencyDependent;
		frequencyDependent = newFrequencyDependent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__FREQUENCY_DEPENDENT, oldFrequencyDependent, frequencyDependent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBackgroundBirthRate() {
		return backgroundBirthRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundBirthRate(double newBackgroundBirthRate) {
		double oldBackgroundBirthRate = backgroundBirthRate;
		backgroundBirthRate = newBackgroundBirthRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StandardPackage.DISEASE_MODEL__BACKGROUND_BIRTH_RATE, oldBackgroundBirthRate, backgroundBirthRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param timeDelta
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getAdjustedBackgroundMortalityRate(long timeDelta) {
		return getBackgroundMortalityRate()
				* ((double) timeDelta / (double) getTimePeriod());
	} // getAdjustedBackgroundMortalityRate

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract DiseaseModelLabel createDiseaseModelLabel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract DiseaseModelLabelValue createDiseaseModelLabelValue();

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract DiseaseModelState createDiseaseModelState();



	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param diseaseModelState
	 * @param diseaseModelLabel
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	abstract public DiseaseModelState initializeDiseaseState(
			final DiseaseModelState diseaseModelState,
			final DiseaseModelLabel diseaseModelLabel);

	
	/**
	 * <!-- begin-user-doc -->
	 * This is a second chance to update the {@link DiseaseModelState} instance that
	 * is being kept at a {@link DiseaseModelLabel}.  We get this because we've
	 * already done one pass over the lablel's that the disease model updates.  In
	 * that pass we accumlated global state information (e.g., the total population)
	 * and now we might need to add something to the state information such
	 * as the global population density.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	abstract public void initializeDiseaseState(DiseaseModelLabel diseaseModelLabel);



	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract Infector createInfector();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public double getAdjustedBackgroundBirthRate(long timeDelta) {
		return getBackgroundBirthRate()
		* ((double) timeDelta / (double) getTimePeriod());
	}

	/**
	 * Search through the graph and find all of the population labels that have
	 * the same identifier.
	 * 
	 * @param populationIdentifier
	 *            the population being labeled
	 * @param graph
	 *            the graph to search
	 * @return the PopulationLabel instances of the graph that match the
	 *         identifier.
	 */
	protected Collection<PopulationLabel> getPopulationLabels(
			final String populationIdentifier, final Graph graph) {
		final List<PopulationLabel> retValue = new ArrayList<PopulationLabel>();

		// Iterate through all of the population labels in the graph
		for (Iterator<NodeLabel> populationLabelIter = graph.getNodeLabelsByTypeURI(
				PopulationLabel.URI_TYPE_POPULATION_LABEL).iterator(); populationLabelIter
				.hasNext();) {
			final PopulationLabel populationLabel = (PopulationLabel) populationLabelIter
					.next();
			// Is this label for the population we're looking for?
			if (populationLabel.getPopulationIdentifier().equals(
					populationIdentifier)) {
				// Yes
				// If there is a problem with the "node uri" of the population
				// label then it would not have been associated with a node
				// instance in the graph at this point. This is a problem for
				// disease models that are trying to label the node (there isn't
				// one!). So filter out those mistakes here.

				// Does the population label have an associated node?
				if (populationLabel.getNode() != null) {
					// Yes
					retValue.add(populationLabel);
				} // if the population label has a node
			} // if the population we're looking for
		} // for each population label

		return retValue;
	} // getPopulationLabels

	/**
	 * @see org.eclipse.stem.core.model.impl.DecoratorImpl#decorateGraph(org.eclipse.stem.core.graph.Graph)
	 */
	@Override
	public void decorateGraph() {
		for (final Iterator<PopulationLabel> populationLabelIter = getPopulationLabels(
				getPopulationIdentifier(), getGraph()).iterator(); populationLabelIter
				.hasNext();) {
			final PopulationLabel populationLabel = populationLabelIter.next();

			final DiseaseModelLabel dml = createDiseaseModelLabel();
			DiseaseModelLabelImpl.labelNode(dml, populationLabel,
					populationLabel.getNode());
			getLabelsToUpdate().add(dml);

			getGraph().putNodeLabel(dml);

			// Initialize the disease model state (if any). The state holds
			// values useful for the computation of the disease model
			final DiseaseModelState diseaseModelState = createDiseaseModelState();

			dml.setDiseaseModelState(initializeDiseaseState(diseaseModelState,
					dml));
		} // for each population label

		// We've made one pass labeling the Node's with the disease model label,
		// and we created DiseaseModelState instances that are specific to this
		// disease that hold state information useful in its computations.
		// Having made one pass we need to give the disease model another chance
		// to update its state information with things it learned during the
		// first pass (e.g., the total population or total area).  
		
		for (Iterator diseseModelLabelIter = getLabelsToUpdate().iterator(); diseseModelLabelIter.hasNext();) {
			initializeDiseaseState((DiseaseModelLabel) diseseModelLabelIter.next());
		} // for each label this disease model updates

		
		// This initializes the disease model values from the population values.
		// For instance for StandardDiseaseModels, it initializes the
		// susceptiable population from the population
		resetLabels();
	} // decorateGraph

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param resolve
	 * @param coreType
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE:
				return new Double(getBackgroundMortalityRate());
			case StandardPackage.DISEASE_MODEL__POPULATION_IDENTIFIER:
				return getPopulationIdentifier();
			case StandardPackage.DISEASE_MODEL__TIME_PERIOD:
				return new Long(getTimePeriod());
			case StandardPackage.DISEASE_MODEL__DISEASE_NAME:
				return getDiseaseName();
			case StandardPackage.DISEASE_MODEL__STEP_SIZE:
				return new Double(getStepSize());
			case StandardPackage.DISEASE_MODEL__CURRENT_X:
				return new Double(getCurrentX());
			case StandardPackage.DISEASE_MODEL__RELATIVE_TOLERANCE:
				return new Double(getRelativeTolerance());
			case StandardPackage.DISEASE_MODEL__FINITE_DIFFERENCE:
				return isFiniteDifference() ? Boolean.TRUE : Boolean.FALSE;
			case StandardPackage.DISEASE_MODEL__FREQUENCY_DEPENDENT:
				return isFrequencyDependent() ? Boolean.TRUE : Boolean.FALSE;
			case StandardPackage.DISEASE_MODEL__BACKGROUND_BIRTH_RATE:
				return new Double(getBackgroundBirthRate());
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @param newValue
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE:
				setBackgroundMortalityRate(((Double)newValue).doubleValue());
				return;
			case StandardPackage.DISEASE_MODEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier((String)newValue);
				return;
			case StandardPackage.DISEASE_MODEL__TIME_PERIOD:
				setTimePeriod(((Long)newValue).longValue());
				return;
			case StandardPackage.DISEASE_MODEL__DISEASE_NAME:
				setDiseaseName((String)newValue);
				return;
			case StandardPackage.DISEASE_MODEL__STEP_SIZE:
				setStepSize(((Double)newValue).doubleValue());
				return;
			case StandardPackage.DISEASE_MODEL__CURRENT_X:
				setCurrentX(((Double)newValue).doubleValue());
				return;
			case StandardPackage.DISEASE_MODEL__RELATIVE_TOLERANCE:
				setRelativeTolerance(((Double)newValue).doubleValue());
				return;
			case StandardPackage.DISEASE_MODEL__FINITE_DIFFERENCE:
				setFiniteDifference(((Boolean)newValue).booleanValue());
				return;
			case StandardPackage.DISEASE_MODEL__FREQUENCY_DEPENDENT:
				setFrequencyDependent(((Boolean)newValue).booleanValue());
				return;
			case StandardPackage.DISEASE_MODEL__BACKGROUND_BIRTH_RATE:
				setBackgroundBirthRate(((Double)newValue).doubleValue());
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE:
				setBackgroundMortalityRate(BACKGROUND_MORTALITY_RATE_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__POPULATION_IDENTIFIER:
				setPopulationIdentifier(POPULATION_IDENTIFIER_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__TIME_PERIOD:
				setTimePeriod(TIME_PERIOD_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__DISEASE_NAME:
				setDiseaseName(DISEASE_NAME_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__STEP_SIZE:
				setStepSize(STEP_SIZE_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__CURRENT_X:
				setCurrentX(CURRENT_X_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__RELATIVE_TOLERANCE:
				setRelativeTolerance(RELATIVE_TOLERANCE_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__FINITE_DIFFERENCE:
				setFiniteDifference(FINITE_DIFFERENCE_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__FREQUENCY_DEPENDENT:
				setFrequencyDependent(FREQUENCY_DEPENDENT_EDEFAULT);
				return;
			case StandardPackage.DISEASE_MODEL__BACKGROUND_BIRTH_RATE:
				setBackgroundBirthRate(BACKGROUND_BIRTH_RATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @param featureID
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case StandardPackage.DISEASE_MODEL__BACKGROUND_MORTALITY_RATE:
				return backgroundMortalityRate != BACKGROUND_MORTALITY_RATE_EDEFAULT;
			case StandardPackage.DISEASE_MODEL__POPULATION_IDENTIFIER:
				return POPULATION_IDENTIFIER_EDEFAULT == null ? populationIdentifier != null : !POPULATION_IDENTIFIER_EDEFAULT.equals(populationIdentifier);
			case StandardPackage.DISEASE_MODEL__TIME_PERIOD:
				return timePeriod != TIME_PERIOD_EDEFAULT;
			case StandardPackage.DISEASE_MODEL__DISEASE_NAME:
				return DISEASE_NAME_EDEFAULT == null ? diseaseName != null : !DISEASE_NAME_EDEFAULT.equals(diseaseName);
			case StandardPackage.DISEASE_MODEL__STEP_SIZE:
				return stepSize != STEP_SIZE_EDEFAULT;
			case StandardPackage.DISEASE_MODEL__CURRENT_X:
				return currentX != CURRENT_X_EDEFAULT;
			case StandardPackage.DISEASE_MODEL__RELATIVE_TOLERANCE:
				return relativeTolerance != RELATIVE_TOLERANCE_EDEFAULT;
			case StandardPackage.DISEASE_MODEL__FINITE_DIFFERENCE:
				return finiteDifference != FINITE_DIFFERENCE_EDEFAULT;
			case StandardPackage.DISEASE_MODEL__FREQUENCY_DEPENDENT:
				return frequencyDependent != FREQUENCY_DEPENDENT_EDEFAULT;
			case StandardPackage.DISEASE_MODEL__BACKGROUND_BIRTH_RATE:
				return backgroundBirthRate != BACKGROUND_BIRTH_RATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return
	 * 
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		final StringBuffer result = new StringBuffer();

		final String title = getDublinCore().getTitle();
		result.append(title == null ? "<disease model>" : title);
		result.append("(");
		result.append(populationIdentifier);
		result.append(')');
		return result.toString();
	} // toString

	/**
	 * @see org.eclipse.stem.core.model.impl.NodeDecoratorImpl#sane()
	 */
	@Override
	public boolean sane() {
		boolean retValue = super.sane();

		retValue = retValue && diseaseName != null;
		assert retValue;

		retValue = retValue
				&& backgroundMortalityRate >= 0.0;
		assert retValue;

		retValue = retValue && !Double.isInfinite(backgroundMortalityRate);
		assert retValue;
		
		retValue = retValue && !Double.isNaN(backgroundMortalityRate);
		assert retValue;
		
		retValue = retValue && timePeriod >= TIME_PERIOD_EDEFAULT;
		assert retValue;

	
		return retValue;
	} // sane

} // DiseaseModelImpl
