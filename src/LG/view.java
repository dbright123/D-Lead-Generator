/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LG;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Omage Micheal
 */
public class view {
    view(){
        
        try {
            Desktop.getDesktop().open(new File(fileName));
        } catch (IOException ex) {
            Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            //LeadGen.jLabel10.setText("Please close your excel application");
            //new eFrame("Please close the current file that is opened");
            
        }
    }
    
    static LocalDate Ddate = LocalDate.now(); 
    static String fileName = System.getProperty("user.home") + "\\Desktop\\" +Ddate.toString() + " leads.xls";
}
