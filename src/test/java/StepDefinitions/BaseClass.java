package StepDefinitions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;

    public void setupDriver(WebDriver remoteDriver)
    {
        driver = remoteDriver;
        //PageFactory.initElements(remoteDriver, this);
        //String projectPath = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/java/Drivers/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    }
}
