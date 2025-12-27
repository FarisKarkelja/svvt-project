import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessagingTest {
    static WebDriver driver;
    static String baseURL;
    static WebDriverWait wait;

    private static String generateRandomString32() {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(32);
        for (int i = 0; i < 32; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }


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
    void testBasicMessage() throws InterruptedException {
        //click on messages
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[1]/div[2]/a[2]")).click();
        Thread.sleep(2000);

        //click on the first chat
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div[1]")).click();

        String randomString = generateRandomString32();
        WebElement messageTextArea = driver.findElement(By.xpath("//*[@id=\"conversation-details-container\"]/div[3]/div/div/div/div/textarea"));
        messageTextArea.click();
        messageTextArea.sendKeys(randomString);
        driver.findElement(By.xpath("//*[@id=\"conversation-details-container\"]/div[3]/div/div/div/div/button")).click();

        //Locate the div with id=messageDisplay
        WebElement messageDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("messageDisplay")
        ));
        assertTrue(messageDisplay.getText().contains(randomString),
                "messageDisplay should contain the random string: " + randomString);

    }

    @Test
    void testMarkAsUnseen() throws InterruptedException {
        //click on messages
        driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[1]/div[2]/a[2]")).click();

        //click on the first chat
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstChat = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div[1]")
        ));
        firstChat.click();

        WebElement unseenBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"conversation-details-container\"]/div[1]/div[1]/div[2]/div/button[2]/img")
        ));
        unseenBtn.click();

        Thread.sleep(5000);

        //check if the chat color is now blue
        WebElement chatDiv = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[1]/div/div/div[1]/div/div[2]/div[2]/div/div[1]"));
        String chatColor = chatDiv.getCssValue("background-color");
        assertEquals("rgba(214, 230, 250, 1)", chatColor, "Chat color should be blue");
    }


    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
