/**
 * These materials are confidential and proprietary to Intellect Design Arena Ltd. and no part of these
 * materials should be reproduced, published, transmitted or distributed in any form or by any means,
 * electronic, mechanical, photocopying, recording or otherwise, or stored in any information storage or
 * retrieval system of any nature nor should the materials be disclosed to third parties or used in any
 * other manner for which this is not authorized, without the prior express written authorization of
 * Intellect Design Arena Ltd.
 *
 * Copyright 2017 Intellect Design Arena Limited. All rights reserved.
 *
 * @author pranshu.shrivastava
 * @date Feb 25, 2020
 */
package com.common.util.test.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;

import com.common.util.collection.CollectionUtils;



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
		
		List<Integer> numbers = CollectionUtils.convertList(strings, strToInt);
		
		Assert.assertNotNull("No value found", CollectionUtils.findInstanceOfType(numbers, Integer.class));
		
	}

}
