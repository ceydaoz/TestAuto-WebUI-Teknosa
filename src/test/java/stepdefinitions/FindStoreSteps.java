package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.FindStorePage;
import pages.Page;

public class FindStoreSteps {

    Page page = new Page();
    FindStorePage store = new FindStorePage();

   @When("Footerdan KurumsalMagazalarimiz tiklanir")
   public void kurumsal_MagazalarTiklanir() throws InterruptedException {
       page.clickCorporate_Stores_Link();
   }

    @And("Magaza Bulucu formundan il ve ilce secimi yapilir")
    public void magazaBulucuFormundanIlVeIlceSecimiYapilir() {
       store.selectCombobox_City_District();
    }

    @And("Magaza listesi bastirilir")
    public void magazaListesiBastirilir() {
       store.printFoundStores();
    }


}
