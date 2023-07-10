package techproed.day23_Log4J;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

public class C02_Log4J extends TestBase {
    @Test
    public void test01() {
        Logger logger = LogManager.getLogger(C02_Log4J.class);

        //Techporeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        logger.info("Techproeducation sayfasina gidildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        logger.info("Sayfada çıkan reklam kapatıldı");

        //basligin egitim icerdigini test edelim
        Assert.assertFalse(driver.getTitle().contains("egitim"));
        logger.error("Sayfa basligi egitim yazisi icermiyor");



    }
}
