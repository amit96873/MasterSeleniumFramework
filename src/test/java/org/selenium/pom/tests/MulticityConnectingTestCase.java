package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.MulticityConnectingDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import org.selenium.pom.pages.ManageCartsPage;



@Epic("Complete Sanity of MultiCity Connecting Booking")
@Feature("Bookings, MultiCity Connecting Booking")
public class MulticityConnectingTestCase extends BaseTest {

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

    @Story("complete sanity of MultiCity Connecting Booking")
    @Link("https://QA.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status success")
    @Test(dataProvider = "getFeaturedMulticityConnectingData", dataProviderClass = MyDataProvider.class)
    public void multiCityDirectCompleteSanityTest(MulticityConnectingDataObject multicityConnectingDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        dashboardPage.enterUserId(multicityConnectingDataObject.getUserId()).clickOnUserSearchBtn();
        //----------------------------------Oneway direct booking----------------------//
        flightPage = new DashboardPage(getDriver()).clickOnEmulateUser()
                .enterSource(multicityConnectingDataObject.getSource()).
                enterDestination(multicityConnectingDataObject.getDestination()).
                selectOnwardsDate(multicityConnectingDataObject.getDate(), multicityConnectingDataObject.getMonthYear()).
                selectPreferredAirline(multicityConnectingDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(multicityConnectingDataObject.getAdults(), multicityConnectingDataObject.getChilds(), multicityConnectingDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(multicityConnectingDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopZero();
        Thread.sleep(multicityConnectingDataObject.getWaitTime());
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(multicityConnectingDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(multicityConnectingDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(multicityConnectingDataObject.getAdult1FirstName())
                .enterAdult1LastName(multicityConnectingDataObject.getAdult1LastName())
                .selectTitleForChild1(multicityConnectingDataObject.getFirstChildTitle())
                .enterChild1FirstName(multicityConnectingDataObject.getChild1FirstName())
                .enterChild1LastName(multicityConnectingDataObject.getChild1LastName())
                .selectTitleForInfant1(multicityConnectingDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(multicityConnectingDataObject.getInfant1FirstName())
                .enterInfant1LastName(multicityConnectingDataObject.getInfant1LastName())
                .enterMobileNumber(multicityConnectingDataObject.getMobileNumber())
                .enterInfant1DOB(multicityConnectingDataObject.getInfant1DOB())
                .enterEmail(multicityConnectingDataObject.getEmail());
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnTermsAndConditionsCheckBox().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        Thread.sleep(multicityConnectingDataObject.getWaitTime());
        Assert.assertEquals(bookingSummaryPage.getBookingStatus(),"Success");
    }
}




