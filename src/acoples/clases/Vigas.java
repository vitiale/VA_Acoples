/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.clases;

import java.io.Serializable;

/**
 *
 * @author Alba Proyecto
 */
public class Vigas implements Serializable{
    
    private String[] propiedades;
    private String nombre_viga;

    public Vigas(String[] propiedades, String nombre_viga) {
        this.propiedades = propiedades;
        this.nombre_viga = nombre_viga;
    }

    public String[] getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(String[] propiedades) {
        this.propiedades = propiedades;
    }

    public String getNombre_viga() {
        return nombre_viga;
    }

    public void setNombre_viga(String nombre_viga) {
        this.nombre_viga = nombre_viga;
    }
    
    
}
