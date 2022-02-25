package tests.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;
import java.util.Set;

public class Odev6 {
    //● https://the-internet.herokuapp.com/windows adresine gidin.
    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //● Click Here butonuna basın.
    //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

@Test
public void test() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/windows");

    //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    WebElement textYazisi= driver.findElement(By.tagName("h3"));
    String expectedYazi="Opening a new window";
    Assert.assertEquals(textYazisi.getText(),expectedYazi,"Opening a new window yazisi yazmiyor");

    //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    String expectedTitle="The Internet";
   String actualTitle= driver.getTitle();
   Assert.assertEquals(actualTitle,expectedTitle,"title The Internet yazisi icermiyor ");
    String handle1=  driver.getWindowHandle();
    //● Click Here butonuna basın

    driver.findElement(By.xpath("//a[.='Click Here']")).click();

//● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.

    Set<String> handller=driver.getWindowHandles();
    for (String each: handller)
    {
        if (!each.equals(handle1)) {
          driver.switchTo().window(each);

        }

    }

    String beklenenString="New Window";
    Assert.assertEquals(driver.getTitle(), beklenenString);
    //● Sayfadaki textin “New Window” olduğunu doğrulayın.
    WebElement textYazi= driver.findElement(By.tagName("h3"));
   Assert.assertEquals(textYazi.getText(), beklenenString );
    //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
    driver.switchTo().window(handle1);
     expectedTitle="The Internet";
   actualTitle= driver.getTitle();
    Assert.assertEquals(actualTitle,expectedTitle,"title The Internet yazisi icermiyor ");

}}
