package tests.odevler;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class yapilacakkOdev extends TestBase {
    //Trendyola Git
//Cocuk Sekmesini sec
//Cocuk Sekmesi Secildigini Test Et
//Erkek Cocuk Sec
//3. urunu ekle Ama(RelativeLocators ile Yapilacak)
//Sepete Ekle
//Septe Eklendigini Dogrula (Screen Shot Ile
//Sepetteki Urunu Sil
//Sayfayi Kapat...

    @Test
    public void trendYolTest() throws InterruptedException, IOException {
//Trendyola Git
        driver.navigate().to("https://www.trendyol.com/");
        driver.navigate().refresh();

        Thread.sleep(2000);

//Cocuk Sekmesini sec
        WebElement cocukElementi = driver.findElement(By.xpath("//a[.='Çocuk']"));
        cocukElementi.click();

//Cocuk Sekmesi Secildigini Test Et
        SoftAssert softAssert = new SoftAssert();
        String actualUrl = driver.getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("cocuk"));
//Erkek Cocuk Sec
        WebElement erkekCocukSekmesi = driver.findElement(By.xpath("//span[.='Erkek Çocuk']"));
        erkekCocukSekmesi.click();
//3. urunu ekle Ama(RelativeLocators ile Yapilacak)

        WebElement ikinciUrun = driver.findElement(By.xpath("(//div[@class='image-overlay-body'])[2]"));
        WebElement tiklanacakUrun = driver.findElement(RelativeLocator.with(By.xpath("(//div[@class='image-overlay-body'])[3]")).toRightOf(ikinciUrun));
        tiklanacakUrun.click();
        String ilkWindowsHandle1 = driver.getWindowHandle();
        Set<String> handleDegerleriSeti = driver.getWindowHandles();
        String handleDegeri2 = "";
        for (String w : handleDegerleriSeti) {
            if (!w.equals(ilkWindowsHandle1)) {
                handleDegeri2 = w;
            }
        }
        //2. sayfaya gecis yapabilirim
        driver.switchTo().window(handleDegeri2);
//Sepete Ekle
        WebElement sepeteEkle = driver.findElement(By.xpath("//div[@class='add-to-basket-button-text']"));
       // JavascriptExecutor jse = (JavascriptExecutor) driver;
       // jse.executeScript("arguments[0].click();", sepeteEkle);
        sepeteEkle.click();
//Septe Eklendigini Dogrula (Screen Shot Ile)
        //Sepetim'e git
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[.='Sepetim']")).click();
        Thread.sleep(5000);
        TakesScreenshot tss = (TakesScreenshot) driver;
        File tumSayfa = new File("target/screenShot/trendyol.jpg");
        File geciciResim = tss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim, tumSayfa);
        Thread.sleep(3000);
//Sepetteki Urunu Sil
        driver.findElement(By.className("i-trash")).click();
        Thread.sleep(5000);
//Sayfayi Kapat...
        driver.quit();
    }
}