package com.devise.checkup.util;

import com.devise.checkup.domain.Checkstandard;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Version 1.0
 * @Author:ruwb
 * @Date:2020/5/9
 * @Content:
 */
public class LeadingInExcelUtils {

    public static List<Checkstandard> readExcel(MultipartFile file) {

        Workbook workbook = null;
        String fileName = file.getOriginalFilename();
        try {
            //判断什么类型文件
            if (fileName.endsWith(".xls")) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (fileName.endsWith(".xlsx")) {
                workbook = new XSSFWorkbook(file.getInputStream());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (workbook == null) {
            return Collections.EMPTY_LIST;
        }

        // 第一个sheet页
        Sheet sheet = workbook.getSheetAt(0);

        //获取一个sheet有多少Row
        int lastRowNum = sheet.getLastRowNum();
        // 解析每一行的内容
        Row row;
        List<Checkstandard> checkstandards = new ArrayList<>();
        for (int i = 1; i <= lastRowNum; i++) {
            row = sheet.getRow(i);
            Checkstandard standard = new Checkstandard(row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue(),
                    row.getCell(6).getStringCellValue(),
                    row.getCell(7).getStringCellValue(),
                    row.getCell(8).getStringCellValue(),
                    row.getCell(9).getStringCellValue(),
                    row.getCell(10).getStringCellValue(),
                    row.getCell(11).getStringCellValue(),
                    row.getCell(12).getStringCellValue(),
                    row.getCell(13).getStringCellValue(),
                    row.getCell(14).getStringCellValue(),
                    row.getCell(15).getStringCellValue(),
                    row.getCell(16).getStringCellValue(),
                    row.getCell(17).getStringCellValue());
            checkstandards.add(standard);
        }

        return checkstandards;
    }
}
