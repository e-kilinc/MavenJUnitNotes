package techproed.day09_DropDownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropDown {

    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01()  {
        //programming languages ddm den istediğiniz 4 seçeneği seçiniz
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);

        //Eger sadece secili olan optionslari yazdirmak istersek;
        select.getAllSelectedOptions().forEach(t-> System.out.println(t.getText()));//Lambda ile

        System.out.println("**************************************************");
        for (WebElement each: select.getAllSelectedOptions()    ) {
            System.out.println(each.getText());

        }

        System.out.println("**************************************");
        //Seceneklerden 4 tane sectigimizi dogrulayalim
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //Sectigimiz seceneklerden ilkini yazdiralim
        System.out.println(select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java", select.getFirstSelectedOption().getText());
        bekle(3);

        //Sectiginiz seceneklerin hepsini kaldirmak icin
        select.deselectAll();
        bekle(3);

        //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
        //diller.sendKeys("C#");

        //visibleText olarak seçim yapacağımız bir method oluşturup
        // programming languages ddm den bir seçenek seçelim
        selectVisibleText(diller,"Java");
        bekle(2);

        //Index olarak seçim yapacağımız bir method oluşturup
        // programming languages ddm den bir seçenek seçelim
        selectIndex(diller,2);
        bekle(2);


        //value olarak seçim yapacağımız bir method oluşturup
        // programming languages ddm den bir seçenek seçelim
        selectValue(diller,"js");

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    public void selectVisibleText(WebElement ddm, String text){
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    public void selectIndex(WebElement ddm, int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    public void selectValue(WebElement ddm, String value){
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    public void bekle (int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
