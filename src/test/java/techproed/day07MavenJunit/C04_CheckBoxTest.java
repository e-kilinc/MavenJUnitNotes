package techproed.day07MavenJunit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxTest {
//    CheckBox
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/checkboxes");


        //    a. Verilen web sayfasına gidin.
//    https://the-internet.herokuapp.com/checkboxes
//    b. Checkbox1 ve checkbox2 elementlerini locate
        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

//    c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!checkBox1.isSelected()){
            checkBox1.click();
            Thread.sleep(2000);
        }else System.out.println("Checkbox1 onceden secilmis");


//    d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }else System.out.println("checkBox2 onceden secilmis");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
