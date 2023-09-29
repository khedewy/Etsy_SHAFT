package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class RegisterPage {

    private final SHAFT.GUI.WebDriver driver;

    public RegisterPage(SHAFT.GUI.WebDriver driver){
        this.driver= driver;
    }

    private final By emailTxt = By.xpath("//*[@id=\"join_neu_email_field\"]");
    private final By firstNameTxt = By.id("join_neu_first_name_field");
    private final By passwordTxt = By.id("join_neu_password_field");
    private final By registerButton = By.xpath("//button[@value='register']");
    private final By AssertionMessage = By.linkText("MahmoudKhedewy");

    public void enterRegisterData(String email, String name, String password) {
        driver.element().type(emailTxt,email);
        driver.element().type(firstNameTxt,name);
        driver.element().type(passwordTxt,password);
        driver.element().click(registerButton);
    }

    public String getRegisterAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }
}
