package e2e.tests;

import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.MyInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoPageSmokeTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    MyInfoPage myInfoPage;

    @Test
    public void smokeTestOnMyInfoPage() throws InterruptedException {
        String username = "Admin";
        String password = "admin123";
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String name = "Oleksandr";
        String lastName = "Rashevchenko";
        String employeeId = "alex@.de";
        int otherId = 485922;
        int driverLicense = 123123;
        String nationality = "German";
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        String actualUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        loginPage.setLoginData(username, password);
        homePage = new HomePage(app.driver);
        homePage.waitForLoadingHomePage();
        homePage.clickOnOneFromSidebarMenu("My info");
        myInfoPage = new MyInfoPage(app.driver);
        myInfoPage.waitForLoadingMyInfoPage();
        myInfoPage.filPersonalData(name,lastName,employeeId,otherId,driverLicense,"December","2021",11,nationality);
        Thread.sleep(5000);
    }
}
