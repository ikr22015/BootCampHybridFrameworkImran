package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.HomePage;
import reporting.TestLogger;

public class TestHomePage extends CommonAPI{
    @Test
    public void testSearch(){
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.search();
    }

    @Test
    public void testLangChangeEnglishToChinese(){
        TestLogger.log(getClass().getSimpleName() + ": " + converToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.langChangeEnglishToChinese();
    }
}
