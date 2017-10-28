/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.visual;

import acoples.clases.Proyecto;
import acoples.clases.Vigas;
import acoples.comunes.ChecarErrores;
import acoples.comunes.Py_Serializable;
import acoples.comunes.Trazado;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Alba Proyecto
 */
public class Ventana_calculo_edicion extends javax.swing.JInternalFrame {

    /**
     *
     *
     * Creates new form Ventana_calculo
     */
    protected String nombre;
    protected ArrayList<String> list = new ArrayList<>();
    private Proyecto editable;
    private Proyecto py = new Proyecto();
    private Vigas vg;
    private int numero_viiga = 0;
    private ChecarErrores ch = new ChecarErrores();
    private ArrayList<String> elementos;
    private int posicion;
    private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private boolean flag = true;
    private String nombre_edit = "";
    private boolean banderin = false;
    private boolean banderin_edit = false;
    private int contador_viga = 1;
    private boolean flag_contador = false;
    private double db_equivalente_combo1 = 1.91;
    private double db_equivalente_combo6 = 1.91;
    private double db_equivalente_combo11 = 1.91;
    private double db_combo2y4 = 1.91;
    private double db_combo3y5 = 1.91;
    private double db_combo12y14 = 1.91;
    private int cont_pak_base = 0;
    private int cont_pak_cara = 0;
    private boolean estado_paneles_diag = true;
    private double constante = 2.65;
    private double separacion_diag_base;
    private double separacion_diag_caras;

    public Ventana_calculo_edicion(Proyecto editable) {
        this.editable = editable;
        initComponents();
        setTitle(editable.devuelveNombre());
        setBounds(0, 0, 1300, 930);
        //setBounds(0, 0, 1260, d.height-100);
        poblar_combo();
        py.setNombre_proyecto(editable.devuelveNombre());
        jPanel2.setVisible(false);
        //lo que le quite porque no hace falta por el momento
        combo8.setVisible(false);
        combo10.setVisible(false);
        combo17.setVisible(false);
        jt25.setVisible(false);
        jt18.setVisible(false);
    }

    public void poblar_combo() {
        //datos=NewMDIApplication1.mf.lectura_fichero();
        for (int i = 0; i < editable.getLista().size(); i++) {
            //List temp = (List) editable.getLista().get(i);
            jComboBox2.addItem(editable.getLista().get(i).getNombre_viga());
        }
    }

    public void actualizar_jl4() {
        double n_jl1 = Double.parseDouble(jl1.getText().substring(20, jl1.getText().length()));
        double n_jl2 = Double.parseDouble(jl2.getText().substring(17, jl2.getText().length()));
        double n_jl3 = Double.parseDouble(jl3.getText().substring(17, jl3.getText().length()));
        double redondear = n_jl1 + n_jl2 + n_jl3;
        jl4.setText("As total long = " + redondeo(redondear, 2));

        //jl4.setText("As total long = " + (n_jl1 + n_jl2 + n_jl3));
    }

    public void limpieza() {
        jt1.setText(null);
        jt2.setText(null);
        jt3.setText(null);
        jt5.setText(null);
        jt6.setText("35.0");
        jt7.setText(null);
        jt8.setText("4220.0");
        jt9.setText("4220.0");
        //jt8.setText(null);
        //jt9.setText(null);
        jt10.setText(null);
        jt11.setText(null);
        jt12.setText(null);
        jt15.setText(null);
        jt16.setText(null);
        jt21.setText("l desarrollo propuesta [cm] = 60");
        jt24.setText(null);
        jt26.setText(null);
        jl1.setText("As Esquinas [cm²] = 11.4");
        jl2.setText("As cara b [cm²] = 0.0");
        jl3.setText("As cara d [cm²] = 0.0");
        jl4.setText("As total long = 11.4");
        jl5.setText("l desarrollo [cm] = 60");
        jl10.setText("As Esquinas [cm²] = 5.7");
        jl11.setText("As cara b [cm²] = 0.0");
        combo1.setSelectedIndex(0);
        combo2.setSelectedIndex(0);
        combo3.setSelectedIndex(0);
        combo4.setSelectedIndex(0);
        combo5.setSelectedIndex(0);
        combo6.setSelectedIndex(0);
        combo7.setSelectedIndex(0);
        combo8.setSelectedIndex(0);
        combo9.setSelectedIndex(0);
        combo9.setBackground(UIManager.getColor(combo11));
        combo10.setSelectedIndex(0);
        combo11.setSelectedIndex(0);
        combo12.setSelectedIndex(0);
        combo13.setSelectedIndex(0);
        combo14.setSelectedIndex(0);
        combo15.setSelectedIndex(0);
        combo16.setSelectedIndex(0);
        combo17.setSelectedIndex(0);
        //combo18.setSelectedIndex(0);
        combo19.setSelectedIndex(0);
        combo20.setSelectedIndex(0);
        apellido_viga.setText(null);

        //garantizar que nada se quede en rojo
        jt1.setBackground(Color.white);
        jt2.setBackground(Color.white);
        jt3.setBackground(Color.white);
        jt5.setBackground(Color.white);
        jt6.setBackground(Color.white);
        jt7.setBackground(Color.white);
        jt8.setBackground(Color.white);
        jt9.setBackground(Color.white);
        jt10.setBackground(Color.white);
        jt11.setBackground(Color.white);
        jt12.setBackground(Color.white);
        jt15.setBackground(Color.white);
        jt16.setBackground(Color.white);
        jt21.setBackground(Color.white);;
        jt24.setBackground(Color.white);
        combo1.setBackground(UIManager.getColor(combo1));
        combo2.setBackground(UIManager.getColor(combo1));
        combo3.setBackground(UIManager.getColor(combo1));
        combo5.setBackground(UIManager.getColor(combo1));
        combo6.setBackground(UIManager.getColor(combo1));
        combo7.setBackground(UIManager.getColor(combo1));
        combo8.setBackground(UIManager.getColor(combo1));
        combo9.setBackground(UIManager.getColor(combo1));
        combo10.setBackground(UIManager.getColor(combo1));
        combo11.setBackground(UIManager.getColor(combo1));
        combo12.setBackground(UIManager.getColor(combo1));
        combo13.setBackground(UIManager.getColor(combo1));
        combo14.setBackground(UIManager.getColor(combo1));
        combo15.setBackground(UIManager.getColor(combo1));
        combo16.setBackground(UIManager.getColor(combo1));
        combo17.setBackground(UIManager.getColor(combo1));
        combo19.setBackground(UIManager.getColor(combo1));
        combo20.setBackground(UIManager.getColor(combo1));
        apellido_viga.setBackground(Color.white);
    }

    public void longitud_desarrollo() {//ESTE METODO TAMBIEN CALCULA LA SEPARACION MAXIMA
        double result = 0;
        double db1 = 0;
        double db2 = 0;
        double db3 = 0;
        double db = 1;
        boolean marca = false;
        boolean marca1 = false;
        boolean marca2 = false;
        boolean marca3 = false;
        double aux_min = 0;
        double min = 0;
        switch (combo1.getSelectedIndex()) {
            case 0:
                db1 = 6;
                marca1 = true;
                break;
            case 1:
                db1 = 8;
                marca1 = true;
                break;
            case 2:
                db1 = 6;
                break;
            case 3:
                db1 = 10;
                marca1 = true;
                break;
            case 4:
                db1 = 8;
                break;
            case 5:
                db1 = 10;
                break;
            case 6:
                db1 = 12;
                marca1 = true;
                break;
            case 7:
                db1 = 10;
                break;
            case 8:
                db1 = 8;
                break;
            case 9:
                db1 = 10;
                break;
            case 10:
                db1 = 10;
                break;
            case 11:
                db1 = 12;
                break;
            case 12:
                db1 = 10;
                break;
            case 13:
                db1 = 12;
                break;
            case 14:
                db1 = 12;
                break;
        }

        switch (combo4.getSelectedIndex()) {
            case 0:
                db2 = 6;
                marca2 = true;
                break;
            case 1:
                db2 = 8;
                marca2 = true;
                break;
            case 2:
                db2 = 6;
                break;
            case 3:
                db2 = 10;
                marca2 = true;
                break;
            case 4:
                db2 = 8;
                break;
            case 5:
                db2 = 10;
                break;
            case 6:
                db2 = 12;
                marca2 = true;
                break;
            case 7:
                db2 = 10;
                break;
            case 8:
                db2 = 8;
                break;
            case 9:
                db2 = 10;
                break;
            case 10:
                db2 = 10;
                break;
            case 11:
                db2 = 12;
                break;
            case 12:
                db2 = 10;
                break;
            case 13:
                db2 = 12;
                break;
            case 14:
                db2 = 12;
                break;
        }

        switch (combo5.getSelectedIndex()) {
            case 0:
                db3 = 6;
                marca3 = true;
                break;
            case 1:
                db3 = 8;
                marca3 = true;
                break;
            case 2:
                db3 = 6;
                break;
            case 3:
                db3 = 10;
                marca3 = true;
                break;
            case 4:
                db3 = 8;
                break;
            case 5:
                db3 = 10;
                break;
            case 6:
                db3 = 12;
                marca3 = true;
                break;
            case 7:
                db3 = 10;
                break;
            case 8:
                db3 = 8;
                break;
            case 9:
                db3 = 10;
                break;
            case 10:
                db3 = 10;
                break;
            case 11:
                db3 = 12;
                break;
            case 12:
                db3 = 10;
                break;
            case 13:
                db3 = 12;
                break;
            case 14:
                db3 = 12;
                break;
        }

        //definir lo de los paquetes que dependen de las variables marca si solo hay una que tiene paquete y el db es igual en las tres se multiplica por 1.2 al final
        //pero si la de mayor diametro es simple no importa que haya otra que tenga paquete me quedo con la de mayor diametro
        System.out.println("");
        if (combo2.getSelectedIndex() != 0 && combo3.getSelectedIndex() != 0) {
            if (db1 > db2 && db1 > db3) {
                System.out.println("db1>db2 && db1>db3");
                System.out.println("");
                db = db1;
                marca = marca1;
            } else if (db2 > db1 && db2 > db3) {
                System.out.println("db2>db1 && db2>db3");
                System.out.println("");
                db = db2;
                marca = marca2;
            } else if (db3 > db1 && db3 > db2) {
                System.out.println("db3>db1 && db3>db2");
                System.out.println("");
                db = db3;
                marca = marca3;
            } else if (db1 == db2 && db1 > db3) {
                System.out.println("db1==db2 && db1>db3");
                System.out.println("");
                db = db1;
                marca = (marca1 && marca2);
            } else if (db1 == db3 && db1 > db2) {
                System.out.println("db1==db3 && db1>db2");
                System.out.println("");
                db = db1;
                marca = (marca1 && marca3);
            } else if (db2 == db3 && db2 > db1) {
                System.out.println("db2==db3 && db2>db1");
                System.out.println("");
                db = db2;
                marca = (marca2 && marca3);
            } else if (db1 == db2 && db2 == db3) {
                System.out.println("db1==db2 && db2==db3");
                db = db1;
                marca = (marca1 && marca2 && marca3);
            }
            aux_min = Math.min(db1, db2);
            min = Math.min(aux_min, db3);
        } else if (combo2.getSelectedIndex() != 0 && combo3.getSelectedIndex() == 0) {
            if (db1 > db2) {
                System.out.println("db1>db2");
                System.out.println("");
                db = db1;
                marca = marca1;
            } else if (db2 > db1) {
                System.out.println("db2>db");
                System.out.println("");
                db = db2;
                marca = marca2;
            } else if (db1 == db2) {
                System.out.println("db1==db2");
                System.out.println("");
                db = db1;
                marca = (marca1 && marca2);
            }
            min = Math.min(db1, db2);
        } else if (combo2.getSelectedIndex() == 0 && combo3.getSelectedIndex() != 0) {
            if (db1 > db3) {
                System.out.println("db1>db3");
                System.out.println("");
                db = db1;
                marca = marca1;
            } else if (db3 > db1) {
                System.out.println("db32>db");
                System.out.println("");
                db = db3;
                marca = marca3;
            } else if (db1 == db3) {
                System.out.println("db1==db3");
                System.out.println("");
                db = db1;
                marca = (marca1 && marca3);
            }
            min = Math.min(db1, db3);
        } else if (combo2.getSelectedIndex() == 0 && combo3.getSelectedIndex() == 0) {
            db = db1;
            marca = marca1;
            min = db1;
        }

        System.out.println("");
        System.out.println("db1= " + db1);
        System.out.println("db2= " + db2);
        System.out.println("db3= " + db3);
        System.out.println("db= " + db);
        System.out.println("marca1= " + marca1);
        System.out.println("marca2= " + marca2);
        System.out.println("marca3= " + marca3);
        System.out.println("marca= " + marca);
        System.out.println("");

        double comodin_anti_error = 0;
        elementos.add(jt7.getText());

        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt7.getText()) < 250 || Double.parseDouble(jt7.getText()) > 1000) {
            comodin_anti_error = 250.0;
        } else {
            comodin_anti_error = Double.parseDouble(jt7.getText());
        }

        if (db <= 6) {
            System.out.println("Entro a menor");
            result = (Double.parseDouble(jt8.getText()) * 1 * 1) / (6.6 * 1 * Math.sqrt(comodin_anti_error)) * db / 8 * 2.54 * 1.25;
        } else {
            System.out.println("Entro a mayor");
            result = (Double.parseDouble(jt8.getText()) * 1 * 1) / (5.3 * 1 * Math.sqrt(comodin_anti_error)) * db / 8 * 2.54 * 1.25;
        }
        System.out.println("resultado= " + result);
        if (marca) {
            jl5.setText("l desarrollo [cm] = " + String.valueOf(Math.round(result)));
            System.out.println("sin paquete");
        } else {
            jl5.setText("l desarrollo [cm] = " + String.valueOf(Math.round(result * 1.2)));
            System.out.println("con paquete");
        }

        //longitud de desarrollo propuesta
        jt21.setText("l desarrollo propuesta [cm] = " + jl5.getText().substring(20));

