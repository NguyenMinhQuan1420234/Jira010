package com.tms.quannguyen.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatePickerPage extends BasePage {

    public static final By BTN_SDATE_PICKER = By.xpath("//button[@ng-click='pcC.openSDatePicker()']");
    public static final By BTN_EDATE_PICKER = By.xpath("//button[@ng-click='pcC.openEDatePicker()']");
    public static final By BTN_TODAY = By.xpath("//button[text()='Today']");
    public static final By BTN_CLEAR = By.xpath("//button[text()='Today']");
    public static final By BTN_CLOSE = By.xpath("//button[text()='Today']");
    public static final By BTN_MONTH_YEAR = By.xpath("//button[@ng-disabled='datepickerMode === maxMode']");
    public static final By BTN_NEXT_20_YEAR_BUTTON = By.xpath("button[@ng-click='move(1)'']");
    public static final By BTN_PREVIOUS_20_YEAR_BUTTON = By.xpath("button[@ng-click='move(-1)'']");
    public static final By BTN_YEAR_RANGE = By.cssSelector("strong.ng-binding");

    public static final By DATE_PICKER_YEAR(String text) { // number with double digit 01->31
        return By.xpath(String.format("//span[text()='%s']", text));
    }

    public static final By DATE_PICKER_MONTH(String text) {
        return By.xpath(String.format("//span[text()='%s']", text));
    }

    public static final By DATE_PICKER_DAY(String text) { // number with double digit 01->31
        return By.xpath(String.format("//span[@class='ng-binding'][text()='%s']", text));
    }

    public String[] yearRange(By locator) { // "2022 - 2042"
        return getText(locator).split(" - ");
    }

    public void datePicker(String year, String month, String day) {
        clickElement(BTN_SDATE_PICKER);
        

    }

    public DatePickerPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

}
