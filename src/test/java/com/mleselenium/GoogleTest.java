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
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Required for GitHub Actions
        options.addArguments("--no-sandbox"); // Recommended for CI environments
        options.addArguments("--disable-dev-shm-usage"); // Prevents resource issues in CI
        
        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle());

        driver.quit();
    }
}
