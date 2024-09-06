package e2e.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class OrangePage extends BasePage{

    public OrangePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@class='navbar-brand nav-logo']")
    WebElement headerOnOrangePage;
    @Step("Wait for loading Orange page")
    public void waitForOrangePage(){
        getWait().forVisibility(headerOnOrangePage);

    }
    public String getTitle(){
        String title = driver.getTitle();
        return title;
    }
@Step("Get current Url on Orange page")
    public String getCurrentUrl(){
        String currentUrl=driver.getCurrentUrl();
        return currentUrl;
    }
    public String getWindow(){
        String windowHandle=driver.getWindowHandle();
        return windowHandle;


}}