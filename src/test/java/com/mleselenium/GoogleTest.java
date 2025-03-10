package com.mleselenium;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    @Test
    public void testGoogleTitle() {
        WebDriverManager.chromedriver().driverVersion("133.0.6943.141").setup();
        WebDriver driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");        // Essential for CI/CD (No UI)
        options.addArguments("--no-sandbox");      // Prevents permission issues
        options.addArguments("--disable-dev-shm-usage");  // Prevents memory issues
        options.addArguments("--remote-allow-origins=*"); // Solves Chrome security issues

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());

        driver.quit();
    }
}