//        System.out.println("Separacion maxima");
//        aux_min = Math.min(db1, db2);
//        min = Math.min(aux_min, db3);
        System.out.println(min);
        jl9.setText("separación max [cm²] = " + Math.round(min * 6 * 2.54 / 8));

        //jl5.setText(Double.parseDouble(title));
    }

    public double redondeo(double num, int cifras) {
        int aux;
        if (cifras == 2) {
            num = num + 0.005;
            num = num * 100;
            aux = (int) num;
            num = (double) aux / 100;
        } else if (cifras == 1) {
            num = num + 0.05;
            num = num * 10;
            aux = (int) num;
            num = (double) aux / 10;
        }
        return num;
    }

    public void estado_combo9() {
        double medida[] = {5, 6, 7.5, 9, 10, 12.5, 15, 17.5, 20, 22.5, 25, 27.5, 30, 32.5, 35};
        Map<Integer, Double> mapa = new HashMap<Integer, Double>();
        double valor = 0;
        int sep_max = Integer.parseInt(jl9.getText().substring(23));
        switch (combo9.getSelectedIndex()) {
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
        if (valor > sep_max) {
            Color anterior = combo10.getBackground();
            combo9.setBackground(Color.ORANGE);
            //JOptionPane.showMessageDialog(null, "No se puede seleccionar un elemento por encima de la separación máxima");
            double min = sep_max;
            for (int i = medida.length - 1; i >= 0; i--) {
                if (min > medida[i]) {
                    min = medida[i];
                    combo9.setSelectedIndex(i);
                    break;
                }
            }
        } else {
            combo9.setBackground(UIManager.getColor(combo11));
        }
    }

    public void calculo_mr() {
        double comodin_anti_error = 0;
        elementos = new ArrayList<>();
        elementos.add(jt7.getText());

        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt7.getText()) < 250 || Double.parseDouble(jt7.getText()) > 1000) {
            comodin_anti_error = 250.0;
        } else {
            comodin_anti_error = Double.parseDouble(jt7.getText());
        }
        //System.out.println(jl10.getText().substring(20));
        jt24.setText(String.valueOf(redondeo(((0.9 * Double.parseDouble(jl10.getText().substring(20)) * Double.parseDouble(jt8.getText()) * (Double.parseDouble(jt2.getText()) * 0.9 - (Double.parseDouble(jl10.getText().substring(20)) * Double.parseDouble(jt8.getText())) / (1.7 * comodin_anti_error * Double.parseDouble(jt3.getText()))))) / 100000, 2)));
        if (Double.parseDouble(jt24.getText()) < Double.parseDouble(jt23.getText())) {
            jt23.setBackground(Color.ORANGE);
        } else {
            jt23.setBackground(Color.WHITE);
        }
    }

    public void calculo_angulo() {
        double conversion = 180 / 3.14159265;
//        double angulo=Math.atan ( (Double.parseDouble(jt2.getText()) - 25) / Double.parseDouble(jt1.getText()))*conversion;
//        jt6.setText(String.valueOf(Math.round(angulo)));
        double angulo = Math.atan((Double.parseDouble(jt2.getText()) - 2 * (Double.parseDouble(jt4.getText())) - Double.parseDouble(jt16.getText())) / Double.parseDouble(jt1.getText())) * conversion;
        jt6.setText(String.valueOf(Math.round(angulo)));
    }

    public void calculo_notificacion() {
        if (Double.parseDouble(jt10.getText()) > Double.parseDouble(jt12.getText())) {
            jt12.setBackground(Color.ORANGE);
        } else {
            jt12.setBackground(Color.WHITE);
        }

    }

    public void gama_colores_jt5() {
        if (Double.parseDouble(jt5.getText()) <= 0.5) {
            if (Double.parseDouble(jt10.getText()) / (Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) * Math.sqrt(Double.parseDouble(jt7.getText()))) <= 0.6 * constante) {
                System.out.println("Diseñar como puntal tensor");
                //tratamiento nuevo
                estado_paneles_diag = true;
                setBounds(0, 0, 1300, 930);
                jPanel5.setVisible(estado_paneles_diag);
                //jPanel10.setVisible(estado_paneles_diag);
                jPanel17.setVisible(estado_paneles_diag);
                ordinaria.setEnabled(true);
                especial.setEnabled(true);
                ordinaria.setSelected(true);
                jt5.setBackground(Color.GREEN);
            } else {
                System.out.println("Modificar seccion");
                jt5.setBackground(Color.RED);
            }
        } else if (Double.parseDouble(jt5.getText()) <= 2) {
            if (Double.parseDouble(jt10.getText()) / (Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) * Math.sqrt(Double.parseDouble(jt7.getText()))) <= 0.85 * constante) {
                System.out.println("Diseñar con diagonales");
                //tratamiento nuevo
                if (estado_paneles_diag == false) {
                    estado_paneles_diag = true;
                    setBounds(0, 0, 1300, 930);
                    jPanel5.setVisible(estado_paneles_diag);
                    //jPanel10.setVisible(estado_paneles_diag);
                    jPanel17.setVisible(estado_paneles_diag);
                }
                ordinaria.setEnabled(false);
                especial.setEnabled(false);
                jt5.setBackground(Color.WHITE);
            } else {
                System.out.println("Modificar seccion");
                jt5.setBackground(Color.RED);
            }
        } else if (Double.parseDouble(jt5.getText()) >= 4) {
            if (Double.parseDouble(jt10.getText()) / (Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) * Math.sqrt(Double.parseDouble(jt7.getText()))) <= 0.75 * constante) {
                System.out.println("Diseñar como viga especial (SMF)");
                //tratamiento nuevo
                if (estado_paneles_diag == true) {
                    estado_paneles_diag = false;
                    setBounds(0, 0, 950, 750);
                    //jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
                    //jPanel2.setBounds(0, 0, 650, 500);
                    jPanel5.setVisible(estado_paneles_diag);
                    //jPanel10.setVisible(estado_paneles_diag);
                    jPanel17.setVisible(estado_paneles_diag);
                }
                ordinaria.setEnabled(false);
                especial.setEnabled(false);
                jt5.setBackground(Color.LIGHT_GRAY);
            } else {
                System.out.println("Modificar seccion");
                jt5.setBackground(Color.RED);
            }
        } else {
            if (Double.parseDouble(jt10.getText()) / (Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) * Math.sqrt(Double.parseDouble(jt7.getText()))) >= 0.85 * constante) {
                System.out.println("Modificar seccion");
                jt5.setBackground(Color.RED);
            } else if ((Double.parseDouble(jt10.getText()) / (Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) * Math.sqrt(Double.parseDouble(jt7.getText()))) <= 0.2 * (constante / 2) * Double.parseDouble(jt5.getText()))) {
                System.out.println("Recomendado diseñar como viga especial (SMF)");
                //tratamiento nuevo
                estado_paneles_diag = true;
                setBounds(0, 0, 1300, 930);
                jPanel5.setVisible(estado_paneles_diag);
                //jPanel10.setVisible(estado_paneles_diag);
                jPanel17.setVisible(estado_paneles_diag);
                ordinaria.setEnabled(true);
                especial.setEnabled(true);
                ordinaria.setSelected(true);
                jt5.setBackground(Color.GRAY);
            } else {
                System.out.println("Recomendado diseñar con diagonales");
                //tratamiento nuevo
                estado_paneles_diag = true;
                setBounds(0, 0, 1300, 930);
                jPanel5.setVisible(estado_paneles_diag);
                //jPanel10.setVisible(estado_paneles_diag);
                jPanel17.setVisible(estado_paneles_diag);
                ordinaria.setEnabled(true);
                especial.setEnabled(true);
                ordinaria.setSelected(true);
                jt5.setBackground(Color.CYAN);
            }
        }

        /*if (Double.parseDouble(rec.getPropiedades()[4]) >= 2) {
                    jt5.setBackground(Color.WHITE);
                }*/
    }
    
    public double control_separacion(double sep, int var, int grap) {
        double separacion = sep;
        double varillas = var;
        double grapas = grap;
        double sep_aux = 0;
        int u = (int) (35 / separacion);  //cantidad de varillas que pueden estar dentro de la separacion
//        System.out.println(varillas/separacion);
        System.out.println("VALOR DE U = " + u);
        System.out.println("VALOR DE SEPARACION = " + separacion);
        System.out.println("VALOR DE VARILLAS = " + varillas);
        System.out.println("VALOR DE GRAPAS = " + grapas);
        //        System.out.println(separacion%varillas);
        if (grapas > varillas) {
            sep_aux = 2;
            System.out.println("no pueden haber más grapas que paquetes de varillas");
        } else if (separacion > 35) {
            System.out.println("La separación entre varillas es mayor que 35cm, no es posible poner grapas");
            //JOptionPane.showMessageDialog(null, "La separación entre varillas es mayor que 35cm, no es posible poner grapas");
            sep_aux = 3;
        } else {
            if (grapas < varillas) {
                double resta = varillas - grapas;
                if (resta >= u) {
                    if (( (int)(resta / u) + (resta % u) / u + 1) * separacion > 35) {
                        System.out.println("AQUI ******************** "+(( (int)(resta / u) + (resta % u) / u + 1) * separacion));
                        sep_aux = 1;
                    } else {
                        sep_aux = 0;
                    }
                } else {
                    if (((int)(resta / u) + 1) * separacion > 35) {
                        sep_aux = 1;
                    } else {
                        sep_aux = 0;
                    }
                }
            } else {//cuando sean iguales
                sep_aux = 0;
            }
        }
        return sep_aux;
    }
    
    public void separacion_varillas_base(int tipo) {
        //calculo de separacion de varillas en la base, el entero se le pasa para diferenciar cuando el evento se ejecuta desde el combo 2
        if (tipo == 1) {
            separacion_diag_base = (Double.parseDouble(jt15.getText()) - db_equivalente_combo1) / (combo2.getSelectedIndex() + 1);
            System.out.println("separacion " + separacion_diag_base);
            if (separacion_diag_base < Math.max(2 * db_combo2y4, db_combo2y4 + 2.5)) {
                combo2.setBackground(Color.ORANGE);
                combo2.setSelectedIndex(0);
            } else {
                combo2.setBackground(UIManager.getColor(combo1));
            }
        }else{
            separacion_diag_base = (Double.parseDouble(jt15.getText()) - db_equivalente_combo1) / (combo2.getSelectedIndex() + 1);
            if (separacion_diag_base < Math.max(2 * db_combo2y4, db_combo2y4 + 2.5)) {
                combo2.setBackground(Color.ORANGE);
                combo2.setSelectedIndex(0);
            }
        }

    }
    
    public void separacion_varillas_cara(int tipo) {
        //calculo de separacion de varillas en la base, el entero se le pasa para diferenciar cuando el evento se ejecuta desde el combo 2
        if (tipo == 1) {
        separacion_diag_caras = (Double.parseDouble(jt16.getText()) - db_equivalente_combo1) / (combo3.getSelectedIndex() + 1);
        if (separacion_diag_caras < Math.max(2 * db_combo3y5, db_combo3y5 + 2.5)) {
            combo3.setBackground(Color.ORANGE);
            combo3.setSelectedIndex(0);
        } else {
            combo3.setBackground(UIManager.getColor(combo1));
        }
        }else{
            separacion_diag_caras = (Double.parseDouble(jt16.getText()) - db_equivalente_combo1) / (combo3.getSelectedIndex() + 1);
            if (separacion_diag_caras < Math.max(2 * db_combo3y5, db_combo3y5 + 2.5)) {
                combo3.setBackground(Color.ORANGE);
                combo3.setSelectedIndex(0);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel15 = new javax.swing.JPanel();
        aceptar_1 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        ordinaria = new javax.swing.JRadioButton();
        especial = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        jt7 = new javax.swing.JTextField();
        jLabel90 = new javax.swing.JLabel();
        jt8 = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jt9 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        jt13 = new javax.swing.JTextField();
        jLabel141 = new javax.swing.JLabel();
        jt14 = new javax.swing.JTextField();
        jLabel127 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel79 = new javax.swing.JLabel();
        jt1 = new javax.swing.JTextField();
        jLabel126 = new javax.swing.JLabel();
        jt2 = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jt3 = new javax.swing.JTextField();
        jLabel118 = new javax.swing.JLabel();
        jt4 = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        jt5 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        jt6 = new javax.swing.JTextField();
        jPanel17 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jt15 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jt16 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jt17 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jt18 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jl1 = new javax.swing.JLabel();
        combo1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jl2 = new javax.swing.JLabel();
        combo2 = new javax.swing.JComboBox<>();
        combo4 = new javax.swing.JComboBox<>();
        jl3 = new javax.swing.JLabel();
        combo3 = new javax.swing.JComboBox<>();
        combo5 = new javax.swing.JComboBox<>();
        jl4 = new javax.swing.JLabel();
        jt21 = new javax.swing.JTextField();
        jl5 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jl6 = new javax.swing.JLabel();
        combo6 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jl7 = new javax.swing.JLabel();
        combo19 = new javax.swing.JComboBox<>();
        combo7 = new javax.swing.JComboBox<>();
        jl8 = new javax.swing.JLabel();
        combo20 = new javax.swing.JComboBox<>();
        combo8 = new javax.swing.JComboBox<>();
        jl9 = new javax.swing.JLabel();
        combo9 = new javax.swing.JComboBox<>();
        combo10 = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jl10 = new javax.swing.JLabel();
        combo11 = new javax.swing.JComboBox<>();
        jLabel188 = new javax.swing.JLabel();
        jl11 = new javax.swing.JLabel();
        combo12 = new javax.swing.JComboBox<>();
        combo14 = new javax.swing.JComboBox<>();
        jl12 = new javax.swing.JLabel();
        jt26 = new javax.swing.JTextField();
        combo15 = new javax.swing.JComboBox<>();
        jl13 = new javax.swing.JLabel();
        combo13 = new javax.swing.JComboBox<>();
        combo16 = new javax.swing.JComboBox<>();
        jt25 = new javax.swing.JTextField();
        combo17 = new javax.swing.JComboBox<>();
        jPanel14 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jt23 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jt24 = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jt10 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jt11 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jt12 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        apellido_viga = new javax.swing.JTextField();
        guardar_2 = new javax.swing.JButton();
        cancelar_2 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        guardar_3 = new javax.swing.JButton();
        editar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        cancelar_3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de edición", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.X_AXIS));

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jComboBox2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox2KeyPressed(evt);
            }
        });
        jPanel9.add(jComboBox2);

        jPanel8.add(jPanel9);

        jPanel15.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        aceptar_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/Accept-icon.png"))); // NOI18N
        aceptar_1.setText("Aceptar");
        aceptar_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptar_1ActionPerformed(evt);
            }
        });
        aceptar_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                aceptar_1KeyPressed(evt);
            }
        });
        jPanel15.add(aceptar_1);

        jPanel8.add(jPanel15);

        jPanel21.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        buttonGroup1.add(ordinaria);
        ordinaria.setSelected(true);
        ordinaria.setText("Con diagonales");
        ordinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordinariaActionPerformed(evt);
            }
        });
        jPanel21.add(ordinaria);

        buttonGroup1.add(especial);
        especial.setText("Especial");
        especial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                especialActionPerformed(evt);
            }
        });
        jPanel21.add(especial);

        jPanel8.add(jPanel21);

        jPanel1.add(jPanel8);

        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.Y_AXIS));

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Materiales y geometría de la viga", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(0, 153, 255));
        jPanel7.setLayout(new java.awt.GridLayout(6, 4, 2, 2));

        jLabel140.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel140.setText("< f'c [kgf/cm²] =");
        jPanel7.add(jLabel140);

        jt7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt7FocusLost(evt);
            }
        });
        jt7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt7KeyPressed(evt);
            }
        });
        jPanel7.add(jt7);

        jLabel90.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel90.setText("fyl [kgf/cm²] =");
        jPanel7.add(jLabel90);

        jt8.setText("4220.0");
        jt8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt8FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt8FocusLost(evt);
            }
        });
        jt8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt8KeyPressed(evt);
            }
        });
        jPanel7.add(jt8);

        jLabel98.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel98.setText("fyt [kgf/cm²] =");
        jPanel7.add(jLabel98);

        jt9.setText("4220.0");
        jt9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt9FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt9FocusLost(evt);
            }
        });
        jt9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt9KeyPressed(evt);
            }
        });
        jPanel7.add(jt9);

        jLabel138.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel138.setText("ϕ cortante");
        jPanel7.add(jLabel138);

        jt13.setEditable(false);
        jt13.setText("0.85");
        jPanel7.add(jt13);

        jLabel141.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel141.setText("ϕ flexión");
        jPanel7.add(jLabel141);

        jt14.setEditable(false);
        jt14.setText("0.9");
        jPanel7.add(jt14);

        jLabel127.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel127);

        jLabel132.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel7.add(jLabel132);

        jPanel6.add(jPanel7);

        jPanel20.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de inicio", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(204, 0, 0))); // NOI18N
        jPanel20.setForeground(new java.awt.Color(0, 153, 255));
        jPanel20.setLayout(new java.awt.GridLayout(6, 2, 2, 2));

        jLabel79.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel79.setText("< ln [cm] = ");
        jPanel20.add(jLabel79);

        jt1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt1FocusLost(evt);
            }
        });
        jt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt1KeyPressed(evt);
            }
        });
        jPanel20.add(jt1);

        jLabel126.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel126.setText("< h [cm] =");
        jPanel20.add(jLabel126);

        jt2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt2FocusLost(evt);
            }
        });
        jt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt2KeyPressed(evt);
            }
        });
        jPanel20.add(jt2);

        jLabel108.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel108.setText("< bw [cm] =");
        jPanel20.add(jLabel108);

        jt3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt3FocusLost(evt);
            }
        });
        jt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt3KeyPressed(evt);
            }
        });
        jPanel20.add(jt3);

        jLabel118.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel118.setText("r [cm] =");
        jPanel20.add(jLabel118);

        jt4.setEditable(false);
        jt4.setText("5.0");
        jPanel20.add(jt4);

        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("ln / h =");
        jPanel20.add(jLabel110);

        jt5.setEditable(false);
        jPanel20.add(jt5);

        jLabel137.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel137.setText("α propuesto [°] =");
        jPanel20.add(jLabel137);

        jt6.setEditable(false);
        jt6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt6FocusLost(evt);
            }
        });
        jt6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt6KeyPressed(evt);
            }
        });
        jPanel20.add(jt6);

        jPanel6.add(jPanel20);

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Geometría de la diagonal", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(240, 0, 0))); // NOI18N
        jPanel17.setLayout(new java.awt.GridLayout(6, 2, 2, 2));

        jLabel5.setText("bd [cm] = ");
        jPanel17.add(jLabel5);

        jt15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt15FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt15FocusLost(evt);
            }
        });
        jt15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt15KeyPressed(evt);
            }
        });
        jPanel17.add(jt15);

        jLabel12.setText("hd [cm] = ");
        jPanel17.add(jLabel12);

        jt16.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt16FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt16FocusLost(evt);
            }
        });
        jt16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt16KeyPressed(evt);
            }
        });
        jPanel17.add(jt16);

        jLabel22.setText("rd [cm] =");
        jPanel17.add(jLabel22);

        jt17.setEditable(false);
        jt17.setText("7.0");
        jPanel17.add(jt17);
        jPanel17.add(jLabel24);

        jt18.setEditable(false);
        jPanel17.add(jt18);
        jPanel17.add(jLabel25);
        jPanel17.add(jLabel26);
        jPanel17.add(jLabel27);
        jPanel17.add(jLabel28);

        jPanel6.add(jPanel17);

        jPanel3.add(jPanel6);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Refuerzo diagonales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(153, 0, 0))); // NOI18N
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.X_AXIS));

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acero longitudinal en diagonales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel12.setLayout(new java.awt.GridLayout(4, 3, 2, 2));

        jl1.setText("As Esquinas [cm²] = 11.40");
        jPanel12.add(jl1);

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#6 = 2.85 cm² ", "1#8 = 5.07 cm²", "2#6 = 5.70 cm²", "1#10 = 7.92 cm²", "2#8 = 10.13 cm²", "1#10 + 1#6 =  10.77 cm²", "1#12 = 11.40 cm²", "1#10 + 1#8 =  12.98 cm²", "3#8 = 15.20 cm²", "2#10 = 15.83 cm²", "1#10 + 2#8 = 18.05 cm²", "2#12 = 22.80 cm²", "3#10 = 23.75 cm²", "1#12 + 2#10 = 27.24 cm²", "3#12 = 34.20 cm²" }));
        combo1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo1FocusLost(evt);
            }
        });
        combo1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo1KeyPressed(evt);
            }
        });
        jPanel12.add(combo1);
        jPanel12.add(jLabel3);

        jl2.setText("As cara b [cm²] = 0.0");
        jPanel12.add(jl2);

        combo2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 paq", "1 paq", "2 paq", "3 paq", "4 paq", "5 paq", "6 paq", "7 paq", "8 paq", "9 paq", "10 paq" }));
        combo2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo2FocusLost(evt);
            }
        });
        combo2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo2KeyPressed(evt);
            }
        });
        jPanel12.add(combo2);

        combo4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#6 = 2.85 cm² ", "1#8 = 5.07 cm²", "2#6 = 5.70 cm²", "1#10 = 7.92 cm²", "2#8 = 10.13 cm²", "1#10 + 1#6 =  10.77 cm²", "1#12 = 11.40 cm²", "1#10 + 1#8 =  12.98 cm²", "3#8 = 15.20 cm²", "2#10 = 15.83 cm²", "1#10 + 2#8 = 18.05 cm²", "2#12 = 22.80 cm²", "3#10 = 23.75 cm²", "1#12 + 2#10 = 27.24 cm²", "3#12 = 34.20 cm²" }));
        combo4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo4FocusLost(evt);
            }
        });
        combo4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo4KeyPressed(evt);
            }
        });
        jPanel12.add(combo4);

        jl3.setText("As cara d [cm²] = 0.0");
        jPanel12.add(jl3);

        combo3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 paq", "1 paq", "2 paq", "3 paq", "4 paq", "5 paq", "6 paq", "7 paq", "8 paq", "9 paq", "10 paq" }));
        combo3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo3FocusLost(evt);
            }
        });
        combo3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo3KeyPressed(evt);
            }
        });
        jPanel12.add(combo3);

        combo5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#6 = 2.85 cm² ", "1#8 = 5.07 cm²", "2#6 = 5.70 cm²", "1#10 = 7.92 cm²", "2#8 = 10.13 cm²", "1#10 + 1#6 =  10.77 cm²", "1#12 = 11.40 cm²", "1#10 + 1#8 =  12.98 cm²", "3#8 = 15.20 cm²", "2#10 = 15.83 cm²", "1#10 + 2#8 = 18.05 cm²", "2#12 = 22.80 cm²", "3#10 = 23.75 cm²", "1#12 + 2#10 = 27.24 cm²", "3#12 = 34.20 cm²" }));
        combo5.setPreferredSize(new java.awt.Dimension(100, 20));
        combo5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo5FocusLost(evt);
            }
        });
        combo5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo5KeyPressed(evt);
            }
        });
        jPanel12.add(combo5);

        jl4.setText("As total long = 11.40");
        jPanel12.add(jl4);

        jt21.setText("l desarrollo propuesta [cm] = 60");
        jt21.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt21FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt21FocusLost(evt);
            }
        });
        jt21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt21KeyPressed(evt);
            }
        });
        jPanel12.add(jt21);

        jl5.setText("l desarrollo [cm] = 60");
        jPanel12.add(jl5);

        jPanel5.add(jPanel12);

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acero transversal en diagonales", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel13.setLayout(new java.awt.GridLayout(4, 3, 2, 2));

        jl6.setText("estribos [cm²] = 1.42");
        jPanel13.add(jl6);

        combo6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#3 = 1.42 cm²", "1#4 = 2.54 cm²", "2#3 = 2.84 cm²" }));
        combo6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo6FocusLost(evt);
            }
        });
        combo6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo6KeyPressed(evt);
            }
        });
        jPanel13.add(combo6);
        jPanel13.add(jLabel13);

        jl7.setText("grapas v2 [cm²] = 1.42");
        jPanel13.add(jl7);

        combo19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 paq", "1 paq", "2 paq", "3 paq", "4 paq", "5 paq", "6 paq", "7 paq", "8 paq", "9 paq", "10 paq" }));
        combo19.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo19FocusLost(evt);
            }
        });
        combo19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo19KeyPressed(evt);
            }
        });
        jPanel13.add(combo19);

        combo7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gr3 = 0.71", "gr4 = 1.27", "gr5 = 1.98" }));
        combo7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo7FocusLost(evt);
            }
        });
        combo7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo7KeyPressed(evt);
            }
        });
        jPanel13.add(combo7);

        jl8.setText("grapas v3 [cm²] = 1.42");
        jPanel13.add(jl8);

        combo20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 paq", "1 paq", "2 paq", "3 paq", "4 paq", "5 paq", "6 paq", "7 paq", "8 paq", "9 paq", "10 paq" }));
        combo20.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo20FocusLost(evt);
            }
        });
        combo20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo20KeyPressed(evt);
            }
        });
        jPanel13.add(combo20);

        combo8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "gr3 = 0.71", "gr4 = 1.27", "gr5 = 1.98", "e3 = 1.42", "e4 = 2.54", "e5 = 3.96" }));
        combo8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo8FocusLost(evt);
            }
        });
        combo8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo8KeyPressed(evt);
            }
        });
        jPanel13.add(combo8);

        jl9.setText("separación max [cm²] = 11");
        jPanel13.add(jl9);

        combo9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "@ 5 cm", "@ 6 cm", "@ 7.5 cm", "@ 9 cm", "@ 10 cm", "@ 12.5 cm", "@ 15 cm", "@ 17.5 cm", "@ 20 cm", "@ 22.5 cm", "@ 25 cm", "@ 27.5 cm", "@ 30 cm", "@ 32.5 cm", "@ 35 cm" }));
        combo9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo9FocusLost(evt);
            }
        });
        combo9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo9KeyPressed(evt);
            }
        });
        jPanel13.add(combo9);

        combo10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hay confinamiento en bordes", "No hay confinamiento en bordes", "Hay confinamiento b. izquierdo", "Hay confinamiento b. derecho" }));
        combo10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo10KeyPressed(evt);
            }
        });
        jPanel13.add(combo10);

        jPanel5.add(jPanel13);

        jPanel3.add(jPanel5);

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel10.setLayout(new javax.swing.BoxLayout(jPanel10, javax.swing.BoxLayout.X_AXIS));

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Diseño por flexión ACI318-1 21.5", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(153, 0, 0))); // NOI18N
        jPanel11.setLayout(new java.awt.GridLayout(5, 3, 2, 2));

        jl10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl10.setText("As Esquinas [cm²] = 5.7");
        jPanel11.add(jl10);

        combo11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#6 = 2.85 cm² ", "1#8 = 5.07 cm²", "2#6 = 5.70 cm²", "1#10 = 7.92 cm²", "2#8 = 10.13 cm²", "1#10 + 1#6 =  10.77 cm²", "1#12 = 11.40 cm²", "1#10 + 1#8 =  12.98 cm²", "3#8 = 15.20 cm²", "2#10 = 15.83 cm²", "1#10 + 2#8 = 18.05 cm²", "2#12 = 22.80 cm²", "3#10 = 23.75 cm²", "1#12 + 2#10 = 27.24 cm²", "3#12 = 34.20 cm²" }));
        combo11.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo11FocusLost(evt);
            }
        });
        combo11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo11KeyPressed(evt);
            }
        });
        jPanel11.add(combo11);
        jPanel11.add(jLabel188);

        jl11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl11.setText("As cara b [cm²] = 0.0");
        jPanel11.add(jl11);

        combo12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 paq", "1 paq", "2 paq", "3 paq", "4 paq", "5 paq" }));
        combo12.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo12FocusLost(evt);
            }
        });
        combo12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo12KeyPressed(evt);
            }
        });
        jPanel11.add(combo12);

        combo14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#6 = 2.85 cm² ", "1#8 = 5.07 cm²", "2#6 = 5.70 cm²", "1#10 = 7.92 cm²", "2#8 = 10.13 cm²", "1#10 + 1#6 =  10.77 cm²", "1#12 = 11.40 cm²", "1#10 + 1#8 =  12.98 cm²", "3#8 = 15.20 cm²", "2#10 = 15.83 cm²", "1#10 + 2#8 = 18.05 cm²", "2#12 = 22.80 cm²", "3#10 = 23.75 cm²", "1#12 + 2#10 = 27.24 cm²", "3#12 = 34.20 cm²" }));
        combo14.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo14FocusLost(evt);
            }
        });
        combo14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo14KeyPressed(evt);
            }
        });
        jPanel11.add(combo14);

        jl12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl12.setText("Asp [cm²] = ");
        jPanel11.add(jl12);

        jt26.setEditable(false);
        jPanel11.add(jt26);

        combo15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#3 = 1.42 cm²", "1#4 = 2.54 cm²" }));
        combo15.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo15FocusLost(evt);
            }
        });
        combo15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo15KeyPressed(evt);
            }
        });
        jPanel11.add(combo15);

        jl13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jl13.setText("estribos");
        jPanel11.add(jl13);

        combo13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1#3 = 1.42 cm²", "1#4 = 2.54 cm²", "2#3 = 2.84 cm²", "1#5 = 3.96 cm²", "2#4 = 5.08 cm²", "1#6 = 5.70 cm²", "2#5 = 7.92 cm²" }));
        combo13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo13KeyPressed(evt);
            }
        });
        jPanel11.add(combo13);

        combo16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "@ 5 cm", "@ 6 cm", "@ 7.5 cm", "@ 9 cm", "@ 10 cm", "@ 12.5 cm", "@ 15 cm", "@ 17.5 cm", "@ 20 cm", "@ 22.5 cm", "@ 25 cm", "@ 27.5 cm", "@ 30 cm", "@ 32.5 cm", "@ 35 cm" }));
        combo16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo16KeyPressed(evt);
            }
        });
        jPanel11.add(combo16);

        jt25.setEditable(false);
        jPanel11.add(jt25);

        combo17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combo17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                combo17KeyPressed(evt);
            }
        });
        jPanel11.add(combo17);

        jPanel10.add(jPanel11);

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Revisión de resistencia", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(153, 0, 0))); // NOI18N
        jPanel14.setLayout(new java.awt.GridLayout(5, 3, 2, 2));

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("< Mu [tf-m]");
        jPanel14.add(jLabel35);

        jt23.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt23FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt23FocusLost(evt);
            }
        });
        jt23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt23KeyPressed(evt);
            }
        });
        jPanel14.add(jt23);

        jLabel47.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel47.setText("ϕ Mr [tf-m]");
        jPanel14.add(jLabel47);

        jt24.setEditable(false);
        jt24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt24KeyPressed(evt);
            }
        });
        jPanel14.add(jt24);

        jLabel61.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel61.setText("< Vu [tf] =");
        jPanel14.add(jLabel61);

        jt10.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jt10FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jt10FocusLost(evt);
            }
        });
        jt10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt10KeyPressed(evt);
            }
        });
        jPanel14.add(jt10);

        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("1.1√f'c*Acw [tf] 18.7.5** =");
        jPanel14.add(jLabel58);

        jt11.setEditable(false);
        jPanel14.add(jt11);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ϕVn Máx [tf] =");
        jPanel14.add(jLabel4);

        jt12.setEditable(false);
        jPanel14.add(jt12);

        jPanel10.add(jPanel14);

        jPanel3.add(jPanel10);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setText("Nombre de Viga VA:");
        jPanel4.add(jLabel1);

        apellido_viga.setMinimumSize(new java.awt.Dimension(60, 20));
        apellido_viga.setPreferredSize(new java.awt.Dimension(250, 30));
        apellido_viga.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                apellido_vigaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                apellido_vigaFocusLost(evt);
            }
        });
        apellido_viga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                apellido_vigaKeyPressed(evt);
            }
        });
        jPanel4.add(apellido_viga);

        guardar_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/Database-Recovery-icon (1).png"))); // NOI18N
        guardar_2.setText("Almacenar");
        guardar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_2ActionPerformed(evt);
            }
        });
        guardar_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guardar_2KeyPressed(evt);
            }
        });
        jPanel4.add(guardar_2);

        cancelar_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/Cancel-icon.png"))); // NOI18N
        cancelar_2.setText("Cancelar");
        cancelar_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_2ActionPerformed(evt);
            }
        });
        cancelar_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelar_2KeyPressed(evt);
            }
        });
        jPanel4.add(cancelar_2);

        jPanel3.add(jPanel4);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1);

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos guardados", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel16.setLayout(new javax.swing.BoxLayout(jPanel16, javax.swing.BoxLayout.X_AXIS));

        jPanel18.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        jComboBox3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBox3KeyPressed(evt);
            }
        });
        jPanel18.add(jComboBox3);

        jPanel16.add(jPanel18);

        jPanel19.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        guardar_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/Database-Accept-icon (1).png"))); // NOI18N
        guardar_3.setText("Guardar");
        guardar_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardar_3ActionPerformed(evt);
            }
        });
        guardar_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                guardar_3KeyPressed(evt);
            }
        });
        jPanel19.add(guardar_3);

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/Editing-Pencil-icon.png"))); // NOI18N
        editar.setText("Editar");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
            }
        });
        editar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                editarKeyPressed(evt);
            }
        });
        jPanel19.add(editar);

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/icons8-Delete_24.png"))); // NOI18N
        eliminar.setText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });
        eliminar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                eliminarKeyPressed(evt);
            }
        });
        jPanel19.add(eliminar);

        cancelar_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fotos/Actions-file-close-icon.png"))); // NOI18N
        cancelar_3.setText("Cerrar");
        cancelar_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar_3ActionPerformed(evt);
            }
        });
        cancelar_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cancelar_3KeyPressed(evt);
            }
        });
        jPanel19.add(cancelar_3);

        jPanel16.add(jPanel19);

        jPanel1.add(jPanel16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_2ActionPerformed
        // TODO add your handling code here:
        jPanel2.setVisible(false);
        banderin = false;
        banderin_edit = false;
        limpieza();
        jComboBox2.requestFocus();
    }//GEN-LAST:event_cancelar_2ActionPerformed

    private void guardar_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_2ActionPerformed
        // TODO add your handling code here:
        //jPanel2.setVisible(false);
        //Nombrar_pryecto.lv1.setVisible(false);
        //String arr1[] = {jt3.getText(), jt2.getText(), jt1.getText(), jt7.getText(), jt10.getText(), jt23.getText()};        
        banderin = false;
        banderin_edit = false;
        elementos = new ArrayList<>();
        elementos.add(jt1.getText());
        elementos.add(jt2.getText());
        elementos.add(jt3.getText());
        elementos.add(jt4.getText());
        elementos.add(jt5.getText());
        elementos.add(jt6.getText());
        elementos.add(jt7.getText());
        elementos.add(jt8.getText());
        elementos.add(jt9.getText());
        elementos.add(jt10.getText());
        elementos.add(jt11.getText());
        elementos.add(jt12.getText());
        elementos.add(jt13.getText());
        elementos.add(jt14.getText());
        elementos.add(jt15.getText());
        elementos.add(jt16.getText());
        elementos.add(jt17.getText());
