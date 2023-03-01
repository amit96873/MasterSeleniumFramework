package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.*;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.ManageCartsPage;



@Epic("Complete Sanity of Oneway Connecting Booking")
@Feature("Bookings, Oneway Connecting")
public class OnewayConnectingTestCase extends BaseTest {

    DashboardPage dashboardPage;
    FlightPage flightPage;
    SearchResultPage searchResultPage;
    ReviewPage reviewPage;
    PaxDetailsPage paxDetailsPage;
    TermsAndConditionsPage termsAndConditionsPage;
    PaymentPage paymentPage;
    BookingSummaryPage bookingSummaryPage;
    CartDetailsPage cartDetailsPage;
    SelectPaxForAmendmentsPage selectPaxForAmendmentsPage;
    ProcessAmendmentPage processAmendmentPage;
    ManageCartsPage manageCartsPage;

    @Story("complete sanity of oneway Connecting booking")
    @Link("https://QA.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status success")
    @Test(dataProvider = "getFeaturedOnewayConnectingData", dataProviderClass = MyDataProvider.class)
    public void onewayConnectingCompleteSanityTest(OnewayConnectingDataObject onewayConnectingDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        dashboardPage.enterUserId(onewayConnectingDataObject.getUserId()).clickOnUserSearchBtn();
        flightPage = new DashboardPage(getDriver()).clickOnEmulateUser()
                .enterSource(onewayConnectingDataObject.getSource()).
                enterDestination(onewayConnectingDataObject.getDestination()).
                selectOnwardsDate(onewayConnectingDataObject.getDate(), onewayConnectingDataObject.getMonthYear()).
                selectPreferredAirline(onewayConnectingDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(onewayConnectingDataObject.getAdults(), onewayConnectingDataObject.getChilds(), onewayConnectingDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(onewayConnectingDataObject.getWaitTime());
        searchResultPage = searchResultPage.searchBySourceId();
        Thread.sleep(onewayConnectingDataObject.getWaitTime());
        Thread.sleep(onewayConnectingDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopOne();
        Thread.sleep(onewayConnectingDataObject.getWaitTime());
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(onewayConnectingDataObject.getWaitTime());
        reviewPage = new ReviewPage(getDriver()).checkPopupAndClickOnContinue();
        Thread.sleep(onewayConnectingDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(onewayConnectingDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(onewayConnectingDataObject.getAdult1FirstName())
                .enterAdult1LastName(onewayConnectingDataObject.getAdult1LastName())
                .selectTitleForChild1(onewayConnectingDataObject.getFirstChildTitle())
                .enterChild1FirstName(onewayConnectingDataObject.getChild1FirstName())
                .enterChild1LastName(onewayConnectingDataObject.getChild1LastName())
                .selectTitleForInfant1(onewayConnectingDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(onewayConnectingDataObject.getInfant1FirstName())
                .enterInfant1LastName(onewayConnectingDataObject.getInfant1LastName())
                .enterMobileNumber(onewayConnectingDataObject.getMobileNumber())
                .enterInfant1DOB(onewayConnectingDataObject.getInfant1DOB())
                .enterEmail(onewayConnectingDataObject.getEmail())
                .clickOnSkipProtectGroupBtn();
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        Thread.sleep(onewayConnectingDataObject.getWaitTime());
        Assert.assertEquals(bookingSummaryPage.getBookingStatusForSuccessBooking(),"Success");
    }
}

