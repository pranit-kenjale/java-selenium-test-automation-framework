package com.framework.core;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ITestContext {

  WebDriver getDriver();

  void get(String url);

  void enterTextIn(Object pageElement, String text);

  void clickButton(Object pageElement);

  String getText(Object pageElement);

  String getValue(Object pageElement);

  String getTitle();

  boolean isEnabled(Object pageElement);

  void clearAndReplace(Object pageElement, String text);

  String getAttribute(Object pageElement, String attribute);

  void takeScreenShot(String pageTitle);

  boolean isDisplayed(Object pageElement);

  boolean doesElementExist(Object pageElement);

  void hardWait(long waitTime);

  void mouseHoverUsingActions(Object pageElement);

  void mouseHoldAndHoverUsingActions(Object pageElement);

  void doubleClickUsingActions(Object pageElement);

  void singleClickUsingActions(Object pageElement);

  void rightClickUsingActions(Object pageElement);

  // Drop-down methods
  void dropdownSelectByVisibleText(Object pageElement, String title);

  List<WebElement> dropdownGetAllSelectedOptions(Object pageElement);

  WebElement dropdownGetFirstSelectedOption(Object pageElement);


  String getWindowHandle();

  Set<String> getWindowHandles();

  void switchToWindow(String winHandle);
}
