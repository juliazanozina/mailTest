import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DraftTest {

    public static final String DRIVER_PATH = "C:\\Program Files\\Google\\Chrome\\chromedriver_win32\\chromedriver.exe";

    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        webDriver = new ChromeDriver();
        webDriver.get("https://mail.ru/");
    }

    @Test
    public void test() {
        LoginPage loginPage = new LoginPage(webDriver, "zanozina.julia@mail.ru", "123qwe/");
        loginPage.loginAction();
    }

    @After
    public void tearDown() {
       // webDriver.quit();
    }

}
