package e2e.tests;

import com.github.javafaker.Faker;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.MyInfoPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyInfoPageSmokeTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    MyInfoPage myInfoPage;
    Faker faker = new Faker();

    @Feature("My Info Page Smoke Test")
    @Story("User can update personal information")
    @Description("Smoke test to verify the personal data update functionality on the My Info page")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "Smoke test on My Info Page with valid user data")
    public void smokeTestOnMyInfoPage() throws InterruptedException {
        String username = "Admin";
        String password = "admin123";
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String name = "Oleksandr";
        String lastName = "Rashevchenko";
        String employeeId = "alex@.de";
        int otherId = faker.number().numberBetween(100000, 999999);
        int driverLicense = faker.number().numberBetween(100000, 999999);
        String nationality = "French";
        String month = "May";
        String year = String.valueOf(faker.number().numberBetween(1987, 2025));
        String day = String.valueOf(faker.number().numberBetween(1, 30));
        String pathToPhoto = "C:\\Users\\OleksandrRashevchenk\\IdeaProjects\\CommerceDemoFramework\\src\\test\\java\\e2e\\imagesForUpload\\cherepashki-nindzya-geroi-010-all.jpg";
        String comment = faker.lorem().characters(5, 20);
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
        myInfoPage.filPersonalData(name, lastName, employeeId, otherId, driverLicense);
        myInfoPage.selectMonthAndDateOnExpiryData("July", "2023", faker.number().numberBetween(1, 30));
        myInfoPage.selectOptionInNationalityDropDown(nationality);
        myInfoPage.selectOptionIMaritalStatusDropDown("Other");
        myInfoPage.selectGender("Male");
        myInfoPage.selectMonthAndDateOnBirthData(month, year, day);
        myInfoPage.savePersonalDetails();
        myInfoPage.uploadPhoto(pathToPhoto, comment);
        myInfoPage.successSavedIsDisplayed();
        myInfoPage.refreshPage();
        myInfoPage.waitForLoadingMyInfoPage();
        String actualFullName = myInfoPage.getUserName();
        String expectedFullName = name + " " + lastName;
        Assert.assertEquals(expectedFullName, actualFullName, "ActualUserName unterscheidet sich von ExpectedUserName");


    }
}
