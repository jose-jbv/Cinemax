package viewSeries;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Arrays;

public class SeriesHomePage {
    private WebDriver driver;

    //Locators
    private By progressBar = By.cssSelector("div.tui div.tui-control-bar div.tui-progress-bar div.tui-bar__active-progress");
    private By CSSplayVideo = By.cssSelector("div.tui div.tui__control-surface div.tui__slate div.tui-start-slate");

    public SeriesHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void playVideo()  {
        WebElement playWebVideo = driver.findElement(CSSplayVideo);
        playWebVideo.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isVideoPlaying(){
        WebElement isPlaying = driver.findElement(progressBar);
        String[] playerValue = isPlaying.getAttribute("style").split(":");
        String[] progressValue = playerValue[2].split("%");
        String[] progress = progressValue[0].split("\\.");
        Integer progressBarValue = Integer.parseInt(progress[0].replaceAll("\\s", ""));
        return progressBarValue > 0;
    }

}

