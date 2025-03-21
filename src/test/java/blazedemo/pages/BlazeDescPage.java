package blazedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BlazeDescPage {
    By ProductDescription = By.id("myTabContent");
    By ProductCart = By.xpath("//tbody[@id='tbodyid']//tr/td[2]");
    WebDriver driver;

    public BlazeDescPage(WebDriver driver){
        this.driver = driver;
    }
    public void validateProductDescription(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productElement = wait.until(ExpectedConditions.presenceOfElementLocated(ProductDescription));
        //String actualText = productElement.getText();
        //System.out.println("Actual Text: " + actualText);
        Assert.assertTrue(productElement.isDisplayed());
        Assert.assertEquals("Product description\n" +
                "The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.", productElement.getText());
    }
    public void validatecartproduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement productElement = wait.until(ExpectedConditions.presenceOfElementLocated(ProductCart));
        //String actualText = productElement.getText();
        //System.out.println("Actual Text: " + actualText);
        Assert.assertTrue(productElement.isDisplayed());
        Assert.assertEquals("Samsung galaxy s6", productElement.getText());
    }
}
