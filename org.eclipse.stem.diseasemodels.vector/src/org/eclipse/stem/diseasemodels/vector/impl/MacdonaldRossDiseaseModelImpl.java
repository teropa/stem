/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.diseasemodels.vector.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.stem.core.STEMURI;
import org.eclipse.stem.core.common.StringValue;
import org.eclipse.stem.core.graph.DynamicLabel;
import org.eclipse.stem.core.graph.Graph;
import org.eclipse.stem.core.graph.LabelValue;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.core.model.Model;
import org.eclipse.stem.core.model.STEMTime;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.DiseaseModelState;
import org.eclipse.stem.diseasemodels.standard.Infector;
import org.eclipse.stem.diseasemodels.standard.SIInfector;
import org.eclipse.stem.diseasemodels.standard.SILabel;
import org.eclipse.stem.diseasemodels.standard.SILabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabel;
import org.eclipse.stem.diseasemodels.standard.StandardDiseaseModelLabelValue;
import org.eclipse.stem.diseasemodels.standard.StandardFactory;
import org.eclipse.stem.diseasemodels.standard.impl.StandardDiseaseModelImpl;

import org.eclipse.stem.diseasemodels.vector.Activator;
import org.eclipse.stem.diseasemodels.vector.MacdonaldRossDiseaseModel;
import org.eclipse.stem.diseasemodels.vector.VectorPackage;
import org.eclipse.stem.populationmodels.standard.PopulationModelLabel;
import org.eclipse.stem.populationmodels.standard.StandardPopulationModel;
import org.eclipse.stem.populationmodels.standard.impl.StandardFactoryImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Macdonald Ross Disease Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl#getBitingRate <em>Biting Rate</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl#getInfectiousBitingProportionHuman <em>Infectious Biting Proportion Human</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl#getInfectiousBitingProportionVector <em>Infectious Biting Proportion Vector</em>}</li>
 *   <li>{@link org.eclipse.stem.diseasemodels.vector.impl.MacdonaldRossDiseaseModelImpl#getRecoveryRate <em>Recovery Rate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MacdonaldRossDiseaseModelImpl extends VectorDiseaseModelImpl implements MacdonaldRossDiseaseModel {
	/**
	 * The default value of the '{@link #getBitingRate() <em>Biting Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitingRate()
	 * @generated
	 * @ordered
	 */
	protected static final double BITING_RATE_EDEFAULT = 0.5;
	/**
	 * The cached value of the '{@link #getBitingRate() <em>Biting Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBitingRate()
	 * @generated
	 * @ordered
	 */
	protected double bitingRate = BITING_RATE_EDEFAULT;
	/**
	 * The default value of the '{@link #getInfectiousBitingProportionHuman() <em>Infectious Biting Proportion Human</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfectiousBitingProportionHuman()
	 * @generated
	 * @ordered
	 */
	protected static final double INFECTIOUS_BITING_PROPORTION_HUMAN_EDEFAULT = 0.5;
	/**
	 * The cached value of the '{@link #getInfectiousBitingProportionHuman() <em>Infectious Biting Proportion Human</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfectiousBitingProportionHuman()
	 * @generated
	 * @ordered
	 */
	protected double infectiousBitingProportionHuman = INFECTIOUS_BITING_PROPORTION_HUMAN_EDEFAULT;
	/**
	 * The default value of the '{@link #getInfectiousBitingProportionVector() <em>Infectious Biting Proportion Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfectiousBitingProportionVector()
	 * @generated
	 * @ordered
	 */
	protected static final double INFECTIOUS_BITING_PROPORTION_VECTOR_EDEFAULT = 1.0;
	/**
	 * The cached value of the '{@link #getInfectiousBitingProportionVector() <em>Infectious Biting Proportion Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfectiousBitingProportionVector()
	 * @generated
	 * @ordered
	 */
	protected double infectiousBitingProportionVector = INFECTIOUS_BITING_PROPORTION_VECTOR_EDEFAULT;
	/**
	 * The default value of the '{@link #getRecoveryRate() <em>Recovery Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoveryRate()
	 * @generated
	 * @ordered
	 */
	protected static final double RECOVERY_RATE_EDEFAULT = 0.00333;
	/**
	 * The cached value of the '{@link #getRecoveryRate() <em>Recovery Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecoveryRate()
	 * @generated
	 * @ordered
	 */
	protected double recoveryRate = RECOVERY_RATE_EDEFAULT;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MacdonaldRossDiseaseModelImpl() {
		super();
	}

	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#createInfector()
	 */
	@Override
	public Infector createInfector() {
		SIInfector retValue = StandardFactory.eINSTANCE.createSIInfector();
		retValue.setDiseaseName(this.getDiseaseName());
		retValue.setPopulationIdentifier(getPopulationIdentifier());
		return retValue;
	} // createInfector
	
	@Override
	public DiseaseModelLabelValue createDiseaseModelLabelValue() {
		return StandardFactory.eINSTANCE.createSILabelValue();
	} // createDiseaseModelLabelValue
	
	/**
	 * @see org.eclipse.stem.diseasemodels.standard.impl.DiseaseModelImpl#createDiseaseModelLabel()
	 */
	@Override
	public DiseaseModelLabel createDiseaseModelLabel() {
		return StandardFactory.eINSTANCE.createSILabel();
	} // createDiseaseModelLabel
	
	/**
	 * @param fractionToDepart
	 * @param nextState
	 * @return
	 */
	@Override
	protected StandardDiseaseModelLabelValue computeDepartures(
			final double fractionToDepart,
			final StandardDiseaseModelLabelValue nextState) {
		return null; // method is obsolete
	} // computeDepartures
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return VectorPackage.Literals.MACDONALD_ROSS_DISEASE_MODEL;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getBitingRate() {
		return bitingRate;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBitingRate(double newBitingRate) {
		double oldBitingRate = bitingRate;
		bitingRate = newBitingRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE, oldBitingRate, bitingRate));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInfectiousBitingProportionHuman() {
		return infectiousBitingProportionHuman;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfectiousBitingProportionHuman(double newInfectiousBitingProportionHuman) {
		double oldInfectiousBitingProportionHuman = infectiousBitingProportionHuman;
		infectiousBitingProportionHuman = newInfectiousBitingProportionHuman;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN, oldInfectiousBitingProportionHuman, infectiousBitingProportionHuman));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInfectiousBitingProportionVector() {
		return infectiousBitingProportionVector;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInfectiousBitingProportionVector(double newInfectiousBitingProportionVector) {
		double oldInfectiousBitingProportionVector = infectiousBitingProportionVector;
		infectiousBitingProportionVector = newInfectiousBitingProportionVector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR, oldInfectiousBitingProportionVector, infectiousBitingProportionVector));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getRecoveryRate() {
		return recoveryRate;
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecoveryRate(double newRecoveryRate) {
		double oldRecoveryRate = recoveryRate;
		recoveryRate = newRecoveryRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE, oldRecoveryRate, recoveryRate));
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE:
				return getBitingRate();
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN:
				return getInfectiousBitingProportionHuman();
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR:
				return getInfectiousBitingProportionVector();
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE:
				return getRecoveryRate();
		}
		return super.eGet(featureID, resolve, coreType);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE:
				setBitingRate((Double)newValue);
				return;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN:
				setInfectiousBitingProportionHuman((Double)newValue);
				return;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR:
				setInfectiousBitingProportionVector((Double)newValue);
				return;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE:
				setRecoveryRate((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE:
				setBitingRate(BITING_RATE_EDEFAULT);
				return;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN:
				setInfectiousBitingProportionHuman(INFECTIOUS_BITING_PROPORTION_HUMAN_EDEFAULT);
				return;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR:
				setInfectiousBitingProportionVector(INFECTIOUS_BITING_PROPORTION_VECTOR_EDEFAULT);
				return;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE:
				setRecoveryRate(RECOVERY_RATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__BITING_RATE:
				return bitingRate != BITING_RATE_EDEFAULT;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_HUMAN:
				return infectiousBitingProportionHuman != INFECTIOUS_BITING_PROPORTION_HUMAN_EDEFAULT;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__INFECTIOUS_BITING_PROPORTION_VECTOR:
				return infectiousBitingProportionVector != INFECTIOUS_BITING_PROPORTION_VECTOR_EDEFAULT;
			case VectorPackage.MACDONALD_ROSS_DISEASE_MODEL__RECOVERY_RATE:
				return recoveryRate != RECOVERY_RATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (bitingRate: ");
		result.append(bitingRate);
		result.append(", infectiousBitingProportionHuman: ");
		result.append(infectiousBitingProportionHuman);
		result.append(", infectiousBitingProportionVector: ");
		result.append(infectiousBitingProportionVector);
		result.append(", recoveryRate: ");
		result.append(recoveryRate);
		result.append(')');
		return result.toString();
	}


	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeathsDeltas(
			STEMTime time, StandardDiseaseModelLabel diseaseLabel,
			StandardDiseaseModelLabelValue currentLabelValue, long timeDelta,
			DiseaseModelLabelValue returnValue) {
		return (StandardDiseaseModelLabelValue)returnValue;
	}


	@Override
	public StandardDiseaseModelLabelValue computeDiseaseDeltas(STEMTime time,
			StandardDiseaseModelLabelValue currentState,
			StandardDiseaseModelLabel diseaseLabel, long timeDelta,
			DiseaseModelLabelValue returnValue) {
		
		// The method comes from Anderson & May Infectious Diseases of Humans
		// chapter 14.3, page 394 "Basic model for Malaria"
		
		// There are two options here depending upon the population
		// we are calculating a delta for. It's either the human
		// or the vector population. Determine which one we're
		// dealing with.
		
		String popIdentifier = diseaseLabel.getPopulationModelLabel().getPopulationIdentifier();
		
		if(popIdentifier.equals(this.getPopulationIdentifier())) {
			// Okay, we're dealing with humans (most likely)
			
			// The change in infected people is:
			// dy/dt = (abNV/N)yv(1-y)-gamma*y
			// where 
			//
			//NV=Total vector population
			//N=Total human population
			//yv = current fraction of infected vectors
			// y = current fraction of infected humans
			//a = biting rate
			//b = proportion infectious bites (human)
			
			SILabelValue siVal = (SILabelValue)currentState;
			double totalHumanPop = siVal.getPopulationCount();
			
			// Find the vector population
			
			SILabel vecPop = findDiseaseLabel(diseaseLabel.getNode(), this.getVectorPopulationIdentifier());
			if(vecPop == null) {
				Activator.logError("Unable to find disease label for "+this.getVectorPopulationIdentifier()+" on node "+ diseaseLabel.getNode(), new Exception());
				return  (StandardDiseaseModelLabelValue)returnValue;
			}
			
			SILabelValue vectorValue = vecPop.getTempValue(); // temp value since probe is not yet set.
			double totalVectorPop = vectorValue.getPopulationCount();
			
			double adjustedRecoveryRate = this.getRecoveryRate() * ((double) timeDelta / (double) getTimePeriod());
			double adjustedBitingRate = this.getBitingRate() * ((double)timeDelta / (double)getTimePeriod());
			
			// The effective Infectious population  is a dimensionles number normalize by total
			// population used in teh computation of bets*S*i where i = Ieffective/Pop.
			// This includes a correction to the current
			// infectious population (Ieffective) based on the conserved exchange of people (circulation)
			// between regions. Note that this is no the "arrivals" and "departures" which are
			// a different process.

//			final double effectiveInfectiousHuman = getNormalizedEffectiveInfectious(diseaseLabel.getNode(), diseaseLabel, siVal.getI());
	
			double dydt = 
				(adjustedBitingRate*this.getInfectiousBitingProportionHuman()*totalVectorPop/totalHumanPop)* 
				(vectorValue.getI()/totalVectorPop)*(1-siVal.getI());

			dydt = (Double.isNaN(dydt))? 0:dydt;
			
			if(dydt > 1.0)
				dydt = 1.0;

			if(dydt < -1.0)
				dydt = -1.0;

			double fracSChange = -dydt + adjustedRecoveryRate*siVal.getI() / totalHumanPop;
			double fracIChange =  dydt - adjustedRecoveryRate*siVal.getI()/totalHumanPop;
				
			double absIChange = fracIChange * totalHumanPop;
			double absSChange = fracSChange * totalHumanPop;
			
			if(absIChange + absSChange != 0.0)
				System.out.println("Mismatch");
			
			SILabelValue retV = (SILabelValue)returnValue;
			retV.setI(absIChange);
			retV.setS(absSChange);
			retV.setIncidence(dydt*totalHumanPop);
			
		} else if (popIdentifier.equals(this.getVectorPopulationIdentifier())) {
			// We're dealing with the vector
			
			// The change in infected vectors are:
			// dyv/dt = acy(1-yv)-mu*yv
			// where 
			//
			//yv = current fraction of infected vectors
			// y = current fraction of infected humans
			//a = biting rate
			//c = proportion infectious bites (vector)
			
			SILabelValue vectorVal = (SILabelValue)currentState;
			double totalVectorPop = vectorVal.getPopulationCount();
			
			// Find the vector population
			
			SILabel humanPop = findDiseaseLabel(diseaseLabel.getNode(), this.getPopulationIdentifier());
			if(humanPop == null) {
				Activator.logError("Unable to find disease label for "+this.getPopulationIdentifier()+" on node "+ diseaseLabel.getNode(), new Exception());
				return  (StandardDiseaseModelLabelValue)returnValue;
			}
			
			SILabelValue siVal = humanPop.getTempValue(); // Temp value since it's safe to use
			
			double adjustedBitingRate = this.getBitingRate() * ((double)timeDelta / (double)getTimePeriod());
			
			
			final double effectiveInfectiousHuman = getNormalizedEffectiveInfectious(humanPop.getNode(), humanPop, siVal.getI());

			
			double fracIChange = 
				adjustedBitingRate*this.getInfectiousBitingProportionVector()*(effectiveInfectiousHuman)*
						(1-vectorVal.getI()/totalVectorPop);
				
			fracIChange = (Double.isNaN(fracIChange))? 0:fracIChange;
			
			if(fracIChange >1.0) 
				fracIChange = 1.0;
			double absIChange = fracIChange * totalVectorPop;
			
			double susceptibleToInfectious = absIChange;
			
			SILabelValue retV = (SILabelValue)returnValue;
			retV.setI(susceptibleToInfectious);
			retV.setS(-susceptibleToInfectious);
			retV.setIncidence(susceptibleToInfectious);
			
		} else {
			Activator.logError("Cannot determine what to do with "+popIdentifier+" on node "+diseaseLabel.getNode(), new Exception());
		}
		
		if(((SILabelValue)returnValue).getI() + ((SILabelValue)currentState).getI() < 0 ||
			((SILabelValue)returnValue).getS() + ((SILabelValue)currentState).getS() < 0)
			System.out.println("Error Negative");
		
		return (StandardDiseaseModelLabelValue)returnValue;
	}


	@Override
	public DiseaseModelState createDiseaseModelState() {
		return null; // method is obsolete
	}


	public void doModelSpecificAdjustments(LabelValue label) {
		// Nothing to do
	}

	/**
	 * We need to override this method to return all population model labels for both humans and the vector
	 * 
	 * @param populationIdentifier
	 *            the population being labeled
	 * @param graph
	 *            the graph to search
	 * @return the PopulationLabel instances of the graph that match the
	 *         identifier.
	 */
	@Override
	protected Collection<PopulationModelLabel> getPopulationModelLabels(
			final String populationIdentifier, final Graph graph) {
		final List<PopulationModelLabel> retValue = new ArrayList<PopulationModelLabel>();

		// Iterate through all of the population labels in the graph
		EList<NodeLabel> labels = graph.getNodeLabelsByTypeURI(
				PopulationModelLabel.URI_TYPE_DYNAMIC_POPULATION_LABEL);
		
		boolean foundHuman = false, foundVector = false;
		for (NodeLabel pl:labels) {
			final PopulationModelLabel populationLabel = (PopulationModelLabel) pl;
			// Is this label for the population we're looking for?
			boolean keep = false;
			if(populationLabel.getPopulationIdentifier().equals(populationIdentifier)) 
				{keep=true;foundHuman = true;}
			else if(populationLabel.getPopulationIdentifier().equals(getVectorPopulationIdentifier())) 
				{keep=true;foundVector = true;}
				
			if (keep) {
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

		// If we didn't find both humans and the vector, return an empty list.
		// This will force a retry creating disease labels after all population model labels have
		// had time to decorate the graph
		if(!foundHuman || !foundVector) retValue.clear();
		
		return retValue;
	} // getPopulationLabels

	/**
	 * We need to override to check all population groups
	 */
	
	@Override
	public void prepare(Model model, STEMTime time) {
		super.prepare(model, time);
		
		boolean found = findPopulationModel(model, this.getVectorPopulationIdentifier());
			
		if(!found) {
			// Create a new standard population model
			StandardPopulationModel spm = StandardFactoryImpl.eINSTANCE.createStandardPopulationModel();
			spm.setPopulationIdentifier(this.getVectorPopulationIdentifier());
			String title = "Auto Generated "+this.getVectorPopulationIdentifier()+" population model";
			String name = "auto_gen_"+this.getVectorPopulationIdentifier()+"_population_model";
			spm.setURI(STEMURI.createURI(name+"/"+STEMURI.generateUniquePart()));
			spm.setName(name);
			spm.getDublinCore().setTitle(title);
			model.getNodeDecorators().add(0, spm);
		}
	}
	
	@Override
	public boolean isDeterministic() {
		return true;
	}
	
	@Override
	public void applyExternalDeltas(STEMTime time, long timeDelta, EList<DynamicLabel> labels) {
		// Superclass handles external births/deaths
		super.applyExternalDeltas(time, timeDelta, labels);
	}
		 
		
	SILabel findDiseaseLabel(Node n, String identifier) {
		for(NodeLabel nl:n.getLabels()) {
			if(nl instanceof SILabel
					&& ((DiseaseModelLabel)nl).getPopulationModelLabel().getPopulationIdentifier().equals(identifier))
				return (SILabel)nl;
		}
		return null;
	}
} //MacdonaldRossDiseaseModelImpl
