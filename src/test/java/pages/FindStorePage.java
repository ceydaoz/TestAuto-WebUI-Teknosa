package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Action;
import utilities.Driver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FindStorePage {

    public FindStorePage() {
        PageFactory.initElements(Driver.getDriver() , this);
    }

    public final By foundStores =  By.cssSelector("div.stp-list-items");

    public void selectCombobox_City_District() {

        Select city = new Select(Driver.getDriver().findElement(By.name("cities")));
        city.selectByVisibleText("Ankara");

        Select towns = new Select(Driver.getDriver().findElement(By.name("towns")));
        towns.selectByVisibleText("çankaya");

    }

    public void printFoundStores() {

        WebElement e = Driver.getDriver().findElement(foundStores);
        String s = e.getText();
        File f = new File("savetxt.txt");
        try{
            FileUtils.writeStringToFile(f, s, Charset.defaultCharset());
        }catch(IOException exc){
            exc.printStackTrace();
        }

    }
}
