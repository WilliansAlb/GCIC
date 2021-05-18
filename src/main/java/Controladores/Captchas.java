/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Analizador.Lexer;
import Analizador.LexerDB;
import Analizador.Parser;
import Analizador.ParserDB;
import POJOS.Captcha;
import POJOS.Errores;
import com.hp.gagawa.java.elements.Body;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Captchas {

    public static final int ERROR = -1;
    public static final int REPETIDO = 0;
    public static final int CORRECTO = 1;
    public ArrayList<Captcha> captchas = new ArrayList<>();
    public ArrayList<Errores> errores = new ArrayList<>();
    public Captcha retorno;
    public Body cuerpo;

    public Captchas() {

    }

    public int analizar_texto(String texto) {
        Parser par = new Parser(new Lexer(new StringReader(texto)));
        int estado = ERROR;
        try {
            par.parse();
            estado = CORRECTO;
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
        return estado;
    }

    public int analizar() throws FileNotFoundException {
        int estado = ERROR;
        File nuevo = new File("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/GCIC/src/main/java/Pages/temporal2.txt");
        Parser par = new Parser(new Lexer(new FileReader(nuevo)));
        try {
            par.parse();
            if (par.errores.isEmpty()) {
                retorno = new Captcha(par.id_cap, par.nombre_cap, 0, 0, 0, "No se ha utilizado", par.url_cap, par.titulo_cap);
                cuerpo = par.cuerpo;
                estado = CORRECTO;
            } else {
                estado = ERROR;
                errores = par.errores;
            }
        } catch (Exception ex) {
            System.out.println("Error por: " + ex.toString());
        }
        return estado;
    }

    public ArrayList<Captcha> obtener_listado() throws FileNotFoundException {
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

    public void actualizar(Captcha agregar) throws FileNotFoundException {
        captchas = obtener_listado();
        captchas.add(agregar);
        actualizar_indice();
    }

    /**
     * Método que actualiza la base de datos de los captchas
     */
    public void actualizar_indice() throws FileNotFoundException {
        int res = ERROR;
        try (FileWriter fw = new FileWriter("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/GCIC/src/main/java/Pages/indice.txt", false);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw)) {
            out.println("BASE{");
            for (int i = 0; i < captchas.size(); i++) {
                out.println("[");
                out.println("\tCAPTCHA=" + captchas.get(i).getId() + "\\");
                out.println("\tNOMBRE=" + captchas.get(i).getNombre() + "\\");
                out.println("\tVECES=" + captchas.get(i).getVeces() + "\\");
                out.println("\tACIERTOS=" + captchas.get(i).getAciertos() + "\\");
                out.println("\tFALLOS=" + captchas.get(i).getFallos() + "\\");
                out.println("\tFECHA=" + captchas.get(i).getFecha() + "\\");
                out.println("\tURL=" + captchas.get(i).getUrl() + "\\");
                out.println("\tTITULO=" + captchas.get(i).getTitulo() + "\\");
                if (i == captchas.size() - 1) {
                    out.println("]");
                } else {
                    out.println("],");
                }
            }
            out.print("}");
        } catch (IOException e) {
            
        } finally {
            
        }
    }

    public int crear_temporal(String texto) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        int retorno = ERROR;
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/GCIC/src/main/java/Pages/temporal2.txt"), "UTF-8"))) {
            out.write(texto);
            retorno = CORRECTO;
        }
        return retorno;
    }

    public int crear_jsp(String texto, String id) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        int retorno = ERROR;
        String nuevo = "<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>";
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/GCIC/src/main/webapp/pages/generados/" + id + ".jsp"), "UTF-8"))) {
            out.write(nuevo + "\n" + texto);
            retorno = CORRECTO;
        } finally {
            return retorno;
        }
    }

    public int crear_temp(String texto) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        int retorno = ERROR;
        String nuevo = "<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>";
        try (Writer out = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("C:/Users/willi/OneDrive/Documentos/NetBeansProjects/GCIC/src/main/webapp/pages/generados/temp.jsp"), "UTF-8"))) {
            out.write(nuevo + "\n" + texto);
            retorno = CORRECTO;
        }
        return retorno;
    }

}
