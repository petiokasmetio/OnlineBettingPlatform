package Pages;
import Utilities.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Sport {

    public WebDriver driver;
    WaitHelper waitHelper;

    public Sport(WebDriver remoteDriver) {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void clickMyFavouriteLink() throws InterruptedException {
        driver.findElement(By
                .xpath("//div[@class='mt-auto text-center nav-slider__text text-truncate' " +
                        "and text()='Любими']")).click();
    }

    public void checkIfMyFavouritesIsEmpty()
    {
        WebElement emptyMsg = driver.findElement(By.cssSelector(".search-msg__text"));
        waitHelper.WaitForElement(emptyMsg, 30);
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