//        elementos.add(jt18.getText());
        elementos.add(jt21.getText().substring(30));
        elementos.add(jt23.getText());
        elementos.add(jt24.getText());
        elementos.add(jt26.getText());
        if (ch.Dobles(elementos) == 1 || apellido_viga.getText() == null || apellido_viga.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en las celdas");
        } else {
            String arr1[] = {jt1.getText(), jt2.getText(), jt3.getText(), jt4.getText(), jt5.getText(), jt6.getText(), jt7.getText(), jt8.getText(), jt9.getText(), jt10.getText(),
                jt11.getText(),
                jt12.getText(), jt13.getText(), jt14.getText(), jt15.getText(), jt16.getText(), jt17.getText(), jt21.getText(), jt23.getText(), jt24.getText(), jt26.getText(),
                String.valueOf(combo1.getSelectedIndex()), String.valueOf(combo2.getSelectedIndex()),
                String.valueOf(combo3.getSelectedIndex()), String.valueOf(combo4.getSelectedIndex()), String.valueOf(combo5.getSelectedIndex()), String.valueOf(combo6.getSelectedIndex()),
                String.valueOf(combo7.getSelectedIndex()), String.valueOf(combo8.getSelectedIndex()), String.valueOf(combo9.getSelectedIndex()), String.valueOf(combo10.getSelectedIndex()),
                String.valueOf(combo11.getSelectedIndex()), String.valueOf(combo12.getSelectedIndex()), String.valueOf(combo13.getSelectedIndex()), String.valueOf(combo14.getSelectedIndex()),
                String.valueOf(combo15.getSelectedIndex()), String.valueOf(combo16.getSelectedIndex()), String.valueOf(combo17.getSelectedIndex()), String.valueOf(combo19.getSelectedIndex()),
                String.valueOf(combo20.getSelectedIndex()),
                jl1.getText(), jl2.getText(), jl3.getText(), jl4.getText(), jl5.getText(), jl6.getText(), jl7.getText(), jl8.getText(), jl9.getText(), jl10.getText(), jl11.getText(), jl12.getText(), apellido_viga.getText(), String.valueOf(db_equivalente_combo1), String.valueOf(db_equivalente_combo11)/*54*/, String.valueOf(estado_paneles_diag)/*55*/};
            //String arr2[]={"atb1", "atb2"};

            Vigas vi1;
            //Vigas vi2=new Vigas(arr2, "viga2");        
//            if (flag == true) {
//                vi1 = new Vigas(arr1, jComboBox2.getItemAt(numero_viiga).toString());
//                py.guardarViga(vi1);
//                jComboBox3.addItem(jComboBox2.getItemAt(numero_viiga));
//            } else {
//                vi1 = new Vigas(arr1, nombre_edit);
//                py.guardarViga(vi1);
//                jComboBox3.addItem(nombre_edit);
//            }
            vi1 = new Vigas(arr1, apellido_viga.getText());
            py.guardarViga(vi1);
            jComboBox3.addItem(apellido_viga.getText());
            vi1 = null;
//            if (!String.valueOf(contador_viga).equals(apellido_viga.getText())) {
//                contador_viga++;
//                flag_contador = false;
//            } else {
//                 flag_contador = true;
//            }
        }
    }//GEN-LAST:event_guardar_2ActionPerformed

    private void aceptar_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptar_1ActionPerformed
        if (banderin == false) {
            limpieza();
            jPanel2.setVisible(true);
            int valor = jComboBox2.getSelectedIndex();
            Vigas rec = editable.getLista().get(jComboBox2.getSelectedIndex());
            for (int j = 0; j < rec.getPropiedades().length; j++) {
                switch (j) {
                    case 0:
                        jt1.setText(rec.getPropiedades()[j]);
                        break;
                    case 1:
                        jt2.setText(rec.getPropiedades()[j]);
                        break;
                    case 2:
                        jt3.setText(rec.getPropiedades()[j]);
                        break;
                    case 3:
                        jt4.setText(rec.getPropiedades()[j]);
                        break;
                    case 4:
                        jt5.setText(rec.getPropiedades()[j]);
                        break;
                    case 5:
                        jt6.setText(rec.getPropiedades()[j]);
                        break;
                    case 6:
                        jt7.setText(rec.getPropiedades()[j]);
                        break;
                    case 7:
                        jt8.setText(rec.getPropiedades()[j]);
                        break;
                    case 8:
                        jt9.setText(rec.getPropiedades()[j]);
                        break;
                    case 9:
                        jt10.setText(rec.getPropiedades()[j]);
                        break;
                    case 10:
                        jt11.setText(rec.getPropiedades()[j]);
                        break;
                    case 11:
                        jt12.setText(rec.getPropiedades()[j]);
                        break;
                    case 12:
                        jt13.setText(rec.getPropiedades()[j]);
                        break;
                    case 13:
                        jt14.setText(rec.getPropiedades()[j]);
                        break;
                    case 14:
                        jt15.setText(rec.getPropiedades()[j]);
                        break;
                    case 15:
                        jt16.setText(rec.getPropiedades()[j]);
                        break;
                    case 16:
                        jt17.setText(rec.getPropiedades()[j]);
                        break;
                    case 17:
                        jt21.setText(rec.getPropiedades()[j]);
                        break;
                    case 18:
                        jt23.setText(rec.getPropiedades()[j]);
                        break;
                    case 19:
                        jt24.setText(rec.getPropiedades()[j]);
                        break;
                    case 20:
                        jt26.setText(rec.getPropiedades()[j]);
                        break;
                    case 21:
                        combo1.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 22:
                        combo2.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 23:
                        combo3.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 24:
                        combo4.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 25:
                        combo5.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 26:
                        combo6.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 27:
                        combo7.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 28:
                        combo8.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 29:
                        combo9.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 30:
                        combo10.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 31:
                        combo11.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 32:
                        combo12.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 33:
                        combo13.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 34:
                        combo14.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 35:
                        combo15.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 36:
                        combo16.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 37:
                        combo17.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 38:
                        combo19.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 39:
                        combo20.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));//System.out.println("valor de prueba"+rec.getPropiedades()[j]);
                        break;
                    case 40:
                        jl1.setText(rec.getPropiedades()[j]);
                        break;
                    case 41:
                        jl2.setText(rec.getPropiedades()[j]);
                        break;
                    case 42:
                        jl3.setText(rec.getPropiedades()[j]);
                        break;
                    case 43:
                        jl4.setText(rec.getPropiedades()[j]);
                        break;
                    case 44:
                        jl5.setText(rec.getPropiedades()[j]);
                        break;
                    case 45:
                        jl6.setText(rec.getPropiedades()[j]);
                        break;
                    case 46:
                        jl7.setText(rec.getPropiedades()[j]);
                        break;
                    case 47:
                        jl8.setText(rec.getPropiedades()[j]);
                        break;
                    case 48:
                        jl9.setText(rec.getPropiedades()[j]);
                        break;
                    case 49:
                        jl10.setText(rec.getPropiedades()[j]);
                        break;
                    case 50:
                        jl11.setText(rec.getPropiedades()[j]);
                        break;
                    case 51:
                        jl12.setText(rec.getPropiedades()[j]);
                        break;
                    case 52:
                        apellido_viga.setText(rec.getPropiedades()[j]);
                }
            }
            /**
             * ****Este metodo no debe eliminar porque la viga editada debe
             * guardarse en la misma posicion en la que estaba antes de
             * modificarse*********
             */
            jPanel2.setVisible(true);
            //para desabilitar los paneles de diagonales en caso de que la viga que se va a editar sea sin diagonales
            if (Boolean.parseBoolean(rec.getPropiedades()[55]) == false) {
                estado_paneles_diag = false;
                especial.setSelected(true);
//                if (Double.parseDouble(rec.getPropiedades()[4]) < 2) {
//                    jt5.setBackground(Color.CYAN);
//                }
                setBounds(0, 0, 950, 750);
                jPanel5.setVisible(estado_paneles_diag);
                //jPanel10.setVisible(estado_paneles_diag);
                jPanel17.setVisible(estado_paneles_diag);
            } else {
                estado_paneles_diag = true;
                ordinaria.setSelected(true);
//                if (Double.parseDouble(rec.getPropiedades()[4]) >= 2) {
//                    jt5.setBackground(Color.WHITE);
//                }
                setBounds(0, 0, 1300, 930);
                jPanel5.setVisible(estado_paneles_diag);
                //jPanel10.setVisible(estado_paneles_diag);
                jPanel17.setVisible(estado_paneles_diag);
            }
            gama_colores_jt5();

            rec = null;
            jt7.requestFocus();
            //jt7.selectAll();
        } else {
            JOptionPane.showMessageDialog(null, "No ha guardado la viga de acople en la que está trabajando");
        }
    }//GEN-LAST:event_aceptar_1ActionPerformed

    private void guardar_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardar_3ActionPerformed
        // TODO add your handling code here:
        //setVisible(false);
        if (jComboBox3.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Tiene que tener al menos un elemento procesado para poder guardar el proyecto");
        } else {
            Trazado trazado = new Trazado();
//            try {
//                trazado.fichero_dibujo(py);
//            } catch (IOException ex) {
//                Logger.getLogger(Ventana_calculo.class.getName()).log(Level.SEVERE, null, ex);
//            }
            System.out.println(py.getLista().size());
            System.out.println("");
            for (int i = 0; i < py.getLista().size(); i++) {
                System.out.println(py.getLista().get(i).getNombre_viga());
                for (int j = 0; j < py.getLista().get(0).getPropiedades().length; j++) {
                    System.out.println(py.getLista().get(i).getPropiedades()[j]);
                    //System.out.println(py.getLista().get(i).getNombre_viga()+"  "+py.getLista().get(i).getPropiedades()[0]+"  "+py.getLista().get(i).getPropiedades()[1]);
                }
            }
            JFileChooser jf = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Solo archivos con extension .scr", "scr");
            jf.setFileFilter(filtro);
            String ruta = "";
            try {
                int returnval = jf.showSaveDialog(null);
                if (returnval == jf.APPROVE_OPTION) {
                    ObjectOutputStream out = null;
                    //ObjectOutputStream out1=null;
                    ruta = jf.getSelectedFile().getAbsolutePath();
                    //se crea el fichero .va para una futura recuperacion de datos
                    Py_Serializable ps = new Py_Serializable(py, ruta, nombre);
                    ps.serializar_py();
                    ps.recuperacion_py();
                    //System.out.println(jf.getSelectedFile().getAbsolutePath());
                    if (jf.getSelectedFile().getAbsolutePath().substring(jf.getSelectedFile().getAbsolutePath().length() - 4, jf.getSelectedFile().getAbsolutePath().length()).equals(".scr")) {
                        int marca = jf.getSelectedFile().getAbsolutePath().lastIndexOf("\\");
                        jf.getSelectedFile().getAbsolutePath().substring(marca + 1); //para quedarme solo con el nombre del archivo
                        File fo = new File(jf.getSelectedFile().getAbsolutePath().substring(marca + 1));//se elimina el fichero para evitar corromper el archivo
                        //File fe=new File(jf.getSelectedFile().getAbsolutePath().substring(marca+1,jf.getSelectedFile().getAbsolutePath().length()-4)+".va");//se elimina el fichero para evitar corromper el archivo
                        //System.out.println(jf.getSelectedFile().getAbsolutePath().substring(marca+1,jf.getSelectedFile().getAbsolutePath().length()-4)+".va");
                        fo.delete();
                        //fe.delete();
                        //FileOutputStream f=new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca+1));
                        //out = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca+1)));
                        out = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca + 1)));
                        trazado.fichero_dibujo(py, jf.getSelectedFile().getAbsolutePath().substring(0, jf.getSelectedFile().getAbsolutePath().length() - 4));
                        out.close();
                        //out1 = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca+1,jf.getSelectedFile().getAbsolutePath().length()-4)+".va"));
                    } else {
                        //out1 = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath() + "(" + nombre + ")" + ".va"));
                        trazado.fichero_dibujo(py, jf.getSelectedFile().getAbsolutePath() + "(" + nombre + ")");
                    }
                    //System.out.println(jf.getSelectedFile().getAbsoluteFile());
                    //ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta + ".va"));
                    //out1.reset();
                    //out1.writeObject(py);***********************************************guardar estado de los objetos
                    //out.close();
                    //out1.close();
                    //this.dispose();
                    //py = null;
                    contador_viga = 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_guardar_3ActionPerformed

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        //jPanel2.setVisible(true);        
        System.out.println(jComboBox3.getItemCount());
        if (jComboBox3.getItemCount() != 0) {
            if (banderin_edit == false && banderin == false) {
                limpieza();
                flag = false;
                nombre_edit = jComboBox3.getItemAt(jComboBox3.getSelectedIndex());
                posicion = jComboBox3.getSelectedIndex();
                Vigas rec;
                rec = py.getLista().get(posicion);
                System.out.println("");
                System.out.println(rec.getNombre_viga());
                System.out.println("cantidad de elementos de la viga " + rec.getPropiedades().length);
                for (int i = 0; i < rec.getPropiedades().length; i++) {
                    System.out.println("posicion " + i + " tiene " + rec.getPropiedades()[i]);
                }

                for (int j = 0; j < rec.getPropiedades().length; j++) {
                    switch (j) {
                        case 0:
                            jt1.setText(rec.getPropiedades()[j]);
                            break;
                        case 1:
                            jt2.setText(rec.getPropiedades()[j]);
                            break;
                        case 2:
                            jt3.setText(rec.getPropiedades()[j]);
                            break;
                        case 3:
                            jt4.setText(rec.getPropiedades()[j]);
                            break;
                        case 4:
                            jt5.setText(rec.getPropiedades()[j]);
                            break;
                        case 5:
                            jt6.setText(rec.getPropiedades()[j]);
                            break;
                        case 6:
                            jt7.setText(rec.getPropiedades()[j]);
                            break;
                        case 7:
                            jt8.setText(rec.getPropiedades()[j]);
                            break;
                        case 8:
                            jt9.setText(rec.getPropiedades()[j]);
                            break;
                        case 9:
                            jt10.setText(rec.getPropiedades()[j]);
                            break;
                        case 10:
                            jt11.setText(rec.getPropiedades()[j]);
                            break;
                        case 11:
                            jt12.setText(rec.getPropiedades()[j]);
                            break;
                        case 12:
                            jt13.setText(rec.getPropiedades()[j]);
                            break;
                        case 13:
                            jt14.setText(rec.getPropiedades()[j]);
                            break;
                        case 14:
                            jt15.setText(rec.getPropiedades()[j]);
                            break;
                        case 15:
                            jt16.setText(rec.getPropiedades()[j]);
                            break;
                        case 16:
                            jt17.setText(rec.getPropiedades()[j]);
                            break;
                        case 17:
                            jt21.setText(rec.getPropiedades()[j]);
                            break;
                        case 18:
                            jt23.setText(rec.getPropiedades()[j]);
                            break;
                        case 19:
                            jt24.setText(rec.getPropiedades()[j]);
                            break;
                        case 20:
                            jt26.setText(rec.getPropiedades()[j]);
                            break;
                        case 21:
                            combo1.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 22:
                            combo2.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 23:
                            combo3.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 24:
                            combo4.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 25:
                            combo5.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 26:
                            combo6.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 27:
                            combo7.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 28:
                            combo8.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 29:
                            combo9.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 30:
                            combo10.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 31:
                            combo11.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 32:
                            combo12.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 33:
                            combo13.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 34:
                            combo14.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 35:
                            combo15.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 36:
                            combo16.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 37:
                            combo17.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 38:
                            combo19.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 39:
                            combo20.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));//System.out.println("valor de prueba"+rec.getPropiedades()[j]);
                            break;
                        case 40:
                            jl1.setText(rec.getPropiedades()[j]);
                            break;
                        case 41:
                            jl2.setText(rec.getPropiedades()[j]);
                            break;
                        case 42:
                            jl3.setText(rec.getPropiedades()[j]);
                            break;
                        case 43:
                            jl4.setText(rec.getPropiedades()[j]);
                            break;
                        case 44:
                            jl5.setText(rec.getPropiedades()[j]);
                            break;
                        case 45:
                            jl6.setText(rec.getPropiedades()[j]);
                            break;
                        case 46:
                            jl7.setText(rec.getPropiedades()[j]);
                            break;
                        case 47:
                            jl8.setText(rec.getPropiedades()[j]);
                            break;
                        case 48:
                            jl9.setText(rec.getPropiedades()[j]);
                            break;
                        case 49:
                            jl10.setText(rec.getPropiedades()[j]);
                            break;
                        case 50:
                            jl11.setText(rec.getPropiedades()[j]);
                            break;
                        case 51:
                            jl12.setText(rec.getPropiedades()[j]);
                            break;
                        case 52:
                            apellido_viga.setText(rec.getPropiedades()[j]);
                    }
                }
                /**
                 * ****Este metodo no debe eliminar porque la viga editada debe
                 * guardarse en la misma posicion en la que estaba antes de
                 * modificarse*********
                 */
                jPanel2.setVisible(true);
                //para desabilitar los paneles de diagonales en caso de que la viga que se va a editar sea sin diagonales
                if (Boolean.parseBoolean(rec.getPropiedades()[55]) == false) {
                    estado_paneles_diag = false;
                    especial.setSelected(true);
//                    if (Double.parseDouble(rec.getPropiedades()[4]) < 2) {
//                        jt5.setBackground(Color.CYAN);
//                    }
                    setBounds(0, 0, 950, 750);
                    jPanel5.setVisible(estado_paneles_diag);
                    //jPanel10.setVisible(estado_paneles_diag);
                    jPanel17.setVisible(estado_paneles_diag);
                } else {
                    estado_paneles_diag = true;
                    ordinaria.setSelected(true);
//                    if (Double.parseDouble(rec.getPropiedades()[4]) >= 2) {
//                        jt5.setBackground(Color.WHITE);
//                    }
                    setBounds(0, 0, 1300, 930);
                    jPanel5.setVisible(estado_paneles_diag);
                    //jPanel10.setVisible(estado_paneles_diag);
                    jPanel17.setVisible(estado_paneles_diag);
                }
                gama_colores_jt5();
                py.eliminarViga(posicion);
                jComboBox3.removeItemAt(posicion);
                System.out.println("lista long");
                System.out.println(py.getLista().size());
                rec = null;
                jt1.requestFocus();
                banderin_edit = true;
                banderin = true;
            } else {
                JOptionPane.showMessageDialog(null, "No ha guardado la viga de acople en la que está trabajando");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene vigas disponibles para editar");
        }

    }//GEN-LAST:event_editarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
        //repaint();
        try {
            if (jComboBox3.getItemCount() != 0) {
                py.eliminarViga(jComboBox3.getSelectedIndex());
                System.out.println(jComboBox3.getSelectedIndex());
                jComboBox3.removeItemAt(jComboBox3.getSelectedIndex());
            } else {
                //contador_viga = 1;
                JOptionPane.showMessageDialog(null, "No tiene vigas disponibles para eliminar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Verifique, puede que este elemento ya haya sido eliminado");
        }

    }//GEN-LAST:event_eliminarActionPerformed

    private void cancelar_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar_3ActionPerformed
        // TODO add your handling code here:
        if (jComboBox3.getItemCount() != 0) {
            int estado = JOptionPane.showConfirmDialog(null, "Está seguro que quiere cancelar?\nSi cancela perderá todo el progreso alcanzado.");
            switch (estado) {
                case JOptionPane.YES_OPTION:
                    py = null;
                    this.dispose();
                    NewMDIApplication.nuevo.setEnabled(true);
                    //NewMDIApplication.abrir.setEnabled(true);
                    contador_viga = 1;
                    break;
            }
        } else {
            py = null;
            this.dispose();
            NewMDIApplication.nuevo.setEnabled(true);
            //NewMDIApplication.abrir.setEnabled(true);
            contador_viga = 1;
        }
    }//GEN-LAST:event_cancelar_3ActionPerformed

    private void combo1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo1KeyPressed
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            elementos.add(jt8.getText());
            if (ch.Dobles(elementos) == 1) {
                JOptionPane.showMessageDialog(null, "Está introduciendo valor incorrecto en la celda fyl [kgf/cm²] =");
            } else {
                combo2.requestFocus();
            }
        }
    }//GEN-LAST:event_combo1KeyPressed

    private void combo1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo1FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt8.getText());
        if (ch.Dobles(elementos) != 1) {
            switch (combo1.getSelectedIndex()) {
                case 0:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 2.85, 2));
                    db_equivalente_combo1 = 1.91;
                    break;
                case 1:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 5.07, 2));
                    db_equivalente_combo1 = 2.54;
                    break;
                case 2:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 5.70, 2));
                    db_equivalente_combo1 = 2.69;
                    break;
                case 3:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 7.92, 2));
                    db_equivalente_combo1 = 3.18;
                    break;
                case 4:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 10.13, 2));
                    db_equivalente_combo1 = 3.59;
                    break;
                case 5:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 10.77, 2));
                    db_equivalente_combo1 = 3.70;
                    break;
                case 6:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 11.40, 2));
                    db_equivalente_combo1 = 3.81;
                    break;
                case 7:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 12.98, 2));
                    db_equivalente_combo1 = 4.07;
                    break;
                case 8:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 15.20, 2));
                    db_equivalente_combo1 = 4.40;
                    break;
                case 9:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 15.83, 2));
                    db_equivalente_combo1 = 4.49;
                    break;
                case 10:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 18.05, 2));
                    db_equivalente_combo1 = 4.79;
                    break;
                case 11:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 22.80, 2));
                    db_equivalente_combo1 = 5.39;
                    break;
                case 12:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 23.75, 2));
                    db_equivalente_combo1 = 5.50;
                    break;
                case 13:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 27.24, 2));
                    db_equivalente_combo1 = 5.89;
                    break;
                case 14:
                    jl1.setText("As Esquinas [cm²] = " + redondeo(4 * 34.20, 2));
                    db_equivalente_combo1 = 6.60;
                    break;
            }
            //calculo de separacion de varillas en la base 
            double separacion = (Double.parseDouble(jt15.getText()) - db_equivalente_combo1) / (combo2.getSelectedIndex() + 1);
            if (separacion < Math.max(2 * db_combo2y4, db_combo2y4 + 2.5)) {
                combo2.setBackground(Color.ORANGE);
                combo2.setSelectedIndex(0);
            } else {
                combo2.setBackground(UIManager.getColor(combo1));
            }
            //calculo de separacion de varillas en las caras
            double comodin_anti_error = 0;
            double aux = redondeo(Double.parseDouble(jt2.getText()) / 4, 1);
            elementos.clear();
            elementos.add(jt16.getText());
            if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt16.getText()) > aux || Double.parseDouble(jt16.getText()) <= 0) {
                comodin_anti_error = redondeo(Double.parseDouble(jt2.getText()) / 4, 1);;
            } else {
                comodin_anti_error = Double.parseDouble(jt16.getText());
            }

            separacion = (comodin_anti_error - db_equivalente_combo1) / (combo3.getSelectedIndex() + 1);
            if (separacion < Math.max(2 * db_combo3y5, db_combo3y5 + 2.5)) {
                System.out.println("comodin_anti_error " + comodin_anti_error);
                System.out.println("2 * db_combo3y5 " + (2 * db_combo3y5));
                System.out.println("db_combo3y5 + 2.5 " + (db_combo3y5 + 2.5));
                System.out.println("separacion " + separacion);
                System.out.println("separacion < Math.max(2 * db_combo3y5, db_combo3y5 + 2.5) ");
                combo3.setBackground(Color.ORANGE);
                combo3.setSelectedIndex(0);
            } else {
                combo3.setBackground(UIManager.getColor(combo1));
            }
            actualizar_jl4();
            longitud_desarrollo();
            estado_combo9();
            calculo_mr();
        }

    }//GEN-LAST:event_combo1FocusLost

    private void combo2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo4.requestFocus();
        }
    }//GEN-LAST:event_combo2KeyPressed

    private void combo4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo4KeyPressed
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            elementos.add(jt8.getText());
            if (ch.Dobles(elementos) == 1) {
                JOptionPane.showMessageDialog(null, "Está introduciendo valor incorrecto en la celda fyl [kgf/cm²] =");
            } else {
                combo3.requestFocus();
            }
        }
    }//GEN-LAST:event_combo4KeyPressed

    private void combo4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo4FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt8.getText());
        db_combo2y4 = 1.91;
        if (ch.Dobles(elementos) != 1) {
            int valor = 0;
            switch (combo4.getSelectedIndex()) {
                case 0:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 2.85, 2));
                    db_combo2y4 = 1.91;
                    break;
                case 1:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 5.07, 2));
                    db_combo2y4 = 2.54;
                    break;
                case 2:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 5.70, 2));
                    db_combo2y4 = 2.69;
                    break;
                case 3:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 7.92, 2));
                    db_combo2y4 = 3.18;
                    break;
                case 4:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 10.13, 2));
                    db_combo2y4 = 3.59;
                    break;
                case 5:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 10.77, 2));
                    db_combo2y4 = 3.70;
                    break;
                case 6:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 11.40, 2));
                    db_combo2y4 = 3.81;
                    break;
                case 7:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 12.98, 2));
                    db_combo2y4 = 4.07;
                    break;
                case 8:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 15.20, 2));
                    db_combo2y4 = 4.40;
                    break;
                case 9:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 15.83, 2));
                    db_combo2y4 = 4.49;
                    break;
                case 10:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 18.05, 2));
                    db_combo2y4 = 4.79;
                    break;
                case 11:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 22.80, 2));
                    db_combo2y4 = 5.39;
                    break;
                case 12:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 23.75, 2));
                    db_combo2y4 = 5.50;
                    break;
                case 13:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 27.24, 2));
                    db_combo2y4 = 5.89;
                    break;
                case 14:
                    jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 34.20, 2));
                    db_combo2y4 = 6.60;
                    break;
            }
            //calculo de separacion de varillas en la base
            separacion_varillas_base(2);

            cont_pak_base = combo2.getSelectedIndex();
            if (combo19.getSelectedIndex() != 0) {
                if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 3) {
                    JOptionPane.showMessageDialog(null, "La separación entre varillas es mayor que 35cm, no es posible poner grapas");
                    combo19.setSelectedIndex(cont_pak_base);
                    combo19.setBackground(Color.ORANGE);
                } else if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 2) {
                    JOptionPane.showMessageDialog(null, "No se puede tener mayor número de grapas que de paquetes de varillas en la base");
                    combo19.setSelectedIndex(cont_pak_base);
                    combo19.setBackground(Color.ORANGE);
                } else if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 1) {
                    JOptionPane.showMessageDialog(null, "No se puede colocar " + combo19.getSelectedIndex() + " grapas en " + cont_pak_base + " paquetes de varillas a menos de 35cm con una separación de " + separacion_diag_base + "cm");
                    combo19.setSelectedIndex(cont_pak_base);
                    combo19.setBackground(Color.ORANGE);
                } else {
                    combo19.setBackground(UIManager.getColor(combo1));
                }
            }
