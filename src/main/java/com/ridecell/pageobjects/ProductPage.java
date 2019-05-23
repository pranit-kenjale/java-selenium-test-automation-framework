package com.ridecell.pageobjects;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.framework.core.ITestContext;
import com.framework.core.TestApplication;
import com.framework.core.TestPage;
import com.ridecell.elementproviders.ProductPageElementProvider;
import com.ridecell.utils.PropertyReader;

public class ProductPage extends TestPage {

  ITestContext context;
  ProductPageElementProvider productPageElementProvider = null;
  Set<String> winHandlesSet = new HashSet<String>();
  List<String> allWindowHandlesList = new ArrayList<>();

  public ProductPage(ITestContext context) {
    super(context);
    this.context = context;
  }

  @Override
  public void intializeElementProvider() {
    productPageElementProvider = new ProductPageElementProvider(context);
  }


  public void searchProduct(TestApplication testApp) throws InterruptedException {
    // Search a product and press 'Enter' key
    context.enterTextIn(productPageElementProvider.searchTextBox(), PropertyReader.getProperty("productName") + Keys.ENTER);
    context.hardWait(3000);
  }


  public void selectProductAndSwitchToNewWindow(TestApplication testApp) throws InterruptedException {
    // Click on a product
    context.clickButton(productPageElementProvider.dellBattery());
    context.hardWait(3000);

    // Switch to the new window
    switchToNewWindow(testApp);
  }


  public void switchToNewWindow(TestApplication testApp) {

    winHandlesSet = context.getWindowHandles();

    // System.out.println("All Handles SET: " + winHandlesSet);
    allWindowHandlesList.addAll(winHandlesSet);

    // Switch to the 2nd window
    testApp.getTestContext().switchToWindow(allWindowHandlesList.get(1));
  }


  public void addProductToCartAndViewCart(TestApplication testApp) throws InterruptedException {
    // Click on a 'Add Product Tos Cart' button
    context.clickButton(productPageElementProvider.addToCartButton());
    context.hardWait(3000);

    // Click on a 'Cart' button
    context.clickButton(productPageElementProvider.cartButton());
    context.hardWait(3000);
  }


  public String deleteProductFromCart(TestApplication testApp) throws InterruptedException {
    // Click 'Delete' link under Product
    // String successMessage = context.getText(productPageElementProvider.deleteSuccessMessage());
    // System.out.println("Success Message -" + successMessage);

    context.clickButton(productPageElementProvider.deleteLinkDellBattery());

    List<WebElement> elements = productPageElementProvider.deleteSuccessMessage();

    int i = 0;
    for (WebElement e : elements) {
      System.out.println("Index = " + i + e.getText());
      System.out.println("Index = " + i + e.getAttribute("inneHTML"));
      i++;
    }

    context.hardWait(3000);
    return "";
  }

}
