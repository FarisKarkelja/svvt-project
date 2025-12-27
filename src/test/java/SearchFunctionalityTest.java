import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class SearchFunctionalityTest {
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
    public void testSearch() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).sendKeys("BMW" + Keys.ENTER);
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div/div[4]/div/div[3]/div/main/div[1]/a/div/div[2]/div[2]/div[1]/h1"));
        assertTrue(title.getText().contains("BMW"));
    }

    @Test
    public void testFiltering() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).sendKeys("BMW" + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[1]/div[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div[1]/div/div[2]/button[1]")).click();
        Thread.sleep(2000);

        WebElement state = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[4]/div/div[3]/div/main/div[1]/a/div/div[2]/div[2]/div[2]/span"));
        assertEquals("Novo", state.getText());
    }

    @Test
    public void testSorting() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/form/div/input")).sendKeys("BMW" + Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[3]/button[1]/div/span")).click();
        Thread.sleep(2000);

        WebElement kilometres = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[4]/div/div[3]/div/main/div[1]/a/div/div[2]/div[2]/div[2]/div/span[2]/div"));
        String numeric = kilometres.getText().replaceAll("[^0-9]", "");
        int priceValue = Integer.parseInt(numeric);
        assertTrue(priceValue <= 20000);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