//            if (cont_pak_base < combo19.getSelectedIndex()) {
//                JOptionPane.showMessageDialog(null, "No puedes tener mayor número de grapas que de paquetes de varillas en la base");
//                combo19.setSelectedIndex(cont_pak_base);
//                combo19.setBackground(Color.ORANGE);
//            } else {
//                combo19.setBackground(UIManager.getColor(combo1));
//            }
            actualizar_jl4();
            longitud_desarrollo();
            estado_combo9();
            calculo_mr();
        }
    }//GEN-LAST:event_combo4FocusLost

    private void combo3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo5.requestFocus();
        }
    }//GEN-LAST:event_combo3KeyPressed

    private void combo5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo5FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt8.getText());
        if (ch.Dobles(elementos) != 1) {
            db_combo3y5 = 1.91;
            switch (combo5.getSelectedIndex()) {
                case 0:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 2.85, 2));
                    db_combo3y5 = 1.91;
                    break;
                case 1:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 5.07, 2));
                    db_combo3y5 = 2.54;
                    break;
                case 2:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 5.70, 2));
                    db_combo3y5 = 2.69;
                    break;
                case 3:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 7.92, 2));
                    db_combo3y5 = 3.18;
                    break;
                case 4:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 10.13, 2));
                    db_combo3y5 = 3.59;
                    break;
                case 5:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 10.77, 2));
                    db_combo3y5 = 3.70;
                    break;
                case 6:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 11.40, 2));
                    db_combo3y5 = 3.81;
                    break;
                case 7:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 12.98, 2));
                    db_combo3y5 = 4.07;
                    break;
                case 8:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 15.20, 2));
                    db_combo3y5 = 4.40;
                    break;
                case 9:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 15.83, 2));
                    db_combo3y5 = 4.49;
                    break;
                case 10:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 18.05, 2));
                    db_combo3y5 = 4.79;
                    break;
                case 11:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 22.80, 2));
                    db_combo3y5 = 5.39;
                    break;
                case 12:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 23.75, 2));
                    db_combo3y5 = 5.50;
                    break;
                case 13:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 27.24, 2));
                    db_combo3y5 = 5.89;
                    break;
                case 14:
                    jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 34.20, 2));
                    db_combo3y5 = 6.60;
                    break;
            }
           //calculo de separacion de varillas en las caras 
            separacion_varillas_cara(2);

            cont_pak_cara = combo3.getSelectedIndex();
            if (combo20.getSelectedIndex() != 0) {
                if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 3) {
                    JOptionPane.showMessageDialog(null, "La separación entre varillas es mayor que 35cm, no es posible poner grapas");
                    combo20.setSelectedIndex(cont_pak_cara);
                    combo20.setBackground(Color.ORANGE);
                } else if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 2) {
                    JOptionPane.showMessageDialog(null, "No se puede tener mayor número de grapas que de paquetes de varillas en las caras");
                    combo20.setSelectedIndex(cont_pak_cara);
                    combo20.setBackground(Color.ORANGE);
                } else if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 1) {
                    JOptionPane.showMessageDialog(null, "No se puede colocar " + combo20.getSelectedIndex() + " grapas en " + cont_pak_cara + " paquetes de varillas a menos de 35cm con una separación de " + separacion_diag_caras + "cm");
                    combo20.setSelectedIndex(cont_pak_cara);
                    combo20.setBackground(Color.ORANGE);
                } else {
                    combo20.setBackground(UIManager.getColor(combo1));
                }
            }
