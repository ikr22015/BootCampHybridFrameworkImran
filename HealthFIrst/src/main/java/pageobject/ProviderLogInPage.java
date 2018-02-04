package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProviderLogInPage {
    @FindBy(xpath = "//*[@id=\"aspnetForm\"]/div[3]/table/tbody/tr[1]/td/div[1]/a/img")
    WebElement providerLogInPageTitle;

    @FindBy(xpath = "//*[@id=\"caa937ce-2aa7-4bb5-b3fc-c87a7d1ce25b\"]/h2[1]/a")
    WebElement goTOHomePage;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_uxLoginForm_ctl00_uxUserNameText\"]/input")
    WebElement providerUserNameField;

    @FindBy(xpath = "//*[@id=\"ctl00_MainContent_uxLoginForm_ctl00_uxPasswordText\"]/input")
    WebElement providerPasswordFieldfield;

    @FindBy(xpath = "//input[@name = \"ctl00$MainContent$uxLoginForm$ctl01$uxLoginButton\"]")
    WebElement providerLogInBtn;

    @FindBy(xpath = "//*[@id=\"7431182f-c908-48ee-9a30-0b6aeb2ed834\"]/p[1]/a/span[1]")
    WebElement providerFogetPassword;

    @FindBy(xpath = "//*[@id=\"7431182f-c908-48ee-9a30-0b6aeb2ed834\"]/p[3]/span/span/a")
    WebElement providerSignUp;

    public void goToHomePage(){
        goTOHomePage.click();
    }

    public void providerLogIn(String username, String password){
        providerUserNameField.sendKeys(username);
        providerPasswordFieldfield.sendKeys(password);
        providerLogInBtn.click();
    }

    public void providerForgetPass(){
        providerFogetPassword.click();
    }

    public void providerSignUp(){
        providerSignUp.click();
    }
}
