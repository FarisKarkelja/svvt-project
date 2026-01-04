import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AboutUsTest {
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
    public void testHistory() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[6]/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[6]/div/div/a[2]")).click();
        Thread.sleep(1000);

        WebElement history = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/p[3]"));
        assertTrue(history.getText().contains("2006"));
    }

    @Test
    public void testTermsOfUse() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[6]/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[6]/div/div/a[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[3]/a")).click();
        Thread.sleep(1000);

        WebElement condition = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div/article/nav/ul/li[10]/a"));
        assertEquals("Član 10. Sudska nadležnost", condition.getText());
    }

    @Test
    public void testDataPrivacy() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[6]/button")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/header/div/div[1]/div[1]/div[1]/div[3]/ul/li[6]/div/div/a[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[1]/div/ul/li[5]/a")).click();
        Thread.sleep(1000);

        WebElement dataPrivacyInfo = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div/div/p[7]/strong"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dataPrivacyInfo);
        assertTrue(dataPrivacyInfo.isDisplayed());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
