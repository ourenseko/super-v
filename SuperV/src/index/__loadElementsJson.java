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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Manuel Garcia Baceiredo
 * @version 1.1.20250611
 * 
 */

public class __loadElementsJson {
    
    
    /* 
    * error crea una nueva instancia y lo que se necesita es hacer referencia a la que ya existe
    * Parfa referirse a la propia instancia inicio() usar this 
    * __loadElementsJson file = new __loadElementsJson(this); file.read(target);
    *
    * inicio desing = new index.inicio(); //error encapsulamiento private
    * 
    * 
    */
    private final inicio desing;
    
    public __loadElementsJson(inicio ventanaActual) {
        this.desing = ventanaActual;
    }
    
    traducciones text = new traducciones();
    
    public void open() {
        
        //Buscamos el archivo con el Filechooser proporcionado por Java
        String directorioActual = System.getProperty("user.dir");
        JFileChooser fileChooser = new JFileChooser(directorioActual);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JSON (*.json)", "json"));
        int resultado = fileChooser.showOpenDialog(null); // null = ventana padre, o pon tu JFrame
        
        String target = null;
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            target =  archivoSeleccionado.getAbsolutePath();
            
            // aquí puedes usar archivoSeleccionado para abrir o leer
            //__loadElementsJson file = new __loadElementsJson(this);
            // AQUI CARGAMOS EL JSON Y LO DIBUJAMOS
            //file.read(target);
            read(target);
            
        }
    
        //Actualizamos donde se guardan los cambios
        desing.setRutaArchivo(target);
        System.out.println(">>> "+desing.getRutaArchivo());
        
    }
    
    
    
    public void read(String rutaArchivo) {
        try (BufferedReader reader = 
                new BufferedReader(
                    new InputStreamReader(
                        new FileInputStream(rutaArchivo), StandardCharsets.UTF_8
                    )
                )
            )
        {
                StringBuilder sb = new StringBuilder();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    sb.append(linea);
                }

                JSONObject json = new JSONObject(sb.toString());
                JSONArray jsonArray = json.getJSONArray("memo");

                // Primero, limpiar el panel para cargar los campos
                desing._limpiarContenedorW();
                
                                
                for (int i = 0; i < jsonArray.length(); i++) {
                    // cargamos una x una linea de texto 
                    String texto = jsonArray.getString(i); 
                    new __elementsDynamic(desing).elementNewRow(texto);
                }
                desing._actualizarContenedor();
                

                //Actualizamos donde se guardarán ahora los cambios
                desing.setRutaArchivo(rutaArchivo);
                
                
            } catch (Exception e) {
               //e.printStackTrace();
                JOptionPane.showMessageDialog(null, text.error_loadFile);
            }
    }
    
}
