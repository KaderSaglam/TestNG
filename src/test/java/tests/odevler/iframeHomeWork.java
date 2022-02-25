package tests.odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class iframeHomeWork extends TestBase {
    @Test
    public void test1(){
        //iframe Home Work
        //1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
driver.get("http://webdriveruniversity.com/IFrame/index.html");
        //2.“Our Products” butonuna basin
        WebElement frame=driver.findElement(By.xpath("//iframe[@id='frame']"));
        driver.switchTo().frame(frame);  // içerideyiz.
        driver.findElement(By.xpath("//a[text()='Our Products']")).click();
        //3.“Cameras product”i tiklayin
        driver.findElement(By.xpath("//img[@id='camera-img']")).click();

        //Popup mesajini yazdirin
        String text=driver.findElement(By.xpath("//div[@class='modal-body']")).getText();
        System.out.println(text);

        //5.“close” butonuna basin
        driver.findElement(By.xpath("//button[text()='Close']")).click();

        //6."WebdriverUniversity.com (IFrame)" linkini tiklayin

        driver.switchTo().parentFrame();
        driver.findElement(By.xpath("//a[@class='navbar-brand']")).click();

   //7."http://webdriveruniversity.com/index.html" adresine gittigini test edin
       String url= driver.getCurrentUrl();
       String expected="http://webdriveruniversity.com/index.html";
        Assert.assertEquals(url, expected," adrese gidilmedi");

    }


}
