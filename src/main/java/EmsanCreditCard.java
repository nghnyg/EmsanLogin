import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class EmsanCreditCard {

    ChromeDriver driver;

    @Test
    public void creditCard() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\Firefox\\geckodriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.emsan.com.tr/");

        WebElement login = driver.findElement(By.xpath("//*[@id=\"underline-menu\"]/li[2]/a"));
        login.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"j_username\"]"));
        email.sendKeys("nagish03@gmail.com");

        WebElement password = driver.findElement(By.id("j_password"));
        password.sendKeys("123456");

        WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
        login_button.click();

        Thread.sleep(2000);

        WebElement kea = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div/ul/li[4]/a"));
        kea.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        WebElement kea_product = driver.findElement(By.xpath("//*[@id=\"list-page\"]/div[2]/div[3]/div[1]/div[2]/a/div[2]/img"));
        kea_product.click();

        WebElement addcart = driver.findElement(By.id("addcart"));
        addcart.click();

        Thread.sleep(2000);

        WebElement checkout = driver.findElement(By.xpath("//*[@id=\"addToCartModal\"]/div/div/div[3]/button"));
        checkout.click();

        WebElement checkout_btn = driver.findElement(By.xpath("//*[@id=\"checkout_cart\"]/div[5]/div/div[2]/a"));
        checkout_btn.click();

        WebElement submit = driver.findElement(By.xpath("//*[@id=\"checkout_checkout\"]/div[3]/div[1]/div/div/form[2]/div/div/button"));
        submit.click();

    }

}
