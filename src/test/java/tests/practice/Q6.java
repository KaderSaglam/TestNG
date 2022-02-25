package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q6 {
// url'ye gidin :http://demo.automationtesting.in/Alerts.html
    // "Alert with OK"yi tıklayın ve 'click the button to display a confirm box' i tıklayın:'
    // Uyarıyı kabul et(I am an alert box!) ve uyarıyı konsolda yazdır
    //  "Alert with OK & Cancel" ı tıklayın ve 'click the button to display a confirm box' i tıklayın
    // Uyarıyı iptal et (Press a Button !)
    // "Alert with Textbox" ı tıklayın ve 'click the button to demonstrate the prompt box' tıklayın'
    // ve ardından sendKeys 'TechProEducation' (Lütfen adınızı girin)
    // sonunda "Hello TechproEducation How are you today" mesajını konsola yazdır (edited)
WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void test1() throws InterruptedException {
      driver.get("http://demo.automationtesting.in/Alerts.html");
        // "Alert with OK"yi tıklayın ve 'click the button to display a confirm box' i tıklayın:'
        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        //Uyarıyı kabul et(I am an alert box!) ve uyarıyı konsolda yazdır
        System.out.println(driver.switchTo().alert().getText());
           driver.switchTo().alert().accept();
   //  "Alert with OK & Cancel" ı tıklayın ve 'click the button to display a confirm box' i tıklayın
        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        // Uyarıyı iptal et (Press a Button !)
        driver.switchTo().alert().dismiss();
        // "Alert with Textbox" ı tıklayın ve 'click the button to demonstrate the prompt box' tıklayın
        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        // ve ardından sendKeys 'TechProEducation' (Lütfen adınızı girin)
        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();
        // sonunda "Hello TechproEducation How are you today" mesajını konsola yazdır (edited)
        String yazi=driver.findElement(By.xpath("//p[.='Hello Automation Testing user How are you today']")).getText();
        System.out.println(yazi);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}



