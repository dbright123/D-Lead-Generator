/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LG;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Omage Micheal
 */
public class udata {
    udata(){
        
    }
    udata(String name, String email,String no,String addr,String desc){
        String excelFilePath = fileName;
        
        try {
            Workbook workbook;
            
            try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath))) {
                workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);
                Object[][] bookData = {
                    {name, email, no, addr, desc}                   
                };  
                int rowCount = sheet.getLastRowNum();
                int count = 0;
                for (Object[] aBook : bookData) {
                    Row row = sheet.createRow(++rowCount);
                    
                    int columnCount = 0;
                    
                    org.apache.poi.ss.usermodel.Cell cell = row.createCell(columnCount);
                    count = rowCount - 1;
                    if(c == 0){
                        cell.setCellValue(count);
                    }else{
                        cell.setCellValue(c);// restart counter
                        c ++;
                    }
                    cell.setCellValue(count);
                    for (Object field : aBook) {
                        cell = row.createCell(++columnCount);
                        if (field instanceof String) {
                            cell.setCellValue((String) field);
                        } else if (field instanceof Integer) {
                            cell.setCellValue((Integer) field);
                        }
                    }
                    
                }
            }
 
            try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
                workbook.write(outputStream);
                //workbook.close();
            }
             
        } catch (IOException | EncryptedDocumentException
                | InvalidFormatException ex) {
            
        }finally{
           // new eFrame("Please close the file to add data to the file");
        }
            
    }
    
    
    static LocalDate Ddate = LocalDate.now(); 
    static String fileName = System.getProperty("user.home") + "\\Desktop\\" +Ddate.toString() + " leads.xls";
    public int c;
}
