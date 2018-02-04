package eBayHomePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.MongoConnection;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import org.bson.Document;

public class Login {
    @FindBy(css = "#gh-ug > a")
    WebElement signInlink;

    @FindBy(xpath = "//input[@name=\"userid\"]")
    WebElement usernameField;

    @FindBy(xpath = "//input[@name=\"pass\"]")
    WebElement passwordField;

    @FindBy(xpath = "//div[@id = \"btnWrapper2\"]/input[@type=\"submit\"]")
    WebElement signInButton;

    public void goToLoginAndRegiPage(){
        signInlink.click();
    }
    //fetch data from mongoDB
    public void login()throws InterruptedException{
        MongoConnection.connectMongoDB("SEFramework","profile");
        BasicDBObject basicDBObject = new BasicDBObject();
        FindIterable<Document> iterable = MongoConnection.collection.find(basicDBObject);
        for (Document it:iterable){
            String _username = (String) it.get("username");
            String _password = (String) it.get("password");
            usernameField.clear();
            Thread.sleep(100);
            usernameField.sendKeys(_username);
            Thread.sleep(100);
            passwordField.clear();
            Thread.sleep(100);
            passwordField.sendKeys(_password);
            Thread.sleep(100);
            signInButton.click();
            Thread.sleep(2000);
        }
    }
}
