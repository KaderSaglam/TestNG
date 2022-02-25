package tests.day12;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;
public class C05_KeyboardActions extends TestBase {
    //1- Bir Class olusturalim KeyboardActions1
    //2- https://www.amazon.com sayfasina gidelim
    //3- Arama kutusuna actions method’larine kullanarak samsung A71 yazdirin ve Enter’a basarak arama yaptirin
    //4- aramanin gerceklestigini test edin
    @Test
    public void test01() throws InterruptedException {
        //2- https://www.amazon.com sayfasina gidelim
        //3- Arama kutusuna actions method’larine kullanarak Samsung A71 yazdirin
        // ve Enter’a basarak arama yaptirin
        //4- aramanin gerceklestigini test edin
        driver.get("https://www.amazon.com");
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Actions actions=new Actions(driver);
        actions.click(aramaKutusu).
                keyDown(Keys.SHIFT).
                sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung ").
                keyDown(Keys.SHIFT).
                sendKeys("a").
                keyUp(Keys.SHIFT).
                sendKeys("71").
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(5000);
    }
}