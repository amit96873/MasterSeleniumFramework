package org.selenium.pom.pages;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
public class FlightPage extends BasePage {

    private final By onewayBtn= By.xpath("//span[text()='ONE WAY']");
    private final By roundtripBtn= By.xpath("//span[text()='ROUND TRIP']");
    private final By multicityBtn= By.xpath("//span[text()='MULTI CITY']");
    private  final By sourceInputField = By.xpath("//div[text()='Where From ?']");
    private final By destinationInputField = By.xpath("//div[text()='Where To ?']");
    private  final By departuredate = By.xpath("//input[@name='departure']");
    private final  By returndate = By.xpath("//input[@name='returnRef']");
    private final By selectpax = By.xpath("//input[@class='form-control form-control-positionHandle']");
    private final By searchBtn  = By.xpath("//button[text()='Search']");
    private final By selectPrefferedAirline = By.xpath("//span[text()='Select Preferred Airline']");
    private final By inputfieldPrefferedAirline= By.xpath("//div[text()='Search']");
    private final By directflightcheckbox= By.xpath("//span[text()='Direct Flight']");
    private final By creditshellCheckbox= By.xpath("//span[text()='Credit Shell']");
    private final By creditPnr= By.xpath("//input[@name='creditShellPnr']");
    private final By regularFareCheckBox= By.xpath("//label[text()='Regular Fares']");
    private final By studenFareCheckBox= By.xpath("//label[text()='Student Fares']");
    private final  By seniourCitizenFareCheckBox = By.xpath("//label[text()='Senior Citizen Fares']");
    private final By viewLatSearch = By.xpath("//p[text()='View your last search']");


    public FlightPage(WebDriver driver) {
        super(driver);
    }


}
