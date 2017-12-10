import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SentLetterPage extends MainPage{

    private WebElement to;
    private WebElement subject;
    private WebElement body;

    public SentLetterPage(WebDriver webDriver){
        super(webDriver);
        to = webDriver.findElement(By.xpath("//span[contains(@class, 'b-letter__head__addrs__value')]"));
        subject = webDriver.findElement(By.xpath("//div[contains(@class, 'b-letter__head__subj__text')]"));
        body = webDriver.findElement(By.xpath("//div[contains(@class, 'js-body b-letter__body__wrap')]"));
    }

    public String getTo(){
        return to.getText().trim();
    }

    public String getSubject(){
        return subject.getText().trim();
    }

    public String getBody(){
        return body.getText().trim();
    }

    public Letter getLetter(){
        String to = getTo();
        String subject = getSubject();
        String body = getBody();
        return new Letter(to, subject, body);
    }

}
