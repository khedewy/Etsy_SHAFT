package tests;

import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterTest extends TestBase{
    HomePage homePage;
    RegisterPage register;
    String currentTime = String.valueOf(System.currentTimeMillis());
    SHAFT.TestData.JSON registerData;

    @Test
    public void navigateToRegisterPage() throws InterruptedException {

        homePage = new HomePage(driver);
        homePage.navigateToRegisterPage();
    }

    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        registerData = new SHAFT.TestData.JSON("src/test/resources/testDataFiles/registerData.json");
        register = new RegisterPage(driver);
        register.enterRegisterData(registerData.getTestData("email")+currentTime+"@gmail.com",
                registerData.getTestData("name"),registerData.getTestData("password"));
        Assert.assertEquals(register.getRegisterAssertionMessage(),"MahmoudKhedewy");
    }
}
