package com.github.spranshu1.common.util.test.object;

import com.github.spranshu1.common.util.object.ObjectUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * The type Object util test.
 */
public class ObjectUtilTest {

    /**
     * Test add obj to array.
     */
    @Test
    public void testAddObjToArray(){
        String field = "lorem ipsum";
        String[] arr = new String[5];
        String[] result = ObjectUtil.addObjectToArray(arr,field);
        Assert.assertTrue(result.length > 0);
    }

    /**
     * Test to obj array.
     */
    @Test
    public void testToObjArray(){
        Object[] arr = ObjectUtil.toObjectArray(null);
        Assert.assertNotNull(arr);
    }

}
