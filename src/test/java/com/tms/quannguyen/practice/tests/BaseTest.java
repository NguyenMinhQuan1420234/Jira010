package com.tms.quannguyen.practice.tests;

import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;

@Listeners({ ExtentIReporterSuiteListenerAdapter.class })
public class BaseTest {

    public WebDriver driver;
    LoginPage loginPage;
    // public HomePage  homePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void BeforeMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(ConfigConstants.BASE_URL);

        // WebDriverManager.edgedriver().setup();
        // driver = new EdgeDriver();

        // loginPage = new LoginPage(driver);
        // loginPage.LoginSuccessfully();
    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
