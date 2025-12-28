import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportTest {
    static WebDriver driver;
    static String baseURL;
    static WebDriverWait wait;


    @BeforeAll
    public static void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        baseURL = "https://olx.ba/";
    }

    @BeforeEach
    public void beforeEachTest() throws InterruptedException {
        driver.get(baseURL);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement disagreeBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.id("disagree-btn")
        ));
        disagreeBtn.click();

        //log in
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
    }

    @Test
    void testReportListing() throws InterruptedException {
        //display all vehicles
        driver.findElement(By.xpath("//*[@id=\"sect--btn0\"]/div/img")).click();
        Thread.sleep(1000);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div[2]/div/div/div[2]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);

        //select absurd min power value
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[11]/div/div[1]")).click();
        WebElement minKw = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[11]/div/div[2]/div[2]/input[1]"));
        minKw.sendKeys("500");
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[11]/div/div[2]/button")).click();
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div[2]/div[2]/div[1]/button[1]")).click();


        //click and report first listing
        WebElement firstListing = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("div.cardd a")
        ));
        firstListing.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div[2]/div[2]/div/div[2]/div/button")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"Kršenje pravila\"]")).click();
        WebElement reason = driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/div[2]/div[3]/div[3]/div/div[2]/textarea"));
        //reason.click();
        Thread.sleep(1000);
        reason.sendKeys("Automobil nema preko 500 kW snage.");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"modals-container\"]/div/div/div[2]/div/div[2]/div[3]/div[3]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submitButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.v-toast__item")
        ));
        assertTrue(toast.getText().contains("Oglas uspješno prijavljen"),
                "Toast should display the expected error message");

    }

}
