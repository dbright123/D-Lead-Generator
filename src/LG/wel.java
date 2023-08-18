/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LG;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JRootPane;

/**
 *
 * @author Omage Micheal
 */
public class wel{
    public String usr = System.getProperty("user.name");
    Date d = new Date(); 
    public String greetinz = "";

    
    wel(){
         
        new Dloader();
       //System.out.println("Hour of the day is  : "+d.getHours()); 
        int DHours = d.getHours();
        if(DHours <= 12){
            greetinz = "Good Morning";
        }
        else if(DHours > 12 && DHours <= 16){
            greetinz = "Good Afternoon";
        }
        else{
            greetinz = "Good Evening";
        }
        
        String Dspeech = greetinz + " " + usr;
        //String Dspeech = " Hello my lovely friend "; 
        
        
        System.out.println(greetinz); 
        JFrame Wel =  new JFrame();  
        Wel.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LG/db_logo.png")));
        Wel.setUndecorated(true);
        Wel.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        Wel.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        Wel.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        Wel.setUndecorated(true);
        Wel.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        final ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/LG/db_logo.png")));
        
        Runnable Rd = () -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(wel.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print("Command Executed\n");
            Wel.dispose();
        };
        
        Thread Td = new Thread(Rd);
        Td.start();
        
        
        JOptionPane.showMessageDialog(Wel, "<html> <h1><strong>"+ greetinz + "</strong>" +
                "</h1><p><h3>Welcome to DBright Application.<br/><br/>Please Application "+
                "graphics is still on progress<br/> and will be fully done in the"+
                        "  next version <br/>which will be available shortly"
                + "<br/><br/>Please Application might have issues working "
                + "<br>on single Threaded CPU</h3> </p>"+
                "Click OK to continue the program  </html>"
                ,"Hey "+usr,JOptionPane.PLAIN_MESSAGE,icon);
        
        
       
        
        
        
        /*for(int x = 0; x < 4; x++){
        try {
        Thread.sleep(1000);
        } catch (InterruptedException ex) {
        Logger.getLogger(wel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }*/
        
        
        
        
    }
    
    
};
