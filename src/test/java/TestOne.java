import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestOne {
    WebDriver driver;

   @BeforeMethod
   public void  iniTTest(){
       System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
       driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.manage().window().maximize();
   }

    @Test
    public void inputTest() {

        ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //driver = new ChromeDriver(options);
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        // driver.findElement(By.tagName("input")).sendKeys("20");
        //driver.findElement(By.tagName("input")).getText();
        inputField.sendKeys("20");
        String actualTextFromInputField = inputField.getAttribute("value");

        Assert.assertEquals(actualTextFromInputField,"20");

        inputField.sendKeys(Keys.ARROW_DOWN);
        actualTextFromInputField = inputField.getAttribute("value");

        Assert.assertEquals(actualTextFromInputField,"19");

        inputField.sendKeys(Keys.ARROW_DOWN);
        actualTextFromInputField = inputField.getAttribute("value");

        Assert.assertEquals(actualTextFromInputField,"18");

        inputField.clear();
        actualTextFromInputField = inputField.getAttribute("value");
        Assert.assertEquals(actualTextFromInputField, "");

        driver.quit();


   }

}
