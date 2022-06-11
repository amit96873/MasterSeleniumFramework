package org.selenium.pom.pages;

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

    public HomePage clickOnLogoutBtn(){
        WebElement e = wetForElementTOClicable(logoutbtn);
        e.click();
        return new HomePage(driver);
    }
    public boolean isLoaded(){
        return wait.until(ExpectedConditions.urlContains("/manage-user"));
    }

    public DashboardPage selectGroup(){
        WebElement e = wetForElementTOClicable(groupdropdoun);
        e.click();
        return this;
//        wait.until(ExpectedConditions.elementToBeClickable(groupdropdoun)).click();
//        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//li[text()='" + groupName + "']")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
//        e.click();
//        return this;
    }

}
