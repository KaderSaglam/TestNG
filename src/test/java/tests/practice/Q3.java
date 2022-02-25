package tests.practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Q3 {
    // go to url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
//-->Task1 Find Dropdown on Multi Selection
//-->Task2 Find all Dropdown Elements on page
//-->Task3 printout DropDown Elements' number
//-->Task4 choose all dropdown elements and printout dropdown elements' name
//-->Task5 check until choise 6'
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
    }@Test
    public void test1() throws InterruptedException {
        //-->Task1 Find Dropdown on Multi Selection
        WebElement dropdownElementi= driver.findElement(By.xpath("//input[@id='justAnInputBox']"));
        dropdownElementi.click();
        //-->Task2 Find all Dropdown Elements on page
        List<WebElement> droplist=driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
        //-->Task3 printout DropDown Elements' number
        System.out.println("droplistteki elementlerin sayisi : "+droplist.size());//45
        //-->Task4 choose all dropdown elements and printout dropdown elements' name
        for (int i = 0; i < droplist.size(); i++) {
            String text=droplist.get(i).getText();
            System.out.println("text =  "+text);

            if (!text.isEmpty()){
                droplist.get(i).click();
            }
            //-->Task5 check until choice 6'
            if (text.equals("choice 6")) {
                droplist.get(i).click();
                break;
            }
        }

    }
}

