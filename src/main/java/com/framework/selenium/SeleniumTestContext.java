package com.framework.selenium;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.framework.core.ITestContext;

public class SeleniumTestContext implements ITestContext {

  WebDriver driver;
  String filePath = "report/ScreenShots/";

  public WebDriver getDriver() {
    return driver;
  }

  public void setDriver(WebDriver driver) {
    this.driver = driver;
  }

  public void get(String url) {
    driver.get(url);
  }

  public void enterTextIn(Object pageElement, String text) {
    ((WebElement) pageElement).sendKeys(text);
  }

  public void clickButton(Object pageElement) {
    if (pageElement != null)
      ((WebElement) pageElement).click();
  }

  public void close() {
    driver.close();
  }

  public String getText(Object pageElement) {
    if (pageElement == null)
      return null;

    return ((WebElement) pageElement).getText();
  }

  public String getValue(Object pageElement) {
    if (pageElement == null)
      return null;

    return ((WebElement) pageElement).getAttribute("value");
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public boolean isEnabled(Object pageElement) {
    return ((WebElement) pageElement).isEnabled();
  }

  public void clearAndReplace(Object pageElement, String text) {
    if (pageElement != null) {
      ((WebElement) pageElement).clear();
      ((WebElement) pageElement).sendKeys(text);
    }
  }

  public String getAttribute(Object pageElement, String attribute) {
    if (pageElement != null) {
      return ((WebElement) pageElement).getAttribute(attribute);
    }
    return null;
  }

  public void takeScreenShot(String pageTitle) {
    filePath = filePath + pageTitle + ".png";
    System.out.println(filePath);
    try {
      File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      FileUtils.copyFile(scrFile, new File(filePath));
    } catch (Exception e) {
    }
  }

  public boolean isDisplayed(Object pageElement) {
    return ((WebElement) pageElement).isDisplayed();
  }

  // Check whether the Web Element exists or not
  public boolean doesElementExist(Object pageElement) {
    if (pageElement == null)
      return false;

    try {
      ((WebElement) pageElement).getTagName();
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }



  public void hardWait(long waitTime) {
    try {
      Thread.sleep(waitTime);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  // Mouse hover using Actions class - Parameter Type - Object
  public void mouseHoverUsingActions(Object pageElement) {
    if (pageElement != null) {
      Actions action = new Actions(driver);
      action.moveToElement((WebElement) pageElement).build().perform();
    }
  }

  public void mouseHoldAndHoverUsingActions(Object pageElement) {
    if (pageElement != null) {
      Actions action = new Actions(driver);
      action.clickAndHold().moveToElement((WebElement) pageElement).build().perform();
    }
  }

  // Double click using Actions class - Parameter Type - Object
  public void doubleClickUsingActions(Object pageElement) {
    if (pageElement != null) {
      Actions actions = new Actions(driver);
      actions.doubleClick((WebElement) pageElement).build().perform();
    }
  }



  /////////////////////////////////////////////////////////////////



  // Single click using Actions class - Parameter Type - WebElement
  public void singleClickUsingActions(Object pageElement) {
    if (pageElement != null) {
      Actions actions = new Actions(driver);
      actions.click((WebElement) pageElement).build().perform();
    }
  }

  // Drop-down - Select By Visible Text
  public void dropdownSelectByVisibleText(Object pageElement, String title) {
    if (pageElement != null) {
      Select select = new Select((WebElement) pageElement);
      select.selectByVisibleText(title);
    }
  }

  // Drop-down - Get All Selected Options
  public List<WebElement> dropdownGetAllSelectedOptions(Object pageElement) {
    if (pageElement != null) {
      Select select = new Select((WebElement) pageElement);
      return select.getAllSelectedOptions();
    }
    return Collections.emptyList();
  }

  // Drop-down - Get First Selected Option
  public WebElement dropdownGetFirstSelectedOption(Object pageElement) {
    if (pageElement != null) {
      Select select = new Select((WebElement) pageElement);
      return select.getFirstSelectedOption();
    }
    return null;
  }

  // Right Click - Actions Class
  public void rightClickUsingActions(Object pageElement) {
    if (pageElement != null) {
      Actions actions = new Actions(driver);
      actions.contextClick((WebElement) pageElement).build().perform();
    }
  }

  public String getWindowHandle() {
    return driver.getWindowHandle();
  }

  public Set<String> getWindowHandles() {
    return driver.getWindowHandles();
  }

  public void switchToWindow(String winHandle) {
    driver.switchTo().window(winHandle);
  }

}