//            if (cont_pak_cara < combo20.getSelectedIndex()) {
//                JOptionPane.showMessageDialog(null, "No puedes tener mayor número de grapas que de paquetes de varillas en las caras");
//                combo20.setSelectedIndex(cont_pak_cara);
//                combo20.setBackground(Color.ORANGE);
//            } else {
//                combo20.setBackground(UIManager.getColor(combo1));
//            }
            //jt21.selectAll();
            actualizar_jl4();
            longitud_desarrollo();
            estado_combo9();
            calculo_mr();
        }
    }//GEN-LAST:event_combo5FocusLost

    private void combo2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo2FocusLost
        // TODO add your handling code here:
        db_combo2y4 = 1.91;
        switch (combo4.getSelectedIndex()) {
            case 0:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 2.85, 2));
                db_combo2y4 = 1.91;
                break;
            case 1:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 5.07, 2));
                db_combo2y4 = 2.54;
                break;
            case 2:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 5.70, 2));
                db_combo2y4 = 2.69;
                break;
            case 3:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 7.92, 2));
                db_combo2y4 = 3.18;
                break;
            case 4:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 10.13, 2));
                db_combo2y4 = 3.59;
                break;
            case 5:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 10.77, 2));
                db_combo2y4 = 3.70;
                break;
            case 6:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 11.40, 2));
                db_combo2y4 = 3.81;
                break;
            case 7:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 12.98, 2));
                db_combo2y4 = 4.07;
                break;
            case 8:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 15.20, 2));
                db_combo2y4 = 4.40;
                break;
            case 9:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 15.83, 2));
                db_combo2y4 = 4.49;
                break;
            case 10:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 18.05, 2));
                db_combo2y4 = 4.79;
                break;
            case 11:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 22.80, 2));
                db_combo2y4 = 5.39;
                break;
            case 12:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 23.75, 2));
                db_combo2y4 = 5.50;
                break;
            case 13:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 27.24, 2));
                db_combo2y4 = 5.89;
                break;
            case 14:
                jl2.setText("As cara b [cm²] = " + redondeo(combo2.getSelectedIndex() * 2 * 34.20, 2));
                db_combo2y4 = 6.60;
                break;
        }
        //calculo de separacion de varillas en la base
        separacion_varillas_base(1);

        cont_pak_base = combo2.getSelectedIndex();
        if (combo19.getSelectedIndex() != 0) {
            if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 3) {
                JOptionPane.showMessageDialog(null, "La separación entre varillas es mayor que 35cm, no es posible poner grapas");
                combo19.setSelectedIndex(cont_pak_base);
                combo19.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 2) {
                JOptionPane.showMessageDialog(null, "No se puede tener mayor número de grapas que de paquetes de varillas en la base");
                combo19.setSelectedIndex(cont_pak_base);
                combo19.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 1) {
                JOptionPane.showMessageDialog(null, "No se puede colocar " + combo19.getSelectedIndex() + " grapas en " + cont_pak_base + " paquetes de varillas a menos de 35cm con una separación de " + separacion_diag_base + "cm");
                combo19.setSelectedIndex(cont_pak_base);
                combo19.setBackground(Color.ORANGE);
            } else {
                combo19.setBackground(UIManager.getColor(combo1));
            }
        }
//        if (cont_pak_base < combo19.getSelectedIndex()) {
//            JOptionPane.showMessageDialog(null, "No puedes tener mayor número de grapas que de paquetes de varillas en la base");
//            combo19.setSelectedIndex(cont_pak_base);
//            combo19.setBackground(Color.ORANGE);
//        } else {
//            combo19.setBackground(UIManager.getColor(combo1));
//        }
        actualizar_jl4();
        calculo_mr();
    }//GEN-LAST:event_combo2FocusLost

    private void combo3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo3FocusLost
        // TODO add your handling code here:        
        db_combo3y5 = 1.91;
        switch (combo5.getSelectedIndex()) {
            case 0:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 2.85, 2));
                db_combo3y5 = 1.91;
                break;
            case 1:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 5.07, 2));
                db_combo3y5 = 2.54;
                break;
            case 2:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 5.70, 2));
                db_combo3y5 = 2.69;
                break;
            case 3:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 7.92, 2));
                db_combo3y5 = 3.18;
                break;
            case 4:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 10.13, 2));
                db_combo3y5 = 3.59;
                break;
            case 5:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 10.77, 2));
                db_combo3y5 = 3.70;
                break;
            case 6:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 11.40, 2));
                db_combo3y5 = 3.81;
                break;
            case 7:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 12.98, 2));
                db_combo3y5 = 4.07;
                break;
            case 8:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 15.20, 2));
                db_combo3y5 = 4.40;
                break;
            case 9:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 15.83, 2));
                db_combo3y5 = 4.49;
                break;
            case 10:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 18.05, 2));
                db_combo3y5 = 4.79;
                break;
            case 11:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 22.80, 2));
                db_combo3y5 = 5.39;
                break;
            case 12:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 23.75, 2));
                db_combo3y5 = 5.50;
                break;
            case 13:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 27.24, 2));
                db_combo3y5 = 5.89;
                break;
            case 14:
                jl3.setText("As cara d [cm²] = " + redondeo(combo3.getSelectedIndex() * 2 * 34.20, 2));
                db_combo3y5 = 6.60;
                break;
        }
        //calculo de separacion de varillas en las caras 
        separacion_varillas_cara(1);

        cont_pak_cara = combo3.getSelectedIndex();
        if (combo20.getSelectedIndex() != 0) {
            if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 3) {
                JOptionPane.showMessageDialog(null, "La separación entre varillas es mayor que 35cm, no es posible poner grapas");
                combo20.setSelectedIndex(cont_pak_cara);
                combo20.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 2) {
                JOptionPane.showMessageDialog(null, "No se puede tener mayor número de grapas que de paquetes de varillas en las caras");
                combo20.setSelectedIndex(cont_pak_cara);
                combo20.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 1) {
                JOptionPane.showMessageDialog(null, "No se puede colocar " + combo20.getSelectedIndex() + " grapas en " + cont_pak_cara + " paquetes de varillas a menos de 35cm con una separación de " + separacion_diag_caras + "cm");
                combo20.setSelectedIndex(cont_pak_cara);
                combo20.setBackground(Color.ORANGE);
            } else {
                combo20.setBackground(UIManager.getColor(combo1));
            }
        }

//        if (cont_pak_cara < combo20.getSelectedIndex()) {
//            JOptionPane.showMessageDialog(null, "No puedes tener mayor número de grapas que de paquetes de varillas en las caras");
//            combo20.setSelectedIndex(cont_pak_cara);
//            combo20.setBackground(Color.ORANGE);
//        } else {
//            combo20.setBackground(UIManager.getColor(combo1));
//        }
        actualizar_jl4();
        calculo_mr();
    }//GEN-LAST:event_combo3FocusLost

    private void combo5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo5KeyPressed
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            elementos.add(jt8.getText());
            if (ch.Dobles(elementos) == 1) {
                JOptionPane.showMessageDialog(null, "Está introduciendo valor incorrecto en la celda fyl [kgf/cm²] =");
            } else {
                jt21.requestFocus();
            }
        }
    }//GEN-LAST:event_combo5KeyPressed

    private void jComboBox2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            aceptar_1.requestFocus();
        }
    }//GEN-LAST:event_jComboBox2KeyPressed

    private void aceptar_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_aceptar_1KeyPressed
        if (banderin == false) {
            limpieza();
            jPanel2.setVisible(true);
            int valor = jComboBox2.getSelectedIndex();
            Vigas rec = editable.getLista().get(jComboBox2.getSelectedIndex());
            for (int j = 0; j < rec.getPropiedades().length; j++) {
                switch (j) {
                    case 0:
                        jt1.setText(rec.getPropiedades()[j]);
                        break;
                    case 1:
                        jt2.setText(rec.getPropiedades()[j]);
                        break;
                    case 2:
                        jt3.setText(rec.getPropiedades()[j]);
                        break;
                    case 3:
                        jt4.setText(rec.getPropiedades()[j]);
                        break;
                    case 4:
                        jt5.setText(rec.getPropiedades()[j]);
                        break;
                    case 5:
                        jt6.setText(rec.getPropiedades()[j]);
                        break;
                    case 6:
                        jt7.setText(rec.getPropiedades()[j]);
                        break;
                    case 7:
                        jt8.setText(rec.getPropiedades()[j]);
                        break;
                    case 8:
                        jt9.setText(rec.getPropiedades()[j]);
                        break;
                    case 9:
                        jt10.setText(rec.getPropiedades()[j]);
                        break;
                    case 10:
                        jt11.setText(rec.getPropiedades()[j]);
                        break;
                    case 11:
                        jt12.setText(rec.getPropiedades()[j]);
                        break;
                    case 12:
                        jt13.setText(rec.getPropiedades()[j]);
                        break;
                    case 13:
                        jt14.setText(rec.getPropiedades()[j]);
                        break;
                    case 14:
                        jt15.setText(rec.getPropiedades()[j]);
                        break;
                    case 15:
                        jt16.setText(rec.getPropiedades()[j]);
                        break;
                    case 16:
                        jt17.setText(rec.getPropiedades()[j]);
                        break;
                    case 17:
                        jt21.setText(rec.getPropiedades()[j]);
                        break;
                    case 18:
                        jt23.setText(rec.getPropiedades()[j]);
                        break;
                    case 19:
                        jt24.setText(rec.getPropiedades()[j]);
                        break;
                    case 20:
                        jt26.setText(rec.getPropiedades()[j]);
                        break;
                    case 21:
                        combo1.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 22:
                        combo2.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 23:
                        combo3.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 24:
                        combo4.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 25:
                        combo5.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 26:
                        combo6.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 27:
                        combo7.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 28:
                        combo8.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 29:
                        combo9.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 30:
                        combo10.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 31:
                        combo11.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 32:
                        combo12.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 33:
                        combo13.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 34:
                        combo14.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 35:
                        combo15.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 36:
                        combo16.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 37:
                        combo17.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 38:
                        combo19.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                        break;
                    case 39:
                        combo20.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));//System.out.println("valor de prueba"+rec.getPropiedades()[j]);
                        break;
                    case 40:
                        jl1.setText(rec.getPropiedades()[j]);
                        break;
                    case 41:
                        jl2.setText(rec.getPropiedades()[j]);
                        break;
                    case 42:
                        jl3.setText(rec.getPropiedades()[j]);
                        break;
                    case 43:
                        jl4.setText(rec.getPropiedades()[j]);
                        break;
                    case 44:
                        jl5.setText(rec.getPropiedades()[j]);
                        break;
                    case 45:
                        jl6.setText(rec.getPropiedades()[j]);
                        break;
                    case 46:
                        jl7.setText(rec.getPropiedades()[j]);
                        break;
                    case 47:
                        jl8.setText(rec.getPropiedades()[j]);
                        break;
                    case 48:
                        jl9.setText(rec.getPropiedades()[j]);
                        break;
                    case 49:
                        jl10.setText(rec.getPropiedades()[j]);
                        break;
                    case 50:
                        jl11.setText(rec.getPropiedades()[j]);
                        break;
                    case 51:
                        jl12.setText(rec.getPropiedades()[j]);
                        break;
                    case 52:
                        apellido_viga.setText(rec.getPropiedades()[j]);
                }
            }
            /**
             * ****Este metodo no debe eliminar porque la viga editada debe
             * guardarse en la misma posicion en la que estaba antes de
             * modificarse*********
             */
            jPanel2.setVisible(true);
            //para desabilitar los paneles de diagonales en caso de que la viga que se va a editar sea sin diagonales
            if (Boolean.parseBoolean(rec.getPropiedades()[55]) == false) {
                estado_paneles_diag = false;
                especial.setSelected(true);
//                if (Double.parseDouble(rec.getPropiedades()[4]) < 2) {
//                    jt5.setBackground(Color.CYAN);
//                }
                setBounds(0, 0, 950, 750);
                jPanel5.setVisible(estado_paneles_diag);
                //jPanel10.setVisible(estado_paneles_diag);
                jPanel17.setVisible(estado_paneles_diag);
            } else {
                estado_paneles_diag = true;
                ordinaria.setSelected(true);
//                if (Double.parseDouble(rec.getPropiedades()[4]) >= 2) {
//                    jt5.setBackground(Color.WHITE);
//                }
                setBounds(0, 0, 1300, 930);
                jPanel5.setVisible(estado_paneles_diag);
                //jPanel10.setVisible(estado_paneles_diag);
                jPanel17.setVisible(estado_paneles_diag);
            }
            gama_colores_jt5();

            rec = null;
            jt7.requestFocus();
            //jt7.selectAll();
        } else {
            JOptionPane.showMessageDialog(null, "No ha guardado la viga de acople en la que está trabajando");
        }

    }//GEN-LAST:event_aceptar_1KeyPressed

    private void guardar_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardar_2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            //jPanel2.setVisible(false);
            //Nombrar_pryecto.lv1.setVisible(false);
            //String arr1[] = {jt3.getText(), jt2.getText(), jt1.getText(), jt7.getText(), jt10.getText(), jt23.getText()};        
            banderin = false;
            banderin_edit = false;
            elementos = new ArrayList<>();
            elementos.add(jt1.getText());
            elementos.add(jt2.getText());
            elementos.add(jt3.getText());
            elementos.add(jt4.getText());
            elementos.add(jt5.getText());
            elementos.add(jt6.getText());
            elementos.add(jt7.getText());
            elementos.add(jt8.getText());
            elementos.add(jt9.getText());
            elementos.add(jt10.getText());
            elementos.add(jt11.getText());
            elementos.add(jt12.getText());
            elementos.add(jt13.getText());
            elementos.add(jt14.getText());
            elementos.add(jt15.getText());
            elementos.add(jt16.getText());
            elementos.add(jt17.getText());
