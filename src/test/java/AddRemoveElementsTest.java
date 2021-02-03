import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddRemoveElementsTest {
    WebDriver driver;
    private static final String HEROKU_APP_URL = "http://the-internet.herokuapp.com/add_remove_elements/";

    @BeforeMethod
    public void  iniTTest(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
}

    @Test
    public void addRemoveElementsTest() {
        driver.get(HEROKU_APP_URL);
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();
        driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();


        driver.quit();
}
}
