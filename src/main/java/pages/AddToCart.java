package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
public class AddToCart {
    private final SHAFT.GUI.WebDriver driver;

    public AddToCart(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By product = By.id("listing-title-1520960234");
    private final By addToCartButton = By.xpath("//*[@id=\"listing-page-cart\"]/div[6]/div[1]/div[3]/div[2]/form/div/button");
    private final By viewCart = By.xpath("//a[@href='/cart']");




    public void addToCart() throws InterruptedException {
        String windowHandle = driver.browser().getWindowHandle();
        driver.element().click(product);
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        driver.element().click(addToCartButton);
        driver.element().click(viewCart);
        driver.browser().switchToWindow(windowHandle); // switch back to the original window

}}
