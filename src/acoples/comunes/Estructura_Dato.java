/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.comunes;

import java.util.List;

/**
 *
 * @author Alba Proyecto
 */
public class Estructura_Dato {
    
    private List lista;
    private int estado;

    public Estructura_Dato(List lista, int estado) {
        this.lista = lista;
        this.estado = estado;
    }

    public List getLista() {
        return lista;
    }

    public void setLista(List lista) {
        this.lista = lista;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
        
    
}
