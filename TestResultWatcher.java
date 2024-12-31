package org.example;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class TestResultWatcher implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Object testInstance = context.getTestInstance().orElse(null);
        if (testInstance instanceof WebDriverProvider) {
            WebDriver driver = ((WebDriverProvider) testInstance).getDriver();
            if (driver != null) {
                byte[] screenshot = captureScreenshot(driver);
                if (screenshot != null) {
                    Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));
                    System.out.println("Скриншот успешно захвачен.");
                }
            }
        }
    }

    @Attachment(value = "Скриншот при неудаче", type = "image/png")
    public byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
