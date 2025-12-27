import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class FormSubmissionTest {
    private static WebDriver driver;
    private static String baseUrl;

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Korisnik\\OneDrive\\Desktop\\ibu\\svvt\\chromedriver-win64\\chromedriver.exe");
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
    public void testVehicleForm() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[3]/div[1]/div/a[3]/div/img")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/ul/li[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[3]/ul/li[1]/ul/li[4]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/input[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/input[2]")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[1]/div/div[2]/input[2]")).sendKeys("400000");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/input[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/input[2]")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[2]/div/div[2]/input[2]")).sendKeys("20000");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[4]/div/div[2]/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[4]/div/div[3]/ul/li[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[4]/div/div[2]/div/div")).click();
        Thread.sleep(1000);

        Select year = new Select(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[5]/div/div[2]/select[2]")));
        year.selectByVisibleText("2025");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[6]/div/div[2]/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[6]/div/div[3]/ul/li[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div[2]/div[6]/div/div[2]/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/button")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/button[2]/div/span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[4]/div/div[3]/div/main/div[1]/a/div/div[2]/div[2]")).click();
        Thread.sleep(2000);

        WebElement price = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div/span"));
        String numeric = price.getText().replaceAll("[^0-9]", "");
        int priceValue = Integer.parseInt(numeric);
        assertTrue(priceValue <= 20000);
    }

    @Test
    public void testRealEstates() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/a[4]/div/img")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[1]/div/ul/li[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[4]/div/ul/li[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[5]/div/div[2]/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[5]/div/div[3]/ul/li[5]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[5]/div/div[2]/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[3]/div/ul/li[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[6]/div/div[2]/input[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[6]/div/div[2]/input[2]")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[6]/div/div[2]/input[2]")).sendKeys("120");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[7]/div/div[2]/input[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[7]/div/div[2]/input[2]")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[7]/div/div[2]/input[2]")).sendKeys("320000");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/button[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/button[2]/div/span")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[4]/div/div[3]/div/main/div[1]/a/div/div[2]/div[2]/div[1]/h1")).click();
        Thread.sleep(2000);

        WebElement price = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/div/div/span"));
        String numeric = price.getText().replaceAll("[^0-9]", "");
        int priceValue = Integer.parseInt(numeric);
        assertTrue(priceValue <= 320000);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
