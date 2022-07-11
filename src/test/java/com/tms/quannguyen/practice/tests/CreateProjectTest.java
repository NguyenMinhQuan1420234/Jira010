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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest extends BaseTest {
    
    public WebDriver driver;
    LoginPage loginPage;
    NavigationPage navigatePage;
    CreateProjectPage createProjectPage;
    

    @BeforeMethod
    public void BeforeMethod() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(ConfigConstants.BASE_URL);

        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);

        loginPage.inputUsername(ConfigConstants.USERNAME);
        loginPage.inputPassword(ConfigConstants.PASSWORD);
        loginPage.clickLoginBtn();

    }

    @Test
    public void CreateProject() {
        System.out.println("awesome");
        // createProjectPage = new CreateProjectPage(driver);
        // createProjectPage.inputText(createProjectPage.TXT_CLIENTNAME, "Vu");
    }

    @AfterMethod
    public void AfterMethod() {
        driver.close();
    }

}
