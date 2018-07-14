import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.gecko.driver", "/home/armin/Downloads/geckodriver-v0.21.0-linux64/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://jira.hillel.it:8080/login.jsp");
    }

    @Test
    public void userLogin() {
        String user = "webinar5";
        WebElement loginField = driver.findElement(By.xpath("//*[@id=\"login-form-username\"]"));
        loginField.sendKeys(user);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id=\"login-form-password\"]"));
        passwordField.sendKeys("webinar5");
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-form-submit\"]"));
        loginButton.click();
        WebElement login = driver.findElement(By.xpath("//*[@id=\"header-details-user-fullname\"]"));
        login.click();
        WebElement profileButton = driver.findElement(By.xpath("//*[@id=\"view_profile\"]"));
        profileButton.click();
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"up-user-title-name\"]"));
        Assert.assertEquals(user,userName.getText());
    }

    @AfterClass
    public static void endTest(){
        driver.quit();
    }
}
    