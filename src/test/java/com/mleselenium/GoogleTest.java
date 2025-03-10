package com.mleselenium;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleTest {

    @Test
    public void testGooglePageTitle() {  // Renamed method for clarity
        // Setup ChromeDriver with specific version
        WebDriverManager.chromedriver().driverVersion("134.0.6998.35").setup();

        // Add Headless Mode for GitHub Actions
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome"); // Force Chrome binary path
        options.addArguments("--headless");  
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-dev-shm-usage"); 

        WebDriver driver = new ChromeDriver(options);

        // Navigate to Google
        driver.get("https://www.google.com");

        // Verify page title
        assertEquals("Google", driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
