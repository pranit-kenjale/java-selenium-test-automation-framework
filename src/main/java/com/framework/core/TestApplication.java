package com.framework.core;

import java.lang.reflect.InvocationTargetException;

public class TestApplication {

  ITestContext testContext;

  public void setTestContext(ITestContext testContext) {
    this.testContext = testContext;
  }

  public ITestContext getTestContext() {
    return testContext;
  }

  public <T extends TestPage> T getInstance(Class<?> TestPage) {
    T page = null;

    try {
      page = (T) TestPage.getConstructor(ITestContext.class).newInstance(testContext);
      page.intializeElementProvider();
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return page;
  }

}
