package com.tms.quannguyen.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateProjectPage extends BasePage {

    public static final By TXT_PROJECT_NAME = By.id("name");
    public static final By DDL_PROJECT_TYPE = By.id("projecttype");
    public static final By DDL_PROJECT_STATUS = By.id("status");
    public static final By DDL_START_DATE = By.cssSelector("input[name='sdate']");
    public static final By DDL_END_DATE = By.cssSelector("input[name='edate']");
    public static final By TXT_SIZEDAY = By.id("sizeday");
    public static final By DDL_LOCATION = By.id("location");
    public static final By DDL_PROJECT_MANAGER = By.id("projectManager");
    public static final By DDL_DELIVERY_MANAGER = By.id("deliveryManager");
    public static final By DDL_ENGAGEMENT_MANAGER = By.id("engagementManager");
    public static final By TXT_SHORT_DESCRIPTION = By.id("shortDescription");
    public static final By TXT_LONG_DESCRIPTION = By.id("longDescription");
    public static final By TXT_TECHNOLOGIES = By.id("technologies");
    public static final By TXT_CLIENTNAME = By.id("clientName");
    public static final By DDL_CLIENT_INDUSTRY = By.id("clientindustry");
    public static final By TXT_CLIENT_DESCRIPTION = By.id("clientdescription");
    public static final By BTN_CREATE = By.cssSelector("project-create button[type='submit']");
    public static final By BTN_CANCEL = By.xpath("//button[@ng-click='pcC.cancel()']");

    public CreateProjectPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public void inputTextBox(By locator, String text) {
        inputText(locator, text);
    }






}
