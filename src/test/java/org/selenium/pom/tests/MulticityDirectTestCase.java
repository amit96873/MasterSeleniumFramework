package org.selenium.pom.tests;
import io.qameta.allure.*;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.dataProvider.MyDataProvider;
import org.selenium.pom.objects.MulticityDirectDataObject;
import org.selenium.pom.objects.RoundTripConnectingDataObject;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.*;
import org.selenium.pom.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import org.selenium.pom.pages.ManageCartsPage;



@Epic("Complete Sanity of MultiCity Direct Booking")
@Feature("Bookings, MultiCity Direct Booking")
public class MulticityDirectTestCase extends BaseTest {

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

    @Story("complete sanity of MultiCity Direct Booking")
    @Link("https://QA.technogramsolutions.com")
    @Link(name = "Technogram", type = "mylink")
    @Issue("no issue in this test case")
    @TmsLink("not available")
    @Description("Checking each and every module till booking status success")
    @Test(dataProvider = "getFeaturedMulticityDirectData", dataProviderClass = MyDataProvider.class)
    public void multiCityDirectCompleteSanityTest(MulticityDirectDataObject multicityDirectDataObject) throws IOException, InterruptedException {

        User user = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());
        dashboardPage = new HomePage(getDriver()).
                load().login(user);
        dashboardPage.isLoaded();
        dashboardPage.enterUserId(multicityDirectDataObject.getUserId()).clickOnUserSearchBtn();
        flightPage = new DashboardPage(getDriver()).clickOnEmulateUser().clickOnMultiCityBtn()
                .enterSource(multicityDirectDataObject.getSource()).
                enterDestination(multicityDirectDataObject.getDestination()).
                selectOnwardsDate(multicityDirectDataObject.getDate(), multicityDirectDataObject.getMonthYear())
                        .enterMultiCitySecondSource(multicityDirectDataObject.getMultiCitySecondSourceName())
                .enterMultiCitySecondDestination(multicityDirectDataObject.getMultiCitySecondDestinationName())
                .selectMultiCityDepartureDateSecond(multicityDirectDataObject.getMultiCityDepartureDateSecond(),multicityDirectDataObject.getMultiCityDepartureMonthYearSecond())
        .selectPreferredAirline(multicityDirectDataObject.getPreferredAirlines()).
                selectPaxWithAdultsChildsInfant(multicityDirectDataObject.getAdults(), multicityDirectDataObject.getChilds(), multicityDirectDataObject.getInfants());
        searchResultPage = flightPage.clickOnSearchBtn();
        Thread.sleep(multicityDirectDataObject.getWaitTime());
        searchResultPage = searchResultPage.searchBySourceId();
        Thread.sleep(multicityDirectDataObject.getWaitTime());
        Thread.sleep(multicityDirectDataObject.getWaitTime());
        searchResultPage = new SearchResultPage(getDriver()).clickOnStopZero();
        Thread.sleep(multicityDirectDataObject.getWaitTime());
        reviewPage = new SearchResultPage(getDriver()).clickOnBookBtn();
        Thread.sleep(multicityDirectDataObject.getWaitTime());
        reviewPage = new ReviewPage(getDriver()).checkPopupAndClickOnContinue();
        Thread.sleep(multicityDirectDataObject.getWaitTime());
        paxDetailsPage = new ReviewPage(getDriver()).clickOnAddPassangerBtn()
                .clickOnExpandPaxInputFields().
                clickOnExpandPaxInputFields()
                .selectTitleForAdult1(multicityDirectDataObject.getFirstAdultTitle())
                .enterAdult1FirstName(multicityDirectDataObject.getAdult1FirstName())
                .enterAdult1LastName(multicityDirectDataObject.getAdult1LastName())
                .selectTitleForChild1(multicityDirectDataObject.getFirstChildTitle())
                .enterChild1FirstName(multicityDirectDataObject.getChild1FirstName())
                .enterChild1LastName(multicityDirectDataObject.getChild1LastName())
                .selectTitleForInfant1(multicityDirectDataObject.getFirstInfantTitle())
                .enterInfant1FirstName(multicityDirectDataObject.getInfant1FirstName())
                .enterInfant1LastName(multicityDirectDataObject.getInfant1LastName())
                .enterMobileNumber(multicityDirectDataObject.getMobileNumber())
                .enterInfant1DOB(multicityDirectDataObject.getInfant1DOB())
                .enterEmail(multicityDirectDataObject.getEmail())
                .clickOnSkipProtectGroupBtn();
        termsAndConditionsPage = new PaxDetailsPage(getDriver()).clickOnProceedToReviewBtn();
        paymentPage = new TermsAndConditionsPage(getDriver()).clickOnProceedToPayBtn().clickOnPayNowBtn();
        bookingSummaryPage = new PaymentPage(getDriver()).clickOnConfirmPayNowBtn();
        Thread.sleep(multicityDirectDataObject.getWaitTime());
        Assert.assertEquals(bookingSummaryPage.getBookingStatusForSuccessBooking(),"Success");
    }
}




