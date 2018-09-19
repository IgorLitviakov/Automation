import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", ConfigProperties.getTestProperty("chromedriver"));
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigProperties.getTestProperty("url"));
    }

    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"login-form-username\"]"));
        loginField.sendKeys(ConfigProperties.getTestProperty("user"));
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"login-form-password\"]"));
        passwordField.sendKeys(ConfigProperties.getTestProperty("password"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form-submit\"]"));
        loginButton.click();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"header-details-user-fullname\"]"));
        login.click();
        WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"view_profile\"]"));
        profileButton.click();
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"up-user-title-name\"]"));
        Assert.assertEquals(ConfigProperties.getTestProperty("user"),userName.getText());
    }

    @AfterClass
    public static void endTest(){
        driver.quit();
    }
}
    