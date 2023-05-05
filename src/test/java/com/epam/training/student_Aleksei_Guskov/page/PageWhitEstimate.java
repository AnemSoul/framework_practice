package com.epam.training.student_Aleksei_Guskov.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageWhitEstimate {
    private WebDriver driver;
    @FindBy (xpath = "//h2[text()='Estimate']")
    private WebElement estimateHeadAfterCalculation;
    @FindBy (xpath = "//md-list-item[4]/div[1]")
    private WebElement provisioningModelLine;
    @FindBy (xpath = "//md-list-item[5]/div[1]")
    private WebElement instanceTypeLine;
    @FindBy (xpath = "//md-list-item[1]/div[1]")
    private WebElement regionLine;
    @FindBy (xpath = "//md-list-item[8]/div[1]")
    private WebElement localSSDLine;
    @FindBy (xpath = "//md-list-item[3]/div[1]")
    private WebElement commitmentTermLine;
    @FindBy (xpath = "//h2/b")
    private WebElement totalEstimatedLine;
    public PageWhitEstimate(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public PageWhitEstimate examEstimateOnly() {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        webDriverWait.until(webDriver -> estimateHeadAfterCalculation.isDisplayed());
        return this;
    }
    public String getTextFromProvisioningModel() {
        return this.provisioningModelLine.getText();
    }
    public String getTextFromInstanceType() {
        return this.instanceTypeLine.getText();
    }
    public String getTextFromRegion() {
        return this.regionLine.getText();
    }
    public String getTextFromLocalSSD() {
        return this.localSSDLine.getText();
    }
    public String getTextFromCommitmentTerm() {
        return this.commitmentTermLine.getText();
    }
    public String getTexFromTotalEstimated() {
        Pattern pattern = Pattern.compile("[\\d,]*[\\d]{3}[\\.]{1}[\\d]{2}");
        String start = this.totalEstimatedLine.getText();
        String finish = "";
        Matcher matcher = pattern.matcher(start);
        while (matcher.find()) {
            finish = matcher.group();
        }
        return finish;
    }
}