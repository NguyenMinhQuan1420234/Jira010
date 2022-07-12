package com.tms.quannguyen.practice.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Config;
import com.tms.quannguyen.practice.contents.ConfigConstants;

public class NavigationPage extends BasePage {

    //LoginTest Assertion
    private By IMG_TXT = By.xpath("//a[text()=' Admin2 ']");
    private By CLASS_NAME = By.id("userName");
    private By ERR_MSG = By.xpath("//p[@ng-message='required']");
    private By ERR_MSG_2 = By.xpath("//div[@ng-show='isError']");

    // Search Page
    private By SEARCH_RESULT = By.xpath(String.format("//a[text()='%s']",ConfigConstants.PRJ_SEARCH_NAME));
    public static final By SEARCH_RESULT_NAME = By.xpath("//a[contains(text(),'%s')]");
    public static final By BTN_NEXT_PAGE = By.xpath("//a[@ng-click='setCurrent(pagination.current + 1)']");
    public static final By BTN_NEXT_PAGE_DISABLE = By.xpath("//li[@class='ng-scope disabled']/a[@ng-click='setCurrent(pagination.current + 1)'']");

    public static final By listOfProjectNameLocator(String text) { // number with double digit 01->31
        return By.xpath(String.format("//a[contains(text(),'%s')]", text));
    }

    public List<WebElement> listOfProjectName(String text) {
        return (List<WebElement>) waitForElementToBeVisible(listOfProjectNameLocator(text));

    }

    public String getProjectResultName(By locator) {
        return getText(locator);

    }
 
    public void verifyProjectName(String expected, String actual) {
        List<WebElement> projectNameList = listOfProjectName(actual);
        boolean flag = true;

        while(flag) {
            for (WebElement projectName: projectNameList) {
                String Name = projectName.getText();
                if (expected == Name) {
                    flag = false;
                    break;
                }
            }
            clickElement(BTN_NEXT_PAGE);
        }
    }

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

    // public List<WebElement> listOfProjectName() {
    //     return ;
    // }

}
