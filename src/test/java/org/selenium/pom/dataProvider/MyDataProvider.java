package org.selenium.pom.dataProvider;

import org.selenium.pom.objects.CompleteBookingSanityDataObject;
import org.selenium.pom.objects.FlightSearchPageDataObject;
import org.selenium.pom.objects.SearchResultsPageDataObject;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class MyDataProvider {

    @DataProvider(name = "getFeaturedAirSearchData", parallel = false)
    public Object[] getFeaturedAirSearchData() throws IOException {
        return JacksonUtils.deserializeJson("flightSearchData.json", FlightSearchPageDataObject[].class);
    }

    @DataProvider(name = "getFeaturedCompleteBookingSanityData", parallel = false)
    public Object[] getFeaturedCompleteBookingSanityData() throws IOException {
        return JacksonUtils.deserializeJson("completeBookingSanityData.json", CompleteBookingSanityDataObject[].class);
    }
}
