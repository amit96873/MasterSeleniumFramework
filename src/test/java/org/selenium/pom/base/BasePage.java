package org.selenium.pom.base;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;



    public BasePage(WebDriver driver){
        this.driver=driver;
       wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }


    public void load(String endpoint){
        driver.get(ConfigLoader.getInstance().getBaseUrl() +endpoint);
    }

    public WebElement wetForElementTOVisible(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
    public WebElement wetForElementTOClicable(By element){
        return  wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void moveToElementAndClick(WebDriver driver, WebElement element) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        Thread.sleep(200);

    }

    public static void moveToElementAndSendData(WebDriver driver, WebElement element, String origin) throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
        actions.moveToElement(element).sendKeys(origin);
        Thread.sleep(200);

    }
}
