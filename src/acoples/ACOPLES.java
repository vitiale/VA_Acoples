/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples;

import acoples.comunes.Comun;
import acoples.visual.NewMDIApplication;
import static java.awt.Component.CENTER_ALIGNMENT;

/**
 *
 * @author Alba Proyecto
 */
public class ACOPLES {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewMDIApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        
        //Comun.nm.desktopPane.add(Comun.np, CENTER_ALIGNMENT);
        //Comun.nm.desktopPane.add(Comun.lv, CENTER_ALIGNMENT);
        //Comun.nm.desktopPane.add(Comun.vc, CENTER_ALIGNMENT);
        Comun.nm.setVisible(true);
    }
    
}
