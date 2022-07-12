package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class ProcessAmendmentPage extends BasePage {
     private final By addNotesInputField = By.xpath("//*[@class='addnotes_content-box']");
     private final By submitBtn = By.xpath("//*[text()='Submit']");
    private final By processBtn = By.xpath("//*[text()='Process']");
    private final By reasonInputField = By.xpath("//*[@class='reason-note']");
    private final By confirmBtn = By.xpath("//*[@class='btn sign_btn cancel-btn-generic']");


    public ProcessAmendmentPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public ProcessAmendmentPage selectAllNACheckBox(){
        Log.info("trying to click on all NA radio button......");
        for(int i = 1;i<=6;i++){
            WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//*[text()='NA'])["+i+"]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
            e.click();
        }
        Log.info("successfully clicked on all NA radio button......");
        return this;
    }
    @Step
    public ProcessAmendmentPage addNotes(String notes){
        Log.info("trying to add notes as:-"+notes);
        WebElement e = wetForElementTOVisible(addNotesInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.sendKeys(notes);
        Log.info("successfully added the notes as:-"+notes);
        return this;
    }
    @Step
    public ProcessAmendmentPage clickOnSubmitBtn(){
        Log.info("trying to click on submit button of process amendments page");
        WebElement e = wetForElementTOVisible(submitBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("successfully clicked on submit button of process amendments page");
        return this;
    }
    @Step
    public ProcessAmendmentPage clickOnProcessBtn(){
        Log.info("trying to click on process button of process amendments page");
        WebElement e = wetForElementTOVisible(processBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("successfully clicked on process button of process amendments page");
        return this;
    }
    @Step
    public ProcessAmendmentPage addReason(String reason){
        Log.info("trying to add reason as:-"+reason);
        WebElement e = wetForElementTOVisible(reasonInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.sendKeys(reason);
        Log.info("successfully added the reason as:-"+reason);
        return this;
    }
    @Step
    public ProcessAmendmentPage clickOnConfirmBtn() {
        Log.info("trying to click on confirm button of process Amendments page");
        WebElement e = wetForElementTOVisible(confirmBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("successfully clicked on confirm button of process Amendments page");
        return this;
    }
    @Step
    public  CartDetailsPage clickOnBackBtn() throws InterruptedException {
        Log.info("pressing back button of chrome.........");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        Log.info("successfully pressed back button of chrome and get in to the cart details page");
        return new CartDetailsPage(driver);
    }
}
