/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.definitions.transport.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.stem.definitions.transport.PipeTransportEdge;
import org.eclipse.stem.definitions.transport.TransportFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pipe Transport Edge</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipeTransportEdgeTest extends TestCase {

	/**
	 * The fixture for this Pipe Transport Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdge fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PipeTransportEdgeTest.class);
	}

	/**
	 * Constructs a new Pipe Transport Edge test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeTransportEdgeTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Pipe Transport Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PipeTransportEdge fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Pipe Transport Edge test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdge getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(TransportFactory.eINSTANCE.createPipeTransportEdge());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //PipeTransportEdgeTest
