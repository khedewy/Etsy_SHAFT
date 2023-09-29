package pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


import java.awt.*;
import java.awt.event.KeyEvent;


public class HelpCenter {
    private final SHAFT.GUI.WebDriver driver;
    Robot robot;
    public HelpCenter(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    private final By helpCenterLink = By.linkText("Go to Help Center");
    private final By searchBox = By.xpath("/html/body/main/section/header/div/div/div[2]/div/form/div/input");
    private final By AssertionMessage = By.xpath("//h1[@class='wt-text-title-03 wt-mt-xs-4 wt-mb-xs-5']");


    public void navigateToHelpCenter(){
        driver.element().click(helpCenterLink);
    }

    public void AskYourQuestion(String question) throws AWTException {
        driver.element().type(searchBox,question);
        robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
    }

    public String getAssertionMessage(){
        return driver.element().getText(AssertionMessage);
    }
}
