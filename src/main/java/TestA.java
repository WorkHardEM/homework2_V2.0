// o Скрипт А. Логин в Админ панель
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


public class TestA {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();
        driver.manage().window().maximize();

        login(driver);
        exit(driver);

        driver.quit();
    }

    public static void login(WebDriver driver) throws InterruptedException {
        driver.get("http://prestashop-automation.qatestlab.com.ua/admin147ajyvk0/");
        WebElement emailField = driver.findElement(By.name("email"));
        emailField.sendKeys("webinar.test@gmail.com");
        WebElement passwordField = driver.findElement(By.name("passwd"));
        passwordField.sendKeys("Xcg7299bnSmMuRLp9ITw");
        WebElement loginButton = driver.findElement(By.name("submitLogin"));
        loginButton.click();
        TimeUnit.SECONDS.sleep(5);
    }

    public static void exit(WebDriver driver) throws InterruptedException {
        WebElement iconProfile = driver.findElement(By.className("employee_avatar_small"));
        iconProfile.click();
        TimeUnit.SECONDS.sleep(3);
        WebElement logout = driver.findElement(By.id("header_logout"));
        logout.click();
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }


    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", TestA.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }
}
