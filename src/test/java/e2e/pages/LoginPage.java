package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.security.cert.X509Certificate;
import java.util.List;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='oxd-text oxd-text--h5 orangehrm-login-title']")
    WebElement header;
    @FindBy(xpath = "//*[@name='username']")
    WebElement userName;
    @FindBy(xpath = "//*[@name='password']")
    WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginButton;
    @FindBy(xpath = "//a[normalize-space()='OrangeHRM, Inc']")
    WebElement linkToOtherPage;
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement errorMassageInvalidCredentials;

    List<WebElement> errors = driver.findElements(By.xpath("//*[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));

    @Step("Wait for the login page to load")
    public void waitForLoadingLoginPage() {
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
        getWait().forVisibility(loginButton);
        Assert.assertTrue(loginButton.isDisplayed());
        getWait().forVisibility(userName);
        Assert.assertTrue(userName.isDisplayed());
        getWait().forVisibility(passwordField);
        Assert.assertTrue(passwordField.isDisplayed());
        getWait().forVisibility(linkToOtherPage);
        Assert.assertTrue(linkToOtherPage.isDisplayed());
    }

    @Step("Login with username: {email} and password: {password}")
    public void setLoginData(String email, String password) {
        userName.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    @Step("Click on the OrangeHRM link")
    public void clickOnOrangeHRM() {
        linkToOtherPage.click();
    }

    @Step("Get current URL on the login page")
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
    @Step("Get current window handle")
    public String getWindow() {
        String windowHandle = driver.getWindowHandle();
        return windowHandle;
    }

    @Step("Check if 'Invalid Credentials' message is displayed")
    public void invalidCredentialsIsDisplayed() {
        getWait().forVisibility(errorMassageInvalidCredentials);
        Assert.assertTrue(errorMassageInvalidCredentials.isDisplayed());
    }

    @Step("Check if form field errors are displayed")
    public void waitForFieldsErrors() {
        getWait().forAllVisibility(errors);
    }
}
