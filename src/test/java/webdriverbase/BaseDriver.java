package webdriverbase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseDriver {
    public static WebDriver driver;
    public void getDriver(){

        ChromeOptions options = new ChromeOptions(); //untuk headless atau tanpa eksekusi website
        options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        //driver = WebDriverManager.chromedriver().create();
    }
}
