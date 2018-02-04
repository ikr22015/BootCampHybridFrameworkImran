package pageobject;

import base.CommonAPI;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MemberSignUpPage extends CommonAPI{
    JavascriptExecutor jsc = (JavascriptExecutor)driver;

    @FindBy(id = "button_1")
    WebElement agree;

    @FindBy(xpath = "//*[@id=\"field_41\"]")
    WebElement memberID;

    @FindBy(xpath = "//*[@id=\"field_2\"]")
    WebElement firstName;

    @FindBy(xpath = "//*[@id=\"field_3\"]")
    WebElement lastName;

    @FindBy(xpath = "//*[@id=\"field_4\"]")
    WebElement dob;

    @FindBy(xpath = "//*[@id=\"field_9\"]")
    WebElement zip;

    @FindBy(xpath = "//*[@id=\"button_1\"]")
    WebElement next;

    @FindBy(xpath = "//*[@id=\"button_7\"]")
    WebElement previous;

    public void clickAgree(){
        jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");//Use JavascriptExecutor selenium api to scroll down license page.
        agree.click();
    }

    public void fillUpForm(){
        jsc.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        memberID.sendKeys("LL0LLL0L");
        firstName.sendKeys("Jhon");
        lastName.sendKeys("Smith");
        dob.sendKeys("01131985");
        zip.sendKeys("11416");
        next.click();
    }
}
