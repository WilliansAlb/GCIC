/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generador;

import com.hp.gagawa.java.elements.*;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author willi
 */
public class html {

    public html() {

    }

    public void generar() {

    }

    public static void main(String[] args) {
    }

    public H1 parametros_h1(H1 h1, HashMap<String, String> parametros, String texto) {
        if (parametros.containsKey("fts")) {
            h1.setStyle("font-size: "+parametros.get("fts")+";");
        }
        if (parametros.containsKey("ftf")) {
            h1.setStyle("font-family: "+parametros.get("ftf")+";");
        }
        if (parametros.containsKey("txta")) {
            h1.setStyle("text-align: "+parametros.get("txta")+";");
        }
        if (parametros.containsKey("id")) {
            h1.setId(parametros.get("id"));
        }
        if (parametros.containsKey("color")) {
            h1.setStyle("color: "+parametros.get("color")+";");
        }
        h1.appendText(texto);
        return h1;
    }
    
    public Span parametros_spam(Span spam, HashMap<String, String> parametros, String texto) {
        if (parametros.containsKey("fts")) {
            spam.setStyle("font-size: "+parametros.get("fts")+";");
        }
        if (parametros.containsKey("ftf")) {
            spam.setStyle("font-family: "+parametros.get("ftf")+";");
        }
        if (parametros.containsKey("txta")) {
            spam.setStyle("text-align: "+parametros.get("txta")+";");
        }
        if (parametros.containsKey("id")) {
            spam.setId(parametros.get("id"));
        }
        if (parametros.containsKey("color")) {
            spam.setStyle("color: "+parametros.get("color")+";");
        }
        spam.appendText(texto);
        return spam;
    }
    
    public P parametros_p(P parrafo, HashMap<String, String> parametros, String texto) {
        if (parametros.containsKey("fts")) {
            parrafo.setStyle("font-size: "+parametros.get("fts")+";");
        }
        if (parametros.containsKey("ftf")) {
            parrafo.setStyle("font-family: "+parametros.get("ftf")+";");
        }
        if (parametros.containsKey("txta")) {
            parrafo.setStyle("text-align: "+parametros.get("txta")+";");
        }
        if (parametros.containsKey("id")) {
            parrafo.setId(parametros.get("id"));
        }
        if (parametros.containsKey("color")) {
            parrafo.setStyle("color: "+parametros.get("color")+";");
        }
        parrafo.appendText(texto);
        return parrafo;
    }
    
    public Img parametros_img(Img img, HashMap<String, String> parametros) {
        if (parametros.containsKey("src")) {
            img.setSrc(parametros.get("src"));
        }
        if (parametros.containsKey("alt")) {
            img.setAlt(parametros.get("height"));
        }
        if (parametros.containsKey("width")) {
            img.setWidth(parametros.get("width"));
        }
        if (parametros.containsKey("id")) {
            img.setId(parametros.get("id"));
        }
        if (parametros.containsKey("height")) {
            img.setHeight(parametros.get("height"));
        }
        return img;
    }
    
    public Link parametros_link(Link link, String url) {
        link.setHref(url);
        return link;
    }
    
    public Title parametros_titulo(Title titulo, String texto) {
        titulo.appendText(texto);
        return titulo;
    }
    
    public Button parametros_button(Button boton, HashMap<String, String> parametros, String texto){
        if (parametros.containsKey("fts")) {
            boton.setStyle("font-size: "+parametros.get("fts")+";");
        }
        if (parametros.containsKey("ftf")) {
            boton.setStyle("font-family: "+parametros.get("ftf")+";");
        }
        if (parametros.containsKey("txta")) {
            boton.setStyle("text-align: "+parametros.get("txta")+";");
        }
        if (parametros.containsKey("id")) {
            boton.setId(parametros.get("id"));
        }
        if (parametros.containsKey("color")) {
            boton.setStyle("color: "+parametros.get("color")+";");
        }
        if (parametros.containsKey("bg")) {
            boton.setStyle("background: "+parametros.get("bg")+";");
        }
        if (parametros.containsKey("onclick")) {
            boton.setAttribute("onclick", parametros.get("onclick"));
        }
        boton.appendText(texto);
        return boton;
    }
    
    public Br param_br(){
        return new Br();
    }
    
    public Body parametros_body(Body body, String bg){
        body.setStyle("background: "+bg+";");
        return body;
    }
    
    public Input parametros_input(Input in, HashMap<String, String> parametros){
        if (parametros.containsKey("fts")) {
            in.setStyle("font-size: "+parametros.get("fts")+";");
        }
        if (parametros.containsKey("ftf")) {
            in.setStyle("font-family: "+parametros.get("ftf")+";");
        }
        if (parametros.containsKey("txta")) {
            in.setStyle("text-align: "+parametros.get("txta")+";");
        }
        if (parametros.containsKey("id")) {
            in.setId(parametros.get("id"));
        }
        if (parametros.containsKey("color")) {
            in.setStyle("color: "+parametros.get("color")+";");
        }
        if (parametros.containsKey("type")) {
            in.setType(parametros.get("type"));
        }
        return in;
    }
    
    public Textarea parametros_textarea(Textarea txt ,HashMap<String, String> parametros){
        if (parametros.containsKey("fts")) {
            txt.setStyle("font-size: "+parametros.get("fts")+";");
        }
        if (parametros.containsKey("ftf")) {
            txt.setStyle("font-family: "+parametros.get("ftf")+";");
        }
        if (parametros.containsKey("txta")) {
            txt.setStyle("text-align: "+parametros.get("txta")+";");
        }
        if (parametros.containsKey("id")) {
            txt.setId(parametros.get("id"));
        }
        if (parametros.containsKey("cols")) {
            txt.setCols(parametros.get("cols"));
        }
        if (parametros.containsKey("rows")) {
            txt.setRows(parametros.get("rows"));
        }
        return txt;
    }
    
    public Div parametros_textarea(Div div ,HashMap<String, String> parametros){
        if (parametros.containsKey("fts")) {
            div.setStyle("font-size: "+parametros.get("fts")+";");
        }
        if (parametros.containsKey("ftf")) {
            div.setStyle("font-family: "+parametros.get("ftf")+";");
        }
        if (parametros.containsKey("txta")) {
            div.setStyle("text-align: "+parametros.get("txta")+";");
        }
        if (parametros.containsKey("id")) {
            div.setId(parametros.get("id"));
        }
        if (parametros.containsKey("class")) {
            div.setAttribute("class", parametros.get("class"));
        }
        if (parametros.containsKey("color")) {
            div.setStyle("color: "+parametros.get("color")+";");
        }
        if (parametros.containsKey("bg")) {
            div.setStyle("background: "+parametros.get("bg")+";");
        }
        return div;
    }
}
