package com.github.spranshu1.common.util.test.hex;

import com.github.spranshu1.common.util.hex.HexUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;

public class HexUtilTest {

    @Test
    @DisplayName("Byte array to hexadecimal string")
    public void testToString() throws UnsupportedEncodingException {
        String test = "Go Corona, Go Corona....";
        String dump = HexUtil.toString(test.getBytes("UTF-8"));
        Pattern pattern = Pattern.compile("\\p{XDigit}+");
        Assertions.assertTrue(dump.matches(pattern.toString()));
    }



}
