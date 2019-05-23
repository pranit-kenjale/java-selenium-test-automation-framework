package com.framework.reporter;

import org.testng.annotations.BeforeMethod;
import com.framework.selenium.SeleniumTestEngine;
import com.ridecell.pageobjects.LoginPage;

/**
 * Custom Base Test
 */
public class CustomBaseTest extends BaseTest {

  protected LoginPage loginPage;

  @BeforeMethod
  public void customBaseBeforeMethod() throws InterruptedException {
    testEngine = new SeleniumTestEngine();
    testApp = testEngine.start("custom");

    loginPage = testApp.getInstance(LoginPage.class);

    // Log in to site
    loginPage.loginToSite(testApp);
  }

  public void getUtilsObject() {}
}
