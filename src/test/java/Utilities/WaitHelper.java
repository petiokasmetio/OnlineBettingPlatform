package Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitHelper {

    public WebDriver driver;

    public WaitHelper(WebDriver remoteDriver)
    {
        this.driver = remoteDriver;
    }

    public void WaitForElement(WebElement element, long timeOutInSeconds)
    {
        Duration duration = Duration.ofSeconds(timeOutInSeconds);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
