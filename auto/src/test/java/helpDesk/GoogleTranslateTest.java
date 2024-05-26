package helpDesk;

import core.BaseSeleniumTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Google Translate Main Page")
public class GoogleTranslateTest extends BaseSeleniumTest {

    public static MainPage mainPage;

    @Test
    @Tag("Smoke")
    @Epic("Translate")
    @Story("US-5.5")
    @Feature("Translate russia -> english")
    @DisplayName("Translating")
    public void test1() throws InterruptedException {
        String text = "собака";
        String translatedText = "dog";
        mainPage = new MainPage();
        Allure.step("ввод текста", () -> {
            mainPage.translate(text);
            Thread.sleep(2000);
        });

        Allure.step("Сверка значений", () -> {
            Assertions.assertEquals(translatedText, mainPage.getTranslatedText());
        });

    }

    @Test
    @Tag("Smoke")
    @Epic("Translate")
    @Story("US-5.6")
    @Feature("Translate russia -> english")
    @Flaky
    @DisplayName("Translating")
    public void test2() throws InterruptedException {
        String text = "собака";
        String translatedText = "dog";
        String act = new MainPage().translate(text).getTranslatedText();
        Thread.sleep(2000);
        Assertions.assertEquals(translatedText, act);
    }

    @Test
    @Tag("Smoke")
    @Epic("Translate")
    @Story("US-5.7")
    @Feature("Translate russia -> english")
    @DisplayName("Translating")
    public void test3() throws InterruptedException {
        String text = "собака";
        String translatedText = "dog";
        String act = new MainPage().translate(text).getTranslatedText();
        Thread.sleep(2000);
        Assertions.assertEquals(translatedText, act);
    }
}
