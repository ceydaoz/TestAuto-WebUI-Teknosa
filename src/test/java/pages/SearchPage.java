package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

import java.util.List;

public class SearchPage {

    public SearchPage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    public final By searchIcon = By.xpath("//em[@class='icon icon-search icon-m']");

    public final By searchInput = By.xpath("//button[@class='search-button js_search_button sbx-fake btn-search']");
    public final By searchInput2 = By.cssSelector("input#search-input");
    public final By searchHeading = By.xpath("(//h2[@class='a-heading'])[1]");

    public final By subProduct = By.xpath("//a[@href='https://www.teknosa.com/arama?s=kulakl%C4%B1k%3Arelevance%3Acategory%3A10000601']");

    public final By bestSellersFilter = By.xpath("//label[contains(text(), 'En Çok Satanlar')]");

     public final By addToCartbutton = By.cssSelector("button#addToCartButton");


    public final By basketIcon= By.cssSelector("svg.icon.icon-cart");

    public final By basketButton = By.xpath("//a[@class='btn btn-primary mmc-cta']");

    public final By lastBy =  By.xpath("//div[last()][@id='product-item']");

    public final By closeButton = By.xpath("(//div[@id='mnp-added-to-cart']//button[@class='mnp-close btn-close-layer'])[1]");


    public void clickSearchButton() {
        Action.clickElement(searchIcon);
    }

    public void sendKeysToSearchArea(String key) {
        Action.clickElement(searchInput);
        Action.sendKeysElement(searchInput2,key);
        Action.pressEnter(searchInput2);
    }

    public void searchHeadingCheck(String searchText) {
        String text = "\"" + searchText + "\" için arama sonuçları";
        Action.checkElementText(searchHeading, text);
    }


    public void clickSubProduct() {
        Action.clickElement(subProduct);

    }

    public void clickBestSellers() {
        Action.clickElement(bestSellersFilter);
    }

    public void addFirstAndLastProductsToBasket() throws InterruptedException {

        List<WebElement> productItems =  Driver.getDriver().findElements(By.cssSelector("div#product-item"));

        WebElement firstItem =  productItems.get(0);
        firstItem.click();
        Action.JSClickElement(addToCartbutton);
        Thread.sleep(5000);
        Action.clickElement(closeButton);
        Action.navigateBack();
        Thread.sleep(5000);
        Action.scrollUntilVisible(lastBy);
        Thread.sleep(5000);
        Action.clickElement(lastBy);
        Thread.sleep(5000);
        Action.JSClickElement(addToCartbutton);
        Thread.sleep(5000);
        Action.clickElement(closeButton);
        Action.navigateBack();

    }

    public void goToBasket() throws InterruptedException {
        Action.clickElement(basketIcon);
        Thread.sleep(5000);
        Action.clickElement(basketButton);
    }
}
