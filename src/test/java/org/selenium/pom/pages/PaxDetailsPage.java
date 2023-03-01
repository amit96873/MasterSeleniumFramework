package org.selenium.pom.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.utils.Log;

public class PaxDetailsPage extends BasePage {

    private final By expendAllPaxFieldsBtn = By.id("toggle__wrapper--checkboxid");
    private final By firstPaxExpandBtn  = By.xpath("(//i[@class='fa fa-angle-down'])[1]");
    private final By secondPaxExpandBtn  = By.xpath("(//i[@class='fa fa-angle-down'])[2]");
    private final By firstAdultTitleDropbox = By.xpath("//*[@name='ADULT1_ti']");
    private final By firstAdultFirstNameInputField = By.id("ADULT1_fN_feild");
    private final By firstAdultLastNameInputField = By.id("ADULT1_lN_feild");
    private final By secondAdultTitleDropbox = By.xpath("//*[@name='ADULT2_ti']");
    private final By secondAdultFirstNameInputField = By.id("ADULT2_fN_feild");
    private final By secondAdultLastNameInputField = By.id("ADULT2_lN_feild");
    private final By thirdAdultTitleDropbox = By.xpath("//*[@name='ADULT3_ti']");
    private final By thirdAdultFirstNameInputField = By.id("ADULT3_fN_feild");
    private final By thirdAdultLastNameInputField = By.id("ADULT3_lN_feild");
    private final By fourthAdultTitleDropbox = By.xpath("//*[@name='ADULT4_ti']");
    private final By fourthAdultFirstNameInputField = By.id("ADULT4_fN_feild");
    private final By fourthAdultLastNameInputField = By.id("ADULT4_lN_feild");
    private final By fifthAdultTitleDropbox = By.xpath("//*[@name='ADULT5_ti']");
    private final By fifthAdultFirstNameInputField = By.id("ADULT5_fN_feild");
    private final By fifthAdultLastNameInputField = By.id("ADULT5_lN_feild");
    private final By sixthAdultTitleDropbox = By.xpath("//*[@name='ADULT6_ti']");
    private final By sixthAdultFirstNameInputField = By.id("ADULT6_fN_feild");
    private final By sixthAdultLastNameInputField = By.id("ADULT6_lN_feild");
    private final By seventhAdultTitleDropbox = By.xpath("//*[@name='ADULT7_ti']");
    private final By seventhAdultFirstNameInputField = By.id("ADULT7_fN_feild");
    private final By seventhAdultLastNameInputField = By.id("ADULT7_lN_feild");
    private final By eighthAdultTitleDropbox = By.xpath("//*[@name='ADULT8_ti']");
    private final By eighthAdultFirstNameInputField = By.id("ADULT8_fN_feild");
    private final By eighthAdultLastNameInputField = By.id("ADULT8_lN_feild");
    private final By ninthAdultTitleDropbox = By.xpath("//*[@name='ADULT9_ti']");
    private final By ninthAdultFirstNameInputField = By.id("ADULT9_fN_feild");
    private final By ninthAdultLastNameInputField = By.id("ADULT9_lN_feild");

    private final By firstChildTitleDropbox = By.xpath("//*[@name='CHILD1_ti']");
    private final By firstChildFirstNameInputField = By.id("CHILD1_fN_feild");
    private final By firstChildLastNameInputField = By.id("CHILD1_lN_feild");
    private final By secondChildTitleDropbox = By.xpath("//*[@name='CHILD2_ti']");
    private final By secondChildFirstNameInputField = By.id("CHILD2_fN_feild");
    private final By secondChildLastNameInputField = By.id("CHILD2_lN_feild");
    private final By thirdChildTitleDropbox = By.xpath("//*[@name='CHILD3_ti']");
    private final By thirdChildFirstNameInputField = By.id("CHILD3_fN_feild");
    private final By thirdChildLastNameInputField = By.id("CHILD3_lN_feild");
    private final By fourthChildTitleDropbox = By.xpath("//*[@name='CHILD4_ti']");
    private final By fourthChildFirstNameInputField = By.id("CHILD4_fN_feild");
    private final By fourthChildLastNameInputField = By.id("CHILD4_lN_feild");
    private final By fifthChildTitleDropbox = By.xpath("//*[@name='CHILD5_ti']");
    private final By fifthChildFirstNameInputField = By.id("CHILD5_fN_feild");
    private final By fifthChildLastNameInputField = By.id("CHILD5_lN_feild");
    private final By sixthChildTitleDropbox = By.xpath("//*[@name='CHILD6_ti']");
    private final By sixthChildFirstNameInputField = By.id("CHILD6_fN_feild");
    private final By sixthChildLastNameInputField = By.id("CHILD6_lN_feild");
    private final By seventhChildTitleDropbox = By.xpath("//*[@name='CHILD7_ti']");
    private final By seventhChildFirstNameInputField = By.id("CHILD7_fN_feild");
    private final By seventhChildLastNameInputField = By.id("CHILD7_lN_feild");
    private final By eighthChildTitleDropbox = By.xpath("//*[@name='CHILD8_ti']");
    private final By eighthChildFirstNameInputField = By.id("CHILD8_fN_feild");
    private final By eighthChildLastNameInputField = By.id("CHILD8_lN_feild");


