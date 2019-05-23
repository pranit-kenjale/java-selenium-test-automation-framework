package com.framework.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.framework.core.TestApplication;
import com.framework.core.TestEngine;
import com.ridecell.utils.PropertyReader;

public class SeleniumTestEngine extends TestEngine {

  public WebDriver driver;
  public TestApplication testApp;
  public SeleniumTestContext seleniumContext;

  @Override
  public final TestApplication start(String url) {

    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();

    testApp = new TestApplication();
    seleniumContext = new SeleniumTestContext();
    seleniumContext.setDriver(driver);
    testApp.setTestContext(seleniumContext);


    driver.manage().window().maximize();

    // Launch url in browser
    launchSite(url);

    return testApp;
  }

  // Launch url in browser
  private void launchSite(String url) {

    if (url.equalsIgnoreCase("custom")) {
      driver.get(PropertyReader.getProperty("customUrl")); // For grid execution, read property from pom.xml
    }
  }

  @Override
  public void stop() {
    driver.close();
    driver.quit();
  }

}
