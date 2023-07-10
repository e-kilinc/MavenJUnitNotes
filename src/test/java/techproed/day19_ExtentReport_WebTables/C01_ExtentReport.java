package techproed.day19_ExtentReport_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ExtentReport extends TestBase {
    /*
    EXTENTREPORT;
       1- ExtentReport(aventstack) kullanabilmek için öncelikle mvn adresinden 4.0.9 versiyon numaralı
    dependency'i pom.xml dosyamıza ekleriz.
       2- ExtentReports class'ından class seviyeninde obje oluştururuz
       3- ExtentHtmlReporter class'ından class seviyeninde obje oluştururuz
       4- ExtentTest class'ından class seviyeninde obje oluştururuz
     */

    ExtentReports extentReports; //--> raporlamayi baslatmak icin kullanilan class
    ExtentHtmlReporter extentHtmlReporter; //--> Raporu html formatinda duzenler
    ExtentTest extentTest; //--> Test adimlarina eklemek istedigimiz bilgileri bu class ile olustururuz

    @Test
    public void test01() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu= "testOutput/extentReports/extendReport" + tarih+ ".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);//HTML formatinda raporlamayi baslatacak

        //Raporda gozukmesini istedigimiz bilgiler icin
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Emin");
        extentHtmlReporter.config().setDocumentTitle("Extent Report");
        extentHtmlReporter.config().setReportName("Smoke Test Raporu");

        extentTest = extentReports.createTest("Extent Test", "Test Raporu");

        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        //basligin Amazon icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        extentTest.info("Basligin Amazon icerdigi test edildi");

        //arama kutusunda iphone aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Iphone", Keys.ENTER);
        extentTest.info("Arama kutusunda iphone aratildi");

        //sonuc yazisini konsola yazdiralim
        WebElement sonucYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println("Sonuc Yazisi : "+sonucYazisi.getText());
        extentTest.info("Sonuc Yazisi konsola yazdırıldı");
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush(); //--> Bu methodu kullanmazsak raporumuz olusmaz

          /*
        extentTest objesi ile info() methodunu kullanarak her step'de ne yaptığımızla alakalı bilgi yazabiliriz
        testimizin en sonunda testin bittiğini ifade eden pass() methodu ile testimiz ile alakalı son bilgiyi
        ekleyebiliriz.

        Ve son olarak actions daki perform() methodu gibi extentReport objesi ile flush() methodu kullanarak
        raporu sonlandırırız
         */


    }
}
