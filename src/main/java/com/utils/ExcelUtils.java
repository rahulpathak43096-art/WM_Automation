package com.utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.*;

public class ExcelUtils {

    // Reads data from excel sheet
    public static String getCellData(String sheetName, int row, int col) {

        try {
            FileInputStream fis =
                    new FileInputStream(PropertyUtils.getProperty("excelPath"));

            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            String data =
                    sheet.getRow(row).getCell(col).getStringCellValue();

            workbook.close();
            return data;

        } catch (Exception e) {
            return null;
        }
    }
}
