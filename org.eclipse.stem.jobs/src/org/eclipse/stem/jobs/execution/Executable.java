// Executable.java
package org.eclipse.stem.jobs.execution;

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

import java.util.Calendar;
import java.util.Date;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.stem.core.common.impl.DublinCoreImpl;

/**
 * This class is an "adapter" class for the interface {@link IExecutable}. It
 * implements common features of that interface for extending subclasses.
 */
abstract public class Executable extends Job implements IExecutable {

	/**
	 * The {@link Executable}'s sequence number. This value is typically
	 * assigned by the {@link ExecutableManager} when it first creates a
	 * {@link Executable}.
	 */
	private int sequenceNumber = 0;

	/**
	 * The time (wall clock) when this {@link Executable} was created.
	 */
	private final Date creationTime;

	/**
	 * @param name
	 *            the name of the {@link Executable}
	 * @param sequenceNumber
	 *            the unique sequence number of the {@link Executable}
	 */
	public Executable(final String name, final int sequenceNumber) {
		super(name);
		this.sequenceNumber = sequenceNumber;
		this.creationTime = Calendar.getInstance().getTime();
	} // Executable

	/**
	 * @return the unique sequence number of the {@link Executable}
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	} // getSequenceNumber

	/**
	 * @param sequenceNumber
	 *            the unique sequence number of the {@link Executable}
	 */
	public void setSequenceNumber(final int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	} // setSequenceNumber

	/**
	 * @return the name of the Executable with its sequence number as a prefix
	 *         (e.g., "[2] FooBar").
	 * @see #getSequenceNumber()
	 * @see #getName()
	 */
	public String getNameWithSequenceNumber() {
		final StringBuilder retValue = new StringBuilder("[");
		retValue.append(getSequenceNumber());
		retValue.append("] ");
		retValue.append(getName());
		return retValue.toString();
	} // getNameWithSequenceNumber

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#getCreationTime()
	 */
	public Date getCreationTime() {
		return creationTime;
	} // getCreationTime

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#getUniqueIDString()
	 */
	public String getUniqueIDString() {
		final StringBuilder sb = new StringBuilder(URI.encodeSegment(getName(),
				false).replace("%", "-"));
		sb.append("-");
		sb.append(getSequenceNumber());
		sb.append("-");
		sb.append(DublinCoreImpl.createISO8601DateString(getCreationTime()));
		return sb.toString();
	} // getUniqueIDString

	/**
	 * @see org.eclipse.stem.jobs.execution.IExecutable#isStoppable()
	 */
	public boolean isStoppable() {
		return true;
	}

} // Executable
