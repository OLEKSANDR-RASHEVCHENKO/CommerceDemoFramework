package e2e.tests;

import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageSmokeTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    @Feature("Home Page Smoke Test")
    @Story("Verify login and sidebar navigation functionality")
    @Description("Smoke test to verify the login functionality and interaction with the sidebar menu on the Home Page")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void smokeTestOnHomePage() throws InterruptedException {
        String username = "Admin";
        String password = "admin123";
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        String actualUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        loginPage.setLoginData(username, password);
        homePage = new HomePage(app.driver);
        homePage.waitForLoadingHomePage();
        homePage.testSidebarMenu();
    }
}
