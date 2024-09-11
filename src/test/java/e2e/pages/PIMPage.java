package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class PIMPage extends BasePage {

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement title;
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;
    @FindBy(xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//input[1]")
    WebElement employeeName;
    @FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement employeeId;
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;
    @FindBy(xpath = "//a[normalize-space()='Employee List']")
    WebElement employeeList;
    @FindBy(xpath = "//i[@class='oxd-icon bi-trash']")
    WebElement deleteButton;
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement yesDelete;


    @Step("Click on '{chooseOne}' from the side menu")
    public void clickOnOneFromSidebarMenu(String chooseOne) {
        List<WebElement> sideBar = driver.findElements(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        for (WebElement menu : sideBar) {
            if (menu.getText().equalsIgnoreCase(chooseOne)) {
                menu.click();
                break;
            }
        }
    }

    @Step("Wait for the PIM page to load")
    public void waitForLoadingPIMPage() {
        getWait().forVisibility(title);
        Assert.assertTrue(title.isDisplayed());
        getWait().forVisibility(addButton);
        Assert.assertTrue(addButton.isDisplayed());
        getWait().forVisibility(employeeId);
        Assert.assertTrue(employeeId.isDisplayed());
        getWait().forVisibility(employeeName);
        Assert.assertTrue(employeeName.isDisplayed());
        getWait().forVisibility(searchButton);
        Assert.assertTrue(searchButton.isDisplayed());
        getWait().forVisibility(employeeList);
        Assert.assertTrue(employeeList.isDisplayed());
    }

    @Step("Get the title of the PIM page")
    public String getTitle() {
        String titleFromPIMPage = title.getText();
        return titleFromPIMPage;
    }

    @Step("Click on the Add button")
    public void clickOnAddButton() {
        addButton.click();
    }

    @Step("Set employee data to search for '{name}'")
    public void setDataToFoundEmployee(String name) {
        employeeName.sendKeys(name);
        searchButton.click();
    }

    @Step("Get employee ID: {id}")
    public String getId(String id) {
        WebElement ID = driver.findElement(By.xpath("//div[contains(text(),'" + id + "')]"));
        getWait().forVisibility(ID);
        String getId = ID.getText();
        return getId;
    }

    @Step("Get first name: {name}")
    public String getFirstName(String name) {
        WebElement nameFirst = driver.findElement(By.xpath("//div[contains(text(),'" + name + "')]"));
        getWait().forVisibility(nameFirst);
        String getName = nameFirst.getText();
        return getName;
    }

    @Step("Get last name: {lastname}")
    public String getLastName(String lastname) {
        WebElement nameLast = driver.findElement(By.xpath("//div[contains(text(),'" + lastname + "')]"));
        getWait().forVisibility(nameLast);
        String getLastName = nameLast.getText();
        return getLastName;
    }

    @Step("Delete employee")
    public void deleteUser() {
        deleteButton.click();
        getWait().forVisibility(yesDelete);
        yesDelete.click();
    }

    @Step("Check for error message after deleting the user")
    public void errorMessageAfterDeletingUser() {
        WebElement error = driver.findElement(By.xpath("//*[@class='oxd-toast-start']"));
        getWait().forVisibility(error);
        Assert.assertTrue(error.isDisplayed());
    }

    @Step("Click the search button")
    public void clickSearch() {
        getWait().forVisibility(searchButton);
        searchButton.click();
    }


}
