package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import pages.Page;
import utilities.Driver;

import static utilities.Driver.getDriver;

public class Steps {

    Page page = new Page();

    @Given("Cerezler kabul edilir")
    public void cerezlerKabulEdilir(){
        page.kabulEdilir();
    }


    @When("Footerdan “Kurumsal\\/Magazalarimiz” tiklanir")
    public void footerdanKurumsalMagazalarimizTiklanir() throws InterruptedException {
        page.clickCorporate_Stores_Link();
    }
}
