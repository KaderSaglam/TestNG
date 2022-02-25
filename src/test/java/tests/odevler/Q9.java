package tests.odevler;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Q9 extends TestBase {
    //      //   1- https://www.facebook.com adresine gidelim
    //    2- Yeni hesap olustur butonuna basalim
    //    3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        @Test
        public void Odev() throws InterruptedException {
            driver.get("https://www.facebook.com");
            driver.findElement(By.xpath("//a[.='Yeni Hesap Oluştur']")).click();
            WebElement name = driver.findElement(By.xpath("//input[@name='firstname']"));
            Actions actions = new Actions(driver);
            actions.click(name).
                    sendKeys("Kader").
                    sendKeys(Keys.TAB).
                    sendKeys("SAGLAM").
                    sendKeys(Keys.TAB).
                    sendKeys("abcde@gmail.com").
                    sendKeys(Keys.TAB).
                    sendKeys("abcde@gmail.com").
                    sendKeys(Keys.TAB).
                    sendKeys("123456,")
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys("Aug")
                    .sendKeys(Keys.TAB)
                    .sendKeys("15")
                    .sendKeys(Keys.TAB)
                    .sendKeys("1994")
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                    .sendKeys(Keys.ENTER)
                    .perform();
Thread.sleep(3000);


        }
}
