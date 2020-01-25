package com.wisefull.common;
import org.testng.annotations.*;

public class TestBase extends Base{
    @BeforeSuite
    public void beforeSuit(){
        Driver.setUpDriver();

    }
    @BeforeMethod
    public void beforeMethod(){
        Driver.getDriver();

    }
    @AfterMethod
    public void afterMethod(){
        Driver.closeDriver();

    }
    @AfterSuite
    public void afterSuite(){

    }


}
