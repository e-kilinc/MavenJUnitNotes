package techproed.day07MavenJunit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {

        /*
           Notasyonlara sahip methodlar oluşturabilmek için
           mause+sağtik+generate(kısayol alt+insert) yaparak
       after methodu için teardown'u seçeriz.
       before methodu için setup'ı seçeriz.
       test methodu için de test'i seçeriz.
           Junit frameworkunde testlerimizi sıralama yapabilmek için ekstra bir notasyon yoktur
       Eğer belli bir sıralamada çalıştırmak istersek method isimlerini alfabetik ve
       sayıl olarak belirtmemiz gerekir.
        */
    @Before
    public void setUp() throws Exception {
        System.out.println("Her test metodundan once bir kez calisir");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test metodundan sonra bir kez calistiriliz");

    }

    @Test
    public void test1() {
        System.out.println("Test 1 metodu calisti");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 metodu calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test 3 metodu calisti");
    }
}
