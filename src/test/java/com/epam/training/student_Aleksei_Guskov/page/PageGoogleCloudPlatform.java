package com.epam.training.student_Aleksei_Guskov.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageGoogleCloudPlatform {
    protected WebDriver driver;
    private static final String URL_GOOGLE_CLOUD = "https://cloud.google.com/ ";
    @FindBy ( xpath = "//input[@aria-label='Search']")
    private WebElement searchButtonAndAreaOnStartPage;
    @FindBy ( xpath = "//div[@class='gs-title']/a/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResultForClick;
    public PageGoogleCloudPlatform(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public PageGoogleCloudPlatform openPage() {
        this.driver.get(URL_GOOGLE_CLOUD);
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        webDriverWait.until(webDriver -> searchButtonAndAreaOnStartPage.isEnabled());
        return this;
    }
    public PageGoogleCloudPlatform inputSearchTextInSearchArea(String textForSearchArea) {
        this.searchButtonAndAreaOnStartPage.sendKeys(textForSearchArea);
        return new PageGoogleCloudPlatform(this.driver);
    }
    public PageGoogleCloudPlatform imitationPressEnter() {
        this.searchButtonAndAreaOnStartPage.sendKeys(Keys.ENTER);
        return this;
    }
    public void selectSearchResult() {
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        webDriverWait.until(weDriver -> searchResultForClick.isEnabled());
        this.searchResultForClick.click();
    }
}