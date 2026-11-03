package stepdefination;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    WebDriver driver;
    WebDriverWait wait;
    @Given("Goto the loginpage")
    public void goto_the_loginpage() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }
    @When("enter correct username and password")
    public void enter_correct_username_and_password() {
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin123");


    }
    @When("click on the login button")
    public void click_on_the_login_button() {
        driver.findElement(By.tagName("button")).click();


    }
    @Then("login successful")
   public void login_successful(){
        String loginpageurl=driver.getCurrentUrl();
        Assert.assertNotEquals(loginpageurl,"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


    }
    @Then("profile picture displayed")
    public void profile_picture_displayed() {
        System.out.println("displayed");


    }
}
