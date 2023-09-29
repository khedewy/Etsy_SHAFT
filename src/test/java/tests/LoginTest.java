package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

import java.io.IOException;

public class LoginTest extends TestBase {

    HomePage homePage;
    RegisterPage register;
    LoginPage loginPage;
    SHAFT.TestData.JSON registerData;
    String currentTime = String.valueOf(System.currentTimeMillis());

    @Test
    public void navigateToRegisterPage() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData()  {
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        register = new RegisterPage(driver);
        register.enterRegisterData(registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("name"),registerData.getTestData("password"));
        Assert.assertEquals(register.getRegisterAssertionMessage(),"MahmoudKhedewy");
    }

    @Test(priority = 2)
    public void logOut(){
        homePage = new HomePage(driver);
        homePage.logOut();
    }

    @Test(priority = 3)
    public void navigateToLogin(){
        homePage = new HomePage(driver);
        homePage.login();
    }

    @Test(priority = 4)
    public void enterLoginData() throws IOException, ParseException {
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        loginPage = new LoginPage(driver);
        loginPage.enterLoginData(registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("password"));
        Assert.assertEquals(loginPage.getLoginAssertionMessage(),"MahmoudKhedewy");
    }

}
