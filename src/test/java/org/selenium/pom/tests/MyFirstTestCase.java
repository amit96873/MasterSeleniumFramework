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
import java.util.logging.LogManager;
import java.util.logging.Logger;

@Epic("Staging tgs sanity testing")
@Feature("login page, dashboard page,Flight page,Search results page")
public class MyFirstTestCase extends BaseTest {

    @Story("sanity testing till search results page for Oneway")
    @Link("https://staging.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Login with valid credential and go for the dashboard page and then click on flight options and then it should get in to flight search page and do some operations and then able to search the flights for oneway and get in to search results page")
    @Test(dataProvider="getFeaturedAirSearchData", dataProviderClass = MyDataProvider.class)
    public void onewayTest(FlightSearchPageDataObject flightSearchPageDataObject) throws IOException, InterruptedException {

                        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
                        DashboardPage dashboardPage = new HomePage(getDriver()).
                        load().login(user);
                        dashboardPage.isLoaded();
                        FlightPage flightPage = new MyHeaders(getDriver()).
                                clickOnFlight().enterSource(flightSearchPageDataObject.getSource()).
                                enterDestination(flightSearchPageDataObject.getDestination()).
                                selectOnwardsDate(flightSearchPageDataObject.getDate(),flightSearchPageDataObject.getMonthYear()).
                                selectPreferredAirline(flightSearchPageDataObject.getPreferredAirlines()).
                                selectPaxWithAdultsChildsInfant(flightSearchPageDataObject.getAdults(), flightSearchPageDataObject.getChilds(), flightSearchPageDataObject.getInfants());
                        SearchResultPage searchResultPage = flightPage.clickOnSearchBtn();
                        Thread.sleep(flightSearchPageDataObject.getWaitTime());
                        Assert.assertEquals(searchResultPage.getTitle(),flightSearchPageDataObject.getTitle());



    }

    @Story("sanity testing till search results page for Return")
    @Link("https://staging.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Login with valid credential and go for the dashboard page and then click on flight options and then it should get in to flight search page and do some operations and then able to search the flights  for return and get in to search results page")
    @Test(dataProvider="getFeaturedAirSearchData", dataProviderClass = MyDataProvider.class)
    public void returnTest(FlightSearchPageDataObject flightSearchPageDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        DashboardPage dashboardPage = new HomePage(getDriver()).load().login(user);
        dashboardPage.isLoaded();
        FlightPage flightPage = new MyHeaders(getDriver()).
                clickOnFlight().clickOnReturnBtn().enterSource(flightSearchPageDataObject.getSource()).
                enterDestination(flightSearchPageDataObject.getDestination()).
                selectOnwardsDate(flightSearchPageDataObject.getDate(),flightSearchPageDataObject.getMonthYear()).
                selectReturnDate(flightSearchPageDataObject.getReturnDate(), flightSearchPageDataObject.getReturnMonthYear()).
                selectPreferredAirline(flightSearchPageDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(flightSearchPageDataObject.getAdults(),flightSearchPageDataObject.getChilds(), flightSearchPageDataObject.getInfants());
        SearchResultPage searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(flightSearchPageDataObject.getWaitTime());
        Assert.assertEquals(searchResultPage.getTitle(),flightSearchPageDataObject.getTitle());



    }
}
