package org.littil.integration;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class WebDriverAdapter {

    public static WebDriverManager getDriverManager() {
        return WebDriverManager.getInstance(DriverManagerType.CHROME);
    }

    public static WebDriver getDriver(){
        WebDriver driver = getDriverManager().getWebDriver();
        return driver;
    }

}
