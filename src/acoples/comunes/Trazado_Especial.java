/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.comunes;

import acoples.clases.Proyecto;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Alba Proyecto
 */
public class Trazado_Especial {

    public double para_separacion_max(int envio) {//tanto de estribos de viga como de diagonal
        double medida[] = {5, 6, 7.5, 9, 10, 12.5, 15, 17.5, 20, 22.5, 25, 27.5, 30, 32.5, 35};
        Map<Integer, Double> mapa = new HashMap<Integer, Double>();
        double valor = 0;
        switch (envio) {
            case 0:
                valor = 5;
                break;
            case 1:
                valor = 6;
                break;
            case 2:
                valor = 7.5;
                break;
            case 3:
                valor = 9;
                break;
            case 4:
                valor = 10;
                break;
            case 5:
                valor = 12.5;
                break;
            case 6:
                valor = 15;
                break;
            case 7:
                valor = 17.5;
                break;
            case 8:
                valor = 20;
                break;
            case 9:
                valor = 22.5;
                break;
            case 10:
                valor = 25;
                break;
            case 11:
                valor = 27.5;
                break;
            case 12:
                valor = 30;
                break;
            case 13:
                valor = 32.5;
                break;
            case 14:
                valor = 35;
                break;
        }
        return valor;
    }

    public ArrayList<Double> as_esquinas(int envio) {
        ArrayList<Double> arr = new ArrayList<>();
        switch (envio) {
            case 0:
                arr.add(1.0);
                arr.add(6.0);
                break;
            case 1:
                arr.add(1.0);
                arr.add(8.0);
                break;
            case 2:
                arr.add(2.0);
                arr.add(6.0);
                break;
            case 3:
                arr.add(1.0);
                arr.add(10.0);
                break;
            case 4:
                arr.add(2.0);
                arr.add(8.0);
                break;
            case 5:
                arr.add(1.0);
                arr.add(10.0);
                arr.add(1.0);
                arr.add(6.0);
                break;
            case 6:
                arr.add(1.0);
                arr.add(12.0);
                break;
            case 7:
                arr.add(1.0);
                arr.add(10.0);
                arr.add(1.0);
                arr.add(8.0);
                break;
            case 8:
                arr.add(3.0);
                arr.add(8.0);
                break;
            case 9:
                arr.add(2.0);
                arr.add(10.0);
                break;
            case 10:
                arr.add(1.0);
                arr.add(10.0);
                arr.add(2.0);
                arr.add(8.0);
                break;
            case 11:
                arr.add(2.0);
                arr.add(12.0);
                break;
            case 12:
                arr.add(3.0);
                arr.add(10.0);
                break;
            case 13:
                arr.add(1.0);
                arr.add(12.0);
                arr.add(2.0);
                arr.add(10.0);
                break;
            case 14:
                arr.add(3.0);
                arr.add(12.0);
                break;
        }
        return arr;
    }

    public String estribo_en_viga_tipo(int envio) {
        String cad = "e # 3";
        switch (envio) {
            case 0:
                cad = "e # 3";
                break;
            case 1:
                cad = "e # 4";
                break;
            case 2:
                cad = "2e # 3";
                break;
            case 3:
                cad = "e # 5";
                break;
            case 4:
                cad = "2e # 4";
                break;
            case 5:
                cad = "e # 6";
                break;
            case 6:
                cad = "2e # 5";
                break;
        }
        return cad;
    }

    public String estrivo_en_viga_sep(int envio) {
        String cad = "5";
        switch (envio) {
            case 0:
                cad = "5";
                break;
            case 1:
                cad = "6";
                break;
            case 2:
                cad = "7.5";
                break;
            case 3:
                cad = "9";
                break;
            case 4:
                cad = "10";
                break;
            case 5:
                cad = "12.5";
                break;
            case 6:
                cad = "15";
                break;
            case 7:
                cad = "17.5";
                break;
            case 8:
                cad = "20";
                break;
            case 9:
                cad = "22.5";
                break;
            case 10:
                cad = "25";
                break;
            case 11:
                cad = "27.5";
                break;
            case 12:
                cad = "30";
                break;
            case 13:
                cad = "32.5";
                break;
            case 14:
                cad = "35";
                break;
        }
        return cad;
    }

