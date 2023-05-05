package com.epam.training.student_Aleksei_Guskov.test;

import com.epam.training.student_Aleksei_Guskov.page.PageWhitEstimate;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.epam.training.student_Aleksei_Guskov.service.VariantsChoice.withCredentialsFromProperty;

public class GooglePlatformEstimatedTest extends CommonConditions{
    SoftAssert softAssert = new SoftAssert();
    private static final String TOTAL_ESTIMATED = withCredentialsFromProperty().getTotalEstimated();
    @Test
    public void testEqualsSelectedParameters() throws InterruptedException {
        createNewPlatform();
        PageWhitEstimate pageWhitEstimate = new PageWhitEstimate(this.driver).examEstimateOnly();
        softAssert.assertEquals(pageWhitEstimate.getTextFromProvisioningModel(),
                PROVISIONING_MODEL, "Provisioning model is not Regular!");
        softAssert.assertEquals(pageWhitEstimate.getTextFromInstanceType(),
                INSTANCE_TYPE, "Instance type is not n1-standard-8!");
        softAssert.assertEquals(
                pageWhitEstimate.getTextFromRegion(),
                REGION, "Region is not Frankfurt!");
        softAssert.assertEquals(pageWhitEstimate.getTextFromLocalSSD(),
                LOCAL_SSD, "Local SSD is not 2x375 GiB!");
        softAssert.assertEquals(pageWhitEstimate.getTextFromCommitmentTerm(),
                COMMITMENT_TERM, "Commitment term is not 1 Year!");
        softAssert.assertEquals(pageWhitEstimate.getTexFromTotalEstimated(),
                TOTAL_ESTIMATED, "Total estimated is not equaled!!!");
        softAssert.assertAll();
    }
}
