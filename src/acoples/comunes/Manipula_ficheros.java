/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acoples.comunes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Alba Proyecto
 */
public class Manipula_ficheros {

    //private List cellDataList;
    private String direccion;

    public Manipula_ficheros(String direccion) {
        this.direccion = direccion;
    }

    public Estructura_Dato lectura_fichero() {
        List cellDataList = new ArrayList();
        int t = 0;
        try {
            FileInputStream fileInputStream = new FileInputStream(direccion);
            if (!direccion.substring(direccion.length()-5, direccion.length()).equals(".xlsx")) {
                throw new Mi_Excepcion_Etensiones();
            } else {
                XSSFWorkbook workBook = new XSSFWorkbook(fileInputStream);
                XSSFSheet hssfSheet = workBook.getSheetAt(t);// aqui va el cero
                Iterator rowIterator = hssfSheet.rowIterator();
                while (rowIterator.hasNext()) {
                    XSSFRow hssfRow = (XSSFRow) rowIterator.next();
                    Iterator iterator = hssfRow.cellIterator();
                    List cellTempList = new ArrayList();
                    while (iterator.hasNext()) {
                        XSSFCell hssfCell = (XSSFCell) iterator.next();
                        cellTempList.add(hssfCell);
                    }
                    cellDataList.add(cellTempList);
                }
            }
        } catch (NumberFormatException ne) {
            System.out.println(""+ne.getMessage());
            JOptionPane.showMessageDialog(null, "El sistema no puede encontrar el archivo especificado");
            return new Estructura_Dato(cellDataList, 0);
        } catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "El sistema no puede encontrar el archivo especificado");
            return new Estructura_Dato(cellDataList, 0);
        } catch (Mi_Excepcion_Etensiones mx) {
            mx.extension_desconocida();
            return new Estructura_Dato(cellDataList, 0);
        }
        Leer(cellDataList);
        return new Estructura_Dato(cellDataList, Leer(cellDataList));
    }

    private int Leer(List cellDataList) {
        for (int i = 0; i < cellDataList.size(); i++) {
            List cellTempList = (List) cellDataList.get(i);
            System.out.println("cantidad de celdas " + cellTempList.size());
            if (cellTempList.size() != 7) {
                //JOptionPane.showMessageDialog(null, "El archivo no tiene la estructura correcta");
                return 0;
            } else {
                for (int j = 0; j < cellTempList.size(); j++) {
                    XSSFCell hssfCell = (XSSFCell) cellTempList.get(j);
                    String stringCellValue = hssfCell.toString();
                    System.out.print(stringCellValue + " ");
                }
            }

            System.out.println();
        }
        return 1;
    }

}
