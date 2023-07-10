package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
    /*
    Bir web sayfasinda bazi webelementler olusuturulurken JavaScript ile olusturulmus olabilir.
    By webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekebilir.

    Bir webelement JavaScript kodları ile yazılmamış olsada javaScriptExecutor ile o webelementi handle edebiliriz.
    Normal bildiğimiz methodlardan daha yavaş çalışacağı için bildiğimiz methodlar işimizi görüyorsa
    onları kullanırız.
    <script> tagi ile oluşturulmuş olan web elementleri de js executor ile handle edebiliriz.
     */

    @Test
    public void test01() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test02() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //sell linkinin resmini alalım

        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        bekle(2);
        webElementResmi(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click(); //burada baska bir pencere acildigi icin sell linkine tiklamadi
                            //ElementClickInterceptedException hatasi verdi
        //JS executor ile Webelementin onunde uyari cikmasina ragmen tikladi
        //Yukaridaki hata ile karsilastigimizda JS executor ile bunu cozebiliriz

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //sell linkinin resmini alalım
        driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//uyari kapatildi
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);//-->click methodu ile normal click yapmayi denedi fakat olmadi js executor ile click yapti.


        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }
}
