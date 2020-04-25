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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


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

    @Test
    public void testConvertList() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("13");
        strings.add("15");

        List<Integer> numbers = CollectionUtil.convertList(strings, strToInt);

        Assertions.assertNotNull(numbers,"Unable to convert given list");
    }

    @Test
    public void tesListIsEmpty() {
        List<String> strings = new ArrayList<>();

        Assertions.assertTrue(CollectionUtil.listIsEmpty(strings));
    }

    @Test
    public void tesListIsNotEmpty() {
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("13");
        strings.add("15");
        Assertions.assertTrue(CollectionUtil.listIsNotEmpty(strings));
    }

    @Test
    public void testCollectionIsEmpty() {
        List<String> strings = new ArrayList<>();
        Set<String> data = new HashSet<>();

        Assertions.assertTrue(CollectionUtil.isEmpty(strings));
        Assertions.assertTrue(CollectionUtil.isEmpty(data));
    }


}
