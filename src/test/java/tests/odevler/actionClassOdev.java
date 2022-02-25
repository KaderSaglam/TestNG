package tests.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class actionClassOdev {

    //Actions Class Home Work
    //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
    //2. "Hover over Me First" kutusunun ustune gelin
    //3. "Link 1" e tiklayin
    //4. Popup mesajini yazdirin
    //5. Popup'i tamam diyerek kapatin
    //6. "Click and hold" kutusuna basili tutun
    //7. "Click and hold" kutusunda cikan yaziyi yazdirin
    //8. "Double click me" butonunu cift tiklayin
    WebDriver driver;
@BeforeClass
    public void setUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

}@Test
    public void test1(){
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverover= driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));
        actions.moveToElement(hoverover).perform();
        //3. "Link 1" e tiklayin
driver.findElement(By.xpath("(//a[.='Link 1'])[1]")).click();

        //4. Popup mesajini yazdirin
        System.out.println("popup yazısı : "+driver.switchTo().alert().getText());

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
        WebElement box=driver.findElement(By.id("click-box"));
        actions.clickAndHold(box).perform();
       //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        WebElement textBox=driver.findElement(By.xpath("//div[@id='click-box']"));
        System.out.println(textBox.getText());
        //8. "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.xpath("//div[@class='div-double-click']"))).perform();




    }
}
