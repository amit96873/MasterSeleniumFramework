package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class SearchResultPage extends BasePage {


    private final By title = By.xpath("//span[text()='Show Incv']");
    private final By selectonwardsconnectingflightrediobtn = By.xpath("(//span[@class='fa fa-info-circle edit-icon-tiles'])[1]");
    private final By bookBtn = By.xpath("(//button[text()='BOOK'])[1]");
    private final By stop1 = By.xpath("//ul//li//a[@class='stop-flights' and  text() = \"1\"]");
    private final By stop0 = By.xpath("//ul//li//a[@class='stop-flights' and  text() = \"0\"]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public boolean isLoaded() {

        return wait.until(ExpectedConditions.urlContains("/flight/list/?from=DEL&to=BOM&dep=2022-08-25&ADT=1&CHD=0&INF=0&pClass=Economy&tripType=0&pft=REGULAR"));
    }

    @Step("Type {Search Results page verification text is:- Show Incv, and we found the same as expected}.")
    public String getTitle() {
        Log.info("getting the title of the Search Results page");
        WebElement e = wetForElementTOVisible(title);
        String text = e.getText();
        Log.info("got the title As " + title + "");
        return text;
    }

    @Step
    public ReviewPage clickOnBookBtn() {
        Log.info("clicking on book button..........");
        WebElement e = wetForElementTOClicable(bookBtn);
        e.click();
        Log.info("clicked on book button..........");
        return new ReviewPage(driver);
    }

    @Step
    public SearchResultPage clickOnStopOne() {
        Log.info("clicking on stop count 1 .............");
        WebElement e = wetForElementTOClicable(stop1);
        e.click();
        Log.info("clicked on stop count 1 ............");
        return this;
    }
    @Step
    public SearchResultPage clickOnStopZero() {
        Log.info("clicking on stop count 0 .............");
        WebElement e = wetForElementTOClicable(stop0);
        e.click();
        Log.info("clicked on stop count 0 ............");
        return this;
    }
    @Step
    public SearchResultPage selectConnectingOnwardsFlight(){
        Log.info("selecting connected onwards flight......");
        WebElement e = wetForElementTOClicable(selectonwardsconnectingflightrediobtn);
        e.click();
        Log.info("selected onwards flight....");
        return this;
    }
    @Step
    public  SearchResultPage searchBySourceId(){
        Log.info("getting current url..............");
        String url = driver.getCurrentUrl();
        Log.info("have received current url as:-"+url);
        Log.info("adding source id in current url");
        String sid = "&sId=5";
        Log.info("have added source id in current url as:-"+sid);
        String newUrl = url+sid;
        Log.info("now current new url is :-"+newUrl);
        driver.get(newUrl);
        return this;
    }

}