//        elementos.add(jt18.getText());
            elementos.add(jt21.getText().substring(30));
            elementos.add(jt23.getText());
            elementos.add(jt24.getText());
            elementos.add(jt26.getText());
            if (ch.Dobles(elementos) == 1 || apellido_viga.getText().isEmpty() || (apellido_viga.getText().indexOf(" ") == 0)) {
                JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en las celdas");
            } else {
                String arr1[] = {jt1.getText(), jt2.getText(), jt3.getText(), jt4.getText(), jt5.getText(), jt6.getText(), jt7.getText(), jt8.getText(), jt9.getText(), jt10.getText(),
                    jt11.getText(),
                    jt12.getText(), jt13.getText(), jt14.getText(), jt15.getText(), jt16.getText(), jt17.getText(), jt21.getText(), jt23.getText(), jt24.getText(), jt26.getText(),
                    String.valueOf(combo1.getSelectedIndex()), String.valueOf(combo2.getSelectedIndex()),
                    String.valueOf(combo3.getSelectedIndex()), String.valueOf(combo4.getSelectedIndex()), String.valueOf(combo5.getSelectedIndex()), String.valueOf(combo6.getSelectedIndex()),
                    String.valueOf(combo7.getSelectedIndex()), String.valueOf(combo8.getSelectedIndex()), String.valueOf(combo9.getSelectedIndex()), String.valueOf(combo10.getSelectedIndex()),
                    String.valueOf(combo11.getSelectedIndex()), String.valueOf(combo12.getSelectedIndex()), String.valueOf(combo13.getSelectedIndex()), String.valueOf(combo14.getSelectedIndex()),
                    String.valueOf(combo15.getSelectedIndex()), String.valueOf(combo16.getSelectedIndex()), String.valueOf(combo17.getSelectedIndex()), String.valueOf(combo19.getSelectedIndex()),
                    String.valueOf(combo20.getSelectedIndex()),
                    jl1.getText(), jl2.getText(), jl3.getText(), jl4.getText(), jl5.getText(), jl6.getText(), jl7.getText(), jl8.getText(), jl9.getText(), jl10.getText(), jl11.getText(), jl12.getText(), apellido_viga.getText(), String.valueOf(db_equivalente_combo1), String.valueOf(db_equivalente_combo11)/*54*/, String.valueOf(estado_paneles_diag)/*55*/};
                //String arr2[]={"atb1", "atb2"};

                Vigas vi1;
                //Vigas vi2=new Vigas(arr2, "viga2");        
//            if (flag == true) {
//                vi1 = new Vigas(arr1, jComboBox2.getItemAt(numero_viiga).toString());
//                py.guardarViga(vi1);
//                jComboBox3.addItem(jComboBox2.getItemAt(numero_viiga));
//            } else {
//                vi1 = new Vigas(arr1, nombre_edit);
//                py.guardarViga(vi1);
//                jComboBox3.addItem(nombre_edit);
//            }
                vi1 = new Vigas(arr1, apellido_viga.getText());
                py.guardarViga(vi1);
                jComboBox3.addItem(apellido_viga.getText());
                vi1 = null;
//            if (!String.valueOf(contador_viga).equals(apellido_viga.getText())) {
//                contador_viga++;
//                flag_contador = false;
//            }
            }
        }

    }//GEN-LAST:event_guardar_2KeyPressed

    private void guardar_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guardar_3KeyPressed
        // TODO add your handling code here:
        //setVisible(false);
        if (jComboBox3.getItemCount() == 0) {
            JOptionPane.showMessageDialog(null, "Tiene que tener al menos un elemento procesado para poder guardar el proyecto");
        } else {
            Trazado trazado = new Trazado();
//            try {
//                trazado.fichero_dibujo(py);
//            } catch (IOException ex) {
//                Logger.getLogger(Ventana_calculo.class.getName()).log(Level.SEVERE, null, ex);
//            }
            System.out.println(py.getLista().size());
            System.out.println("");
            for (int i = 0; i < py.getLista().size(); i++) {
                System.out.println(py.getLista().get(i).getNombre_viga());
                for (int j = 0; j < py.getLista().get(0).getPropiedades().length; j++) {
                    System.out.println(py.getLista().get(i).getPropiedades()[j]);
                    //System.out.println(py.getLista().get(i).getNombre_viga()+"  "+py.getLista().get(i).getPropiedades()[0]+"  "+py.getLista().get(i).getPropiedades()[1]);
                }
            }
            JFileChooser jf = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Solo archivos con extension .scr", "scr");
            jf.setFileFilter(filtro);
            String ruta = "";
            try {
                int returnval = jf.showSaveDialog(null);
                if (returnval == jf.APPROVE_OPTION) {
                    ObjectOutputStream out = null;
                    //ObjectOutputStream out1=null;
                    ruta = jf.getSelectedFile().getAbsolutePath();
                    //se crea el fichero .va para una futura recuperacion de datos
                    Py_Serializable ps = new Py_Serializable(py, ruta, nombre);
                    ps.serializar_py();
                    ps.recuperacion_py();
                    //System.out.println(jf.getSelectedFile().getAbsolutePath());
                    if (jf.getSelectedFile().getAbsolutePath().substring(jf.getSelectedFile().getAbsolutePath().length() - 4, jf.getSelectedFile().getAbsolutePath().length()).equals(".scr")) {
                        int marca = jf.getSelectedFile().getAbsolutePath().lastIndexOf("\\");
                        jf.getSelectedFile().getAbsolutePath().substring(marca + 1); //para quedarme solo con el nombre del archivo
                        File fo = new File(jf.getSelectedFile().getAbsolutePath().substring(marca + 1));//se elimina el fichero para evitar corromper el archivo
                        //File fe=new File(jf.getSelectedFile().getAbsolutePath().substring(marca+1,jf.getSelectedFile().getAbsolutePath().length()-4)+".va");//se elimina el fichero para evitar corromper el archivo
                        //System.out.println(jf.getSelectedFile().getAbsolutePath().substring(marca+1,jf.getSelectedFile().getAbsolutePath().length()-4)+".va");
                        fo.delete();
                        //fe.delete();
                        //FileOutputStream f=new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca+1));
                        //out = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca+1)));
                        out = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca + 1)));
                        trazado.fichero_dibujo(py, jf.getSelectedFile().getAbsolutePath().substring(0, jf.getSelectedFile().getAbsolutePath().length() - 4));
                        out.close();
                        //out1 = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath().substring(marca+1,jf.getSelectedFile().getAbsolutePath().length()-4)+".va"));
                    } else {
                        //out1 = new ObjectOutputStream(new FileOutputStream(jf.getSelectedFile().getAbsolutePath() + "(" + nombre + ")" + ".va"));
                        trazado.fichero_dibujo(py, jf.getSelectedFile().getAbsolutePath() + "(" + nombre + ")");
                    }
                    //System.out.println(jf.getSelectedFile().getAbsoluteFile());
                    //ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ruta + ".va"));
                    //out1.reset();
                    //out1.writeObject(py);***********************************************guardar estado de los objetos
                    //out.close();
                    //out1.close();
                    //this.dispose();
                    //py = null;
                    contador_viga = 1;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_guardar_3KeyPressed

    private void cancelar_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelar_2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jPanel2.setVisible(false);
            banderin = false;
            banderin_edit = false;
            limpieza();
            jComboBox2.requestFocus();
        }
    }//GEN-LAST:event_cancelar_2KeyPressed

    private void editarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_editarKeyPressed
        // TODO add your handling code here:
        //jPanel2.setVisible(true);        
        System.out.println(jComboBox3.getItemCount());
        if (jComboBox3.getItemCount() != 0) {
            if (banderin_edit == false && banderin == false) {
                limpieza();
                flag = false;
                nombre_edit = jComboBox3.getItemAt(jComboBox3.getSelectedIndex());
                posicion = jComboBox3.getSelectedIndex();
                Vigas rec;
                rec = py.getLista().get(posicion);
                System.out.println("");
                System.out.println(rec.getNombre_viga());
                System.out.println("cantidad de elementos de la viga " + rec.getPropiedades().length);
                for (int i = 0; i < rec.getPropiedades().length; i++) {
                    System.out.println("posicion " + i + " tiene " + rec.getPropiedades()[i]);
                }

                for (int j = 0; j < rec.getPropiedades().length; j++) {
                    switch (j) {
                        case 0:
                            jt1.setText(rec.getPropiedades()[j]);
                            break;
                        case 1:
                            jt2.setText(rec.getPropiedades()[j]);
                            break;
                        case 2:
                            jt3.setText(rec.getPropiedades()[j]);
                            break;
                        case 3:
                            jt4.setText(rec.getPropiedades()[j]);
                            break;
                        case 4:
                            jt5.setText(rec.getPropiedades()[j]);
                            break;
                        case 5:
                            jt6.setText(rec.getPropiedades()[j]);
                            break;
                        case 6:
                            jt7.setText(rec.getPropiedades()[j]);
                            break;
                        case 7:
                            jt8.setText(rec.getPropiedades()[j]);
                            break;
                        case 8:
                            jt9.setText(rec.getPropiedades()[j]);
                            break;
                        case 9:
                            jt10.setText(rec.getPropiedades()[j]);
                            break;
                        case 10:
                            jt11.setText(rec.getPropiedades()[j]);
                            break;
                        case 11:
                            jt12.setText(rec.getPropiedades()[j]);
                            break;
                        case 12:
                            jt13.setText(rec.getPropiedades()[j]);
                            break;
                        case 13:
                            jt14.setText(rec.getPropiedades()[j]);
                            break;
                        case 14:
                            jt15.setText(rec.getPropiedades()[j]);
                            break;
                        case 15:
                            jt16.setText(rec.getPropiedades()[j]);
                            break;
                        case 16:
                            jt17.setText(rec.getPropiedades()[j]);
                            break;
                        case 17:
                            jt21.setText(rec.getPropiedades()[j]);
                            break;
                        case 18:
                            jt23.setText(rec.getPropiedades()[j]);
                            break;
                        case 19:
                            jt24.setText(rec.getPropiedades()[j]);
                            break;
                        case 20:
                            jt26.setText(rec.getPropiedades()[j]);
                            break;
                        case 21:
                            combo1.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 22:
                            combo2.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 23:
                            combo3.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 24:
                            combo4.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 25:
                            combo5.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 26:
                            combo6.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 27:
                            combo7.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 28:
                            combo8.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 29:
                            combo9.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 30:
                            combo10.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 31:
                            combo11.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 32:
                            combo12.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 33:
                            combo13.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 34:
                            combo14.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 35:
                            combo15.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 36:
                            combo16.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 37:
                            combo17.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 38:
                            combo19.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));
                            break;
                        case 39:
                            combo20.setSelectedIndex(Integer.parseInt(rec.getPropiedades()[j]));//System.out.println("valor de prueba"+rec.getPropiedades()[j]);
                            break;
                        case 40:
                            jl1.setText(rec.getPropiedades()[j]);
                            break;
                        case 41:
                            jl2.setText(rec.getPropiedades()[j]);
                            break;
                        case 42:
                            jl3.setText(rec.getPropiedades()[j]);
                            break;
                        case 43:
                            jl4.setText(rec.getPropiedades()[j]);
                            break;
                        case 44:
                            jl5.setText(rec.getPropiedades()[j]);
                            break;
                        case 45:
                            jl6.setText(rec.getPropiedades()[j]);
                            break;
                        case 46:
                            jl7.setText(rec.getPropiedades()[j]);
                            break;
                        case 47:
                            jl8.setText(rec.getPropiedades()[j]);
                            break;
                        case 48:
                            jl9.setText(rec.getPropiedades()[j]);
                            break;
                        case 49:
                            jl10.setText(rec.getPropiedades()[j]);
                            break;
                        case 50:
                            jl11.setText(rec.getPropiedades()[j]);
                            break;
                        case 51:
                            jl12.setText(rec.getPropiedades()[j]);
                            break;
                        case 52:
                            apellido_viga.setText(rec.getPropiedades()[j]);
                    }
                }
                /**
                 * ****Este metodo no debe eliminar porque la viga editada debe
                 * guardarse en la misma posicion en la que estaba antes de
                 * modificarse*********
                 */
                jPanel2.setVisible(true);
                //para desabilitar los paneles de diagonales en caso de que la viga que se va a editar sea sin diagonales
                if (Boolean.parseBoolean(rec.getPropiedades()[55]) == false) {
                    estado_paneles_diag = false;
                    especial.setSelected(true);
//                    if (Double.parseDouble(rec.getPropiedades()[4]) < 2) {
//                        jt5.setBackground(Color.CYAN);
//                    }
                    setBounds(0, 0, 950, 750);
                    jPanel5.setVisible(estado_paneles_diag);
                    //jPanel10.setVisible(estado_paneles_diag);
                    jPanel17.setVisible(estado_paneles_diag);
                } else {
                    estado_paneles_diag = true;
                    ordinaria.setSelected(true);
//                    if (Double.parseDouble(rec.getPropiedades()[4]) >= 2) {
//                        jt5.setBackground(Color.WHITE);
//                    }
                    setBounds(0, 0, 1300, 930);
                    jPanel5.setVisible(estado_paneles_diag);
                    //jPanel10.setVisible(estado_paneles_diag);
                    jPanel17.setVisible(estado_paneles_diag);
                }
                gama_colores_jt5();
                py.eliminarViga(posicion);
                jComboBox3.removeItemAt(posicion);
                System.out.println("lista long");
                System.out.println(py.getLista().size());
                rec = null;
                jt1.requestFocus();
                banderin_edit = true;
                banderin = true;
            } else {
                JOptionPane.showMessageDialog(null, "No ha guardado la viga de acople en la que está trabajando");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No tiene vigas disponibles para editar");
        }

    }//GEN-LAST:event_editarKeyPressed

    private void eliminarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_eliminarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            try {
                if (jComboBox3.getItemCount() != 0) {
                    py.eliminarViga(jComboBox3.getSelectedIndex());
                    System.out.println(jComboBox3.getSelectedIndex());
                    jComboBox3.removeItemAt(jComboBox3.getSelectedIndex());
                } else {
                    //contador_viga = 1;
                    JOptionPane.showMessageDialog(null, "No tiene vigas disponibles para eliminar");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Verifique, puede que este elemento ya haya sido eliminado");
            }
        }

    }//GEN-LAST:event_eliminarKeyPressed

    private void cancelar_3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cancelar_3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            if (jComboBox3.getItemCount() != 0) {
                int estado = JOptionPane.showConfirmDialog(null, "Está seguro que quiere cancelar?\nSi cancela perderá todo el progreso alcanzado.");
                switch (estado) {
                    case JOptionPane.YES_OPTION:
                        py = null;
                        this.dispose();
                        NewMDIApplication.nuevo.setEnabled(true);
                        //NewMDIApplication.abrir.setEnabled(true);
                        contador_viga = 1;
                        break;
                }
            } else {
                py = null;
                this.dispose();
                NewMDIApplication.nuevo.setEnabled(true);
                //NewMDIApplication.abrir.setEnabled(true);
                contador_viga = 1;
            }
        }
    }//GEN-LAST:event_cancelar_3KeyPressed

    private void jComboBox3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBox3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            guardar_3.requestFocus();
        }
    }//GEN-LAST:event_jComboBox3KeyPressed

    private void combo19FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo19FocusLost
        // TODO add your handling code here:
        double jl6_valor = Double.parseDouble(jl6.getText().substring(17));
        //System.out.println(jl6_valor);
        if (combo19.getSelectedIndex() != 0) {
            if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 3) {
                JOptionPane.showMessageDialog(null, "La separación entre varillas es mayor que 35cm, no es posible poner grapas");
                combo19.setSelectedIndex(cont_pak_base);
                combo19.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 2) {
                JOptionPane.showMessageDialog(null, "No se puede tener mayor número de grapas que de paquetes de varillas en la base");
                combo19.setSelectedIndex(cont_pak_base);
                combo19.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_base, cont_pak_base, combo19.getSelectedIndex()) == 1) {
                JOptionPane.showMessageDialog(null, "No se puede colocar " + combo19.getSelectedIndex() + " grapas en " + cont_pak_base + " paquetes de varillas a menos de 35cm con una separación de " + separacion_diag_base + "cm");
                combo19.setSelectedIndex(cont_pak_base);
                combo19.setBackground(Color.ORANGE);
            } else {
                combo19.setBackground(UIManager.getColor(combo1));
            }
        }else {
                combo19.setBackground(UIManager.getColor(combo1));
            }

