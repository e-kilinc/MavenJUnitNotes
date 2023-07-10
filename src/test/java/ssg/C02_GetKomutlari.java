package ssg;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_GetKomutlari extends TestBase {
    @Test
    public void test01() {
//        https://www.kitapyurdu.com/ adresine gidiniz.
        driver.get("https://www.kitapyurdu.com/");

//        Arama motorunda “Java” kelimesini aratınız.
        driver.findElement(By.xpath("//*[@id='search-input']")).sendKeys("Java", Keys.ENTER);

//        Listedeki birinci ve ikinci ürünü sepete ekleyiniz.
        WebElement ilkUrun = driver.findElement(By.xpath("(//*[@class='name'])[1]"));
        ilkUrun.click();
        WebElement sepeteEkle = driver.findElement(By.xpath("//*[@id='button-cart']"));
        sepeteEkle.click();
        driver.navigate().back();
        WebElement ikinciUrun = driver.findElement(By.xpath("(//*[@class='name'])[2]"));
        ikinciUrun.click();
        WebElement sepeteEkle2 = driver.findElement(By.xpath("//*[@id='button-cart']"));
        sepeteEkle2.click();

//        Sepetinize gidiniz.
        driver.findElement(By.xpath("(//h4)[1]")).click();
        driver.findElement(By.xpath("//*[@id='js-cart']")).click();


//        Eklenen iki ürünün de sepette göründüğünü doğrulayınız.
        WebElement urun1 = driver.findElement(By.xpath("(//*[@class='alt'])[2]"));
        WebElement urun2 = driver.findElement(By.xpath("(//*[@class='alt'])[4]"));
        Assert.assertTrue(urun1.isDisplayed());
        Assert.assertTrue(urun2.isDisplayed());

//        İlk ürünün miktarını 2, ikinci ürünün miktarını 3 olarak değiştiriniz.
        WebElement miktar1 = driver.findElement(By.xpath("(//*[@name='quantity'])[1]"));
        miktar1.clear();
        miktar1.sendKeys("2");

        WebElement miktar2 = driver.findElement(By.xpath("(//*[@name='quantity'])[2]"));
        miktar2.clear();
        miktar2.sendKeys("3");
        bekle(3);

//        “Seçilenleri Daha Sonra Al” fonksiyonunun görünür olmadığını doğrulayınız.
//        Ürünlere ait kontrol kutularını seçili hale getiriniz.
        WebElement kabulEtJS = driver.findElement(By.xpath("//*[@id='js-popup-accept-button']"));
        click(kabulEtJS);

        WebElement checkBox1 = driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//*[@type='checkbox'])[3]"));

        if (!checkBox1.isSelected()){
            checkBox1.click();
        }

        if (!checkBox2.isSelected()){
            checkBox2.click();
        }

        WebElement dahaSonraAl = driver.findElement(By.xpath("//*[@id='cart-selected-button']"));
        Assert.assertTrue(dahaSonraAl.isDisplayed());


//        Kontrol kutularının seçili olduğunu doğrulayınız.
        Assert.assertTrue(checkBox1.isSelected());
        Assert.assertTrue(checkBox2.isSelected());

//        İkinci ürüne ait kontrol kutusunun seçimini kaldırınız.
        if (checkBox2.isSelected()){
            checkBox2.click();
        }
//        İkinci ürünün kontrol kutusunun seçili olmadığını doğrulayınız.
        Assert.assertFalse(checkBox2.isSelected());
        bekle(3);

//        “Seçilenleri Daha Sonra Al” fonksiyonunun aktif olduğunu doğrulayınız.
        Assert.assertTrue(dahaSonraAl.isDisplayed());
    }
}
