import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private String login;
    private String password;
    private WebElement loginContainer;
    private WebElement passwordContainer;
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver, String login, String password) {
        this.login = login;
        this.password = password;
        loginContainer = webDriver.findElement(By.id("mailbox:login"));
        passwordContainer = webDriver.findElement(By.id("mailbox:password"));
        submitButton = webDriver.findElement(By.id("mailbox:submit"));
    }

    public void loginAction() {
        fillLoginContainer(login);
        fillPasswordContainer(password);
        submit();
    }

    public void fillLoginContainer(String text){
        loginContainer.clear();
        loginContainer.sendKeys(text);
    }

    public void fillPasswordContainer(String text){
        passwordContainer.clear();
        passwordContainer.sendKeys(text);
    }

    public void submit(){
        submitButton.click();
    }

}
