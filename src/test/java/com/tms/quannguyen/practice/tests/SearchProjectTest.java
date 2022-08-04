package com.tms.quannguyen.practice.tests;

import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.SearchProjectPage;
import com.tms.quannguyen.practice.pages.Shared.NavigationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.fail;

import java.awt.AWTException;

public class SearchProjectTest extends BaseTest {
    // public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    SearchProjectPage searchProjectPage;
    
    @BeforeMethod
    public void BeforeSearch() {       
        driver.manage().window().setSize(new Dimension(1024,768));
        loginPage = new LoginPage(driver);
        loginPage.LoginWithUsernameAndPassword();
        searchProjectPage = new SearchProjectPage(driver);
        navigatePage = new NavigationPage(driver);
    }

     @Test
     public void searchProjectSuccess() {

        searchProjectPage.clickSearchMenu();
        searchProjectPage.inputSearchProjectNameDefault();
        searchProjectPage.clickSearchButton();
        searchProjectPage.zoom();

        assertThat("verify project name: ", navigatePage.resultProjectName(), equalTo(ConfigConstants.PRJ_SEARCH_NAME));
     }

     @Test
     public void searchProjectByMethod() throws AWTException {

        searchProjectPage.clickSearchMenu();
        searchProjectPage.inputSearchProjectName("aaa");
        searchProjectPage.clickSearchButton();
        searchProjectPage.zoomOutSearchPage();
        searchProjectPage.zoom();
        // searchProjectPage.driver.manage().window().maximize();
        // navigatePage.verifyProjectName(ConfigConstants.PRJ_SEARCH_NAME, "quan");
        navigatePage.verifyProjectName("aaa", "aaa");
     }
}
