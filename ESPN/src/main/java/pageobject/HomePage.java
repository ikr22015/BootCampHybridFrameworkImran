package pageobject;

import base.CommonAPI;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.MongoConnection;

public class HomePage extends CommonAPI{
    JavascriptExecutor jsc = (JavascriptExecutor)driver;

    @FindBy(css = "#sideLogin-left-rail > button.button-alt.lg")
    WebElement loginLink;

    @FindBy(css = "#did-ui > div > div > section > section > form > section > div:nth-child(1) > div > label > span.input-wrapper > input")
    WebElement usernameField;

    @FindBy(css = "#did-ui > div > div > section > section > form > section > div:nth-child(2) > div > label > span.input-wrapper > input")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"did-ui\"]/div/div/section/section/form/section/div[3]/button[2]")
    WebElement loginButton;

    public void goToLogin() throws InterruptedException{
        jsc.executeScript("javascript:window.scrollBy(250,700)");
        Thread.sleep(2000);
        loginLink.click();
        driver.switchTo().frame(driver.findElement(By.cssSelector("#disneyid-iframe")));
    }

    public void login()throws InterruptedException{
        MongoConnection.connectMongoDB("ESPN","users");
        BasicDBObject basicDBObject = new BasicDBObject();
        FindIterable<Document> iterable = MongoConnection.collection.find(basicDBObject);
        for (Document it:iterable){
            String username = (String) it.get("username");
            String password = (String) it.get("password");
            usernameField.clear();
            Thread.sleep(100);
            usernameField.sendKeys(username);
            Thread.sleep(100);
            passwordField.clear();
            Thread.sleep(100);
            passwordField.sendKeys(password);
            Thread.sleep(100);
            loginButton.click();

            Thread.sleep(3000);
        }
    }
}
