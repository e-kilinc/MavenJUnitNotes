package techproed.day8_Assertation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {
    /*
   Verilen web sayfasına gidin.
   https://the-internet.herokuapp.com/checkboxes
   Checkbox1 ve checkbox2 elementlerini locate edin.
   Checkbox1 seçili değilse onay kutusunu tıklayın
   Checkbox2 seçili değilse onay kutusunu tıklayın
    */

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        
    }

    @Test
    public void name() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        if (!checkbox1.isSelected()){
            checkbox1.click();
        }

        if (!checkbox2.isSelected()){
            checkbox2.click();
        }
    }
}
