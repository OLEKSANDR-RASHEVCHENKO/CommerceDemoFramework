package e2e.tests;

import e2e.pages.LoginPage;
import e2e.pages.OrangePage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class LoginTest_Positive_001 extends BaseTest {
    LoginPage loginPage;
    OrangePage orangePage;

    @Feature("Login Positive Test")
    @Story("User can log in with correct data")
    @Description("Checking login process and navigating to OrangeHRM page from opensource-demo.orangehmlive.com")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Positive login test with valid credentials")
    public void loginInSystem() {
        String username = "Admin";
        String password = "admin123";
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        String actualUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        String requiredPage = loginPage.getWindow();
        loginPage.clickOnOrangeHRM();

        Set<String> allWindows = app.driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(requiredPage)) {
                app.driver.switchTo().window(window);
                System.out.println(window);
                break;
            }
        }

        orangePage = new OrangePage(app.driver);
        orangePage.waitForOrangePage();
        String urlOnOrangePage = orangePage.getCurrentUrl();
        Assert.assertEquals(urlOnOrangePage, "https://www.orangehrm.com/");
        app.driver.switchTo().window(requiredPage);
        loginPage.setLoginData(username, password);

    }
}
