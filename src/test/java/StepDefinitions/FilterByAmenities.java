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

public class FilterByAmenities {
    WebDriver driver;

    @Given("^Open chrome and login with registred account 8$")
    public void Open_chrome_and_login_with_registred_account_8() throws Throwable {

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

    @When("^Select hotel, check in date, check out date then click search now 8$")
    public void Select_hotel_check_in_date_check_out_date_then_click_search_now_8() throws Throwable {


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

    @And("^Click on desired amenities on the amenities box$")
    public void Click_on_desired_amenities_on_the_amenities_box() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement filter_amenities= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[1]/div/div/span")));
        Assert.assertTrue(filter_amenities.isDisplayed());

        driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[2]/div[1]/div/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[2]/div[2]/div/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[2]/div[3]/div/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[2]/div[4]/div/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[2]/div[5]/div/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[2]/div[6]/div/span/input")).click();
        driver.findElement(By.xpath("//*[@id=\"filter_results\"]/div/div[2]/div[2]/div[7]/div/span/input")).click();

    }

    @Then("^user will see hotel amenities displayed based on amenities filter$")
    public void user_will_see_hotel_amenities_displayed_based_on_amenities_filter() throws Throwable {
        // failed because does not display any amenities
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement amenities = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"category_data_cont\"]/div")));
        Assert.assertTrue(amenities.isDisplayed());

        driver.quit();
    }
}
