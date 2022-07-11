package com.tms.quannguyen.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SearchProjectPage extends BasePage {
    // drop down list Project option
    public static final By BTN_DROPDOWN_PROJECT = By.xpath("//a[contains(text(),'Projects')]");
    public static final By OPT_CREATE_PROJECT = By.xpath("//a[contains(text(),'Create Project')]");
    public static final By OPT_SEARCH_PROJECT = By.xpath("//a[contains(text(),'Search Project')]");
    // Search options
    public static final By TXT_PROJECT_NAME = By.xpath("//input[@ng-model='input.projectname']");
    public static final By DDL_LOCATION = By.id("ddl-location");
    public static final By DDL_PROJECT_TYPE = By.id("ddl-projecttype");

    public SearchProjectPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public void searchProjectName(String username) {
        inputText(TXT_PROJECT_NAME, username);
    } 
    
    public void elementSelectByIndex(By locator, int number) {
        Select element = elementSelect(locator);
        element.selectByIndex(number);
    }

}
