// o Скрипт Б. Проверка работоспособности главного меню Админ панели
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestB extends TestA {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = initChromeDriver();
        driver.manage().window().maximize();

        login(driver);

        testPage(driver, By.linkText("Dashboard"));
        testPage(driver, By.id("subtab-AdminParentOrders"));
        testPage(driver, By.id("subtab-AdminCatalog"));
        testPage(driver, By.linkText("Клиенты"));
        testPage(driver, By.id("subtab-AdminParentCustomerThreads"));
        testPage(driver, By.id("subtab-AdminStats"));
        testPage(driver, By.id("subtab-AdminParentModulesSf"));
        testPage(driver, By.linkText("Design"));
        testPage(driver, By.id("subtab-AdminParentShipping"));
        testPage(driver, By.id("subtab-AdminParentPayment"));
        testPage(driver, By.id("subtab-AdminInternational"));
        testPage(driver, By.id("subtab-ShopParameters"));
        testPage(driver, By.id("subtab-AdminAdvancedParameters"));

//        List<WebElement> listMenu = driver.findElements(By.cssSelector(".title>span"));
//        By title = By.tagName("h2");
//        String beforeRefresh, afterRefresh;
//
//        for (WebElement e : listMenu) {
//            e.click();
//            TimeUnit.SECONDS.sleep(5);
//            beforeRefresh = driver.findElement(title).getText();
//            System.out.println("before Refresh: " + beforeRefresh);
//            driver.navigate().refresh();
//            TimeUnit.SECONDS.sleep(5);
//            afterRefresh = driver.findElement(title).getText();
//            System.out.println("after Refresh " + afterRefresh);
//            TimeUnit.SECONDS.sleep(5);
//            if (beforeRefresh.equals(afterRefresh)) {
//                System.out.println("Page is same");
//            } else {
//                System.out.println("Page is not same");
//            }
//            TimeUnit.SECONDS.sleep(5);
//        }

        driver.quit();
    }

    public static void testPage(WebDriver driver, By locator) throws InterruptedException {
        String beforeRefreshTitlePage, afterRefreshTitlePage;
        WebElement dashboard = driver.findElement(locator);
        dashboard.click();
        TimeUnit.SECONDS.sleep(2);
        beforeRefreshTitlePage = driver.findElement(By.tagName("h2")).getText();
        System.out.println(beforeRefreshTitlePage);
        driver.navigate().refresh();
        TimeUnit.SECONDS.sleep(2);
        afterRefreshTitlePage = driver.findElement(By.tagName("h2")).getText();
        if (beforeRefreshTitlePage.equals(afterRefreshTitlePage)) {
            System.out.println("Page is same after resresh");
        } else {
            System.out.println("Page is not same after resresh");
        }
    }

    public static WebDriver initChromeDriver() {
        System.setProperty("webdriver.chrome.driver", TestA.class.getResource("chromedriver.exe").getPath());
        return new ChromeDriver();
    }

}
