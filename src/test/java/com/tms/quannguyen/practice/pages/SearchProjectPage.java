package com.tms.quannguyen.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchProjectPage extends BasePage {

    public static final By BTN_DROPDOWN_PROJECT = By.xpath("//a[contains(text(),'Projects')]");
    public static final By OPT_CREATE_PROJECT = By.xpath("//a[contains(text(),'Create Project')]");
    public static final By OPT_SEARCH_PROJECT = By.xpath("//a[contains(text(),'Search Project')]");
    

    public SearchProjectPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
}
