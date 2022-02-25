package tests.odevler;

        import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;


        import java.time.Duration;
import java.util.Set;

    public class aaa {

        static WebDriver driver;
        @BeforeClass
        public  static void setup() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)) ;
            ////● https://the-internet.herokuapp.com/windows adresine gidin.
            driver.get("https://the-internet.herokuapp.com/windows ");
        }
        @Test
        public void test1OpeningYazisi(){
            //  //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

            WebElement openingYazi=driver.findElement(By.xpath("//h3[.='Opening a new window']"));
            Assert.assertTrue(openingYazi.isDisplayed(),"Opening Yazisi test1 Failed");
        }
        @Test
        public void test2TitleTheInternet() {
            //  //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
            String actualTitle=driver.getTitle();
            String expectedTitle="The Internet";
            Assert.assertTrue(actualTitle.equals(expectedTitle),"test2TitleTheInternet FAILED");
        }
        @Test
        public void newWindowSekmesiTestleri(){
            //  //● Click Here butonuna basın.
            //  //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
            String ilkAcilanPencere=driver.getWindowHandle();
            String ilkAcilanURL=driver.getCurrentUrl();
            System.out.println("Ilk Acilan Pencerem"+ilkAcilanURL);
            driver.findElement(By.xpath("//a[.='Click Here']")).click();
            //ilk acilan penceredki Click Here tiklattirdik ve su an yeni bir pencere acildi

            //Simdi pencere Degisimi Yapmamiz Lazim Nasil Yaparim

            Set<String> tumAcilanPencereler=driver.getWindowHandles();//*burada Handles cogul*
            //cunku set ile birden fazla acxilan pencere kontrolu yapicaz
            //driver.switchTo() bu method diger pencereye gecis yapmak maksadiyla kullanilir
            //forun degisken turu Set degisken turuyle ayni olmaliki seti kullanayim
            for (String each:tumAcilanPencereler) {
                // windowun parantez içine sıradaki pencereyi yazdım..
                driver.switchTo().window(each); //diger acilan pencereye gecis yap

                //neyle gezer foreach acilan yeni seklmeleri each ismiyle
                //genelde each ismi yerine yeni acilan sekme veya window da yaziliri
            }
            String newActualTitle= driver.getTitle();
            System.out.println(newActualTitle);
            String expectedTitleyazisi="New Window";
            Assert.assertEquals("newWindowsTileTesti FAILED",newActualTitle,expectedTitleyazisi);
            // //● Sayfadaki textin “New Window” olduğunu doğrulayın.
            String newWindowYazisi=driver.findElement(By.xpath("//h3[.='New Window']")).getText();
            String expectednewWindowYazisi="New Window";
            Assert.assertTrue(newWindowYazisi.equals(expectednewWindowYazisi),"New Window Yazisi FAILED");
            // //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
            // “The Internet” olduğunu doğrulayın.
            driver.switchTo().window(ilkAcilanPencere);
            String ilkacilanActualSayfaTitle=driver.getTitle();
            String expected="The Internet";
            Assert.assertEquals("The INTERNET Tiltle FAILED",ilkacilanActualSayfaTitle,expected);

            driver.quit();

        }

    }