    private final By firstInfantTitleDropbox = By.xpath("//*[@name='INFANT1_ti']");
    private final By firstInfantFirstNameInputField = By.id("INFANT1_fN_feild");
    private final By firstInfantLastNameInputField = By.id("INFANT1_lN_feild");
    private final By firstInfantDOB = By.xpath("//input[@name='INFANT1_dob']");
    private final By secondInfantTitleDropbox = By.xpath("//*[@name='INFANT2_ti']");
    private final By secondInfantFirstNameInputField = By.id("INFANT2_fN_feild");
    private final By secondInfantLastNameInputField = By.id("INFANT2_lN_feild");
    private final By thirdInfantTitleDropbox = By.xpath("//*[@name='INFANT3_ti']");
    private final By thirdInfantFirstNameInputField = By.id("INFANT3_fN_feild");
    private final By thirdInfantLastNameInputField = By.id("INFANT3_lN_feild");
    private final By fourthInfantTitleDropbox = By.xpath("//*[@name='INFANT4_ti']");
    private final By fourthInfantFirstNameInputField = By.id("INFANT4_fN_feild");
    private final By fourthInfantLastNameInputField = By.id("INFANT4_lN_feild");
    private final By fifthInfantTitleDropbox = By.xpath("//*[@name='INFANT5_ti']");
    private final By fifthInfantFirstNameInputField = By.id("INFANT5_fN_feild");
    private final By fifthInfantLastNameInputField = By.id("INFANT5_lN_feild");
    private final By sixthInfantTitleDropbox = By.xpath("//*[@name='INFANT6_ti']");
    private final By sixthInfantFirstNameInputField = By.id("INFANT6_fN_feild");
    private final By sixthInfantLastNameInputField = By.id("INFANT6_lN_feild");
    private final By seventhInfantTitleDropbox = By.xpath("//*[@name='INFANT7_ti']");
    private final By seventhInfantFirstNameInputField = By.id("INFANT7_fN_feild");
    private final By seventhInfantLastNameInputField = By.id("INFANT7_lN_feild");
    private final By eighthInfantTitleDropbox = By.xpath("//*[@name='INFANT8_ti']");
    private final By eighthInfantFirstNameInputField = By.id("INFANT8_fN_feild");
    private final By eighthInfantLastNameInputField = By.id("INFANT8_lN_feild");


    private By proceedToReviewBtn = By.xpath("//i[@class='fa fa-angle-double-right proceed-button-positionHandle']");
    private By mobileNumberInputField = By.id("mobile_feild");
    private By emailInputField = By.id("email_feild");

    private By skipProtectGroup = By.xpath("(//*[@class='protectGrp__radio--text'])[2]");
    public PaxDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public PaxDetailsPage clickOnExpandPaxInputFields(){
        Log.info("clicking on expand button of pax input fields");
        WebElement e = wetForElementTOClicable(expendAllPaxFieldsBtn);
        e.click();
        e.click();
        Log.info("clicked on expand button of pax input fields");
        return this;
    }

