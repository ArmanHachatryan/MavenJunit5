package helpDesk;

import core.BaseSeleniumTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GoogleTranslateTest extends BaseSeleniumTest {

    @Test
    public void test1() throws InterruptedException {
        String text = "соба";
        String translatedText = "dog";

        String act = new MainPage().translate(text).getTranslatedText();

        Thread.sleep(2000);
        Assertions.assertEquals(translatedText, act);
    }

    @Test
    public void test2() throws InterruptedException {
        String text = "собака";
        String translatedText = "dog";

        String act = new MainPage().translate(text).getTranslatedText();

        Thread.sleep(2000);
        Assertions.assertEquals(translatedText, act);
    }

    @Test
    public void test3() throws InterruptedException {
        String text = "собака";
        String translatedText = "dog";

        String act = new MainPage().translate(text).getTranslatedText();

        Thread.sleep(2000);
        Assertions.assertEquals(translatedText, act);
    }
}
