package StepDefinitions;
import Pages.Login;
import Pages.Sport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseClass{

    @Before
    public void setup()
    {
        setupDriver(driver);
    }

    @Given("User is on login page {string}")
    public void user_is_on_login_page(String string) {
        driver.get(string);
        Login l = new Login(driver);
        l.acceptCookie();
    }
    @When("User enters Username {string} and Password {string}")
    public void user_enters_username_pet_io_and_password(String username, String password) throws InterruptedException {
        Login l = new Login(driver);
        l.clickEntranceButton();
        l.login(username, password);
    }

    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {
        Login l = new Login(driver);
        l.checkBallance();
    }

    @Then("Error message is displayed")
    public void error_message_is_displayed() {
        Login l = new Login(driver);
        l.checkErrorMessage();
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get("https://winbet.bg/sports");
        Login l = new Login(driver);
        l.acceptCookie();
        l.clickEntranceButton();
        l.login("pet.io", "36L99mw5FcTYR82");
    }

    @When("Click on Favourites")
    public void click_on_favourites() throws InterruptedException {
        Sport sport = new Sport(driver);
        sport.clickMyFavouriteLink();
    }

    @Then("Favourites page is displayed")
    public void favourites_page_is_displayed() {
        Sport sport = new Sport(driver);
        sport.checkIfMyFavouritesIsEmpty();
    }
}
