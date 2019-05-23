package com.ridecell.elementproviders;

import com.framework.core.ITestContext;
import com.framework.selenium.SeleniumElementProvider;

public class LoginPageElementProvider extends SeleniumElementProvider {

  public SeleniumElementProvider localElementProvider = null;

  public LoginPageElementProvider(ITestContext context) {
    super(context);
    localElementProvider = new SeleniumElementProvider(context);
  }


  public Object signInLink() {
    // return localElementProvider.getElementByID("nav-link-yourAccounts");
    return localElementProvider.getElementByXpath("//span[text() = 'Hello, Sign in']");
  }

  public Object signInButton() {
    return localElementProvider.getElementByID("//span[text() = 'Sign in' and @class='nav-action-inner']");
  }

  public Object emailTextBox() {
    return localElementProvider.getElementByID("ap_email");
  }

  public Object continueButton() {
    return localElementProvider.getElementByID("continue");
  }

  public Object passwordTextBox() {
    return localElementProvider.getElementByID("ap_password");
  }

  public Object loginButton() {
    return localElementProvider.getElementByID("signInSubmit");
  }

}
