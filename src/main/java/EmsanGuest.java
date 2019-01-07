import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class EmsanGuest {

    private WebDriver driver;
    WebElement kitchenProduct, product1, addcart, btn_checkout, submit, email;

    @Test

    public void doGuest() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions opts = new ChromeOptions();
        caps.setCapability(ChromeOptions.CAPABILITY, opts);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();

        driver.get("https://www.emsan.com.tr/");
        Thread.sleep(5000);

        kitchenProduct = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div/ul/li[2]/a"));
        kitchenProduct.click();

        Thread.sleep(2000);

        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('strwimg str-ortaorta')[0].style.display='none'");

        Thread.sleep(5000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(3000);


        product1 = driver.findElement(By.xpath("//*[@id=\"list-page\"]/div[2]/div[3]/div[1]/div[2]/a"));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", product1);

        Thread.sleep(3000);

        addcart = driver.findElement(By.xpath("//*[@id=\"addcart\"]"));
        addcart.click();

        Thread.sleep(5000);

        btn_checkout = driver.findElement(By.xpath("//*[@id=\"addToCartModal\"]/div/div/div[3]/button"));
        btn_checkout.click();

        submit = driver.findElement(By.xpath("//*[@id=\"checkout_cart\"]/div[5]/div[1]/div[2]/a"));
        submit.click();

        Thread.sleep(3000);

       /* Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"email\"]")));
        //actions.click();
        actions.sendKeys("nagish03@gmail.com"); */


      /* WebElement email = driver.findElement(By.xpath("//*[@id=\"guestboxForm\"]/div[1]/div[1]"));
       email.click();
       email.sendKeys("nagish03@gmail.com"); */

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"guestboxForm\"]/div[1]/div[2]"))).click();

        Thread.sleep(5000);

        //WebElement email_guest = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        //email_guest.sendKeys("nagish03@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"guestboxForm\"]/div[1]/div[2]/button")).click();
        Thread.sleep(2000);
        email =  driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("nagihan.yapici@inomera.com");
        driver.findElement(By.xpath("//*[@id=\"guestboxForm\"]/div[1]/div[2]/button")).click();

    }

}
