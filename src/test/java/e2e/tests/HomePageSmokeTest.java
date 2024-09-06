package e2e.tests;

import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.OrangePage;
import org.testng.Assert;

import java.util.Set;

public class HomePageSmokeTest extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    public void smokeTestOnHomePage(){
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
    }
}
