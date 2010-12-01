/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.stem.definitions.transport.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabel;
import org.eclipse.stem.definitions.transport.TransportFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pipe Transport Edge Label</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipeTransportEdgeLabelTest extends TestCase {

	/**
	 * The fixture for this Pipe Transport Edge Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdgeLabel fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PipeTransportEdgeLabelTest.class);
	}

	/**
	 * Constructs a new Pipe Transport Edge Label test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeTransportEdgeLabelTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Pipe Transport Edge Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PipeTransportEdgeLabel fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Pipe Transport Edge Label test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdgeLabel getFixture() {
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
		setFixture(TransportFactory.eINSTANCE.createPipeTransportEdgeLabel());
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

} //PipeTransportEdgeLabelTest
