/*
 * Copyright (C) 2025 MANUEL GARCIA BACEIREDO
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package index;

import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Manuel Garcia Baceiredo
 * @version 1.1.20250611
 * 
 */

    /** 
     * ESTA CLASE ES PARA MODIFICAR EL DESING CON LA REFERENCIA DE LA INSTANCIA inicio(), 
     * NOTA: NO CREAR NUEVAS INST., LA LOGICA INDEPENDIENTE GLICHEA EL DESING EXISTENTE EN LA APP.
     * 
     */

public class __elementsDynamic {
    
    private final inicio desing;
    
    public __elementsDynamic(inicio ventanaActual) {
        this.desing = ventanaActual;
    }
    
    
    
    // Cargamos nuestros protopipos para usar el mismo siempre
    __elementsInGUI prototipo = new __elementsInGUI();
    
    
    /**
    * AÑADE UNA NUEVA FILA CON BOTON Y JTEXTAREA.
     * @param texto
    */
    public void elementNewRow(String texto){    
        JPanel fila = new JPanel();
        fila.setLayout(new BoxLayout(fila, BoxLayout.X_AXIS));
        fila.add(prototipo.element_jButtonDel());
        fila.add(prototipo.element_jTextField(texto));
        
        //fila.add(Box.createHorizontalStrut(10)); //Aparecen las filas flotando en el centro equidistantes
        //fila.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); //No hace falta
        desing._agregarAlContenedorW(fila);
    }

    
    /**
    * ELIMINA EL CONTENIDO DE TODAS LOS JTEXTAREA.
    */
    public void elementsDrop(){
                for (Component comp : desing.getjPanelContenedor().getComponents()) {
                    if (comp instanceof JPanel) {
                        JPanel fila = (JPanel) comp;
                        for (Component subcomp : fila.getComponents()) {
                            if (subcomp instanceof JTextField) {
                                JTextField campo = (JTextField) subcomp;
                                campo.setText("");
                            }
                        }
                    }   
                }  
    }
    
    
    /** 
     * En desarrollo y sin uso.
     * UNIFICAR AQUI el codigo repetitivo de __saveElementsJson y __loadElementsJson
     * @return 
     */
    public int elementFileChooser(){
        String directorioActual = System.getProperty("user.dir");
        JFileChooser fileChooser = new JFileChooser(directorioActual);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JSON (*.json)", "json"));
        int resultado = fileChooser.showSaveDialog(null);
        return resultado;
        
        
        //BLABLABLA
        
        
        
    }
        
}
