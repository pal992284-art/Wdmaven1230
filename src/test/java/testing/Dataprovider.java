package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Dataprovider {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    @Parameters({"browser", "url"})
    public void browser_setup(String browser, String url) {

        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else {
            throw new IllegalArgumentException("Invalid browser: " + browser);
        }

        driver.manage().window().maximize();
        driver.get(url);

        // Explicit wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test(dataProvider = "logindata")
    public void enter_login_credentials(String username, String password) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("username"))
        ).sendKeys(username);

        driver.findElement(By.name("password")).sendKeys(password);

        driver.findElement(By.tagName("button")).click();
    }

    @org.testng.annotations.DataProvider(name = "logindata")
    public Object[][] loginData() {

        return new Object[][]{
                {"user1", "password1"},
                {"user2", "password2"},
                {"user3", "password3"}
        };
    }
}
