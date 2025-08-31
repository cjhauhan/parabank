package com.capstone.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    public static Object[][] readSheet(String path, String sheetName) {
        List<Object[]> rows = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheet(sheetName);
            int rcount = sheet.getPhysicalNumberOfRows();
            Row header = sheet.getRow(0);
            for (int i = 1; i < rcount; i++) {
                Row r = sheet.getRow(i);
                if (r == null) continue;
                int cc = r.getPhysicalNumberOfCells();
                Object[] data = new Object[cc];
                for (int c = 0; c < cc; c++) {
                    Cell cell = r.getCell(c);
                    if (cell == null) { data[c] = ""; continue; }
                    switch (cell.getCellType()) {
                        case STRING: data[c] = cell.getStringCellValue(); break;
                        case NUMERIC: data[c] = cell.getNumericCellValue(); break;
                        case BOOLEAN: data[c] = cell.getBooleanCellValue(); break;
                        default: data[c] = cell.toString();
                    }
                }
                rows.add(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Object[][] out = new Object[rows.size()][];
        for (int i = 0; i < rows.size(); i++) out[i] = rows.get(i);
        return out;
    }
}
