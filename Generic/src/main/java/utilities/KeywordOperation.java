package utilities;

import base.CommonAPI;
import org.openqa.selenium.By;

public class KeywordOperation extends CommonAPI {

    public void perform(String operation, String objectType, String locator)throws Exception{
        switch (operation){
            case "CLICK":
                driver.findElement(this.getObject(objectType,locator)).click();
                break;
            case "SETTEXT":
                driver.findElement(this.getObject(objectType,locator)).sendKeys("Book");
                break;
            default:
                break;
        }
    }

    private By getObject(String objectType, String locator)throws Exception{
        if (objectType.equalsIgnoreCase("XPATH")){
            return By.xpath(locator);
        }else if (objectType.equalsIgnoreCase("ID")){
            return By.id(locator);
        }else if (objectType.equalsIgnoreCase("CSS")){
            return By.cssSelector(locator);
        }else
        {
            throw new Exception("Wrong object type");
        }
    }
}
