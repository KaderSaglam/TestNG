package tests.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;


public class EnableTest {
    //Explicit Wait Class Work
    //1. Bir class olusturun : EnableTest
    //2. Bir metod olusturun : isEnabled()
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Textbox’in etkin olmadigini(enabled) dogrulayın
    //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //7. Textbox’in etkin oldugunu(enabled) dogrulayın
 WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
    }@Test
    public void isEabled(){
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
//4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(aramaKutusu.isEnabled());
        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

      WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(15));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Enable']"))).click();

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        WebElement itsEnabled=driver.findElement(By.xpath("//p[@id='message']"));
        Assert.assertTrue(itsEnabled.isDisplayed());
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın
        Assert.assertTrue(aramaKutusu.isEnabled());
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
