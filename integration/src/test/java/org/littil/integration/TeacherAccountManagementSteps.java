package org.littil.integration;

import com.google.common.collect.Sets;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class TeacherAccountManagementSteps implements En {

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

    public TeacherAccountManagementSteps(UserState scenarioState) {
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
        When("^their password (?:as|to) (.*?)$", (String pwd) -> {

        });
        When("^their post code (?:as|to) (\\d+)", (Integer int1) -> {

        });
        When("^their country as (.*?)$", (String country) -> {

            And("^their available days (?:as|to) (.*?)$", (String list) -> {
                var uniqueDays = Set.of(StringUtils.split(list, ","));
                for (String weekday : uniqueDays) {
                    switch (weekday.trim().toLowerCase()) {
                        case "monday":
                            break;
                        case "tuesday":
                            break;
                        case "wednesday":
                            break;
                        case "thursday":
                            break;
                        case "friday":
                            break;
                        default:
                            throw new IllegalStateException("Unknown day of the week: " + weekday);
                    }
                }
            });
            And("^their profile text (?:as|to) (.*?)$", (String preferences) -> {
            });

        });
        When("^indicates that they agree with the privacy statement", () -> {

        });
        When("^they confirm the registration", () -> {

        });
        Then("^they receive an email at (.*?) asking to activate their account", (String email) -> {

        });
        When("^they follow the activation instructions in the email", () -> {

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
        Then("^they can update their first name to (.*?) and surname to (.*?)$", (String firstName, String surname) -> {

        });

        And("^they receive a confirmation that the changes have been made", () -> {

        });
        And("^indicates that they want to delete their account", () -> {

        });
        And("^confirms their decision to delete", () -> {

        });
        And("^they receive email confirmation that the account has been deleted", () -> {
            String currentUser = state.getCurrentUser();
        });
        And("^they can no longer log in", () -> {
            String currentUser = state.getCurrentUser();
        });
        Then("^their account details are updated$", () -> {
        });

        And("^indicates they want to change their email$", () -> {
        });
        Then("^they can update their email to (.*?)$", (String email) -> {
        });
        And("^they receive an email at (.*?) confirming the change$", (String email) -> {
        });

    }



}
