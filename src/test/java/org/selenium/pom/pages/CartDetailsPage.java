package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class CartDetailsPage  extends BasePage {


    private final By RaiseAmendments = By.xpath("(//span[@class='cssCircle-plusdesign'])[5]");
    private final By clickOnAmendmentsType = By.id("type");
    private final By clickOnRaiseBtn = By.xpath("//button[@class='btn sign_btn ']");
    private final By amendmentid = By.xpath("(//*[@class='cart_info-field--detail'])[11]");
    private final By assignMeBtn = By.xpath("//*[@class='fa fa-address-book-o assignme-icon info-fa-icon']");
    private final By processBtn = By.xpath("//*[text()='Process']");
    private final By bookingSummeryLink = By.xpath("//*[text()='Booking Summary']");
    public CartDetailsPage(WebDriver driver) {
        super(driver);
    }

@Step
    public CartDetailsPage clickOnRaiseAmendments(){
        Log.info("Clicking on Raise Amendments on............. ");
        WebElement e = wetForElementTOClicable(RaiseAmendments);
        e.click();
        Log.info("Clicked on Raise Amendments on");
        return this;
    }
    @Step
    public CartDetailsPage clickOnAmendmentsType(){
        Log.info("clicking on Amendments type drop down..........");
        WebElement e = wetForElementTOClicable(clickOnAmendmentsType);
        e.click();
        Log.info("clicked on amendments type drop down and value get appear to select the Amendment type");
        return this;
    }
    @Step
    public CartDetailsPage clickOnSelectAmendments(String amendmentsName){
        Log.info("clicking on Amendments type drop down..........");
        WebElement e = wetForElementTOClicable(clickOnAmendmentsType);
        e.click();
        Log.info("clicked on amendments type drop down and value get appear to select the Amendment type");
        WebElement e1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[text()='" + amendmentsName + "']")));
        Log.info("checking to  select the Amendments type As "+amendmentsName);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
        e1.click();
        Log.info("have selected the Amendments type As "+amendmentsName);
        return this;
    }
    @Step
    public SelectPaxForAmendmentsPage clickOnRaiseAmendmentsBtn(){
        Log.info("clicking on raise Amendments Button.................");
        WebElement e = wetForElementTOClicable(clickOnRaiseBtn);
        e.click();
        Log.info("clicked on raise amendments button and get in to select pax for amendments page");
        return new SelectPaxForAmendmentsPage(driver);
    }
    @Step
     public CartDetailsPage clickOnAssignMeBtn(){
        Log.info("clicking on assign me button as admin...........");
        WebElement e = wetForElementTOClicable(assignMeBtn);
        e.click();
         Log.info("clicked on assign me button as admin");
        return this;
     }
     @Step
     public ProcessAmendmentPage clickOnProcessBtn(){
        Log.info("clicking on process button..............");
        WebElement e = wetForElementTOClicable(processBtn);
        e.click();
        Log.info("clicked on process button and get in to process Amendments page");
        return new ProcessAmendmentPage(driver);
     }
     @Step
     public BookingSummaryPage clickOnBookingSummery(){
        Log.info("clicking on booking summery link of cart details page");
        WebElement e = wetForElementTOClicable(bookingSummeryLink);
        e.click();
        Log.info("clicked on booking summery link of cart details page and get back to booking summery page");
        return new BookingSummaryPage(driver);
     }

}
