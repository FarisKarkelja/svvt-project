import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class UserAuthenticationTest {
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
    public void createNewUser() throws InterruptedException {
        driver.findElement(By.linkText("Registracija")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='text']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='text']")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nedimdzebotvbox@gmail.com");
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Neda123");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input"))
                .sendKeys("odhaoefeofhaoefhoeafhaoefh");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[4]/select")).click();
        Thread.sleep(500);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[4]/select")))
                .selectByVisibleText("Muški");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div[2]/select")).click();
        Thread.sleep(1000);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div[2]/select")))
                .selectByVisibleText("Kanton Sarajevo");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div/h2")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div[2]/select")).click();
        Thread.sleep(1000);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div[2]/select")))
                .selectByVisibleText("Ilidža");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div/h2")).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkboxLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"checkbox\"]")
        ));

        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkboxLabel).click().perform();
        Thread.sleep(1000);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#__layout > div > div.w-full.register-wrap.relative.z-2 > div.form-wrapper.relative.m-auto.flex.flex-col.justify-center.items-center.py-md.rounded-sm.sm\\:w-full.px-md > div.flex.flex-col.w-full > div > div > button")
        ));

        actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();
        Thread.sleep(1000);
    }

    @Test
    public void testAlreadyExistingMail() throws InterruptedException {
        driver.findElement(By.linkText("Registracija")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='text']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='text']")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("fkarkelja149@gmail.com");
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pass!!123");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input"))
                .sendKeys("eofhaoefafco");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[4]/select")).click();
        Thread.sleep(500);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[4]/select")))
                .selectByVisibleText("Muški");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div[2]/select")).click();
        Thread.sleep(1000);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div[2]/select")))
                .selectByVisibleText("Kanton Sarajevo");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div/h2")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div[2]/select")).click();
        Thread.sleep(1000);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div[2]/select")))
                .selectByVisibleText("Ilidža");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div/h2")).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkboxLabel = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"checkbox\"]")
        ));

        Thread.sleep(500);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkboxLabel).click().perform();
        Thread.sleep(1000);

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#__layout > div > div.w-full.register-wrap.relative.z-2 > div.form-wrapper.relative.m-auto.flex.flex-col.justify-center.items-center.py-md.rounded-sm.sm\\:w-full.px-md > div.flex.flex-col.w-full > div > div > button")
        ));

        actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();
        Thread.sleep(4000);

        WebElement toastrError = driver.findElement(By.cssSelector("body > div.v-toast.v-toast--top > div > p"));
        Thread.sleep(2000);
        assertEquals("Email adresa je zauzeta", toastrError.getText(), "Error messages aren't equal!");
    }

    @Test
    public void testNotAcceptingCheckbox() throws InterruptedException {
        driver.findElement(By.linkText("Registracija")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@type='text']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='text']")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("nedimdzebotvbox@gmail.com");
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Pass!!123");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input")).click();
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input")).clear();
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[3]/div/input"))
                .sendKeys("laolaolao");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[4]/select")).click();
        Thread.sleep(500);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[4]/select")))
                .selectByVisibleText("Muški");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div[2]/select")).click();
        Thread.sleep(1000);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div[2]/select")))
                .selectByVisibleText("Kanton Sarajevo");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div/div/h2")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div[2]/select")).click();
        Thread.sleep(1000);

        new Select(driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div[2]/select")))
                .selectByVisibleText("Ilidža");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/div/div/div[5]/div[2]/div/div/h2")).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("#__layout > div > div.w-full.register-wrap.relative.z-2 > div.form-wrapper.relative.m-auto.flex.flex-col.justify-center.items-center.py-md.rounded-sm.sm\\:w-full.px-md > div.flex.flex-col.w-full > div > div > button")
        ));

        Actions actions = new Actions(driver);
        actions.moveToElement(submitButton).click().perform();
        Thread.sleep(4000);

        WebElement toastrError = driver.findElement(By.cssSelector("body > div.v-toast.v-toast--top > div > p"));
        Thread.sleep(2000);
        assertEquals("Polje uslovi korištenja mora biti prihvaćeno", toastrError.getText(), "Error messages aren't equal!");
    }

    @Test
    public void testLoginWithValidCredentials() throws InterruptedException {
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

        WebElement accountName = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/header/div/div[1]/div[1]/div[2]/div[2]/a/p"));
        assertEquals("FarisKarkelja", accountName.getText(), "Names aren't equal!");
    }

    @Test
    public void testLoginWithInvalidCredentials() throws InterruptedException {
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

        driver.findElement(By.name("password")).sendKeys("wrongpassword");
        Thread.sleep(500);

        driver.findElement(By.xpath("//div[@id='__layout']/div/div[2]/div[2]/div/button")).click();
        Thread.sleep(2000);

        WebElement toastrError = driver.findElement(By.cssSelector("body > div.v-toast.v-toast--top > div > p"));
        assertEquals("Podaci nisu tačni.", toastrError.getText(), "Error messages aren't equal!");
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
