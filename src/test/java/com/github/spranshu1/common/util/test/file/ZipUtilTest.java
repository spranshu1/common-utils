package com.github.spranshu1.common.util.test.file;


import com.github.spranshu1.common.util.file.ZipUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipUtilTest {

    private static Path resourceDirectory = Paths.get("src","test","resources");

    private static String absolutePath = resourceDirectory.toFile().getAbsolutePath();

    private static String SRC_FILE_PATH = absolutePath + "\\test_data\\dummy.txt";

    private static String SRC_DIR_PATH = absolutePath + "\\test_data";

    private static String DESTINATION = absolutePath + "\\test_data\\dummy.zip";


    @Test
    public void testFileZip() throws IOException {
        boolean result = ZipUtil.zip(SRC_FILE_PATH,DESTINATION);
        Assert.assertTrue(result);
    }

}
