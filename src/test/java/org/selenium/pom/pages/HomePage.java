package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.LoginCredentials;
import org.selenium.pom.objects.User;
import org.selenium.pom.utils.Log;

public class HomePage extends BasePage {

//    private final By usernameField = By.cssSelector("#login__form > div:nth-child(1) > input");
    private final By usernameInputField = By.xpath("//input[@name='username']");
    private final By passwordField = By.cssSelector("#paswrd");
    private final By loginBtn = By.cssSelector("#submitButton");
    private final By homePageTitle = By.xpath("//h2[text()='Already using Technogram Solutions?']");



    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @Step
    public HomePage enterUserName(String username) {
        Log.info("Trying to Enter UserName");
        WebElement e = wetForElementTOVisible(usernameInputField);
        e.clear();
        e.sendKeys(username);
        Log.info("Entered UserName As "+username+"");
        return this;
    }

    @Step
    public   HomePage enterPassword(String password){
        Log.info("Trying to Enter Password");
        WebElement e = wetForElementTOVisible(passwordField);
        e.clear();
        e.sendKeys(password);
        Log.info("Entered Password As "+password+"");
        return this;

    }

    @Step
    public   DashboardPage clickOnLoginButton(){
        Log.info("clicking on Login Button...................");
        WebElement e = wetForElementTOClicable(loginBtn);
        e.click();
        Log.info("clicked on Login Button and get back to the Dashboard Page");
        return new DashboardPage(driver);
    }

    @Step
    public String getTitle(){
        Log.info("getting title of the home page ...........");
        WebElement e = wetForElementTOVisible(homePageTitle);
        String homePageTitleText= e.getText();
        Log.info("got Home Page Title As:-"+homePageTitleText);
        return homePageTitleText;
    }
    @Step
    public DashboardPage Login(String username, String password) {
        Log.info("entering user name As:-"+username+" and password As:-"+password);
        enterUserName(username).enterPassword(password).clickOnLoginButton();
        Log.info("entered user name As:-"+username+" and password As:-"+password);
        return new DashboardPage(driver);
    }
    @Step
    public HomePage load(){
        Log.info("checking by URL the home page loaded or not........");
        load("/nav/");
        Log.info("Home page is loaded successfully");
        return this;
    }
    @Step
   public HomePage setCredentials(LoginCredentials loginCredentials){
                enterUserName(loginCredentials.getUsername()).
                enterPassword(loginCredentials.getPassword());
                return this;
   }
    @Step
    public HomePage setUsername(LoginCredentials loginCredentials){
        enterUserName(loginCredentials.getUsername());
        return this;
    }

    @Step
    public HomePage setPassword(LoginCredentials loginCredentials){
                enterPassword(loginCredentials.getPassword());
        return this;
    }

    @Step
    public Boolean isLoaded(){
        return  wait.until(ExpectedConditions.textToBe(homePageTitle,"Already using Technogram Solutions?"));
    }

    @Step
    public DashboardPage login(User user){
        Log.info("login by using login method and reading the value from properties file ");
        enterUserName(user.getUsername()).enterPassword(user.getPassword());
        HomePage homePage= new HomePage(driver);
        homePage.clickOnLoginButton();
        return new DashboardPage(driver);

    }

}
