package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class GetKomutlari extends TestBase {
    @Test
    public void getKomutlariTesti() {
        //    Test Görevi:
//    https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");

//    Anasayfanın açıldığını sayfa URL’si ile doğrulayınız.
        String expectedUrl = "https://www.kitapyurdu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

//    Anasayfanın açıldığını sayfa başlığı ile doğrulayınız.
        String expectedTitle = "Kitapyurdu, Kitapla buluşmanın en kolay yolu";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

//    Anasayfada "Haftanın Yayınevi", "En Çok Satılanlar" ve "Ayın Yayınevleri" başlıklarının
//    bulunduğunu doğrulayınız.
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Haftanın Yayınevi"));
        Assert.assertTrue(pageSource.contains("En Çok Satılanlar"));
        Assert.assertTrue(pageSource.contains("Ayın Yayınevleri"));


//    Üye girişi butonunun üzerindeki metnin "Giriş Yap" olduğunu doğrulayınız.
        WebElement girisButonu = driver.findElement(By.xpath("//*[@class='menu-top-button login']"));
        String girisButonuMetni = girisButonu.getText();
        Assert.assertEquals("Giriş Yap", girisButonuMetni);

//    “Üye Ol” butonunun linkinin "https://www.kitapyurdu.com/index.php?route=account/register"
//    olduğunu doğrulayınız.
        WebElement uyeOlButonu = driver.findElement(By.linkText("Üye Ol"));
        String uyeOlHref = uyeOlButonu.getAttribute("href");
        Assert.assertEquals("https://www.kitapyurdu.com/index.php?route=account/register", uyeOlHref);


//    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin span tagı içerisinde olduğunu doğrulayınız.
        List<WebElement> yazarIsmiListesi = driver.findElements(By.xpath("//*[@class='author line-clamp-2']"));
        for (WebElement yazarIsmi : yazarIsmiListesi) {
            Assert.assertEquals("span",yazarIsmi.getTagName());
        }

//    En Çok Satılanlar bölümündeki yazar isimlerinin hepsinin font ailesinin "Arial, Helvetica, sans-serif"
//    olduğunu doğrulayınız.
        for (WebElement yazarIsmi:yazarIsmiListesi) {
            Assert.assertEquals("Arial, Helvetica, sans-serif", yazarIsmi.getCssValue("font-family"));

        }

//    Haftanın Yayınevi bölümündeki ilk kitabın resim genişliğinin 120, yüksekliğinin 174 olduğunu doğrulayınız.
        //uyeOlButonu.getSize().getHeight()

        WebElement ilkResim = driver.findElement(By.xpath("//*[@id='product-648673']"));
        int height= ilkResim.getSize().height;
        int width= ilkResim.getSize().width;
        Assert.assertEquals(height,174);
        Assert.assertEquals(width,120);
//    quit() ve close() metotları arasındaki farkı inceleyelim.
    }

}
