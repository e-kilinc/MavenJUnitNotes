package techproed.day8_Assertation;

import org.junit.Assert;
import org.junit.Test;

public class C06_Assertion {

    /*
 Assertionlarda eşitlik için expected,actual olarak kullanılır
  */

    @Test
    public void test01() {
        Assert.assertEquals(2,2);
        System.out.println("Test Basarili bir sekilde calisti");
    }

    @Test
    public void test02() {
        Assert.assertEquals(2,3);
        System.out.println("Test Basarili bir sekilde calisti");
    }

    @Test
    public void test03() {
        Assert.assertNotEquals(5,4);
        System.out.println("Test Basarili bir sekilde calisti");
    }

    @Test
    public void test04() {
        String actualName = "erol";
        String expectedName = "Erol";

        Assert.assertEquals(actualName, expectedName);
        System.out.println("Test Basarili bir sekilde calisti");
    }

    @Test
    public void test05() {
        int yas = 50;
        int emeklilikYas = 65;

        Assert.assertFalse(emeklilikYas<yas);
        System.out.println("Emeklilik testi basariyla calisti");
    }
}
