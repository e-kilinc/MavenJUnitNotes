package techproed.day20_WebTable_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    /*
WEBTABLE;
    <table> tagı ile başlar
        <thead> başlıklar için bu tag ile devam eder
            <th> table head
                <td> başlıktaki veriler
            <tbody> başlıklar altındaki verileri temsil eder
                    <tr> table row(satır)
                        <td> table data (tablodaki veri)

 */
    @Test
    public void test01() {
        extentReport("Chrome", "WebTable");
        extentTest =extentReports.createTest("WebTable", "TestRaporu");


        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("Sayfaya gidildi");

//    Task 1 : Table1’i yazdırın
        WebElement table1= driver.findElement(By.xpath("(//table)[1]"));
        System.out.println("table1");
        System.out.println(table1.getText());
        extentTest.info("Tablo 1 yazdirildii");

//    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("********************************");
        System.out.println(ucuncuSatir.getText());
        extentTest.info("3. Satir verileri yazdirildi");

//    Task 3 : Son satırın verilerini yazdırın
        WebElement sonSatir = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        //last()--> Istenilene gore son satir ya da sutun bilgilerini verir
        System.out.println("1.Tablo Son Satir = "+ sonSatir.getText());
        extentTest.info("Son satir verileri yazdirildi");

//    Task 4 : 5. Sütun verilerini yazdırın
        System.out.println("****************************************************");
        WebElement besinciBaslik= driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println("Besinci Sutun Basligi = "+ besinciBaslik.getText());
        extentTest.info("5.sutun verileri yazdirildi");

        List<WebElement> besinciSutun = driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));

        //Task 5: 3. satirdaki 1. ve 2. sutun bilgilerini yazdiriniz
        System.out.println("************************************");
        List<WebElement> ucuncuSatir2 = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
        ucuncuSatir2.forEach(t-> System.out.print(t.getText()+"\t"));
        extentTest.info("3. satir 1-2. sutun verileri yazdirildi");


//    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        System.out.println("**********************************************");
        //WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr[2]//td[3]"));
        //method olusturmadan bu sekilde yazdiririz
        System.out.println(printData(2, 3));

        extentTest.info("Son 2.satir 3.sutun verileri yazdirildi");


        //3.satir 2.sutun bilgisinin Jack olup olmadigini dogrulayin
        printData(3,2);
        String actualData = printData(3,2);
        String expectedData = "Jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3.satir 2. sutun bilgisinin Jack degil, Jason oldugu goruldu");
        extentTest.pass("Sayfa kapatildi");
        extentReports.flush();

    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        return satirSutun.getText();
    }
}
