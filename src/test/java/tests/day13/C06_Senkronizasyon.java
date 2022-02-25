package tests.day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_Senkronizasyon extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //https://the-internet.herokuapp.com/upload adresine gidelim
       // driver.get("https://the-internet.herokuapp.com/upload");
       // 1- File secme butonununa tiklayalim
     // driver.findElement(By.id("file-submit")).click();


       // driver.get("https://www.techproeducation.com");
        //driver.findElement(By.xpath("(//a[text()='info@techproeducation.com'])[2]")).click();

       //https://the-internet.herokuapp.com/dynamic_controls gidin disable butonuna basin
        //disabled yazisinin ciktigini test edin
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
      Thread.sleep(5000);


    }


}
