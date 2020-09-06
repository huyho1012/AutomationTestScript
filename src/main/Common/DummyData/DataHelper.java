package Common.DummyData;
import com.github.javafaker.Faker;
import java.util.Locale;
public class DataHelper {
    private final Locale locale = new Locale("vi");
    private final Faker faker = new Faker(locale);

    public static DataHelper getData() {
        return new DataHelper();
    }

    public String getCompanyName(){
        return  faker.company().name();
    }

    public String getCompanyPhone() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getCompanyEmail(){
        return  faker.internet().emailAddress();
    }

    public String getTaxCode(){
        return faker.commerce().promotionCode(10);
    }


    public String getAddress(){
        return faker.address().fullAddress();
    }

    public String getZipCode(){
        return faker.address().zipCode();
    }
    // Tên người dùng
    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.address().firstName();
    }

    public String getFullName(){
        return faker.name().fullName();
    }


}
