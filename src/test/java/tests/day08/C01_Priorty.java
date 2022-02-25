package tests.day08;
import org.testng.annotations.Test;
public class C01_Priorty {
    // Alfabetik sirali olarak calisir
    // priority sırasina gore calisir
    @Test (priority = -9)
    public void youtubetest01(){
        System.out.println("Youtube testi calisti");
    }

    @Test
    public void amazontest02(){ // priority atanmazsa, priority=0 olarak kabul eder!
        System.out.println("Amazon testi calisti");
    }
    @Test (priority = 5)
    public void bestbuytest03(){
        System.out.println("BestBuy testi calisti");
    }
}



