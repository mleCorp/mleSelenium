package com.mleselenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    @Test
    public void GoogleTest() {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().driverVersion("134.0.6998.35").setup();
        WebDriverManager.chromedriver().setup();

        // Add Headless Mode for GitHub Actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // Important for CI/CD environments
        options.addArguments("--no-sandbox"); // Recommended for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Prevent memory issues

        WebDriver driver = new ChromeDriver(options);

        // Navigate to Google
        driver.get("https://www.google.com");

        // Verify page title
        assertEquals("Google", driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
