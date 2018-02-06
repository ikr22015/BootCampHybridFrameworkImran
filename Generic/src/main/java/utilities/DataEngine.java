package utilities;

import base.CommonAPI;
import org.openqa.selenium.By;

public class DataEngine extends CommonAPI{
    private By getElementLocator(String locatorType, String locatorValue){
        switch (locatorType){
            case "ClassName":
                return By.className(locatorValue);
            case "CssSelector":
                return By.cssSelector(locatorValue);
            case "Id":
                return By.id(locatorValue);
            case "LinkText":
                return By.linkText(locatorValue);
            case "Name":
                return By.name(locatorValue);
            case "PartialLinkText":
                return By.partialLinkText(locatorValue);
            case "TagName":
                return By.tagName(locatorValue);
            case "Xpath":
                return By.xpath(locatorValue);
            default:
                return By.id(locatorValue);
        }
    }

    public void performAction(String keyword, String locatorType, String locatorValue,String testData){
        switch (keyword){
            case "Click":
                driver.findElement(getElementLocator(locatorType,locatorValue)).click();
                break;
            case "SendKeyes":
                driver.findElement(getElementLocator(locatorType,locatorValue)).sendKeys(testData);
                break;
                default:
                    System.out.println(keyword+" keyword doesn't match with keyword list. Please fix your keyword.");
        }
    }

    public void performAction(String keyword, String locatorType, String locatorValue){
        switch (keyword){
            case "Click":
                driver.findElement(getElementLocator(locatorType,locatorValue)).click();
                break;
            default:
                System.out.println(keyword+" keyword doesn't match with keyword list. Please fix your keyword.");
        }
    }
}
