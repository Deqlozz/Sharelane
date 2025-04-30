import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SingUp {
    @Test
    public void checkZipCodeDigits() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver browser = new ChromeDriver();
        browser.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
        browser.get("https://www.sharelane.com/cgi-bin/register.py");
        browser.findElement(By.name("zip_code")).sendKeys("12345");
        browser.findElement(By.cssSelector("[value=Continue]")).click();
        browser.findElement(By.name("first_name")).sendKeys("Sasha");
        browser.findElement(By.name("email")).sendKeys("Sasha@test.com");
        browser.findElement(By.name("password1")).sendKeys("11111");
        browser.findElement(By.name("password2")).sendKeys("11111");
        browser.findElement(By.cssSelector("[value=Register]")).click();
        String errorMsg = browser.findElement(By.className("confirmation_message")).getText();
        Assert.assertEquals(errorMsg, "Account is created!");
        browser.quit();





    }
}