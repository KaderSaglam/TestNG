package tests.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class C01_WindowHandle {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void handleWindows() throws InterruptedException {
            driver.get("https://www.amazon.com/");
            String windowHandleDegeri1= driver.getWindowHandle();
        System.out.println("ilk sayfanin window handle degeri : "+driver.getWindowHandle());
        driver.switchTo().newWindow(WindowType.WINDOW); // yeni bir pencere acilir
        driver.get("https://bestbuy.com");
        System.out.println("2. Sayfanin window handle degeri :"+driver.getWindowHandle());
        String windowHandleDegeri2= driver.getWindowHandle();

       Set <String>handleDegerleriSet= driver.getWindowHandles();
        System.out.println(handleDegerleriSet);
        Thread.sleep(2000);

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");

//amazonun acik oldugu sayfaya gecin ve nutella icin arama yapin
        driver.switchTo().window(windowHandleDegeri1);
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramakutusu.sendKeys("Nutella"+ Keys.ENTER);
        //bestbuy acik olan sayfaya gecin ve titlein bestbuy icerdigini test edin
        Thread.sleep(3000);

        driver.switchTo().window(windowHandleDegeri2);
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));

        Thread.sleep(3000);

          //facebookun acık oldugu sayfaya gecin ve urlnin
        // https://www.facebook.com oldugunu test edin
        //eger acik olan pencerelerden sadece birtanesinin window handle degeri bilinmiyorsa
        //once tum handle degerelerini bulup bir sete koyariz

        handleDegerleriSet=driver.getWindowHandles();
        //bu soru icin su anda sette 3 window handle degeri var
        //1. ve 2. sayfanin window handle degerlerini biliyoruz.
        //setimizde olup, ilk iki sayfa olmayan handle degeri 3. ssayfanin handle degeri olacaktir.
        driver.getWindowHandles();
        String windowHandleDegeri3="";
        for (String w:handleDegerleriSet
             ) {
            if (!(w.equals(windowHandleDegeri1)||w.equals(windowHandleDegeri2)) ){
                windowHandleDegeri3=w;

            }

        }
        System.out.println(windowHandleDegeri3);
        System.out.println(handleDegerleriSet);

        driver.switchTo().window(windowHandleDegeri3);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
        Thread.sleep(3000);
        }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
