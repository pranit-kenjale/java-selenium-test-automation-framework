package com.framework.reporter;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.framework.core.TestApplication;
import com.framework.core.TestEngine;

public class BaseTest {

  public TestApplication testApp;
  public TestEngine testEngine;

  @BeforeSuite
  public void beforeSuite() {

  }

  @AfterMethod
  public void afterMethod(ITestResult result) {

    testApp.getTestContext().takeScreenShot(result.getTestClass().getRealClass().getSimpleName());


    // Add reporting logic here
    // logout
  }


  @AfterSuite
  public void afterSuite() {
    // testEngine.stop();

  }



}
