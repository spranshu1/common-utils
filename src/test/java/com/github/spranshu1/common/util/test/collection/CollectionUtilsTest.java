/*
 * Created By: Pranshu Shrivastava

 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.spranshu1.common.util.test.collection;

import com.github.spranshu1.common.util.collection.CollectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * The type Collection utils test.
 */
public class CollectionUtilsTest {


    /**
     * Convert String to Integer.
     */
    private static final Function<String, Integer> strToInt = new Function<String, Integer>() {

        /**
         * Apply conversion of String to Integer
         */
        @Override
        public Integer apply(final String value) {
            return Integer.parseInt(value);
        }

    };

    /**
     * Test convert list.
     */
    @Test
    @DisplayName("Convert list to another list")
    public void testConvertList() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("13");
        strings.add("15");

        List<Integer> numbers = CollectionUtil.convertList(strings, strToInt);

        Assertions.assertNotNull(numbers, "Unable to convert given list");
    }

    /**
     * Tes list is empty.
     */
    @Test
    @DisplayName("Check if list is empty")
    public void tesListIsEmpty() {
        List<String> strings = new ArrayList<>();

        Assertions.assertTrue(CollectionUtil.listIsEmpty(strings));
    }

    /**
     * Tes list is not empty.
     */
    @Test
    @DisplayName("Check if list is not empty")
    public void tesListIsNotEmpty() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("13");
        strings.add("15");
        Assertions.assertTrue(CollectionUtil.listIsNotEmpty(strings));
    }

    /**
     * Test collection is empty.
     */
    @Test
    @DisplayName("Check if given collection is empty")
    public void testCollectionIsEmpty() {
        List<String> strings = new ArrayList<>();
        Set<String> data = new HashSet<>();

        Assertions.assertTrue(CollectionUtil.isEmpty(strings));
        Assertions.assertTrue(CollectionUtil.isEmpty(data));
    }

    /**
     * Test array to list.
     */
    @Test
    @DisplayName("Convert array to list")
    public void testArrayToList() {
        Object[] obj = new Object[3];
        obj[0] = "first";
        obj[1] = "second";
        obj[2] = "third";
        List list = CollectionUtil.arrayToList(obj);

        Predicate<List> check = x -> x.size() == 3;

        Assertions.assertNotNull(list);
        Assertions.assertTrue(check.test(list));
    }

    @Test
    @DisplayName("Merge array to collection")
    public void testMergeArrayToCollection() {
        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;

        Set data = new HashSet();

        CollectionUtil.mergeArrayIntoCollection(arr, data);
        Predicate<Set> check = x -> x.size() == 3;
        Assertions.assertTrue(check.test(data));
    }

    @Test
    @DisplayName("Merge properties into map")
    public void testMergePropertyMap(){
        Properties prop = new Properties(System.getProperties());

        Map<String, String> data = new HashMap<>();

        CollectionUtil.mergePropertiesIntoMap(prop, data);

        Predicate<Map<String, String>> check = x -> x.containsKey("java.specification.version");

        Assertions.assertTrue(check.test(data));
    }

    @Test
    @DisplayName("Check collection contains given instance")
    public void testContainsInstance(){
        Set<String> data = new HashSet<>();
        data.add("test");
        boolean result = CollectionUtil.containsInstance(data,"test");

        Assertions.assertTrue(result);
    }

}
