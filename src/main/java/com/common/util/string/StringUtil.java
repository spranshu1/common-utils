/**
 * @author pranshu.shrivastava
 * @date Feb 24, 2020
 */
package com.common.util.string;

import java.util.List;

public class StringUtil {
	
	/**
	 * Checks if the given String field is null or empty (or contains only spaces).
	 *
	 * @param field String parameter
	 * @return boolean,<br>
	 *         true - if given String field is null or empty (or contains only spaces),<br>
	 *         false - otherwise
	 */
	public static boolean strFieldIsEmpty(final String field) {
		return field==null || field.trim().equals("");
	}
	
	/**
	 * Checks if the given String field contains any useful data (i.e. not null, not empty, not contain only spaces).
	 *
	 * @param field String parameter
	 * @return boolean,<br>
	 *         true - if given String field contains useful data,<br>
	 *         false - otherwise
	 */
	public static boolean strFieldIsNotEmpty(final String field) {
		return !strFieldIsEmpty(field);
	}
	
	
	/**
	 * Checks if the given String params are not null/empty and match with each other (Case sensitive).
	 *
	 * @param field1 String first parameter to be compared
	 * @param field2 String second parameter to be compared
	 * @return boolean,<br>
	 *         true - if both the fields are not null/empty and their values match (using equals() operation),<br>
	 *         false - otherwise
	 */
	public static boolean equals(final String field1, final String field2) {
		return strFieldIsNotEmpty(field1) && strFieldIsNotEmpty(field2) && field1.equals(field2);
	}

	/**
	 * Checks if the given String params are not null/empty and match with each other (Case insensitive).
	 *
	 * @param field1 String first parameter to be compared
	 * @param field2 String second parameter to be compared
	 * @return boolean,<br>
	 *         true - if both the fields are not null/empty and their values match (using equalsIgnoreCase() operation),<br>
	 *         false - otherwise
	 */
	public static boolean equalsIgnoreCase(final String field1, final String field2) {
		return strFieldIsNotEmpty(field1) && strFieldIsNotEmpty(field2) && field1.equalsIgnoreCase(field2);
	}
	
	
	
	/**
	 * Matches given string value against List Of Regex Values.
	 *
	 * @param value String value to be matched
	 * @param regexLov List of regex strings
	 * @return boolean,<br>
	 * 		true - if given string matches with one of the regex values in list,<br>
	 * 		false - otherwise.
	 */
	public static boolean matchAgainstRegexLOV(final String value, final List<String> regexLov) {
		
		if (strFieldIsEmpty(value) || regexLov==null) {
			return false;
		}
		
		for (final String regex: regexLov) {
			if (value.matches(regex)) {
				return true;
			}				
		}
		
		return false;
	}



}
