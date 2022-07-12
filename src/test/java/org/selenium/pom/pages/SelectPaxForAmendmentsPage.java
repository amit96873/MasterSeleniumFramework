package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class SelectPaxForAmendmentsPage extends BasePage {

    private final By submitSelectedPaxBtn = By.xpath("//*[@class='btn ammend_submit_btn']");
    private final By cancellationDetailsRemarksField = By.xpath("//*[@class='remarks_text']");
    private final By proceedToCancelBtn = By.xpath("//*[text()='Proceed to Cancel']");


    public SelectPaxForAmendmentsPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public SelectPaxForAmendmentsPage selectPax(int paxCount){
        Log.info("selecting the pax to raise amendment");
        for(int i = 1;i<=paxCount;i++){
            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//*[@class='al-label '])["+i+"]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
            e.click();
        }
        Log.info("selected the pax to raise amendment");
        return this;
    }
    @Step
    public SelectPaxForAmendmentsPage clickOnSubmitBtn(){
        Log.info("clicking on submit button of select pax for amendment page..........");
        WebElement e = wetForElementTOClicable(submitSelectedPaxBtn);
        e.click();
        Log.info("clicked on submit button select pax for amendment page");
        return this;
    }
    @Step
    public SelectPaxForAmendmentsPage enterRemarks(String remarks){
        Log.info("adding remarks as:-"+remarks);
        WebElement e = wetForElementTOVisible(cancellationDetailsRemarksField);
        e.clear();
        e.sendKeys(remarks);
        Log.info("added remarks as:-"+remarks);
        return this;
    }
    @Step
    public CartDetailsPage clickOnProceedToCancelBtn(){
        Log.info("clicking on proceed to cancel button");
        WebElement e = wetForElementTOClicable(proceedToCancelBtn);
        e.click();
        Log.info("clicked on proceed to cancel button and grt in to cart details page");
        return new CartDetailsPage(driver);
    }

}
