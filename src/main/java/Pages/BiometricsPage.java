package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BiometricsPage extends BasePage {

    private final By setupBiometrics = By.id("setup-biometrics");
    private final By accountInfo = By.id("user-account-info");

    public BiometricsPage(WebDriver driver) {
        super(driver);
    }

    public void setupBiometrics() {
        waitForVisible(setupBiometrics).click();
    }

    public void goToAccountInfo() {
        waitForVisible(accountInfo).click();
    }
}

