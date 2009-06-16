// SanityChecker.java
package org.eclipse.stem.core.common;

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

/**
 * The <code>SanityChecker</code> interface is implemented by classes that can
 * perform a self-check to determine their "sanity" at run-time. If assertions
 * are enabled ("-ea" JVM flag) and an instance finds a problem an assertion
 * will typically fail and the execution will halt. If assertions are not
 * enabled then <code>false</code> will be returned by the {@link #sane()}
 * method and execution will continue.
 * <p>
 * This interface enables the ability to check the consistency of the entire
 * system at run-time. Typically, that is done at strategic points in the
 * execution, for instance, at the start of the main simulation cycle.
 * </p>
 */
public interface SanityChecker {

	/**
	 * This method is for ongoing development and testing purposes. It performs
	 * a "self-check" on the instance of the class. The checking consists of
	 * combination of boolean tests and assertions using the Java "assert"
	 * facility. Assertions must be enabled using the "-ea" JVM flag for the
	 * assertions to be enabled.
	 * <p>
	 * This method is intended to be overridden by extending sub-classes. These
	 * classes should first call the method in the super class (i.e.,
	 * <code>super.sane()</code>) to ensure that the super class is "ok" and
	 * then it can issue its own assertions. <code>
	 * <pre>
	 * void sane() {
	 * 	boolean retValue = super.sane();
	 * 
	 * 	// If foo references bar, then bar should reference foo!
	 * 	retValue = retValue &amp;&amp; (foo.a == bar &amp;&amp; bar.a == foo);
	 * 	assert(retValue);
	 * 
	 * 	return retValue;
	 * } // sane
	 * </pre>
	 * </code>
	 * <p>
	 * The idiom <code>retValue = retValue && &lt;boolean test&gt;</code>
	 * followed by an assertion of the value of <code>retValue</code> is a
	 * typical pattern. If followed, then once a problem is detected, an
	 * assertion will be thrown, or the rest of the tests will be skipped and
	 * the value of <code>false</code> returned. By having <code>sane</code>
	 * return a value rather than simply relying upon the <code>assert</code>
	 * keyword sanity testing can occur even if assertions are not enabled.
	 * <p>
	 * The <code>sane</code> method should be called when the instance is
	 * known to be "stable" so the consistency checks should complete with no
	 * problems (if all is well).
	 * 
	 * @return <code>true</code> if the class passes its self-test,
	 *         <code>false</code> otherwise
	 * @throws AssertionError
	 *             if assertions are enabled and <code>false</code> would be
	 *             returned
	 */
	boolean sane();

} // SanityChecker
