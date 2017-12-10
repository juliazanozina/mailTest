import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {

    private WebElement writeMailButton;
    protected WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        writeMailButton = webDriver.findElement(By.cssSelector(".b-toolbar__item"));
    }

    public void writeMailAction() {
        writeMailButton.click();
    }

    public void draftAction() {
        webDriver.findElement(By.xpath("//span[text()='Черновики']")).click();
    }

    public void sendedAction() {
        webDriver.findElement(By.xpath("//span[text()='Отправленные']")).click();
    }
}
