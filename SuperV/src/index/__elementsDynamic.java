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
 * @author Aaa
 */
public class __elementsDynamic {
    
    private final inicio desing;
    
    public __elementsDynamic(inicio ventanaActual) {
        this.desing = ventanaActual;
    }
    
    /** OJO!!!!
     * ESTO PARA QUE FUNCIONE NECESITA LA REFERENCIA A LA INSTANCIA Y NO CREAR UNA NUEVA.
     */
    
    // Cargamos nuestros protopipos para usar el mismo siempre
    __elementsInGUI prototipo = new __elementsInGUI();
    
    public void elementNewRow(String texto){
        JPanel fila = new JPanel();
        fila.setLayout(new BoxLayout(fila, BoxLayout.X_AXIS));
        fila.add(prototipo.element_jTextField(texto));
        fila.add(prototipo.element_jButtonDel());
        //fila.add(Box.createHorizontalStrut(10)); //Aparecen las filas flotando en el centro equidistantes
        //fila.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0)); //No hace falta
        desing._agregarAlContenedorW(fila);
    }

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
     * UNIFICAR en __elementsDynamic el codigo repetitivo en __saveElementsJson y __loadElementsJson.
     * elementFileChooser() NO SE ESTA USANDO ACTUALMENTE!!!!
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
