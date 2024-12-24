import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.PaymentPage;

import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class MTStest {

    private WebDriver driver;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/anastasiadovalova/chromedriver/mac-131.0.6778.140/chromedriver-mac-x64/chromedriver"); // Укажите путь к chromedriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        paymentPage = new PaymentPage(driver);
        driver.get("https://www.mts.by");
        paymentPage.rejectCookies();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Проверка открытия выпадающего списка")
    public void testDropdownOpensWhenSelectButtonClicked() {
        paymentPage.clickSelectButton();
        paymentPage.waitForDropdownToBeVisible();
        assertTrue(paymentPage.isDropdownVisible(), "Выпадающий список должен быть видимым после клика по кнопке");
    }


    @Test
    @DisplayName("Проверка активностей элементов списка")
    public void testTabsFunctionality() {
        paymentPage.clickSelectButton();
        paymentPage.waitForDropdownToBeVisible();
        paymentPage.selectTab("Услуги связи");
        assertTrue(paymentPage.isServicesTabActive(),
                "Вкладка 'Услуги связи' должна быть активной после клика");
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Домашний интернет");
        assertTrue(paymentPage.isInternetTabActive(),
                "Вкладка 'Домашний интернет' должна быть активной после клика");
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Рассрочка");
        assertTrue(paymentPage.isInstalmentTabActive(),
                "Вкладка 'Рассрочка' должна быть активной после клика");
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Задолженность");
        assertTrue(paymentPage.isDebtTabActive(),
                "Вкладка 'Задолженность' должна быть активной после клика");
    }

    @Test
    @DisplayName("Проверка пустоты полей на вкладках")
    public void testFieldsAreEmptyOnEachTab() {
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Услуги связи");
        String phoneServicesValue = driver.findElement(paymentPage.getPhoneServicesTab()).getAttribute("value");
        String totalRubServicesValue = driver.findElement(paymentPage.getTotalRubServicesTab()).getAttribute("value");
        String emailServicesValue = driver.findElement(paymentPage.getEmailServicesTab()).getAttribute("value");
        assertTrue(phoneServicesValue.isEmpty(),
                "Поле 'Номер телефона' на вкладке 'Услуги связи' должно быть пустым");
        assertTrue(totalRubServicesValue.isEmpty(),
                "Поле 'Сумма в рублях' на вкладке 'Услуги связи' должно быть пустым");
        assertTrue(emailServicesValue.isEmpty(),
                "Поле 'Email' на вкладке 'Услуги связи' должно быть пустым");
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Домашний интернет");
        String phoneInternetValue = driver.findElement(paymentPage.getPhoneInternetTab()).getAttribute("value");
        String totalRubInternetValue = driver.findElement(paymentPage.getTotalRubInternetTab()).getAttribute("value");
        String emailInternetValue = driver.findElement(paymentPage.getEmailInternetTab()).getAttribute("value");
        assertTrue(phoneInternetValue.isEmpty(),
                "Поле 'Номер телефона' на вкладке 'Домашний интернет' должно быть пустым");
        assertTrue(totalRubInternetValue.isEmpty(),
                "Поле 'Сумма в рублях' на вкладке 'Домашний интернет' должно быть пустым");
        assertTrue(emailInternetValue.isEmpty(),
                "Поле 'Email' на вкладке 'Домашний интернет' должно быть пустым");
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Рассрочка");
        String scoreInstalmentValue = driver.findElement(paymentPage.getScoreInstalmentTab()).getAttribute("value");
        String totalRubInstalmentValue = driver.findElement(paymentPage.getTotalRubInstalmentTab()).getAttribute("value");
        String emailInstalmentValue = driver.findElement(paymentPage.getEmailInstalmentTab()).getAttribute("value");
        assertTrue(scoreInstalmentValue.isEmpty(),
                "Поле 'Номер счета' на вкладке 'Рассрочка' должно быть пустым");
        assertTrue(totalRubInstalmentValue.isEmpty(),
                "Поле 'Сумма в рублях' на вкладке 'Рассрочка' должно быть пустым");
        assertTrue(emailInstalmentValue.isEmpty(),
                "Поле 'Email' на вкладке 'Рассрочка' должно быть пустым");
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Задолженность");
        String scoreDebtValue = driver.findElement(paymentPage.getScoreDebtTab()).getAttribute("value");
        String totalRubDebtValue = driver.findElement(paymentPage.getTotalRubDebtTab()).getAttribute("value");
        String emailDebtValue = driver.findElement(paymentPage.getEmailDebtTab()).getAttribute("value");
        assertTrue(scoreDebtValue.isEmpty(),
                "Поле 'Номер счета' на вкладке 'Задолженность' должно быть пустым");
        assertTrue(totalRubDebtValue.isEmpty(),
                "Поле 'Сумма в рублях' на вкладке 'Задолженность' должно быть пустым");
        assertTrue(emailDebtValue.isEmpty(),
                "Поле 'Email' на вкладке 'Задолженность' должно быть пустым");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке 'Услуги связи'")
    public void testServicesTabPlaceholders() {
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Услуги связи");
        assertEquals("Номер телефона", paymentPage.getPhoneServicesPlaceholder(),
                "Некорректный плейсхолдер для поля 'Номер телефона' на вкладке 'Услуги связи'");
        assertEquals("Сумма", paymentPage.getTotalRubServicesPlaceholder(),
                "Некорректный плейсхолдер для поля 'Сумма' на вкладке 'Услуги связи'");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailServicesPlaceholder(),
                "Некорректный плейсхолдер для поля 'Email' на вкладке 'Услуги связи'");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке 'Домашний интернет'")
    public void testInternetTabPlaceholders() {
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Домашний интернет");
        assertEquals("Номер абонента", paymentPage.getPhoneInternetPlaceholder(),
                "Некорректный плейсхолдер для поля 'Номер абонента' на вкладке 'Домашний интернет'");
        assertEquals("Сумма", paymentPage.getTotalRubInternetPlaceholder(),
                "Некорректный плейсхолдер для поля 'Сумма' на вкладке 'Домашний интернет'");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailInternetPlaceholder(),
                "Некорректный плейсхолдер для поля 'Email' на вкладке 'Домашний интернет'");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке 'Рассрочка'")
    public void testInstalmentTabPlaceholders() {
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Рассрочка");
        assertEquals("Номер счета на 44", paymentPage.getScoreInstalmentPlaceholder(),
                "Некорректный плейсхолдер для поля 'Номер счета' на вкладке 'Рассрочка'");
        assertEquals("Сумма", paymentPage.getTotalRubInstalmentPlaceholder(),
                "Некорректный плейсхолдер для поля 'Сумма' на вкладке 'Рассрочка'");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailInstalmentPlaceholder(),
                "Некорректный плейсхолдер для поля 'Email' на вкладке 'Рассрочка'");
    }

    @Test
    @DisplayName("Проверка плейсхолдеров на вкладке 'Задолженность'")
    public void testDebtTabPlaceholders() {
        paymentPage.clickSelectButton();
        paymentPage.selectTab("Задолженность");
        assertEquals("Номер счета на 2073", paymentPage.getScoreDebtPlaceholder(),
                "Некорректный плейсхолдер для поля 'Номер счета' на вкладке 'Задолженность'");
        assertEquals("Сумма", paymentPage.getTotalRubDebtPlaceholder(),
                "Некорректный плейсхолдер для поля 'Сумма' на вкладке 'Задолженность'");
        assertEquals("E-mail для отправки чека", paymentPage.getEmailDebtPlaceholder(),
                "Некорректный плейсхолдер для поля 'Email' на вкладке 'Задолженность'");
    }

    @Test
    @DisplayName("Проверка заполнения полей на вкладке 'Услуги связи' и нажатия кнопки 'Продолжить'")
    public void testFillServicesTabAndContinue() {
        String testPhoneNumber = "(29)777-77-77";
        String testTotalRub = "5";
        paymentPage.fillServicesTabFields(testPhoneNumber, testTotalRub);
        assertEquals(testPhoneNumber, driver.findElement(paymentPage.getPhoneServicesTab()).getAttribute("value"),
                "Поле 'Номер телефона' заполнено некорректно");
        assertEquals(testTotalRub, driver.findElement(paymentPage.getTotalRubServicesTab()).getAttribute("value"),
                "Поле 'Сумма в рублях' заполнено некорректно");
    }

    @Test
    @DisplayName("Проверка на корректность отображения суммы в появившемся окне после нажатия кнопки 'Продолжить'")
    public void testSumIframe() {
        String testPhoneNumber = "(29)777-77-77";
        String testTotalRub = "5";
        paymentPage.fillServicesTabFields(testPhoneNumber, testTotalRub);
        paymentPage.clickContinueButton();
        paymentPage.switchToIframe(paymentPage.getIframeWindow());
        assertEquals("5.00 BYN", paymentPage.getsumIframe(),
                "Итоговая сумма отображается некорректно!");
        paymentPage.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка на корректность отображения суммы на кнопке 'Оплатить'")
    public void testButtonSumIframe() {
        String testPhoneNumber = "(29)777-77-77";
        String testTotalRub = "5";
        paymentPage.fillServicesTabFields(testPhoneNumber, testTotalRub);
        paymentPage.clickContinueButton();
        paymentPage.switchToIframe(paymentPage.getIframeWindow());
        assertEquals("Оплатить 5.00 BYN", paymentPage.getsumbtnIframe(),
                "Итоговая сумма отображается некорректно!");
        paymentPage.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка на корректность отображения номера телефона в появившемся окне после нажатия кнопки 'Продолжить'")
    public void testPhoneIframe() {
        String testPhoneNumber = "(29)777-77-77";
        String testTotalRub = "5";
        paymentPage.fillServicesTabFields(testPhoneNumber, testTotalRub);
        paymentPage.clickContinueButton();
        paymentPage.switchToIframe(paymentPage.getIframeWindow());
        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", paymentPage.getphoneIframe(),
                "Номер телефона отображается некорректно!");
        paymentPage.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка на корректность отображения надписей в незаполненных полях для ввода реквизитов карты")
    public void testCardIframe() {
        String testPhoneNumber = "(29)777-77-77";
        String testTotalRub = "5";
        paymentPage.fillServicesTabFields(testPhoneNumber, testTotalRub);
        paymentPage.clickContinueButton();
        paymentPage.switchToIframe(paymentPage.getIframeWindow());
        Assertions.assertEquals("Номер карты", paymentPage.getCardIframe(),
                "Номер карты отображается некорректно!");
        Assertions.assertEquals("Срок действия", paymentPage.getExpirationDateIframe(),
                "Срок действия отображается некорректно!");
        Assertions.assertEquals("CVC", paymentPage.getCVCIframe(),
                "CVC отображается некорректно!");
        Assertions.assertEquals("Имя держателя (как на карте)", paymentPage.getNameIframe(),
                "Имя держателя отображается некорректно!");
        paymentPage.switchToDefaultContent();
    }

    @Test
    @DisplayName("Проверка наличия иконок платёжных систем")
    public void testPaymentIconsPresence() {
        String testPhoneNumber = "(29)777-77-77";
        String testTotalRub = "5";
        paymentPage.fillServicesTabFields(testPhoneNumber, testTotalRub);
        paymentPage.clickContinueButton();
        paymentPage.switchToIframe(paymentPage.getIframeWindow());
        List<String> expectedIcons = Arrays.asList("visa-system.svg", "mastercard-system.svg",
                "belkart-system.svg", "maestro-system.svg", "mir-system-ru.svg");
        for (String iconSrc : expectedIcons) {
            Assertions.assertTrue(paymentPage.isIconPresent(iconSrc),
                    "Иконка " + iconSrc + " не найдена на странице!");
        }
        paymentPage.switchToDefaultContent();
    }
}

