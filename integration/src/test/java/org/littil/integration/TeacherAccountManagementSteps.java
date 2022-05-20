package org.littil.integration;

import io.cucumber.java8.En;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.littil.integration.pages.RegistrationPage;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@Slf4j
public class TeacherAccountManagementSteps implements En {

    private UserState state;
    private final RegistrationPage page;
    WebDriverAdapter wd;

    public TeacherAccountManagementSteps(UserState scenarioState, RegistrationPage page) {
        this.state = scenarioState;
        this.page = page;

        Given("^user (.*?) is new to the platform", (String name) -> {
            assertThat(state.getCurrentUser()).isNull();
        });
        When("^(.*?) indicates they want to register as a teacher", (String name) -> {
            assertThat(state.getCurrentUser()).isNull();
            wd.getDriver().navigate().to("http://localhost:4200");
            page.goToPage();

        });
        Then("^they are presented with a registration form", page::assertFormIsPresent);

        When("^they give their first name as (.*?)$", page::enterFirstName);

        When("^their surname as (.*?)", page::enterSurname);

        When("^their email as (.*?)$", page::enterEmail);

        When("^their password (?:as|to) (.*?)$", (String pwd) -> {
            page.enterPassword(pwd);
            page.enterPasswordConfirmation(pwd);
        });

        When("^their post code (?:as|to) (\\d+)", page::enterPostcode);

        When("^their country as (.*?)$", page::enterCountry);

        And("^their profile text (?:as|to) (.*?)$", page::enterProfileText);

        And("^their available days (?:as|to) (.*?)$", (String list) -> {
            var uniqueDays = Set.of(StringUtils.split(list, ","));
            for (String weekday : uniqueDays) {
                page.selectAvailableDay(weekday);
            }
        });
        When("^indicates that they agree with the privacy statement", page::togglePrivacyStatement);

        When("^they confirm the registration", page::sendRegistration);

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
