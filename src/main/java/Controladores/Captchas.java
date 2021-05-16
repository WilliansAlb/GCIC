/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Analizador.LexerDB;
import Analizador.ParserDB;
import POJOS.Captcha;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Captchas {
    public Captchas(){
    
    }
    
    public ArrayList<Captcha> obtener_listado() throws FileNotFoundException{
        File nuevo = new File("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/GCIC/src/main/java/Pages/indice.txt");
        ArrayList<Captcha> retorno = new ArrayList<>();
        ParserDB par = new ParserDB(new LexerDB(new FileReader(nuevo)));
        try {
            par.parse();
            retorno = par.listado;
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
        return retorno;
    }
}
