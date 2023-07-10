package techproed.day13_Cookies_Actions;

import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import techproed.utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        /*
        Cookie'leri listemek istersek
           driver.manage().getCookies() methoduyla bir Set yada ArrayList'e atarak listeleyebiliriz
         */
        //Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);
        // -->Lambda ile Cookie'leri yazdırdık

        Set<Cookie> cookieSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie w:cookieSet) {
            System.out.println(sayac + ". Cookie: "+ w);
            System.out.println(sayac + ". Cookie Name: "+ w.getName());//Sadece cookilerin isimlerini alir
            System.out.println(sayac + ". Cookie Value: "+ w.getValue());//Sadece cookilerin valuelarini alir

            sayac++;
        }

        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        System.out.println("Cookilerin sayisi: "+ cookieSet.size());
        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin  5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        String actualCookieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();
        String expectedCookieValue= "USD";
        Assert.assertEquals(expectedCookieValue, actualCookieValue);
        //NOT: getCookieNamed() methodu ile bize verilen cookie isminin getValue()
        // methoduyla gerçek değerini actualCookieValue değişkenine assing ettik


        //5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan
        // bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet = driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(each);
        }
        Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());

        System.out.println("Cookilerin sayisi: "+ cookieSet.size());
        //System.out.println("Cookilerin sayisi: " +Arrays.stream(driver.manage().getCookies().toArray()).count());

        //7-ismi skin olan cookie’yi silin ve silindigini test edin

        int silinmedenOnce = cookieSet.size();
        System.out.println("silinmeden once:" +silinmedenOnce);
        bekle(2);
        driver.manage().deleteCookieNamed("skin");//ismi skin olan cookieyi sildik
        bekle(2);
        cookieSet = driver.manage().getCookies();//silindikten sonda cookiSete atama yapmamiz lazim
        //yoksa fail aliriz

        int silindiktenSonra = cookieSet.size();
        System.out.println("silindikten sonra:" +silindiktenSonra);
        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));


        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//tum cookielerin sildik
        cookieSet=driver.manage().getCookies(); //CookieSeti guncelledik
        Assert.assertTrue(cookieSet.isEmpty()); //cookieSetin icinin bos oldugunu isEmpty() ile test ettik
    }
}
