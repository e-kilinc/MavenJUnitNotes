package techproed.day11_IframeWindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_C03_WindowHandle extends TestBase {
    @Test
    public void windowHandle() {
        /*
  Eğer sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle başka sayfaya gittikten sonra
  tekrar ilk açtığınız sayfaya dönmek isterseniz,
  ilk sayfaya driver.get() methoduyla gittikten sonra
  String bir değişkene handle değerini assingn ederseniz tekrar ilk açılan sayfaya dönmek istediğinizde
  driver.switchTo().window(ilksayfaHandleDeğeri) ile geçiş yapabilirsiniz.
    */

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:

        driver.switchTo().newWindow(WindowType.WINDOW);//Yeni bir pencereye drivei tasir
                                    //WindowType.TAB --> yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHande = driver.getWindowHandle();
        bekle(2);

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasina geri donun
        driver.switchTo().window(techproedWindowHandle);
        bekle(2);

        //youtube sayfasina geciniz
        driver.switchTo().window(youtubeWindowHande);
        bekle(2);

        //linkedin sayfasina geciniz
        driver.switchTo().window(linkedinWindowHandle);
        bekle(2);

    }

    @Test
    public void test02() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

        //Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:

        driver.switchTo().newWindow(WindowType.TAB);//Yeni bir pencereye drivei tasir
        //WindowType.TAB --> yeni bir sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHande = driver.getWindowHandle();
        bekle(2);

        //Window 3'te (yeni bir pencerede) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();
        bekle(2);

        //techproeducation sayfasina geri donun
        driver.switchTo().window(techproedWindowHandle);
        bekle(2);

        //youtube sayfasina geciniz
        driver.switchTo().window(youtubeWindowHande);
        bekle(2);

        //linkedin sayfasina geciniz
        driver.switchTo().window(linkedinWindowHandle);
        bekle(2);
    }
}
