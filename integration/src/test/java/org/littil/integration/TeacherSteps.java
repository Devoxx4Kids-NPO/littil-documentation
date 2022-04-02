package org.littil.integration;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class TeacherSteps implements En {

    private ScenarioState state;
    WebDriver webDriver;

    //@Before
    public void before(Scenario scenario) {
        webDriver = WebDriverAdapter.getDriver();
        scenario.log("Runs before each scenarios *not* tagged with @foo");
    }

    //@After
    public void after(Scenario scenario) {
        scenario.log("Runs after each scenario");
        if (webDriver != null) {
            webDriver.quit();
        }
    }

    public TeacherSteps(ScenarioState scenarioState) {
        this.state = scenarioState;

        Given("^user (.*?) is new to the platform", (String name) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^(.*?) indicates they want to register as a teacher", (String name) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        Then("^they are presented with a registration form", () -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^they give their first name as (.*?)$", (String firstName) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^their surname as (.*?)", (String surname) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^their email as (.*?)$", (String email) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^their password as (.*?)$", (String pwd) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^their post code as (\\d+)", (Integer int1) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^their country as (.*?)$", (String country) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^indicates that (?:he|she) agrees with the privacy statement", () -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^(?:he|she) confirms the registration", () -> {
            // Write code here that turns the phrase above into concrete actions

        });
        Then("^they receive an email at (.*?) asking to activate their account", (String email) -> {
            // Write code here that turns the phrase above into concrete actions

        });
        When("^(?:he|she) follows the activation instructions in the email", () -> {
            // Write code here that turns the phrase above into concrete actions

        });
        Then("^their account is activated", () -> {
            // Write code here that turns the phrase above into concrete actions

        });


        // Updates their profile data
        Given("^a user with email (.*?) is known to the platform", (String email) -> {
            state.setCurrentUser(email);
        });
        When("this user logs into the system", () -> {
            log.info("User: {}", state.getCurrentUser());
        });
        And("^indicates they want to change their profile", () -> {
        });
        Then("^they can update their first name to (.*?) and surname to (.*?)", (String firstName, String surname) -> {
        });
        And("update their password to (.*?)$", (String newPwd) -> {
        });
        And("update their post code to (\\d+)$", (String newPostcode) -> {
        });
        And("^they receive a confirmation that the changes have been made", () -> {
        });

        And("^indicates that they want to delete their account", () -> {
        });
        And("^confirms their decision", () -> {
        });
        And("^they receive email confirmation that the account has been deleted", () -> {
        });
        And("^they can no longer log in", () -> {
        });
    }



}
