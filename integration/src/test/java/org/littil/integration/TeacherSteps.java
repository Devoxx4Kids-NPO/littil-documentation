package org.littil.integration;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class TeacherSteps implements En {

    private UserState state;
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

    public TeacherSteps(UserState scenarioState) {
        this.state = scenarioState;

        Given("^user (.*?) is new to the platform", (String name) -> {
            assertThat(state.getCurrentUser()).isNull();
        });
        When("^(.*?) indicates they want to register as a teacher", (String name) -> {
            assertThat(state.getCurrentUser()).isNull();
        });
        Then("^they are presented with a registration form", () -> {
        });
        When("^they give their first name as (.*?)$", (String firstName) -> {

        });
        When("^their surname as (.*?)", (String surname) -> {

        });
        When("^their email as (.*?)$", (String email) -> {

        });
        When("^their password as (.*?)$", (String pwd) -> {

        });
        When("^their post code as (\\d+)", (Integer int1) -> {

        });
        When("^their country as (.*?)$", (String country) -> {

        });
        When("^indicates that (?:he|she) agrees with the privacy statement", () -> {

        });
        When("^(?:he|she) confirms the registration", () -> {

        });
        Then("^they receive an email at (.*?) asking to activate their account", (String email) -> {

        });
        When("^(?:he|she) follows the activation instructions in the email", () -> {

        });
        Then("^their account is activated", () -> {

        });


        // Updates their profile data
        Given("^a user with email (.*?) is known to the platform", (String email) -> {
            state.addUserByEmail(email);
        });
        When("this user logs into the system", () -> {
            String currentUser = state.getCurrentUser();
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
            String currentUser = state.getCurrentUser();
        });
        And("^they can no longer log in", () -> {
            String currentUser = state.getCurrentUser();
        });
    }



}
