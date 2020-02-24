/**
 * @author pranshu.shrivastava
 * @date Feb 24, 2020
 */
package com.common.util.list;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListUtil {
	
	public static <T, U> List<U> convertList(List<T> from, Function<T, U> func) {
	    return from.stream().map(func).collect(Collectors.toList());
	}
	
	/**
	 * Checks if the given List is null or empty.
	 *
	 * @param list input list to be checked
	 * @return boolean,<br>
	 *         true - if given list is null or empty,<br>
	 *         false - otherwise
	 */
	public static boolean listIsEmpty(final List<?> list) {
		return list==null || list.isEmpty();
	}
	

	/**
	 * Checks if the given List contains any node (i.e. not null and not empty).
	 *
	 * @param list input list to be checked
	 * @return boolean,<br>
	 *         true - if given list contains any node,<br>
	 *         false - otherwise
	 */
	public static boolean listIsNotEmpty(final List<?> list) {
		return !listIsEmpty(list);
	}

}
