package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.LoginCredentials;

public class DashboardPage extends BasePage {
    private final By logoutbtn = By.xpath("//li[text()='Logout']");
    private final By groupdropdoun = By.xpath("//div[text()='Group']");



    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public HomePage clickOnLogoutBtn(){
        WebElement e = wetForElementTOClicable(logoutbtn);
        e.click();
        return new HomePage(driver);
    }

    @Step
    public boolean isLoaded(){

        return wait.until(ExpectedConditions.urlContains("/manage-user"));
    }
    @Step

    public DashboardPage selectGroup(){
        WebElement e = wetForElementTOClicable(groupdropdoun);
        e.click();
        return this;
    }

}
