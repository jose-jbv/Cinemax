package goIntoSeries;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Test class for user navigation on Cinemax.com.
 */
public class CinemaxNavigationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private CinemaxHomePage cinemaxHomePage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://www.cinemax.com");
        cinemaxHomePage = new CinemaxHomePage(driver);
    }

    @Test
    public void testUserCanNavigateAndViewMore() {
        Assert.assertTrue(cinemaxHomePage.isViewMorePresent(), "View More button should be present on the homepage.");
        cinemaxHomePage.clickViewMore();
        cinemaxHomePage.isStreamOnPresent();
        String text = cinemaxHomePage.streamOnHBO();
        Assert.assertEquals(text, "STREAM ON HBO MAX");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
