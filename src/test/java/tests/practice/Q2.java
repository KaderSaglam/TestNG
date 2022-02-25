package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q2 {
    /*
birbirine bagimli testler olusturun..
.beforClass olusturup setUp ayarlarini yapin..
  birbirine bagimli testler olusturarak;
      ilk once facebook a gidin
      sonra facebook a bagimli olarak google a gidin,
      daha sonra google a bagimli olarak amazon a gidin
driver i kapatin

 */
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test(dependsOnMethods ="googleTest")
    public void amazonTest(){
        driver.get("http://www.amazon.com");

    }
    @Test(dependsOnMethods ="facebookTest")
    public void googleTest(){
        System.out.println("http://www.google.com");

    }

    @Test
    public void facebookTest(){
        System.out.println("http://www.facebook.com");

    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
