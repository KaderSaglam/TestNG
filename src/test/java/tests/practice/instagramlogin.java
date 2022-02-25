package tests.practice;
//*******bu kod calismiyor bakilacak

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class instagramlogin {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void insTagramKatitTesti() throws InterruptedException {
//intagram girin Kayit Testi yapin https://www.instagram.com/
        driver.get("https://www.instagram.com/");
//kaydola tikla
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[.='Kaydol']")).click();
        Thread.sleep(5000);
        // JavascriptExecutor jse = (JavascriptExecutor) driver;
//WebElement ilkGelenEmailKutusudriver=driver.findElement(By.xpath("(//span[@class='_9nyy2'])[1]"));
        //  jse.executeScript("arguments[0].click();", ilkGelenEmailKutusudriver);//
//ortak locator xpath=//div[@class='WZdjL']
        //ortak locator className=_9nyy2
        Faker faker =new Faker();
        String isimSoyIsim= faker.name().fullName();
        String email=faker.internet().emailAddress();
        String userName=faker.name().username();
        String passWord=faker.internet().password();
        List<WebElement> instOrtakLocator=driver.findElements(By.xpath("//div[@class='WZdjL']"));//locate degiscek
        List<String> kayitTexts=new ArrayList(Arrays.asList(email,isimSoyIsim,userName,passWord));
        for (int i = 0; i <instOrtakLocator.size() ; i++) {
            instOrtakLocator.get(i).sendKeys(kayitTexts.get(i));
        }
    }
}
