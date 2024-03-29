package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

import java.util.List;

public class ReviewPage extends BasePage {


    private final By addPaxBtn= By.xpath("//i[@class='fa fa-angle-double-right proceed-button-positionHandle']");
    private final By backBtn= By.xpath("//span[text()='BACK']");
    private final By popupContinueBtn = By.xpath("//button[text()='Continue']");
    private final By popupBackBtn = By.xpath("//button[text()='Back']");
    private  final By popupTitle = By.xpath("//h1[text()='Confirm to proceed']");


    public ReviewPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public PaxDetailsPage clickOnAddPassangerBtn() throws InterruptedException {
            Log.info("trying to click on add passenger button.......");
            Thread.sleep(5000);
            WebElement e = wetForElementTOClicable(addPaxBtn);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
            e.click();
            Log.info("clicked on add passenger button.......");
            return new PaxDetailsPage(driver);
    }
    @Step
    public SearchResultPage clickOnBackBtn(){
        Log.info("clicking on back button..........");
        WebElement e = wetForElementTOClicable(backBtn);
        e.click();
        Log.info("clicked on back button..........");
        return new SearchResultPage(driver);
    }
    @Step
    public ReviewPage clickOnPopupContinueBtn(){
        Log.info("clicking on popup continue button.........");
        WebElement e = wetForElementTOClicable(popupContinueBtn);
        e.click();
        Log.info("clicked on popup continue button.........");
        return this;
    }
    @Step
    public String getTitlePopupOfReviewPage(){

        Log.info("getting the pop up status of the review page");
        WebElement e = wetForElementTOVisible(popupTitle);
        String popupTitle = e.getText();
        Log.info("got the status As "+popupTitle+"");
        return popupTitle;
    }
    @Step
    public ReviewPage checkPopupAndClickOnContinue(){
        WebElement e = wetForElementTOVisible(popupTitle);
        String title = e.getText();
        String s = "Confirm to proceed";
        if(title.equalsIgnoreCase(s)){
            WebElement e1 = wetForElementTOClicable(popupContinueBtn);
            e1.click();
        }
        return this;
    }
}
