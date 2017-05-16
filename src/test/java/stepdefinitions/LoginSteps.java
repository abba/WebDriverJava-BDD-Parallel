package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageobjects.LoginPage;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;


/**
 * Created by zsuleiman on 04/02/2017.
 */
public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("^User Signin using \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void userSigninUserAndPassword(String username,String password){

        assertThat(loginPage.gotoSignInPage(), is(true));
        loginPage.userLoginWith(username,password);


    }

    @Then("^User Should Signin Successful$")
    public void successfulSignin(){
        assertThat(
                loginPage.signedInUser().
                        pageTitle(),
                not("Amazon Sign In"));


    }

    @Then("^Notification Message should be \"([^\"]*)\"$")
    public void messageShouldBeDisplayed(String message) throws Throwable {

            assertThat(loginPage.errorMessages(),
                hasItem(message));

    }


}
