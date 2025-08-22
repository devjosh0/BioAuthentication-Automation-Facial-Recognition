

import Pages.BiometricsPage;
import Pages.DeleteAccount;
import Pages.LoginPage;
import Pages.SignUpPage;
import Utils.ConvertMp4ToY4m;
import Utils.TestDataUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FaceSignUpTest extends ConvertMp4ToY4m {

    @Test
    public void testFaceSignUpAndLogin() {

        String mp4Path = System.getProperty("user.dir") + "/src/main/resources/face.mp4";
        String y4mPath = System.getProperty("user.dir") + "/src/main/resources/face.y4m";

        // Convert video before starting Chrome
        convertMp4ToY4m(mp4Path, y4mPath);


        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless=new"); // or "--headless" comment to run in GUI
        //options.addArguments("--disable-gpu");//comment to run in GUI
        options.addArguments("--use-fake-ui-for-media-stream");
        options.addArguments("--use-fake-device-for-media-stream");
        options.addArguments("--use-file-for-fake-video-capture=" + y4mPath);

        ChromeDriver driver = new ChromeDriver(options);

        driver.get("https://uxjh3zwiuz.eu-central-1.awsapprunner.com/#!");

        String username = TestDataUtils.generateRandomUsername();
        String email = TestDataUtils.generateRandomEmail();
        String password = TestDataUtils.generateRandomPassword();

        SignUpPage signUp = new SignUpPage(driver);
        signUp.signUp(username, email, password);

        BiometricsPage biometrics = new BiometricsPage(driver);
        biometrics.setupBiometrics();
        biometrics.goToAccountInfo();

        // Logout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement logoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button:nth-child(5)")));
        logoutBtn.click();

        LoginPage login = new LoginPage(driver);
        login.openLogin();
        login.loginWithFace();
        login.assertLoggedIn();

        DeleteAccount deleteAccount = new DeleteAccount(driver);
        deleteAccount.deleteUserAccount();

        driver.quit();
    }
}
