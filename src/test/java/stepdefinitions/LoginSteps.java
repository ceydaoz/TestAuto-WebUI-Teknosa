package stepdefinitions;

import io.cucumber.java.en.And;
import pages.LoginPage;
import pages.Page;

public class LoginSteps {

    LoginPage loginp = new LoginPage();

    @And("Uye olmadan devam et yapilir")
    public void uye_olmadan_devam_et_yapilir() {
        loginp.continueAsGuest();
    }


    @And("Email girilir")
    public void email_girilir(){
        loginp.enterEmail();
    }

}
