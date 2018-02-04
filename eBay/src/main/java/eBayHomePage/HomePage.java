package eBayHomePage;

import utilities.DataEngine;
import utilities.GoogleSheetAPI;

import java.util.List;


public class HomePage{
    private String spreadsheetId = "1CJZo9iVtPhuN4bmeTcKPWuXFrA_A0xgCpNW9EZjgFrc";
    private String range = "TC01!A2:F";
    public void search()throws Exception{
        DataEngine dataEngine = new DataEngine();
        GoogleSheetAPI sheetAPI = new GoogleSheetAPI();
        List<List<Object>> rows = sheetAPI.getSpreadSheetRecords(spreadsheetId, range);

        for (List<Object> column : rows) {
            String keyword = column.get(2).toString();
            String locatorType = column.get(3).toString();
            String locatorValue = column.get(4).toString();
            String testData = column.get(5).toString();
            dataEngine.performAction(keyword,locatorType,locatorValue,testData);
        }
    }
}
