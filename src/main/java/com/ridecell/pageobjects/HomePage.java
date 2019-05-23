package com.ridecell.pageobjects;

import com.framework.core.ITestContext;
import com.framework.core.TestApplication;
import com.framework.core.TestPage;

public class HomePage extends TestPage {

  ITestContext context;

  public HomePage(ITestContext context) {
    super(context);
    this.context = context;
  }

  @Override
  public void intializeElementProvider() {
    // TODO Auto-generated method stub

  }

  public String smokeTest(TestApplication testApp) {
    return context.getTitle();
  }


}
