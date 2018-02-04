package utilities;

import base.CommonAPI;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile extends CommonAPI{
    HSSFWorkbook wb = null;
    HSSFSheet sheet = null;

    public ReadExcelFile(){

    }

    public ReadExcelFile(String excelPath){
        try {
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new HSSFWorkbook(fis);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public String getData(int sheetNumber, int row, int column){
        sheet = wb.getSheetAt(sheetNumber);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(int sheetIndex){
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }

    public static void main(String[] args) {
        System.out.printf("");
    }
}
