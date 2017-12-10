import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LettersContainer {

    private List<WebElement> mailList;

    public LettersContainer(WebDriver webDriver) {
        WebElement mailContainer = webDriver.findElement(By.xpath("//div[contains(@class, 'b-datalist_letters_to')]"))
                .findElement(By.className("b-datalist__body"));
        this.mailList = mailContainer.findElements(By.className("b-datalist__item"));
    }

    public WebElement getLetter(int number) {
        if (mailList != null) {
            return mailList.get(number);
        }
        return null;
    }


}
