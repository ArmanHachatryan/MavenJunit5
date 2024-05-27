import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class AppTest {

    @Test
    public void start() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("app.properties"));
        String age = System.getProperty("age");
        System.out.println(age);
    }

    @Test
    public void test2() {
        var f = ConfigProvider.readConfig().getBoolean("userParams.admin.isAdmin");
        System.out.println(f);
    }

}
