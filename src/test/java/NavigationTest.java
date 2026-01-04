import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class NavigationTest {
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        baseUrl = "https://olx.ba/";
    }

    @BeforeEach
    public void beforeEachTest() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@id='disagree-btn']/span")).click();
        Thread.sleep(1000);
    }

    @Test
    public void testNavigationLinks() throws InterruptedException {
        driver.findElement(By.linkText("Početna")).click();
        Thread.sleep(1000);
        String currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/", currentUrl, "URLs don't match!");

        driver.findElement(By.linkText("Kategorije")).click();
        Thread.sleep(1000);
        currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/kategorije", currentUrl, "URLs don't match!");

        driver.findElement(By.linkText("Shopovi")).click();
        Thread.sleep(1000);
        currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/shopovi", currentUrl, "URLs don't match!");

        driver.findElement(By.linkText("Marketing")).click();
        Thread.sleep(2000);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String marketingUrl = driver.getCurrentUrl();
        assertTrue(marketingUrl.contains("marketing.olx.ba"));

        driver.get(baseUrl);
        Thread.sleep(2000);

        driver.findElement(By.linkText("Blog")).click();
        Thread.sleep(2000);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        String blogUrl = driver.getCurrentUrl();
        assertTrue(blogUrl.contains("blog.olx.ba"));

        driver.get(baseUrl);
        Thread.sleep(2000);
    }

    @Test
    public void testDropdownLinks() throws InterruptedException {
        String baseUrl = "https://olx.ba/";
        String currentUrl;

        WebElement dropdown = driver.findElement(By.xpath("//button[contains(text(),'Ostali linkovi')]"));
        dropdown.click();
        Thread.sleep(1000);

        WebElement supportLink = driver.findElement(By.linkText("Podrška korisnicima"));
        supportLink.click();
        Thread.sleep(2000);

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("pomoc.olx.ba"));

        if (driver.getWindowHandles().size() > 1) {
            driver.close();
            driver.switchTo().window(driver.getWindowHandles().iterator().next());
        }

        driver.get(baseUrl);
        Thread.sleep(1000);

        dropdown = driver.findElement(By.xpath("//button[contains(text(),'Ostali linkovi')]"));
        dropdown.click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("O nama")).click();
        Thread.sleep(1000);
        currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/o-olxu/o-nama", currentUrl, "URLs don't match!");

        driver.get(baseUrl);
        Thread.sleep(1000);

        dropdown = driver.findElement(By.xpath("//button[contains(text(),'Ostali linkovi')]"));
        dropdown.click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Uslovi korištenja")).click();
        Thread.sleep(1000);
        currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/o-olxu/uslovi-koristenja", currentUrl, "URLs don't match!");

        driver.get(baseUrl);
        Thread.sleep(1000);

        dropdown = driver.findElement(By.xpath("//button[contains(text(),'Ostali linkovi')]"));
        dropdown.click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("OLX kredit")).click();
        Thread.sleep(1000);
        currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/o-olxu/olxkredit", currentUrl, "URLs don't match!");

        driver.get(baseUrl);
        Thread.sleep(1000);

        dropdown = driver.findElement(By.xpath("//button[contains(text(),'Ostali linkovi')]"));
        dropdown.click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Online sigurnost")).click();
        Thread.sleep(1000);
        currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/o-olxu/online-sigurnost", currentUrl, "URLs don't match!");

        driver.get(baseUrl);
        Thread.sleep(1000);

        dropdown = driver.findElement(By.xpath("//button[contains(text(),'Ostali linkovi')]"));
        dropdown.click();
        Thread.sleep(1000);

        driver.findElement(By.linkText("Privatnost podataka")).click();
        Thread.sleep(1000);
        currentUrl = driver.getCurrentUrl();
        assertEquals("https://olx.ba/o-olxu/privatnost-podataka", currentUrl, "URLs don't match!");

        driver.get(baseUrl);
        Thread.sleep(1000);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
