package com.ridecell.pageobjects;

import com.framework.core.ITestContext;
import com.framework.core.TestApplication;
import com.framework.core.TestPage;
import com.ridecell.elementproviders.LoginPageElementProvider;
import com.ridecell.utils.PropertyReader;

public class LoginPage extends TestPage {

  ITestContext context;
  LoginPageElementProvider loginPageElementProvider = null;

  public LoginPage(ITestContext context) {
    super(context);
    this.context = context;
  }

  @Override
  public void intializeElementProvider() {
    loginPageElementProvider = new LoginPageElementProvider(context);
  }


  public void loginToSite(TestApplication testApp) throws InterruptedException {

    context.hardWait(2000);
    context.clickButton(loginPageElementProvider.signInLink());
    context.clickButton(loginPageElementProvider.signInLink());

    // context.mouseHoverUsingActions(loginPageElementProvider.signInLink());
    // context.doubleClickUsingActions(loginPageElementProvider.signInButton());
    // context.clickButton(loginPageElementProvider.signInLink());
    context.hardWait(3000);

    context.enterTextIn(loginPageElementProvider.emailTextBox(), PropertyReader.getProperty("email"));
    context.clickButton(loginPageElementProvider.continueButton());

    context.hardWait(3000);

    context.enterTextIn(loginPageElementProvider.passwordTextBox(), PropertyReader.getProperty("password"));
    context.clickButton(loginPageElementProvider.loginButton());

  }


}
