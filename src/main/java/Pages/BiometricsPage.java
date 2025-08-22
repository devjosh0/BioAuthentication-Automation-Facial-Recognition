package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class BiometricsPage extends BasePage {

    private final By biometricsBtn = By.id("setup-biometrics");
    private final By accountInfo = By.id("user-account-info");

    public BiometricsPage(WebDriver driver) {
        super(driver);
    }

    FluentWait<WebDriver> fluentWait1 = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(180))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(Exception.class);

    public void setupBiometrics() {
        fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("setup-biometrics")));
        driver.findElement(biometricsBtn).click();
    }

    public void goToAccountInfo() {
        fluentWait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-account-info")));
        driver.findElement(accountInfo).click();
    }
}

