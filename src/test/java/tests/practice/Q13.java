package tests.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;
public class Q13 extends TestBase {
    //https://www.gmibank.com/ adresine gidip negative login test yapiniz..
    // test datalar :
    //{"username1@gmail.com","password1"},
    //{"username2@gmail.com","password2"},
    @DataProvider
    public static Object[][] negativeSigInTest(){
        Object [][] bankData = new Object[3][2];
        bankData [0][0] = "username1@gmail.com";
        bankData [0][1] = "password1";
        bankData [1][0] = "username2@gmail.com";
        bankData [1][1] = "password2";
        bankData [2][0] = "username3@gmail.com";
        bankData [2][1] = "password3";
        return bankData;
    }
    @Test (dataProvider = "negativeSigInTest")
    public void test(String username,String password) throws InterruptedException {
        driver.get("https://www.gmibank.com/");
        driver.findElement(By.xpath("//*[@id=\"account-menu\"]/a")).click();  //menu icon
        driver.findElement(By.xpath("//a[@id='login-item']")).click();  //ilk sign in
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(4000);
    }
}


