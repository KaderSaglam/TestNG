package tests.odevler;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.testng.Assert;
        import org.testng.annotations.BeforeClass;
        import org.testng.annotations.Test;

        import java.time.Duration;
        import java.util.Set;

public class Q11 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){


        // go to url :http://demo.guru99.com/popup.php
        driver.get("http://demo.guru99.com/popup.php");
        //      get the first window
        String ilkpencere= driver.getWindowHandle();
        //      clicking on click here button
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        //      get all the window in the set
        Set<String> pencereler =driver.getWindowHandles();
        String ikinciPencere="";
        for (String each:pencereler
        ) {
            if (!each.equals(ilkpencere)) {
                ikinciPencere=each;
            }

        }

        //      switch to window
        driver.switchTo().window(ikinciPencere);
        //      input email id (somepne@gmail.com) and type something in that input
        //      Clicking on the submit button
        WebElement emailIdElement = driver.findElement(By.cssSelector("[name=\"emailid\"]"));
        emailIdElement.click();
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

        //      verify title as expected
        String actualTitle= driver.getTitle();
        String expectedTitle="Guru99 Bank Home Page";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //      switch to first window
        driver.switchTo().window(ilkpencere);
    }

}
