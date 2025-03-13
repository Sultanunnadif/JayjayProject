package webdriverbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class BaseDriver {
    public static WebDriver driver;
    public void getDriver(){
        driver = WebDriverManager.chromedriver().create();
    }
}
