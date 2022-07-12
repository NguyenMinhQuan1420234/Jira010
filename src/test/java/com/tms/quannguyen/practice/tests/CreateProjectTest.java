package com.tms.quannguyen.practice.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.CreateProjectPage;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.NavigationPage;
import com.tms.quannguyen.practice.pages.SearchProjectPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProjectTest extends BaseTest {
    
    public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    CreateProjectPage createProjectPage;
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
    public void CreateProjectSuccess() {

        createProjectPage = new CreateProjectPage(driver);
        navigatePage = new NavigationPage(driver);

        createProjectPage.clickCreateProjectDropdownList();
        createProjectPage.fillProjectInfomation();
        createProjectPage.selectProjectValue();
        createProjectPage.PickToday();

        createProjectPage.clickCreateButton();

        assertThat("verify message: ", navigatePage.getProjectName(), equalTo(ConfigConstants.PRJ_NAME));
    }

    @AfterMethod
    public void AfterMethod() {
        createProjectPage.deleteProject();
        driver.quit();
    }

}
