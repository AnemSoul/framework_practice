package com.epam.training.student_Aleksei_Guskov.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GooglePlatformFinderTest extends CommonConditions{
    private static final String URL_OF_CALCULATION = "https://cloud.google.com/products/calculator";
    @Test
    public void testOfGoogleFinderWithFindAndClickSearcher() {
        openGoogleAndFindTheDesiredResult();
        String actualURL = this.driver.getCurrentUrl();
        Assert.assertEquals(actualURL, URL_OF_CALCULATION);
    }
}
