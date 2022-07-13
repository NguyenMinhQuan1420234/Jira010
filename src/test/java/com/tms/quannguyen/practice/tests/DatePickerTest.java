package com.tms.quannguyen.practice.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.databind.JsonSerializable.Base;
import com.tms.quannguyen.practice.pages.CreateProjectPage;
import com.tms.quannguyen.practice.pages.LoginPage;
import com.tms.quannguyen.practice.pages.NavigationPage;
import com.tms.quannguyen.practice.pages.helper.DatePickerPage;

public class DatePickerTest extends BaseTest {
    LoginPage loginPage;
    NavigationPage navigatePage;
    DatePickerPage datePickerPage;
    CreateProjectPage createProjectPage;

    @BeforeMethod
    public void Precondition() {
        loginPage = new LoginPage(driver);
        navigatePage = new NavigationPage(driver);
        datePickerPage = new DatePickerPage(driver);
        createProjectPage = new CreateProjectPage(driver);
        loginPage.LoginSuccessfully();
    }
    
    @Test
    public void PickDate() {
        createProjectPage.clickCreateProjectDropdownList();
        datePickerPage.sdayOpen();
        datePickerPage.datePicker("2044", "May", "02"); // YYYY-MM-DD
        datePickerPage.edayOpen();
        datePickerPage.datePicker("2045", "September", "30"); 
    }
}

    
