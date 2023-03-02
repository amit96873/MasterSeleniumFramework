package org.selenium.pom.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.qameta.allure.Step;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.apache.tools.ant.taskdefs.optional.javah.Kaffeh;
import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

import java.util.List;

public class FlightPage extends BasePage {

    private final By onewayBtn = By.xpath("//span[text()='ONE WAY']");
    private final By roundtripBtn = By.xpath("//span[text()='ROUND TRIP']");
    private final By multicityBtn = By.xpath("//span[text()='MULTI CITY']");
    private final By departuredate = By.xpath("//input[@name='departure']");
    private final By returndate = By.xpath("//input[@name='returnRef']");
    private final By MultiCityDepartureDateSecond = By.xpath("//input[@name='dep_1']");
    private final By MultiCityDepartureDateThird = By.xpath("//input[@name='dep_2']");

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
    private final By originSecondMultiCityInputField = By.xpath("//input[@id='react-select-5-input']");
    private final By destinationSecondMultiCityInputField = By.xpath("//input[@id='react-select-6-input']");

    private final By monthchangebtn = By.xpath("//button[text()='Next month']");
    private final By paxdonebtn = By.xpath("//a[text()='DONE']");

    public FlightPage(WebDriver driver)
    {
        super(driver);
    }


    @Step
    public FlightPage enterSource(String sourceName) throws InterruptedException {
        Log.info("trying to enter source");
        WebElement e = wetForElementTOVisible(origininputfield);
        Log.info("clicking on source input fields-----------");
        e.click();
        Log.info("clicked on source input fields-----------");
        Log.info("Entering the data source as:- "+sourceName+" on source input fields-----------");
        e.sendKeys(sourceName);
        Log.info("Entered the data source as:- "+sourceName+" on source input fields-----------");
        Thread.sleep(600);
        e.sendKeys(Keys.ENTER);
        Log.info("clicked  on Enter----------");
        return this;
    }

    @Step
    public FlightPage enterDestination(String destinationName) throws InterruptedException {
        Log.info("trying to enter destination");
        WebElement e = wetForElementTOVisible(destinationinputfield);
        Log.info("clicking on destination input fields-----------");
        e.click();
        Log.info("clicked on destination input fields-----------");
        Log.info("Entering the data destination as:- "+destinationName+" on destination input fields-----------");
        e.sendKeys(destinationName);
        Log.info("Entered the data destination as:- "+destinationName+" on destination input fields-----------");
        Thread.sleep(600);
        e.sendKeys(Keys.ENTER);
        Log.info("clicked on Enter Button-----------");
        return this;
    }

    @Step
    public FlightPage enterMultiCitySecondSource(String multiCitySecondSourceName) throws InterruptedException {
        Log.info("trying to enter multi city second source");
        WebElement e = wetForElementTOVisible(originSecondMultiCityInputField);
        Log.info("clicking on multi city second source input fields-----------");
        e.click();
        Log.info("clicked on multi city second source input fields-----------");
        Log.info("Entering the data source as:- "+multiCitySecondSourceName+" on multi city second source input fields-----------");
        e.sendKeys(multiCitySecondSourceName);
        Log.info("Entered the data source as:- "+multiCitySecondSourceName+" on multi city second source input fields-----------");
        Thread.sleep(600);
        e.sendKeys(Keys.ENTER);
        Log.info("clicked  on Enter----------");
        return this;
    }

    @Step
    public FlightPage enterMultiCitySecondDestination(String multiCitySecondDestinationName) throws InterruptedException {
        Log.info("trying to enter multi city second destination");
        WebElement e = wetForElementTOVisible(destinationSecondMultiCityInputField);
        Log.info("clicking on multi city second destination input fields-----------");
        e.click();
        Log.info("clicked on multi city second destination input fields-----------");
        Log.info("Entering the data multi city second destination as:- "+multiCitySecondDestinationName+" on multi city second destination input fields-----------");
        e.sendKeys(multiCitySecondDestinationName);
        Log.info("Entered the data multi city second destination as:- "+multiCitySecondDestinationName+" on multi city second destination input fields-----------");
        Thread.sleep(600);
        e.sendKeys(Keys.ENTER);
        Log.info("clicked on Enter Button-----------");
        return this;
    }

    @Step
    public FlightPage selectOnwardsDate(String date, String MonthYear) throws InterruptedException {
        Log.info("trying to select departure Date");
        WebElement e = wetForElementTOVisible(departuredate);
        Log.info("clicking on departure Date Calendar");
        e.click();
        Log.info("clicked on departure Date Calendar");

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
        Log.info("have select the date as:-"+date+"-"+MonthYear);
        return this;
    }


    @Step
    public FlightPage selectReturnDate(String returnDate, String returnMonthYear) throws InterruptedException {
        Log.info("Trying to select Return Date");
        WebElement e = wetForElementTOVisible(returndate);
        Log.info("clicking on Return Date Calendar");
        e.click();
        Log.info("clicked on Return Date Calendar");

        while (!driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText().contains(returnMonthYear)){
            WebElement element = wetForElementTOClicable(monthchangebtn);
            element.click();
        }

        List<WebElement> al = driver.findElements(By.xpath("//div[@role='option']"));
        for (int i=0;i<al.size();i++){
            String value = al.get(i).getText();
            if (value.equalsIgnoreCase(returnDate)){
                al.get(i).click();
                break;
            }
        }
        Log.info("have select the date as:-"+returnDate+"-"+returnMonthYear);
        return this;
    }

