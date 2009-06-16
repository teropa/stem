// IdentifiableDelegate
package org.eclipse.stem.ui.views;

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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.PlatformObject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.Utility;
import org.eclipse.stem.core.common.DublinCore;
import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.impl.DublinCoreImpl;
import org.eclipse.stem.core.experiment.ExperimentPackage;
import org.eclipse.stem.core.graph.GraphPackage;
import org.eclipse.stem.core.model.ModelPackage;
import org.eclipse.stem.core.scenario.ScenarioPackage;
import org.eclipse.stem.core.sequencer.SequencerPackage;
import org.eclipse.stem.jobs.Activator;

/**
 * This class represents a serialized {@link Identifiable}.
 */
public class IdentifiableDelegate extends PlatformObject implements
		Comparable<IdentifiableDelegate> {

	// The Category this Identifiable belongs to
	// I think this can be deleted
	private Object parent;

	// The URI of the Identifiable
	private URI uri;

	// The Dublin Core instance that was initialized from the configuration
	// element
	private final DublinCoreImpl dublinCore;

	/**
	 * Create an {@link IdentifiableDelegate} from the {@link
	 * IConfigurationElement} obtained from an extension point. The {@link
	 * DublinCore} instance will be initialize from the {@link
	 * IConfigurationElement}
	 * 
	 * @param configElement
	 * 		the {@link IConfigurationElement} that defines an {@link
	 * 		Identifiable} that has been plugged in.
	 */
	public IdentifiableDelegate(final IConfigurationElement configElement) {
		this.dublinCore = new DublinCoreImpl(configElement);
	} // IdentifiableDelegate

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final String retValue = dublinCore != null ? dublinCore.getTitle() : ""; //$NON-NLS-1$
		return retValue != null ? retValue : "";
	}

	/**
	 * @return the {@link Identifiable} instance
	 */
	public Identifiable getIdentifiable() {
		Identifiable retValue = null;
		try {
			retValue = Utility.getIdentifiable(getURI());
		} catch (final Exception e) {
			Activator.logError("The resource \"" + getURI().toString()
					+ "\" was not found or was of the wrong format", e);
			retValue = null;
		}
		return retValue;
	} // getIdentifiable

	/**
	 * @return the value of the {@link Identifiable}'s eNS_URI. This is recorded
	 * 	as the {@link DublinCore#getFormat()} of the {@link Identifiable}.
	 * @see GraphPackage#eNS_URI
	 * @see ModelPackage#eNS_URI
	 * @see ScenarioPackage#eNS_URI
	 * @see SequencerPackage#eNS_URI
	 * @see ExperimentPackage#eNS_URI
	 */
	public String getFormat() {
		return getDublinCore().getFormat();
	} // getFormat

	/**
	 * @return the {@link URI} to the serialized {@link Identifiable}.
	 */
	private final URI getURI() {
		// Already have the URI?
		if (uri == null) {
			// No
			uri = URI.createURI(dublinCore.getIdentifier());
		} // if
		return uri;
	} // getURI

	/**
	 * @return the {@link DublinCore}
	 */
	public final DublinCoreImpl getDublinCore() {
		return dublinCore;
	}

	/**
	 * @param o
	 * @return the value of the compare
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(final IdentifiableDelegate o) {
		return toString().compareTo(o.toString());
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object o) {
		boolean retValue = false;
		if (o != null) {
			// Yes
			retValue = toString().equals(o.toString());
		} // if
		return retValue;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

	/**
	 * I don't think this is ever called, there is a reference to it, but I
	 * don't think it ever gets invoked.
	 * 
	 * @return the parent
	 */
	public Object getParent() {
		return parent;
	}

} // IdentifiableDelegate