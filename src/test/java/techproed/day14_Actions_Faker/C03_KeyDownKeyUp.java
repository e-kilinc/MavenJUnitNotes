package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //google anasayfasina gidelim
        driver.get("https://www.google.com");

        WebElement reject = driver.findElement(By.xpath("(//*[@class=\"QS5gu sy4vM\"])[1]"));
        reject.click();

        //arama kutusunda shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT). //--> Arama kutusunda shift tusuna bastik
                                    sendKeys("selenium").//selenium metni shift tusu basili oldugu icin buyuk yazdi
                                    keyUp(Keys.SHIFT).  //shift tusunu serbest biraktik
                                    sendKeys("-java", Keys.ENTER).//shifti serbest biraktigimiz icin kucuk yazdi
                                    perform();

    }

    @Test
    public void test02() {
        //google anasayfasina gidelim
        driver.get("https://www.google.com");

        WebElement reject = driver.findElement(By.xpath("(//*[@class=\"QS5gu sy4vM\"])[1]"));
        reject.click();

        //arama kutusunda shift tusuna basili olarak selenium yazdiralim ve shift tusunu serbest birakarak java yazdiralim

        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT, "selenium", Keys.SHIFT, "-java", Keys.ENTER);
        
        /*
        Mouse islemleri icin action classinin kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri
        icin action classini kullanmadan sendKeys() methodu ile de istegimiz bir metni buyuk yazdirabilir 
        hatta birden fazla klavye tuslarina bastirabiliriz. 
        Yukaridaki ornekte sendKeys() methodu ile Keys.SHIFT diyerek sonrasinda yazdirmak istedigimiz metni
        kucuk harfle yazmamiza ragmen buyuk harflerle yazdirdi.
        Tekrar Keys.SHIFT tusunu serbest birakmis olduk
         */

    }

    @Test
    public void test03() {
        //google sayfasina gidelim
        driver.get("https://www.google.com");
        WebElement reject = driver.findElement(By.xpath("(//*[@class=\"QS5gu sy4vM\"])[1]"));
        reject.click();

        //Arama kutusuna "selenium" yazin ve entera basin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium");
        aramaKutusu.sendKeys(Keys.RETURN);

        //sayfayi bekleyin
        bekle(4);

        //Arattigimiz kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys(Keys.CONTROL,"a");
        //--> Sayfa yenilendigi icin tekrar locate aldik.
        // metni kesebilmek icin once ctrl+a ile secmemiz gerekir.

        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//secilen metni ctrl+x ile kestik

        //tekrar google sayfasina gidip kestigimiz kelimeyi ctrl+v ile yapistirip tekrar aratalim
        driver.navigate().to("https://www.google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v", Keys.ENTER); //secilen metni ctrl+v ile yapistirdik


    }
}
