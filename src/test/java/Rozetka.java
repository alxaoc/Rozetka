import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class Rozetka {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

//        //Create prefs map to store all preferences
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        //Put this into prefs map to switch off browser notification
//        prefs.put("profile.default_content_setting_values.notifications", 2);
//        //Create chrome options to set this prefs
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        // Maximize the window
        driver.manage().window().maximize();

        // Navigate to the page
        driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@class='exponea-close-cross']")).click();
        Thread.sleep(2000);

    }

    public void home() {
    }
}