package com.wisefull.utils;

import com.wisefull.common.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumUtil {
    private final long SHORT_EXPLICIT_WAIT_TIME=10;
    public WebElement findElement(By locator){

        return Driver.getDriver().findElement(locator);
    }
    public void sendKeys(By locator, String text){
        clear(locator);
        findElement(locator).sendKeys(text);
    }
    public void clear(By locator){
        findElement(locator).clear();
    }
    public void click(By locator){
        findElement(locator).click();
    }

    public String getText(By locator){
        waitFor(500);
        return findElement(locator).getText();

    }
    public String getAttributeText(By locator) {

        return findElement(locator).getAttribute("innerHTML");
    }
    public boolean isDisplayed(By locator){

        return findElement(locator).isDisplayed();
    }
    public void waitFor(long millis){

    }
    public void waitForVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), SHORT_EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
}
