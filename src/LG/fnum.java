/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LG;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class fnum {
    public String pnum(String n){
        PrintWriter writer;
        int c = 0;
        
        String num0 = "";
        try{          
            String ac = n;            
            String[] acA = ac.split(",",-1);            
            String contact;
            char[] cs;
            StringBuilder num; 
            System.out.println("Program Started");  
            for (String acA1 : acA) {           
                contact = acA1.replace(" ", "");
                contact = contact.replaceAll("[^0-9 ]", "");           
                //System.out.println("\n"+contact);
                cs = contact.toCharArray();
                // This is the part that does the formatting
                if(cs[0] == '0'){
                    num = new StringBuilder("00"+contact);
                    num.setCharAt(0, '2');
                    num.setCharAt(1, '3');
                    num.setCharAt(2, '4');
                    //System.out.println(num);
                    num0 += "'"+num + "',  " ;
                    c ++;
                } else{
                    num0 += "'"+contact + "',  " ;
                    c ++;
                }
            }
            System.out.println("\n"+num0);
            String[] pn = num0.split(",", -1);
                for (String pn1 : pn) {
                    contact = pn1.replace(" ", "");
                    contact = contact.replaceAll("[^0-9 ]", "");
                    try(FileWriter fw = new FileWriter(fileName, true);
                            BufferedWriter bw = new BufferedWriter(fw);
                            PrintWriter out = new PrintWriter(bw))
                        {
                            out.println(contact);

                    } catch (IOException e) {
                        //exception handling left as an exercise for the reader
                    }
                    
                }
            System.out.println("a file to hold that has the records have been created");
            
            
            
        }catch(Exception e){
                System.out.println("Sorry a particular number is causing an error"
                        + " but the number above are well formatted");
        }
        
        return num0;        
    };
    static LocalDate Ddate = LocalDate.now(); 
    static String fileName = System.getProperty("user.home") + "\\Desktop\\" + Ddate.toString() + " leads.txt";
}
