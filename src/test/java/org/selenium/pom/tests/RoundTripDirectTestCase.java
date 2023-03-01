package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.OnewayConnectingDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
        import org.selenium.pom.objects.*;
        import java.io.IOException;
        import org.selenium.pom.pages.ManageCartsPage;



@Epic("Complete Sanity of Round Trip Direct Booking")
@Feature("Bookings, Round Trip Direct")
public class RoundTripDirectTestCase extends BaseTest {

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

    @Story("complete sanity of Round Trip Direct  booking")
    @Link("https://QA.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status success")
    @Test(dataProvider = "getFeaturedRoundTripDirectData", dataProviderClass = MyDataProvider.class)
    public void roundTripDirectCompleteSanityTest(RoundTripDirectDataObject roundTripDirectDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        dashboardPage.enterUserId(roundTripDirectDataObject.getUserId()).clickOnUserSearchBtn();
        //----------------------------------Oneway direct booking----------------------//
        flightPage = new DashboardPage(getDriver()).clickOnEmulateUser()
                .enterSource(roundTripDirectDataObject.getSource()).
                enterDestination(roundTripDirectDataObject.getDestination()).
                selectOnwardsDate(roundTripDirectDataObject.getDate(), roundTripDirectDataObject.getMonthYear()).
                selectReturnDate(roundTripDirectDataObject.getReturnDate(),roundTripDirectDataObject.getReturnMonthYear()).
                selectPreferredAirline(roundTripDirectDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(roundTripDirectDataObject.getAdults(), roundTripDirectDataObject.getChilds(), roundTripDirectDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(roundTripDirectDataObject.getWaitTime());
        searchResultPage = searchResultPage.searchBySourceId();
        Thread.sleep(roundTripDirectDataObject.getWaitTime());
        Thread.sleep(roundTripDirectDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopZero();
        Thread.sleep(roundTripDirectDataObject.getWaitTime());
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(roundTripDirectDataObject.getWaitTime());
        reviewPage = new ReviewPage(getDriver()).checkPopupAndClickOnContinue();
        Thread.sleep(roundTripDirectDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(roundTripDirectDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(roundTripDirectDataObject.getAdult1FirstName())
                .enterAdult1LastName(roundTripDirectDataObject.getAdult1LastName())
                .selectTitleForChild1(roundTripDirectDataObject.getFirstChildTitle())
                .enterChild1FirstName(roundTripDirectDataObject.getChild1FirstName())
                .enterChild1LastName(roundTripDirectDataObject.getChild1LastName())
                .selectTitleForInfant1(roundTripDirectDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(roundTripDirectDataObject.getInfant1FirstName())
                .enterInfant1LastName(roundTripDirectDataObject.getInfant1LastName())
                .enterMobileNumber(roundTripDirectDataObject.getMobileNumber())
                .enterInfant1DOB(roundTripDirectDataObject.getInfant1DOB())
                .enterEmail(roundTripDirectDataObject.getEmail())
                .clickOnSkipProtectGroupBtn();
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        Thread.sleep(roundTripDirectDataObject.getWaitTime());
        Assert.assertEquals(bookingSummaryPage.getBookingStatus(),"Success");
    }
}


