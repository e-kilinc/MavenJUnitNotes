package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Faker {
    @Test
    public void faker() {
        //Faker classindan sahte verileri kullanabilmek icin obje olkusturmamiz gerekir

        Faker faker = new Faker();



        //Faker objesini kullanarak bir isim yazdiriniz
        System.out.println("Isim: " +faker.name().firstName());

        //faker objesini kullanarak last name yazdiriniz
        System.out.println("Soyisim: " +faker.name().lastName());

        //faker objesini kullanarak full name yazdiriniz
        System.out.println("Isim - Soyisim: " +faker.name().fullName());

        //faker objesini kullanarak adres yazdiriniz
        System.out.println("Adres: " +faker.address().fullAddress());

        //faker objesini kullanarak telefon yazdiriniz
        System.out.println("Cep: " +faker.phoneNumber().cellPhone());
        System.out.println("Telefon: " +faker.phoneNumber().phoneNumber());

        //rastgele 15 haneli bir numara yazdiralim
        System.out.println("Rastgele 15 haneli bir numara: " +faker.number().digits(15));

        //rastgele bir meslek yazdirim
        System.out.println("Is: " +faker.job().position());




    }
}
