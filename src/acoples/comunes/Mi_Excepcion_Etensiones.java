/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.comunes;

/**
 *
 * @author Alba Proyecto
 */
public class Mi_Excepcion_Etensiones extends Exception{

    public Mi_Excepcion_Etensiones() {
    }
    
    public String extension_desconocida(){
        return "Extensión desconocida por el sistema, se espera un .xslx.";
    }    
    
}
