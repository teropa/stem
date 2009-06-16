package org.eclipse.stem.utility.generators;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * 
 * Autogenerated class
 * 
 */
public class Messages {
	private static final String BUNDLE_NAME = "org.eclipse.stem.utility.generators.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
		// Nothing here
	}

	/**
	 * Returns the externalized string literal.
	 * 
	 * @param key
	 * @return the externalized string literal.
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
