package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.LoginCredentials;
import org.selenium.pom.objects.User;

public class HomePage extends BasePage {

    private final By usernameField = By.cssSelector("#login__form > div:nth-child(1) > input");
    private final By passwordField = By.cssSelector("#paswrd");
    private final By loginBtn = By.cssSelector("#submitButton");
    private final By homePageTitle = By.xpath("//h2[text()='Already using Technogram Solutions?']");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage enterUserName(String username) {
        WebElement e = wetForElementTOVisible(usernameField);
        e.clear();
        e.sendKeys(username);
        return this;
    }
    public   HomePage enterPassword(String password){
        WebElement e = wetForElementTOVisible(passwordField);
        e.clear();
        e.sendKeys(password);
        return this;

    }
    public   DashboardPage clickOnLoginButton(){
        WebElement e = wetForElementTOClicable(loginBtn);
        e.click();
        return new DashboardPage(driver);
    }
    public String getTitle(){
        WebElement e = wetForElementTOVisible(homePageTitle);
        return e.getText();
    }
    public DashboardPage Login(String username, String password) {
        enterUserName(username).enterPassword(password).clickOnLoginButton();
        return new DashboardPage(driver);
    }
    public HomePage load(){
        load("/nav/");
        return this;
    }
   public HomePage setCredentials(LoginCredentials loginCredentials){
                enterUserName(loginCredentials.getUsername()).
                enterPassword(loginCredentials.getPassword());
                return this;
   }
    public HomePage setUsername(LoginCredentials loginCredentials){
        enterUserName(loginCredentials.getUsername());
        return this;
    }
    public HomePage setPassword(LoginCredentials loginCredentials){
                enterPassword(loginCredentials.getPassword());
        return this;
    }
    public Boolean isLoaded(){
        return  wait.until(ExpectedConditions.textToBe(homePageTitle,"Already using Technogram Solutions?"));
    }
    public DashboardPage login(User user){
        enterUserName(user.getUsername()).enterPassword(user.getPassword());
        HomePage homePage= new HomePage(driver);
        homePage.clickOnLoginButton();
        return new DashboardPage(driver);

    }

}
