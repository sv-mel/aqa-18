import com.github.javafaker.Faker;

public class FakerUtil {

    static Faker faker = new Faker();

    public static String randomName() {
        return faker.lorem().word();
    }
    public static Long randomId() {
        return faker.random().nextLong(100);
    }
}
