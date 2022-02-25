package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Q5  {
    //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    //maximize the window
//click on action dialog button
    //if need use explicitly wait
//click on the ok button
//accept the iframe message

   WebDriver driver;
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
        @Test
    public void test1(){
            //go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
            //maximize the window
            driver.manage().window().maximize();
            //click on action dialog button
            //if need use explicitly wait
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='action']"))).click();
            //click on the ok button
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='dialog-mycodemyway-action']"))).click();
            //accept the iframe message
            driver.switchTo().alert().accept();
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
