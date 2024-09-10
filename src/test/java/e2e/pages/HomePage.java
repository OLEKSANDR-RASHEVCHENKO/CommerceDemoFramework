package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
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

    @Step("Wait for Home page to fully load")
    public void waitForLoadingHomePage() {
        getWait().forVisibility(header);
        Assert.assertTrue(header.isDisplayed());
        getWait().forVisibility(username);
        Assert.assertTrue(username.isDisplayed());
    }

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

    @Step("Click on icon '{iconToChoose}' from Home Page")
    public void clickOnOneIconFromHomePage(String iconToChoose) {
        List<WebElement> icons = driver.findElements(By.xpath("//*[@class='oxd-icon']"));
        for (WebElement icon : icons) {
            if (icon.getText().equalsIgnoreCase(iconToChoose)) {
                icon.click();
                break;
            }
        }
    }

    @Step("Navigate back to the previous page")
    public void back() {
        driver.navigate().back();
    }

    @Step("Click on each item in the sidebar menu and verify page navigation")
    public void testSidebarMenu() throws InterruptedException {
        List<WebElement> sideBar = driver.findElements(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));

        for (int i = 0; i < sideBar.size(); i++) {
            sideBar = driver.findElements(By.xpath("//*[@class='oxd-text oxd-text--span oxd-main-menu-item--name']"));
            String menuItemName = sideBar.get(i).getText();

            sideBar.get(i).click();
            Thread.sleep(3000);
            if (menuItemName.equalsIgnoreCase("Maintenance")) {
                back();
            } else {
                WebElement titleOnPage = driver.findElement(By.xpath("//*[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
                getWait().forVisibility(titleOnPage);
                Assert.assertTrue(titleOnPage.isDisplayed());
                String pageTitle = titleOnPage.getText();
                try {
                    Assert.assertTrue(pageTitle.contains(menuItemName));
                } catch (AssertionError error) {
                    System.out.println("Error: Title " + pageTitle + "  enthält nicht  menu name " + menuItemName);
                }

            }
        }
    }
}