//        if (cont_pak_base < combo19.getSelectedIndex()) {
//            JOptionPane.showMessageDialog(null, "No puedes tener mayor número de grapas que de paquetes de varillas en la base");
//            combo19.setSelectedIndex(cont_pak_base);
//            combo19.setBackground(Color.ORANGE);
//        } else {
//            combo19.setBackground(UIManager.getColor(combo1));
//        }
        switch (combo7.getSelectedIndex()) {
            case 0:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 0.71 + jl6_valor, 2)));
                break;
            case 1:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 1.27 + jl6_valor, 2)));
                break;
            case 2:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 1.98 + jl6_valor, 2)));
                break;/*
            case 3:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 1.42 + jl6_valor, 2)));
                break;
            case 4:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 2.54 + jl6_valor, 2)));
                break;
            case 5:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 3.96 + jl6_valor, 2)));
                break;*/
        }
    }//GEN-LAST:event_combo19FocusLost

    private void combo19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo19KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo7.requestFocus();
        }
    }//GEN-LAST:event_combo19KeyPressed

    private void combo20FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo20FocusLost
        // TODO add your handling code here:
        double jl6_valor = Double.parseDouble(jl6.getText().substring(17));
        if (combo20.getSelectedIndex() != 0) {
            if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 3) {
                JOptionPane.showMessageDialog(null, "La separación entre varillas es mayor que 35cm, no es posible poner grapas");
                combo20.setSelectedIndex(cont_pak_cara);
                combo20.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 2) {
                JOptionPane.showMessageDialog(null, "No se puede tener mayor número de grapas que de paquetes de varillas en las caras");
                combo20.setSelectedIndex(cont_pak_cara);
                combo20.setBackground(Color.ORANGE);
            } else if (control_separacion(separacion_diag_caras, cont_pak_cara, combo20.getSelectedIndex()) == 1) {
                JOptionPane.showMessageDialog(null, "No se puede colocar " + combo20.getSelectedIndex() + " grapas en " + cont_pak_cara + " paquetes de varillas a menos de 35cm con una separación de " + separacion_diag_caras + "cm");
                combo20.setSelectedIndex(cont_pak_cara);
                combo20.setBackground(Color.ORANGE);
            } else {
                combo20.setBackground(UIManager.getColor(combo1));
            }
        } else {
                combo20.setBackground(UIManager.getColor(combo1));
            }

//        if (cont_pak_cara < combo20.getSelectedIndex()) {
//            JOptionPane.showMessageDialog(null, "No puedes tener mayor número de grapas que de paquetes de varillas en las caras");
//            combo20.setSelectedIndex(cont_pak_cara);
//            combo20.setBackground(Color.ORANGE);
//        } else {
//            combo20.setBackground(UIManager.getColor(combo1));
//        }
        switch (combo7.getSelectedIndex()) {
            case 0:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 0.71 + jl6_valor, 2)));
                break;
            case 1:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 1.27 + jl6_valor, 2)));
                break;
            case 2:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 1.98 + jl6_valor, 2)));
                break;/*
            case 3:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 1.42 + jl6_valor, 2)));
                break;
            case 4:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 2.54 + jl6_valor, 2)));
                break;
            case 5:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 3.96 + jl6_valor, 2)));
                break;*/
        }
    }//GEN-LAST:event_combo20FocusLost

    private void combo20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo20KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo9.requestFocus();
        }
    }//GEN-LAST:event_combo20KeyPressed

    private void combo6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo6FocusLost
        // TODO add your handling code here:        
        switch (combo6.getSelectedIndex()) {
            case 0:
                jl6.setText("estribos [cm²] = " + 1.42);
                break;
            case 1:
                jl6.setText("estribos [cm²] = " + 2.54);
                break;
            case 2:
                jl6.setText("estribos [cm²] = " + 2.84);
                break;
            case 3:
                jl6.setText("estribos [cm²] = " + 3.96);
                break;
            case 4:
                jl6.setText("estribos [cm²] = " + 5.08);
                break;
            case 5:
                jl6.setText("estribos [cm²] = " + 5.70);
                break;
            case 6:
                jl6.setText("estribos [cm²] = " + 7.92);
                break;
        }
    }//GEN-LAST:event_combo6FocusLost

    private void combo6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo6KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo19.requestFocus();
        }
    }//GEN-LAST:event_combo6KeyPressed

    private void combo7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo7FocusLost
        // TODO add your handling code here:
        double jl6_valor = Double.parseDouble(jl6.getText().substring(17));
        //System.out.println(jl6_valor);
        switch (combo7.getSelectedIndex()) {
            case 0:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 0.71 + jl6_valor, 2)));
                break;
            case 1:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 1.27 + jl6_valor, 2)));
                break;
            case 2:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 1.98 + jl6_valor, 2)));
                break;/*
            case 3:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 1.42 + jl6_valor, 2)));
                break;
            case 4:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 2.54 + jl6_valor, 2)));
                break;
            case 5:
                jl7.setText("grapas v2 [cm²] = " + (redondeo(combo19.getSelectedIndex() * 3.96 + jl6_valor, 2)));
                break;*/
        }
    }

    private void nosirve() {

    }//GEN-LAST:event_combo7FocusLost

    private void combo7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo7KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo20.requestFocus();
        }
    }//GEN-LAST:event_combo7KeyPressed

    private void combo8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo8FocusLost
        // TODO add your handling code here:
        double jl6_valor = Double.parseDouble(jl6.getText().substring(17));
        switch (combo8.getSelectedIndex()) {
            case 0:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 0.71 + jl6_valor, 2)));
                break;
            case 1:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 1.27 + jl6_valor, 2)));
                break;
            case 2:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 1.98 + jl6_valor, 2)));
                break;
            case 3:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 1.42 + jl6_valor, 2)));
                break;
            case 4:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 2.54 + jl6_valor, 2)));
                break;
            case 5:
                jl8.setText("grapas v3 [cm²] = " + (redondeo(combo20.getSelectedIndex() * 3.96 + jl6_valor, 2)));
                break;
        }
    }//GEN-LAST:event_combo8FocusLost

    private void combo8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo8KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo9.requestFocus();
        }
    }//GEN-LAST:event_combo8KeyPressed

    private void combo9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo9KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo11.requestFocus();
        }
    }//GEN-LAST:event_combo9KeyPressed

    private void combo10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo10KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo11.requestFocus();
        }
    }//GEN-LAST:event_combo10KeyPressed

    private void jt21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt21KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo6.requestFocus();
        }
    }//GEN-LAST:event_jt21KeyPressed

    private void jt21FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt21FocusGained
        // TODO add your handling code here:
        jt21.setText(jl5.getText().substring(20));
        jt21.selectAll();
    }//GEN-LAST:event_jt21FocusGained

    private void jt21FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt21FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt21.getText());
        if (jt21.getText().equals("") || ch.Dobles(elementos) == 1 || Double.parseDouble(jt21.getText()) < Double.parseDouble(jl5.getText().substring(20))) {
            jt21.setText("l desarrollo propuesta [cm] = " + jl5.getText().substring(20));
            jt21.setBackground(Color.ORANGE);
        } else {
            //if(Double.parseDouble(jt21.getText())<Double.parseDouble(jl5.getText().substring(20)))
            jt21.setText("l desarrollo propuesta [cm] = " + jt21.getText());
            jt21.setBackground(Color.WHITE);
        }
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
    }//GEN-LAST:event_jt21FocusLost

    private void combo9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo9FocusLost
        // TODO add your handling code here:
        estado_combo9();
    }//GEN-LAST:event_combo9FocusLost

    private void apellido_vigaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_apellido_vigaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            guardar_2.requestFocus();
        }
    }//GEN-LAST:event_apellido_vigaKeyPressed

    private void apellido_vigaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellido_vigaFocusLost
