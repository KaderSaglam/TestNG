package tests.day14;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.io.File;

public class C04_Screenshot extends TestBase {
    @Test
    public void googleTest(){
        driver.get("http://www.google.com");
        TakesScreenshot tss= (TakesScreenshot) driver;
        File tumsayfaSS=new File("src\\tumSayfa.png");

        tumsayfaSS=tss.getScreenshotAs(OutputType.FILE);

    }
}
