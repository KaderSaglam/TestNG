package tests.day12;
import org.testng.annotations.Test;
import tests.day10.C01_Allerts;
import utilities.TestBase;
public class C01_TestBaseKullanim {

    @Test
    public void test01(){
        // projeniz icerisindeki herhangi bir class'dan obje olusturabilir ve
        // o obje sayesinde ait oldugu class'daki tum variable ve method'lara
        // (access modfier izin verdigi surece) ulasabilirim
        C01_Allerts obj=new C01_Allerts();

        // eger proje kapsaminda bir class'dan obje olusturulmasini engellemek isterseniz
        // 1- o class'in constructor'ini private yapabiliriz
        // 2- class'in kendisini abstract yapabiliriz
        // 1.method cok tercih edilmez cunku OOP consept'e uymaz(cok sinirli sayida kullanimi vardir)
        // 2.method'u kullanabiliriz, boylece o class'daki abstract olmayan (concrete)
        // method'lari override etmek mecburiyeti olmadan kullanabiliriz
        // ama obje olusturamayiz

        // ornegin biz testBase class'ini abstract yaptigimizdan obje olusturamayiz
        // ama child class'lardan TestrBase'deki setUp ve teardown method'larini kullanabiliriz
        // TestBase obj1=new TestBase();



    }

}

