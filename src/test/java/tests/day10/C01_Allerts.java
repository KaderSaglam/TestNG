package tests.day10;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
public class C01_Allerts {
    // ● Bir class olusturun: Alerts
    //● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    WebDriver driver;
    WebElement sonucYazisiElementi;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlertTesti() throws InterruptedException {
        //● Bir metod olusturun: acceptAlert
        //      ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        //      “You successfully clicked an alert” oldugunu test edin.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        Thread.sleep(3000);
        String actualSonucYazisi=sonucYazisiElementi.getText();
        String expectedSonucYazisi="You successfully clicked an alert";
        Assert.assertEquals(actualSonucYazisi,expectedSonucYazisi);
    }
    @Test
    public void dismissAllertTesti() throws InterruptedException {
        //● Bir metod olusturun: dismissAlert
        //      ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        //      “successfuly” icermedigini test edin.
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi= sonucYazisiElementi.getText();
        String istenmeyenKelime="successfuly";
        Thread.sleep(3000);
        Assert.assertFalse(actualSonucYazisi.contains(istenmeyenKelime));
    }
    @Test
    public void sendKeysAlertTesti() throws InterruptedException {
        //● Bir metod olusturun: sendKeysAlert
        //      ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().sendKeys("Yildiz");
        //      OK butonuna     tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.switchTo().alert().accept();
        sonucYazisiElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualSonucYazisi= sonucYazisiElementi.getText();
        String yazdigimizIsim="Yildiz";
        Thread.sleep(3000);
        Assert.assertTrue(actualSonucYazisi.contains(yazdigimizIsim));
    }
    @AfterClass
    public  void teardown(){
        driver.close();
    }
}


