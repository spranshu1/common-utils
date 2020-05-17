package com.github.spranshu1.common.util.test.hex;

import com.github.spranshu1.common.util.hex.HexUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

/**
 * The type Hex util test.
 */
public class HexUtilTest {

    /**
     * Test to string.
     *
     * @throws UnsupportedEncodingException the unsupported encoding exception
     */
    @Test
    public void testToString() throws UnsupportedEncodingException {
        String test = "Go Corona, Go Corona....";
        String dump = HexUtil.toString(test.getBytes("UTF-8"));
        Pattern pattern = Pattern.compile("\\p{XDigit}+");
        Assert.assertTrue(dump.matches(pattern.toString()));
    }

    /**
     * Test from string.
     */
    @Test
    public void testFromString(){
        String hex = "D5CF";
        byte[] actual = HexUtil.fromString(hex);

        Assert.assertNotNull(actual);
    }

    /**
     * Test from digit.
     */
    @Test
    public void testFromDigit(){
        int result = HexUtil.fromDigit('A');
        Assert.assertEquals(10,result);
    }

    /**
     * Test to digit.
     */
    @Test
    public void testToDigit(){
       char ch = HexUtil.toDigit(10);
       Assert.assertEquals('A',ch);
    }

    /**
     * Test to digit neg.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testToDigitNEG(){
        char ch = HexUtil.toDigit(20);
    }


}
