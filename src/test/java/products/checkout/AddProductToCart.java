package products.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.reporter.CustomBaseTest;
import com.ridecell.pageobjects.ProductPage;
import com.ridecell.utils.RidecellConstants;

@Test(alwaysRun = true)
public class AddProductToCart extends CustomBaseTest {

  ProductPage productPage = null;

  public void testAddProductToCart() throws InterruptedException {

    productPage = testApp.getInstance(ProductPage.class);

    productPage.searchProduct(testApp);
    productPage.selectProductAndSwitchToNewWindow(testApp);
    productPage.addProductToCartAndViewCart(testApp);

    String deleteMessage = productPage.deleteProductFromCart(testApp);
    Assert.assertTrue(deleteMessage.contains(RidecellConstants.DELETE_SUCCESS_MESSAGE), "Success message does not match.");

  }

}
