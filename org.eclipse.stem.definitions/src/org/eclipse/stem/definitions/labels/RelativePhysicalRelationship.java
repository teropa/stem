// RelativePhysicalRelationship.java
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
 * This class represents the enumeration of the different types of relative
 * physical relationships.
 * 
 * @model
 */
public enum RelativePhysicalRelationship implements Enumerator
{
	/**
	 * The '<em><b>Unspecified</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNSPECIFIED
	 * @generated
	 * @ordered
	 */
	UNSPECIFIED_LITERAL(0, "Unspecified", "Unspecified"),
	/**
	 * The '<em><b>Above</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABOVE
	 * @generated
	 * @ordered
	 */
	ABOVE_LITERAL(2, "Above", "Above"),
	/**
	 * The '<em><b>Below</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BELOW
	 * @generated
	 * @ordered
	 */
	BELOW_LITERAL(4, "Below", "Below"),
	/**
	 * The '<em><b>Right Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #RIGHT_OF
	 * @generated
	 * @ordered
	 */
	RIGHT_OF_LITERAL(6, "RightOf", "RightOf"),
	/**
	 * The '<em><b>Left Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LEFT_OF
	 * @generated
	 * @ordered
	 */
	LEFT_OF_LITERAL(8, "LeftOf", "LeftOf"),
	/**
	 * The '<em><b>North Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NORTH_OF
	 * @generated
	 * @ordered
	 */
	NORTH_OF_LITERAL(10, "NorthOf", "NorthOf"),
	/**
	 * The '<em><b>South Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SOUTH_OF
	 * @generated
	 * @ordered
	 */
	SOUTH_OF_LITERAL(12, "SouthOf", "SouthOf"),
	/**
	 * The '<em><b>West Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WEST_OF
	 * @generated
	 * @ordered
	 */
	WEST_OF_LITERAL(14, "WestOf", "WestOf"),
	/**
	 * The '<em><b>East Of</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EAST_OF
	 * @generated
	 * @ordered
	 */
	EAST_OF_LITERAL(16, "EastOf", "EastOf"),
	/**
	 * The '<em><b>Contains</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINS
	 * @generated
	 * @ordered
	 */
	CONTAINS_LITERAL(18, "Contains", "Contains"),
	/**
	 * The '<em><b>Contained By</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTAINED_BY
	 * @generated
	 * @ordered
	 */
	CONTAINED_BY_LITERAL(20, "ContainedBy", "ContainedBy"),
	/**
	 * The '<em><b>Overlaps</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OVERLAPS
	 * @generated
	 * @ordered
	 */
	OVERLAPS_LITERAL(22, "Overlaps", "Overlaps"),
	/**
	 * The '<em><b>Orbits</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORBITS
	 * @generated
	 * @ordered
	 */
	ORBITS_LITERAL(24, "Orbits", "Orbits");
	/**
	 * @model name="Unspecified"
	 */
	public static final int UNSPECIFIED = 0;

	/**
	 * One thing is above another, but not touching.
	 * 
	 * @model name="Above"
	 */
	public static final int ABOVE = 2;

	/**
	 * One thing is below another, but not touching.
	 * 
	 * @model name="Below"
	 */
	public static final int BELOW = 4;

	/**
	 * One thing is to the right of another, but not touching.
	 * 
	 * @model name="RightOf"
	 */
	public static final int RIGHT_OF = 6;

	/**
	 * One thing is to the left of another, but not touching.
	 * 
	 * @model name="LeftOf"
	 */
	public static final int LEFT_OF = 8;

	/**
	 * One thing is to the north of another, but not touching.
	 * 
	 * @model name="NorthOf"
	 */
	public static final int NORTH_OF = 10;

	/**
	 * One thing is to the south of another, but not touching.
	 * 
	 * @model name="SouthOf"
	 */
	public static final int SOUTH_OF = 12;

	/**
	 * One thing is to the west of another, but not touching.
	 * 
	 * @model name="WestOf"
	 */
	public static final int WEST_OF = 14;

	/**
	 * @model name="EastOf"
	 */
	public static final int EAST_OF = 16;

	/**
	 * One thing completely contains another.
	 * 
	 * @model name="Contains"
	 */
	public static final int CONTAINS = 18;

	/**
	 * One thing is contained by another.
	 * 
	 * @model name="ContainedBy"
	 */
	public static final int CONTAINED_BY = 20;

	/**
	 * One thing overlaps another.
	 * 
	 * @model name="Overlaps"
	 */
	public static final int OVERLAPS = 22;

	/**
	 * One orbits another
	 * 
	 * @model name="Orbits"
	 */
	public static final int ORBITS = 24;

	/**
	 * An array of all the '<em><b>Relative Physical Relationship</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RelativePhysicalRelationship[] VALUES_ARRAY =
		new RelativePhysicalRelationship[] {
			UNSPECIFIED_LITERAL,
			ABOVE_LITERAL,
			BELOW_LITERAL,
			RIGHT_OF_LITERAL,
			LEFT_OF_LITERAL,
			NORTH_OF_LITERAL,
			SOUTH_OF_LITERAL,
			WEST_OF_LITERAL,
			EAST_OF_LITERAL,
			CONTAINS_LITERAL,
			CONTAINED_BY_LITERAL,
			OVERLAPS_LITERAL,
			ORBITS_LITERAL,
		};

	/**
	 * A public read-only list of all the '<em><b>Relative Physical Relationship</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RelativePhysicalRelationship> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Relative Physical Relationship</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelativePhysicalRelationship get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RelativePhysicalRelationship result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relative Physical Relationship</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelativePhysicalRelationship getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RelativePhysicalRelationship result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Relative Physical Relationship</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static RelativePhysicalRelationship get(int value) {
		switch (value) {
			case UNSPECIFIED: return UNSPECIFIED_LITERAL;
			case ABOVE: return ABOVE_LITERAL;
			case BELOW: return BELOW_LITERAL;
			case RIGHT_OF: return RIGHT_OF_LITERAL;
			case LEFT_OF: return LEFT_OF_LITERAL;
			case NORTH_OF: return NORTH_OF_LITERAL;
			case SOUTH_OF: return SOUTH_OF_LITERAL;
			case WEST_OF: return WEST_OF_LITERAL;
			case EAST_OF: return EAST_OF_LITERAL;
			case CONTAINS: return CONTAINS_LITERAL;
			case CONTAINED_BY: return CONTAINED_BY_LITERAL;
			case OVERLAPS: return OVERLAPS_LITERAL;
			case ORBITS: return ORBITS_LITERAL;
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
	private RelativePhysicalRelationship(int value, String name, String literal) {
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
