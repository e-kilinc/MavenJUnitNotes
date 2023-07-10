package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import techproed.utilities.TestBase;

public class C02_BasicAuthentication extends TestBase {

    /*
    -Authentication kimlik dogrulama yöntemidir
    - söz konusu sisteme dahil olup olunamayacagını belirleyen formu ifade eder
    - Authentication üzerinde sag click yapıp locate alınamaz
    - Authentication bir alert degildir
    - Authentication yapabilmek icin uygulamanın kullanıcılara,
    Authentication'ı nasıl yapacagına dair bilgilendirme yapmıs olması gerekir
    - https://username:password@URL gibi
     */

        // Aşağıdaki bilgileri kullanarak authentication yapınız:

        // Url: https://the-internet.herokuapp.com/basic_auth
        // Username: admin
        // Password: admin

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız

    @Test
    public void test01() {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        bekle(3);

        //"Congratulations" yazisinin ciktigini dogrulayin
        WebElement text = driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations"));

        //Elemental Selenium yazisina tiklayalim
        driver.findElement(By.xpath("(//a)[2]")).click();
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        //yukaridaki kod ile Acilan yeni pencereye gectik

        //Basligin Elemental Selenium olmadigini dogrulayin
        System.out.println("Sayfa Basligi: " +driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());

        //dropdown menuden java secelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");

        //selectVisibleText(ddm,"Java");//Metot ile


    }
}
