/**
 * @author pranshu.shrivastava
 * @date Feb 25, 2020
 */
package com.github.spranshu1.common.util.test.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.github.spranshu1.common.util.collection.CollectionUtil;



public class CollectionUtilsTest {
	
	
	/** Convert String to Integer. */
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
		
		Assert.assertNotNull("Unable to convert given list", numbers);
	}
	
	@Test
	public void tesListIsEmpty() {
		List<String> strings = new ArrayList<>();
		
		Assert.assertTrue(CollectionUtil.listIsEmpty(strings));
	}
	
	@Test
	public void tesListIsNotEmpty() {
		List<String> strings = new ArrayList<>();
		strings.add("1");
		strings.add("13");
		strings.add("15");
		Assert.assertTrue(CollectionUtil.listIsNotEmpty(strings));
	}
	
	@Test
	public void tescollectionIsEmpty() {
		List<String> strings = new ArrayList<>();
		Set<String> data = new HashSet<>();
		
		Assert.assertTrue(CollectionUtil.isEmpty(strings));
		Assert.assertTrue(CollectionUtil.isEmpty(data));
	}
	

}
