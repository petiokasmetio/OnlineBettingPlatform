package Pages;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sport {

    public WebDriver driver;

    public Sport(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public void clickMyFavouriteLink() throws InterruptedException {
        driver.findElement(By
                .xpath("//div[@class='mt-auto text-center nav-slider__text text-truncate' " +
                        "and text()='Любими']")).click();
    }

    public void checkIfMyFavouritesIsEmpty()
    {
        WebElement emptyMsg = driver.findElement(By.cssSelector(".search-msg__text"));
        String emptyMsgTxt = emptyMsg.getText();
        if (emptyMsgTxt.equals("Нямате любими събития")) {
            driver.quit();
            Assert.assertTrue(true);
        } else {
            driver.quit();
            Assert.fail();
        }
    }
}
