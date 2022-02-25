package tests.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;
public class Q11 extends TestBase {
    // http://amazon.com adresine gidiniz
// araba, ev, anahtarlik, ayakkabi, gomlek  kelimelerini arayiniz
    @Test(dataProvider = "urunler")
    public void amazonTest(String kelime){
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(kelime+ Keys.ENTER);
    }
    @DataProvider(name = "urunler")
    public Object [][] getUrunler(){
        Object [][] urunler ={{"araba"},{"ev"},{"anahtarlik"},{"ayakkabi"},{"gomlek"}};
        return urunler;
    }
    //https://www.gittigidiyor.com gidin
    @Test(dataProvider="aranacakKelimeler")
    public void gittiGidiyorTest(String aranacakKelime){
        driver.get("https://www.gittigidiyor.com");
        driver.findElement(By.xpath("//input[@name ='k']")).sendKeys(aranacakKelime+Keys.ENTER);

    }
    @DataProvider
    public  static Object[][] aranacakKelimeler(){
        String data[][]={{"Java"},{"Javascript"},{"pyhton"}};
        return  data;
    }
}


