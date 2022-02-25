package tests.odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class SlayttakiSoru extends TestBase {
    //amazona gidin
    //arama kutusunn solundaki dropdown menuyu handle edip lisetesini ekrana yazdirin
    //dropdown menüde 28 eleman oldugunu dogrulayın
//****
    WebElement dropdownElementi;
    Select select;



    @Test
    public void test1Amazon() {
        driver.get("https://www.amazon.com/");
        dropdownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownElementi);
        List<WebElement> optionListesi=select.getOptions();
     int actualOptionSayisi = optionListesi.size();
        int expectedOptionSayisi = 28;
        for (WebElement each: optionListesi
             ) {
            System.out.println(each.getText());

        }

        Assert.assertEquals(actualOptionSayisi, expectedOptionSayisi, "eleman sayilari esit degil");
    }@Test
    public void elektronicTest(){

        driver.get("https://www.amazon.com/");
//1-)dropdown menuden elektronik bolumu secin
        dropdownElementi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(dropdownElementi);
        select.selectByIndex(10);
        System.out.println(select.getFirstSelectedOption().getText());
//2-)Arama Kutusuna iphone cable yazip Aratin ve bulunan sonuc sayisini yazdirin
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
  aramaKutusu.sendKeys("iphone Cable" + Keys.ENTER);
//3-)Sonuc sayisi bildiren yazinin iphone icerdegini test edin
        WebElement sonucSayisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucSayisi.getText().contains("iphone Cable"));
//4-)Ikinci urune relative locater kullanarak tiklayin
      WebElement iphone11cable = driver.findElement(By.xpath("//img[@class='s-image']"));
       WebElement iphone12cable = driver.findElement(RelativeLocator.with(By.tagName("img")).below(iphone11cable));
     iphone12cable.click();


//5-)Urunun title 'ini ve fiyatini variable'a assign edip sepete ekleyin
        String title= driver.getTitle();
        WebElement sepeteEkle=driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
      sepeteEkle.click();


}}
