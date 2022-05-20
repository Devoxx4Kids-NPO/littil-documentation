package org.littil.integration.pages;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.littil.integration.WebDriverAdapter;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage {

    WebDriverAdapter wd;
    @Before
    public void before(Scenario scenario) {
        wd = WebDriverAdapter.getinstance();
        scenario.log("Runs before each scenarios *not* tagged with @foo");
    }

    @After
    public void after(Scenario scenario) {
        scenario.log("Runs after each scenario");
        if (wd != null) {
            wd.getDriver().quit();
        }
    }

    public void goToPage() {
        wd.byId("registerTeacherLink").click();
    }

    public void assertFormIsPresent() {
        wd.waitUntil().until(d -> ExpectedConditions.urlContains("register-teacher"));
    }

    public void enterFirstName(String firstName) {
        wd.byId("firstName").sendKeys(firstName);
    }

    public void enterSurname(String surname) {
        wd.byId("surname").sendKeys(surname);
    }

    public void enterEmail(String email) {
        wd.byId("email").sendKeys(email);
    }

    public void enterPassword(String pwd) {
        wd.byId("password").sendKeys(pwd);
    }

    public void enterPasswordConfirmation(String pwd) {
        wd.byId("password_repeat").sendKeys(pwd);
    }

    public void enterPostcode(Integer postcode) {
        wd.byId("postalCode").sendKeys(Integer.toString(postcode));
    }

    public void enterCountry(String country) {

    }

    public void enterProfileText(String profileText) {

    }

    public void selectAvailableDay(String weekday) {
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

    public void togglePrivacyStatement() {
        wd.byId("privacy").click();
    }

    public void sendRegistration() {
        wd.byId("register-teacher").click();
    }
}
