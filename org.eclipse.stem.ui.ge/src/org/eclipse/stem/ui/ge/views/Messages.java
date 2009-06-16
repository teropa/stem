package org.eclipse.stem.ui.ge.views;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
/**
 * Class generated by the externalizeStrings option.
 * 
 * 
 *
 */
public class Messages {
	private static final String BUNDLE_NAME = "org.eclipse.stem.ui.ge.views.messages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle
			.getBundle(BUNDLE_NAME);

	private Messages() {
	}

	/**
	 * @param key
	 * @return String assigned to the specified key in properties file
	 */
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}