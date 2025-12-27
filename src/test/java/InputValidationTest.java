import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class InputValidationTest {
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
    public void beforeEachTest() {
        driver.get(baseUrl);
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disagreeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("disagree-btn")
        ));
        disagreeBtn.click();
    }

    @Test
    void testEmailValidation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement regLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Registracija")));
        regLink.click();

        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
        emailInput.clear();
        emailInput.sendKeys("verybadmail.gmail.com");

        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id='__layout']/div/div[2]/div[2]/div[1]/div/div/button")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        }

        WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='__layout']/div/div[2]/div[2]/div[1]/div/div/div[1]/div/small")
        ));
        assertEquals("Polje email mora biti validna e-mail addressa.", warning.getText());
    }

    @Test
    void testPoorPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement regLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Registracija")));
        regLink.click();

        WebElement passInput = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/input"));
        passInput.sendKeys("a");

        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id='__layout']/div/div[2]/div[2]/div[1]/div/div/button")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);

        try {
            wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        }

        WebElement warning = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div[1]/div/div/div[2]/div/small")
        ));
        assertTrue(warning.getText().contains("Šifra treba da sadrži veliko slovo, malo slovo, broj, znak i mora biti minimalno 8 karaktera"));
    }

    @Test
    void testGarbageSearch() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[2]/form/div[1]/input"));
        search.sendKeys("@@@####");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        WebElement h1 = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[4]/div/div[3]/div/div[2]/div/h1"));
        assertTrue(h1.getText().contains("Nema rezultata"));
    }

    @Test
    void testEmptySearch() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[2]/form/div[1]/input"));
        search.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Nema rezultata za traženi pojam"));
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}