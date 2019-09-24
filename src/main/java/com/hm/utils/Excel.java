package com.hm.utils;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Excel {

    public static ArrayList<String[]> readExcel(){
        String path = "src/main/java/com/hm/testdata/testcase.xls";
        Workbook book = null;
        ArrayList<String[]> al = new ArrayList<>();
        try {
            book = book.getWorkbook(new File(path));
            Sheet sheet = book.getSheet(0);
            for(int i = 0; i < sheet.getRows(); i ++){
                String[] dataRow = new String[sheet.getColumns()];
                for (int j = 0; j < sheet.getColumns(); j ++){
                    Cell cell = sheet.getCell(j, i);
                    dataRow[j] = cell.getContents();
                }
                al.add(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        book.close();
        return al;
    }
}
