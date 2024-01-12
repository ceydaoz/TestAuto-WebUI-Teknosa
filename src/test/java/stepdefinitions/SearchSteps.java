package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class SearchSteps {

    SearchPage searchPage = new SearchPage();


    @When("Arama ikonuna basilir")
    public void aramaIkonunaBasilir() {
        searchPage.clickSearchButton();
    }

    @And("Arama kutusuna {string} yazilir ve entera basilir")
    public void aramaKutusunaYazildiveGonderildi(String data) {
        searchPage.sendKeysToSearchArea(data);
    }

    @And("Arama sonucu basligi {string} ile kontrol edilir")
    public void aramaSonucuBasligiUrunAdiIleKontrolEdilir(String data) {
        searchPage.searchHeadingCheck(data);
    }

    @And("BlueTooth kulaklik secilir")
    public void bluetoothKulaklikSecilir() {
        searchPage.clickSubProduct();
    }

    @And("En cok satanlar filtrelenir")
    public void enCokSatanlarFiltrelenir() {
        searchPage.clickBestSellers();
    }

    @And("Ilk ve son urunler sepete eklenir")
    public void ilkVeSonUrunlerSepeteEklenir() throws InterruptedException {
        searchPage.addFirstAndLastProductsToBasket();
    }

    @And("Sepete gidilir")
    public void sepetegidilir() throws InterruptedException {
        searchPage.goToBasket();
    }
}
