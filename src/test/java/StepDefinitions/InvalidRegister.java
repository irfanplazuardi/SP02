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
import org.openqa.selenium.support.ui.WebDriverWait;

public class InvalidRegister {
    WebDriver driver;

    @Given("^Open the chrome and launch web with invalid input$")
    public void Open_the_chrome_and_launch_web_with_invalid_input() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        Thread.sleep(1000);
    }

    @When("^Input Email and click create account$")
    public void Input_Email_and_click_create_account() throws Throwable {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("email_create")).sendKeys("ko@mailinator.com");
        driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]/span")).click();
        Thread.sleep(1000);
    }

    @And("^fill in your personal information and click register with invalid input$")
    public void fill_in_your_personal_information_and_click_register_with_invalid_input() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement create_account = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"uniform-id_gender1\"]/span")));
        Assert.assertTrue(create_account.isDisplayed());
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"uniform-id_gender1\"]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("customer_firstname")).sendKeys("Irfan");
        Thread.sleep(1000);
        driver.findElement(By.id("customer_lastname")).sendKeys("8894");
        Thread.sleep(1000);
        driver.findElement(By.id("passwd")).sendKeys("123@Password");
        Thread.sleep(1000);
        driver.findElement(By.id("days")).sendKeys("4");
        Thread.sleep(1000);
        driver.findElement(By.id("months")).sendKeys("September");
        Thread.sleep(1000);
        driver.findElement(By.id("years")).sendKeys("1995");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"submitAccount\"]/span")).click();
        Thread.sleep(1000);


    }

    @Then("^user will see register account error$")
    public void user_will_see_register_account_error() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement error_registered = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div")));
        Assert.assertTrue(error_registered.isDisplayed());
        Thread.sleep(1000);


        driver.quit();
    }
}
