package com.tms.quannguyen.practice.tests;

import com.tms.quannguyen.practice.contents.ConfigConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;

@Listeners({ ExtentIReporterSuiteListenerAdapter.class })
public class BaseTest {

    public WebDriver driver;
    // public HomePage  homePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void BeforeMethod() throws InterruptedException {
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get(ConfigConstants.BASE_URL);
    }

    @AfterClass
    public void AfterMethod() {
         driver.quit();
    }
}
