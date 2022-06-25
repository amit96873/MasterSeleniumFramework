package org.selenium.pom.pages;

import io.qameta.allure.Step;
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

    @Step
    public boolean isLoaded(){

        return wait.until(ExpectedConditions.urlContains("/flight/list/?from=DEL&to=BOM&dep=2022-08-25&ADT=1&CHD=0&INF=0&pClass=Economy&tripType=0&pft=REGULAR"));
    }
    @Step("Type {Search Results page verification text is:- Show Incv, and we found the same as expected}.")
    public String getTitle(){
        WebElement e = wetForElementTOVisible(title);
        String text = e.getText();
        return text;
    }
}
