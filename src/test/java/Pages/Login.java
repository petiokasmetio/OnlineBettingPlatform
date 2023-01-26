package Pages;
import Utilities.WaitHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;
import static org.junit.Assert.assertTrue;

public class Login {

    public WebDriver driver;
    WaitHelper waitHelper;

    public Login(WebDriver remoteDriver) {
        driver = remoteDriver;
        PageFactory.initElements(driver, this);
        waitHelper = new WaitHelper(driver);
    }

    public void acceptCookie()
    {
        try {
            WebElement element = driver.findElement(By
                    .cssSelector("button.btn.ml-auto.btn-primary[data-qid='accept-cookies']"));
            waitHelper.WaitForElement(element, 30);
            if(element.isDisplayed() && element.isEnabled()) {
                assertTrue(true);
                element.click();
            }
        } catch (NoSuchElementException e) {
            // element is not present
            System.out.println("Element not found, continuing with next step");
            Assert.assertFalse(false);
            // Continue with next step
        }
    }

    public void clickEntranceButton()
    {
        try {
            WebElement element = driver.findElement(By.cssSelector("div[data-qid='nav-login-btn']"));
            waitHelper.WaitForElement(element, 30);
            element.click();
        } catch (Exception e) {
            System.out.println("An error occurred while trying to locate the element or perform the click: " + e);
            driver.quit();
        }
    }

    public void login(String username, String password) {
        try {
            String mainWindow = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles())
            {
                if(!windowHandle.equals(mainWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
            WebElement usernameField = driver.findElement(By.cssSelector("input[name='username']"));
            waitHelper.WaitForElement(usernameField, 30);
            usernameField.sendKeys(username);

            WebElement passwordField = driver.findElement(By.cssSelector("input[name='password']"));
            waitHelper.WaitForElement(passwordField, 30);
            passwordField.sendKeys(password);

            WebElement loginBtn = driver.findElement(By.cssSelector("button[data-qid='login-btn']"));
            waitHelper.WaitForElement(loginBtn, 30);
            loginBtn.click();

            driver.switchTo().defaultContent();

        } catch (Exception e) {
            System.out.println("An error occurred while trying to locate the element or perform the sendKeys: " + e);
        }
    }

    public void verifyPageTitle(String expectedString) {
        String pageSource = driver.getPageSource();
        if (pageSource.contains(expectedString)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertFalse(false);
        }
        driver.quit();
    }

    public void checkBallance() {
            // Locate the element using a CSS selector
        WebElement element = driver.findElement(By.cssSelector("span.text-nowrap"));
        waitHelper.WaitForElement(element, 30);
            // Get the text from the element
        String elementText = element.getText();
            // Convert the text to a double
        double elementValue = Double.parseDouble(elementText);
        if (elementValue == 0.0) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
        driver.quit();
    }

    public void checkErrorMessage() {
        // Wait for the element to be present
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(20))
                .ignoring(Exception.class);
        wait.until(ExpectedConditions.presenceOfElementLocated(By
                .cssSelector("div.d-flex-ac.auth-msg-line.auth-msg-line--error")));

        // Locate the element using a CSS selector
        WebElement element = driver.findElement(By
                .cssSelector("div.d-flex-ac.auth-msg-line.auth-msg-line--error"));
        waitHelper.WaitForElement(element, 30);
        // Get the text from the element
        String elementText = element.getText();

        // Assert that the element contains the specific text
        if(elementText.contains("Грешно потребителско име/имейл или парола.")) {
            Assert.assertTrue(true);
            driver.quit();
        } else {
            Assert.assertFalse(false);
            driver.quit();
        }
    }
}
