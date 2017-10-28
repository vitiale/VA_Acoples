/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alba Proyecto
 */
public class Proyecto implements Serializable{
    
    private String nombre_proyecto;
    private ArrayList<Vigas> lista=new ArrayList<>();
    private transient List secciones=new ArrayList();

    public List getSecciones() {
        return secciones;
    }

    public void setSecciones(List secciones) {
        this.secciones = secciones;
    }
    

    public void setNombre_proyecto(String nombre_proyecto) {
        this.nombre_proyecto = nombre_proyecto;
    }
    
    public ArrayList<Vigas> getLista(){
        return lista;
    }
    
    public void setLista(ArrayList<Vigas> lista) {
        this.lista = lista;
    }

    public void guardarViga(Vigas vg) {
        lista.add(vg);
    }
    
    public void eliminarViga(int indice){
        lista.remove(indice);
    }
    
    public String devuelveNombre(){
        return nombre_proyecto;
    }
}
