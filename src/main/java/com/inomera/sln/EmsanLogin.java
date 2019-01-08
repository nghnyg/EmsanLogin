import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EmsanLogin {

    ChromeDriver driver;

    WebElement kitchenProduct, product1, addcart, btn_checkout, submit;

    @Test
    public void doLogin() throws InterruptedException {

     System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver\\chromedriver.exe");
     DesiredCapabilities caps = new DesiredCapabilities();
     ChromeOptions opts = new ChromeOptions();
     caps.setCapability(ChromeOptions.CAPABILITY, opts);
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
     driver.manage().deleteAllCookies();

        driver.get("https://www.emsan.com.tr/");

        kitchenProduct = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/div/ul/li[2]/a"));
        kitchenProduct.click();
        Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("document.getElementsByClassName('strwimg str-ortaorta')[0].style.display='none'");
        Thread.sleep(2000);


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

        JavascriptExecutor js0 = (JavascriptExecutor) driver;
        js0.executeScript("window.scrollBy(0,2000)");
        Thread.sleep(3000);

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        WebElement email = driver.findElement(By.xpath("//*[@id=\"j_username\"]"));
        email.sendKeys("nagish03@gmail.com");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("j_password"));
        password.sendKeys("123456");

        WebElement login_button = driver.findElement(By.xpath("//*[@id=\"login\"]/button"));
        login_button.click();

        Thread.sleep(5000);

        WebElement payment_finish = driver.findElement(By.xpath("//*[@id=\"checkout_cart\"]/div[5]/div/div[2]/a"));
        payment_finish.click();

        WebElement checkout_adress = driver.findElement(By.xpath("//*[@id=\"checkout_checkout\"]/div[3]/div[1]/div/div/form[2]/div/div/button"));
        checkout_adress.click();

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.TAB).build().perform();
        WebElement eft = driver.findElement(By.xpath("//*[@id=\"krcOrderPostForm\"]/div[1]/div[1]/div[1]/div[1]/div/div/ul/li[2]"));
        eft.click();

        Thread.sleep(2000);
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)");


        WebElement orderpage = driver.findElement(By.id("checkoutProcess"));
        orderpage.click();

     Thread.sleep(5000);

     takeScreenShot();
     driver.close();

     //driver.get("https://gmail.com/");


    }

    public void takeScreenShot(){

     String yourfilepath = "C:\\Users\\nagihan\\Desktop\\emsan_screenshot\\test.png";

     File snapshort_file = driver.getScreenshotAs(OutputType.FILE);
     File DestFile=new File(yourfilepath);
     try {
      FileUtils.copyFile(snapshort_file, DestFile);
     } catch (IOException e) {
      e.printStackTrace();

        }
      }
    }
