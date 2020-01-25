package com.wisefull.tests;

import com.wisefull.common.Driver;
import com.wisefull.common.TestBase;
import com.wisefull.pages.DashboardPage;
import com.wisefull.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test (groups= {"login", "regression"})
    public void verifyUserCanLoginWithCorrectCredentials() throws InterruptedException {
        new LoginPage().login("nyaz@na.edu","123456_point");
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://lessoncourse.com/login");
    }
    @Test(groups= {"login", "regression"})
    public void verifyUserCanNotLoginWithIncorrectPasswordIsShownErrorMessage() throws InterruptedException {
        new LoginPage().login("nyaz@na.edu","123456");
        new DashboardPage().WaitForPageToLoad();
       Thread.sleep(1000);
        String errorMessageIncorrectPassword=new LoginPage().getErrorMessageInvalidPassword();
        Assert.assertEquals(errorMessageIncorrectPassword,"\n" +
                "Invalid password.");
        //Assert.assertEquals(errorMessageText,"User not found.");
        //burda invalid password. ile assert edemedim

    }
    @Test(groups= {"login", "regression"})
    public void verifyUserCannotLoginWithIncorrectUsernameIsShownErrorMessage() throws InterruptedException {
        new LoginPage().login("nya@na.edu", "123456_point");
        new DashboardPage().WaitForPageToLoad();
        Thread.sleep(1000);
        String errorMessageIncorrectUser=new LoginPage().getErrorMessageUserNotFound();
        Assert.assertEquals(errorMessageIncorrectUser, "\n" +
                "User not found.");
    }
}
