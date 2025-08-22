package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccount extends BasePage{

    private final By deleteButton = By.cssSelector("button.btn.btn-danger.btn-block");

    public DeleteAccount(WebDriver driver) {
        super(driver);
    }
    public void deleteUserAccount(){
        waitForVisible(deleteButton);
        driver.findElement(deleteButton).click();
    }

}
