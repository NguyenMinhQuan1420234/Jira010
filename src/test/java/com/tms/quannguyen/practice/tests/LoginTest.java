package com.tms.quannguyen.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.NavigationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Listeners({ ExtentIReporterSuiteListenerAdapter.class })
public class LoginTest extends BaseTest {
    
    public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    static ExtentReports report;
    static ExtentTest test;

    @BeforeMethod
    public void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        report = new ExtentReports("C:/Users/banch/QuanNguyen-practice-auto/selenium-testng/extent-reports/report.html", true);
        test = report.startTest("Extent report demo");
        driver.get(ConfigConstants.BASE_URL);

    }

    @AfterMethod
    public void AfterMethod() {
        report.endTest(test);
        report.flush();
        driver.close();
    }

    @Test(priority = 0, description = "Login with valid Admin account")
    public void LoginSuccessfulCase() throws InterruptedException {

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword(ConfigConstants.PASSWORD);
        loginPage.clickLoginBtn();

        assertThat("verify message: ", navigatePage.getUsername(), equalTo(ConfigConstants.USERNAME));
    }

    @Test(priority = 1, description = "Login with empty password")
    public void LoginUnsuccessfulNoPassword() throws InterruptedException {

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword("");
        loginPage.clickLoginBtn();

        assertThat("verify message: ", navigatePage.requireMessage(), equalTo(ConfigConstants.RQR_MSG));
    }

    @Test(priority = 1, description = "Login with empty username")
    public void LoginUnsuccessfulNoUsername() throws InterruptedException {

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword("");
        loginPage.clickLoginBtn();
        
        assertThat("verify message: ", navigatePage.requireMessage(), equalTo(ConfigConstants.RQR_MSG));
    }

    @Test(priority = 1, description = "Login with empty username and password")
    public void LoginUnsuccessfulEmpty() throws InterruptedException {

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.inputUsername("");
        loginPage.inputPassword("");
        loginPage.clickLoginBtn();
        
        assertThat("verify message: ", navigatePage.requireMessage(), equalTo(ConfigConstants.RQR_MSG));
    }

    @Test(priority = 2, description = "Login with invalid username and password")
    public void LoginUnsuccessfulInvalidData() throws InterruptedException {

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.inputUsername("Admin1");
        loginPage.inputPassword("qp$#tGu3");
        loginPage.clickLoginBtn();
        
        assertThat("verify message: ", navigatePage.errorMessage(), equalTo(ConfigConstants.ERR_MSG));
    }
}
