package tests.Tekrar;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class Day15 extends TestBase {
    // amazon anasayfaya gidelim

    // nutella icin arama yapalim


    // sonuclarin nutella icerdigini test edelim

    // testin calistiginin ispati icin tum sayfanin screenshot'ini alalim

    @Test
    public void amazonTest() throws IOException {
        // amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");

        // nutella icin arama yapalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);


        // sonuclarin nutella icerdigini test edelim
        WebElement sonuc= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonuc.getText().contains("nutella"));

        // testin calistiginin ispati icin tum sayfanin screenshot'ini alalim
      //  TakesScreenshot tss= (TakesScreenshot) driver; bu tüm sayfada oluyor
     File webelement=new File("target/screenShot/resim.jpg");
     File geciciresim=sonuc.getScreenshotAs(OutputType.FILE);
     FileUtils.copyFile(geciciresim,webelement);

    }

    //hepsiBuradaya adidasa tıkla  gitiginiin ekran resmini cek
    @Test
    public void hepsiburada() throws InterruptedException, IOException {
        driver.get("https://www.Hepsiburada.com");
        WebElement adidas= driver.findElement(By.xpath("//a[@title='adidas']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",adidas);
        Thread.sleep(3000);
        //tum sayfanin resmini cek
        TakesScreenshot tss= (TakesScreenshot) driver;
        File sahra=new File("target/screenShot/sahra.pny");
        File gecici=tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(gecici,sahra);
    }

}
