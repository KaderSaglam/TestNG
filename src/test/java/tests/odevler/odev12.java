package tests.odevler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;


public class odev12 extends TestBase {
    // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
    @Test
    public void siteTesti() throws InterruptedException {
        // 1."https://react-shopping-cart-67954.firebaseapp.com/" adresine gidin
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        // 2.Web sitesindeki tüm öğeleri listeleyin ve yazdirin
        // (sitede 16 urun var, 1.urun : 2.urun :.....seklinde yazdirin )
        List<WebElement> urunList = driver.findElements(By.xpath("//p[@class='shelf-item__title']"));
        System.out.println("\nUrun Listesi\n");
        for(int i=0;i<urunList.size();i++){
            System.out.println((i+1) + ".urun : " + urunList.get(i).getText());
        }

        // 3.Stringlerden olusan bir ArrayList oluşturun ve Ürün Adlarını ArrayList'e yerleştirin
        List<String> urunStringList = new ArrayList<>();
        for(int i=0 ; i<urunList.size() ; i++){
            urunStringList.add(i,urunList.get(i).getText());
        }

        // 4.Siteden Rastgele 5 öğe seçin, sepete ekleyin ve sectiginiz öğelerin adlarını yazdırın
        // (Her ürün 1 defadan fazla eklenemez!)
        int randomSelect=0;
        List<Integer> tekrarsizList=new ArrayList<>();
        List<WebElement> sitedenSecilenUrunlerFiyatList = new ArrayList<>();
        for(int i=1; i<=5;i++){

            for(int j=1; j>0 ; j++) {
                randomSelect = (int) ((Math.random() * 16) + 1);
                if(!tekrarsizList.contains(randomSelect)) {
                    tekrarsizList.add(randomSelect);
                    break;
                }
            }
            String dinamikXpath =  "(//div[@class='shelf-item__buy-btn'])["+randomSelect+"]";
            driver.findElement(By.xpath(dinamikXpath)).click();

        }
        for(int i=0;i<tekrarsizList.size();i++){
            String secilenUrunFiyatXpath =  "(//div[@class='val'])["+tekrarsizList.get(i)+"]";
            sitedenSecilenUrunlerFiyatList.add(driver.findElement(By.xpath(secilenUrunFiyatXpath)));
        }
        WebElement sepetBox = driver.findElement(By.xpath("//span[@class='bag']"));
        sepetBox.click();
        List<WebElement> sepetUrunlerList = driver.findElements(By.xpath("//div[@class='shelf-item__details']"));
        // 5.Her bir öğenin fiyatını toplayın ve sonucunuzu web sitesiyle karşılaştırın
        Double actualPriceOfSelect=0.0;
        for(int i=0; i<sitedenSecilenUrunlerFiyatList.size() ; i++){
            String price=sitedenSecilenUrunlerFiyatList.get(i).getText().replace("$","");
            actualPriceOfSelect += Double.parseDouble(price);
        }
        List<WebElement> sepetPriceList = driver.findElements(By.xpath("//div[@class='shelf-item__price']//p"));
        Double expectedPriceOfBasket=0.0;
        for(int i=0; i<sepetPriceList.size() ; i++){
            String price=sepetPriceList.get(i).getText().replace("$","");
            expectedPriceOfBasket += Double.parseDouble(price);
        }
        System.out.println("actualSelectOfPrice = " + actualPriceOfSelect);
        System.out.println("expectedBasketOfPrice = " + expectedPriceOfBasket);

        // 6.Sonuçlar eşleşiyorsa  konsola test pass yazirin
        Assert.assertEquals(actualPriceOfSelect, expectedPriceOfBasket);
        System.out.println("Test Pass");

        // 7.Checkout'a tıklayın
        driver.findElement(By.xpath("//div[@class='buy-btn']")).click();

    }
    }
