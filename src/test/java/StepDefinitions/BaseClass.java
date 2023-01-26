package StepDefinitions;
import Pages.Login;
import Pages.Sport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public WebDriver driver;
    public Login login;
    public Sport sport;
    public Properties configProp;

    public void setupDriver(WebDriver remoteDriver) throws IOException {

        driver = remoteDriver;

        //PageFactory.initElements(remoteDriver, this);
        //String projectPath = System.getProperty("user.dir");
        //System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/java/Drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");

        configProp = new Properties();
        FileInputStream configPropFile = new FileInputStream("config.properties");
        configProp.load(configPropFile);

        String browser = configProp.getProperty("browser");

        if (browser.equals("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
        }
        else if (browser.equals("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("edge"))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }

    public static String randomStringGenerator()
    {
        return (RandomStringUtils.randomAlphabetic(10));
    }
}
