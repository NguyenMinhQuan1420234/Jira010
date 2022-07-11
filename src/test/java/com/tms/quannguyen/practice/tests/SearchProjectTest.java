package com.tms.quannguyen.practice.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.NavigationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchProjectTest extends BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    
    @BeforeMethod
    public void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigConstants.BASE_URL);

        loginPage = new LoginPage(driver);
        loginPage.LoginSuccessfully();
    }

}
