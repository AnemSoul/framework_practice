package com.epam.training.student_Aleksei_Guskov.test;

import com.epam.training.student_Aleksei_Guskov.driver.DriverSingleton;
import com.epam.training.student_Aleksei_Guskov.page.PageGoogleCloudPlatform;
import com.epam.training.student_Aleksei_Guskov.page.PageGooglePlatformCalculator;
import com.epam.training.student_Aleksei_Guskov.page.PageWhitEmailGenerator;
import com.epam.training.student_Aleksei_Guskov.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import static com.epam.training.student_Aleksei_Guskov.service.VariantsChoice.withCredentialsFromProperty;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    private static final String SEARCHING_TEXT= "Google Cloud Platform Pricing Calculator";
    static final String PROVISIONING_MODEL = "Provisioning model: Regular";
    static final String INSTANCE_TYPE = "Instance type: n1-standard-8\n" +
            "Committed Use Discount applied";
    static final String REGION = "Region: Frankfurt";
    static final String LOCAL_SSD = "Local SSD: " + withCredentialsFromProperty().getLocalSSDAmount() + "x375 GiB\n" +
            "Committed Use Discount applied";
    static final String COMMITMENT_TERM = "Commitment term: " + withCredentialsFromProperty().getCommittedUsage() + " " + withCredentialsFromProperty().getGraduationForYears();
    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = DriverSingleton.getDriver();
    }
    public void openGoogleAndFindTheDesiredResult() {
        new PageGoogleCloudPlatform(this.driver)
                .openPage()
                .inputSearchTextInSearchArea(SEARCHING_TEXT)
                .imitationPressEnter()
                .selectSearchResult();
    }
    public void createNewPlatform() throws InterruptedException {
        openGoogleAndFindTheDesiredResult();
        new PageGooglePlatformCalculator(this.driver)
                .searchComputeEngineOption()
                .inputNumberOfInstances()
                .selectFreeOperatingSystem()
                .selectRegularProvisioningModel()
                .selectNOneSeries()
                .selectMachineType()
                .addGPUsOperations()
                .selectLocalSSD()
                .selectRegionOption()
                .selectCommittedUsageOptionAndAddToEstimate();
    }
    public void sendEmailOnTemporaryMail() throws InterruptedException {
        createNewPlatform();
        new PageWhitEmailGenerator(this.driver)
                .openNewPage()
                .generationNewEmail()
                .returnToTheGooglePage()
                .onGooglePageClickEmailEstimate()
                .sendEmailAndGoToYopmailPage()
                .checkTheMailButtonClick();
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}