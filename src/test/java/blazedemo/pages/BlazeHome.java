package blazedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BlazeHome {
    WebDriver driver;

    By productTitlesSamsung = By.cssSelector("a[href='prod.html?idp_=1']");
    By productTittlesSony = By.cssSelector("a[href='prod.html?idp_=8']");
    By addToCartButton = By.cssSelector("a.btn.btn-success.btn-lg");
    By SigninButton = By.id("signin2");
    By SigninUsername = By.id("sign-username");
    By SigninPassword = By.id("sign-password");
    By userClickOnLogIn = By.id("login2");
    By loginusernameform = By.id("loginusername");
    By loginpasswordform = By.id("loginpassword");
    By phonecategory = By.xpath("//a[text()='Phones']");
    By laptopcategory = By.xpath("//a[text()='Laptops']");

    public BlazeHome(WebDriver driver){
        this.driver = driver;
    }

    public void BlazeDemoPage() {
        driver.get("https://www.demoblaze.com/index.html");
    }

    public void PhoneSamsungGalaxyS() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitlesSamsung));
        productTitle.click();
    }

    public void userAddToChart() {
        driver.findElement(addToCartButton).click();
    }

    public void Message(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.alertIsPresent());

        // untuk mengecek apakah alert text sesuai dengan expected message
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedMessage, alertText);

        //untuk menutup alert dengan klik OK
        driver.switchTo().alert().accept();
    }
    public void userClickOnSignUp() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signinButton = wait.until(ExpectedConditions.visibilityOfElementLocated(SigninButton));
        signinButton.click();
    }
    public void signinusername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signinUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(SigninUsername));
        signinUsername.sendKeys(username);
    }
    public void signinpassword(String password) {
        driver.findElement(SigninPassword).sendKeys(password);
    }
    public void signinbutton(){
        WebElement signUpBtn = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpBtn);
    }
    public void signupMessage (String signupMessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept(); // Close the alert
    }

    public void userClickOnLogIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(userClickOnLogIn));
        loginButton.click();
    }

    public void setLoginusernameform(String loginusername) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(loginusernameform));
        loginUsername.sendKeys(loginusername);
    }

    public void setLoginpasswordform(String loginpassword) {
        driver.findElement(loginpasswordform).sendKeys(loginpassword);
    }

    public void userClickOnLoginform() {
        WebElement loginBtn = driver.findElement(By.xpath("//button[contains(@class, 'btn-primary')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginBtn);
    }

    public void loginMessage(String loginmessage){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        alert.accept(); // Close the alert
    }

    public void choosephoneCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement phoneCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(phonecategory));
        phoneCategory.click();
    }
    public void producttitlesphones(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTitlesSamsung));
        driver.findElement(productTitlesSamsung);
        Assert.assertTrue(productElement.isDisplayed());
    }
    public void chooseLaptopCategory() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement laptopCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(laptopcategory));
        laptopCategory.click();
    }
    public void producttitleslaptops(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement productElement = wait.until(ExpectedConditions.visibilityOfElementLocated(productTittlesSony));
        driver.findElement(productTittlesSony);
        Assert.assertTrue(productElement.isDisplayed());
    }
}
