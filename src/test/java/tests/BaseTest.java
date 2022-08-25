package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected ProductPage productPage;

    protected CartPage cartPage;

    protected CheckoutCompletePage checkoutCompletePage;

    protected CheckoutStepOnePage checkoutStepOnePage;

    protected CheckoutStepTwoPage checkoutStepTwoPage;




    @BeforeClass
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);

    }

    @BeforeMethod
    public void navigate(){
        loginPage.open();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
