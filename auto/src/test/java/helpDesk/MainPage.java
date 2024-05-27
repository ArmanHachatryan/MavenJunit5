package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BaseSeleniumPage {
    @FindBy(xpath = "//select[@id='id_queue']")
    private WebElement queueList;

    public MainPage() {
        driver.get("");
        PageFactory.initElements(driver, this);
    }
}
