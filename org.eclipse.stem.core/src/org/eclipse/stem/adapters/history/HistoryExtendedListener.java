// HistoryExtendedListener.java
package org.eclipse.stem.adapters.history;

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

/**
 * This interface is implemented by classes that want to be notified when a
 * {@link HistoryProvider} can provide additional history values.
 */
public interface HistoryExtendedListener {
	void historyExtended(final HistoryProviderAdapter historyProviderAdapter);
} // HistoryExtendedListener
