package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage {

    private final By username = By.id("signUpUsername");
    private final By email = By.id("signUpEmail");
    private final By password = By.id("signUpPassword");
    private final By signUpBtn = By.id("signUpButton");

    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public void signUp(String user, String mail, String pass) {
        waitForVisible(username).sendKeys(user);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(signUpBtn).click();
    }
}
