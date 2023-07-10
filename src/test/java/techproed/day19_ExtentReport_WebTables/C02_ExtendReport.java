package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_ExtendReport extends TestBase {
    @Test
    public void test01() {
        extentReport("Chrome","Amazon Testi");
        extentTest = extentReports.createTest("ExtentReport","Test Raporu");

        //amazon sayfasina gidin
        driver.get("https://www.amazon.com");
        extentTest.info("Amazon sayfasina gidildi");

        //sayfanin resmini aliniz
        tumSayfaResmi();
        extentTest.info("Sayfanin resmi alindi");

        //arama kutusunda iphone aratiniz
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Arama Kutusunda iphone aratildi");
        extentTest.pass("Sayfa kapatildi");


    }
}
