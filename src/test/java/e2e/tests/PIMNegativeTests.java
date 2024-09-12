package e2e.tests;

import com.github.javafaker.Faker;
import e2e.pages.AddEmployeePage;
import e2e.pages.HomePage;
import e2e.pages.LoginPage;
import e2e.pages.PIMPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PIMNegativeTests extends BaseTest{
    LoginPage loginPage;
    HomePage homePage;
    PIMPage pimPage;
    AddEmployeePage addEmployeePage;
    Faker faker = new Faker();
    @Feature("PIM Negative Tests")
    @Story("User cannot add employee with invalid data")
    @Description("Negative tests to verify that the user cannot add an employee with various invalid data in the PIM module.")
    public void PIMNegativeTest(String firstName,String LastName,int id,String userName,String passwordd,boolean allFields,boolean firstAndLastNameMore30Characters,boolean userNameIsLessThen5Characters,boolean userNameIsMoreThen40Characters,boolean passwordIsLessThen7Characters,boolean passwordIsMoreThen64Characters){
        String username = "Admin";
        String password = "admin123";
        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        String pathToPhoto = "C:\\Users\\OleksandrRashevchenk\\IdeaProjects\\CommerceDemoFramework\\src\\test\\java\\e2e\\imagesForUpload\\cherepashki-nindzya-geroi-010-all.jpg";
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
        addEmployeePage.setUserData(firstName,LastName,id,pathToPhoto,userName,passwordd,passwordd);
        if (allFields){
            addEmployeePage.firstNameErrorMessage();
            addEmployeePage.lastnameErrorMessage();
            addEmployeePage.usernameErrorMessage();
            addEmployeePage.passwordErrormessage();
            addEmployeePage.confirmPasswordErrormessage();
        }if (firstAndLastNameMore30Characters){
            addEmployeePage.maxCharactersFirstnameError();
            addEmployeePage.maxCharactersLastnameError();
        }if (userNameIsLessThen5Characters){
            addEmployeePage.minCharactersUsernameError();
        }if (userNameIsMoreThen40Characters){
            addEmployeePage.maxCharactersUsernameError();
        }if (passwordIsLessThen7Characters){
            addEmployeePage.MinCharactersPasswordError();
        }if (passwordIsMoreThen64Characters){
            addEmployeePage.MaxCharactersPasswordEmail();
        }
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "PIM negative test with all empty fields")
    public void allFieldsAreEmpty(){
        PIMNegativeTest("","",12324,"","",true,false,false,false,false,false);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "PIM negative test with first and last name more than 30 characters")
    public void firstAndLastNameMore30Characters() {
        String longFirstName = faker.lorem().characters(31);
        String longLastName = faker.lorem().characters(31);
        PIMNegativeTest(longFirstName, longLastName, faker.number().numberBetween(1000, 9999), faker.name().username(), "password123", false, true, false, false, false, false);
    }
    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "PIM negative test with username less than 5 characters")
    public void userNameIsLessThan5Characters() {
        String shortUsername = faker.lorem().characters(4); // 4 символа
        PIMNegativeTest(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(1000, 9999), shortUsername, "password123", false, false, true, false, false, false);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "PIM negative test with password more than 41 characters")
    public void userNameIsMoreThan40Characters() {
        String longUsername = faker.lorem().characters(41); // 41 символ
        PIMNegativeTest(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(1000, 9999), longUsername, "password123", false, false, false, true, false, false);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "PIM negative test with password less than 6 characters")
    public void passwordIsLessThan7Characters() {
        String shortPassword = faker.lorem().characters(6); // 6 символов
        PIMNegativeTest(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(1000, 9999), faker.name().username(), shortPassword, false, false, false, false, true, false);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Test(description = "PIM negative test with password more than 64 characters")
    public void passwordIsMoreThan64Characters() {
        String longPassword = faker.lorem().characters(65); // 65 символов
        PIMNegativeTest(faker.name().firstName(), faker.name().lastName(), faker.number().numberBetween(1000, 9999), faker.name().username(), longPassword, false, false, false, false, false, true);
    }
}
