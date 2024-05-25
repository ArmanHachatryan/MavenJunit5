package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//textarea")
    private WebElement inputText;

    @FindBy(xpath = "(//span[text()='английский'])[2]/../..")
    private WebElement selectEnglish;

    @FindBy(xpath = "//*[@class='ryNqvb']")
    private WebElement translatedText;



    public MainPage() {
        driver.get("https://translate.google.com/");
        PageFactory.initElements(driver, this);

    }

    public String getTranslatedText() {
        return translatedText.getText();
    }

    public MainPage translate(String text) {
        inputText.click();
        inputText.sendKeys(text);
        selectEnglish.click();
        return this;
    }
}
