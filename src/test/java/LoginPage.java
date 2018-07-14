import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.firefox.driver", "/home/armin/Downloads/geckodriver-v0.21.0-linux64/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://jira.hillel.it:8080/login.jsp");
    }

    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.id("login"));
        loginField.sendKeys("autotestorgua");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("testpass");
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Войти']"));
        System.out.print("Test");
        System.out.print("Test");System.out.print("Test");
        System.out.print("Test");
        System.out.print("Test");
        System.out.print("Test");
        System.out.print("Test");
        System.out.print("Test");



        loginButton.click();
        WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
        String mailUser = profileUser.getText();
        Assert.assertEquals("autotestorgua@ukr.net", mailUser);
    }
}
