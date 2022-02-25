package tests.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class pratik {
     /*
   ...Exercise6...
// 1. Amazon.com'a gidelim.
// 2. DropDown üzerinde Books secelim.(All yazan yerde)
//    kategorilerin hepsini konsola yazdiralim
// 3. Arama kutusuna Les Miserables yazalım ve arama yapalim.
// 4. Sonuc sayisini ekrana yazdiralim.
// 5. Sonucların Les Miserables i icerdigini assert edelim
*/
     WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void dropdownTesti(){
        driver.navigate().to("https://www.amazon.com");
        WebElement dropdownElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownElementi);
        select.selectByVisibleText("Books");
        List<WebElement> optionList = select.getOptions();
        for (WebElement each: optionList
        ) {
            System.out.println(each.getText());
        }
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Les Miserables");
        aramaKutusu.submit();
        WebElement sonucSayisi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucSayisi.getText());

        String sonuCyazisi="Les Miserables";

        Assert.assertTrue(sonucSayisi.getText().contains(sonuCyazisi),"sonuc yazisi Les Miserables icermiyor");
    } @AfterMethod
    public void teardown(){
        driver.close();
    }
}
