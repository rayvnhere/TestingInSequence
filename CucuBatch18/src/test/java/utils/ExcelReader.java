package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public static List<Map<String,String>> read(String path, String sheetName) throws IOException {
        // To Bring the data from file into the java program
        List<Map<String,String>> excelData=new ArrayList<>();

        try(FileInputStream fis=new FileInputStream(path);
            XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fis);){
            //There can be many sheets we are getting the sheet1 from excel
            Sheet sheet=xssfWorkbook.getSheet(sheetName);
            //getting the number of actual rows that contains the data
            int noOfActualRowsWithData=sheet.getPhysicalNumberOfRows();
            //Getting the row number 0 as we will be using this for all the maps as keys
            Row headerRow=sheet.getRow(0);
            // A loop to go through all the rows
            for (int i = 1; i <noOfActualRowsWithData ; i++) {
                //Getting each row one by one from the map
                Row currentRow=sheet.getRow(i);
                //A new Map for every row
                Map<String,String> rowMap=new LinkedHashMap<>();
                //The Actual no of cells that contains the data in reach row
                int noOfActualCellsWithData=currentRow.getPhysicalNumberOfCells();
                // A loop to go through all the cells
                for (int j = 0; j <noOfActualCellsWithData ; j++) {
                    // From Header, we get the keys
                    String key=headerRow.getCell(j).toString();
                    // From current row we get the values
                    String value=currentRow.getCell(j).toString();
                    //store these keys and values in the map
                    rowMap.put(key,value);
                }
                //Store each map in the list
                excelData.add(rowMap);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return excelData;

    }

    public static List<Map<String,String>> read(String sheetName) throws IOException {
        return read(Constants.EXCEL_FILE_PATH,sheetName);
    }

    public static List<Map<String,String>> read() throws IOException {
        return read(Constants.EXCEL_FILE_PATH,"Sheet1");
    }
}


/* mine doesnt has TRY AND CATCH THING
public class ExcelReader {
    public static List<Map<String,String>> read(String path,String sheetName) throws IOException {
        FileInputStream fis=new FileInputStream(path);
        //A class that understands how excel works
        XSSFWorkbook xssfWorkbook=new XSSFWorkbook(fis);
        //There can be many sheets we are getting the sheet1 from excel
        Sheet sheet=xssfWorkbook.getSheet(sheetName);
        //getting the number of actual rows that contains the data
        int noOfActualRowsWithData=sheet.getPhysicalNumberOfRows();
        // A List of maps to store all the info from Excel sheet

        List<Map<String,String>> excelData=new ArrayList<>();
        //Getting the row number 0 as we will be using this for all the maps as keys
        Row headerRow=sheet.getRow(0);
        // A loop to go through all the rows
        for (int i = 1; i <noOfActualRowsWithData ; i++) {
            //Getting each row one by one from the map
            Row currentRow=sheet.getRow(i);
            //A new Map for every row
            Map<String,String> rowMap=new LinkedHashMap<>();
            //The Actual no of cells that contains the data in reach row
            int noOfActualCellsWithData=currentRow.getPhysicalNumberOfCells();
            // A loop to go through all the cells
            for (int j = 0; j <noOfActualCellsWithData ; j++) {
                // From Header, we get the keys
                String key=headerRow.getCell(j).toString();
                // From current row we get the values
                String value=currentRow.getCell(j).toString();
                //store these keys and values in the map
                rowMap.put(key,value);
            }
            //Store each map in the list
            excelData.add(rowMap);
        }
        return excelData;
    }
    //method overLoaded for flexibility
//this overLoaded method TAKEs 1 PARAMETER
    public static List<Map<String,String>> read(String sheetName) throws IOException {
        return read(Constants.EXCEL_FILE_PATH,sheetName);//same method different parameters
    }
    //this overLoaded method DOESN'T TAKE ANY PARAMETER
    public static List<Map<String,String>> read() throws IOException {
        return read(Constants.EXCEL_FILE_PATH,"Sheet1");//same
        //dont have to write all code of 2 parameter takers, cuz I called the method and it RETURNED ME the method
    }
}

/* when we have to use this class then just write below line for that class to read this file;
               ExcelReader.read(Constants.EXCEL_FILE_PATH,"Sheet1");
saved excelFile's location in 'constants.file's name written in CapitalLetters'
'sheet1' is of excel

 */


/* public static List<Map<String,String>> read(String path,String sheetName)
static > don't want to make multiple object of class + it cant be overridden

What should the method return when called? its list of maps i.e. List<Map<String,String>>

the name of the method is > read, and it has two parameters that the user can input depending on their excel path and sheetNo
*/
/* didn't use final here cuz;
we use final with variables mostly, but with methods we only use when we don't want any childClasss to override them */