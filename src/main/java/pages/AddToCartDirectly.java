package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class AddToCartDirectly {
    private final SHAFT.GUI.WebDriver driver;

    public AddToCartDirectly(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By AddToCartButton =By.xpath("//button[@aria-describedby='ad-listing-title-1518179088']");
    private final By assertionMessage = By.xpath("//a[@data-title='Comfort Colors 1717 Black Unisex Tshirt mockup, mens fashion black oversized t-shirt mock up, minimalist shirt male model mock-up for POD']");

    public void addProductToCart(){
        driver.element().click(AddToCartButton);
    }

    public String getAssertionMessage(){
        return driver.element().getText(assertionMessage);
    }
}
