package org.selenium.pom.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.pages.DashboardPage;
import org.selenium.pom.pages.FlightPage;
import org.selenium.pom.pages.HomePage;

public class MyHeaders extends BasePage {

    private final By flightLink = By.xpath("//ul//li//a[@class='mainmenu__list--link' and contains(@href,'/flight')]");
    private final By hotelLink = By.xpath("//ul//li//a[@class='mainmenu__list--link' and contains(@href,'/hotel')]");
    private final By dashboardLink = By.xpath("//ul//li//a[@class='mainmenu__list--link' and contains(@href,'/manage-user')]");
    private final By userIdTestingLink = By.xpath("//ul//li//a[@class='mainmenu__list--link' and contains(@href,'/tripjackForm.html?userId')]");
    private final By quickLinks = By.xpath("//li//a[@class='mainmenu__list--link' and contains(@href,'javascript:void(0);') and text()='Quick Links']");
    private final By cruiseLink = By.xpath("//li//a[@class='mainmenu__list--link' and text()='Cruise']");
    private final By cruiseTesting = By.xpath("//li//a[@class='mainmenu__list--link' and text()='Cruise Testing']");
    private final By user = By.xpath("//ul//li[@class='topbar__list' and text()='Hello']");
    private final By myBalance= By.xpath("//ul//li//span[text()='My Balance']");
    private final By refereshMyBalance= By.xpath("//*[@class='topbar__list--refresh-icon']");
    private final By language   = By.xpath("//*[text()='Language']");
    private final By logoutbtn = By.xpath("//*[text()='Logout']");
    private final By logobtn = By.xpath("//img[@class='img-responsive companyLogo-size']");
    private final By userNamelogobtn =By.xpath("//span[@class='navbar-brand-name']");


    public MyHeaders(WebDriver driver) {
        super(driver);
    }


    @Step
    public FlightPage clickOnFlight(){
        WebElement e = wetForElementTOClicable(flightLink);
        e.click();
        return new FlightPage(driver);
    }
    @Step
    public HomePage clickOnLogout(){
        WebElement e = wetForElementTOClicable(logoutbtn);
        e.click();
        return new HomePage(driver);
    }
    @Step
    public DashboardPage clickOnDashboard(){
        WebElement e = wetForElementTOClicable(dashboardLink);
        e.click();
        return new DashboardPage(driver);
    }

}
