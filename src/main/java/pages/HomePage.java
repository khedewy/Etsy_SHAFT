package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class HomePage {
    private final SHAFT.GUI.WebDriver driver;

    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By AccountManger = By.xpath("//button[@class='wt-btn wt-btn--small wt-btn--transparent wt-mr-xs-1 inline-overlay-trigger signin-header-action select-signin header-button']");
    private final By registerButton = By.cssSelector("button.wt-btn--secondary:nth-child(2)");
    private final By logOutMenu = By.xpath("//button[@aria-describedby='ge-tooltip-label-you-menu']");
    private final By logoutButton = By.xpath("//p[text()='Sign out']");
    private final By searchBox = By.id("global-enhancements-search-query");
    private final By searchButton = By.xpath("//button[@value='Search']");


    public RegisterPage navigateToRegisterPage() {
        driver.element().click(AccountManger);
        driver.element().click(registerButton);
        return new RegisterPage(driver);
    }

    public void logOut(){
        driver.element().click(logOutMenu);
        driver.element().click(logoutButton);
    }

    public LoginPage login(){
        driver.element().click(AccountManger);
        return new LoginPage(driver);
    }

    public void searchForProduct(String product){
        driver.element().type(searchBox,product);
        driver.element().click(searchButton);
    }
}
