package StepDefinitions;
import Pages.Login;
import Pages.Sport;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Steps extends BaseClass{

    @Before
    public void setup() throws IOException {
        setupDriver(driver);
    }

    @Given("User is on login page {string}")
    public void user_is_on_login_page(String string) {
        driver.get(string);
        login = new Login(driver);
        login.acceptCookie();
    }
    @When("User enters Username {string} and Password {string}")
    public void user_enters_username_pet_io_and_password(String username, String password) throws InterruptedException {
        login = new Login(driver);
        login.clickEntranceButton();
        login.login(username, password);
    }

    @Then("User is navigated to the home page")
    public void user_is_navigated_to_the_home_page() throws InterruptedException {
        login = new Login(driver);
        login.checkBallance();
    }

    @Then("Error message is displayed")
    public void error_message_is_displayed() {
        login = new Login(driver);
        login.checkErrorMessage();
    }

    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.get("https://winbet.bg/sports");
        login = new Login(driver);
        login.acceptCookie();
        login.clickEntranceButton();
        login.login("pet.io", "36L99mw5FcTYR82");
    }

    @When("Click on Favourites")
    public void click_on_favourites() throws InterruptedException {
        sport = new Sport(driver);
        sport.clickMyFavouriteLink();
    }

    @Then("Favourites page is displayed")
    public void favourites_page_is_displayed() {
        Sport sport = new Sport(driver);
        sport.checkIfMyFavouritesIsEmpty();
    }
}
