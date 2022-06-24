package org.selenium.pom.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.tools.ant.taskdefs.optional.javah.Kaffeh;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

import java.util.List;

public class FlightPage extends BasePage {

    private final By onewayBtn = By.xpath("//span[text()='ONE WAY']");
    private final By roundtripBtn = By.xpath("//span[text()='ROUND TRIP']");
    private final By multicityBtn = By.xpath("//span[text()='MULTI CITY']");
    private final By departuredate = By.xpath("//input[@name='departure']");
    private final By returndate = By.xpath("//input[@name='returnRef']");
    private final By selectpax = By.xpath("//input[@class='form-control form-control-positionHandle']");
    private final By searchBtn = By.xpath("//button[text()='Search']");
    private final By selectPrefferedAirline = By.xpath("//span[text()='Select Preferred Airline']");
    private final By inputfieldPrefferedAirline = By.xpath("//input[@id='react-select-4-input']");
    private final By directflightcheckbox = By.xpath("//span[text()='Direct Flight']");
    private final By creditshellCheckbox = By.xpath("//span[text()='Credit Shell']");
    private final By creditPnr = By.xpath("//input[@name='creditShellPnr']");
    private final By regularFareCheckBox = By.xpath("//label[text()='Regular Fares']");
    private final By studenFareCheckBox = By.xpath("//label[text()='Student Fares']");
    private final By seniourCitizenFareCheckBox = By.xpath("//label[text()='Senior Citizen Fares']");
    private final By viewLatSearch = By.xpath("//p[text()='View your last search']");
    private final By origininputfield = By.xpath("//input[@id='react-select-2-input']");
    private final By destinationinputfield = By.xpath("//input[@id='react-select-3-input']");
    private final By monthchangebtn = By.xpath("//button[text()='Next month']");
    private final By paxdonebtn = By.xpath("//a[text()='DONE']");

    public FlightPage(WebDriver driver) {
        super(driver);
    }

    public FlightPage enterSource(String sourceName) throws InterruptedException {
        WebElement e = wetForElementTOVisible(origininputfield);
        e.click();
        e.sendKeys(sourceName);
        Thread.sleep(500);
        e.sendKeys(Keys.ENTER);
        return this;
    }

    public FlightPage enterDestination(String destinationName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement e = wetForElementTOVisible(destinationinputfield);
        e.click();
        e.sendKeys(destinationName);
        Thread.sleep(500);
        e.sendKeys(Keys.ENTER);
        return this;
    }

    public FlightPage selectDate(String date, String MonthYear) throws InterruptedException {

        WebElement e = wetForElementTOVisible(departuredate);
        e.click();


        while (!driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText().contains(MonthYear)){
            WebElement element = wetForElementTOClicable(monthchangebtn);
            element.click();
        }

        List<WebElement> al = driver.findElements(By.xpath("//div[@role='option']"));
        for (int i=0;i<al.size();i++){
            String value = al.get(i).getText();
            if (value.equalsIgnoreCase(date)){
                al.get(i).click();
                break;
            }
        }
        return this;
    }

    public FlightPage selectPax(String adults, String childs, String infants) throws InterruptedException {
        WebElement e1 = wetForElementTOClicable(selectpax);
        e1.click();
        Thread.sleep(5000);
            WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + adults + "'])[1]")));
            e2.click();
            WebElement e3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + childs + "'])[2]")));
            e3.click();
            WebElement e4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + infants + "'])[3]")));
            e4.click();
        WebElement element5 = wetForElementTOClicable(paxdonebtn);
        element5.click();
        return this;
    }

    public FlightPage selectPreferredAirline(String airline) throws InterruptedException {
        WebElement e = wetForElementTOClicable(selectPrefferedAirline);
        e.click();
        WebElement element= wetForElementTOVisible(inputfieldPrefferedAirline);
        element.sendKeys(airline);
        Thread.sleep(500);
        element.sendKeys(Keys.ENTER);
        return this;
    }

    public SearchResultPage clickOnSearchBtn() {
        WebElement e = wetForElementTOClicable(searchBtn);
        e.click();
        return new SearchResultPage(driver);
    }




}