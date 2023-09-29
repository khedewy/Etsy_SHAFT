package tests;


import com.shaft.driver.SHAFT;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToFavorite;
import pages.HomePage;
import pages.RegisterPage;

import java.io.IOException;

public class AddToFavoriteTest extends TestBase{
    HomePage homePage;
    AddToFavorite add;
    RegisterPage register;
    SHAFT.TestData.JSON registerData;
    String currentTime = String.valueOf(System.currentTimeMillis());

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

    @Test(priority = 2)
    public void navigateToProducts(){
        homePage = new HomePage(driver);
        homePage.searchForProduct("gold rings");
    }

    @Test(priority = 3)
    public void addToFavorite(){
        add = new AddToFavorite(driver);
        add.addToFavorite();
    }
}
