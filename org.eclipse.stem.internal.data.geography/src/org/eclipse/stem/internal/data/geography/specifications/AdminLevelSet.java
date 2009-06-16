package org.eclipse.stem.internal.data.geography.specifications;

/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * This is an ordered set of {@link AdminLevel} instances.
 */
public class AdminLevelSet {
	private static final String DELIMITER = "_"; //$NON-NLS-1$

	/**
	 * These are the administration levels. They are ordered from lowest to
	 * highest.
	 */
	protected List<AdminLevel> adminLevels = new ArrayList<AdminLevel>();

	/**
	 * The maximum administration level in the set.
	 */
	protected AdminLevel maxAdminLevel = new AdminLevel(Integer.MIN_VALUE);

	/**
	 * The minimum administration level in the set.
	 */
	protected AdminLevel minAdminLevel = new AdminLevel(Integer.MAX_VALUE);

	/**
	 * Default Constructor
	 */
	public AdminLevelSet() {
		// Nothing
	} // AdminLevelSet
	

	/**
	 * @param adminLevel
	 *            the initial {@link AdminLevel} in the set.
	 */
	public AdminLevelSet(AdminLevel adminLevel) {
		addAdminLevel(adminLevel);
	} // AdminLevelSet

	/**
	 * @param adminSetToken a string produced by {@link #toString()}
	 */
	public AdminLevelSet(final String adminSetToken) {
		final StringTokenizer st = new StringTokenizer(adminSetToken, DELIMITER);
		while (st.hasMoreElements()) {
			addAdminLevel(new AdminLevel(st.nextToken()));
		}
	} // AdminLevelSet

	/**
	 * @param adminLevel
	 *            the administration level to add to the set.
	 */
	public final void addAdminLevel(final int adminLevel) {
		addAdminLevel(new AdminLevel(adminLevel));
	} // addAdminLevel

	/**
	 * @param adminLevel
	 *            the administration level to add to the set.
	 */
	public final void addAdminLevel(final AdminLevel adminLevel) {
		// Is the admin level already in our collection?
		if (!adminLevels.contains(adminLevel)) {
			// No
			adminLevels.add(adminLevel);
			maxAdminLevel = maxAdminLevel.intValue() >= adminLevel.intValue() ? maxAdminLevel
					: adminLevel;
			minAdminLevel = minAdminLevel.intValue() <= adminLevel.intValue() ? minAdminLevel
					: adminLevel;
			Collections.sort(adminLevels);
		}
	} // addAdminLevel

	/**
	 * Add a list of administration levels to the set
	 * 
	 * @param levels
	 *            a list of administration levels
	 */
	public final void addAdminLevels(final List<AdminLevel> levels) {
		for (final AdminLevel adminLevel : levels) {
			addAdminLevel(adminLevel);
		}
	} // addAdminLevels

	/**
	 * @return the administration levels
	 */
	public final List<AdminLevel> getAdminLevels() {
		return adminLevels;
	} // getAdminLevels

	/**
	 * @return the administration levels in reverse order
	 */
	public List<AdminLevel> getAdminLevelsMaxToMin() {
		final List<AdminLevel> reversedAdminLevels = new ArrayList<AdminLevel>(
				adminLevels.size());
		for (final AdminLevel level : adminLevels) {
			reversedAdminLevels.add(level);
		} // for
		Collections.reverse(reversedAdminLevels);
		return reversedAdminLevels;
	} // getAdminLevelsMaxToMin

	/**
	 * @return the number of administration levels represented in the
	 *         identifiable.
	 */
	public final int getNumAdminLevels() {
		return adminLevels.size();
	} // getNumAdminLevels

	/**
	 * @return the maximum administration level in the data
	 */
	public final AdminLevel getMaxAdminLevel() {
		return maxAdminLevel;
	}

	/**
	 * @return the minimum administration level in the data
	 */
	public final AdminLevel getMinAdminLevel() {
		return minAdminLevel;
	}

	
	/**
	 * Using the set of levels, create the complete collection of allowed groupings.
	 * E.g., with "0, 1, 2", we would produce "0", "1", "2", "0_1", "0_1_2", "1_2"
	 * @return the complete collection of allowed groupings.
	 */
	public List<AdminLevelSet> makeAllLevelSets() {
		final List<AdminLevelSet> retValue = new ArrayList<AdminLevelSet>();
		
		for (int i = 0; i < getNumAdminLevels(); i++) {
			for (int j = i; j < getNumAdminLevels()	; j++) {
				final AdminLevelSet temp = new AdminLevelSet();
				for (int k = i; k <= j; k++) {
					temp.addAdminLevel(adminLevels.get(k));
				} // for k
				retValue.add(temp);
			} // for j
		} // for i
		return retValue;
	} // makeAllLevelSets
	
	/**
	 * @param delimiter
	 *            the string to place between the administration level integers
	 * @return the administration level integers concatenated together with a
	 *         delimiter (e.g., "0_1").
	 */
	public final String toString(final String delimiter) {
		final StringBuilder sb = new StringBuilder();
		for (int i = 0; i < adminLevels.size(); i++) {
			// Is this the first one?
			if (i != 0) {
				// No
				sb.append(delimiter);
			}
			sb.append(adminLevels.get(i));
		}
		return sb.toString();
	} // getAdminLevelsAsString

	/**
	 * @return the administration level integers concatenated together with a
	 *         delimiter (e.g., "0_1").
	 */
	@Override
	public final String toString() {
		return this.toString(DELIMITER);
	} // getAdminLevelsAsString
} // AdminLevelSet
