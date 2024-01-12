package utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Action {

    public static void clickElement(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.click();
    }

    public static void clickElementAfterPageRefresh(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        try {
            WebElement element = Driver.getDriver().findElement(xpath);
            element.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement element = Driver.getDriver().findElement(xpath);
            element.click();
        }

    }

    public static void JSClickElement(By xpath){
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
            WebElement element = Driver.getDriver().findElement(xpath);
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement element = Driver.getDriver().findElement(xpath);
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
        }


    }


    public static void scrollUntilVisible(By xpath) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("arguments[0].scrollIntoView({behavior: ‘auto’, block: ‘center’, inline: ‘center’})", element);
        js.executeScript("arguments[0].scrollIntoView(true)", element);
        //js.executeScript("arguments[0].click();", element);
    }

    public static void sendKeysElement(By xpath, String key){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        element.sendKeys(key);
    }

    public static String getTextElement(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element = Driver.getDriver().findElement(xpath);
        return element.getText();
    }

    public static void pressEnter(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        element.sendKeys(Keys.ENTER);

    }

    public static void  checkElementText(By xpath, String text){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        Assert.assertEquals(element.getText(),text);
    }

    public static void elementPresent(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
    }
    public static void elementNotPresent(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
    }

    public static void  checkElementValue(By xpath, String text){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        Assert.assertEquals(element.getAttribute("value"),text);
    }

    public static void clearText(By xpath){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
        WebElement element=Driver.getDriver().findElement(xpath);
        element.clear();
    }



    public static void navigateBack(){
         Driver.getDriver().navigate().back();
    }

    public static void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2000)", "");
    }




    public static void clickShadowElement(By acceptCookies, WebElement elemShadowRoot) {

        SearchContext shadowRoot0 = (SearchContext) ((JavascriptExecutor) Driver.getDriver()).executeScript (
                "return arguments[0].shadowRoot", elemShadowRoot);

        shadowRoot0.findElement(acceptCookies).click();
    }
}
