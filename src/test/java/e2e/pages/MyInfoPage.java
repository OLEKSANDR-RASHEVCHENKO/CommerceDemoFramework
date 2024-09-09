package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

public class MyInfoPage extends BasePage {

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='oxd-layout-context']")
    WebElement header;
    @FindBy(xpath = "//input[@placeholder='First Name']")
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
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']")
    WebElement nationality;
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-up-fill oxd-select-text--arrow']")
    WebElement maritalStatus;
    @FindBy(xpath = "//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='orangehrm-card-container']/div[@class='orangehrm-edit-employee']/div[@class='orangehrm-edit-employee-content']/div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-3 orangehrm-full-width-grid']/div[1]/div[1]/div[2]/div[1]/div[1]/i[1]")
    WebElement dataOfBirth;
    @FindBy(xpath = "//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']")
    WebElement savePersonalDetails;



    @Step("Wait for loading MyInfo page")
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
    @Step("Select data on Expiry option")
    public void selectMonthAndDateOnExpiryData(String targetMonth, String targetYar, int targetDay) throws InterruptedException {
        getWait().forVisibility(expiryDataCalendar);
        expiryDataCalendar.click();
        Thread.sleep(1000);
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        while (true) {
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
        days.click();

    }
    @Step("Select gender")
    public void selectGender(String gender){
        WebElement element = driver.findElement(By.xpath("//*[text()='"+gender+"']"));
        element.click();
    }
    @Step("Fill all  and save all data on MyInfo page")
    public void filPersonalData(String name,String lasstname,String empId,int otherIDD,int driversLicense,String targetMonth, String targetYar, int targetDay,String nati) throws InterruptedException {
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
       selectMonthAndDateOnExpiryData(targetMonth,targetYar,targetDay);
       Select national = new Select(nationality);
       national.selectByVisibleText(nati);
       Select marit = new Select(maritalStatus);
       marit.selectByVisibleText("Other");
       selectGender("Male");
        savePersonalDetails.click();
    }

}
