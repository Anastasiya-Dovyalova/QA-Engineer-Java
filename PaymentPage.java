package org.example;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By selectButton = By.cssSelector("button.select__header");
    private By dropdownList = By.cssSelector("ul.select__list");
    private By servicesTab = By.xpath("(//ul[contains(@class, 'select__list')]/li)[1]");
    private By internetTab = By.xpath("(//ul[contains(@class, 'select__list')]/li)[2]");
    private By instalmentTab = By.xpath("(//ul[contains(@class, 'select__list')]/li)[3]");
    private By debtTab = By.xpath("(//ul[contains(@class, 'select__list')]/li)[4]");
    private By phoneServicesTab = By.id("connection-phone");
    private By total_rubServicesTab = By.id("connection-sum");
    private By emailServicesTab = By.id("connection-email");
    private By phoneInternetTab = By.id("internet-phone");
    private By total_rubInternetTab = By.id("internet-sum");
    private By emailInternetTab = By.id("internet-email");
    private By scoreInstalmentTab = By.id("score-instalment");
    private By total_rubInstalmentTab = By.id("instalment-sum");
    private By emailInstalmentTab = By.id("instalment-email");
    private By scoreDebtTab = By.id("score-arrears");
    private By total_rubDebtTab = By.id("arrears-sum");
    private By emailDebtTab = By.id("arrears-email");
    private By continueButton = By.xpath("//*[@id=\"pay-connection\"]/button");
    private By rejectButton = By.cssSelector("button.btn.btn_gray.cookie__cancel");
    private By iframeWindow = By.xpath("//iframe[@class = 'bepaid-iframe']");
    private By payDescriptionText = By.cssSelector(".pay-description__text");
    private By payDescriptionCost = By.cssSelector(".pay-description__cost");
    private By payButtonCost = By.cssSelector("button.colored.disabled");
    private By payCraditCard = By.xpath("//label[text()='Номер карты']");
    private By payExpirationDate = By.xpath("//label[text()='Срок действия']");
    private By payCVC = By.xpath("//label[text()='CVC']");
    private By payName = By.xpath("//label[text()='Имя держателя (как на карте)']");
    private By paymentIconsContainer = By.cssSelector(".cards-brands__container");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 40);
    }

    @Step("Кликаем на выпадающий список в блоке 'Онлайн пополнение без комиссии'")
    public void clickSelectButton() {
        WebElement selectButtonElement = wait.until(ExpectedConditions.elementToBeClickable(selectButton));
        selectButtonElement.click();
    }

    @Step("Ожидаем, пока выпадающий список станет видимым")
    public void waitForDropdownToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownList));
    }

    @Step("Проверяем, виден ли выпадающий список")
    public boolean isDropdownVisible() {
        return driver.findElement(dropdownList).isDisplayed();
    }

    @Step("Выбираем вкладку: {tabName}")
    public void selectTab(String tabName) {
        By tab = null;
        switch (tabName) {
            case "Услуги связи":
                tab = servicesTab;
                break;
            case "Домашний интернет":
                tab = internetTab;
                break;
            case "Рассрочка":
                tab = instalmentTab;
                break;
            case "Задолженность":
                tab = debtTab;
                break;
        }
        WebElement tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tab));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tabElement);
        wait.until(ExpectedConditions.elementToBeClickable(tabElement));
        try {
            tabElement.click();
        } catch (ElementClickInterceptedException e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tabElement);
        }
    }

    @Step("Заполняем поля 'Номер телефона' и 'Сумма' на вкладке 'Услуги связи'")
    public void fillServicesTabFields(String phoneNumber, String totalRub) {
        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneServicesTab));
        phoneField.clear();
        phoneField.sendKeys(phoneNumber);

        WebElement totalRubField = driver.findElement(total_rubServicesTab);
        totalRubField.clear();
        totalRubField.sendKeys(totalRub);
    }

    @Step("Кликаем по кнопке 'Продолжить'")
    public void clickContinueButton() {
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueBtn.click();
    }

    @Step("Отклоняем окно с куки, если оно появляется")
    public void rejectCookies() {
        try {
            WebElement rejectButtonElement = wait.until(ExpectedConditions.elementToBeClickable(rejectButton));
            if (rejectButtonElement.isDisplayed()) {
                rejectButtonElement.click();
                System.out.println("Куки окно отклонено");
            }
        } catch (Exception e) {
            System.out.println("Окно с куки не появилось");
        }
    }

    @Step("Переключаемся на iframe")
    public void switchToIframe(By iframeLocator) {
        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframe);
    }

    @Step("Возвращаемся к основному содержимому страницы")
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    @Step("Получаем текст с поля 'Номер карты'")
    public String getCardIframe() {
        WebElement totalCardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payCraditCard));
        String totalCard = totalCardElement.getText();
        return totalCard;
    }

    @Step("Получаем текст с поля 'CVC'")
    public String getCVCIframe() {
        WebElement totalCVCElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payCVC));
        String totalCVC = totalCVCElement.getText();
        return totalCVC;
    }

    @Step("Получаем текст с поля 'Срок действия'")
    public String getExpirationDateIframe() {
        WebElement totalExpirationDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payExpirationDate));
        String totalExpirationDate = totalExpirationDateElement.getText();
        return totalExpirationDate;
    }

    @Step("Получаем текст с поля 'Имя держателя (как на карте)'")
    public String getNameIframe() {
        WebElement totalNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payName));
        String totalName = totalNameElement.getText();
        return totalName;
    }

    @Step("Получаем текст с поля описания (номер телефона)")
    public String getphoneIframe() {
        WebElement totalPhoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payDescriptionText));
        String totalPhone = totalPhoneElement.getText();
        return totalPhone;
    }

    @Step("Получаем текст с кнопки подтверждения")
    public String getsumbtnIframe() {
        WebElement totalsumbtnElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payButtonCost));
        String totalsumbtn = totalsumbtnElement.getText();
        return totalsumbtn;
    }

    @Step("Получаем сумму с описания")
    public String getsumIframe() {
        WebElement totalAmountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(payDescriptionCost));
        String totalAmount = totalAmountElement.getText();
        return totalAmount;
    }

    @Step("Получаем все иконки платежных систем")
    public List<WebElement> getPaymentIcons() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement container = wait.until(ExpectedConditions.presenceOfElementLocated(paymentIconsContainer));
        return container.findElements(By.tagName("img"));
    }

    @Step("Проверяем, присутствует ли иконка с src {iconSrc}")
    public boolean isIconPresent(String iconSrc) {
        List<WebElement> icons = getPaymentIcons();
        for (WebElement icon : icons) {
            if (icon.getAttribute("src").contains(iconSrc)) {
                return true;
            }
        }
        return false;
    }

    private boolean isTabActive(By tabLocator) {
        WebElement tabElement = wait.until(ExpectedConditions.visibilityOfElementLocated(tabLocator));
        return tabElement.getAttribute("class").contains("active");
    }

    @Step("Проверяем, активна ли вкладка 'Услуги связи'")
    public boolean isServicesTabActive() {
        return isTabActive(servicesTab);
    }

    @Step("Проверяем, активна ли вкладка 'Домашний интернет'")
    public boolean isInternetTabActive() {
        return isTabActive(internetTab);
    }

    @Step("Проверяем, активна ли вкладка 'Рассрочка'")
    public boolean isInstalmentTabActive() {
        return isTabActive(instalmentTab);
    }

    @Step("Проверяем, активна ли вкладка 'Задолженность'")
    public boolean isDebtTabActive() {
        return isTabActive(debtTab);
    }

    @Step("Получаем placeholder поля 'Номер телефона' на вкладке 'Услуги связи'")
    public String getPhoneServicesPlaceholder() {
        return driver.findElement(phoneServicesTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Сумма' на вкладке 'Услуги связи'")
    public String getTotalRubServicesPlaceholder() {
        return driver.findElement(total_rubServicesTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Email' на вкладке 'Услуги связи'")
    public String getEmailServicesPlaceholder() {
        return driver.findElement(emailServicesTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Номер абонента' на вкладке 'Домашний интернет'")
    public String getPhoneInternetPlaceholder() {
        return driver.findElement(phoneInternetTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Сумма' на вкладке 'Домашний интернет''")
    public String getTotalRubInternetPlaceholder() {
        return driver.findElement(total_rubInternetTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Email' на вкладке 'Домашний интернет'")
    public String getEmailInternetPlaceholder() {
        return driver.findElement(emailInternetTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Номер счета' на вкладке 'Рассрочка'")
    public String getScoreInstalmentPlaceholder() {
        return driver.findElement(scoreInstalmentTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Сумма' на вкладке 'Рассрочка'")
    public String getTotalRubInstalmentPlaceholder() {
        return driver.findElement(total_rubInstalmentTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Email' на вкладке 'Рассрочка'")
    public String getEmailInstalmentPlaceholder() {
        return driver.findElement(emailInstalmentTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Номер счета' на вкладке 'Задолженность'")
    public String getScoreDebtPlaceholder() {
        return driver.findElement(scoreDebtTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Сумма' на вкладке 'Задолженность'")
    public String getTotalRubDebtPlaceholder() {
        return driver.findElement(total_rubDebtTab).getAttribute("placeholder");
    }

    @Step("Получаем placeholder поля 'Email' на вкладке 'Задолженность'")
    public String getEmailDebtPlaceholder() {
        return driver.findElement(emailDebtTab).getAttribute("placeholder");
    }

    public By getPhoneServicesTab() {
        return phoneServicesTab;
    }

    public By getTotalRubServicesTab() {
        return total_rubServicesTab;
    }

    public By getEmailServicesTab() {
        return emailServicesTab;
    }

    public By getPhoneInternetTab() {
        return phoneInternetTab;
    }

    public By getTotalRubInternetTab() {
        return total_rubInternetTab;
    }

    public By getEmailInternetTab() {
        return emailInternetTab;
    }

    public By getScoreInstalmentTab() {
        return scoreInstalmentTab;
    }

    public By getTotalRubInstalmentTab() {
        return total_rubInstalmentTab;
    }

    public By getEmailInstalmentTab() {
        return emailInstalmentTab;
    }

    public By getScoreDebtTab() {
        return scoreDebtTab;
    }

    public By getTotalRubDebtTab() {
        return total_rubDebtTab;
    }

    public By getEmailDebtTab() {
        return emailDebtTab;
    }

    public By getIframeWindow() {
        return iframeWindow;
    }
}
