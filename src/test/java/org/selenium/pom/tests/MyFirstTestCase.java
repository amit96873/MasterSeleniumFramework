package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.FlightSearchPageDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.DashboardPage;
import org.selenium.pom.pages.FlightPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.SearchResultPage;
import org.selenium.pom.pages.components.MyHeaders;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

@Epic("Complete Sanity of search page")
@Feature("Oneway Search, Return Search ")
public class MyFirstTestCase extends BaseTest {

    @Story("Oneway sanity testing till search results page ")
    @Link("https://staging.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module of flights search and search results page")
    @Test(dataProvider="getFeaturedAirSearchData", dataProviderClass = MyDataProvider.class)
    public void OnewaySanityTest(FlightSearchPageDataObject flightSearchPageDataObject) throws IOException, InterruptedException {
        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
                        DashboardPage dashboardPage = new HomePage(getDriver()).
                        load().login(user);
                        dashboardPage.isLoaded();
                        FlightPage flightPage = new MyHeaders(getDriver()).
                        clickOnFlight().enterSource(flightSearchPageDataObject.getSource()).
                        enterDestination(flightSearchPageDataObject.getDestination()).
                                selectOnwardsDate(flightSearchPageDataObject.getDate(),flightSearchPageDataObject.getMonthYear()).
                                selectPreferredAirline(flightSearchPageDataObject.getPreferredAirlines()).
                                selectPaxWithAdultsChildsInfant(flightSearchPageDataObject.getAdults(),
                                        flightSearchPageDataObject.getChilds(),
                                        flightSearchPageDataObject.getInfants());
                        SearchResultPage searchResultPage = flightPage.clickOnSearchBtn();
                        Thread.sleep(flightSearchPageDataObject.getWaitTime());
                        Assert.assertEquals(searchResultPage.getTitle(),flightSearchPageDataObject.getTitle());



    }
    @Story("return sanity testing till search results page")
    @Link("https://staging.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till search results page")
    @Test(dataProvider="getFeaturedAirSearchData", dataProviderClass = MyDataProvider.class)
    public void ReturnSanityTest(FlightSearchPageDataObject flightSearchPageDataObject) throws IOException, InterruptedException {
        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        DashboardPage dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        FlightPage flightPage = new MyHeaders(getDriver()).
                clickOnFlight().enterSource(flightSearchPageDataObject.getSource()).
                enterDestination(flightSearchPageDataObject.getDestination()).
                selectOnwardsDate(flightSearchPageDataObject.getDate(),flightSearchPageDataObject.getMonthYear()).
                selectReturnDate(flightSearchPageDataObject.getReturnDate(),flightSearchPageDataObject.getReturnMonthYear()).
                selectPreferredAirline(flightSearchPageDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(flightSearchPageDataObject.getAdults(),
                        flightSearchPageDataObject.getChilds(),
                        flightSearchPageDataObject.getInfants());
        SearchResultPage searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(flightSearchPageDataObject.getWaitTime());
        Assert.assertEquals(searchResultPage.getTitle(),flightSearchPageDataObject.getTitle());



    }
}
