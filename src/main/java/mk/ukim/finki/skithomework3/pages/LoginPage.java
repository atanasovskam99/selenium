package mk.ukim.finki.skithomework3.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.reddit.com/login/");
    }

    public boolean isLoaded() throws InterruptedException {
        Thread.sleep(5000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginUsername"))).isDisplayed();

    }

    public void login(String user, String password) throws InterruptedException {
        driver.findElement(By.id("loginUsername")).clear();
        driver.findElement(By.id("loginUsername")).sendKeys(user);
        Thread.sleep(5000);
        driver.findElement(By.id("loginPassword")).sendKeys(password);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("[class=\"AnimatedForm__submitButton m-full-width\"]")).click();
        Thread.sleep(5000);


    }


    public String getErrorMessage() {
        WebElement errorPage = driver.findElement(By.cssSelector("div[class=\"AnimatedForm__errorMessage\"]"));
        return errorPage.getText();
    }
}

