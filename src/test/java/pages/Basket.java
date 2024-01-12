package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utilities.Action;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class Basket {

    public Basket(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //public final By acceptCookies = By.xpath("//button[contains (., 'Tümünü kabul et')]");
    public final By acceptNotifications = By.cssSelector("div#ins-editable-button-1580496494");

    public final By acceptCookies = By.id("31cd32c1-b03e-4463-948d-1347667e64a4");

    public final By corporate_Stores_Link = By.xpath("//div[@class='fmi-menu']//a[@href=\"/magaza-bul\"]");

    public final By completeShoppingButton = By.xpath("//a[@class='btn btn-primary js-checkout-controls']");

    int productIndex;

    public void kabulEdilir(){
        Action.clickElement(acceptNotifications);
        // Action.clickElement(acceptCookies);
        WebElement elemShadowRoot = Driver.getDriver().findElement(By.tagName("efilli-layout-dynamic"));
        Action.clickShadowElement(acceptCookies,elemShadowRoot);
    }

    public void increaseCheapestProductByOne() throws InterruptedException {
        List<String> priceValue = new ArrayList<String>();
        List<WebElement> prices = Driver.getDriver().findElements(By.cssSelector("div.prd-prices"));

        for(int i=0;i<prices.size();i++)
            priceValue.add(prices.get(i).getText());

        int size1 = priceValue.size();
        Float[] arr = new Float [size1];
        for(int i=0; i<size1; i++) {
            String newStr = priceValue.get(i);
            String[] strArry = newStr.split(" ",2);
            //String str = strArry[0].replaceAll("[^a-zA-Z0-9]","");
            String str = strArry[0].replace(".","");
            String str2 = str.replace(",",".");
            arr[i] = Float.parseFloat(str2);
        }

        float minValue = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] < minValue){
                minValue = arr[i];
            }
            productIndex = i;
        }

        String s = Float.toString(minValue);

        List<WebElement> cartProducts =  Driver.getDriver().findElements(By.cssSelector("div.cart-row"));
        List <WebElement> ara =  Driver.getDriver().findElements(By.xpath("(//button[@class='plus  quantity-right-plus'])"));
        WebElement arabul =   ara.get(productIndex);

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("arguments[0].scrollIntoView({behavior: ‘auto’, block: ‘center’, inline: ‘center’})", element);
        js.executeScript("arguments[0].scrollIntoView(true)", arabul);
        Thread.sleep(5000);
        arabul.click();


    }


    public void clickCompleteShopping() {
        Action.clickElement(completeShoppingButton);
    }
}
