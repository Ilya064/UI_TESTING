import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;


public class Pikabu {
    WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/IKHalizov/Desktop/AT-Cource/UI/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void PikabuTesting() {

        driver.get("https://pikabu.ru");
        Assert.assertEquals(driver.getCurrentUrl(), "https://pikabu.ru/");
        Assert.assertEquals(driver.getTitle(), "Горячее – самые интересные и обсуждаемые посты | Пикабу");

        driver.findElement(By.cssSelector(".header-right-menu__login-button")).click();

        driver.findElement(By.cssSelector(".auth-modal .input__input[placeholder='Логин']")).isDisplayed();
        driver.findElement(By.cssSelector(".auth-modal .input__input[placeholder='Пароль']")).isDisplayed();
        driver.findElement(By.cssSelector(".auth-modal .button__title")).isDisplayed();

        driver.findElement(By.cssSelector(".auth-modal .input__input[placeholder='Логин']")).sendKeys("Qwerty");
        driver.findElement(By.cssSelector(".auth-modal .input__input[placeholder='Пароль']")).sendKeys("Qwerty");
        driver.findElement(By.cssSelector(".auth-modal .button__title")).click();

        driver.findElement(By.cssSelector(".popup__content .auth__error.auth__error_top")).isDisplayed();
        String text = driver.findElement(By.cssSelector(".popup__content .auth__error.auth__error_top")).getText();
        Assert.assertEquals(text, "Ошибка проверки данных. Повторите процесс авторизации, пожалуйста");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}



