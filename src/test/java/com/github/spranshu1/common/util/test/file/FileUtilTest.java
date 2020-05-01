package com.github.spranshu1.common.util.test.file;

import com.github.spranshu1.common.util.file.FileUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The type File util test.
 */
public class FileUtilTest {

    private static final Path resourceDirectory = Paths.get("src","test","resources");

    private static final String absolutePath = resourceDirectory.toFile().getAbsolutePath();


    /**
     * Test get file name.
     *
     * @throws FileNotFoundException the file not found exception
     */
    @Test
    @DisplayName("Get File Name Test")
    public void testGetFileName() throws FileNotFoundException {
        final String fileName = FileUtil.getFileName(absolutePath+"/test_data/dummy.txt");
        Assertions.assertEquals("dummy.txt",fileName,"Filename does not match");
    }

    /**
     * Test absolute path.
     *
     * @throws MalformedURLException the malformed url exception
     * @throws URISyntaxException    the uri syntax exception
     */
    @Test
    @DisplayName("Absolute path test")
    @DisabledOnOs(OS.WINDOWS)
    public void testAbsolutePath() throws MalformedURLException, URISyntaxException {
        URL url = new File(absolutePath+"/test_data/dummy.txt").toURL();
        final String path = FileUtil.getAbsolutePath(url);
        Assertions.assertEquals(absolutePath+"/test_data/dummy.txt",path);
    }


}
