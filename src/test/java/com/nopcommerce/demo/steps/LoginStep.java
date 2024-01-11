package com.nopcommerce.demo.steps;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStep {

    //This is feature branch
    @Given("I am on homepage")    //Don't write any code inside this because it is opening browser from Hook class
    public void iAmOnHomepage() {
        System.out.println("This is @Given");
    }

    @When("I click on login link")
    public void iClickOnLoginLink() {
//        System.out.println("This is @When");
        new HomePage().clickOnLoginLink();

    }

    @Then("I should navigate to login page successfully")
    public void iShouldNavigateToLoginPageSuccessfully() {

        //System.out.println("This is @Then");
        String expectedMessage="Welcome, Please Sign In!";
        String actualMessage=new LoginPage().getWelcomeText();
        Assert.assertEquals(actualMessage,expectedMessage,"Login page is not displayed");

    }

    @And("I enter email {string}")
    public void iEnterEmail(String email) {
        new LoginPage().enterEmailId(email);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        new LoginPage().enterPassword(password);
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        new LoginPage().clickOnLoginButton();
    }

    @Then("I should log in successfully")
    public void iShouldLogInSuccessfully() {
    }

    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String errorMessage) {
        Assert.assertEquals(new LoginPage().getErrorMessage(),errorMessage,"The error message not displayed");
    }
}