    @Step
    public FlightPage selectMultiCityDepartureDateSecond(String multiCityDepartureDateSecond, String multiCityDepartureMonthYearSecond) throws InterruptedException {
        Log.info("Trying to select Multi City Second Date");
        WebElement e = wetForElementTOVisible(MultiCityDepartureDateSecond);
        Log.info("clicking on Multi City Second  Date Calendar");
        e.click();
        Log.info("clicked on Multi City Second  Date Calendar");

        while (!driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText().contains(multiCityDepartureMonthYearSecond)){
            WebElement element = wetForElementTOClicable(monthchangebtn);
            element.click();
        }

        List<WebElement> al = driver.findElements(By.xpath("//div[@role='option']"));
        for (int i=0;i<al.size();i++){
            String value = al.get(i).getText();
            if (value.equalsIgnoreCase(multiCityDepartureDateSecond)){
                al.get(i).click();
                break;
            }
        }
        Log.info("have select the date as:-"+multiCityDepartureDateSecond+"-"+multiCityDepartureMonthYearSecond);
        return this;
    }

    @Step
    public FlightPage selectMultiCityDepartureDateThird(String multiCityDepartureDateThird, String multiCityDepartureMonthYearThird) throws InterruptedException {
        Log.info("Trying to select Multi City Third Date");
        WebElement e = wetForElementTOVisible(MultiCityDepartureDateThird);
        Log.info("clicking on Multi City Third  Date Calendar");
        e.click();
        Log.info("clicked on Multi City Third  Date Calendar");

        while (!driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']")).getText().contains(multiCityDepartureMonthYearThird)){
            WebElement element = wetForElementTOClicable(monthchangebtn);
            element.click();
        }

        List<WebElement> al = driver.findElements(By.xpath("//div[@role='option']"));
        for (int i=0;i<al.size();i++){
            String value = al.get(i).getText();
            if (value.equalsIgnoreCase(multiCityDepartureDateThird)){
                al.get(i).click();
                break;
            }
        }
        Log.info("have select the date as:-"+multiCityDepartureDateThird+"-"+multiCityDepartureMonthYearThird);
        return this;
    }

    @Step
    public FlightPage selectPaxWithAdultsChildsInfant(String adults, String child, String infants) throws InterruptedException {
        WebElement e1 = wetForElementTOClicable(selectpax);
        Log.info("trying to select pax");
        Log.info("clicking on the select pax");
        e1.click();
        Log.info("clicked on the select pax field");
        Thread.sleep(600);
            WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + adults + "'])[1]")));
            e2.click();
            Log.info("have selected number of Adults is:-"+adults+"Adults");
            WebElement e3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + child + "'])[2]")));
            e3.click();
        Log.info("have selected number of Child is:-"+child+"Child");
            WebElement e4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + infants + "'])[3]")));
            e4.click();
        Log.info("have selected number of Infants is:-"+infants+"Infants");
        WebElement element5 = wetForElementTOClicable(paxdonebtn);
        element5.click();
        Log.info("The number of pax have selected is:-"+adults+"Adults,"+child+"Child,"+infants+"Infants");
        return this;
    }
    @Step
    public FlightPage selectAdultsPax(String adults) throws InterruptedException {
        Log.info("selecting number of Adult pax:-"+adults);
        WebElement e1 = wetForElementTOClicable(selectpax);
        e1.click();
        Thread.sleep(600);
        WebElement e2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + adults + "'])[1]")));
        e2.click();
        Log.info("selected number of Adult pax:-"+adults);
        return this;
    }
    @Step
    public FlightPage selectChildPax(String child){
        Log.info("selecting number of child pax:-"+child);
        WebElement e3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + child + "'])[2]")));
        e3.click();
        Log.info("selected number of child pax:-"+child);
        return this;
    }
    @Step
    public FlightPage selectInfantsPax(String infants){
        Log.info("selecting number of infant pax:-"+infants);
        WebElement e4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='" + infants + "'])[3]")));
        e4.click();
        Log.info("selected number of infant pax:-"+infants);
        return this;
    }
    @Step
    public FlightPage clickOnSelectPaxDoneBtn(){
        Log.info("clicking on select pax done button...........");
        WebElement element5 = wetForElementTOClicable(paxdonebtn);
        element5.click();
        Log.info("clicked on select pax done button");
        return this;
    }
    @Step
    public FlightPage selectPreferredAirline(String airline) throws InterruptedException {
        Log.info("Trying to select preferred Airlines");
        WebElement e = wetForElementTOClicable(selectPrefferedAirline);
        Log.info("clicking on preferred Airlines field");
        e.click();
        Log.info("clicked on preferred Airlines field");
        WebElement element= wetForElementTOVisible(inputfieldPrefferedAirline);
        element.sendKeys(airline);
        Log.info("have selected preferred Airlines As:-"+airline+"Airline");
        Thread.sleep(600);
        element.sendKeys(Keys.ENTER);
        Log.info("click on Enter Button");
        return this;
    }
    @Step
    public SearchResultPage clickOnSearchBtn() {
        WebElement e = wetForElementTOClicable(searchBtn);
        Log.info("clicking on Search Button of flight search page");
        e.click();
        Log.info("clicked on Search Button of flight search page");
        return new SearchResultPage(driver);
    }

    @Step
   public FlightPage clickOnReturnBtn(){
        WebElement e = wetForElementTOClicable(roundtripBtn);
        Log.info("Clicking on RoundTrip Button");
        e.click();
       Log.info("Clicked on RoundTrip Button");
        return this;
   }

    @Step
    public FlightPage clickOnMultiCityBtn(){
        WebElement e = wetForElementTOClicable(multicityBtn);
        Log.info("Clicking on MultiCity Button");
        e.click();
        Log.info("Clicked on MultiCity Button");
        return this;
    }





}