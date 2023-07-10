package techproed.day12_WindowHandles;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandles extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfa = driver.getWindowHandle();
        System.out.println("ilk sayfa handle degeri" + ilkSayfa);

        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click(); //-->Kontrolum disinda Yeni bir sekme acildi
        bekle(3);

        /*
         Bir button'a click yaptığımızda kontrolümüz dışında yeni bir sekme yada pencere açılırsa
         yeni açılan pencerenin handle değerini bilmediğim için normal getWindowHandle
         ile driver'imi yeni pencere geçiremem.

         Bunu getWindowHandles() methoduyla açılan tüm pencereleri bir Set'e assign edip, ilkaçtiğimiz
         pencere değilse ikinci açılan yeni penceredir mantığıyla bir loop için çözebiliriz
         */
        Set<String> pencereler = driver.getWindowHandles();
        for (String w:pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfa)){
                driver.switchTo().window(w);
            }
        }
        //ikinci sayfa titleinin "New Window" oldugunu test edin
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println("2. Sayfa Handle Degeri: " +ikinciSayfaHandle);

        //Ilk sayfaya donun ve Title`in "The Internet" oldugunu test edin
        driver.switchTo().window(ilkSayfa);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle , ilkSayfaActualTitle);
        bekle(2);

        //ikinci sayfaya tekrar gecin
        driver.switchTo().window(ikinciSayfaHandle);
        bekle(2);

        //ilk sayfaya tekrar donun
        driver.switchTo().window(ilkSayfa);
        bekle(2);

    }

    @Test
    public void test02() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click(); //-->Kontrolum disinda Yeni bir sekme acildi
        bekle(3);



        //ikinci sayfa titleinin "New Window" oldugunu test edin
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        bekle(2);
        /*
             getWindowHandles() metodunu kullanarak acilan tum pencerelerin handle degerlerini
        bir ArrayList`e atadik.
            Index 0`dan basladigi icin kontrolum disinda acilan pencere 1.index`te oldugundan
        driver.switchTo().window(pencereler.get(1)); komutu ile yeni acilan pencereye gecis yaptik
         */


        //Ilk sayfaya donun ve Title`in "The Internet" oldugunu test edin
        driver.switchTo().window(pencereler.get(0));
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle , ilkSayfaActualTitle);
        bekle(2);

        //ikinci sayfaya tekrar gecin
        driver.switchTo().window(pencereler.get(1));

        //ilk sayfaya tekrar donun
        driver.switchTo().window(pencereler.get(0));

    }

    @Test
    public void test03() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click(); //-->Kontrolum disinda Yeni bir sekme acildi
        bekle(3);



        //ikinci sayfa titleinin "New Window" oldugunu test edin
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        /*
        Set ve ArrayList kullanmadan switchTo().window() metodu icine argument olarak
        driver.getWindowHandles() ile butun acilan pencereleri bir array olarak alip
        index belirterek istedigim pencereye gecis yapabilirim.
         */

        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        bekle(2);
        /*
             getWindowHandles() metodunu kullanarak acilan tum pencerelerin handle degerlerini
        bir ArrayList`e atadik.
            Index 0`dan basladigi icin kontrolum disinda acilan pencere 1.index`te oldugundan
        driver.switchTo().window(pencereler.get(1)); komutu ile yeni acilan pencereye gecis yaptik
         */


        //Ilk sayfaya donun ve Title`in "The Internet" oldugunu test edin
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle , ilkSayfaActualTitle);
        bekle(2);

        //ikinci sayfaya tekrar gecin
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());

        //ilk sayfaya tekrar donun
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());

    }

    @Test
    public void test04() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");


        //  ilk sayfadaki textin “Opening a new window” olduğunu test edin.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(expectedText,actualText);

        //  ilk sayfa Title'ının “The Internet” olduğunu test edin.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(expectedTitle, actualTitle);


        //  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click(); //-->Kontrolum disinda Yeni bir sekme acildi
        bekle(3);



        //ikinci sayfa titleinin "New Window" oldugunu test edin
        switchToWindow(1);
        /*
        Set ve ArrayList kullanmadan switchTo().window() metodu icine argument olarak
        driver.getWindowHandles() ile butun acilan pencereleri bir array olarak alip
        index belirterek istedigim pencereye gecis yapabilirim.
         */

        String actualTitleNewWindow = driver.getTitle();
        String expectedTitleNewWindow = "New Window";
        Assert.assertEquals(expectedTitleNewWindow, actualTitleNewWindow);
        bekle(2);
        /*
             getWindowHandles() metodunu kullanarak acilan tum pencerelerin handle degerlerini
        bir ArrayList`e atadik.
            Index 0`dan basladigi icin kontrolum disinda acilan pencere 1.index`te oldugundan
        driver.switchTo().window(pencereler.get(1)); komutu ile yeni acilan pencereye gecis yaptik
         */


        //Ilk sayfaya donun ve Title`in "The Internet" oldugunu test edin
        switchToWindow(0);
        String ilkSayfaActualTitle = driver.getTitle();
        String ilkSayfaExpectedTitle = "The Internet";
        Assert.assertEquals(ilkSayfaExpectedTitle , ilkSayfaActualTitle);
        bekle(2);

        //ikinci sayfaya tekrar gecin
        switchToWindow(1);

        //ilk sayfaya tekrar donun
        switchToWindow(0);

    }
}
