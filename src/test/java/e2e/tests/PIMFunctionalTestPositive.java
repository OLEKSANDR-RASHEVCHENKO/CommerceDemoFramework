package e2e.tests;

import com.github.javafaker.Faker;
import e2e.pages.AddEmployeePage;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.PIMPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMFunctionalTestPositive extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    PIMPage pimPage;
    AddEmployeePage addEmployeePage;
    Faker faker = new Faker();

    @Feature("PIM Functional Test")
    @Story("User can add, verify, and delete employee data")
    @Description("Test to verify that the user can successfully add, verify, and delete an employee in the PIM module.")
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "PIM functional test with valid employee data")
    public void PimFunctionalTest() throws InterruptedException {
        String username = "Admin";
        String password = "admin123";
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        int id = faker.number().numberBetween(1, 10000);
        String pathToPhoto = "C:\\Users\\OleksandrRashevchenk\\IdeaProjects\\CommerceDemoFramework\\src\\test\\java\\e2e\\imagesForUpload\\cherepashki-nindzya-geroi-010-all.jpg";
        String name = faker.name().username();
        String pass = faker.regexify("[a-zA-Z0-9]{6,29}\\d");
        String confirmPass = pass;
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        String actualUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        loginPage.setLoginData(username, password);
        homePage = new HomePage(app.driver);
        homePage.waitForLoadingHomePage();
        homePage.clickOnOneFromSidebarMenu("PIM");
        pimPage = new PIMPage(app.driver);
        pimPage.waitForLoadingPIMPage();
        String actualTitle = pimPage.getTitle();
        String expectedTitle = "PIM";
        Assert.assertEquals(actualTitle, expectedTitle);
        pimPage.clickOnAddButton();
        addEmployeePage = new AddEmployeePage(app.driver);
        addEmployeePage.waitForLoadingAddEmployee();
        addEmployeePage.setUserData(firstName, lastName, id, pathToPhoto, name, pass, confirmPass);
        addEmployeePage.successSavedIsDisplayed();
        addEmployeePage.clickOnEmployeeList();
        pimPage = new PIMPage(app.driver);
        pimPage.waitForLoadingPIMPage();
        pimPage.setDataToFoundEmployee(firstName + " " + lastName);
        Thread.sleep(1000);
        pimPage.getId(String.valueOf(id));
        pimPage.getFirstName(firstName);
        pimPage.getLastName(lastName);
        pimPage.deleteUser();
        pimPage.clickSearch();
        Thread.sleep(1000);
        pimPage.errorMessageAfterDeletingUser();
    }
}
