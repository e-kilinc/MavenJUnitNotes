package techproed.day21_Excel_JSExecutor;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C04_Odev1 {
    @Test
    public void test01() throws IOException {
        //    1.satirdaki 2.hucreye gidelim ve yazdiralim

        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler (1).xlsx");
        Workbook workbook = WorkbookFactory.create(fis);

        //  1.satirdaki 2.hucreye gidelim ve yazdiralim
        String birinciSatir = workbook.getSheet("Sayfa1").getRow(0).getCell(1).toString();
        System.out.println("birinci satir" + birinciSatir);

        //  2.satir 4.cell'in afganistan'in baskenti oldugunu test  edelim
        String ikinciSatir = workbook.getSheet("Sayfa1").getRow(1).getCell(3).toString();
        System.out.println("birinci satir" + birinciSatir);
        Assert.assertEquals("Kabil", ikinciSatir);

        //  Satir sayisini bulalim
        int satirSayisi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("satir sayisi : " + satirSayisi);

        //  Fiziki olarak kullanilan satir sayisini bulun
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa1").getPhysicalNumberOfRows();
        System.out.println("Kullanilan Satir Sayisi : " + kullanilanSatirSayisi);

        //  Ingilizce Ulke isimleri ve baskentleri bir map olarak  kaydedelim
        Map<String, String> ulkeBaskent = new HashMap<>();
        for (int i = 0; i <= satirSayisi; i++) {
            String key = workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String value = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(key, value);
            System.out.println(key + "/" + value);
        }
        //  System.out.println(ulkeBaskent);
    }

    @Test
    public void odev2() throws IOException {
//        Yeni bir test method olusturalim writeExcelTest()
//        Adimlari takip ederek 1.satira kadar gidelim//        5.hucreye yeni bir cell olusturalim
//        Olusturdugumuz hucreye “Nufus” yazdiralim
//        2.satir nufus kolonuna 1500000 yazdiralim
//        10.satir nufus kolonuna 250000 yazdiralim
//        15.satir nufus kolonuna 54000 yazdiralim
//        Dosyayi kaydedelim
//        Dosyayi kapatalim

        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/ulkeler (1).xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue("1500000");
        workbook.getSheet("Sayfa1").getRow(9).createCell(4).setCellValue("250000");
        workbook.getSheet("Sayfa1").getRow(14).createCell(4).setCellValue("54000");

        FileOutputStream fos = new FileOutputStream("src/test/java/techproed/resources/ulkeler (1).xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

    }
}

