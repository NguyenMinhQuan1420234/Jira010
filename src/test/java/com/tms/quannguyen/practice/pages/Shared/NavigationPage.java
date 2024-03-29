package com.tms.quannguyen.practice.pages.Shared;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Config;
import com.tms.quannguyen.practice.contents.ConfigConstants;
import com.tms.quannguyen.practice.pages.BasePage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

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

    public void navigateUrl(String url) {
        driver.get(ConfigConstants.BASE_URL + url);
    }

    public static final By listOfProjectNameLocator(String text) { 
        return By.xpath(String.format("//a[contains(text(),'%s')]", text));
    }

    public ArrayList<WebElement> listOfProjectName(String text) {
        return (ArrayList<WebElement>) waitForListOfElementToBeVisible(listOfProjectNameLocator(text));

    }

    public String getProjectResultName(By locator) {
        return getText(locator);

    }
 
    public void verifyProjectName(String expected, String search) {
        ArrayList<WebElement> projectNameList = listOfProjectName(search); // list chỉ lấy đúng element theo ký tự
        boolean flag = true;
        String name = "";
        
        while(flag) {
            for (WebElement projectName: projectNameList) {
                name = projectName.getText();
                assertThat("verify message:", name, containsString(search));
                // if (expected.equals(name)) 
                    // assertThat("Verify Message", expected, equalTo(name));
            }
            if (projectNameList.size() == 15) { // tổng số là 15 tên / 1 trang
                try {
                    clickElement(BTN_NEXT_PAGE);
                } catch (Exception e) {
                    //TODO: handle exception
                }
                projectNameList = listOfProjectName(search); // đúng ký tự nhập vô mới lập list
            }
            else
                break;
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
