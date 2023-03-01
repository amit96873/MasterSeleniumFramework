package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.CompleteBookingSanityDataObject;
import org.selenium.pom.objects.SanityDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.*;
import org.selenium.pom.pages.components.MyHeaders;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.selenium.pom.pages.ManageCartsPage;
import java.io.IOException;


@Epic("Complete Sanity of Booking")
@Feature("Bookings, Amendments")
public class SanityTestCase extends BaseTest {

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

    @Story("complete sanity of oneway, return and multi-city direct and connecting")
    @Link("https://QA.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status success")
    @Test(dataProvider="getFeaturedSanityData", dataProviderClass = MyDataProvider.class)
    public void onewayCompleteSanityTest(SanityDataObject sanityDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        dashboardPage.enterUserId(sanityDataObject.getUserId()).clickOnUserSearchBtn();
        //----------------------------------Oneway direct booking----------------------//
        flightPage = new DashboardPage(getDriver()).clickOnEmulateUser()
                .enterSource(sanityDataObject.getSource()).
                enterDestination(sanityDataObject.getDestination()).
                selectOnwardsDate(sanityDataObject.getDate(),sanityDataObject.getMonthYear()).
                selectPreferredAirline(sanityDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(sanityDataObject.getAdults(), sanityDataObject.getChilds(), sanityDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopZero();
        Thread.sleep(sanityDataObject.getWaitTime());
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(sanityDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(sanityDataObject.getAdult1FirstName())
                .enterAdult1LastName(sanityDataObject.getAdult1LastName())
                .selectTitleForChild1(sanityDataObject.getFirstChildTitle())
                .enterChild1FirstName(sanityDataObject.getChild1FirstName())
                .enterChild1LastName(sanityDataObject.getChild1LastName())
                .selectTitleForInfant1(sanityDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(sanityDataObject.getInfant1FirstName())
                .enterInfant1LastName(sanityDataObject.getInfant1LastName())
                .enterMobileNumber(sanityDataObject.getMobileNumber())
                .enterInfant1DOB(sanityDataObject.getInfant1DOB())
                .enterEmail(sanityDataObject.getEmail());
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnTermsAndConditionsCheckBox().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();

//        Assert.assertEquals(bookingSummaryPage.getBookingStatus(),"Success");
        //------------------------------one way connecting booking-------------------------------//
        Thread.sleep(sanityDataObject.getWaitTime());
        flightPage = new MyHeaders(getDriver()).clickOnFlight().enterSource(sanityDataObject.getSource()).
                enterDestination(sanityDataObject.getDestination()).
                selectOnwardsDate(sanityDataObject.getDate(),sanityDataObject.getMonthYear()).
                selectPreferredAirline(sanityDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(sanityDataObject.getAdults(), sanityDataObject.getChilds(), sanityDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopOne();
        Thread.sleep(sanityDataObject.getWaitTime());
              reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(sanityDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(sanityDataObject.getAdult1FirstName())
                .enterAdult1LastName(sanityDataObject.getAdult1LastName())
                .selectTitleForChild1(sanityDataObject.getFirstChildTitle())
                .enterChild1FirstName(sanityDataObject.getChild1FirstName())
                .enterChild1LastName(sanityDataObject.getChild1LastName())
                .selectTitleForInfant1(sanityDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(sanityDataObject.getInfant1FirstName())
                .enterInfant1LastName(sanityDataObject.getInfant1LastName())
                .enterMobileNumber(sanityDataObject.getMobileNumber())
                .enterInfant1DOB(sanityDataObject.getInfant1DOB())
                .enterEmail(sanityDataObject.getEmail());
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnTermsAndConditionsCheckBox().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        //---------------------------------------------------------------------------//
        //round trip Direct booking
        //---------------------------------------------------------------------------//
        //        Assert.assertEquals(bookingSummaryPage.getBookingStatus(),"Success");
        Thread.sleep(sanityDataObject.getWaitTime());
        flightPage = new MyHeaders(getDriver()).clickOnFlight().enterSource(sanityDataObject.getSource()).
                enterDestination(sanityDataObject.getDestination()).
                selectOnwardsDate(sanityDataObject.getDate(),sanityDataObject.getMonthYear()).
                selectReturnDate(sanityDataObject.getReturnDate(),sanityDataObject.getReturnMonthYear()).
                selectPreferredAirline(sanityDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(sanityDataObject.getAdults(), sanityDataObject.getChilds(), sanityDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(sanityDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(sanityDataObject.getAdult1FirstName())
                .enterAdult1LastName(sanityDataObject.getAdult1LastName())
                .selectTitleForChild1(sanityDataObject.getFirstChildTitle())
                .enterChild1FirstName(sanityDataObject.getChild1FirstName())
                .enterChild1LastName(sanityDataObject.getChild1LastName())
                .selectTitleForInfant1(sanityDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(sanityDataObject.getInfant1FirstName())
                .enterInfant1LastName(sanityDataObject.getInfant1LastName())
                .enterMobileNumber(sanityDataObject.getMobileNumber())
                .enterInfant1DOB(sanityDataObject.getInfant1DOB())
                .enterEmail(sanityDataObject.getEmail());
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnTermsAndConditionsCheckBox().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        //--------------------------------------------------------------------------//
      //Sanity round trip connecting booking
        //---------------------------------------------------------------------------//
        Thread.sleep(sanityDataObject.getWaitTime());
        flightPage = new MyHeaders(getDriver()).clickOnFlight().enterSource(sanityDataObject.getSource()).
                enterDestination(sanityDataObject.getDestination()).
                selectOnwardsDate(sanityDataObject.getDate(),sanityDataObject.getMonthYear()).
                selectReturnDate(sanityDataObject.getReturnDate(),sanityDataObject.getReturnMonthYear()).
                selectPreferredAirline(sanityDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(sanityDataObject.getAdults(), sanityDataObject.getChilds(), sanityDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
      searchResultPage = new SearchResultPage(getDriver()).clickOnStopOne();
      Thread.sleep(sanityDataObject.getWaitTime());
      searchResultPage = new SearchResultPage(getDriver()).selectConnectingOnwardsFlight();
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(sanityDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(sanityDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(sanityDataObject.getAdult1FirstName())
                .enterAdult1LastName(sanityDataObject.getAdult1LastName())
                .selectTitleForChild1(sanityDataObject.getFirstChildTitle())
                .enterChild1FirstName(sanityDataObject.getChild1FirstName())
                .enterChild1LastName(sanityDataObject.getChild1LastName())
                .selectTitleForInfant1(sanityDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(sanityDataObject.getInfant1FirstName())
                .enterInfant1LastName(sanityDataObject.getInfant1LastName())
                .enterMobileNumber(sanityDataObject.getMobileNumber())
                .enterInfant1DOB(sanityDataObject.getInfant1DOB())
                .enterEmail(sanityDataObject.getEmail());
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnTermsAndConditionsCheckBox().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();




    }
}
