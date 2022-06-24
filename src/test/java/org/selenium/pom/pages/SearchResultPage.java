package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class SearchResultPage extends BasePage {


    private By title = By.xpath("//span[text()='Show Incv']");


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded(){

        return wait.until(ExpectedConditions.urlContains("/flight/list/?from=DEL&to=BOM&dep=2022-08-25&ADT=1&CHD=0&INF=0&pClass=Economy&tripType=0&pft=REGULAR"));
    }

    public String getTitle(){
        WebElement e = wetForElementTOVisible(title);
        return e.getText();
    }
}
