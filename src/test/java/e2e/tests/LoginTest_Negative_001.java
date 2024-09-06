package e2e.tests;

import e2e.pages.LoginPage;
import e2e.untils.DataProvider;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginTest_Negative_001 extends BaseTest {
    LoginPage loginPage;
    @Feature(value = "LoginNegativeTest")
    @Story(value = "User can  not login with false data")
    @Description(value = "Checking  negative Login process on opensource-demo.orangehmlive.com")
    @Severity(SeverityLevel.CRITICAL)
    @Test(dataProvider = "invalidLoginData", dataProviderClass = DataProvider.class)
    public void negativeLoginTests(String userName, String password, String scenario) {
        loginPage = new LoginPage(app.driver);
        loginPage.waitForLoadingLoginPage();
        loginPage.setLoginData(userName, password);
        if (scenario.equalsIgnoreCase("with_invalid_password") ||
                scenario.equalsIgnoreCase("with_invalid_email") ||
                scenario.equalsIgnoreCase("with_invalid_data")) {
            loginPage.invalidCredentialsIsDisplayed();
        }else if (scenario.equalsIgnoreCase("emptyData")){
            loginPage.waitForFieldsErrors();
        }
    }
}
