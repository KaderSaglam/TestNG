package tests.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q8 extends TestBase {



@Test
    public void test() throws InterruptedException {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
    WebElement iframe=driver.findElement(By.xpath("//iframe[@id='emoojis']"));
    driver.switchTo().frame(iframe);
    //driver.switchTo().frame("emoojis"); yukardaki 2 satir yerine bu sekilde de kullanimi olur
    // ikinci emojiye tıklayın
    WebElement secondEmoji = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
    secondEmoji.click();
    // tüm ikinci emoji öğelerini tıklayın
    List<WebElement> emojiOgeler = driver.findElements(By.xpath("//div[@id ='nature']/div/img"));
    for (WebElement w:emojiOgeler) {
        w.click();
    }

    //  emojiOgeler.stream().forEach(x-> x.click());

    System.out.println("ogeler tiklandi");
    Thread.sleep(3000);
    // parent iframe e geri donun
    driver.switchTo().defaultContent();
    // formu doldurun,(Formu istediğiniz metinlerle doldurun)
    List<WebElement> metinGirList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));  //classlar ayni
    List<String> metinler = new ArrayList<>(Arrays.asList("Bir", "iframe", "sorusu", "bu", "kadar", "eglenceli",
            "olabilir", "sizce de ","oyle degil mi?", "", ""));
    for (int i = 0; i < metinGirList.size(); i++) {
        metinGirList.get(i).sendKeys(metinler.get(i));
    }
    Thread.sleep(3000);
    //  apply button a basin
    driver.findElement(By.xpath("//button[@id ='send']")).click();
}
}