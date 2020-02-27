/**
 * @author pranshu.shrivastava
 * @date Feb 25, 2020
 */
package com.github.spranshu1.common.util.test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.github.spranshu1.common.util.collection.CollectionUtil;



public class CollectionUtilsTest {
	
	
	/** Maps interest slab to interest type grid. */
	private static Function<String, Integer> strToInt = new Function<String, Integer>() {

		/**
		 * Apply conversion of String to Integer
		 */
		@Override
		public Integer apply(final String value) {
			return Integer.parseInt(value);
		}
		
	};
	
	@Test
	public void testConvertList() {
		List<String> strings = new ArrayList<>();
		strings.add("1");
		strings.add("13");
		strings.add("15");
		
		List<Integer> numbers = CollectionUtil.convertList(strings, strToInt);
		
		Assert.assertNotNull("No value found", CollectionUtil.findInstanceOfType(numbers, Integer.class));
		
	}

}
