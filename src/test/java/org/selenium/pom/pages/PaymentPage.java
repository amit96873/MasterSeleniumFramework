package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class PaymentPage extends BasePage {

    private final By TCBtn = By.xpath("//input[@type='checkbox']");
    private final By payNowBtn = By.xpath("//button[@class='btn add_money-btn']");
    private final By payYesBtn = By.xpath("//button[@class='fare-yesbutton']");
    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public PaymentPage clickOnTermsAndConditionsCheckBox(){
        Log.info("trying to click on TC check box............");
        WebElement e = wetForElementTOClicable(TCBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("successfully clicked on TC check box............");
        return this;
    }
    @Step
    public PaymentPage clickOnPayNowBtn(){
        Log.info("trying to click on pay now button.........");
        WebElement e = wetForElementTOClicable(payNowBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("successfully clicked on pay now button.........");
        return this;
    }
    @Step
    public BookingSummaryPage clickOnConfirmPayNowBtn(){
        Log.info("trying to click on confirm pay now button.........");
        WebElement e = wetForElementTOClicable(payYesBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("successfully clicked on confirm pay now button and get in to the booking summery page.........");
        return new BookingSummaryPage(driver);
    }
}
