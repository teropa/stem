package org.eclipse.stem.ui.ge.views;
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
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.stem.jobs.simulation.ISimulation;
import org.eclipse.stem.ui.ge.GEInterface;
import org.eclipse.stem.ui.ge.GELog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;


/**
 * provide text and image labels for the list 
 * 
 * We insert some information about the simulation id 
 * and whether it is slected
 * we could change the getImage to return a 
 * different image if GoogleEarth is active or inactive 
 * for the specified simulation 
 *
 */
public class GEViewLabelProvider extends LabelProvider implements IBaseLabelProvider {
	
	/**
	 * This is the class that handles the interface
	 *  between our view and GoogleEarth
	 */
	
	
	private GEInterface gei = null;
	
		
	
	/**
     * Get text to be displayed
     * 
     * @param obj instance being displayed
     */
	public String getText(Object obj) {
        //GELog.debug(this,"getText: obj="+obj);
        String flag = "";
        String template = "%s %s %s %s";
        String text = null;
        try {
			if (obj != null) {
				if (obj instanceof ISimulation) {
					ISimulation sim = (ISimulation)obj;
					
					String  cycle = "";
					String name = GEInterface.getSimulationId(sim);
					if (gei.isActive(sim)) {
						cycle = "["+Integer.toString(gei.getCycle(sim))+"]";
						flag = "*";
					}
					if (gei.isActiveView(sim)) {
					
						flag = "*GE";
					}
					text = String.format(template,
							flag, name, cycle, sim.toString());
				} else {
					text = ""+obj;  // so null will display
				}
			} else {
				text = "null";  // for debug
			}
		} catch (RuntimeException e) {			
			GELog.error("Failure",e);
		}
        //GELog.debug(this,"text="+text); 
       return text;
	}
	/**
     * Get Image to be displayed
     * This apppears to not be called.  Perhaps it is not 
     * supported for ListViewer
     * 
     * @param obj instance being displayed
     */
	public Image getImage(Object obj) {
        GELog.debug(this.getClass(),"getImage: obj="+obj.toString());
		return PlatformUI.getWorkbench().
				getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
	}
	/**
	 * @param gei reference to GE interface class
	 */
	public void setGEI(GEInterface gei) {
		this.gei = gei;
	}
	/**
	 * Set the selected simulation 
	 * Called by GEInterface to provide this needed info
	 * 
	 * @param selection
	 */
	public void setSelected(ISimulation selection) {
		GELog.debug(this.getClass(),"setSelected");
				
		LabelProviderChangedEvent event = new LabelProviderChangedEvent(this);
		this.fireLabelProviderChanged(event);
	}
}




