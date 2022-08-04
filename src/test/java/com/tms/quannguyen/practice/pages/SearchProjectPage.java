package com.tms.quannguyen.practice.pages;

import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.security.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.Select;

import com.tms.quannguyen.practice.contents.ConfigConstants;

public class SearchProjectPage extends BasePage {
    // drop down list Project option
    public static final By BTN_DROPDOWN_PROJECT = By.xpath("//a[contains(text(),'Projects')]");
    public static final By OPT_CREATE_PROJECT = By.xpath("//a[contains(text(),'Create Project')]");
    public static final By OPT_SEARCH_PROJECT = By.xpath("//a[contains(text(),'Search Project')]");
    // Search options
    public static final By TXT_PROJECT_NAME = By.xpath("//input[@ng-model='input.projectname']");
    public static final By DDL_LOCATION = By.id("ddl-location");
    public static final By DDL_PROJECT_TYPE = By.id("ddl-projecttype");
    public static final By BTN_SEARCH = By.xpath("//search-project//button[@ng-click='search(input)']");

    public static final By SEARCH_RESULT_NAME = By.xpath("//a[contains(text(),'%s')]");
    public static final By HTML = By.cssSelector("html[ng-app='TMS']");
    public static final By TITLE = By.xpath("//b[@class='ng-binding']");

    public SearchProjectPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public void searchProjectName(String username) {
        inputText(TXT_PROJECT_NAME, username);
    }

    public void clickSearchMenu() {
        clickElement(BTN_DROPDOWN_PROJECT);
        clickElement(OPT_SEARCH_PROJECT);
    }

    public void inputSearchProjectNameDefault() {
        inputText(TXT_PROJECT_NAME, ConfigConstants.PRJ_SEARCH_NAME);
    }

    public void inputSearchProjectName(String text) {
        inputText(TXT_PROJECT_NAME, text);
    }

    public void clickSearchButton() {
        clickElement(BTN_SEARCH);
    }

    public List<WebElement> listOfProjectName(By locator) {
        return (List<WebElement>) waitForListOfElementToBeVisible(locator);

    }

    public void zoomOutSearchPage() throws AWTException {
        WebElement textboxSearchProject = driver.findElement(TXT_PROJECT_NAME);
        Actions a = new Actions(driver);
        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(textboxSearchProject);
        // driver.manage().window()
        a.moveToElement(textboxSearchProject).click();
        a.sendKeys(Keys.EQUALS);
        a.keyDown(Keys.LEFT_CONTROL);
        a.scrollFromOrigin(scrollOrigin, 120, 0);
        a.keyDown(Keys.SUBTRACT);
        a.keyUp(Keys.SUBTRACT);
        a.perform();

        // textboxSearchProject.sendKeys(Keys.NUMPAD0);
        // Robot robot = new Robot();
        // System.out.println("About to zoom out");
        // for (int i = 0; i < 2; i++) {
        // robot.keyPress(KeyEvent.VK_CONTROL);
        // robot.keyPress(KeyEvent.VK_SUBTRACT);
        // robot.keyRelease(KeyEvent.VK_SUBTRACT);
        // robot.keyRelease(KeyEvent.VK_CONTROL);
        // }

        // WebElement html = driver.findElement(By.tagName("html"));
        // moveToElement(TXT_PROJECT_NAME);
        // waitForElementToBeClickable(TXT_PROJECT_NAME).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        
        // System.out.println("zooming");
        // // To zoom in 3 times
        // for(int i=0; i< 3 ; i++){
        // waitForElementToBeVisible(By.cssSelector("html[ng-app='TMS']")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
        // }
        // // To zoom out 3 times
        // for(int i=0; i  < 3 ; i++){
        // driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
        // }
        // //To set the browser to default zoom level ie., 100%
        // driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
    }
    
    public void zoom() {
        zoomOutWeb(HTML);
    }
}
