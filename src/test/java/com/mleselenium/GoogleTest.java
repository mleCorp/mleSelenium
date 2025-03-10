package com.mleselenium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    @Test
    public void testGoogleTitle() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to Google
        driver.get("https://www.google.com");

        // Verify page title
        assertEquals("Google", driver.getTitle());

        // Close the browser
        driver.quit();
    }
}