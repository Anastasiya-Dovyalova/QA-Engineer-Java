import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MtsTests {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/anastasiadovalova/chromedriver/mac-131.0.6778.140/chromedriver-mac-x64/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    public void testOnlineTopUpBlockTitle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        String actualTitle = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/h2")).getText().replaceAll("\\s+", " ").trim();
        String expectedTitle = "Онлайн пополнение без комиссии";
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок не совпадает!");
        driver.quit();
    }

    @Test
    @DisplayName("Проверка на наличие логотипов платежных систем")
    public void testLogosPresence() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement paymentSection = driver.findElement(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]"));
        WebElement ul = paymentSection.findElement(By.xpath("./ul"));
        List<WebElement> listItems = ul.findElements(By.xpath("./li"));
        assertTrue(listItems.size() > 0, "Не найдены логотипы платёжных систем.");
        for (WebElement logo : listItems) {
            WebElement img = logo.findElement(By.tagName("img"));
            assertTrue(img.isDisplayed(), "Логотип не отображается.");
        }
        driver.quit();
    }

    @Test
    @DisplayName("Проверка работы ссылки Подробнее о сервисе")
    public void testServiceLink() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebElement moreInfoLink = driver.findElement(By.linkText("Подробнее о сервисе"));
        assertNotNull(moreInfoLink, "Ссылка 'Подробнее о сервисе' не найдена.");
        moreInfoLink.click();
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        assertEquals(expectedUrl, driver.getCurrentUrl(), "Неверный URL после перехода по ссылке.");
        driver.quit();
    }

    @Test
    @DisplayName("Проверка работы кнопки Продолжить")
    public void testContinueButton() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            WebElement rejectButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".cookie__cancel")));
            if (rejectButton.isDisplayed()) {
                rejectButton.click();
                System.out.println("Куки окно отклонено");
            }
        } catch (Exception e) {
            System.out.println("Окно с куки не появилось");
        }
        WebElement dropdown = driver.findElement(By.id("pay"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Услуги связи");
        WebElement phoneNumberField = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneNumberField.sendKeys("297777777");
        WebElement amountField = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        amountField.sendKeys("60");
        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        continueButton.click();
        driver.quit();
    }

}