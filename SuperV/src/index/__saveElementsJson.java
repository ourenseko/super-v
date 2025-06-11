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

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Manuel Garcia Baceiredo
 * @version 1.1.20250611
 * 
 */

    /** 
   * ESTA CLASE ES PARA GUARDAR LAS MEMORIAS ESCRITAS EN FORMATO JSON.
   **/

public class __saveElementsJson {
    
    private final inicio desing;
    
    /**
     * CONSTRUCTOR PARA RECIBIR LA INSTANCIA INICIO().
     * @param ventanaActual 
     */
    public __saveElementsJson(inicio ventanaActual) {
        this.desing = ventanaActual;
    }
    
    traducciones text = new traducciones();

    /**
     * GUARDA EN UN ARCHIVO DADO CON FORMATO JSON, FUERZA LA EXTENSIÓN .JSON
     * @param archivoGuardar
     */
    public void save(String archivoGuardar) {
        
        /*
        if (archivoGuardar.isEmpty()){
            archivoGuardar= desing.getRutaArchivo();
        }
        */
        
        JSONArray jsonArray = new JSONArray();

        for (int i = 0; i < desing.getjPanelContenedor().getComponentCount(); i++) {
                JPanel fila = (JPanel) desing.getjPanelContenedor().getComponent(i);
                // el primer componente (0) es jButton, el segundo (1) JTextField
                JTextField campo = (JTextField) fila.getComponent(1); 
                String texto = campo.getText();
                jsonArray.put(texto);
        }

        JSONObject json = new JSONObject();
        json.put("memo", jsonArray);

        try (FileWriter file = new FileWriter(archivoGuardar)) {
                file.write(json.toString(4));  // indentación para legibilidad
                file.flush();
                
                
            //Actualizamos donde se guardan los cambios
            desing.setRutaArchivo(archivoGuardar);
            System.out.println(">>> "+desing.getRutaArchivo());
                
                JOptionPane.showMessageDialog(null, new traducciones().fx_savedAs+archivoGuardar);
                
        } catch (Exception e) {
                //e.printStackTrace();
                JOptionPane.showMessageDialog(null, new traducciones().error_fatal);
        }
        
        
    }
    
    
    /**
     * ABRE FILECHOOSER PARA CREAR EL NOMBRE Y LA RUTA DE UN NUEVO ARCHIVO.
     * 
     */
    public void saveAs() {
        
        String directorioActual = System.getProperty("user.dir");
        JFileChooser fileChooser = new JFileChooser(directorioActual);
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos de texto (*.txt)", "txt"));
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Archivos JSON (*.json)", "json"));
        int resultado = fileChooser.showSaveDialog(null);
        

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoGuardar = fileChooser.getSelectedFile();
            String target = archivoGuardar.getAbsolutePath();
            //System.out.println("Guardar en: " + archivoGuardar.getAbsolutePath());
            
            // aquí puedes guardar en archivoGuardar
            save(target);
        }
        
    }
     
}
