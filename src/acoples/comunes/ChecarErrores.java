/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.comunes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alba Proyecto
 */
public class ChecarErrores {
    
    public int Dobles(ArrayList<String> elementos){
        try {
            for(int i=0; i<elementos.size(); i++){
                Double.parseDouble(elementos.get(i));
            }
            return 0;
        } catch (Exception e) {
            return 1;
        }
    }
    
}
