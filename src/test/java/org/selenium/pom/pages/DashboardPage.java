package org.selenium.pom.pages;

import io.qameta.allure.Step;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.LoginCredentials;
import org.selenium.pom.utils.Log;

public class DashboardPage extends BasePage {
    private final By logoutbtn = By.xpath("//li[text()='Logout']");
    private final By groupdropdoun = By.xpath("//div[text()='Group']");
    private final By userInputField = By.id("react-select-3-input");
    private final By userSearchBtn = By.xpath("//button[text()='Search']");
    private final By emulateUserBtn = By.xpath("//a[text()='Emulate']");



    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public HomePage clickOnLogoutBtn(){
        Log.info("clicking on Logout Button-----------");
        WebElement e = wetForElementTOClicable(logoutbtn);
        e.click();
        Log.info("successfully clicked on Logout Button-----------");
        return new HomePage(driver);
    }

    @Step
    public boolean isLoaded(){
        Log.info("checking by url is dashboard page is loaded or not-----------");
        return wait.until(ExpectedConditions.urlContains("/manage-user"));
    }
    @Step

    public DashboardPage selectGroup(){
        Log.info("clicking on Group dropdown-----------");
        WebElement e = wetForElementTOClicable(groupdropdoun);
        e.click();
        Log.info("clicked on group dropdown");
        return this;
    }
   @Step
    public DashboardPage enterUserId(String userid) throws InterruptedException {
        Log.info("Searching user as"+":-" +userid);
        WebElement e = wetForElementTOVisible(userInputField);
        Thread.sleep(500);
        e.sendKeys(userid);
        Thread.sleep(600);
        e.sendKeys(Keys.ENTER);
        Log.info("get the user as "+":-" +userid);
        return this;
    }
    @Step
    public DashboardPage clickOnUserSearchBtn(){
        Log.info("clicking on search button of user......");
        WebElement e = wetForElementTOClicable(userSearchBtn);
        e.click();
        Log.info("clicked on search button of manage user form and get the user details on the dashboard page");
        return this;
    }
    @Step
    public FlightPage clickOnEmulateUser() throws InterruptedException {
        Log.info("emulating user...............");
        Thread.sleep(500);
       WebElement e = wetForElementTOClicable(emulateUserBtn);
       e.click();
        Log.info("emulated user...............");
        Thread.sleep(5000);
        return new FlightPage(driver);
    }
}
