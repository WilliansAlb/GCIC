/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Analizador.Lexer;
import Analizador.LexerDB;
import Analizador.Parser;
import Analizador.ParserDB;
import Controladores.Tabla;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

/**
 *
 * @author willi
 */
public class Tests {

    public static void main(String[] args) throws FileNotFoundException {
        prueba_sin();
        //prueba_asc("probandoz");
    }

    public static void prueba_sin() throws FileNotFoundException { 
        Path rutaSym = Paths.get("C:/Users/willi/OneDrive/Escritorio/[txts]/gcic2.txt");
        File nuevo = new File("C:/Users/willi/OneDrive/Escritorio/[txts]/gcic.txt");
        //prueba_lex();
        Parser par = new Parser(new Lexer(new FileReader(nuevo)));
        try {
            par.parse();
            System.out.println("no se");
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
    }
    
    public static void prueba_sinDB() throws FileNotFoundException {
        File nuevo = new File("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/GCIC/src/main/java/Pages/indice.txt");
        //prueba_lex();
        ParserDB par = new ParserDB(new LexerDB(new FileReader(nuevo)));
        try {
            par.parse();
            for (int i = 0; i < par.listado.size(); i++) {
                System.out.println(par.listado.get(i).getId());
            }
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
    }
    
    public static void prueba_lex() throws FileNotFoundException { 
        
        File nuevo = new File("C:/Users/willi/OneDrive/Escritorio/[txts]/gcic.txt");
        Lexer le = new Lexer(new FileReader(nuevo));
        while(true){
            try {
                Symbol t = le.next_token();
                if (t.value==null){
                    break;
                } else {
                    System.out.println(t.value.toString());
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Tests.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void prueba_asc(String vuelta) throws FileNotFoundException { 
        Tabla t = new Tabla();
        t.asc(vuelta);
    }
}
