import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ListingManagementTest {
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
    public void testListingCreation() throws InterruptedException {
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
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/header/div/div[1]/div[2]/div/button/div/img")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div/div/div[2]/div/div/div[2]/div/div[1]/div/button[1]/div/p")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[2]/div[2]/div[2]/button[3]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/div/div[3]/div[2]/div[2]/button[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[6]/div/div/button[2]/div/p")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[2]/button[1]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[3]/div[2]/button[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[4]/div[2]/button[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/input")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[5]/div[2]/input")).sendKeys("160000");
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kubikaza = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[6]/div[2]/div")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", kubikaza);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(kubikaza)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kubikaza);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        kubikaza = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[6]/div[2]/div[2]/button[1]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", kubikaza);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(kubikaza)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kubikaza);
        }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement kw = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[7]/div[2]/input")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", kw);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(kw)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", kw);
        }

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[7]/div[2]/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[7]/div[2]/input")).sendKeys("84");
        Thread.sleep(1000);

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement doors = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//button[contains(., '4/5')]")
        ));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", doors);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(doors)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", doors);
        }

        driver.findElement(By.xpath("//button[contains(., 'Sljedeći korak')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/div/div[6]/div[1]/div/input")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/div/div[6]/div[1]/div/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[3]/div/div[6]/div[1]/div/input")).sendKeys("40000");
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[6]/div/div/button[2]/div/p")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[6]/div/div/button[2]/div/p")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/div[2]/div[1]/div[6]/div/div/button[2]")).click();
        Thread.sleep(7500);

        driver.get(baseUrl);
        Thread.sleep(2000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[1]/div[1]/div[2]/div/img[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("/html/body/div[1]/div/div/header/div/div[1]/div[3]/div[2]/div[2]/a[5]/span")).click();
        Thread.sleep(2000);

        WebElement title = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div/a[1]/div/div[2]/div[2]/div[1]/h1"));
        assertEquals("BMW 114 2025", title.getText());
    }

    @Test
    public void testListingEdit() throws InterruptedException {
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
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@aria-label='Moji oglasi']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@href, '/mojolx/artikli/neaktivni')]")).click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement listingCard = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1[contains(text(), 'BMW 114')]/ancestor::a[1]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", listingCard);
        Thread.sleep(500);

        actions.moveToElement(listingCard).build().perform();
        WebElement editBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[img[contains(@src, 'pencil-edit-button-new.svg')]]")
        ));

        try {
            editBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", editBtn);
        }

        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[span[contains(text(), 'KM')]]/input")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[span[contains(text(), 'KM')]]/input")).clear();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[span[contains(text(), 'KM')]]/input")).sendKeys("35000");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[contains(., 'Završi uređivanje')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@aria-label='Moji oglasi']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@href, '/mojolx/artikli/neaktivni')]")).click();
        Thread.sleep(2000);

        WebElement price = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[2]/div/a[1]/div/div[2]/div[2]/div[3]/div[1]/span"));
        assertTrue(price.getText().contains("35.000"));
    }

    @Test
    public void testListingDeletion() throws InterruptedException {
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
        Thread.sleep(5000);

        driver.findElement(By.xpath("//a[@aria-label='Moji oglasi']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(@href, '/mojolx/artikli/neaktivni')]")).click();
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement listingCard = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//h1[contains(text(), 'BMW 114')]/ancestor::a[1]")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", listingCard);
        Thread.sleep(500);
        actions.moveToElement(listingCard).build().perform();
        WebElement deleteBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[img[contains(@src, 'trash.svg')]]")
        ));

        try {
            deleteBtn.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteBtn);
        }

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div[2]/div[4]/div/div[2]/div[2]/div/div[2]/div[2]")).click();
        Thread.sleep(1000);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
