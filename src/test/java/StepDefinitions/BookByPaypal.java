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

import static org.junit.Assert.assertTrue;

public class BookByPaypal {
    WebDriver driver;

    @Given("^Open chrome and login with registered account 3$")
    public void Open_chrome_and_login_with_registered_account_3() throws Throwable {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://qa.cilsy.id:8080/en/");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[7]/ul/li/a/span")).click();
        driver.findElement(By.id("email")).sendKeys("jkl@mailinator.com");
        driver.findElement(By.id("passwd")).sendKeys("123@Password");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Thread.sleep(1000);

        WebElement my_account = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li/a")));
        assertTrue(my_account.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/a")).click();
        Thread.sleep(1000);
    }

    @When("^Select hotel, check in date, check out date then click search now 3$")
    public void Select_hotel_check_in_date_check_out_date_then_click_search_now_3() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        Thread.sleep(1000);

        WebElement account = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("id_hotel_button")));
        assertTrue(account.isDisplayed());
        Thread.sleep(1000);
        driver.findElement(By.id("id_hotel_button")).click();
        driver.findElement(By.xpath("//*[@id=\"search_hotel_block_form\"]/div[2]/div/ul")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("check_in_time")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[5]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[7]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("search_room_submit")).click();
    }

    @And("^Book a room and proceed to checkout 3$")
    public void Book_a_room_and_proceed_to_checkout_3() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Thread.sleep(1000);

        WebElement order_room= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a")));
        Assert.assertTrue(order_room.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"category_data_cont\"]/div[1]/div/div[2]/a")).click();
        Thread.sleep(1000);

        WebElement room= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")));
        Assert.assertTrue(room.isDisplayed());
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();

    }
    @And("^Proceed for payment room with paypal$")
    public void Proceed_for_payment_room_with_paypal() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        Thread.sleep(1000);

        WebElement room_summary = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("shopping-cart-summary-head")));
        Assert.assertTrue(room_summary.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"collapse-shopping-cart\"]/div/div[2]/div[2]/div/a")).click();
        Thread.sleep(1000);

        WebElement guest_information = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"guest-info-head\"]/h5")));
        Assert.assertTrue(guest_information.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"collapse-guest-info\"]/div/div[4]/div/a")).click();
        Thread.sleep(1000);

        WebElement payment_agree = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("uniform-cgv")));
        Assert.assertTrue(payment_agree.isDisplayed());
        driver.findElement(By.id("uniform-cgv")).click();
        Thread.sleep(1000);

        WebElement payment_bank = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[3]/div/p/a")));
        Assert.assertTrue(payment_bank.isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[3]/div/p/a")).click();
        Thread.sleep(1000);


    }

    @Then("^Confirmation hotel room order is complete 3$")
    public void Confirmation_hotel_room_order_is_complete_3() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement order_complete= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"center_column\"]/div[1]")));
        Assert.assertTrue(order_complete.isDisplayed());

        Thread.sleep(1000);

        driver.quit();
    }
}
