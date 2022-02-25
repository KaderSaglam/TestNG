package tests.practice;
//*****bunada bakilacak
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;
import java.util.List;
import java.util.Random;

public class Twitter_Login extends TestBase {
    @Test
    public void testLogin(){
        driver.get("https://twitter.com");
        driver.findElement(By.xpath("//a[@data-testid='signupButton']")).click();
        Faker faker=new Faker();
        WebElement isimElement=driver.findElement(By.xpath("(//input[@class='r-30o5oe r-1niwhzg r-17gur6a r-1yadl64 r-deolkf r-homxoj r-poiln3 r-7cikom r-1ny4l3l r-t60dpp r-1dz5y72 r-fdjqy7 r-13qz1uu'])[1]"));
        isimElement.click();
        isimElement.sendKeys(faker.name().fullName());
        driver.findElement(By.xpath("//span[text()='E-posta kullan']")).click();
        WebElement emailElement=driver.findElement(By.xpath("(//input[@class='r-30o5oe r-1niwhzg r-17gur6a r-1yadl64 r-deolkf r-homxoj r-poiln3 r-7cikom r-1ny4l3l r-t60dpp r-1dz5y72 r-fdjqy7 r-13qz1uu'])[2]"));
        emailElement.click();
        emailElement.sendKeys(faker.internet().emailAddress());
        WebElement ayElement=driver.findElement(By.xpath("//select[@id='SELECTOR_1']"));
        Select select1=new Select(ayElement);
        List<WebElement> ayList=select1.getOptions();
        Random rnd=new Random();
        int ay=rnd.nextInt(ayList.size()+1);
        System.out.println(ay);
        ayElement.sendKeys(ayList.get(ay).getText());
        WebElement gunElement=driver.findElement(By.xpath("//select[@id='SELECTOR_2']"));
        Select select2=new Select(gunElement);
        List<WebElement> gunList=select2.getOptions();
        int gun=rnd.nextInt(gunList.size()+1);
        System.out.println(gun);
        gunElement.sendKeys(gunList.get(gun).getText());
        WebElement yilElement=driver.findElement(By.xpath("//select[@id='SELECTOR_3']"));
        Select select3=new Select(yilElement);
        List<WebElement> yilList=select3.getOptions();
        System.out.println(yilList.size());
        int yil=rnd.nextInt(yilList.size()+1);
        yilElement.sendKeys(yilList.get(yil).getText());
        driver.findElement(By.xpath("//div[@class='css-18t94o4 css-1dbjc4n r-sdzlij r-1phboty r-rs99b7 r-peo1c r-1ps3wis r-1ny4l3l r-1guathk r-o7ynqc r-6416eg r-lrvibr']")).click();
        driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
        driver.findElement(By.xpath("(//div[@role='button'])[4]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0']")).getText().contains("Sana bir kod gönderdik."));
    }
}
