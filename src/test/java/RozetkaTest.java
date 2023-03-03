import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RozetkaTest {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        //Create prefs map to store all preferences
        Map<String, Object> prefs = new HashMap<String, Object>();
        //Put this into prefs map to switch off browser notification
        prefs.put("profile.default_content_setting_values.notifications", 2);
        //Create chrome options to set this prefs
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        // Maximize the window
        driver.manage().window().maximize();

        // Navigate to the page
        driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@class='exponea-close-cross']")).click();
        Thread.sleep(2000);

        // Get the page title and verify that it contains "Rozetka"
        String pageTitle = driver.getTitle();

        // Check whether the page title contains "Rozetka"
        if (pageTitle.contains("Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Назва сторінки не містить 'Rozetka'");
        }

        // Знаходимо пошуковий інпут та вводимо значення Asus PCI-Ex
        WebElement searchInput = driver.findElement(By.cssSelector("input[name='search']"));
        searchInput.sendKeys("Asus PCI-Ex");

        // Клікаємо на кнопку пошуку
        WebElement searchButton = driver.findElement(By.cssSelector(".search-form__submit"));
        searchButton.click();

        // Знаходимо всі товари на сторінці
        List<WebElement> products = driver.findElements(By.cssSelector(".goods-tile__inner"));
        Thread.sleep(1000);

        // Вибираємо третій товар за розрахунком
        WebElement product = products.get(2);
        Thread.sleep(1000);

        // Клікаємо на вибраний товар, щоб перейти на його сторінку
        product.click();
        Thread.sleep(2000);

        // Додаємо товар до корзини
        WebElement addToCartButton = driver.findElement(By.cssSelector("app-buy-button"));
        addToCartButton.click();
        Thread.sleep(1000);

        // Вибираємо модальне вікно
        driver.getWindowHandles();
        Thread.sleep(1000);
        // Закриваємо модальне вікно
        WebElement closeButton = driver.findElement(By.cssSelector("button.modal__close"));
        //WebElement closeButton = driver.findElement(By.xpath(".//div[contains(@class, 'modal__header')]/button[contains(@class, 'modal__close')]"));
        closeButton.click();  // ???

        // Натиснення на кнопку "Каталог"
        WebElement catalogButton = driver.findElement(By.xpath("//button[@aria-label='Каталог']"));
        catalogButton.click();
        Thread.sleep(1000);

        //Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement mainMenu = driver.findElement(By.xpath("//ul//li//a[contains(.,'Товари для дому')]"));;
        Thread.sleep(1000);
        action.moveToElement(mainMenu).perform();
        Thread.sleep(1000);
        WebElement subMenu = driver.findElement(By.xpath("//ul//li//a[contains(., 'Освітлення')]"));
        subMenu.click();
        Thread.sleep(3000);

        // Вибір категорії "Бра та настінно-стельові світильники"
        WebElement categoryLink = driver.findElement(By.linkText("Бра та настінно-стельові світильники"));
        categoryLink.click();
        Thread.sleep(7000);

        // Вибір третього товару зі списку та додавання його в корзину
        List<WebElement> products1 = driver.findElements(By.cssSelector("app-goods-tile-default"));
        Thread.sleep(2000);

        WebElement thirdProduct = products1.get(2);
        thirdProduct.click();
        Thread.sleep(1000);

        // Додаємо товар до корзини
        WebElement addToCartBtn = driver.findElement(By.cssSelector("app-buy-button"));
        addToCartBtn.click();
        Thread.sleep(2000);

        // Вибираємо модальне вікно
        driver.getWindowHandles();
        Thread.sleep(1000);

        // Закриваємо модальне вікно
        WebElement closeButton1 = driver.findElement(By.cssSelector("button.modal__close"));
        closeButton1.click();
        Thread.sleep(2000);

        // New class #########################################
        Rozetka next = new Rozetka();
                next.home();

        // Знаходимо пошуковий інпут та вводимо значення Asus PCI-Ex
        WebElement search_Input = driver.findElement(By.cssSelector("input[name='search']"));
        search_Input.sendKeys("Інтерактивні панелі");
        Thread.sleep(1000);

        // Клікаємо на кнопку пошуку
        WebElement searchBtn = driver.findElement(By.cssSelector(".search-form__submit"));
        searchBtn.click();

        // Знаходимо всі товари на сторінці
        List<WebElement> goods = driver.findElements(By.cssSelector(".goods-tile__inner"));
        Thread.sleep(3000);

        // Вибираємо третій товар за розрахунком
        WebElement good = goods.get(3);
        Thread.sleep(3000);
        // Клікаємо на вибраний товар, щоб перейти на його сторінку
        good.click();
        Thread.sleep(2000);

        // Додаємо товар до корзини
        WebElement addToCartBttn = driver.findElement(By.cssSelector("app-buy-button"));
        addToCartBttn.click();
        Thread.sleep(1000);

        // Вибираємо модальне вікно
        driver.getWindowHandles();
        Thread.sleep(1000);

        // Закриваємо модальне вікно
        WebElement closeBtn = driver.findElement(By.cssSelector("button.modal__close"));
        closeBtn.click();
        Thread.sleep(2000);

        // Закриваємо браузер
        driver.quit();
    }
}
