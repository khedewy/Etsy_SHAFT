package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = By.id("join_neu_email_field");
    private final By passwordTxt = By.id("join_neu_password_field");
    private final By signInButton = By.xpath("//button[@value='sign-in']");
    private final By AssertionMessage = By.linkText("MahmoudKhedewy");

    public void enterLoginData(String email, String password){
        driver.element().type(emailTxt,email);
        driver.element().type(passwordTxt,password);
        driver.element().click(signInButton);
    }

    public String getLoginAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }
}
