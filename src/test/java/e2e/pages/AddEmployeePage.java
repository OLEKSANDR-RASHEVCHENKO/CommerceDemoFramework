package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddEmployeePage extends BasePage {
    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h6[normalize-space()='Add Employee']")
    WebElement title;
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Middle Name']")
    WebElement middleName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement employeeId;
    @FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
    WebElement radioButtonLoginDetails;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/form[@class='oxd-form']/div[@class='orangehrm-employee-container']/div[@class='orangehrm-employee-form']/div[@class='oxd-form-row']/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement userName;
    @FindBy(xpath = "//label[normalize-space()='Disabled']")
    WebElement disableButton;
    @FindBy(xpath = "//label[normalize-space()='Enabled']")
    WebElement enabledButton;
    @FindBy(xpath = "//label[text()='Password']/following::input[@type='password'][1]")
    WebElement password;
    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[@type='password'][1]")
    WebElement confirmPassword;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;
    @FindBy(xpath = "//*[@class='oxd-file-input']")
    WebElement uploadPhoto;
    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    WebElement employeeList;

    //Error Message for fields
    @FindBy(xpath = "//div[@class='oxd-grid-1 orangehrm-full-width-grid']//div[@class='oxd-input-group']//div[1]//span[1]")
    WebElement firstnameErrorMessage;
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[3]//span[1]")
    WebElement lastNameErrorMessage;
    @FindBy(xpath = "//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required']")
    WebElement userNameErrorMessage;
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message'][normalize-space()='Required']")
    WebElement passwordErrorMessage;
    @FindBy(xpath = "//span[normalize-space()='Passwords do not match']")
    WebElement confirmPasswordErrorMessage;

    //characters Error messages
    @FindBy(xpath = "//div[@class='oxd-grid-1 orangehrm-full-width-grid']//div[@class='oxd-input-group']//div[1]//span[1]")
    WebElement maxCharactersFirstNameError;
    @FindBy(xpath = "//div[@class='oxd-form-row']//div[3]//span[1]")
    WebElement maxCharactersLastNameError;
    @FindBy(xpath = "//span[normalize-space()='Should be at least 5 characters']")
    WebElement minCharactersUserNameError;
    @FindBy(xpath = "//span[normalize-space()='Should not exceed 40 characters']")
    WebElement maxCharactersUserNameError;
    @FindBy(xpath = "//span[normalize-space()='Should have at least 7 characters']")
    WebElement minCharactersPasswordError;
    @FindBy(xpath = "//span[normalize-space()='Should not exceed 64 characters']")
    WebElement maxCharactersPasswordEmail;

    @Step("Wait for the Add Employee page to load")
    public void waitForLoadingAddEmployee() {
        getWait().forVisibility(title);
        getWait().forVisibility(firstName);
        getWait().forVisibility(middleName);
        getWait().forVisibility(lastName);
        getWait().forVisibility(employeeId);
        getWait().forVisibility(saveButton);
    }

    @Step("Set employee data: First name {firstNam}, Last name {lastNam}, ID {id}, Username {username}, Password {pass}")
    public void setUserData(String firstNam, String lastNam, int id, String photoPath, String username, String pass, String confirmPass) {
        firstName.sendKeys(firstNam);
        lastName.sendKeys(lastNam);
        employeeId.sendKeys(String.valueOf(id));
        uploadPhoto.sendKeys(photoPath);
        radioButtonLoginDetails.click();
        getWait().forVisibility(userName);
        getWait().forVisibility(password);
        getWait().forVisibility(confirmPassword);
        getWait().forVisibility(saveButton);
        userName.sendKeys(username);
        password.sendKeys(pass);
        confirmPassword.sendKeys(confirmPass);
        saveButton.click();
    }

    @Step("Verify first name error message")
    public void firstNameErrorMessage() {
        getWait().forVisibility(firstnameErrorMessage);
    }

    @Step("Verify last name error message")
    public void lastnameErrorMessage() {
        getWait().forVisibility(lastNameErrorMessage);
    }

    @Step("Verify username error message")
    public void usernameErrorMessage() {
        getWait().forVisibility(userNameErrorMessage);
    }

    @Step("Verify password error message")
    public void passwordErrormessage() {
        getWait().forVisibility(passwordErrorMessage);
    }

    @Step("Verify confirm password error message")
    public void confirmPasswordErrormessage() {
        getWait().forVisibility(confirmPasswordErrorMessage);
    }

    @Step("Verify max characters in first name error message")
    public void maxCharactersFirstnameError() {
        getWait().forVisibility(maxCharactersFirstNameError);
    }

    @Step("Verify max characters in last name error message")
    public void maxCharactersLastnameError() {
        getWait().forVisibility(maxCharactersLastNameError);
    }

    @Step("Verify min characters in username error message")
    public void minCharactersUsernameError() {
        getWait().forVisibility(minCharactersUserNameError);
    }

    @Step("Verify max characters in username error message")
    public void maxCharactersUsernameError() {
        getWait().forVisibility(maxCharactersUserNameError);
    }

    @Step("Verify min characters in password error message")
    public void MinCharactersPasswordError() {
        getWait().forVisibility(minCharactersPasswordError);
    }

    @Step("Verify max characters in password error message")
    public void MaxCharactersPasswordEmail() {
        getWait().forVisibility(maxCharactersPasswordEmail);
    }

    @Step("Click on Employee List")
    public void clickOnEmployeeList() {
        employeeList.click();
    }

    @Step("Check if success message is displayed")
    public void successSavedIsDisplayed() {
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='oxd-toaster_1']"));
        getWait().forVisibility(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
    }

    @Step("Get the title of the page")
    public String getTitle() {
        String titleOnPage = title.getText();
        return titleOnPage;
    }


}
