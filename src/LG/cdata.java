/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LG;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;

/**
 *
 * @author Omage Micheal
 */
public class cdata {
    static LocalDate Ddate = LocalDate.now(); 
    static String fileName = System.getProperty("user.home") + "\\Desktop\\" +Ddate.toString() + " leads.xls";
    cdata(String title, String name, String email,String no,String addr,String desc) throws FileNotFoundException, IOException{
        System.out.println(fileName);
        String filename = fileName ;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Lead sheet");
        // Editing the Cell to be created
        HSSFCellStyle style = workbook.createCellStyle();
        style.setWrapText(true);
        HSSFFont font = workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setFontHeightInPoints((short)11);
        //font.setBold(true);
        style.setFont(font);
        
        HSSFRow rowhead = sheet.createRow((short)0);
            
            rowhead.createCell(0).setCellValue(title.toUpperCase());
            rowhead.createCell(1).setCellValue("           ");
            rowhead.createCell(2).setCellValue("           ");
            rowhead.createCell(3).setCellValue("           ");
            rowhead.createCell(4).setCellValue("           ");
            rowhead.createCell(5).setCellValue("           ");
            for(int j = 0; j<=5; j++){
                rowhead.getCell(j).setCellStyle(style);
            }
            for (int i=0; i<7; i++){
                sheet.autoSizeColumn(i);
            }
        HSSFRow rowhead1 = sheet.createRow((short)1);
            
            rowhead1.createCell(0).setCellValue("S/N");
            rowhead1.createCell(1).setCellValue("COMPANY NAME");
            rowhead1.createCell(2).setCellValue("EMAIL ADDRESS");
            rowhead1.createCell(3).setCellValue("PHONE NUMBER");
            rowhead1.createCell(4).setCellValue("ADDRESS");
            rowhead1.createCell(5).setCellValue("DESCRIPTION");
            for(int j = 0; j<=5; j++){
                rowhead1.getCell(j).setCellStyle(style);
            }
            for (int i=0; i<7; i++){
                sheet.autoSizeColumn(i);
            }
        HSSFRow rowhead2 = sheet.createRow((short)2);
            rowhead2.createCell(0).setCellValue(1);
            rowhead2.createCell(1).setCellValue(name);
            rowhead2.createCell(2).setCellValue(email);
            rowhead2.createCell(3).setCellValue(no);
            rowhead2.createCell(4).setCellValue(addr);
            rowhead2.createCell(5).setCellValue(desc);
            for (int i=0; i<7; i++){
                sheet.autoSizeColumn(i);
            }
        
        try (FileOutputStream fileOut = new FileOutputStream(filename)) {
                workbook.write(fileOut);
        }catch ( IOException ex ) {
            System.out.println(ex);
        }finally{
            //new eFrame("Please close the file to add data to the file");
        }
    }
    
   
};
