package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C06_FacebookKayit extends TestBase {

    //Yeni bir class olusturalim: D15_MouseActions4


    @Test
    public void test01() throws InterruptedException {
        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        Thread.sleep(1000);
        //2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));


        Actions actions=new Actions(driver);

        actions.click(isimKutusu)
                .sendKeys("Kader")
                .sendKeys(Keys.TAB)
                .sendKeys("Saglam")
                .sendKeys(Keys.TAB)
                .sendKeys("asdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("asdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12qwasQ.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("1994")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(5000);


        //4- Kaydol tusuna basalim
    }
}
