package com.github.spranshu1.common.util.test;

import com.github.spranshu1.common.util.test.collection.CollectionUtilsTest;
import com.github.spranshu1.common.util.test.file.ZipUtilTest;
import com.github.spranshu1.common.util.test.json.JSONHandlerTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The Test suite.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CollectionUtilsTest.class,
        JSONHandlerTest.class,
        ZipUtilTest.class
})
public class TestSuite {
    // the class remains empty,
    // used only as a holder for the above annotations
}
