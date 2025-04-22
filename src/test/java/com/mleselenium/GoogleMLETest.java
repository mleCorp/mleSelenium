import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleMLETest {

    private WebDriver driver;

    @BeforeEach
        public void setUp() {
            WebDriverManager.chromedriver()
                .cachePath("~/.cache/selenium")
                .avoidBrowserDetection()  // <-- Enforces the cached version only
                .setup();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");        
            options.addArguments("--no-sandbox");      
            options.addArguments("--disable-dev-shm-usage"); 

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }


    @Test
    public void sampleTest() {
        driver.get("https://www.google.com");
        assertEquals("Google", driver.getTitle(), "Page title should be 'Google'");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}