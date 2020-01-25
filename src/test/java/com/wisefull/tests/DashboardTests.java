package com.wisefull.tests;

import com.wisefull.common.Driver;
import com.wisefull.common.TestBase;
import com.wisefull.pages.DashboardPage;
import com.wisefull.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DashboardTests extends TestBase {
    @Test (groups= {"dashboard", "regression"})
    public void verifyUsersNameOnDashboardMatches() throws InterruptedException {
        new LoginPage().login("nyaz@na.edu", "123456_point");
        new DashboardPage().WaitForPageToLoad();
        Thread.sleep(2000);
        String usersNameOnDashboard=new DashboardPage().getUsersNameFromDashboard();

        Assert.assertEquals(usersNameOnDashboard, "Ms. Patrick");
    }
    @Test(groups= {"dashboard", "regression"})
    public void verifyUserCanLogout() throws InterruptedException {

        LoginPage loginPage=new LoginPage();
        loginPage.login("nyaz@na.edu", "123456_point");
        Thread.sleep(2000);
        new DashboardPage().logout();
        Boolean isLoginButtonDisplayed=loginPage.isLoginButtonDisplayed();
        Assert.assertTrue(isLoginButtonDisplayed);
    }
    @Test(groups= {"dashboard", "regression"})
    public void clickToCategories () throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.login("nyaz@na.edu", "123456_point");
        Driver.getDriver().manage().window().maximize();
        Thread.sleep(3000);
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.WaitForPageToLoad();
        dashboardPage.clickToCategoriesButton();
    }
    @Test(groups= {"dashboard", "regression"})
    public void chooseMathLessonCategory() throws InterruptedException {
        LoginPage loginPage=new LoginPage();
        loginPage.login("nyaz@na.edu", "123456_point");
        Driver.getDriver().manage().window().maximize();
        Thread.sleep(3000);
        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.WaitForPageToLoad();
        dashboardPage.clickToCategoriesButton();
        dashboardPage.WaitForPageToLoad();
        dashboardPage.chooseAcademicsTab();
        dashboardPage.WaitForPageToLoad();
        dashboardPage.chooseTheMathClass();
        //dashboardPage.WaitForPageToLoad();
        //dashboardPage.chooseSatMathClass();

    }
}
