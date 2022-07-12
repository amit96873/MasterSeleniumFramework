package org.selenium.pom.base;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.selenium.pom.utils.Log;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    public WebDriver getDriver() {
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public void startDriver(String browser) {
        DOMConfigurator.configure("log4j.xml");
        Log.info("this is before method");
        browser = System.getProperty("browser", browser);
        setDriver(new DriverManager().initializeDriver(browser));
        System.out.println("CURRENT THREAD" + Thread.currentThread().getId() + "," + "Driver = " + getDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public void quitDriver(@Optional String browser, ITestResult result) throws InterruptedException, IOException {
        System.out.println("CURRENT THREAD" + Thread.currentThread().getId() + "," + "Driver = " + getDriver());
        if (result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("scr" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + ".png");
            takeScreenshot(destFile);

        }

        getDriver().quit();
    }

    public void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }

}
