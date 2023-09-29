package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class AddToFavorite {
    private final SHAFT.GUI.WebDriver driver;

    public AddToFavorite(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private final By product = By.id("listing-title-1520960234");
    private final By addToFavorite = By.xpath("//button[@class='wt-btn wt-btn--transparent wt-width-full wt-justify-content-center']");
    private final By doneButton = By.xpath("//button[@class='wt-btn wt-btn--primary wt-pr-md-7 wt-pl-md-7']");


    public void addToFavorite(){

        String windowHandle = driver.browser().getWindowHandle(); //store the current window handle
        // Action to open a new window or tab
        driver.element().click(product);
        Object[] handles = driver.getDriver().getWindowHandles().toArray(); // get array to store the windows handles for all windows/tabs opened in the session
        driver.browser().switchToWindow(handles[1].toString());
        driver.element().click(addToFavorite);
        driver.element().click(doneButton);
        // to switch to a the new window/tab
        driver.browser().switchToWindow(windowHandle); // switch back to the original window

}}

