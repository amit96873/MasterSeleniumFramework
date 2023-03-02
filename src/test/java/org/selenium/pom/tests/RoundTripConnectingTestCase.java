package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.RoundTripConnectingDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import org.selenium.pom.pages.ManageCartsPage;



@Epic("Complete Sanity of Round Trip Connecting Booking")
@Feature("Bookings, Round Trip Connecting")
public class RoundTripConnectingTestCase extends BaseTest {

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

    @Story("complete sanity of Round Trip Connecting  booking")
    @Link("https://QA.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status success")
    @Test(dataProvider = "getFeaturedRoundTripConnectingData", dataProviderClass = MyDataProvider.class)
    public void roundTripConnectingCompleteSanityTest(RoundTripConnectingDataObject roundTripConnectingDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        dashboardPage.enterUserId(roundTripConnectingDataObject.getUserId()).clickOnUserSearchBtn();
        //----------------------------------Oneway direct booking----------------------//
        flightPage = new DashboardPage(getDriver()).clickOnEmulateUser()
                .enterSource(roundTripConnectingDataObject.getSource()).
                enterDestination(roundTripConnectingDataObject.getDestination()).
                selectOnwardsDate(roundTripConnectingDataObject.getDate(), roundTripConnectingDataObject.getMonthYear()).
                selectReturnDate(roundTripConnectingDataObject.getReturnDate(),roundTripConnectingDataObject.getReturnMonthYear()).
                selectPreferredAirline(roundTripConnectingDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(roundTripConnectingDataObject.getAdults(), roundTripConnectingDataObject.getChilds(), roundTripConnectingDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(roundTripConnectingDataObject.getWaitTime());
        searchResultPage = searchResultPage.searchBySourceId(roundTripConnectingDataObject.getsId());
        Thread.sleep(roundTripConnectingDataObject.getWaitTime());
        Thread.sleep(roundTripConnectingDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopOne();
        Thread.sleep(roundTripConnectingDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).selectConnectingOnwardsFlight();
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(roundTripConnectingDataObject.getWaitTime());
        reviewPage = new ReviewPage(getDriver()).checkPopupAndClickOnContinue();
        Thread.sleep(roundTripConnectingDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(roundTripConnectingDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(roundTripConnectingDataObject.getAdult1FirstName())
                .enterAdult1LastName(roundTripConnectingDataObject.getAdult1LastName())
                .selectTitleForChild1(roundTripConnectingDataObject.getFirstChildTitle())
                .enterChild1FirstName(roundTripConnectingDataObject.getChild1FirstName())
                .enterChild1LastName(roundTripConnectingDataObject.getChild1LastName())
                .selectTitleForInfant1(roundTripConnectingDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(roundTripConnectingDataObject.getInfant1FirstName())
                .enterInfant1LastName(roundTripConnectingDataObject.getInfant1LastName())
                .enterMobileNumber(roundTripConnectingDataObject.getMobileNumber())
                .enterInfant1DOB(roundTripConnectingDataObject.getInfant1DOB())
                .enterEmail(roundTripConnectingDataObject.getEmail())
                .clickOnSkipProtectGroupBtn();
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        Thread.sleep(roundTripConnectingDataObject.getWaitTime());
        Assert.assertEquals(bookingSummaryPage.getBookingStatusForSuccessBooking(),roundTripConnectingDataObject.getStatusOfBooking());
    }
}



