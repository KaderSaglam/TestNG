package tests.practice;

import org.testng.annotations.Test;
/*
  ●TestNG (default ) olarak @Test methodları ni alfabetik sıraya gore run eder ..(Yukardan asagi degil)
  ●priority annotation Testlere öncelik vermek icin kullanilir, Kucuk olan Numara daha once calisir.
  priority:  TestNG testlerinde, testler konsola alfabetik sira ile yazdirilir.

  enabled = false  methodu : Testi gormezden gelmek icin @Test in yanina    '(enabled = false)' fonksiyonunu kullaniriz.
 */

public class Q1 {
    @Test(priority = 3000)
    public void b(){
        System.out.println("b");
    }
    @Test(priority = 2001, enabled = false) //gormezden gelme
    public void a(){
        System.out.println("a");
    }

    @Test(priority =2000 )
    public void c(){
        System.out.println("c");
    }
    @Test
    public void test1(){
        System.out.println("Test1......");
    }
    @Test
    public void test2(){
        System.out.println("Test2......");
    }
    @Test
    public void test3(){
        System.out.println("Test3......");
    }
    @Test(enabled = false)
    public void test4(){
        System.out.println("Test4......");
    }
    @Test(enabled = false)
    public void test5(){
        System.out.println("Test5......");
    } @Test
    public void test16(){
        System.out.println("Test6......");
    }


}
