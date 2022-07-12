package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.layertree.model.Layer;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class TermsAndConditionsPage extends BasePage {
     private final By TCBtn = By.xpath("//input[@type='checkbox']");
     private final By proceedToPayBtn = By.xpath("//i[@class='fa fa-angle-double-right proceed-button-positionHandle']");
    public TermsAndConditionsPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public TermsAndConditionsPage clickOnTermsAndConditionsCheckBox(){
        Log.info("clicking on TC check box of Terms and condition page to enable block button to make hold bookings");
        WebElement e = wetForElementTOClicable(TCBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("clicked on TC check box of Terms and condition page to enable block button to make hold bookings");
        return this;
    }
    @Step
    public PaymentPage clickOnProceedToPayBtn(){
        Log.info("clicking on proceed to pay button.........");
        WebElement e = wetForElementTOClicable(proceedToPayBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("clicked on proceed to pay button and get in to the Payment page");
        return new PaymentPage(driver);
    }
}
