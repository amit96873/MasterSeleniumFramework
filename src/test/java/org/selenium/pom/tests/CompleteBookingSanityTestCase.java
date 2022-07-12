package org.selenium.pom.tests;

import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.CompleteBookingSanityDataObject;
import org.selenium.pom.objects.SearchResultsPageDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.*;
import org.selenium.pom.pages.ManageCartsPage;
import org.selenium.pom.pages.components.MyHeaders;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
@Epic("Complete Sanity of Booking")
@Feature("Bookings, Amendments")
public class CompleteBookingSanityTestCase extends BaseTest {

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

    @Story("sanity testing for booking and cancellation amendments and checking the status of the booking it should be canceled ")
    @Link("https://staging.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status got canceled")
    @Test(dataProvider="getFeaturedCompleteBookingSanityData", dataProviderClass = MyDataProvider.class)
    public void onewayCompleteSanityTest(CompleteBookingSanityDataObject completeBookingSanityDataObject) throws IOException, InterruptedException {

                User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
                dashboardPage = new HomePage(getDriver()).
                load().login(user);
                dashboardPage.isLoaded();
                dashboardPage.enterUserId(completeBookingSanityDataObject.getUserId()).clickOnUserSearchBtn();
                flightPage = new DashboardPage(getDriver()).clickOnEmulateUser()
               .enterSource(completeBookingSanityDataObject.getSource()).
                enterDestination(completeBookingSanityDataObject.getDestination()).
                selectOnwardsDate(completeBookingSanityDataObject.getDate(),completeBookingSanityDataObject.getMonthYear()).
                selectPreferredAirline(completeBookingSanityDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(completeBookingSanityDataObject.getAdults(), completeBookingSanityDataObject.getChilds(), completeBookingSanityDataObject.getInfants());
                searchResultPage = flightPage.clickOnSearchBtn();
                Thread.sleep(completeBookingSanityDataObject.getWaitTime());
                reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
                Thread.sleep(completeBookingSanityDataObject.getWaitTime());
                paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(completeBookingSanityDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(completeBookingSanityDataObject.getAdult1FirstName())
                .enterAdult1LastName(completeBookingSanityDataObject.getAdult1LastName())
                .selectTitleForChild1(completeBookingSanityDataObject.getFirstChildTitle())
                .enterChild1FirstName(completeBookingSanityDataObject.getChild1FirstName())
                .enterChild1LastName(completeBookingSanityDataObject.getChild1LastName())
                .selectTitleForInfant1(completeBookingSanityDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(completeBookingSanityDataObject.getInfant1FirstName())
                .enterInfant1LastName(completeBookingSanityDataObject.getInfant1LastName())
                .enterMobileNumber(completeBookingSanityDataObject.getMobileNumber())
                .enterInfant1DOB(completeBookingSanityDataObject.getInfant1DOB())
                .enterEmail(completeBookingSanityDataObject.getEmail());
                 termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
                 paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnTermsAndConditionsCheckBox().clickOnPayNowBtn();
                 bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
                 cartDetailsPage = new BookingSummaryPage(getDriver()).clickOnBookingId().clickOnRaiseAmendments().clickOnSelectAmendments(completeBookingSanityDataObject.getAmendmentsType());
                 selectPaxForAmendmentsPage = new CartDetailsPage(getDriver()).clickOnRaiseAmendmentsBtn().selectPax(completeBookingSanityDataObject.getPaxCountToSelectForAmendments()).clickOnSubmitBtn().enterRemarks(completeBookingSanityDataObject.getRemarks());
                 cartDetailsPage = new SelectPaxForAmendmentsPage(getDriver()).clickOnProceedToCancelBtn();
                 Thread.sleep(completeBookingSanityDataObject.getWaitTime());
                 dashboardPage = new MyHeaders(getDriver()).clickOnSwitchBackBtn();
                 manageCartsPage = new MyHeaders(getDriver()).clickOnManageCart();
                 manageCartsPage.enterBookingUserId(completeBookingSanityDataObject.getUserId()).clickOnSearchBtn().enterAdultsFirstNameInSearchInputField(completeBookingSanityDataObject.getAdult1FirstName());
                 Thread.sleep(completeBookingSanityDataObject.getWaitTime());
                 cartDetailsPage = new ManageCartsPage(getDriver()).clickOnBookingId();
                 cartDetailsPage.clickOnAssignMeBtn();
                 processAmendmentPage = new CartDetailsPage(getDriver()).clickOnProcessBtn();
                 processAmendmentPage.selectAllNACheckBox().addNotes(completeBookingSanityDataObject.getNotes()).clickOnSubmitBtn().clickOnProcessBtn().addReason(completeBookingSanityDataObject.getReason()).clickOnConfirmBtn();
                 cartDetailsPage= processAmendmentPage.clickOnBackBtn();
                 bookingSummaryPage=cartDetailsPage.clickOnBookingSummery();
                 Thread.sleep(completeBookingSanityDataObject.getWaitTime());
                 Assert.assertEquals(bookingSummaryPage.getBookingStatus(),"Cancelled");



    }
}