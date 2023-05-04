package com.epam.training.student_Aleksei_Guskov.test;

import com.epam.training.student_Aleksei_Guskov.driver.DriverSingleton;
import com.epam.training.student_Aleksei_Guskov.page.PageGoogleCloudPlatform;
import com.epam.training.student_Aleksei_Guskov.page.PageGooglePlatformCalculator;
import com.epam.training.student_Aleksei_Guskov.page.PageWhitEmailGenerator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {
    protected WebDriver driver;

    private static final String SEARCHING_TEXT= "Google Cloud Platform Pricing Calculator";
    private static final String NUMBER_OF_INSTANCES = "4";
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
                .inputNumberOfInstances(NUMBER_OF_INSTANCES)
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