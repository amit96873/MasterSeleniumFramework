package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class ManageCartsPage extends BasePage {

    private final By bookingUserIdInputField = By.id("react-select-4-input");
    private final By searchBtn = By.xpath("//*[@class='btn sign_btn ']");
    private final By searchInputField  = By.id("tableSearch");
    private final By bookingIdLink = By.xpath("(//*[@class='generic-td '])[3]");

    public ManageCartsPage(WebDriver driver) {
        super(driver);
    }
    @Step
    public ManageCartsPage enterBookingUserId(String userid) throws InterruptedException {
        Log.info("Searching user..............");
        WebElement e = wetForElementTOVisible(bookingUserIdInputField);
        Thread.sleep(500);
        e.sendKeys(userid);
        Thread.sleep(600);
        e.sendKeys(Keys.ENTER);
        Log.info("Searched user as :-"+userid);
        return this;
    }
    @Step
    public ManageCartsPage clickOnSearchBtn(){
        Log.info("clicking on search button........");
        WebElement e = wetForElementTOClicable(searchBtn);
        e.click();
        Log.info("clicked on search button");
        return this;
    }
    @Step
    public ManageCartsPage enterAdultsFirstNameInSearchInputField(String adultFirstName) throws InterruptedException {
        Log.info("entering Adult First Name to search..............");
        WebElement e = wetForElementTOVisible(searchInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.sendKeys(adultFirstName);
        Log.info("have searched by key"+adultFirstName);
        return this;
    }
    @Step
    public CartDetailsPage clickOnBookingId(){
        Log.info("clicking on booking id of Manage cart page......");
        WebElement e = wetForElementTOClicable(bookingIdLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("clicked on booking id of Manage cart page and get back to car details page");
        return new CartDetailsPage(driver);
    }
}
