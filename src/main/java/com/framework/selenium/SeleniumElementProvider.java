package com.framework.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import com.framework.core.ITestContext;

public class SeleniumElementProvider {

  public SeleniumTestContext seleniumContext;

  public SeleniumElementProvider(ITestContext context) {
    seleniumContext = (SeleniumTestContext) context;
  }

  public Object getElementByID(String id) {
    try {
      return seleniumContext.getDriver().findElement(By.id(id));
    } catch (NoSuchElementException e) {
      return null;
    }

  }

  public Object getElementByName(String name) {
    try {
      return seleniumContext.getDriver().findElement(By.name(name));
    } catch (NoSuchElementException e) {
      return null;
    }

  }

  public WebElement getElementByXpath(String xpath) {
    try {
      return seleniumContext.getDriver().findElement(By.xpath(xpath));
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  public List<WebElement> getElementsByXpath(String xpath) {
    return seleniumContext.getDriver().findElements(By.xpath(xpath));
  }

  public Object getElementByClass(String className) {
    try {
      return seleniumContext.getDriver().findElement(By.className(className));
    } catch (NoSuchElementException e) {
      return null;
    }

  }

  public WebElement getElementByCss(String cssSelector) {
    try {
      return seleniumContext.getDriver().findElement(By.cssSelector(cssSelector));
    } catch (NoSuchElementException e) {
      return null;
    }

  }


  public Object getElementByPartialText(String text) {
    try {
      return seleniumContext.getDriver().findElement(By.partialLinkText(text));
    } catch (NoSuchElementException e) {
      return null;
    }
  }
}
