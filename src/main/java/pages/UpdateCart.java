package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class UpdateCart {
    private final SHAFT.GUI.WebDriver driver;


    public UpdateCart(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By AddToCartButton = By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[3]/div[9]/div[2]/div[11]/div[1]/div/div/ol/li[1]/div/div/div[1]/span[1]/form/button/span[2]");
    private final By style = By.id("wt-cart-select-style");
    private final By size = By.id("wt-cart-select-size");
    private final By saveButton = By.xpath("//*[@id=\"cart-edit-panel-overlay\"]/div/button[2]");
    private final By AssertionMessage = By.xpath("//a[@class='wt-text-link-no-underline wt-text-title']");
    private final By quantityList = By.name("listing-quantity");
    private final By deleteItem = By.xpath("//*[@id=\"multi-shop-cart-list\"]/div[1]/div[1]/ul/li[1]/div/div/ul/li/div/div[1]/div/div/div/div[1]/a/span");
    private final By deleteItemAssertion = By.xpath("//*[@id=\"checkout\"]/div[2]/div[4]/div[2]/div/h1");



    public void addToCart() throws InterruptedException {
        driver.element().click(AddToCartButton);
        driver.element().select(style,"Crew Neck");
        driver.element().select(size,"M US letter");
        driver.element().click(saveButton);
    }

    public void updateQuantity(){
        driver.element().select(quantityList,"2");

    }

    public String getAssertionMessage() {
        return driver.element().getText(AssertionMessage);
    }

    public void deleteItem() {
        driver.element().click(deleteItem);
    }

    public String getDeleteItemAssertionMessage() {
        return driver.element().getText(deleteItemAssertion);
    }

}
