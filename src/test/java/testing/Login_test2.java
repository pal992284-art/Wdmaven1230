package testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_test2 {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get(
                "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
        );
    }

    @Test
    public void login() {

        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[name='username']")
                )
        );

        username.sendKeys("Admin");

        WebElement password = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("input[name='password']")
                )
        );

        password.sendKeys("admin123");

        WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.cssSelector("button[type='submit']")
                )
        );

        loginButton.click();
    }

    @AfterClass
    public void user_logout() {

        if (driver != null) {
            driver.quit();
        }
    }
}
