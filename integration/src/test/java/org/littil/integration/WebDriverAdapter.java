package org.littil.integration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WebDriverAdapter {

    public static final int DEFAULT_ELEMENT_FIND_TIMEOUT_SECONDS = 10;

    private WebDriver driver;

    private WebDriverAdapter() {
        driver = WebDriverManager.getInstance(DriverManagerType.CHROME).create();
    }

    public static WebDriverAdapter getinstance() {
        return new WebDriverAdapter();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigate(String url) {
        driver.navigate().to(url);
        waitUntil().until(ExpectedConditions.urlToBe(url));
    }

    public WebElement byId(String id) {
        return byId(id, 10);
    }

    public WebElement byId(String id, int timeout) {
        return waitUntil(timeout).until(d -> d.findElement(By.id(id)));
    }

    public FluentWait<WebDriver> waitUntil(int timeOutSecs) {
        return new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(timeOutSecs))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NoSuchElementException.class);
    }

    public FluentWait<WebDriver> waitUntil() {
        return waitUntil(DEFAULT_ELEMENT_FIND_TIMEOUT_SECONDS);
    }
}
