package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class MyInfoPage extends BasePage {

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='oxd-layout-context']")
    WebElement header;
    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstName;
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[1]/div[1]/div[1]/div[2]/input[1]")
    WebElement employeeId;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[2]/div[1]/div[2]/input[1]")
    WebElement otherId;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[2]/div[1]/div[1]/div[2]/input[1]")
    WebElement licenseNumber;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[2]/div[1]/div[2]/div[1]/div[1]/i[1]")
    WebElement expiryDataCalendar;
    @FindBy(xpath = "//label[text()='Nationality']/following::div[@class='oxd-select-wrapper'][1]")
    WebElement nationality;
    @FindBy(xpath = "//label[text()='Marital Status']/following::div[@class='oxd-select-wrapper'][1]")
    WebElement maritalStatus;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]/i[1]")
    WebElement dataOfBirth;
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
    WebElement savePersonalDetails;



    @Step("Wait for the MyInfo page to fully load")
    public void waitForLoadingMyInfoPage() {
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
        getWait().forVisibility(firstName);
        Assert.assertTrue(firstName.isDisplayed());
        getWait().forVisibility(lastName);
        Assert.assertTrue(lastName.isDisplayed());
        getWait().forVisibility(employeeId);
        Assert.assertTrue(employeeId.isDisplayed());
    }
    @Step("Select expiration date: month {targetMonth}, year {targetYar}, day {targetDay}")
    public void selectMonthAndDateOnExpiryData(String targetMonth, String targetYar, int targetDay) throws InterruptedException {
        getWait().forVisibility(expiryDataCalendar);
        expiryDataCalendar.click();
        Thread.sleep(1000);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        while (true) {
            Thread.sleep(500);
            String currentMonth = driver.findElement(By.xpath("//*[@class='oxd-calendar-selector-month']")).getText();
            String currentYears = driver.findElement(By.xpath("//*[@class='oxd-calendar-selector-year-selected']")).getText();
            if (currentMonth.equals(targetMonth) && currentYears.equals(targetYar)) {
                break;
            }
            int currentMonthIndex = Arrays.asList(months).indexOf(currentMonth);
            int targetMonthIndex = Arrays.asList(months).indexOf(targetMonth);
            if (Integer.parseInt(targetYar) > Integer.parseInt(currentYears)) {
                WebElement right = driver.findElement(By.xpath("//*[@class='oxd-date-input-calendar']//*[@class='oxd-icon bi-chevron-right']"));
                getWait().forVisibility(right);
                right.click();
            } else if (Integer.parseInt(targetYar) < Integer.parseInt(currentYears)) {

                WebElement left = driver.findElement(By.xpath("//*[@class='oxd-date-input-calendar']//*[@class='oxd-icon bi-chevron-left']"));
                getWait().forVisibility(left);
                left.click();
            } else {
                if (targetMonthIndex > currentMonthIndex) {
                    driver.findElement(By.xpath("//*[@class='oxd-date-input-calendar']//*[@class='oxd-icon bi-chevron-right']")).click();
                } else if (targetMonthIndex < currentMonthIndex) {
                    driver.findElement(By.xpath("//*[@class='oxd-date-input-calendar']//*[@class='oxd-icon bi-chevron-left']")).click();
                }
            }
            Thread.sleep(1000);

        }
        WebElement days = driver.findElement(By.xpath("//div[@class='oxd-calendar-date' and text()='" + targetDay + "']"));
        getWait().forVisibility(days);
        days.click();

    }
    @Step("Select gender {gender}")
    public void selectGender(String gender){
        WebElement element = driver.findElement(By.xpath("//*[text()='"+gender+"']"));
        element.click();
    }
    @Step("Fill in personal data: First Name: {name}, Last Name: {lasstname}, Employee ID: {empId}, Other ID: {otherIDD}, Driver's License: {driversLicense}")
    public void filPersonalData(String name,String lasstname,String empId,int otherIDD,int driversLicense)  {
       deleteText(firstName);
       firstName.sendKeys(name);
       deleteText(lastName);
       lastName.sendKeys(lasstname);
       deleteText(employeeId);
       employeeId.sendKeys(empId);
       deleteText(otherId);
       otherId.sendKeys(String.valueOf(otherIDD));
       deleteText(licenseNumber);
       licenseNumber.sendKeys(String.valueOf(driversLicense));
    }
    @Step("Select nationality: {national}")
    public void selectOptionInNationalityDropDown(String national){
        nationality.click();
        List<WebElement> options = driver.findElements(By.xpath("//*[@role='option']"));
        for (int i =0;i<options.size();i++){
            String option = options.get(i).getText();
            if (option.equals(national)){
                options.get(i).click();
                break;
            }
        }
    }
    @Step("Select marital status: {status}")
    public void selectOptionIMaritalStatusDropDown(String status){
        maritalStatus.click();
        List<WebElement> options = driver.findElements(By.xpath("//*[@role='option']"));
        for (int i = 0;i<options.size();i++){
            String option = options.get(i).getText();
            if (option.equals(status)){
                options.get(i).click();
                break;
            }
        }
    }
    @Step("Select birth date: month {monthss}, year {yaer}, day {day}")
    public void selectMonthAndDateOnBirthData(String monthss,String yaer,String day) throws InterruptedException {
        dataOfBirth.click();
        driver.findElement(By.xpath("//*[@class='oxd-calendar-selector-month-selected']")).click();
        List<WebElement> months=driver.findElements(By.xpath("//*[@class='oxd-calendar-dropdown--option']"));
        for (int i = 0;i<months.size();i++){
            String options = months.get(i).getText();
            if (options.equals(monthss)){
                months.get(i).click();
                break;
            }
        }
        driver.findElement(By.xpath("//*[@class='oxd-calendar-selector-year']")).click();
        List<WebElement> years = driver.findElements(By.xpath("//*[@class='oxd-calendar-dropdown--option']"));
        for (int i =0;i<years.size();i++){
            String optionsYear = years.get(i).getText();
            if (optionsYear.equals(yaer)){
                years.get(i).click();
                break;
            }
        }
        WebElement days = driver.findElement(By.xpath("//*[text()='"+day+"']"));
        getWait().forVisibility(days);
        days.click();
    }
    @Step("Save personal details")
    public void savePersonalDetails() throws InterruptedException {
        WebElement saveButton = driver.findElement(By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButton);
    }
    @Step("Upload photo and save")
    public void uploadPhoto(String filePath,String textComent) throws InterruptedException {
        WebElement attachmentButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--text']"));
        getWait().forVisibility(attachmentButton);
        attachmentButton.click();
        WebElement selectFileButton = driver.findElement(By.xpath("//*[@class='oxd-file-input']"));
        selectFileButton.sendKeys(filePath);
        WebElement textInput = driver.findElement(By.xpath("//*[@placeholder='Type comment here']"));
        textInput.sendKeys(textComent);
        WebElement saveButton = driver.findElement(By.xpath("//div[@class='orangehrm-attachment']//button[@type='submit'][normalize-space()='Save']"));
        saveButton.click();
    }
    @Step("Check if success message is displayed")
    public void successSavedIsDisplayed(){
        WebElement successMessage = driver.findElement(By.xpath("//*[@id='oxd-toaster_1']"));
        getWait().forVisibility(successMessage);
        Assert.assertTrue(successMessage.isDisplayed());
    }
    @Step("Get username from user dropdown")
    public String getUserName () throws InterruptedException {
        WebElement userName = driver.findElement(By.xpath("//*[@class='oxd-userdropdown-tab']"));
        getWait().forVisibility(userName);
        return userName.getText();

    }
    @Step("Refresh the page")
    public void refreshPage(){
        driver.navigate().refresh();
    }

}
