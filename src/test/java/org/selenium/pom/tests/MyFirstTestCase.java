package org.selenium.pom.tests;

import org.openqa.selenium.By;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.LoginCredentials;
import org.selenium.pom.objects.User;
import org.selenium.pom.pages.DashboardPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyFirstTestCase extends BaseTest {

    @Test
    public void apistagingtest() throws  IOException {

      LoginCredentials loginCredentials = JacksonUtils.deserializeJson("loginCredentialsData.json", LoginCredentials.class);

        User user   = new User(ConfigLoader.getInstance().getUsername(), ConfigLoader.getInstance().getPassword());

         DashboardPage dashboardPage = new HomePage(getDriver()).
                load().login(user);
         dashboardPage.isLoaded();
         dashboardPage.selectGroup();
        HomePage homePage = dashboardPage.clickOnLogoutBtn();
        homePage.isLoaded();
        Assert.assertEquals(homePage.getTitle(), "Already using Technogram Solutions?");






    }
}