    @Step
    public PaxDetailsPage selectTitleForAdult1(String firstAdultTitle){
        Log.info("clicking on the title drop box for the first Adult.............");
        WebElement e = wetForElementTOClicable(firstAdultTitleDropbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("clicked on the title drop box for the first Adult and now trying to select the title as "+firstAdultTitle);
        String firstTi= "Mr";
        String secondTi = "Mrs";
        String thirdTi = "Ms";
        Log.info("in drop down Trying to select the first Adult title As:-"+firstAdultTitle);
        if(firstTi.equalsIgnoreCase(firstAdultTitle)) {
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ENTER);
        } else if (secondTi.equalsIgnoreCase(firstAdultTitle)) {
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ENTER);
        } else if (thirdTi.equalsIgnoreCase(firstAdultTitle)) {
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ENTER);
        }
        Log.info("have successfully selected the first Adult title as:-"+firstAdultTitle);
        return this;
    }
    @Step
    public PaxDetailsPage enterAdult1FirstName(String adult1FirstName){
        Log.info("trying to enter Adult1 first name.....As:-"+adult1FirstName);
        WebElement e = wetForElementTOVisible(firstAdultFirstNameInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        e.clear();
        e.sendKeys(adult1FirstName);
        Log.info("successfully entered Adult1 first name.....As:-"+adult1FirstName);
        return this;
    }
    @Step
    public PaxDetailsPage enterAdult1LastName(String adult1LastName){
        Log.info("trying to enter Adult1 last name.....As:-"+adult1LastName);
        WebElement e = wetForElementTOVisible(firstAdultLastNameInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        e.clear();
        e.sendKeys(adult1LastName);
        Log.info("successfully entered Adult1 last name.....As:-"+adult1LastName);
        return this;
    }
    @Step
    public PaxDetailsPage selectTitleForChild1(String firstChildTitle){
        Log.info("clicking on the title drop box for the first child.............");
        WebElement e1 = wetForElementTOClicable(firstPaxExpandBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
        e1.click();
        Log.info("clicked on the title drop box for the first Child and now trying to select the title as "+firstChildTitle);
        WebElement e = wetForElementTOClicable(firstChildTitleDropbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        String firstTi = "Ms";
        String secondTi = "Master";
        Log.info("in dropdown Trying to select the first child title As:-"+firstChildTitle);
        if(firstTi.equalsIgnoreCase(firstChildTitle)){
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ENTER);
        } else if (secondTi.equalsIgnoreCase(firstChildTitle)) {
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ENTER);
        }
        Log.info("have successfully selected the first child title as:-"+firstChildTitle);
        return this;
    }
    @Step
    public PaxDetailsPage enterChild1FirstName(String child1FirstName){
        Log.info("trying to enter child1 first name.....As:-"+child1FirstName);
        WebElement e = wetForElementTOVisible(firstChildFirstNameInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        e.clear();
        e.sendKeys(child1FirstName);
        Log.info("successfully entered child1 first name ....As:-"+child1FirstName);
        return this;
    }
    @Step
    public PaxDetailsPage enterChild1LastName(String child1LastName){
        Log.info("trying to enter child1 last name.....As:-"+child1LastName);
        WebElement e = wetForElementTOVisible(firstChildLastNameInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        e.clear();
        e.sendKeys(child1LastName);
        Log.info("successfully entered child1 last name ....As:-"+child1LastName);
        return this;
    }
    @Step
    public PaxDetailsPage selectTitleForInfant1(String firstInfantTitle){
        Log.info("clicking on the title drop box for the first Infant.............");
        WebElement e1 = wetForElementTOClicable(secondPaxExpandBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
        e1.click();
        Log.info("clicked on the title drop box for the first Infant and now trying to select the title as "+firstInfantTitle);
        WebElement e = wetForElementTOClicable(firstInfantTitleDropbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        String firstTi = "Ms";
        String secondTi = "Master";
        Log.info("in dropdown Trying to select the first Infant title As:-"+firstInfantTitle);
        if(firstTi.equalsIgnoreCase(firstInfantTitle)){
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ENTER);
        } else if (secondTi.equalsIgnoreCase(firstInfantTitle)) {
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ARROW_DOWN);
            e.sendKeys(Keys.ENTER);
        }
        Log.info("have successfully selected the first Infant title as:-"+firstInfantTitle);
        return this;
    }
    @Step
    public PaxDetailsPage enterInfant1FirstName(String infant1FirstName){
        Log.info("trying to enter infant1 first name.....As:-"+infant1FirstName);
        WebElement e = wetForElementTOVisible(firstInfantFirstNameInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        e.clear();
        e.sendKeys(infant1FirstName);
        Log.info("successfully entered infant1 first name ....As:-"+infant1FirstName);
        return this;
    }
    @Step
    public PaxDetailsPage enterInfant1LastName(String infant1LastName){
        Log.info("trying to enter infant1 last name.....As:-"+infant1LastName);
        WebElement e = wetForElementTOVisible(firstInfantLastNameInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        e.clear();
        e.sendKeys(infant1LastName);
        Log.info("successfully entered  infant1 last name.....As:-"+infant1LastName);
        return this;
    }
    @Step
    public PaxDetailsPage enterInfant1DOB(String infant1DOB){
        Log.info("trying to enter infant1 dob as:-"+infant1DOB);
        WebElement e = wetForElementTOVisible(firstInfantDOB);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        e.sendKeys(infant1DOB);
        Log.info("successfully entered the infant1 dob as:-"+infant1DOB);
        return this;
    }
    @Step
    public PaxDetailsPage enterMobileNumber(String mobileNumber){
        Log.info("trying to enter mobile number As:-"+mobileNumber);
        WebElement e1 = wetForElementTOVisible(mobileNumberInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e1);
        e1.clear();
        e1.sendKeys(mobileNumber);
        Log.info("successfully entered mobile number as:-"+mobileNumber);
        return this;
    }
    @Step
    public PaxDetailsPage enterEmail(String email){
        Log.info("trying to enter email id as:-"+email);
        WebElement e = wetForElementTOVisible(emailInputField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.clear();
        e.sendKeys(email);
        Log.info("successfully entered email id as:- "+email);
        return this;
    }
    @Step
    public TermsAndConditionsPage clickOnProceedToReviewBtn(){
        Log.info("trying to click on proceed button.............");
        WebElement e = wetForElementTOClicable(proceedToReviewBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("successfully clicked on proceed button and get in to the Terms and condition page");
        return new TermsAndConditionsPage(driver);
    }

    @Step
    public PaxDetailsPage clickOnSkipProtectGroupBtn(){
        Log.info("clicking on skip button of protect group...");
        WebElement e = wetForElementTOClicable(skipProtectGroup);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
        e.click();
        Log.info("have clicked on skip protect group btn");
        return this;
    }


}