//        // TODO add your handling code here:
//        if (apellido_viga.getText().equals("")) {
//            apellido_viga.setText(String.valueOf(contador_viga));
//            apellido_viga.setBackground(Color.ORANGE);
//            //JOptionPane.showMessageDialog(null, "Se le a puesto un nombre por defecto ");
//        } else {
//            jt10.setBackground(Color.WHITE);
//        }
    }//GEN-LAST:event_apellido_vigaFocusLost

    private void apellido_vigaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_apellido_vigaFocusGained
        // TODO add your handling code here:
        apellido_viga.selectAll();
    }//GEN-LAST:event_apellido_vigaFocusGained

    private void ordinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordinariaActionPerformed
        // TODO add your handling code here:
        estado_paneles_diag = true;
        setBounds(0, 0, 1300, 930);
        jPanel5.setVisible(estado_paneles_diag);
        //jPanel10.setVisible(estado_paneles_diag);
        jPanel17.setVisible(estado_paneles_diag);
    }//GEN-LAST:event_ordinariaActionPerformed

    private void especialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_especialActionPerformed
        // TODO add your handling code here:
        estado_paneles_diag = false;
        setBounds(0, 0, 950, 750);
        //jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        //jPanel2.setBounds(0, 0, 650, 500);
        jPanel5.setVisible(estado_paneles_diag);
        //jPanel10.setVisible(estado_paneles_diag);
        jPanel17.setVisible(estado_paneles_diag);
    }//GEN-LAST:event_especialActionPerformed

    private void jt16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt16KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo1.requestFocus();
        }
    }//GEN-LAST:event_jt16KeyPressed

    private void jt16FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt16FocusLost
        // TODO add your handling code here:
        //double aux = Double.parseDouble(jt2.getText()) / 4;para comparacion sin redondeo
        double aux = redondeo(Double.parseDouble(jt2.getText()) / 4, 1);
        elementos = new ArrayList<>();
        elementos.add(jt16.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt16.getText()) > aux || Double.parseDouble(jt16.getText()) <= Double.parseDouble(jt3.getText())/5) {
            jt16.setText(String.valueOf(redondeo(aux, 1)));
            jt16.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda, verifique que sea un número y que esté entre " + redondeo((Double.parseDouble(jt3.getText())/5),1) + " y " + redondeo(aux, 1));
            combo1.requestFocus();
        } else {
            jt16.setBackground(Color.white);
        }
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
        separacion_varillas_cara(2);
        //para controlar que no se me vayan mas grapas que paquetes
        if (combo20.getSelectedIndex() > combo3.getSelectedIndex()) {
            combo20.setSelectedIndex(combo3.getSelectedIndex());
            combo20.setBackground(Color.ORANGE);
        } else {
            combo20.setBackground(UIManager.getColor(combo1));
        }
    }//GEN-LAST:event_jt16FocusLost

    private void jt15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt15KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt16.requestFocus();
        }
    }//GEN-LAST:event_jt15KeyPressed

    private void jt15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt15FocusLost
        // TODO add your handling code here:
        double aux = redondeo(Double.parseDouble(jt3.getText()) / 2 - 2 * Double.parseDouble(jt4.getText()), 1);
        elementos = new ArrayList<>();
        elementos.add(jt15.getText());
        if (ch.Dobles(elementos) == 1 /*|| (Double.parseDouble(jt15.getText()))*/ || ((Double.parseDouble(jt15.getText())) < aux || Double.parseDouble(jt15.getText()) > (redondeo(3 * Double.parseDouble(jt3.getText()) / 4 - 2 * Double.parseDouble(jt4.getText()), 1)))) {
            jt15.setText(String.valueOf(redondeo(3 * Double.parseDouble(jt3.getText()) / 4 - 2 * Double.parseDouble(jt4.getText()), 1)));
            jt15.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda, verifique que sea un número y que esté entre " + aux + " y " + (redondeo(3 * Double.parseDouble(jt3.getText()) / 4 - 2 * Double.parseDouble(jt4.getText()), 1)));
        } else {
            jt15.setBackground(Color.white);
        }
        //jt16.selectAll();
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
        separacion_varillas_base(2);
        if (combo19.getSelectedIndex() > combo2.getSelectedIndex()) {
            combo19.setSelectedIndex(combo2.getSelectedIndex());
            combo19.setBackground(Color.ORANGE);
        } else {
            combo19.setBackground(UIManager.getColor(combo1));
        }
    }//GEN-LAST:event_jt15FocusLost

    private void jt7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt7KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt8.requestFocus();
        }
    }//GEN-LAST:event_jt7KeyPressed

    private void jt7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt7FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt2.getText());
        elementos.add(jt3.getText());
        elementos.add(jt7.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt7.getText()) < 250 || Double.parseDouble(jt7.getText()) > 1000) {            
            jt7.setText("250.0");
            jt7.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda");
            //JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en las celdas <f'c[kgf/cm²], <h[cm] y/o <bw[cm]");
            //jt8.requestFocus();
        } else {
            jt7.setBackground(Color.white);
        }
        jt11.setText(String.valueOf(redondeo(1.1 * Math.sqrt(Double.parseDouble(jt7.getText())) * Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) / 1000, 2)));
        jt12.setText(String.valueOf(redondeo((Double.parseDouble(jt13.getText()) * 2.65 * Math.sqrt(Double.parseDouble(jt7.getText())) * Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText())) / 1000, 2)));
        //jt8.selectAll();
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
    }//GEN-LAST:event_jt7FocusLost

    private void jt10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt10KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            apellido_viga.requestFocus();
        }
    }//GEN-LAST:event_jt10KeyPressed

    private void jt10FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt10FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt10.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt10.getText()) <= 0) {
            jt10.setText("1.0");
            jt10.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda");
        } else {
            jt10.setBackground(Color.WHITE);
        }
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
        //jt15.selectAll();
    }//GEN-LAST:event_jt10FocusLost

    private void jt9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt9KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt1.requestFocus();
            //jt1.selectAll();
        }
    }//GEN-LAST:event_jt9KeyPressed

    private void jt9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt9FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt9.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt9.getText()) < 4220 || Double.parseDouble(jt9.getText()) > 6000) {            
            jt9.setText("4220.0");
            jt9.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda, verifique que sea un número y que esté entre 4220 y 6000");
            jt1.requestFocus();
        } else {
            jt9.setBackground(Color.white);
        }
        //jt1.selectAll();
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
    }//GEN-LAST:event_jt9FocusLost

    private void jt8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt8KeyPressed
        // TODO add your handling code here:
        //elementos = new ArrayList<>();
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt9.requestFocus();
        }
    }//GEN-LAST:event_jt8KeyPressed

    private void jt8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt8FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt8.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt8.getText()) < 4220 || Double.parseDouble(jt8.getText()) > 6000) {
            jt8.setText("4220.0");
            jt8.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda, verifique que sea un número y que esté entre 4220 y 6000");            
            jt9.requestFocus();
        } else {
            jt8.setBackground(Color.white);
        }
        longitud_desarrollo();
        jt21.setText("l desarrollo propuesta [cm] = " + jl5.getText().substring(20));
        //jt9.selectAll();
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
    }//GEN-LAST:event_jt8FocusLost

    private void combo17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo17KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            guardar_2.requestFocus();
        }
    }//GEN-LAST:event_combo17KeyPressed

    private void jt24KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt24KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo17.requestFocus();
        }
    }//GEN-LAST:event_jt24KeyPressed

    private void jt23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt23KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt10.requestFocus();
        }
    }//GEN-LAST:event_jt23KeyPressed

    private void jt23FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt23FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt23.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt23.getText()) <= 0) {
            jt23.setText("1.0");
            jt23.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda");
        } else {
            jt23.setBackground(Color.WHITE);
        }
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
    }//GEN-LAST:event_jt23FocusLost

    private void jt23FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt23FocusGained
        // TODO add your handling code here:
        jt23.selectAll();
    }//GEN-LAST:event_jt23FocusGained

    private void combo16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo16KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt23.requestFocus();
        }
    }//GEN-LAST:event_combo16KeyPressed

    private void combo13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo13KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo16.requestFocus();
        }
    }//GEN-LAST:event_combo13KeyPressed

    private void combo15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo15KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo13.requestFocus();
        }
    }//GEN-LAST:event_combo15KeyPressed

    private void combo15FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo15FocusLost
        // TODO add your handling code here:
        switch (combo15.getSelectedIndex()) {
            case 0:
            jl12.setText("Asp [cm²] = " + jt26.getText() + "#3 @ CARA");
            break;
            case 1:
            jl12.setText("Asp [cm²] = " + jt26.getText() + "#4 @ CARA");
            break;
        }
    }//GEN-LAST:event_combo15FocusLost

    private void combo14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo14KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo15.requestFocus();
        }
    }//GEN-LAST:event_combo14KeyPressed

    private void combo14FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo14FocusLost
        // TODO add your handling code here:
        db_combo12y14 = 1.91;
        switch (combo14.getSelectedIndex()) {
            case 0:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 2.85, 2));
            db_combo12y14 = 1.91;
            break;
            case 1:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 5.07, 2));
            db_combo12y14 = 2.54;
            break;
            case 2:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 5.70, 2));
            db_combo12y14 = 2.69;
            break;
            case 3:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 7.92, 2));
            db_combo12y14 = 3.18;
            break;
            case 4:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 10.13, 2));
            db_combo12y14 = 3.59;
            break;
            case 5:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 10.77, 2));
            db_combo12y14 = 3.70;
            break;
            case 6:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 11.40, 2));
            db_combo12y14 = 3.81;
            break;
            case 7:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 12.98, 2));
            db_combo12y14 = 4.07;
            break;
            case 8:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 15.20, 2));
            db_combo12y14 = 4.40;
            break;
            case 9:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 15.83, 2));
            db_combo12y14 = 4.49;
            break;
            case 10:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 18.05, 2));
            db_combo12y14 = 4.79;
            break;
            case 11:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 22.80, 2));
            db_combo12y14 = 5.39;
            break;
            case 12:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 23.75, 2));
            db_combo12y14 = 5.50;
            break;
            case 13:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 27.24, 2));
            db_combo12y14 = 5.89;
            break;
            case 14:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 34.20, 2));
            db_combo12y14 = 6.60;
            break;
        }
        //calculo de separacion de varillas en la abse de estribo grande
        double separacion = ((Double.parseDouble(jt3.getText()) - 2 * Double.parseDouble(jt4.getText())) - db_equivalente_combo11) / (combo12.getSelectedIndex() + 1);
        if (separacion < Math.max(2 * db_combo12y14, db_combo12y14 + 2.5)) {
            combo12.setBackground(Color.ORANGE);
            combo12.setSelectedIndex(0);
        } else {
            combo12.setBackground(UIManager.getColor(combo1));
        }
    }//GEN-LAST:event_combo14FocusLost

    private void combo12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo12KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo14.requestFocus();
        }
    }//GEN-LAST:event_combo12KeyPressed

    private void combo12FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo12FocusLost
        // TODO add your handling code here:
        db_combo12y14 = 1.91;
        switch (combo14.getSelectedIndex()) {
            case 0:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 2.85, 2));
            db_combo12y14 = 1.91;
            break;
            case 1:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 5.07, 2));
            db_combo12y14 = 2.54;
            break;
            case 2:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 5.70, 2));
            db_combo12y14 = 2.69;
            break;
            case 3:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 7.92, 2));
            db_combo12y14 = 3.18;
            break;
            case 4:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 10.13, 2));
            db_combo12y14 = 3.59;
            break;
            case 5:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 10.77, 2));
            db_combo12y14 = 3.70;
            break;
            case 6:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 11.40, 2));
            db_combo12y14 = 3.81;
            break;
            case 7:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 12.98, 2));
            db_combo12y14 = 4.07;
            break;
            case 8:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 15.20, 2));
            db_combo12y14 = 4.40;
            break;
            case 9:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 15.83, 2));
            db_combo12y14 = 4.49;
            break;
            case 10:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 18.05, 2));
            db_combo12y14 = 4.79;
            break;
            case 11:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 22.80, 2));
            db_combo12y14 = 5.39;
            break;
            case 12:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 23.75, 2));
            db_combo12y14 = 5.50;
            break;
            case 13:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 27.24, 2));
            db_combo12y14 = 5.89;
            break;
            case 14:
            jl11.setText("As cara b [cm²] = " + redondeo(combo12.getSelectedIndex() * 34.20, 2));
            db_combo12y14 = 6.60;
            break;
        }
        //calculo de separacion de varillas en la base de estribo grande
        double separacion = ((Double.parseDouble(jt3.getText()) - 2 * Double.parseDouble(jt4.getText())) - db_equivalente_combo11) / (combo12.getSelectedIndex() + 1);
        if (separacion < Math.max(2 * db_combo12y14, db_combo12y14 + 2.5)) {
            combo12.setBackground(Color.ORANGE);
            combo12.setSelectedIndex(0);
        } else {
            combo12.setBackground(UIManager.getColor(combo1));
        }
        //actualizar_jl4();
    }//GEN-LAST:event_combo12FocusLost

    private void combo11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_combo11KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            combo12.requestFocus();
        }
    }//GEN-LAST:event_combo11KeyPressed

    private void combo11FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo11FocusLost
        // TODO add your handling code here:
        switch (combo11.getSelectedIndex()) {
            case 0:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 2.85, 2));
            db_equivalente_combo11 = 1.91;
            break;
            case 1:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 5.07, 2));
            db_equivalente_combo11 = 2.54;
            break;
            case 2:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 5.70, 2));
            db_equivalente_combo11 = 2.69;
            break;
            case 3:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 7.92, 2));
            db_equivalente_combo11 = 3.18;
            break;
            case 4:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 10.13, 2));
            db_equivalente_combo11 = 3.59;
            break;
            case 5:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 10.77, 2));
            db_equivalente_combo11 = 3.70;
            break;
            case 6:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 11.40, 2));
            db_equivalente_combo11 = 3.81;
            break;
            case 7:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 12.98, 2));
            db_equivalente_combo11 = 4.07;
            break;
            case 8:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 15.20, 2));
            db_equivalente_combo11 = 4.40;
            break;
            case 9:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 15.83, 2));
            db_equivalente_combo11 = 4.49;
            break;
            case 10:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 18.05, 2));
            db_equivalente_combo11 = 4.79;
            break;
            case 11:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 22.80, 2));
            db_equivalente_combo11 = 5.39;
            break;
            case 12:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 23.75, 2));
            db_equivalente_combo11 = 5.50;
            break;
            case 13:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 27.24, 2));
            db_equivalente_combo11 = 5.89;
            break;
            case 14:
            jl10.setText("As Esquinas [cm²] = " + redondeo(2 * 34.20, 2));
            db_equivalente_combo11 = 6.60;
            break;
        }
        //calculo de separacion de varillas en la base de estribo grande
        double separacion = ((Double.parseDouble(jt3.getText()) - 2 * Double.parseDouble(jt4.getText())) - db_equivalente_combo11) / (combo12.getSelectedIndex() + 1);
        if (separacion < Math.max(2 * db_combo12y14, db_combo12y14 + 2.5)) {
            combo12.setBackground(Color.ORANGE);
            combo12.setSelectedIndex(0);
        } else {
            combo12.setBackground(UIManager.getColor(combo1));
        }
        //actualizar_jl4();
        calculo_mr();
    }//GEN-LAST:event_combo11FocusLost

    private void jt7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt7FocusGained
        // TODO add your handling code here:
        jt7.selectAll();
    }//GEN-LAST:event_jt7FocusGained

    private void jt8FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt8FocusGained
        // TODO add your handling code here:
        jt8.selectAll();
    }//GEN-LAST:event_jt8FocusGained

    private void jt9FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt9FocusGained
        // TODO add your handling code here:
        jt9.selectAll();
    }//GEN-LAST:event_jt9FocusGained

    private void jt15FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt15FocusGained
        // TODO add your handling code here:
        jt15.selectAll();
    }//GEN-LAST:event_jt15FocusGained

    private void jt16FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt16FocusGained
        // TODO add your handling code here:
        jt16.selectAll();
    }//GEN-LAST:event_jt16FocusGained

    private void jt10FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt10FocusGained
        // TODO add your handling code here:
        jt10.selectAll();
    }//GEN-LAST:event_jt10FocusGained

    private void jt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt2KeyPressed
        // TODO add your handling code here
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt3.requestFocus();
        }
    }//GEN-LAST:event_jt2KeyPressed

    private void jt2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt2FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt2.getText());
        elementos.add(jt3.getText());
        elementos.add(jt7.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt2.getText()) <= 0) {
            jt2.setText("1.0");
            jt2.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda");
            //JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en las celdas <ln[cm] y/o <h[cm]");
            jt3.requestFocus();
        } else {
            jt2.setBackground(Color.WHITE);
        }
        jt5.setText(String.valueOf(redondeo(Double.parseDouble(jt1.getText()) / Double.parseDouble(jt2.getText()), 2)));
        //jt16.setText(String.valueOf(Math.round(Double.parseDouble(jt2.getText()) / 4)));
        jt16.setText(String.valueOf(redondeo(Double.parseDouble(jt2.getText()) / 4, 1)));
        if (Double.parseDouble(jt2.getText()) >= 60) {//el radio tiene un valor fijo por el momento (5.0)
            jt26.setText(String.valueOf(Math.round((Double.parseDouble(jt2.getText()) - 2 * Double.parseDouble(jt4.getText())) / 30)));
        } else {
            jt26.setText("0");
        }
        switch (combo15.getSelectedIndex()) {
            case 0:
            jl12.setText("Asp [cm²] = " + jt26.getText() + "#3 @ CARA");
            break;
            case 1:
            jl12.setText("Asp [cm²] = " + jt26.getText() + "#4 @ CARA");
            break;
        }
        //jt3.selectAll();
        jt11.setText(String.valueOf(redondeo(1.1 * Math.sqrt(Double.parseDouble(jt7.getText())) * Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) / 1000, 2)));
        jt12.setText(String.valueOf(redondeo((Double.parseDouble(jt13.getText()) * 2.65 * Math.sqrt(Double.parseDouble(jt7.getText())) * Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText())) / 1000, 2)));
        //para desabilitar los paneles de diagonales
        //        if (Double.parseDouble(jt5.getText()) < 2) {
            //            jt5.setBackground(Color.CYAN);
            ////                estado_paneles_diag = false;
            ////                setBounds(0, 0, 950, 750);
            ////                jPanel5.setVisible(estado_paneles_diag);
            ////                //jPanel10.setVisible(estado_paneles_diag);
            ////                jPanel17.setVisible(estado_paneles_diag);
            //        } else {
            //            jt5.setBackground(Color.WHITE);
            ////                estado_paneles_diag = true;
            ////                setBounds(0, 0, 1300, 930);
            ////                jPanel5.setVisible(estado_paneles_diag);
            ////                //jPanel10.setVisible(estado_paneles_diag);
            ////                jPanel17.setVisible(estado_paneles_diag);
            //        }
        gama_colores_jt5();
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
        separacion_varillas_cara(2);
        //para controlar que no se me vayan mas grapas que paquetes
        if (combo20.getSelectedIndex() > combo3.getSelectedIndex()) {
            combo20.setSelectedIndex(combo3.getSelectedIndex());
            combo20.setBackground(Color.ORANGE);
        } else {
            combo20.setBackground(UIManager.getColor(combo1));
        }
    }//GEN-LAST:event_jt2FocusLost

    private void jt2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt2FocusGained
        // TODO add your handling code here:
        jt2.selectAll();
    }//GEN-LAST:event_jt2FocusGained

    private void jt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt3KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            if (estado_paneles_diag == true) {
                jt15.requestFocus();
            } else {
                combo11.requestFocus();
            }
        }
    }//GEN-LAST:event_jt3KeyPressed

    private void jt3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt3FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt2.getText());
        elementos.add(jt3.getText());
        elementos.add(jt7.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt3.getText()) < 30/* || Double.parseDouble(jt3.getText())< 25 */) {
            jt3.setText("30.0");
            jt3.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo un valor incorrecto en esta celda");
            jt15.requestFocus();
        } else {
            jt3.setBackground(Color.WHITE);
        }
        jt15.setText(String.valueOf(redondeo(3 * Double.parseDouble(jt3.getText()) / 4 - 2 * Double.parseDouble(jt4.getText()), 1)));
        jt11.setText(String.valueOf(redondeo(1.1 * Math.sqrt(Double.parseDouble(jt7.getText())) * Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText()) / 1000, 2)));
        jt12.setText(String.valueOf(redondeo((Double.parseDouble(jt13.getText()) * 2.65 * Math.sqrt(Double.parseDouble(jt7.getText())) * Double.parseDouble(jt2.getText()) * Double.parseDouble(jt3.getText())) / 1000, 2)));
        //jt7.selectAll();
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
        separacion_varillas_base(2);
        if (combo19.getSelectedIndex() > combo2.getSelectedIndex()) {
            combo19.setSelectedIndex(combo2.getSelectedIndex());
            combo19.setBackground(Color.ORANGE);
        } else {
            combo19.setBackground(UIManager.getColor(combo1));
        }
    }//GEN-LAST:event_jt3FocusLost

    private void jt3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt3FocusGained
        // TODO add your handling code here:
        jt3.selectAll();
    }//GEN-LAST:event_jt3FocusGained

    private void jt6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt6KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt7.requestFocus();
        }
    }//GEN-LAST:event_jt6KeyPressed

    private void jt6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt6FocusLost
        // TODO add your handling code here:
        //        elementos = new ArrayList<>();
        //        elementos.add(jt6.getText());
        //        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt6.getText()) < 10 || Double.parseDouble(jt6.getText()) > 70) {
            //            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda, verifique que sea un número y que este entre 10 y 70");
            //            jt6.setText("35.0");
            //            jt6.setBackground(Color.ORANGE);
            //        } else {
            //            jt6.setBackground(Color.white);
            //        }
        //jt7.selectAll();
    }//GEN-LAST:event_jt6FocusLost

    private void jt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER/* || evt.getKeyCode() == evt.VK_SPACE*/) {
            jt2.requestFocus();
        }
    }//GEN-LAST:event_jt1KeyPressed

    private void jt1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt1FocusLost
        // TODO add your handling code here:
        elementos = new ArrayList<>();
        elementos.add(jt1.getText());
        if (ch.Dobles(elementos) == 1 || Double.parseDouble(jt1.getText()) <= 0) {
            jt1.setText("1.0");
            jt1.setBackground(Color.ORANGE);
            JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en esta celda");
            //JOptionPane.showMessageDialog(null, "Está introduciendo valores incorrectos en las celdas <ln[cm] y/o <h[cm]");
            jt2.requestFocus();
        } else {
            jt1.setBackground(Color.WHITE);
        }
        jt5.setText(String.valueOf(redondeo(Double.parseDouble(jt1.getText()) / Double.parseDouble(jt2.getText()), 2)));
        //jt2.selectAll();
        //para desabilitar los paneles de diagonales
        //        if (Double.parseDouble(jt5.getText()) < 2) {
            //            jt5.setBackground(Color.CYAN);
            ////            estado_paneles_diag = false;
            ////            setBounds(0, 0, 950, 750);
            ////            jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
            ////            jPanel2.setBounds(0, 0, 650, 500);
            ////            jPanel5.setVisible(estado_paneles_diag);
            ////            jPanel10.setVisible(estado_paneles_diag);
            ////            jPanel17.setVisible(estado_paneles_diag);
            //
            //        } else {
            //            jt5.setBackground(Color.WHITE);
            ////            estado_paneles_diag = true;
            ////            setBounds(0, 0, 1300, 930);
            ////            jPanel5.setVisible(estado_paneles_diag);
            ////            //jPanel10.setVisible(estado_paneles_diag);
            ////            jPanel17.setVisible(estado_paneles_diag);
            //        }
        gama_colores_jt5();
        calculo_notificacion();
        calculo_mr();
        calculo_angulo();
    }//GEN-LAST:event_jt1FocusLost

    private void jt1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jt1FocusGained
        // TODO add your handling code here:
        jt1.selectAll();
    }//GEN-LAST:event_jt1FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptar_1;
    private javax.swing.JTextField apellido_viga;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelar_2;
    private javax.swing.JButton cancelar_3;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JComboBox<String> combo10;
    private javax.swing.JComboBox<String> combo11;
    private javax.swing.JComboBox<String> combo12;
    private javax.swing.JComboBox<String> combo13;
    private javax.swing.JComboBox<String> combo14;
    private javax.swing.JComboBox<String> combo15;
    private javax.swing.JComboBox<String> combo16;
    private javax.swing.JComboBox<String> combo17;
    private javax.swing.JComboBox<String> combo19;
    public javax.swing.JComboBox<String> combo2;
    private javax.swing.JComboBox<String> combo20;
    private javax.swing.JComboBox<String> combo3;
    public javax.swing.JComboBox<String> combo4;
    private javax.swing.JComboBox<String> combo5;
    private javax.swing.JComboBox<String> combo6;
    private javax.swing.JComboBox<String> combo7;
    private javax.swing.JComboBox<String> combo8;
    private javax.swing.JComboBox<String> combo9;
    private javax.swing.JButton editar;
    private javax.swing.JButton eliminar;
    private javax.swing.JRadioButton especial;
    private javax.swing.JButton guardar_2;
    private javax.swing.JButton guardar_3;
    public javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    public javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    public javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jl1;
    private javax.swing.JLabel jl10;
    private javax.swing.JLabel jl11;
    private javax.swing.JLabel jl12;
    private javax.swing.JLabel jl13;
    private javax.swing.JLabel jl2;
    private javax.swing.JLabel jl3;
    private javax.swing.JLabel jl4;
    private javax.swing.JLabel jl5;
    private javax.swing.JLabel jl6;
    private javax.swing.JLabel jl7;
    private javax.swing.JLabel jl8;
    private javax.swing.JLabel jl9;
    private javax.swing.JTextField jt1;
    private javax.swing.JTextField jt10;
    private javax.swing.JTextField jt11;
    private javax.swing.JTextField jt12;
    private javax.swing.JTextField jt13;
    private javax.swing.JTextField jt14;
    private javax.swing.JTextField jt15;
    private javax.swing.JTextField jt16;
    private javax.swing.JTextField jt17;
    private javax.swing.JTextField jt18;
    private javax.swing.JTextField jt2;
    private javax.swing.JTextField jt21;
    private javax.swing.JTextField jt23;
    private javax.swing.JTextField jt24;
    private javax.swing.JTextField jt25;
    private javax.swing.JTextField jt26;
    private javax.swing.JTextField jt3;
    private javax.swing.JTextField jt4;
    private javax.swing.JTextField jt5;
    private javax.swing.JTextField jt6;
    private javax.swing.JTextField jt7;
    private javax.swing.JTextField jt8;
    private javax.swing.JTextField jt9;
    private javax.swing.JRadioButton ordinaria;
    // End of variables declaration//GEN-END:variables
}
