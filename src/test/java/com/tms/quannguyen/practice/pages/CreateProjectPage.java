package com.tms.quannguyen.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tms.quannguyen.practice.contents.ConfigConstants;

public class CreateProjectPage extends BasePage {
    // Search Page Button
    public static final By BTN_DROPDOWN_PROJECT = By.xpath("//a[contains(text(),'Projects')]");
    public static final By OPT_CREATE_PROJECT = By.xpath("//a[contains(text(),'Create Project')]");
    public static final By OPT_SEARCH_PROJECT = By.xpath("//a[contains(text(),'Search Project')]");

    // Create Project Form
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

    // Project information
    public static final By BTN_DELETE = By.xpath("//button[text()='Delete']");
    public static final By BTN_YES = By.xpath("//button[@ng-click='piC.deleteProject()']");
    
    // Date picker
    public static final By BTN_SDATE_PICKER = By.xpath("//button[@ng-click='pcC.openSDatePicker()']");
    public static final By BTN_EDATE_PICKER = By.xpath("//button[@ng-click='pcC.openEDatePicker()']");
    public static final By BTN_TODAY = By.xpath("//button[text()='Today']");
    

    public static final By DATE_PICKER_DAY(String text) { 
        // return By.xpath($"//span[@class='ng-binding'][text()='text']");
        return By.xpath(String.format("//span[@class='ng-binding'][text()='%s']", text));
    }

    public void PickToday() {
        clickElement(BTN_SDATE_PICKER);
        clickElement(BTN_TODAY);
        // clickElement(BTN_EDATE_PICKER);
        // clickElement(BTN_TODAY);
    }

    //method
    public CreateProjectPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    public void clickCreateProjectDropdownList() {
        clickElement(BTN_DROPDOWN_PROJECT);
        clickElement(OPT_CREATE_PROJECT);
    }

    public void clickCreateButton() {
        clickElement(BTN_CREATE);
    }

    public void clickCancelButton() {
        clickElement(BTN_CANCEL);
    }

    public void deleteProject() {
        clickElement(BTN_DELETE);
        clickElement(BTN_YES);
    }

    public void elementSelectByIndex(By locator, int number) {
        Select element = elementSelect(locator);
        element.selectByIndex(number);
    }

    public void elementSelectByValue(By locator, String value) {
        Select element = elementSelect(locator);
        element.selectByValue(value);
    }

    public void elementSelectByVisibleText(By locator, String text) {
        Select element = elementSelect(locator);
        element.selectByVisibleText(text);
    }


    public void inputTextBox(By locator, String text) {
        inputText(locator, text);
    }

    public void fillProjectInfomation() {
        inputTextBox(TXT_PROJECT_NAME, ConfigConstants.PRJ_NAME);
        inputTextBox(TXT_SIZEDAY, "1");
        inputTextBox(TXT_SHORT_DESCRIPTION, ConfigConstants.TXT_INPUT);
        inputTextBox(TXT_LONG_DESCRIPTION, ConfigConstants.TXT_INPUT);
        inputTextBox(TXT_TECHNOLOGIES, ConfigConstants.TXT_INPUT);
        inputTextBox(TXT_CLIENTNAME, ConfigConstants.TXT_INPUT);
        inputTextBox(TXT_CLIENT_DESCRIPTION, ConfigConstants.TXT_INPUT);
    }

    public void selectProjectValue() {
        elementSelectByIndex(DDL_PROJECT_STATUS, 1);
        elementSelectByIndex(DDL_PROJECT_TYPE, 1);
        elementSelectByIndex(DDL_LOCATION, 1);
        elementSelectByIndex(DDL_PROJECT_MANAGER, 1);
        elementSelectByIndex(DDL_DELIVERY_MANAGER, 1);
        elementSelectByIndex(DDL_ENGAGEMENT_MANAGER, 1);
        elementSelectByIndex(DDL_CLIENT_INDUSTRY, 1);

    }
}
