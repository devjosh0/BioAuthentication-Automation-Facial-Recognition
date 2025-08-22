package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By loginLink = By.linkText("Log in");
    private final By faceLoginBtn = By.cssSelector("button.btn.btn-success.btn-block");
    private final By authenticateBtn = By.id("authenticate-biometrics");
    private final By confirmTitle = By.cssSelector("body > div.page > div.right-container > div > h1");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLogin() {
        waitForVisible(loginLink).click();
    }

    public void loginWithFace() {
        waitForVisible(faceLoginBtn).click();
        waitForVisible(authenticateBtn).click();
    }

    public void assertLoggedIn() {
        waitForText(confirmTitle, "Account info");
    }
}
