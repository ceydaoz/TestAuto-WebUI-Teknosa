package stepdefinitions;

import io.cucumber.java.en.And;
import pages.ProductPage;

public class ProductSteps {

    ProductPage productPage = new ProductPage();


    @And("İlk ürünün detayına gidilir")
    public void ilkÜrününDetayınaGidilir() {
        productPage.clickFirstProduct();
    }
}
