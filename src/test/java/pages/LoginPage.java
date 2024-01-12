package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public final By continueAsGuestButton = By.xpath("//a[@class='btn btn-outline-dark button-guestForm']");

    public final By guestEmailField = By.xpath("//input[@id='guest.email']");

    public void continueAsGuest(){

        Action.clickElement(continueAsGuestButton);

    }


    public void enterEmail() {
        Action.sendKeysElement(guestEmailField, "jondoe@abc.com");
    }
}
