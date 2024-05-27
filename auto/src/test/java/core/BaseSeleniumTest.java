package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class BaseSeleniumTest {
    protected static WebDriver driver;

    @BeforeAll
    public static void setUp() {
//        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver",
                "E:\\AQA\\MavenJunit5\\auto\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        ChromeOptions options = new ChromeOptions();
//        options.setHeadless(true);
//        options.addArguments("--headles");
//        driver = new ChromeDriver(options);
        BaseSeleniumPage.setDriver(driver);

    }

    @AfterAll
    public static void tearDown() {
        //driver.close();
        driver.quit();
    }
}
