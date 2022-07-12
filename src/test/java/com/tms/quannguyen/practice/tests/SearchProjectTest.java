package com.tms.quannguyen.practice.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.NavigationPage;
import com.tms.quannguyen.practice.pages.SearchProjectPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SearchProjectTest {
    public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    SearchProjectPage searchProjectPage;
    
    @BeforeMethod
    public void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigConstants.BASE_URL);
        
        loginPage = new LoginPage(driver);
        loginPage.LoginSuccessfully();
    }

     @Test
     public void searchProjectSuccess() {

        searchProjectPage = new SearchProjectPage(driver);
        navigatePage = new NavigationPage(driver);

        searchProjectPage.clickSearchMenu();
        searchProjectPage.inputSearchProjectNameDefault();
        searchProjectPage.clickSearchButton();

        assertThat("verify project name: ", navigatePage.resultProjectName(), equalTo(ConfigConstants.PRJ_SEARCH_NAME));

     }

     @AfterMethod
     public void AfterMethod() {
         driver.quit();
     }

}
