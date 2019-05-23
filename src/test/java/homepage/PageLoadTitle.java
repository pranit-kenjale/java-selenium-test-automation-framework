package homepage;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.framework.reporter.CustomBaseTest;
import com.ridecell.pageobjects.HomePage;

@Test
public class PageLoadTitle extends CustomBaseTest {

  HomePage homePage = null;

  public void testPageTitle() {

    homePage = testApp.getInstance(HomePage.class);

    String pageTitle = homePage.smokeTest(testApp);
    Assert.assertTrue(pageTitle.endsWith("Amazon.in"), "Title does not match.");


  }


}
