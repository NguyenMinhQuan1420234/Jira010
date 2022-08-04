package com.tms.quannguyen.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.Shared.NavigationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class LoginTest extends BaseTest {
    
    // public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    @BeforeMethod
    public void SetUp() {
        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);
    }

    @Test(priority = 0, description = "Login with valid Admin account")
    public void LoginSuccessfulCase() throws InterruptedException {

        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword(ConfigConstants.PASSWORD);
        loginPage.clickLoginBtn();

        assertThat("verify message: ", navigatePage.getUsername(), equalTo(ConfigConstants.USERNAME));
    }

    @Test(priority = 1, description = "Login with empty password ") //empty password
    public void LoginUnsuccessfulNoPassword() throws InterruptedException {

        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword("");
        loginPage.clickLoginBtn();

        assertThat("verify message: ", navigatePage.requireMessage(), equalTo(loginPage.RQR_MSG));
    }

    @Test(priority = 1, description = "Login with empty username")
    public void LoginUnsuccessfulNoUsername() throws InterruptedException {

        loginPage.inputUsername("");
        loginPage.inputPassword(ConfigConstants.PASSWORD);
        loginPage.clickLoginBtn();
        
        assertThat("verify message: ", navigatePage.requireMessage(), equalTo(loginPage.RQR_MSG));
    }

    @Test(priority = 1, description = "Login with empty username and password")
    public void LoginUnsuccessfulEmpty() throws InterruptedException {

        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLoginBtn();
        
        assertThat("verify message: ", navigatePage.requireMessage(), equalTo(loginPage.RQR_MSG));
    }

    @Test(priority = 2, description = "Login with invalid username and password")
    public void LoginUnsuccessfulInvalidData() throws InterruptedException {

        loginPage.inputUsername("Admin1");
        loginPage.inputPassword("qp$#tGu3");
        loginPage.clickLoginBtn();
        
        assertThat("verify message: ", navigatePage.errorMessage(), equalTo(loginPage.ERR_MSG));
    }
}
