/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Omage Micheal
 */
public class Dloader {
    Dloader(){
        final JFrame frame = new JFrame ();
        frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f,1.0f,1.0f,0.5f));
        frame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        try {
            SwingUtilities.invokeAndWait (() -> {
                frame.setVisible ( false );
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(Dloader.class.getName()).log(Level.SEVERE, null, ex);
        }
        final JDialog load = new JDialog ( frame );
        JPanel panel2 = new JPanel ( new BorderLayout () );
        panel2.setBorder ( BorderFactory.createEmptyBorder ( 15, 15, 20, 20 ) );
        load.add ( panel2 );
        load.setUndecorated(true);
        load.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        final JProgressBar progressBar = new JProgressBar ( 0, 100 );
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.GRAY);
        progressBar.setPreferredSize( new Dimension (400, 40));
        panel2.add ( progressBar );

        load.setModal ( false );
        load.pack ();
        load.setLocationRelativeTo ( frame );
        
        try {
            SwingUtilities.invokeAndWait (() -> {
                load.setVisible ( true );
            });
        } catch (InterruptedException | InvocationTargetException ex) {
            Logger.getLogger(Dloader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for ( int i = 0; i < 100; i++ )
        {
            try {
                Thread.sleep ( 20 );
            } catch (InterruptedException ex) {
                Logger.getLogger(Dloader.class.getName()).log(Level.SEVERE, null, ex);
            }

            
            final int finalI = i;

            // Updating panel and progress in EDT
            SwingUtilities.invokeLater (() -> {
                progressBar.setValue ( finalI  );
                progressBar.setString("Loading ...  " + finalI + " %");
            });
        }
        frame.dispose();
        
    }
    
}
