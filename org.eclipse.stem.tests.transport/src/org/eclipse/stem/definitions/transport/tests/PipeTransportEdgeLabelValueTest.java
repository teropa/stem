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
import org.eclipse.stem.definitions.transport.PipeTransportEdgeLabelValue;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Pipe Transport Edge Label Value</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class PipeTransportEdgeLabelValueTest extends TestCase {

	/**
	 * The fixture for this Pipe Transport Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdgeLabelValue fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(PipeTransportEdgeLabelValueTest.class);
	}

	/**
	 * Constructs a new Pipe Transport Edge Label Value test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PipeTransportEdgeLabelValueTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Pipe Transport Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(PipeTransportEdgeLabelValue fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Pipe Transport Edge Label Value test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PipeTransportEdgeLabelValue getFixture() {
		return fixture;
	}

	/**
	 * create the fixture
	 **/
	private static PipeTransportEdgeLabelValue createFixture() {
		PipeTransportEdge edge = PipeTransportEdgeTest.createFixture();
		PipeTransportEdgeLabelValue  edgeLabelValue = (PipeTransportEdgeLabelValue)edge.getLabel().getCurrentValue();
					
		return edgeLabelValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated NOT
	 */
	@Override
	protected void setUp() throws Exception {
		setFixture(createFixture());
	}
	
	/**
	 * @generated NOT
	 */
	public void testPipeTransportEdgeLabelValue() {
		assertTrue(getFixture().sane());
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

} //PipeTransportEdgeLabelValueTest
