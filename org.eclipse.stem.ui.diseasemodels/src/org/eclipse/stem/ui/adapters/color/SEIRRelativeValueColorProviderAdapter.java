// SEIRRelativeValueColorProviderAdapter.java
package org.eclipse.stem.ui.adapters.color;

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

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.stem.core.graph.DynamicNodeLabel;
import org.eclipse.stem.core.graph.Node;
import org.eclipse.stem.core.graph.NodeLabel;
import org.eclipse.stem.ui.adapters.color.AbstractRelativeValueColorProviderAdapterFactory.PropertySelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;

/**
 * This class adapts {@link Node} objects to
 * {@link SEIRRelativeValueColorProvider} object.
 */
public class SEIRRelativeValueColorProviderAdapter extends
		AbstractRelativeValueColorProviderAdapter  implements PropertySelectionListener{
	
	private ItemPropertyDescriptor selectedProperty;

	/**
	 * Constructor
	 * @param selectedProperty
	 */
	public SEIRRelativeValueColorProviderAdapter(ItemPropertyDescriptor selectedProperty) {
		super();
		this.selectedProperty = selectedProperty;
	} // SEIRRelativeValueColorProviderAdapter

	/**
	 * @see org.eclipse.stem.ui.adapters.color.AbstractRelativeValueColorProviderAdapter#getRelativeValue()
	 */
	@Override
	public float getRelativeValue() {

		final Node node = (Node) getTarget();
		
		for (final NodeLabel label : node.getLabels()) {
			if (label instanceof DynamicNodeLabel) {
				DynamicNodeLabel nodeLabel = (DynamicNodeLabel)label;
				if (nodeLabel.getDecorator() == selectedDecorator) {
					setRVPTarget(nodeLabel);
					return (float) rvp.getRelativeValue(selectedProperty);
				}
			}
		}

		return 0; // We shouldn't reach this point
	} // getRelativeValue
	
	/**
	 * @see org.eclipse.stem.ui.adapters.color.AbstractRelativeValueColorProviderAdapter#updateGC(org.eclipse.swt.graphics.GC, float, boolean)
	 */
	@Override
	public void updateGC(GC gcToUpdate, float gainFactor, boolean useLogScaling) {
		device = gcToUpdate.getDevice();
		double relativeValue = getRelativeValue();
		double gainedRelativeValue = gainFactor * relativeValue;
		Color foreground = getColorForRelativeValue(gainedRelativeValue);
		gcToUpdate.setBackground(foreground);
	}
	
	/**
	 * @see org.eclipse.stem.ui.adapters.color.IntensityColorsLabelsMappingColorProviderAdapterFactory.PropertySelectionListener#propertySelected(org.eclipse.emf.edit.provider.ItemPropertyDescriptor)
	 */
	public void propertySelected(ItemPropertyDescriptor selectedProperty) {
		this.selectedProperty = selectedProperty;		
	}

} // SEIRRelativeValueColorProviderAdapter
