package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ValidLogin {
    WebDriver driver;

    @Given("^Open chrome and launch with valid account$")
    public void Open_chrome_and_launch_with_valid_account() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        Thread.sleep(1000);
    }

    @When("^Enter the username and password with valid account$")
    public void Enter_the_username_and_password_with_valid_account() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("jkl@mailinator.com");
        driver.findElement(By.id("passwd")).sendKeys("123@Password");
        Thread.sleep(1000);

    }

    @And("^Click login button with valid account$")
    public void Click_login_button_with_valid_account() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        Thread.sleep(1000);

    }
    @Then("^user will be directed to my account page$")
    public void A_new_account_is_registered() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Thread.sleep(1000);

       WebElement account = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/h1")));
        assertTrue(account.isDisplayed());

        Thread.sleep(1000);

        driver.quit();

    }

}
