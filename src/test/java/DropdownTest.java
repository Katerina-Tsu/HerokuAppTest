import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest {
    WebDriver driver;
    private static final String HEROKU_APP_URL = "http://the-internet.herokuapp.com/dropdown";

    @BeforeMethod
    public void  iniTTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTest() {
        driver.get(HEROKU_APP_URL);
        Select dropdown = new Select(driver.findElement(By.id("dropdown")));
        //driver.findElement(By.id("dropdown"));
        dropdown.selectByVisibleText("Option 2");
        String selectedText = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedText, "Option 2");

        List<WebElement> options = dropdown.getOptions();
        for (WebElement element : options) {
            System.out.println(element.getText());
            //System.out.println(element.isEnabled());
        }

        List<WebElement> elementList = driver.findElements(By.xpath("//table[@id = 'table1']//tbody//tr"));
        boolean isDueValuePresent = false;
        for (WebElement element : elementList) {
            if (element.getText().contains("Conway")) {
                if (element.getText().contains("$50.00")) {
                    isDueValuePresent = true;
                }
            }
            System.out.println(element.getText());
            //System.out.println(element.isEnabled());
        }
        Assert.assertEquals(isDueValuePresent, true);

        driver.findElement(By.xpath("//table[@id = 'table1']//tbody//tr[4]//td[4]")).getText();

        driver.quit();

    }
}
