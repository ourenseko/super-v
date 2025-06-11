/*
 * Copyright (C) 2025 Aaa
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

/**
 *
 * @author Manuel Garcia Baceiredo
 * @version 1.1.20250610
 * 
 */
public class traducciones {
    
    public void setLanguageBySystem() {
        String language = java.util.Locale.getDefault().getLanguage();
        if (language.equals("es")) {
            spanish();
        } else {
            english();
        }
    }
    
    String program_name = "SuperV";
    String program_version = "#v1.1.20250910";
    String menu_save;
    String menu_saveAs;
    String menu_openFile;
    String menu_new;
    String menu_repository;
    String desing_jText1;
    String desing_jButtonAdd;
    String desing_jButtonDel;
    String desing_;
    String error_fatal;
    String error_loadFile;
    String fx_savedAs;
    String fx_;
    
    
    

    public void spanish(){
        menu_save="Guardar";
        menu_saveAs="Guardar como...";
        menu_openFile="Abrir archivo...";
        menu_new="Nuevo";
        menu_repository="Repo";
        desing_jText1="Portapapeles";
        desing_jButtonAdd="+";
        desing_jButtonDel="x";
        error_fatal = "Fatal error.";
        error_loadFile="Fatal error, el archivo está dañado o es ilegible.";
        fx_savedAs = "Guardado con exito.\nRuta: ";
    }
    public void english(){
        menu_save="Save";
        menu_saveAs="Save as...";
        menu_openFile="Open file...";
        menu_new="New";
        menu_repository="About";
        desing_jText1="Clipboard";
        desing_jButtonAdd="+";
        desing_jButtonDel="x";
        error_fatal = "Fatal error.";
        error_loadFile="Fatal error, the file is corrupted or unreadable.";
        fx_savedAs = "Saved successfully.\nPath: ";
        
    }
    /*
    public void portuguese(){
        menu_save="";
        
    }
    public void russian(){
        menu_save="";
        
    }
    public void chinese(){
        menu_save="";
        
    }
    */
}
