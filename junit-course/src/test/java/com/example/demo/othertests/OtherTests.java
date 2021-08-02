package com.example.demo.othertests;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.util.Arrays;

public class OtherTests {
    //test
    @Test
    public void testIfArrayIsSorted() {
        int[] array_1 = {1, 34, 17, 22};
        Arrays.sort(array_1);
        int[] expected = {1, 17, 22, 34};
        boolean result = Arrays.equals(array_1, expected);
        Assert.assertTrue(result);
        Assert.assertArrayEquals(expected, array_1);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPointer() {
        int[] array_1 = null;
        Arrays.sort(array_1);
    }

    @Test(timeout = 100)
    public void testArrayPerformance() {
        int[] array_1 = {1, 34, 17, 22};
        for(int i=0; i<5000000; i++){
            array_1[0] = i;
        }
        Arrays.sort(array_1);
    }
}