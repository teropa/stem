// EStructuralFeatureFeatureModifierAdapterFactory.java
package org.eclipse.stem.ui.adapters.featuremodifier;

/*******************************************************************************
 * Copyright (c) 2008 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.modifier.FeatureModifier;
import org.eclipse.stem.core.modifier.ModifierFactory;
import org.eclipse.stem.core.modifier.NOPModifier;
import org.eclipse.stem.core.modifier.RangeModifier;
import org.eclipse.stem.core.modifier.SequenceModifier;
import org.eclipse.stem.data.geography.Activator;

/**
 * This interface defines an adapter factory that adapts
 * {@link EStructuralFeature}s to {@link FeatureModifier}s.
 */
public interface EStructuralFeatureFeatureModifierAdapterFactory {

	/**
	 * Singleton instance of the factory.
	 */
	IdentifiableFeatureModifierAdapterFactoryImpl INSTANCE = new IdentifiableFeatureModifierAdapterFactoryImpl();

	/**
	 * This class is an implementation of
	 * {@link EStructuralFeatureFeatureModifierAdapterFactory} that adapts
	 * {@link EStructuralFeature}s of {@link Identifiable}s to
	 * {@link FeatureModifier}s.
	 * <p>
	 * This implementation isn't quite complete as it doesn't allow the factory
	 * to be extended by adding another implementations of
	 * {@link EStructuralFeatureFeatureModifierAdapterFactory}. Doing so would
	 * allow different types provided by other plugins to be adapted.
	 */
	public class IdentifiableFeatureModifierAdapterFactoryImpl implements
			EStructuralFeatureFeatureModifierAdapterFactory {

		/**
		 * @param obj
		 *            the {@link EStructuralFeature} to be adapted
		 * @param target
		 *            the class to adapt to
		 * @return a {@link FeatureModifier} for the obj, or <code>null</code>
		 *         if that's not possible.
		 */
		public FeatureModifier adapt(final Object obj, final Object target) {
			FeatureModifier retValue = null;
			if (obj instanceof EStructuralFeature) {
				// Yes
				final EStructuralFeature feature = (EStructuralFeature) obj;
				if (target == NOPModifier.class) {
					// Yes
					// Integer NOP?
					if (feature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createIntegerNOPModifier();
						retValue.setEStructuralFeature(feature);
					} // if integer NOP
					// Long NOP?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getELong()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createLongNOPModifier();
						retValue.setEStructuralFeature(feature);
					} // if Long NOP
					// Double NOP?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getEDouble()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createDoubleNOPModifier();
						retValue.setEStructuralFeature(feature);
					} // if double NOP
					// STEMTime NOP?
					else if (feature.getEType() == ModelPackage.eINSTANCE
							.getSTEMTime()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createSTEMTimeNOPModifier();
						retValue.setEStructuralFeature(feature);
					} // if STEMTime NOP
					// String NOP?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getEString()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createStringNOPModifier();
						retValue.setEStructuralFeature(feature);
					} // if String NOP
					else {
						// No
						// Not implemented
//						Activator.logError("FeatureModifierAdapter for type \""
//								+ feature.getEType().getName()
//								+ "\" is not implemented.", null);
						retValue = ModifierFactory.eINSTANCE
								.createNOPModifier();
						retValue.setEStructuralFeature(feature);
					} // else
				} // if NOPModifier
				else if (target == RangeModifier.class) {
					// Yes
					// Integer range?
					if (feature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createIntegerRangeModifier();
						retValue.setEStructuralFeature(feature);
					} // if integer range
					// Long range?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getELong()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createLongRangeModifier();
						retValue.setEStructuralFeature(feature);
					} // if Long range
					// Double range?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getEDouble()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createDoubleRangeModifier();
						retValue.setEStructuralFeature(feature);
					} // if double range
					// STEMTime range?
					else if (feature.getEType() == ModelPackage.eINSTANCE
							.getSTEMTime()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createSTEMTimeRangeModifier();
						retValue.setEStructuralFeature(feature);
					} // if STEMTime range
					else {
						// No
						// Not implemented
						Activator.logError("FeatureModifierAdapter for type \""
								+ feature.getEType().getName()
								+ "\" is not implemented.", null);
						retValue = ModifierFactory.eINSTANCE
								.createNOPModifier();
						retValue.setEStructuralFeature(feature);
					}
				} // if Range Modifier
				// Sequence?
				else if (target == SequenceModifier.class) {
					// Yes
					// Integer Sequence?
					if (feature.getEType() == EcorePackage.eINSTANCE.getEInt()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createIntegerSequenceModifier();
						retValue.setEStructuralFeature(feature);
					} // if integer Sequence
					// Long Sequence?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getELong()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createLongSequenceModifier();
						retValue.setEStructuralFeature(feature);
					} // if Long Sequence
					// Double Sequence?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getEDouble()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createDoubleSequenceModifier();
						retValue.setEStructuralFeature(feature);
					} // if double Sequence
					// STEMTime Sequence?
					else if (feature.getEType() == ModelPackage.eINSTANCE
							.getSTEMTime()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createSTEMTimeSequenceModifier();
						retValue.setEStructuralFeature(feature);
					} // if STEMTime Sequence
					// String Sequence?
					else if (feature.getEType() == EcorePackage.eINSTANCE
							.getEString()) {
						// Yes
						retValue = ModifierFactory.eINSTANCE
								.createStringSequenceModifier();
						retValue.setEStructuralFeature(feature);
					} // if String Sequence
					else {
						// No
						// Not implemented
						Activator.logError("FeatureModifierAdapter for type \""
								+ feature.getEType().getName()
								+ "\" is not implemented.", null);
						retValue = ModifierFactory.eINSTANCE
								.createNOPModifier();
						retValue.setEStructuralFeature(feature);
					}
				} // if Sequence Modifier
				else {
					// No
					// Not implemented
					Activator.logError("FeatureModifierAdapter for type \""
							+ feature.getEType().getName()
							+ "\" is not implemented.", null);
					retValue = ModifierFactory.eINSTANCE
							.createNOPModifier();
					retValue.setEStructuralFeature(feature);
				}
			} // if EStructuralFeature
			return retValue;
		} // adapt

	} // IdentifiableFeatureModifierAdapterFactoryImpl

} // EStructuralFeatureFeatureModifierAdapterFactory
