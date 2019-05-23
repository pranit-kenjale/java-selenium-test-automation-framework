package com.framework.core;

public abstract class TestPage {

  protected ITestContext testContext;

  public TestPage(ITestContext context) {
    this.testContext = context;
  }

  public abstract void intializeElementProvider();
}
