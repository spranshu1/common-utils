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
package com.github.spranshu1.common.util.file;

import com.github.spranshu1.common.util.Messages;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Holds utility methods for handling file related operations
 */
public class FileUtil {

    /**
     * Gets filename from filepath.
     * The filename is the farthest element from the root in file directory
     * <pre class="code">
     *     FileUtil.getFileName("D:\data\test.csv") = test.csv
     *     FileUtil.getFileName("D:\data\) = FileNotFoundException
     * </pre>
     *
     * @param filePath the path where file exist
     * @return String representation of file name
     * @throws FileNotFoundException the exception
     */
    public static String getFileName(String filePath) throws FileNotFoundException {
        Path path = Paths.get(filePath);

        Path fileName = path.getFileName();

        if (fileName == null) {
            throw new FileNotFoundException(Messages.ERR_FILE_NOT_FOUND);
        }

        return fileName.toString();
    }


    /**
     * Get absolute path string.
     *
     * @param filePath the file path
     * @return the string
     * @throws URISyntaxException the uri syntax exception
     */
    public static String getAbsolutePath(URL filePath) throws URISyntaxException {
        File file = Paths.get(filePath.toURI()).toFile();
        return file.getAbsolutePath();
    }

    /**
     * Checks if file exist at the filePath.
     * <pre class=code>
     *      FileUtil.fileExist("D:\data\test.csv") = true // if test.csv present at location
     * </pre>
     *
     * @param filePath the path where file exist
     * @return True if a file with valid extension exist, False otherwise
     */
    public static boolean fileExist(String filePath) {
        Path path = Paths.get(filePath);

        Path fileName = path.getFileName();

        if (fileName == null)
            return false;
        else
            return true;
    }


    /**
     * Gets the file extension from file name
     * <pre class=code>
     *      FileUtil.getFileExtension("D:\data\test.csv") = csv
     *      FileUtil.getFileExtension("D:\data\test.xlsx") = xlsx
     * </pre>
     *
     * @param filename the file name
     * @return extension of file eg: .csv or .xlsx
     */
    public static String getFileExtension(final String filename) {

        return filename.substring(filename.lastIndexOf("."));

    }




}