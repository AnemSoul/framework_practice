package com.epam.training.student_Aleksei_Guskov.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PageWhitEmailGenerator {
    protected WebDriver driver;
    protected static String finish = "";
    protected static String newEmail = "";
    @FindBy (xpath = "//a[@href='email-generator']/div[2]")
    private WebElement buttonEmailGeneration;
    @FindBy (xpath = "//button[@onclick=\"clipboard('geny')\"]")
    private WebElement buttonCopyEmail;
    @FindBy (xpath = "//div[@id='geny']")
    private WebElement generationNewEMailArea;
    @FindBy (xpath = "//button[@title='Email Estimate']")
    private WebElement buttonEmailEstimate;
    @FindBy (xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailArea;
    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstFrameOnPage;
    @FindBy (xpath = "//*[@id='myFrame']")
    private WebElement frameWhitImportantElements;
    @FindBy (xpath = "//h2/b")
    private WebElement totalEstimatedLine;
    @FindBy (xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement buttonSendEmail;
    @FindBy (xpath = "//button[@onclick='egengo();']")
    private WebElement buttonCheckTheMail;
    @FindBy (xpath = "//iframe[@name='ifmail']")
    private WebElement frameInMail;
    @FindBy (xpath = "//tbody/tr[1]/td[4]")
    private WebElement areaWhitUSDPrice;
    public PageWhitEmailGenerator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private static final String URL_YOPMAIL = "https://yopmail.com/ru/";
    public PageWhitEmailGenerator openNewPage() {
        this.driver.switchTo().newWindow(WindowType.TAB);
        this.driver.navigate().to(URL_YOPMAIL);
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        webDriverWait.until(webDriver -> buttonEmailGeneration.isEnabled());
        return this;
    }
    public PageWhitEmailGenerator generationNewEmail() {
        this.buttonEmailGeneration.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        webDriverWait.until((webDriver -> buttonCopyEmail.isEnabled()));
        newEmail = generationNewEMailArea.getText();
        return this;
    }
    public PageWhitEmailGenerator returnToTheGooglePage() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        this.driver.switchTo().window(tabs.get(0));
        driver.switchTo().frame(firstFrameOnPage);
        driver.switchTo().frame(frameWhitImportantElements);
        return this;
    }
    public String getTexFromTotalEstimated() {
        Pattern pattern = Pattern.compile("[\\d,]*\\d{3}[.]\\d{2}");
        String start = this.totalEstimatedLine.getText();
        String finish = "";
        Matcher matcher = pattern.matcher(start);
        while (matcher.find()) {
            finish = matcher.group();
        }
        return finish;
    }
    public PageWhitEmailGenerator onGooglePageClickEmailEstimate() {
        this.buttonEmailEstimate.click();
        WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        webDriverWait.until((webDriver -> emailArea.isEnabled()));
        this.emailArea.sendKeys(newEmail);
        return this;
    }
    public PageWhitEmailGenerator sendEmailAndGoToYopmailPage() {
        this.buttonSendEmail.click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        this.driver.switchTo().window(tabs.get(1));
        return this;
    }
    public void checkTheMailButtonClick() {
        this.buttonCheckTheMail.click();
    }
    public String getTextFromEmail() {
        for (int i = 0; (i < 10) && (finish.equals("")); i++) {
            try {
                WebDriverWait webDriverWait = new WebDriverWait(this.driver, Duration.ofSeconds(3));
                webDriverWait.until(webDriver -> frameInMail.isEnabled());
                this.driver.switchTo().frame(frameInMail);
                Pattern pattern = Pattern.compile("[\\d,]*\\d{3}[.]\\d{2}");
                String start = this.areaWhitUSDPrice.getText();
                Matcher matcher = pattern.matcher(start);
                while (matcher.find()) {
                    finish = matcher.group();
                }
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        }
        return finish;
    }
}