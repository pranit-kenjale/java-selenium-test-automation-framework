package com.ridecell.elementproviders;

import java.util.List;
import org.openqa.selenium.WebElement;
import com.framework.core.ITestContext;
import com.framework.selenium.SeleniumElementProvider;

public class ProductPageElementProvider extends SeleniumElementProvider {

  public SeleniumElementProvider localElementProvider = null;

  public ProductPageElementProvider(ITestContext context) {
    super(context);
    localElementProvider = new SeleniumElementProvider(context);
  }

  // Search Text Box
  public Object searchTextBox() {
    return localElementProvider.getElementByID("twotabsearchtextbox");
  }

  // Product - Dell Battery
  public Object dellBattery() {
    return localElementProvider.getElementByXpath("//span[text()='Dell Latitude E6420 6Cell Battery (Black)']");
  }

  // Add to cart button
  public Object addToCartButton() {
    return localElementProvider.getElementByID("add-to-cart-button");
  }

  // Cart button
  public Object cartButton() {
    return localElementProvider.getElementByID("hlb-view-cart-announce");
  }

  // Delete Product Link - Dell Battery
  public Object deleteLinkDellBattery() {
    return localElementProvider.getElementByXpath("//input[@aria-label = 'Delete Dell Latitude E6420 6Cell Battery (Black)']");
  }

  // Delete Product Success Message
  public List<WebElement> deleteSuccessMessage() {
    return localElementProvider.getElementsByXpath("//div[contains(@class, 'sc-list-item-removed-msg a-padding-medium')]/div[@data-action='delete']/span/a");
  }

}
