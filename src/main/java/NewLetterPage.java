import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewLetterPage extends MainPage{

    private WebElement to;
    private WebElement subject;
    private WebElement body;
    private WebElement switchToPlainTxt;
    private WebElement save;
    private WebElement saveDraft;
    private WebElement tempDraftLink;
    private WebElement sendMail;

    public NewLetterPage(WebDriver webDriver){
        super(webDriver);
        to = webDriver.findElement(By.cssSelector("textarea[data-original-name='To']"));
        subject = webDriver.findElement(By.cssSelector("input[name='Subject']"));
        switchToPlainTxt = webDriver.findElement(By.xpath("//span[.='Убрать оформление']"));
        body = webDriver.findElement(By.cssSelector("textarea[name='Body']"));
        save = webDriver.findElement(By.cssSelector("div[data-group='save-more']"));
        sendMail = webDriver.findElement(By.xpath("//span[.='Отправить']"));
}

    public void sendMailAction(){
        sendMail.click();
    }

    public void fillTo(String text){
        to.clear();
        to.sendKeys(text);
    }

    public void fillSubject(String text){
        subject.clear();
        subject.sendKeys(text);
    }

    public void fillBody(String text){
        body.clear();
        body.sendKeys(text);
    }

    public String getBody(){
        return body.getAttribute("value").trim();
    }

    public String getTo(){
        return  to.getText();
    }

    public String getConfirmedMail(){
        WebElement confirmedMail = webDriver.findElement(By
                .xpath("//div[contains(@class, 'b-input b-input_textarea js-compose-labels js-input compose__labels " +
                        "compose__labels_placehold-on-suggest b-contact-container')]"));
        return confirmedMail.getText();
    }

    public String getSubject(){
        return subject.getAttribute("value").trim();
    }

    public void switchToPlainTxtAction(){
        switchToPlainTxt.click();
    }

    public void saveAction(){
        save.click();
    }

    public void saveDraftAction(){
        saveAction();
        saveDraft = webDriver.findElement(By.xpath("//span[.='Сохранить черновик']"));
        saveDraft.click();
    }

    @Override
    public void draftAction(){
        tempDraftLink = webDriver.findElement(By.xpath("//a[.='черновиках']"));
        tempDraftLink.click();
    }

    public void fillLetter(Letter letter){
        fillTo(letter.getTo());
        fillSubject(letter.getSubject());
        switchToPlainTxtAction();
        fillBody(letter.getBody());
    }

    public Letter getLetter(){
        String to = getConfirmedMail();
        String subject = getSubject();
        switchToPlainTxtAction();
        pause(3);
        String body = getBody();
        return new Letter(to, subject, body);
    }

    private void pause(int sec){
        try {
            Thread.sleep(sec*1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
