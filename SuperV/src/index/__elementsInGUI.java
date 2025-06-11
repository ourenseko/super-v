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

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Manuel Garcia Baceiredo
 * @version 1.1.20250610
 * 
 */


  /** ATENCION:
   * ESTA CLASE ES PARA CREAR CON EL MISMO FORMATO LOS CONTROLES SWING
   * DIMENSIONES, COLOR, ETC.
   **/

public class __elementsInGUI {
    
    //cambiamos a private y creamos constructor.
    private JTextField nuevoCampo;
    
    public JTextField element_jTextField(String text){
            // Crear el input responsive en eje X
            nuevoCampo = new JTextField(20);
            //nuevoCampo.setPreferredSize(new java.awt.Dimension(jPanelContenedor.getParent().getWidth(), 50));
            //nuevoCampo.setMinimumSize(new java.awt.Dimension(450, 50)); // jPanelContenedor.getParent().getWidth()-90
            nuevoCampo.setMaximumSize(new java.awt.Dimension(Integer.MAX_VALUE, 30));
            nuevoCampo.setFont(new Font("Arial", Font.PLAIN, 20));
            nuevoCampo.setText(text);
            nuevoCampo.setCaretPosition(0); // si tiene texto el puntero en el caracter inicial, se usa al cargar
            /*
            * Funciones del input:
            * Al hacer clic DERECHO en el campo, copia el texto si no está vacío
            * Al hacer clic IZQUIERDO en el campo, pega el texto si está vacío
            */
            nuevoCampo.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    // Clic izquierdo 
                    if (evt.getButton() == java.awt.event.MouseEvent.BUTTON1) {
                        String texto = nuevoCampo.getText();
                        if (!texto.isEmpty()) {
                            java.awt.datatransfer.StringSelection seleccion = new java.awt.datatransfer.StringSelection(texto);
                            java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(seleccion, null);
                        }
                    }
                    // Clic derecho 
                    if (evt.getButton() == java.awt.event.MouseEvent.BUTTON3) {
                        if (nuevoCampo.getText().isEmpty()) {
                            try {
                                java.awt.datatransfer.Clipboard clipboard = java.awt.Toolkit.getDefaultToolkit().getSystemClipboard();
                                String textoPegado = (String) clipboard.getData(java.awt.datatransfer.DataFlavor.stringFlavor);
                                nuevoCampo.setText(textoPegado);
                            } catch (HeadlessException | UnsupportedFlavorException | IOException ex) {
                                //ex.printStackTrace();
                            }
                        }
                    }
                }
            });
            return nuevoCampo;
    }
    
    
    public JButton element_jButtonDel(){
            // Botón DEL que vacía el campo
            JButton botonDel = new JButton("x");
            //botonDel.setPreferredSize(new java.awt.Dimension(30, 30));
            //botonDel.setMaximumSize(new java.awt.Dimension(30, 30));
            //botonDel.setMinimumSize(new java.awt.Dimension(30, 30));
            //botonDel.setFont(new Font("Arial", Font.BOLD, 16));
            //botonDel.setBorder(new LineBorder(Color.RED, 2)); // Borde rojo de 2 píxeles
            
            // Función del botón 
            botonDel.addActionListener((java.awt.event.ActionEvent e) -> {
                nuevoCampo.setText("");
            });
            return botonDel;
    }
    
    
    
    
    
}