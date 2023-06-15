package com.epam.training.student_Aleksei_Guskov.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.training.student_Aleksei_Guskov.service.VariantsChoice.withCredentialsFromProperty;

public class PageGooglePlatformCalculator {
    protected WebDriver driver;
    private String xPathForOperationSystem = "//div/md-select-menu/md-content/md-option[@value='" + withCredentialsFromProperty().getOperatingSystemXPath() + "']";
    private String xPathForSSDAmount = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer'][@value='" + withCredentialsFromProperty().getLocalSSDAmount() + "']";
    private String xPathForCommittedYear = "//md-option[@value='" + withCredentialsFromProperty().getCommittedUsage() + "'][@class='md-ink-ripple'][@aria-selected='false']";
    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstFrameOnPage;
    @FindBy (xpath = "//*[@id='myFrame']")
    private WebElement frameWhitImportantElements;
    @FindBy (xpath = "//*[@id='tab-item-1']")
    private WebElement computeEngineButton;
    @FindBy (xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement areaNumberOfInstances;
    @FindBy (xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']/md-select-value")
    private WebElement selectorOfOperatingSystem;
    @FindBy (xpath = "//md-select[@placeholder='VM Class']/md-select-value")
    private WebElement selectorProvisioningModel;
    @FindBy (xpath = "//div/md-select-menu/md-content/md-option[@value='regular']")
    private WebElement regularProvisioningModel;
    @FindBy (xpath = "//md-select[@placeholder='Series']/md-select-value")
    private WebElement selectorOfSeries;
    @FindBy (xpath = "//div/md-select-menu/md-content/md-option[@value='n1']")
    private WebElement nOneSeries;
    @FindBy (xpath = "//md-select[@placeholder='Instance type']/md-select-value")
    private WebElement machineTypeSelector;
    @FindBy (xpath = "//div/md-select-menu/md-content//md-optgroup/md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    private WebElement nOneStandardOptionMachine;
    @FindBy (xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']/div[@md-ink-ripple]")
    private WebElement addGPUsCheckBox;
    @FindBy (xpath = "//md-select[@placeholder='GPU type']")
    private WebElement selectorTypeOfGPU;
    @FindBy (xpath = "//div/md-select-menu/md-content/md-option[@value='NVIDIA_TESLA_T4']")
    private WebElement teslaTForeOption;
    @FindBy (xpath = "//md-select[@placeholder='Number of GPUs']/md-select-value")
    private WebElement numberOfGPUsSelector;
    @FindBy (xpath = "//div/md-select-menu/md-content/md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU'][@value='1']")
    private WebElement selectNumberOfGPUsOne;
    @FindBy (xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement selectorOfSSDOptions;
    @FindBy (xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationOptions;
    @FindBy (xpath = "//md-option[@value='europe-west3'][@ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']")
    private WebElement selectEuropeWestThirdOption;
    @FindBy (xpath = "//md-select[@ng-disabled='listingCtrl.isCudDisabled']")
    private WebElement committedUsageSelector;
    @FindBy (xpath = "//div/button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    public PageGooglePlatformCalculator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public PageGooglePlatformCalculator searchComputeEngineOption() {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(3));
        webDriverWait.until(webDriver -> firstFrameOnPage.isEnabled());
        driver.switchTo().frame(firstFrameOnPage);
        driver.switchTo().frame(frameWhitImportantElements);
        this.computeEngineButton.click();
        return this;
    }
    public PageGooglePlatformCalculator inputNumberOfInstances() {
        this.areaNumberOfInstances.sendKeys(withCredentialsFromProperty().getNumberOfInstance());
        return new PageGooglePlatformCalculator(this.driver);
    }
    public PageGooglePlatformCalculator selectFreeOperatingSystem() {
        this.selectorOfOperatingSystem.click();
        WebElement operatingSystem = driver.findElement(By.xpath(xPathForOperationSystem));
        operatingSystem.click();
        return this;
    }
    public PageGooglePlatformCalculator selectRegularProvisioningModel() {
        this.selectorProvisioningModel.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        webDriverWait.until(webDriver -> regularProvisioningModel.isDisplayed());
        this.regularProvisioningModel.click();
        return this;
    }
    public PageGooglePlatformCalculator selectNOneSeries() {
        this.selectorOfSeries.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        webDriverWait.until(webDriver -> nOneSeries.isDisplayed());
        this.nOneSeries.click();
        return this;
    }
    public PageGooglePlatformCalculator selectMachineType() {
        this.machineTypeSelector.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        webDriverWait.until(webDriver -> nOneStandardOptionMachine.isDisplayed());
        this.nOneStandardOptionMachine.click();
        return this;
    }
    public PageGooglePlatformCalculator addGPUsOperations() {
        this.addGPUsCheckBox.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        webDriverWait.until(webDriver -> selectorTypeOfGPU.isDisplayed());
        this.selectorTypeOfGPU.click();
        webDriverWait.until(webDriver -> teslaTForeOption.isDisplayed());
        this.teslaTForeOption.click();
        webDriverWait.until(webDriver -> numberOfGPUsSelector.isDisplayed());
        this.numberOfGPUsSelector.click();
        webDriverWait.until(webDriver -> selectNumberOfGPUsOne.isDisplayed());
        this.selectNumberOfGPUsOne.click();
        return this;
    }
    public PageGooglePlatformCalculator selectLocalSSD() {
        this.selectorOfSSDOptions.click();
        WebElement localSSDAmount = driver.findElement(By.xpath(xPathForSSDAmount));
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        webDriverWait.until(webDriver -> localSSDAmount.isDisplayed());
        localSSDAmount.click();
        return this;
    }
    public PageGooglePlatformCalculator selectRegionOption() {
        this.datacenterLocationOptions.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        webDriverWait.until(webDriver -> selectEuropeWestThirdOption.isDisplayed());
        this.selectEuropeWestThirdOption.click();
        return this;
    }
    public void selectCommittedUsageOptionAndAddToEstimate() {
        this.committedUsageSelector.click();
        WebElement committedUsage = driver.findElement(By.xpath(xPathForCommittedYear));
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        webDriverWait.until(webDriver -> committedUsage.isDisplayed());
        committedUsage.click();
        this.addToEstimateButton.click();
    }
}