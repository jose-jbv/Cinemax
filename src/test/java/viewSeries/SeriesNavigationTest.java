package viewSeries;

import goIntoSeries.CinemaxHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeriesNavigationTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private SeriesHomePage seriesHomePage;
    private CinemaxHomePage cinemaxHomePage;

    @BeforeMethod
    public void setUp() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("http://www.cinemax.com");
        seriesHomePage = new SeriesHomePage(driver);
        cinemaxHomePage = new CinemaxHomePage(driver);
    }

    @Test
    public void playVideo() {
        cinemaxHomePage.isViewMorePresent();
        cinemaxHomePage.clickViewMore();
        cinemaxHomePage.isStreamOnPresent();
        seriesHomePage.playVideo();
        seriesHomePage.isVideoPlaying();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
