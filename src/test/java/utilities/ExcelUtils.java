package utilities;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    // workbook
    // sheet
    // row
    // cell class
    // filePath

    // openExcelFile(String path, String sheetName)  -> void
    // getValue(int rowNum, int cellNum)  -> return String
    // setValue(String value, int rowNum, int cellNum) -> return void
    // getNumberOfRows() -> return int num of row

    private static XSSFWorkbook workbook;
    private static XSSFSheet excelSheet;
    private static XSSFRow row;
    private static XSSFCell cell;
    private static String filePath;

    /**
     * This method will open excel file
     *
     * @param excelFileName
     * @param SheetName
     */

    public static void openExcelFile(String excelFileName, String SheetName) {
        filePath = "src/test/resources/data/" + excelFileName + ".xlsx";
        try {
            File file = new File(filePath);
            FileInputStream input = new FileInputStream(file);
            workbook = new XSSFWorkbook(input);
            excelSheet = workbook.getSheet(SheetName);
        } catch (Exception e) {
            System.out.println("No such file in dictionary");
        }

    }

    /**
     * This method will accept rowNum and cellNum and will return the vlue on that cell.
     *
     * @param rowNum
     * @param cellNum
     * @return
     */
    public static String getValue(int rowNum, int cellNum) {
        row = excelSheet.getRow(rowNum);
        cell = row.getCell(cellNum);
        return cell.toString();

    }

    public static void setValue(String value, int rowNum, int cellNum) throws IOException {

        row = excelSheet.getRow(rowNum);
        cell = row.getCell(cellNum);  // it will get cell and
        if (cell == null) { //if this cell is emty, it is return null.
            cell = row.createCell(cellNum);
            cell.setCellType(CellType.STRING); // if null we assign a value which should be String value
            cell.setCellValue(value);

        } else {
            cell.setCellValue(value);  // if this cell is not null, it has just set the value directly.

        }


        FileOutputStream output = null;

        try {
            output = new FileOutputStream(filePath);  // find the file if you not find the file it use try catch exception for no such element exception and
            workbook.write(output);  // it means update the value.

        } catch (FileNotFoundException e) {
            System.out.println("No such file in directory");
        } finally { // there is no exception it is gonna close the connection.

            output.close();
        }
    }

    /**
     * Method will return the number of rows in the excel file.
     * @return
     */
    public static int getNumOfRows() {

        return excelSheet.getPhysicalNumberOfRows();// this is method that return the number of the rows.


    }


}



