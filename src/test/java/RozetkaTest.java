import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class RozetkaTest {

    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the window
        driver.manage().window().maximize();
        Thread.sleep(2500);
        // Navigate to the page
        driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class='exponea-close-cross']")).click();
        Thread.sleep(2000);

        // Get the page title and verify that it contains "Rozetka"
        String pageTitle = driver.getTitle();
//        Assert.assertTrue(pageTitle.contains("Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні"));
        // Check whether the page title contains "Rozetka"
        if (pageTitle.contains("Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Назва сторінки не містить 'Rozetka'");
        }

        Thread.sleep(1000);
        driver.quit();
    }
}
