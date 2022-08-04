package com.tms.quannguyen.practice.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.CreateProjectPage;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.SearchProjectPage;
import com.tms.quannguyen.practice.pages.Shared.DatePickerPage;
import com.tms.quannguyen.practice.pages.Shared.NavigationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CreateProjectTest extends BaseTest {
    
    LoginPage loginPage;
    NavigationPage navigatePage;
    CreateProjectPage createProjectPage;
    SearchProjectPage searchProjectPage;
    DatePickerPage datePickerPage;

    @BeforeMethod
    public void BeforeCreateProject() {

        loginPage = new LoginPage(driver);
        loginPage.LoginWithUsernameAndPassword();

        createProjectPage = new CreateProjectPage(driver);
        navigatePage = new NavigationPage(driver);  
        datePickerPage = new DatePickerPage(driver);
        System.out.println("Before Create");
    }

    @Test
    public void CreateProjectSuccessfully() {
        
        createProjectPage.clickCreateProjectDropdownList();
        String projectname = createProjectPage.createProjectNameUnique();
        createProjectPage.fillProjectInfomation(projectname);
        createProjectPage.selectProjectValue();
        datePickerPage.sdayOpen();
        datePickerPage.datePicker("2042", "June", "29");
        datePickerPage.edayOpen();
        datePickerPage.datePicker("2068", "October", "15");

        createProjectPage.clickCreateButton();

        assertThat("verify message: ", navigatePage.getProjectName(), equalTo(projectname));
    }

    @AfterMethod
    public void DeleteProject() {
        createProjectPage.deleteProject();
    }

}
