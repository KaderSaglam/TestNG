package tests.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Odev7 {
    // 4 TEST METODU OLUSTURUN,oncelik vererek sirasiyla
    // https://www.n11.com/ SAYFASINA GiDİN.
    // https://www.gittigidiyor.com/ SAYFASINA GiDiN
    // https://getir.com/ SAYFASINA GiDiN
    // https://www.sahibinden.com/ SAYFASINA GiDiN
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }@Test(priority = -1)
    public void n11() throws InterruptedException {
        // https://www.n11.com/ SAYFASINA GiDİN.
        driver.get("https://www.n11.com/");
        Thread.sleep(5000);

    }@Test(priority = 5)
    public void gittigidiyor() throws InterruptedException {
        // https://www.gittigidiyor.com/ SAYFASINA GiDiN
        driver.get("https://www.gittigidiyor.com/");
        Thread.sleep(3000);
    }@Test(priority = 7)
    public void getir() throws InterruptedException {
        // https://getir.com/ SAYFASINA GiDiN
        driver.get("https://getir.com/");
        Thread.sleep(3000);
    }@Test(priority = 10)
    public void sahibinden() throws InterruptedException {
        // https://www.sahibinden.com/ SAYFASINA GiDiN
        driver.get("https://www.sahibinden.com/");
        Thread.sleep(3000);
    }
    @AfterClass
    public void taeardown(){
        driver.close();
    }
}
