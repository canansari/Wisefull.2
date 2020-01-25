package com.wisefull.pages;

import com.wisefull.common.Driver;
import com.wisefull.common.PageBase;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    private String pageUrl="https://lessoncourse.com/login";
    private By userNameLocator=By.xpath("//input[@type='text']");
    private By passwordLocator=By.xpath("//input[@name='password']");
    private By loginButtonLocator=By.xpath("//button[@type='submit']");
    private By statusTestInvalidPassword=By.xpath("//md-toast[@layout='row']/div/div");
    private By statusTestUserNotFound=By.xpath("//md-toast[@layout='row']/div/div");
    private By checkLoginButtonLocator=By.xpath("//button[@translate='TOOLBAR.LOGIN']");


    //locators are separated from methods
    public void goToPage() {
        Driver.getDriver().get(pageUrl);
    }

    public void enterUsername(String userName) {
        seleniumUtil.sendKeys(userNameLocator,userName);
    }
    public void enterPassword(String password) {
        seleniumUtil.sendKeys(passwordLocator,password);
    }
    public void clickLoginButton() {
        seleniumUtil.click(loginButtonLocator);
    }
    public String getErrorMessageInvalidPassword() {

        return seleniumUtil.getAttributeText(statusTestInvalidPassword);
    }
    public String getErrorMessageUserNotFound() {
        return seleniumUtil.getAttributeText(statusTestUserNotFound);
    }
    public void login(String userName, String password){
        goToPage();
        enterUsername(userName);
        enterPassword(password);
        clickLoginButton();
    }
    public Boolean isLoginButtonDisplayed(){

        return seleniumUtil.isDisplayed(checkLoginButtonLocator);
    }

    public void WaitForPageToLoad() {
        //TODO Auto-generated stub
    }
}
