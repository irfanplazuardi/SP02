package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLogin {
    WebDriver driver;

    @Given("^Open chrome and launch with invalid account$")
    public void Open_chrome_and_launch_with_invalid_account() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        Thread.sleep(1000);
    }

    @When("^Input incorrect email and password$")
    public void Input_incorrect_email_and_password() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email")).sendKeys("irfanplazuardi@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("123Password");
        Thread.sleep(1000);

    }

    @And("^Click login Button with invalid account$")
    public void Click_login_button_with_invalid_account() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        Thread.sleep(1000);

    }

    @Then("^user will see pop up error$")
    public void user_will_see_pop_up_error() throws Throwable {

        String error = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/p[1]")).getText();
        Assert.assertTrue("There is 1 error", error.contains("There is 1 error"));

        Thread.sleep(1000);

        driver.quit();
    }
}
