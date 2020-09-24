package Common.ExcelUitls;

import Common.GlobalVariables;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Platform;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtil {
    public static final String USER_FOLDER = System.getProperty("user.dir");
    public static String excelPath;

    private static XSSFWorkbook excelBook;
    private static XSSFSheet excelWSheet;
    private static XSSFCell cell;
    private static XSSFRow row;

    public static int rowNumber;

    public static int columnNumber;

    public static void setRowNumber(int prowNumber) {
        rowNumber = prowNumber;
    }
    public static int getRowNumber() {
        return rowNumber;
    }

    public static void setColumnNumber(int pcolumnNumber) {
        columnNumber = pcolumnNumber;
    }
    public static int getColumnNumber() {
        return columnNumber;
    }


    public static void  setExcelFileSheet(){
//        if(Platform.getCurrent().toString().equalsIgnoreCase("MAC")){
//            excelPath = USER_FOLDER + "//src//main//Common//ExcelUitls//" +fileName;
//        } else if(Platform.getCurrent().toString().equalsIgnoreCase("WIN")) {
//            excelPath = USER_FOLDER + "\\src\\main\\Common\\ExcelUitls\\" +fileName;
//        }
        String fileName = "loginData.xlsx";
        excelPath = USER_FOLDER + "\\JsonData\\" +fileName;

        try{
            FileInputStream excelFile = new FileInputStream(excelPath);
            excelBook = new XSSFWorkbook(excelFile);
            excelWSheet = excelBook.getSheet("LoginTestCase");
        }catch (Exception e){
            try {
                throw (e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static String getCellData(int rowNum, int colNum){
        try{
            cell = excelWSheet.getRow(rowNum).getCell(colNum);
            DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
        }catch (Exception e){
            throw (e);
        }
    }

    public static XSSFRow getRowData(int rowNum){
        try {
            row = excelWSheet.getRow(rowNum);
            return row;
        } catch (Exception e){
            throw (e);
        }
    }
    public static void setCellData(String value, int rowNumber, int columnNumber){
        try {
            row = excelWSheet.getRow(rowNumber);
            cell = row.getCell(columnNumber);
            if(cell==null){
                cell = row.createCell(columnNumber);
                cell.setCellValue(value);
            }
            else {
                cell.setCellValue(value);
            }
            FileOutputStream fileOut = new FileOutputStream(excelPath);
            excelBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            try {
                throw (e);
            }catch (IOException e1){
                e1.printStackTrace();
            }
        }
    }

}
