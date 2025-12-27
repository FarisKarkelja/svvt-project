import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SessionHandlingTest {
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
    public void testSessionCookies() throws InterruptedException {
        driver.findElement(By.linkText("Prijavi se")).click();
        Thread.sleep(500);

        driver.findElement(By.name("username")).click();
        Thread.sleep(500);

        driver.findElement(By.name("username")).clear();
        Thread.sleep(500);

        driver.findElement(By.name("username")).sendKeys("fkarkelja149@gmail.com");
        Thread.sleep(500);

        driver.findElement(By.name("password")).click();
        Thread.sleep(500);

        driver.findElement(By.name("password")).clear();
        Thread.sleep(500);

        driver.findElement(By.name("password")).sendKeys("Faris!2004");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/button")).click();
        Thread.sleep(3000);

        WebElement accountName = driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[1]/div[2]/div/div/a"));
        assertEquals("FarisKarkelja", accountName.getText(), "Names aren't equal!");
        Thread.sleep(1000);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@id='disagree-btn']/span")).click();
        Thread.sleep(1000);

        WebElement loginButton = driver.findElement(By.linkText("Prijavi se"));
        assertTrue(loginButton.isDisplayed());
    }

    @Test
    public void testPersistentSession() throws InterruptedException {
        driver.findElement(By.linkText("Prijavi se")).click();
        Thread.sleep(500);

        driver.findElement(By.name("username")).click();
        Thread.sleep(500);

        driver.findElement(By.name("username")).clear();
        Thread.sleep(500);

        driver.findElement(By.name("username")).sendKeys("fkarkelja149@gmail.com");
        Thread.sleep(500);

        driver.findElement(By.name("password")).click();
        Thread.sleep(500);

        driver.findElement(By.name("password")).clear();
        Thread.sleep(500);

        driver.findElement(By.name("password")).sendKeys("Faris!2004");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/button")).click();
        Thread.sleep(3000);

        Set<Cookie> savedCookies = driver.manage().getCookies();
        driver.quit();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get(baseUrl);
        Thread.sleep(1000);

        try {
            driver.findElement(By.xpath("//button[@id='disagree-btn']/span")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Cookie cookie : savedCookies) {
            driver.manage().addCookie(cookie);
        }

        driver.navigate().refresh();
        Thread.sleep(3000);

        WebElement myProfile = driver.findElement(By.cssSelector("a[href='/profil/FarisKarkelja/aktivni']"));
        assertTrue(myProfile.isDisplayed());
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
