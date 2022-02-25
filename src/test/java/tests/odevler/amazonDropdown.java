package tests.odevler;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class amazonDropdown {
    WebDriver driver;
    Select select;
    WebElement dropdownElementi;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //● https://www.amazon.com/ adresine gidin.
      driver.get("https://www.amazon.com/");
    }
  @Test
    public void test1(){
      //- Test 1
      //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
    	dropdownElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select =new Select(dropdownElementi);
      List<WebElement> optionListesi =select.getOptions();
     int kategoriSayisi=optionListesi.size();
     int beklenen=28;
      Assert.assertEquals(kategoriSayisi,beklenen);


  }@Test
    public void test2() throws IOException {
        //-Test 2
        //	1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");


        //	2. Arama kutusuna Java yazin ve aratin
WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("java"+ Keys.ENTER);
        //	3. Bulunan sonuc sayisinin resmini cekin
WebElement sonucyazisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        File elements=new File("target/screenShot/image.jpg");
        File geciciResim=sonucyazisi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,elements);
        //	4. Sonucun Java kelimesini icerdigini test edin
        Assert.assertTrue(sonucyazisi.getText().contains("java"));


    }
    @AfterClass
    public void teardown(){
       driver.quit();
    }
    }
