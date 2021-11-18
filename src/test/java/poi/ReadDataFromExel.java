package poi;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ReadDataFromExel {
    @Test
    public void readTest() throws IOException, InvalidFormatException {

        File excelFile = new File("src/test/resources/testData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet1 = workbook.getSheet("Sheet1");
        XSSFRow row1 = sheet1.getRow(0);
        XSSFCell cell1 = row1.getCell(0);
        System.out.println(cell1.getStringCellValue());

        Assert.assertEquals(cell1.getStringCellValue(), "Test name ");

        XSSFCell cell2 = row1.getCell(0);
        XSSFCell cell3 = row1.getCell(0);

        System.out.println("Cell B:" + cell2.getStringCellValue());
        System.out.println("Cell C:" + cell3.getStringCellValue());
    }

    @Test
    public void readAllCellsForRowTest() throws IOException, InvalidFormatException {
        File excelFile = new File("src/test/resources/testData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet1 = workbook.getSheet("Sheet1");
        XSSFRow row2 = sheet1.getRow(1);

        for (int i = row2.getFirstCellNum(); i < row2.getLastCellNum(); i++) {
            XSSFCell tempCell = row2.getCell(i);
            System.out.print(tempCell + "\t");

        }
    }

    @Test
    public void readColumnDataTest() throws IOException, InvalidFormatException {
        File exelFile = new File("src/test/resources/RealTestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(exelFile);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); i++) {
            XSSFCell tempCell = sheet.getRow(i).getCell(2);
            System.out.println(tempCell);


        }

    }

    @Test
    public void readAllDataTest() throws IOException, InvalidFormatException {
        File excelFile = new File("src/test/resources/RealTestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = sheet.getFirstRowNum(); i < sheet.getLastRowNum(); i++) {
            XSSFRow tempRow = sheet.getRow(i);
            for (int j = tempRow.getFirstCellNum(); j < tempRow.getLastCellNum(); j++) {
                XSSFCell tempCell = tempRow.getCell(j);
                System.out.print(tempCell + " | ");
            }
            System.out.println();
        }
    }

}
