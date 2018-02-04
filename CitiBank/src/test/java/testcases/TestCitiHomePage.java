package testcases;

import base.CitiHomePage;
import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TestCitiHomePage extends CommonAPI{
    @Test
    public void testLink(){
        CitiHomePage citiHomePage = PageFactory.initElements(driver,CitiHomePage.class);
        citiHomePage.gotoLink();
    }
}
