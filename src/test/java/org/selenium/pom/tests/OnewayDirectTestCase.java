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



@Epic("Complete Sanity of Oneway Direct Booking")
@Feature("Bookings, Oneway Direct")
public class OnewayDirectTestCase extends BaseTest {

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

    @Story("complete sanity of oneway direct booking")
    @Link("https://QA.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status success")
    @Test(dataProvider = "getFeaturedOnewayDirectData", dataProviderClass = MyDataProvider.class)
    public void onewayDirectCompleteSanityTest(OnewayDirectDataObject onewayDirectDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        dashboardPage.enterUserId(onewayDirectDataObject.getUserId()).clickOnUserSearchBtn();
        flightPage = new DashboardPage(getDriver()).clickOnEmulateUser()
                .enterSource(onewayDirectDataObject.getSource()).
                enterDestination(onewayDirectDataObject.getDestination()).
                selectOnwardsDate(onewayDirectDataObject.getDate(), onewayDirectDataObject.getMonthYear()).
                selectPreferredAirline(onewayDirectDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(onewayDirectDataObject.getAdults(), onewayDirectDataObject.getChilds(), onewayDirectDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(onewayDirectDataObject.getWaitTime());
        searchResultPage = searchResultPage.searchBySourceId(onewayDirectDataObject.getsId());
        Thread.sleep(onewayDirectDataObject.getWaitTime());
        Thread.sleep(onewayDirectDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopZero();
        Thread.sleep(onewayDirectDataObject.getWaitTime());
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
            Thread.sleep(onewayDirectDataObject.getWaitTime());
        reviewPage = new ReviewPage(getDriver()).checkPopupAndClickOnContinue();
        Thread.sleep(onewayDirectDataObject.getWaitTime());
               paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(onewayDirectDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(onewayDirectDataObject.getAdult1FirstName())
                .enterAdult1LastName(onewayDirectDataObject.getAdult1LastName())
                .selectTitleForChild1(onewayDirectDataObject.getFirstChildTitle())
                .enterChild1FirstName(onewayDirectDataObject.getChild1FirstName())
                .enterChild1LastName(onewayDirectDataObject.getChild1LastName())
                .selectTitleForInfant1(onewayDirectDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(onewayDirectDataObject.getInfant1FirstName())
                .enterInfant1LastName(onewayDirectDataObject.getInfant1LastName())
                .enterMobileNumber(onewayDirectDataObject.getMobileNumber())
                .enterInfant1DOB(onewayDirectDataObject.getInfant1DOB())
                .enterEmail(onewayDirectDataObject.getEmail())
                .clickOnSkipProtectGroupBtn();
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        Thread.sleep(onewayDirectDataObject.getWaitTime());
        Assert.assertEquals(bookingSummaryPage.getBookingStatusForSuccessBooking(),onewayDirectDataObject.getStatusOfBooking());
    }
}

