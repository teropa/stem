// TransportMode.java
package org.eclipse.stem.definitions.labels;

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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * This class represents the enumeration of the different types of
 * transportation modes that can be used to move population members between one
 * location and another.
 * 
 * @model
 */
public enum TransportMode implements Enumerator
{
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED_LITERAL(0, "unspecified", "unspecified"),
	/**
	 * The '<em><b>Air</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AIR
	 * @generated
	 * @ordered
	 */
	AIR_LITERAL(2, "air", "air"),
	/**
	 * The '<em><b>Road</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ROAD
	 * @generated
	 * @ordered
	 */
	ROAD_LITERAL(4, "road", "road"),
	/**
	 * The '<em><b>Rail</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RAIL
	 * @generated
	 * @ordered
	 */
	RAIL_LITERAL(6, "rail", "rail"),
	/**
	 * The '<em><b>Marine</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MARINE
	 * @generated
	 * @ordered
	 */
	MARINE_LITERAL(8, "marine", "marine"),
	/**
	 * The '<em><b>Foot</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #FOOT
	 * @generated
	 * @ordered
	 */
	FOOT_LITERAL(10, "foot", "foot");
	/**
	 * @model name="unspecified"
	 */
	public static final int UNSPECIFIED = 0;

	/**
	 * @model name="air"
	 */
	public static final int AIR = 2;

	/**
	 * Vehicular transport
	 * 
	 * @model name="road"
	 */
	public static final int ROAD = 4;

	/**
	 * Rail road
	 * 
	 * @model name="rail"
	 */
	public static final int RAIL = 6;

	/**
	 * Travel by waterway
	 * 
	 * @model name="marine"
	 */
	public static final int MARINE = 8;

	/**
	 * Self-powered walking
	 * 
	 * @model name="foot"
	 */
	public static final int FOOT = 10;

	/**
	 * An array of all the '<em><b>Transport Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final TransportMode[] VALUES_ARRAY =
		new TransportMode[] {
			UNSPECIFIED_LITERAL,
			AIR_LITERAL,
			ROAD_LITERAL,
			RAIL_LITERAL,
			MARINE_LITERAL,
			FOOT_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Transport Mode</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<TransportMode> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Transport Mode</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransportMode get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransportMode result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transport Mode</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransportMode getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			TransportMode result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Transport Mode</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static TransportMode get(int value) {
		switch (value) {
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
			case AIR: return AIR_LITERAL;
			case ROAD: return ROAD_LITERAL;
			case RAIL: return RAIL_LITERAL;
			case MARINE: return MARINE_LITERAL;
			case FOOT: return FOOT_LITERAL;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private TransportMode(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
}
