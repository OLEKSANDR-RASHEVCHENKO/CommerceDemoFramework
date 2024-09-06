package e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//img[@alt='client brand banner']")
    WebElement header;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement username;
    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")
    WebElement usernameDropdown;
    public void waitForLoadingHomePage(){
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
        getWait().forVisibility(username);
        Assert.assertTrue(username.isDisplayed());
    }

    public void clickOnOneFromSidebarMenu(String chooseOne) {
        List<WebElement> sideBar = driver.findElements(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
        for (WebElement menu : sideBar) {
            if (menu.getText().equalsIgnoreCase(chooseOne)) {
                menu.click();
                break;
            }
        }
    }
    public void clickOnOneIconFromHomePage(String iconToChoose){
        List<WebElement> icons = driver.findElements(By.xpath("//*[@class='oxd-icon']"));
        for (WebElement icon:icons){
            if (icon.getText().equalsIgnoreCase(iconToChoose)){
                icon.click();
                break;
            }
        }
    }
    public void back(){
        driver.navigate().back();
    }
}
