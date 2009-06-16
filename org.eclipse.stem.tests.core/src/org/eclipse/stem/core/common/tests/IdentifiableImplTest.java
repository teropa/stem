// IdentifiableImplTest.java
package org.eclipse.stem.core.common.tests;

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

import org.eclipse.stem.core.common.Identifiable;
import org.eclipse.stem.core.common.impl.IdentifiableImpl;

/**
 * This class represents a JUnit test for Identifiable.
 */
@SuppressWarnings("all")
public class IdentifiableImplTest extends IdentifiableTest {

	/**
	 * @param name
	 */
	public IdentifiableImplTest(String name) {
		super(name);
	}

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		final Identifiable id = new IdentifiableImpl() {/* nothing */
		};
		setFixture(id);
	} // setUp

} // IdentifiableImplTest
