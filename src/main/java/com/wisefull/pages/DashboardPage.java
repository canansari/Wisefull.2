package com.wisefull.pages;


import com.wisefull.common.Driver;
import com.wisefull.common.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;



public class DashboardPage extends PageBase {
    private By usersNameLocator=By.xpath("//span[@class='font-size-16 ng-binding']");
    private By logoutMenuBar= By.xpath("//md-menu-bar[@id='user-menu']/md-menu/button/div[1]");
    private  By logoutButtonClick=By.xpath("//button[@translate='TOOLBAR.LOGOUT']");
    private By categoriesLocator=By.xpath("//span[@class='text-semibold color-def hide-md hide-sm hide-xs ng-scope']");
    private By academicsButtonLocatorUnderCategories=By.xpath("//div[@translate='CAT.ACA.NAME']");
    private By mathButtonLocatorUnderAcademics=By.xpath("//a[@aria-label='MATH']/div[1]");
    //private By satMathCourseLocator=By.xpath("//*[@id=\"listRes\"]/md-grid-list/md-grid-tile[1]/figure/div/div/div/ng-transclude/a/div");

    public String getUsersNameFromDashboard(){
        String text= Driver.getDriver().findElement(usersNameLocator).getText();
        return text;
    }

    public void logout() {
        //seleniumUtil.click(logoutMenuBar);

        Driver.getDriver().findElement(logoutMenuBar).click();
        Driver.getDriver().findElement(logoutButtonClick).sendKeys(Keys.ENTER);
    }
    public void clickToCategoriesButton(){
        seleniumUtil.click(categoriesLocator);
    }
    public void chooseAcademicsTab(){

        seleniumUtil.click(academicsButtonLocatorUnderCategories);

    }
    public void chooseTheMathClass(){


        seleniumUtil.click(mathButtonLocatorUnderAcademics);

    }
    /*
    public void chooseSatMathClass(){
        seleniumUtil.click(satMathCourseLocator);
    }

     */


    public void WaitForPageToLoad() {

        seleniumUtil.waitForVisibility(logoutButtonClick);
    }

}
