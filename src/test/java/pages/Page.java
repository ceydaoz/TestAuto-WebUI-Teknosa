package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

public class Page {
    public Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public final By acceptNotifications = By.cssSelector("div#ins-editable-button-1580496494");

    public final By acceptCookies = By.id("31cd32c1-b03e-4463-948d-1347667e64a4");

    public final By corporate_Stores_Link = By.xpath("//div[@class='fmi-menu']//a[@href=\"/magaza-bul\"]");


    public void kabulEdilir(){
        Action.clickElement(acceptNotifications);
        WebElement elemShadowRoot = Driver.getDriver().findElement(By.tagName("efilli-layout-dynamic"));
        Action.clickShadowElement(acceptCookies,elemShadowRoot);
    }


    public void clickCorporate_Stores_Link() throws InterruptedException {
        Thread.sleep(10000);
        Action.JSClickElement(corporate_Stores_Link);

    }

}
