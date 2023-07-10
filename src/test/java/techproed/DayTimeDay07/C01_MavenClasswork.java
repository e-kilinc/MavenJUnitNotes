package techproed.DayTimeDay07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClasswork {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2.Signin buttonuna tiklayin
        WebElement signIn = driver.findElement(By.xpath("//*[@id='signin_button']"));
        signIn.click();
        //3.Login alanine "username" yazdirin
        WebElement logIn = driver.findElement(By.xpath("//*[@id='user_login']"));
        logIn.sendKeys("username");
        //4.Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");
        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //6.Online Banking altında Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("2000");
        //8.tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='pay_saved_payees']")).click();
        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("//*[@id='alert_content']"));
        if (mesaj.isDisplayed()){
            System.out.println("Test Passed");
        }else System.out.println("Test Failed");

    }
}
