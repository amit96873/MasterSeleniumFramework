package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class BookingSummaryPage extends BasePage {
    private final By clickingOnBookingId = By.xpath("//*[@class='abt-succedspan']");
    private final By bookingStatusText = By.xpath("(//*[text()='Cancelled'])[1]");
    private final By bookingStatusTextOnBSummeryPage = By.xpath("//*[text()='Success']");
    public BookingSummaryPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public CartDetailsPage clickOnBookingId(){
        Log.info("Clicking on booking id of booking summery page...................");
        WebElement e = wetForElementTOClicable(clickingOnBookingId);
        e.click();
        Log.info("clicked on booking id of booking summery page and get in to Cart details Page");
        return new CartDetailsPage(driver);
    }
    @Step
    public String getBookingStatus(){

        Log.info("getting the booking status of the Booking summery page");
        WebElement e = wetForElementTOVisible(bookingStatusText);
        String bookingStatus = e.getText();
        Log.info("got the status As "+bookingStatus+"");
        return bookingStatus;
    }
    @Step
    public String getBookingStatusForSuccessBooking(){

        Log.info("getting the booking status of the Booking summery page");
        WebElement e = wetForElementTOVisible(bookingStatusTextOnBSummeryPage);
        String bookingStatus = e.getText();
        Log.info("got the status As "+bookingStatus+"");
        return bookingStatus;
    }

}
