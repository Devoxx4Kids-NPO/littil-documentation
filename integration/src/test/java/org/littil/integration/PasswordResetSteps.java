package org.littil.integration;

import io.cucumber.java8.En;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordResetSteps implements En {

    public PasswordResetSteps() {

        When("^this user indicates they have forgotten their password$", () -> {
        });
        Then("^they can enter their email as (.*?)$", (String email) -> {
        });
        And("^they receive an email at (.*?) with a link to a password page$", (String email) -> {
        });
        When("^they follow the link to the password reset page$", () -> {
        });
        Then("^they can enter a new password as (.*?)$", (String password) -> {
        });

    }


}
