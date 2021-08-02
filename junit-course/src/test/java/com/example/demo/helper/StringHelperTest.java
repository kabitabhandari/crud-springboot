package com.example.demo.helper;

import com.example.demo.StringHelper;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringHelperTest {

    StringHelper sh = new StringHelper();
    @Test
    public void shouldtruncateAInFirst2Positions(){
         final String name = "AAple";
        String actualValue = sh.truncateAInFirst2Positions(name);
        Assert.assertEquals( "ple", actualValue);
    }

    @Test
    public void shouldTruncatetoEmptyStringWhenOnlyTwoCharPresentAndBothAs(){
        final String name = "AA";
        String actualValue = sh.truncateAInFirst2Positions(name);
        Assert.assertEquals("", actualValue);
    }

    @Test
    public void firstAndLastTwoCharactersTheSameShouldReturnTrue(){
        final String name = "AAAA";
        Boolean actualValue = sh.areFirstAndLastTwoCharactersTheSame(name);
        Assert.assertTrue(actualValue);
    }

    @Test
    public void firstAndLastTwoCharactersTheSameShouldReturnFalse(){
        final String name = "AABB";
        Boolean actualValue = sh.areFirstAndLastTwoCharactersTheSame(name);
        Assert.assertFalse(actualValue);
    }


}
