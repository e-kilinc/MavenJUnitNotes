package techproed.day8_Assertation;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    //BeforeClass ve AfterClass metotlari static olmak zorundadir


    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classtan once BeforeClass methodu bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her Classtan sonra AfterClass methodu bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her metottan once Before methodu birkez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her metottan sonra After metodu birkez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test01 metodu calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test02 metodu calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test02 metodu calisti");
    }
}
