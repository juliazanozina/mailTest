import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebElement writeMailButton;
    private WebElement draftButton;
    private WebElement sendedButton;
    protected WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        writeMailButton = webDriver.findElement(By.cssSelector(".b-toolbar__item"));
        draftButton = webDriver.findElement(By.cssSelector("a[href='/messages/drafts/']"));
        sendedButton = webDriver.findElement(By.xpath("//span[.='Отправленные']"));
    }

    public void writeMailAction() {
        writeMailButton.click();
    }

    public void draftAction() {
        draftButton.click();
    }

    public void sendedAction() {
        sendedButton.click();
    }
}
