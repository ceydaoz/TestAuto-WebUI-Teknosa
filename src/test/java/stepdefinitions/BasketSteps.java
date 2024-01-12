package stepdefinitions;

import io.cucumber.java.en.And;
import pages.Basket;

public class BasketSteps {


    Basket basket = new Basket();

    @And("En ucuz urun adedi 2 yapilir")
    public void urunAdedi2yapilir () throws InterruptedException {
        basket.increaseCheapestProductByOne();
        basket.clickCompleteShopping();
    }


}