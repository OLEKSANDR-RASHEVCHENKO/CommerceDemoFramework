package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrangePage extends BasePage {

    public OrangePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='navbar-brand nav-logo']")
    WebElement headerOnOrangePage;

    @Step("Wait for Orange page to fully load")
    public void waitForOrangePage() {
        getWait().forVisibility(headerOnOrangePage);

    }
    @Step("Get the page title")
    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    @Step("Get the current URL of the Orange page")
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }
    @Step("Get the window handle")
    public String getWindow() {
        String windowHandle = driver.getWindowHandle();
        return windowHandle;


    }
}
