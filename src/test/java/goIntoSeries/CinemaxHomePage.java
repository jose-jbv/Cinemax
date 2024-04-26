package goIntoSeries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Page Object class for Cinemax.com homepage.
 */
public class CinemaxHomePage {
    private WebDriver driver;

    // Locators
    private By viewMoreButton = By.cssSelector("div.hero-module-container-content div.hero-content a.hero-button");
    private By streamOn = By.cssSelector("div.hero-module-container-content div.hero-content div.hero-button-container");
    //private By viewMoreButton = By.id("viewMoreButton"); // Example locator, adjust based on actual application

    /**
     * Constructor for the goIntoSeries.CinemaxHomePage class.
     * @param driver WebDriver instance to interact with the page
     */
    public CinemaxHomePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method to click on the "View More" button.
     */
    public void clickViewMore() {
        WebElement viewMoreBtn = driver.findElement(viewMoreButton);
        viewMoreBtn.click();
    }

    /**
     * Method to verify if the "View More" button is present.
     * @return true if the button is present, false otherwise
     */
    public boolean isViewMorePresent() {
        return driver.findElements(viewMoreButton).size() > 0;
    }

    /**
     * Method to verify if the "View More" button is present.
     * @return true if the button is present, false otherwise
     */
    public boolean isStreamOnPresent() {
        return driver.findElements(streamOn).size() > 0;
    }

    /**
     * Method to click on the "View More" button.
     *
     * @return
     */
    public String streamOnHBO() {
        WebElement viewMoreBtn = driver.findElement(streamOn);
        return  viewMoreBtn.getText();
    }
}
