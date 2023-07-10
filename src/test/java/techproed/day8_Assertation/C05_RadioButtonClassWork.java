package techproed.day8_Assertation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButtonClassWork {

    /*
       https://www.facebook.com adresine gidin
       Cookies’i kabul edin
       “Create an Account” button’una basin
       “radio buttons” elementlerini locate edin
       Secili degilse cinsiyet butonundan size uygun olani secin
     */
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//*[@type='submit'])[2]")).click();
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        WebElement female = driver.findElement(By.xpath("(//*[@type='radio'])[1]"));
        WebElement male = driver.findElement(By.xpath("(//*[@type='radio'])[2]"));
        WebElement ozel = driver.findElement(By.xpath("(//*[@type='radio'])[3]"));

        if (!male.isSelected()){
            male.click();
        }

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
