package org.selenium.pom.dataProvider;

import org.selenium.pom.objects.*;
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

    @DataProvider(name = "getFeaturedSanityData", parallel = false)
    public Object[] getFeaturedSanityData() throws IOException {
        return JacksonUtils.deserializeJson("sanityData.json", SanityDataObject[].class);
    }

    @DataProvider(name = "getFeaturedOnewayDirectData", parallel = false)
    public Object[] getFeaturedOnewayDirectData() throws IOException {
        return JacksonUtils.deserializeJson("onewayDirectData.json", OnewayDirectDataObject[].class);
    }


    @DataProvider(name = "getFeaturedOnewayConnectingData", parallel = false)
    public Object[] getFeaturedOnewayConnectingData() throws IOException {
        return JacksonUtils.deserializeJson("onewayConnectingData.json", OnewayConnectingDataObject[].class);
    }

    @DataProvider(name = "getFeaturedRoundTripDirectData", parallel = false)
    public Object[] getFeaturedRoundTripDirectData() throws IOException {
        return JacksonUtils.deserializeJson("roundtripDirectData.json", RoundTripDirectDataObject[].class);
    }

    @DataProvider(name = "getFeaturedRoundTripConnectingData", parallel = false)
    public Object[] getFeaturedRoundTripConnectingData() throws IOException {
        return JacksonUtils.deserializeJson("roundtripConnectingData.json", RoundTripConnectingDataObject[].class);
    }

    @DataProvider(name = "getFeaturedMulticityDirectData", parallel = false)
    public Object[] getFeaturedMulticityDirectData() throws IOException {
        return JacksonUtils.deserializeJson("multicityDirectData.json", MulticityDirectDataObject[].class);
    }

    @DataProvider(name = "getFeaturedMulticityConnectingData", parallel = false)
    public Object[] getFeaturedMulticityConnectingData() throws IOException {
        return JacksonUtils.deserializeJson("multicityConnectingData.json", MulticityConnectingDataObject[].class);
    }

}
