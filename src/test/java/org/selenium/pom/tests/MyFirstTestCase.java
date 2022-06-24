package org.selenium.pom.tests;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.FlightSearchPageDataObject;
import org.selenium.pom.objects.LoginCredentials;
import org.selenium.pom.objects.SearchResultsPageDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.DashboardPage;
import org.selenium.pom.pages.FlightPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.SearchResultPage;
import org.selenium.pom.pages.components.MyHeaders;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void apiStagingTest() throws IOException, InterruptedException {

        FlightSearchPageDataObject flightSearchPageDataObject = JacksonUtils.deserializeJson("flightSearchData.json",FlightSearchPageDataObject.class);
        SearchResultsPageDataObject searchResultsPageDataObject = JacksonUtils.deserializeJson("searchResultsData.json",SearchResultsPageDataObject.class);

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());

                        DashboardPage dashboardPage = new HomePage(getDriver()).
                        load().login(user);
                        dashboardPage.isLoaded();
                        FlightPage flightPage = new MyHeaders(getDriver()).
                        clickOnFlight().enterSource(flightSearchPageDataObject.getSource()).
                        enterDestination(flightSearchPageDataObject.getDestination()).
                        selectDate(flightSearchPageDataObject.getDate(),flightSearchPageDataObject.getMonthYear()).
                                selectPreferredAirline(flightSearchPageDataObject.getPreferredAirlines()).
                                selectPax(flightSearchPageDataObject.getAdults(),
                                        flightSearchPageDataObject.getChilds(),
                                        flightSearchPageDataObject.getInfants());
                        SearchResultPage searchResultPage = flightPage.clickOnSearchBtn();
                        Thread.sleep(6000);
                        Assert.assertEquals(searchResultPage.getTitle(),searchResultsPageDataObject.getTitle());



    }
}
