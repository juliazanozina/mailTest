import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class DraftTest {

    public static final String DRIVER_PATH = "C:\\Program Files\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe";

    public static final String TO = "zanozina.julia@gmail.com";
    public static final String SUBJECT = "subject";
    public static final String BODY = "move your body";

    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.ru/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LoginPage loginPage = new LoginPage(webDriver, "zanozina.julia@mail.ru", "123qwe/");
        loginPage.loginAction();
    }

    @Test
    public void testSaveDraft() throws Exception {
        InboxPage inboxPage = new InboxPage(webDriver);
        inboxPage.writeMailAction();

        NewLetter newLetter = new NewLetter(webDriver);
        Letter letter = new Letter(TO, SUBJECT, BODY);
        newLetter.fillLetter(letter);
        newLetter.saveDraftAction();

        Thread.sleep(4000);
        newLetter.draftAction();
        Thread.sleep(3000);
        MailList mailList = new MailList(webDriver);
        mailList.getLetter(0).click();
        Thread.sleep(3000);
        Letter actualLetter = newLetter.getLetter();

        assertEquals(letter, actualLetter);
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

}
