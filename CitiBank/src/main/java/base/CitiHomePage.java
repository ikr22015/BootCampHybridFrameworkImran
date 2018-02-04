package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CitiHomePage {
    @FindBy(css = "#creditCards > a")
    WebElement link;

    public void gotoLink(){

        link.click();
    }
}
