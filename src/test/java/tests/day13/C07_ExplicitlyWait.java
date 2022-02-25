package tests.day13;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.time.Duration;

public class C07_ExplicitlyWait extends TestBase {

    @Test
    public void test01(){


        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
        //wait.until(ExpectedConditions.)
    }
}
