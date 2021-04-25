package mk.ukim.finki.skithomework3.testSelenium;

import mk.ukim.finki.skithomework3.pages.LoginPage;
import mk.ukim.finki.skithomework3.pages.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }


    @Test
    public void shouldOpen() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
    }

    @Test
    public void canNotLoginWithInvalidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("selenium__testing", "invalid");
        String errorMessage = loginPage.getErrorMessage();
        System.out.println(errorMessage);
        assertEquals(errorMessage, "Incorrect username or password");

    }

    @Test
    public void canNotLoginWithEmptyUserName() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("", "empty");
        String errorMessage = loginPage.getErrorMessage();
        System.out.println(errorMessage);
        assertEquals(errorMessage, "");

    }

    @Test
    public void successfulLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        assertTrue(loginPage.isLoaded());
        loginPage.login("selenium-testing", "skit123");
        assertTrue(new ProductPage(driver).isLoaded());

    }

    private WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/Dell/Desktop/FINKI/6sesti semestar/skit/homework3/src/main/resources/drivers/chromedriver.exe");
        return new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

}
