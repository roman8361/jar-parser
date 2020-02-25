package ru.kravchenko.sp.service;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import ru.kravchenko.sp.api.ICreateExcelFileService;
import ru.kravchenko.sp.entity.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class CreateExcelFileService implements ICreateExcelFileService {

    @Override
    public void createExcelFile(String fileName) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("FirstSheet");

        HSSFRow rowhead = sheet.createRow((short) 0);
        rowhead.createCell(0).setCellValue("No.");
        rowhead.createCell(1).setCellValue("Name");
        rowhead.createCell(2).setCellValue("Address");
        rowhead.createCell(3).setCellValue("Email");

        HSSFRow row = sheet.createRow((short) 1);
        row.createCell(0).setCellValue("1");
        row.createCell(1).setCellValue("Sankumarsingh");
        row.createCell(2).setCellValue("India");
        row.createCell(3).setCellValue("sankumarsingh@gmail.com");

        FileOutputStream fileOut = new FileOutputStream(fileName);
        workbook.write(fileOut);
        fileOut.close();
//          workbook.close(); TODO разоброаться как закрывать поток
        System.out.println("Your excel file has been generated!");
    }

    @Override
    public void createExcelFile(String fileName, List<User> users) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("FirstSheet");

        HSSFRow rowhead = sheet.createRow((short) 0);
        rowhead.createCell(0).setCellValue("No.");
        rowhead.createCell(1).setCellValue("Name");
        rowhead.createCell(2).setCellValue("Age");
        rowhead.createCell(3).setCellValue("Id");

        int count = 1;
        for (User u: users) {
                HSSFRow row = sheet.createRow((short) count);
                row.createCell(0).setCellValue(count);
                row.createCell(1).setCellValue(u.getName());
                row.createCell(2).setCellValue(u.getAge());
                row.createCell(3).setCellValue(u.getId());
                count++;
        }
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
//             workbook.close(); TODO разоброаться как закрывать поток
            System.out.println("Your excel file has been generated!");
    }

}
