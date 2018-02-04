package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.ProviderLogInPage;
import utilities.GoogleSheetAPI;

import java.io.IOException;
import java.util.List;

public class TestProviderligInPage extends CommonAPI{
    private String spreadsheetId = "1-5vLRfsLnfOXfe8HRL5X8_R2tiZJhPDHzK7TQDZhoIM";
    private String range = "userInfo!A1:B";

    @Test
    public void testProviderLogIn()throws IOException {
        GoogleSheetAPI sheetAPI = new GoogleSheetAPI();
        List<List<Object>> values = sheetAPI.getSpreadSheetRecords(spreadsheetId, range);

        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.gotoProviderLogin();

        for (List<Object> row : values) {
            String _username = row.get(0).toString();
            String _password = row.get(1).toString();
            ProviderLogInPage plp = PageFactory.initElements(driver, ProviderLogInPage.class);
            plp.providerLogIn(_username,_password);
        }
    }
}
