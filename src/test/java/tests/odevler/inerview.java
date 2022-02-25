package tests.odevler;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class inerview {
 WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("//https://www.chanel.com/us/");
    }


    @Test
    public void test1(){
        //https://www.chanel.com/us/
        //1st test:
        //    1- Accessing the site --> OK if the site is displayed

        //    2- Click on the search bar (on the top menu)
        //    3- Search for "ROUGE ALLURE"
        //    3- Check if the items of the displayed list contain the searched word
        //    4- Select the second item of the list
        //    5- Make sure that the displayed product name is the same as the previously selected name.

    }
    @Test
    public void test2(){
        //2nd test:
        //    1- Access to the site
        //    2- Access to Makeup => Lipstick category (on top menu)
        //    3- Click on ROUGE ALLURE product
        //    4- Add the product to the cart
        //    5- View Cart --> OK, if there is a "ROUGE ALLURE" product in the cart,
        //    the quantity=1 and the total cart is equal to the product price.
    }@AfterClass
    public void teardown(){

    }


}
