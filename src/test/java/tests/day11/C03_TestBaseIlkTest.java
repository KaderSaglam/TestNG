package tests.day11;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseIlkTest extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com/");

    }
}
