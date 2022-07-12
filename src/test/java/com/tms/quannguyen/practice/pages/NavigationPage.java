package com.tms.quannguyen.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tms.quannguyen.practice.contents.ConfigConstants;

public class NavigationPage extends BasePage {

    //LoginTest Assertion
    private By IMG_TXT = By.xpath("//a[text()=' Admin2 ']");
    private By CLASS_NAME = By.id("userName");
    private By ERR_MSG = By.xpath("//p[@ng-message='required']");
    private By ERR_MSG_2 = By.xpath("//div[@ng-show='isError']");

    // Search Page
    private By SEARCH_RESULT = By.xpath(String.format("//tr//a[text()='%s']",ConfigConstants.PRJ_SEARCH_NAME));

    //Create Page
    private By PROJECT_NAME = By.xpath("//label[@for='name']/following-sibling::p");

    /* ****************************************************************************  */
    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    /* Log in assert method  */
    public String getUsername() {
        return getText(IMG_TXT);
    }

    public String errorMessage() {
        return getText(ERR_MSG_2);
    }

    public String requireMessage() {
        return getText(ERR_MSG);
    }

    public String getClassAttribute() {
        return getAttribute(CLASS_NAME, "class");
    }

    /* Create Project assert method  */

    public String getProjectName() {
        return getText(PROJECT_NAME);
    }

    /* Search Project assert method */

    public String resultProjectName() {
        return getText(SEARCH_RESULT);
    }

}
