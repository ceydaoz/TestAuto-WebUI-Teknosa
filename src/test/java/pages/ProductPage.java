package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

public class ProductPage {

    public ProductPage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    public final By firstProduct = By.xpath("(//div[@class='o-producttilerebrush js-o-producttilerebrush'])[1]");

    public void clickFirstProduct() {
        Action.clickElement(firstProduct);
    }
}