    public void fichero_dibujo(Proyecto py, String dir)  {
        try {
            double espacio = 1.2;
            double x_fijo = 8;//8
            double y_fijo = 4;//4
            double conversion = 3.14159265 / 180;
            double recubrimiento = 5;
            double altura = 90;
           //Tener en cuenta que se trabajo con la altura del armado y no de la viga
            double angulo = 34;
            double ld = 110;
            double ln = 90;
            double separacion_max = 15;
            double cant_varillas_horizontales = 3;
            double distancia_estribos_viga = 17.5;
            double ancho_cuadrito = 30;//<bw
            double altura_detalle;
            double ancho_detalle;
            double h_diag;
            double recubrimiento_diagonal;
            //double cant_varillas_verticales;//estribos
            double diametro_varillas_horizontales = ((3.0 / 8.0) * 2.54) / 20;//este valor hay que traerlo desde la ventana
            String jl12_51 = "";
            int cont_pak_grapas_base = 0;
            int cont_pak_grapas_cara = 0;
            double longitud_recta_grapas = 10;
            String estribos_diag = "1#3";
            String grapa_num = "gr # 3";
            int estribo_viga_tipo = 0;
            int estribo_viga_separacion = 0;
            FileWriter fichero = new FileWriter(dir + ".scr");
            PrintWriter pw = new PrintWriter(fichero);
            //Esto es para crear los
            pw.println("-layer n ALBA_TRABE_D c t 223,255,127 ALBA_TRABE_D l Continuous ALBA_TRABE_D ");
            pw.println("-layer n ALBA_ARMADO c t 76,0,38 ALBA_ARMADO l Continuous ALBA_ARMADO ");
            pw.println("-layer n ALBA_HATCH c t 128,128,128 ALBA_HATCH l Continuous ALBA_HATCH ");
            pw.println("-layer n ALBA_MURO_DE_CARGA_P c t 255,0,255 ALBA_MURO_DE_CARGA_P l Continuous ALBA_MURO_DE_CARGA_P ");
            pw.println("-layer n ALBA_COTAS c t 0,255,0 ALBA_COTAS l Continuous ALBA_COTAS ");
            pw.println("-layer n ALBA_TEXTO_TITULOS c t 255,255,0 ALBA_TEXTO_TITULOS l Continuous ALBA_TEXTO_TITULOS ");
            pw.println("-layer n ALBA_PROYECCION c t 0,255,255 ALBA_PROYECCION l Continuous ALBA_PROYECCION ");
            pw.println("-layer n ALBA_TX2 c t 0,191,255 ALBA_TX2 l Continuous ALBA_TX2 ");
            pw.println("-layer n ALBA_SECCIONES c t 255,0,0 ALBA_SECCIONES l Continuous ALBA_SECCIONES ");
            pw.println("-osnap off");
            //******************
            for (int i = 0; i < py.getLista().size(); i++) {
                py.getLista().get(i).getNombre_viga();
                ln = Double.parseDouble(py.getLista().get(i).getPropiedades()[0]);
                altura = Double.parseDouble(py.getLista().get(i).getPropiedades()[1]) - (2 * recubrimiento);
                System.out.println("***************** " + altura);
                altura_detalle = Double.parseDouble(py.getLista().get(i).getPropiedades()[15]);//altura/4;
                ancho_detalle = Double.parseDouble(py.getLista().get(i).getPropiedades()[14]);//ancho_cuadrito/2;
                ancho_cuadrito = Double.parseDouble(py.getLista().get(i).getPropiedades()[2]);
                angulo = Double.parseDouble(py.getLista().get(i).getPropiedades()[5]);
                ld = Double.parseDouble(py.getLista().get(i).getPropiedades()[17].substring(30));
                //System.out.println(ld);
                separacion_max = para_separacion_max(Integer.parseInt(py.getLista().get(i).getPropiedades()[29]));
                System.out.println("sep ************************* " + separacion_max);
                cant_varillas_horizontales = Double.parseDouble(py.getLista().get(i).getPropiedades()[20]);
                System.out.println("varillas " + py.getLista().get(i).getPropiedades()[20]);
                distancia_estribos_viga = para_separacion_max(Integer.parseInt(py.getLista().get(i).getPropiedades()[36]));
                System.out.println("distancia_estribos_viga  " + distancia_estribos_viga);
                recubrimiento_diagonal = Double.parseDouble(py.getLista().get(i).getPropiedades()[16]);
                if (Double.parseDouble(py.getLista().get(i).getPropiedades()[35]) == 0) {
                    diametro_varillas_horizontales = ((3.0 / 8.0) * 2.54) / 20;
                } else {
                    diametro_varillas_horizontales = ((4.0 / 8.0) * 2.54) / 20;
                }
                jl12_51 = py.getLista().get(i).getPropiedades()[51];
                cont_pak_grapas_base = Integer.parseInt(py.getLista().get(i).getPropiedades()[38]);
                System.out.println("pak grapas base " + Integer.parseInt(py.getLista().get(i).getPropiedades()[38]));
                cont_pak_grapas_cara = Integer.parseInt(py.getLista().get(i).getPropiedades()[39]);
                if (Integer.parseInt(py.getLista().get(i).getPropiedades()[27]) == 0) {
                    longitud_recta_grapas = 10;
                    grapa_num = "gr # 3";
                } else if (Integer.parseInt(py.getLista().get(i).getPropiedades()[27]) == 1) {
                    longitud_recta_grapas = 11;
                    grapa_num = "gr # 4";
                } else if (Integer.parseInt(py.getLista().get(i).getPropiedades()[27]) == 2) {
                    longitud_recta_grapas = 14;
                    grapa_num = "gr # 5";
                }
                if (Integer.parseInt(py.getLista().get(i).getPropiedades()[26]) == 0) {
                    estribos_diag = "e # 3";
                } else if (Integer.parseInt(py.getLista().get(i).getPropiedades()[26]) == 1) {
                    estribos_diag = "e # 4";
                } else if (Integer.parseInt(py.getLista().get(i).getPropiedades()[26]) == 2) {
                    estribos_diag = "2e # 3";
                }
                estribo_viga_tipo = Integer.parseInt(py.getLista().get(i).getPropiedades()[33]);
                estribo_viga_separacion = Integer.parseInt(py.getLista().get(i).getPropiedades()[36]);
                double x_inicio = x_fijo - (Math.cos(angulo * conversion) * (ld / 20));
                double y_inicio = y_fijo - (Math.sin(angulo * conversion) * (ld / 20));
                //ptos. medios
                double x_medio = (x_fijo + ln / 40);
                double y_medio = ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 40 + (y_fijo - ((y_inicio + recubrimiento / 20) - espacio)));
                //ptos necesarios para trazar las diagonales completas
                double pto_diag_dcho_sup_y = Math.tan(angulo * conversion) * ((((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)) - espacio) - x_fijo) + y_fijo;
                double pto_diag_dcho_inf_y = Math.tan(angulo * conversion) * ((((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)) - espacio) - x_fijo) + ((((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) - espacio) + recubrimiento / 20);
                //distancia de ptos de las diagonales interiores en y al pto. medio en y
                double dist_diag_inter_y = (pto_diag_dcho_sup_y) - y_medio;
                double dist_diag_inter_x = (pto_diag_dcho_sup_y) - y_medio;
                //System.out.println("medio "+dist_diag_inter_y);
                //calculo para determinar los ptos. para poner parejas las diagonales
                double hipotenusa_grande = (y_medio - dist_diag_inter_y) - (y_inicio);
                double hipotenusa_chica = Math.sin(angulo * conversion) * hipotenusa_grande;
                double cateto_opuesto = Math.sin(angulo * conversion) * hipotenusa_chica;
                double cateto_adyacente = Math.cos(angulo * conversion) * hipotenusa_chica;
                //para representacion de angulo
                double dist_diag_sup_izq = Math.sqrt(Math.pow(x_fijo - x_inicio, 2) + Math.pow((y_fijo + (altura / 20)) - (((((y_inicio) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio) - espacio))) - espacio), 2));
                double catet_ady = Math.sin(angulo * conversion) * dist_diag_sup_izq / 2;
                double catet_op = Math.cos(angulo * conversion) * dist_diag_sup_izq / 2;
                double pto_medio_rejilla_diag_x = ((x_inicio - cateto_adyacente) + x_inicio) / 2;
                double pto_medio_rejilla_diag_y = ((y_medio - dist_diag_inter_y - cateto_opuesto) + y_inicio) / 2;
                //System.out.println(pto_medio_rejilla_diag_x+" "+pto_medio_rejilla_diag_y);
                double pto_medio_rejilla_diag_x1 = ((x_inicio - cateto_adyacente) + x_inicio) / 2;
                double pto_medio_rejilla_diag_y1 = ((pto_diag_dcho_sup_y + cateto_opuesto) + (((((y_inicio) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio) - espacio))) - espacio)) / 2;
                //System.out.println(pto_medio_rejilla_diag_x1+" "+pto_medio_rejilla_diag_y1);
                double dist_varillas_viga = (altura / 20) / (cant_varillas_horizontales + 1);
                System.out.println(distancia_estribos_viga / 20);
                double cantidad_estribos = (((ln / 20) - 0.25) / (distancia_estribos_viga / 20));
                System.out.println(cantidad_estribos);
                int pasar = (int) cantidad_estribos;
                System.out.println(pasar);
                double resto = cantidad_estribos - pasar;
                System.out.println(resto);
                System.out.println(cantidad_estribos);
                //se comienza calculo para grapas
                double diametro_varilla_grapas = ((3.0 / 8.0) * 2.54) / 20;//tiene una longitud fija por ahora
                //longitud_recta_grapas = 10;//tiene una longitud fija por ahora
                double catet_op_grapas = (Math.sin(45 * conversion) * longitud_recta_grapas / 20);
                double catet_ady_grapas = (Math.cos(45 * conversion) * longitud_recta_grapas / 20);
                //se comienza a trazar las varillas de las esquinas en el estribo mas grande
                double pto_med_estribo_grande_x = (((((x_fijo + ln / 20) + (x_fijo) - (x_inicio - cateto_adyacente - espacio)) + 0.25) + 2.5) + ((((x_fijo + ln / 20) + (x_fijo) - (x_inicio - cateto_adyacente - espacio) + ancho_cuadrito / 20) - 0.25) + 2.5)) / 2;
                double pto_med_estribo_grande_y = ((y_fijo + (altura / 40)) + (y_fijo + (altura / 40))) / 2;
                //arraypath 4.032103033951948,1.821233563322375  4.313815798897894,1.4189060389933057 16.249609730994,9.776438912348556 I 0.5 5 
                double pr_x = (x_inicio + ((((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)) - espacio) + cateto_adyacente)) / 2;
                double pr_y = (y_inicio + (pto_diag_dcho_sup_y + cateto_opuesto)) / 2;
                System.out.println(pr_x + " " + pr_y);
                double dist_diagonales = Math.sqrt(Math.pow(((((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)) - espacio) + cateto_adyacente) - x_inicio, 2) + Math.pow((pto_diag_dcho_sup_y + cateto_opuesto) - y_inicio, 2));
                System.out.println(dist_diagonales);
                //if (Double.parseDouble(py.getLista().get(i).getPropiedades()[4]) < 2) {
               
                    System.out.println("soy menor que 2");
                    double var_modificacion_muro = (x_fijo + ln / 20) + 3.75;
                    double var_modificacion_muro_izq = x_fijo - 3.75;
                    pto_med_estribo_grande_x = ((((var_modificacion_muro) + 0.25) + 2.5) + ((((x_fijo + ln / 20) + (x_fijo) - var_modificacion_muro_izq + ancho_cuadrito / 20) - 0.25) + 2.5)) / 2;
                    pto_med_estribo_grande_y = ((y_fijo + (altura / 40)) + (y_fijo + (altura / 40))) / 2;                   
                    pw.println("zoom window " + (var_modificacion_muro_izq - 1) + "," + (((y_inicio + recubrimiento / 20) - espacio) - 2) + " " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 1 + 7) + "," + (((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + 1));
                    pw.println("-layer s ALBA_TRABE_D ");
                    //base de recubrimiento de viga
                    pw.println("line " + x_fijo + "," + (y_fijo - recubrimiento / 20) + " " + (x_fijo + ln / 20) + "," + (y_fijo - recubrimiento / 20) + " ");
                    //tapa de recubrimiento de viga
                    pw.println("line " + x_fijo + "," + (y_fijo + altura / 20 + recubrimiento / 20) + " " + (x_fijo + ln / 20) + "," + (y_fijo + altura / 20 + recubrimiento / 20) + " ");
                    //cuadro grande de la derecha
                    pw.println("pline " + ((var_modificacion_muro) + 2.5) + "," + (y_fijo - 0.25) + " " + ((var_modificacion_muro) + 2.5) + "," + ((y_fijo + altura / 20) + 0.25) + " "
                            + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5) + "," + ((y_fijo + altura / 20) + 0.25) + " " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5) + "," + (y_fijo - 0.25) + " "
                            + ((var_modificacion_muro) + 2.5) + "," + (y_fijo - 0.25) + " ");
                    pw.println("-layer s ALBA_MURO_DE_CARGA_P ");
                    //lado superior dcho de muro izq
                    pw.println("line " + x_fijo + "," + (y_fijo + altura / 20 + recubrimiento / 20) + " " + x_fijo + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " ");
                    //lado superior izq de muro dcho
                    pw.println("line " + (x_fijo + ln / 20) + "," + (y_fijo + altura / 20 + recubrimiento / 20) + " " + (x_fijo + ln / 20) + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " ");
                    //lado inferior izq de muro dcho
                    pw.println("line " + (x_fijo + ln / 20) + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + (x_fijo + ln / 20) + "," + (y_fijo - recubrimiento / 20) + " ");
                    //lado inferior dcho de muro izq
                    pw.println("line " + x_fijo + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + x_fijo + "," + (y_fijo - recubrimiento / 20) + " ");  //lado inferior dcho de muro izq
                    pw.println("-layer s ALBA_PROYECCION ");
                    pw.println("-layer s ALBA_HATCH ");
                    pw.println("breakline " + var_modificacion_muro_izq + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + x_fijo + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + ((var_modificacion_muro_izq + x_fijo) / 2) + "," + ((y_inicio + recubrimiento / 20) - espacio) + " ");  //base de muro izq
                    //lado izq de muro izq                    
                    pw.println("breakline " + var_modificacion_muro_izq + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + var_modificacion_muro_izq + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " " + var_modificacion_muro_izq + "," + ((((y_inicio + recubrimiento / 20) - espacio) + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio)))) / 2) + " ");
                    //tapa de muro izq
                    pw.println("pline " + var_modificacion_muro_izq + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " " + x_fijo + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " ");
                    //pw.println("line "+x_fijo+","+y_fijo+" "+x_fijo+","+(y_fijo+altura/20)+" ");                    
                    //base de muro dcho
                    pw.println("breakline " + (x_fijo + ln / 20) + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + (var_modificacion_muro) + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + (((x_fijo + ln / 20) + (var_modificacion_muro)) / 2) + "," + ((y_inicio + recubrimiento / 20) - espacio) + " ");
                    //pw.println("pline "+(x_fijo+ln/20)+","+((y_inicio+recubrimiento/20)-espacio)+" "+( (x_fijo+ln/20) +  ( x_fijo) - (x_inicio-cateto_adyacente-espacio)  )+","+((y_inicio+recubrimiento/20)-espacio)+" ");
                    //lado dcho de muro dcho
                    pw.println("breakline " + (var_modificacion_muro) + "," + ((y_inicio + recubrimiento / 20) - espacio) + " " + (var_modificacion_muro) + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " " + (var_modificacion_muro) + "," + ((((y_inicio + recubrimiento / 20) - espacio) + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio)))) / 2) + " ");
                    //tapa de muro dcho
                    pw.println("pline " + (x_fijo + ln / 20) + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " " + (var_modificacion_muro) + "," + ((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio))) + " ");
                    pw.println("-hatch p AR-CONC 0.2 0 " + (x_fijo + (ln + 1) / 20) + "," + ((y_inicio + (recubrimiento + 1) / 20) - espacio) + " ");
                    pw.println("-layer s ALBA_ARMADO ");
                    //varillas horizontales
                    for (double p = dist_varillas_viga; p < altura / 20; p += dist_varillas_viga) {
                        pw.println("line " + (x_fijo - 0.75) + "," + (y_fijo + p) + " " + ((x_fijo + ln / 20) + 0.75) + "," + (y_fijo + p) + " ");
                        pw.println("circle " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varillas_horizontales / 2) + "," + (y_fijo + p) + " " + diametro_varillas_horizontales / 2);
                        pw.println("circle " + (((var_modificacion_muro + ancho_cuadrito / 20) - 0.25) + 2.5 - diametro_varillas_horizontales / 2) + "," + (y_fijo + p) + " " + diametro_varillas_horizontales / 2);
                        pw.println("-layer s ALBA_TX2 ");
                        pw.println("qleader " + (x_fijo + 1.5) + "," + (y_fijo + p) + " " + (x_fijo + 1.5) + "," + ((y_fijo + p) - (p + 1.5)) + " " + (x_fijo + 2) + "," + ((y_fijo + p) - (p + 1.5)) + " " + 2.0 + " " + py.getLista().get(i).getPropiedades()[51].substring(12));
                        pw.println();
                        pw.println("-layer s ALBA_ARMADO ");
                    }
                    //recubrimientos estribos de viga o varillas verticales
                    double aux = distancia_estribos_viga / 20;
                    double aux1 = x_fijo + 0.125 + (resto / 2);
                    for (double j = 0; j < ((ln / 20) - 0.25); j += (aux)) {
                        pw.println("line " + (aux1 + j) + "," + y_fijo + " " + (aux1 + j) + "," + (y_fijo + altura / 20) + " ");
                        pw.println("-layer s ALBA_TX2 ");
                        pw.println("qleader " + (aux1 + j) + "," + (y_fijo + altura / 40) + " " + (x_fijo + ln / 20) + "," + (y_fijo + altura / 40) + " " + (x_fijo + 1.0 + ln / 20) + "," + (y_fijo + altura / 40) + " " + 3.0 + " " + estribo_en_viga_tipo(estribo_viga_tipo) + " @ " + estrivo_en_viga_sep(estribo_viga_separacion));
                        pw.println();
                        pw.println("-layer s ALBA_ARMADO ");
                    }

                    if ((altura + 2 * recubrimiento) > 85) {
                        //base de viga
                        pw.println("line " + (x_fijo - 2.5) + "," + y_fijo + " " + ((x_fijo + ln / 20) + 2.5) + "," + y_fijo + " ");
                        pw.println("line " + (x_fijo - 2.5) + "," + y_fijo + " " + (x_fijo - 2.5) + "," + (y_fijo + 37.5 / 20) + " ");
                        pw.println("line " + ((x_fijo + ln / 20) + 2.5) + "," + y_fijo + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + 37.5 / 20) + " ");
                        //pw.println("fillet r 0.375 "+ ( (x_fijo - 2.5 + 0.5) + "," + y_fijo ) + " "+ ( (x_fijo - 2.5) + "," + (y_fijo + 0.5) )+" ");
                        pw.println("fillet r 0.375 ");
                        pw.println((x_fijo - 2.5 + 0.5) + "," + y_fijo + " " + (x_fijo - 2.5) + "," + (y_fijo + 0.5));
                        pw.println("fillet r 0.375 ");
                        pw.println(((x_fijo + ln / 20) + 2.5 - 0.5) + "," + y_fijo + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + 0.5));
                        //tapa de viga
                        pw.println("line " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20) + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20) + " ");
                        pw.println("line " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20) + " " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20 - 37.5 / 20) + " ");
                        pw.println("line " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20) + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20 - 37.5 / 20) + " ");
                        pw.println("fillet r 0.375 ");
                        pw.println((x_fijo - 2.5 + 0.5) + "," + (y_fijo + altura / 20) + " " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20 - 0.5));
                        pw.println("fillet r 0.375 ");
                        pw.println(((x_fijo + ln / 20) + 2.5 - 0.5) + "," + (y_fijo + altura / 20) + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20 - 0.5));
                    } else {
                        //base de viga
                        pw.println("line " + (x_fijo - 2.6) + "," + y_fijo + " " + ((x_fijo + ln / 20) + 2.6) + "," + y_fijo + " ");
                        pw.println("line " + (x_fijo - 2.6) + "," + y_fijo + " " + (x_fijo - 2.6) + "," + (y_fijo + 37.5 / 20) + " ");
                        pw.println("line " + ((x_fijo + ln / 20) + 2.6) + "," + y_fijo + " " + ((x_fijo + ln / 20) + 2.6) + "," + (y_fijo + 37.5 / 20) + " ");
                        //pw.println("fillet r 0.375 "+ ( (x_fijo - 2.5 + 0.5) + "," + y_fijo ) + " "+ ( (x_fijo - 2.5) + "," + (y_fijo + 0.5) )+" ");
                        pw.println("fillet r 0.375 ");
                        pw.println((x_fijo - 2.6 + 0.5) + "," + y_fijo + " " + (x_fijo - 2.6) + "," + (y_fijo + 0.5));
                        pw.println("fillet r 0.375 ");
                        pw.println(((x_fijo + ln / 20) + 2.6 - 0.5) + "," + y_fijo + " " + ((x_fijo + ln / 20) + 2.6) + "," + (y_fijo + 0.5));
                        //tapa de viga
                        pw.println("line " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20) + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20) + " ");
                        pw.println("line " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20) + " " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20 - 37.5 / 20) + " ");
                        pw.println("line " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20) + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20 - 37.5 / 20) + " ");
                        pw.println("fillet r 0.375 ");
                        pw.println((x_fijo - 2.5 + 0.5) + "," + (y_fijo + altura / 20) + " " + (x_fijo - 2.5) + "," + (y_fijo + altura / 20 - 0.5));
                        pw.println("fillet r 0.375 ");
                        pw.println(((x_fijo + ln / 20) + 2.5 - 0.5) + "," + (y_fijo + altura / 20) + " " + ((x_fijo + ln / 20) + 2.5) + "," + (y_fijo + altura / 20 - 0.5));
                    }
                    pw.println("-layer s ALBA_ARMADO ");                    
                    //*******Comenzmos con los detalles en los cuadros de la derecha*****************************************
                    //estas son las varillas de las esquinas de los cuadros pequeños
                    ArrayList<Double> cad_combo1 = new ArrayList();
                    cad_combo1 = as_esquinas(Integer.parseInt(py.getLista().get(i).getPropiedades()[21]));
                    //double diametro_varilla_cuadritos = ((as_esquinas(Integer.parseInt(py.getLista().get(i).getPropiedades()[21])).get(1) / 8.0) * 2.54) / 20; //el 6 es el diametro de la varilla en pulgadas, aqui se esta llevando a cm
                    double diametro_varilla_cuadritos = ((cad_combo1.get(1) / 8.0) * 2.54) / 20;
                    double fill = diametro_varilla_cuadritos;//este es el valor del radio de curva que se le da por defecto a los bordes de los recatngulos
                    //se comienza a trazar las varillas en los cuadrados pequeños
                    double cat_op_var_esq_cuadro_pequeño_sup = Math.sin(45 * conversion) * fill;
                    double cat_op_var_esq_cuadro_pequeño_sup_diam_circulito = Math.sin(45 * conversion) * (diametro_varilla_cuadritos);
                    double pto_med_cuadro_chiquito_sup_x = ((((var_modificacion_muro + ancho_cuadrito / 20) - 0.25) + 2.5 - 0.1 - ancho_detalle / 20) + (((var_modificacion_muro + ancho_cuadrito / 20) - 0.25) + 2.5 - 0.1)) / 2;
                    double pto_med_cuadro_chiquito_sup_y = ((y_fijo + (altura / 40) + (altura_detalle / 160) + altura_detalle / 40) + ((y_fijo + (altura / 40) + (altura_detalle / 160) + altura_detalle / 40))) / 2;
                    //se esta dibujando las varillas de las esquinas del estribo mas grande
                    //sencillo 
                    //el circulo de referencia es el de la izquierda superior
                    ArrayList<Double> cad_combo11 = new ArrayList();
                    cad_combo11 = as_esquinas(Integer.parseInt(py.getLista().get(i).getPropiedades()[31]));
                    double diametro_varilla_estribo_grande_esq = ((cad_combo11.get(1) / 8.0) * 2.54) / 20;
                    double fill_grande_esq = diametro_varilla_estribo_grande_esq;
                    if (cad_combo11.size() == 2 && cad_combo11.get(0) == 1) {
                        pw.println("circle " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + " " + diametro_varilla_estribo_grande_esq / 2);
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2 - altura / 20 + diametro_varilla_estribo_grande_esq) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                    } else if ((cad_combo11.size() == 2 && cad_combo11.get(0) == 2) || (cad_combo11.size() == 4 && cad_combo11.get(0) == 1 && cad_combo11.get(2) == 1)) {
                        pw.println("circle " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + " " + diametro_varilla_estribo_grande_esq / 2);
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2 - altura / 20 + diametro_varilla_estribo_grande_esq) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        double diametro_varilla_estribo_grande_esq2;
                        if (cad_combo11.size() == 2) {
                            diametro_varilla_estribo_grande_esq2 = ((cad_combo11.get(1) / 8.0) * 2.54) / 20;
                        } else {
                            diametro_varilla_estribo_grande_esq2 = ((cad_combo11.get(3) / 8.0) * 2.54) / 20;
                        }
                        pw.println("circle " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq2 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + " " + diametro_varilla_estribo_grande_esq2 / 2);
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq2 / 2 + diametro_varilla_estribo_grande_esq2 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq2 / 2 + diametro_varilla_estribo_grande_esq2 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + 2 * diametro_varilla_estribo_grande_esq2 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2 - altura / 20 + diametro_varilla_estribo_grande_esq2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                    } else if ((cad_combo11.size() == 2 && cad_combo11.get(0) == 3) || (cad_combo11.size() == 4 && cad_combo11.get(0) == 1 && cad_combo11.get(2) == 2)) {
                        pw.println("circle " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + " " + diametro_varilla_estribo_grande_esq / 2);
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2 - altura / 20 + diametro_varilla_estribo_grande_esq) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        double diametro_varilla_estribo_grande_esq3;
                        if (cad_combo11.size() == 2) {
                            diametro_varilla_estribo_grande_esq3 = ((cad_combo11.get(1) / 8.0) * 2.54) / 20;
                        } else {
                            diametro_varilla_estribo_grande_esq3 = ((cad_combo11.get(3) / 8.0) * 2.54) / 20;
                        }
                        pw.println("circle " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq3 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + " " + diametro_varilla_estribo_grande_esq3 / 2);
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq3 / 2 + diametro_varilla_estribo_grande_esq3 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq3 / 2 + diametro_varilla_estribo_grande_esq3 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + 2 * diametro_varilla_estribo_grande_esq / 2 + 2 * diametro_varilla_estribo_grande_esq3 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2 - altura / 20 + diametro_varilla_estribo_grande_esq3) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        pw.println("circle " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2) + "," + (y_fijo + altura / 20 - 2 * diametro_varilla_estribo_grande_esq / 2 - diametro_varilla_estribo_grande_esq3 / 2) + " " + diametro_varilla_estribo_grande_esq3 / 2);
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq3 / 2) + "," + (y_fijo + altura / 20 - 2 * diametro_varilla_estribo_grande_esq / 2 - diametro_varilla_estribo_grande_esq3 / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq3 / 2) + "," + (y_fijo + altura / 20 - 2 * diametro_varilla_estribo_grande_esq / 2 - diametro_varilla_estribo_grande_esq3 / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                        pw.println("mirror " + (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2 + diametro_varilla_estribo_grande_esq3 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_grande_esq / 2 - diametro_varilla_estribo_grande_esq / 2 - diametro_varilla_estribo_grande_esq3 / 2 - altura / 20 + 2 * diametro_varilla_estribo_grande_esq + 2 * diametro_varilla_estribo_grande_esq3 / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y + (0.5)) + " N  ");
                    }
                    //se comienza a dibujar las varillas de las caras del estribo grande
                    ArrayList<Double> cad_combo14 = new ArrayList();
                    if (!py.getLista().get(i).getPropiedades()[12].equals("0")) {
                        //ArrayList<Double> cad_combo14 = new ArrayList();
                        cad_combo14 = as_esquinas(Integer.parseInt(py.getLista().get(i).getPropiedades()[34]));
                        double diametro_varilla_estribo_base = ((cad_combo14.get(1) / 8.0) * 2.54) / 20;
                        double fill_estribo_base = diametro_varilla_estribo_base;
                        double cant_pak_estribo_base = Double.parseDouble(py.getLista().get(i).getPropiedades()[32]);
                        System.out.println("cant_pak_estribo_base " + cant_pak_estribo_base);
                        double separacion_estribo_base = (((Double.parseDouble((py.getLista().get(i).getPropiedades()[2])) - 2 * Double.parseDouble((py.getLista().get(i).getPropiedades()[3]))) - (Double.parseDouble(py.getLista().get(i).getPropiedades()[54]))) / (cant_pak_estribo_base + 1));
                        System.out.println("separacion buscada " + separacion_estribo_base);
                        double inicio_estribo_base_x = (((var_modificacion_muro) + 0.25) + 2.5 + diametro_varilla_estribo_grande_esq / 2 + separacion_estribo_base / 20);
                        for (int t = 0; t < cant_pak_estribo_base; t++) {
                            if (cad_combo14.size() == 2 && cad_combo14.get(0) == 1) {
                                System.out.println("entre");
                                pw.println("circle " + (inicio_estribo_base_x) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2) + " " + diametro_varilla_estribo_base / 2);
                                pw.println("mirror " + (inicio_estribo_base_x + diametro_varilla_estribo_base / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                            } else if ((cad_combo14.size() == 2 && cad_combo14.get(0) == 2) || (cad_combo14.size() == 4 && cad_combo14.get(0) == 1 && cad_combo14.get(2) == 1)) {
                                pw.println("circle " + (inicio_estribo_base_x) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2) + " " + diametro_varilla_estribo_base / 2);
                                pw.println("mirror " + (inicio_estribo_base_x + diametro_varilla_estribo_base / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                                double diametro_varilla_estribo_base2;
                                if (cad_combo14.size() == 2) {
                                    diametro_varilla_estribo_base2 = ((cad_combo14.get(1) / 8.0) * 2.54) / 20;
                                } else {
                                    diametro_varilla_estribo_base2 = ((cad_combo14.get(3) / 8.0) * 2.54) / 20;
                                    System.out.println("entre");
                                }
                                pw.println("circle " + (inicio_estribo_base_x + diametro_varilla_estribo_base / 2 + diametro_varilla_estribo_base2 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base2 / 2) + " " + diametro_varilla_estribo_base2 / 2);
                                pw.println("mirror " + (inicio_estribo_base_x + diametro_varilla_estribo_base / 2 + diametro_varilla_estribo_base2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base2 / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                            } else if ((cad_combo14.size() == 2 && cad_combo14.get(0) == 3) || (cad_combo14.size() == 4 && cad_combo14.get(0) == 1 && cad_combo14.get(2) == 2)) {
                                pw.println("circle " + (inicio_estribo_base_x) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2) + " " + diametro_varilla_estribo_base / 2);
                                pw.println("mirror " + (inicio_estribo_base_x + diametro_varilla_estribo_base / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                                double diametro_varilla_estribo_base3;
                                if (cad_combo14.size() == 2) {
                                    diametro_varilla_estribo_base3 = ((cad_combo14.get(1) / 8.0) * 2.54) / 20;
                                } else {
                                    diametro_varilla_estribo_base3 = ((cad_combo14.get(3) / 8.0) * 2.54) / 20;
                                }
                                pw.println("circle " + (inicio_estribo_base_x + diametro_varilla_estribo_base / 2 + diametro_varilla_estribo_base3 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base3 / 2) + " " + diametro_varilla_estribo_base3 / 2);
                                pw.println("mirror " + (inicio_estribo_base_x + diametro_varilla_estribo_base / 2 + diametro_varilla_estribo_base3) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base3 / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");

                                pw.println("circle " + (inicio_estribo_base_x) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2 - diametro_varilla_estribo_base / 2 - diametro_varilla_estribo_base3 / 2) + " " + diametro_varilla_estribo_base3 / 2);
                                pw.println("mirror " + (inicio_estribo_base_x + diametro_varilla_estribo_base3 / 2) + "," + (y_fijo + altura / 20 - diametro_varilla_estribo_base / 2 - diametro_varilla_estribo_base / 2 - diametro_varilla_estribo_base3 / 2) + "  " + (pto_med_estribo_grande_x) + "," + (pto_med_estribo_grande_y) + " " + (pto_med_estribo_grande_x + (0.5)) + "," + (pto_med_estribo_grande_y) + " N  ");
                            }
                            inicio_estribo_base_x += separacion_estribo_base / 20;
                        }
                    } 
                    pw.println("rectang " + "f " + fill_grande_esq / 2 + " " + (((var_modificacion_muro) + 0.25) + 2.5) + "," + (y_fijo + altura / 20) + " " + ((((x_fijo + ln / 20) + (x_fijo) - var_modificacion_muro_izq + ancho_cuadrito / 20) - 0.25) + 2.5) + "," + y_fijo + "");
                    //dimensiones     
                    pw.println("-layer s ALBA_COTAS ");
                    pw.println("dimlinear " + x_fijo + "," + (y_fijo + altura / 20 + recubrimiento / 20) + " " + (x_fijo + ln / 20) + "," + (y_fijo + altura / 20 + recubrimiento / 20) + " h t " + Math.round(ln));
                    pw.println((x_fijo + 0.3) + "," + (y_fijo + 0.9 + altura / 20 + recubrimiento / 20));                    
                    pw.println("dimlinear " + ((var_modificacion_muro) + 2.5) + "," + (y_fijo - 0.25) + " " + ((var_modificacion_muro) + 2.5) + "," + ((y_fijo + altura / 20) + 0.25) + " v t " + Math.round(altura + 2 * recubrimiento));//hago esto ultimo porque estoy poniendo la altura tal y como es en texto plano
                    pw.println(((var_modificacion_muro) + 2.5 - 0.4) + "," + (y_fijo - 0.25));
                    pw.println("dimlinear " + ((var_modificacion_muro) + 2.5) + "," + ((y_fijo + altura / 20) + 0.25) + " " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5) + "," + ((y_fijo + altura / 20) + 0.25) + " h t " + Math.round(ancho_cuadrito));
                    pw.println(((var_modificacion_muro) + 2.5) + "," + ((y_fijo + altura / 20) + 0.25 + 0.3));                    
                    pw.println("dimlinear " + (((var_modificacion_muro + ancho_cuadrito / 20) - 0.25) + 2.5 - 0.1) + "," + (y_fijo + (altura / 40) + (altura_detalle / 160) + altura_detalle / 40) + " " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5) + "," + (y_fijo + (altura / 40) + (altura_detalle / 160) + altura_detalle / 40) + " h t " + Math.round(recubrimiento_diagonal));
                    pw.println((((var_modificacion_muro + ancho_cuadrito / 20) - 0.25) + 2.5 - 0.1 + 0.1) + "," + (y_fijo + (altura / 40) + (altura_detalle / 160) + altura_detalle / 40));
                    pw.println("-layer s ALBA_TX2 ");
                    if (cad_combo11.size() == 2) {
                        pw.println("qleader " + (x_fijo + 0.25) + "," + (y_fijo) + " " + (x_fijo + 0.25) + "," + (y_fijo - 0.50) + " " + (x_fijo + 0.3) + "," + (y_fijo - 0.50) + " " + 3.0 + " " + 2 * Math.round(cad_combo11.get(0)) + " # " + Math.round(cad_combo11.get(1)));
                        pw.println();
                        pw.println("qleader " + (x_fijo + 0.25) + "," + (y_fijo + altura / 20) + " " + (x_fijo + 0.25) + "," + ((y_fijo + altura / 20) + 0.50) + " " + (x_fijo + 0.3) + "," + ((y_fijo + altura / 20) + 0.50) + " " + 3.0 + " " + 2 * Math.round(cad_combo11.get(0)) + " # " + Math.round(cad_combo11.get(1)));
                        pw.println();
                    } else {
                        pw.println("qleader " + (x_fijo + 0.25) + "," + (y_fijo) + " " + (x_fijo + 0.25) + "," + (y_fijo - 0.50) + " " + (x_fijo + 0.3) + "," + (y_fijo - 0.50) + " " + 3.0 + " " + 2 * Math.round(cad_combo11.get(0)) + " # " + Math.round(cad_combo11.get(1)) + " + " + 2 * Math.round(cad_combo11.get(2)) + " # " + Math.round(cad_combo11.get(3)));
                        pw.println();
                        pw.println("qleader " + (x_fijo + 0.25) + "," + (y_fijo + altura / 20) + " " + (x_fijo + 0.25) + "," + ((y_fijo + altura / 20) + 0.50) + " " + (x_fijo + 0.3) + "," + ((y_fijo + altura / 20) + 0.50) + " " + 3.0 + " " + 2 * Math.round(cad_combo11.get(0)) + " # " + Math.round(cad_combo11.get(1)) + " + " + 2 * Math.round(cad_combo11.get(2)) + " # " + Math.round(cad_combo11.get(3)));
                        pw.println();
                    }
                    pw.println("-layer s ALBA_TEXTO_TITULOS ");
                    //texto con nombre de viga
                    String nombre_viga = "VIGA DE ACOPLE VA-" + (i + 1) + " (" + py.getLista().get(i).getNombre_viga() + ")";
                    pw.println("-text " + var_modificacion_muro_izq + "," + (((y_inicio + recubrimiento / 20) - espacio) - 1) + " 0.3 0 " + nombre_viga);
                    //pw.println("line "+var_modificacion_muro_izq + "," + (((y_inicio + recubrimiento / 20) - espacio) - 1.001)+" "+(x_inicio - cateto_adyacente - espacio + nombre_viga.length()) + "," + (((y_inicio + recubrimiento / 20) - espacio) - 1.001)+" ");
                    pw.println("-layer s ALBA_TX2 ");
                    pw.println("-text " + var_modificacion_muro_izq + "," + (((y_inicio + recubrimiento / 20) - espacio) - 1.6) + " 0.2 0 " + "ESC 1:20                                 [cm]");
                    char cuad = '²';
                    pw.println("-text " + var_modificacion_muro_izq + "," + (((y_inicio + recubrimiento / 20) - espacio) - 2.2) + " 0.2 0 " + "f'c = " + ((int) Double.parseDouble(py.getLista().get(i).getPropiedades()[6])) + " cm²"/*+((int)cuad)*/);
                    double margen = 0.15;
                    pw.println("-text " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 0.7) + "," + ((y_fijo + altura / 20) + 0.25 - margen) + " 0.2 0 " + "VIGA:");
                    if (cad_combo11.size() == 2) {
                        pw.println("-text " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 0.7) + "," + ((y_fijo + altura / 20) + 0.25 - (margen += 0.60)) + " 0.2 0 " + Math.round(cad_combo11.get(0)) + " # " + Math.round(cad_combo11.get(1)) + " @ ESQ");
                    } else {
                        pw.println("-text " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 0.7) + "," + ((y_fijo + altura / 20) + 0.25 - (margen += 0.60)) + " 0.2 0 " + Math.round(cad_combo11.get(0)) + " # " + Math.round(cad_combo11.get(1)) + " + " + Math.round(cad_combo11.get(2)) + " # " + Math.round(cad_combo11.get(3)) + " @ ESQ");
                    }
                    pw.println("-text " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 0.7) + "," + ((y_fijo + altura / 20) + 0.25 - (margen += 0.60)) + " 0.2 0 " + py.getLista().get(i).getPropiedades()[51].substring(12, 13) + " # " + py.getLista().get(i).getPropiedades()[51].substring(14, 15) + " @ CL");
                    pw.println("-text " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 0.7) + "," + ((y_fijo + altura / 20) + 0.25 - (margen += 0.60)) + " 0.2 0 " + estribo_en_viga_tipo(estribo_viga_tipo) + " @ " + estrivo_en_viga_sep(estribo_viga_separacion));
                    if (Integer.parseInt(py.getLista().get(i).getPropiedades()[32]) != 0) {
                        if (cad_combo14.size() == 2) {
                            pw.println("-text " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 0.7) + "," + ((y_fijo + altura / 20) + 0.25 - (margen += 0.60)) + " 0.2 0 " + (Math.round(Double.parseDouble(py.getLista().get(i).getPropiedades()[32])) * Math.round(cad_combo14.get(0))) + " # " + Math.round(cad_combo14.get(1)) + " @ CC");
                        } else {
                            pw.println("-text " + ((var_modificacion_muro + ancho_cuadrito / 20) + 2.5 + 0.7) + "," + ((y_fijo + altura / 20) + 0.25 - (margen += 0.60)) + " 0.2 0 " + (Math.round(Double.parseDouble(py.getLista().get(i).getPropiedades()[32])) * Math.round(cad_combo14.get(0))) + " # " + Math.round(cad_combo14.get(1)) + " + " + (Math.round(Double.parseDouble(py.getLista().get(i).getPropiedades()[32])) * Math.round(cad_combo14.get(2))) + " # " + Math.round(cad_combo14.get(3)) + ") @ CC");
                        }
                    }
                    //para mirror en cotas
                    pw.println("-layer s ALBA_COTAS ");
                    pw.println("-layer s ALBA_SECCIONES ");
                    pw.println("pline " + (x_fijo + ln / 20 - 1.5) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + " " + (x_fijo + ln / 20 - 1.5 + 0.25) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 + 0.15) + " " + (x_fijo + ln / 20 - 1.5 + 0.15) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + " " + (x_fijo + ln / 20 - 1.5) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + " " + (x_fijo + ln / 20 - 1.5 + 0.25) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 - 0.15) + " " + (x_fijo + ln / 20 - 1.5 + 0.15) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + " " + (x_fijo + ln / 20 - 0.5) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + " ");
                    pw.println("mirror " + (x_fijo + ln / 20 - 1.5) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + "  " + (((x_inicio - espacio) + (((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)))) / 2) + "," + (((y_medio) + (y_medio)) / 2) + " " + (((x_inicio - espacio) + (((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)))) / 2 + 0.1) + "," + (((y_medio) + (y_medio)) / 2) + " N  ");
                    pw.println("circle " + (x_fijo + ln / 20 - 0.90) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + " " + (0.952 / 20));
                    pw.println("mirror " + (x_fijo + ln / 20 - 0.90) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 + (0.952 / 20)) + "  " + (((x_inicio - espacio) + (((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)))) / 2) + "," + (((y_medio) + (y_medio)) / 2) + " " + (((x_inicio - espacio) + (((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)))) / 2 + 0.1) + "," + (((y_medio) + (y_medio)) / 2) + " N  ");
                    pw.println("pline " + (x_fijo + ln / 20 - 0.90) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5) + " " + (x_fijo + ln / 20 - 0.90 + 0.3) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 + 0.3) + " " + (((var_modificacion_muro + ancho_cuadrito / 20) - 0.25) + 2.5) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 + 0.3) + " ");
                    pw.println("line " + (x_fijo + ln / 20 - 0.90) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 + 0.3) + " " + (x_fijo + ln / 20 - 0.90) + "," + (((y_medio) + (y_medio)) / 2) + " ");
                    pw.println("mirror " + (x_fijo + ln / 20 - 0.90) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 + 0.3) + "  " + (((x_inicio - espacio) + (((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)))) / 2) + "," + (((y_medio) + (y_medio)) / 2) + " " + (((x_inicio - espacio) + (((x_fijo + ln / 20) + (x_fijo) - (x_inicio - espacio)))) / 2 + 0.1) + "," + (((y_medio) + (y_medio)) / 2) + " N  ");
                    //pw.println("-text " + (((var_modificacion_muro + ancho_cuadrito / 20) - 0.25) + 2.5 - ancho_cuadrito / 20) + "," + (y_fijo + altura / 20 + recubrimiento / 20 + 0.5 + 0.35) + " 0.2 0 " + " SECCION");
                    pw.println("-layer s ALBA_TEXTO_TITULOS ");
                    pw.println("-text " + ((var_modificacion_muro) + 1.5) + "," + (y_fijo - 0.25 - 1.0) + " 0.3 0 " + "SECCION A - A'");
                    pw.println("-layer s ALBA_TX2 ");
                    pw.println("-text " + ((var_modificacion_muro) + 1.5) + "," + (y_fijo - 0.25 - 1.6) + " 0.2 0 " + " ESC 1:20               [cm]");
                
                y_fijo = (((((y_inicio + recubrimiento / 20) - espacio)) + altura / 20 + 2 * (y_fijo - ((y_inicio + recubrimiento / 20) - espacio)))) + 15;
            }
            pw.print("-osnap endpoint,midpoint,center,node,quadrant,intersection,extension,perpendicular,tangent,nearest,parallel ");
            pw.close();
            fichero.close();
        } catch (Exception e) {
            System.out.println("Fichero SCR con problemas " + e.getMessage());
            System.out.println("" + e.getCause());
            System.out.println("" + e.toString());
            System.out.println("" + e.getLocalizedMessage());
        }
    }
}
