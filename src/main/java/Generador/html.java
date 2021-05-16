/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generador;

import com.hp.gagawa.java.Node;
import com.hp.gagawa.java.elements.Body;
import com.hp.gagawa.java.elements.Br;
import com.hp.gagawa.java.elements.Button;
import com.hp.gagawa.java.elements.Div;
import com.hp.gagawa.java.elements.H1;
import com.hp.gagawa.java.elements.Head;
import com.hp.gagawa.java.elements.Html;
import com.hp.gagawa.java.elements.Img;
import com.hp.gagawa.java.elements.Input;
import com.hp.gagawa.java.elements.Link;
import com.hp.gagawa.java.elements.Option;
import com.hp.gagawa.java.elements.P;
import com.hp.gagawa.java.elements.Select;
import com.hp.gagawa.java.elements.Span;
import com.hp.gagawa.java.elements.Textarea;
import com.hp.gagawa.java.elements.Title;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        Html archivo = new Html();
        List<Node> nodos = new ArrayList<>();
        Head cabeza = new Head();
        Title titulo = new Title();
        titulo.appendText("EL TITULO");
        cabeza.appendChild(titulo);
        nodos.add(cabeza);
        H1 nuevo = new H1();
        nuevo.appendText("este es uno h1");
        nuevo.setStyle("font-size:15px");
        nuevo.setStyle("font-size:20px");
        H1 nuevo2 = new H1();
        nuevo2.appendText("este es dos h1");
        H1 nuevo3 = new H1();
        nuevo3.appendText("este es tres h1");
        H1 nuevo4 = new H1();
        nuevo4.appendText("este es cuatro h1");
        System.out.println(nuevo4.write());
        nodos.add(nuevo);
        nodos.add(nuevo2);
        nodos.add(nuevo3);
        nodos.add(nuevo4);
        archivo.appendChild(nodos);
        System.out.println(archivo.write());
    }

    public H1 parametros_h1(H1 h1, ArrayList<String> valores, String texto) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                h1.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                h1.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                h1.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                h1.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("color:")) {
                h1.setStyle(valores.get(i));
            }
        }
        h1.appendText(texto);
        return h1;
    }

    public Span parametros_spam(Span spam, ArrayList<String> valores, String texto) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                spam.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                spam.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                spam.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                spam.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("color:")) {
                spam.setStyle(valores.get(i));
            }
        }
        spam.appendText(texto);
        return spam;
    }

    public P parametros_p(P p, ArrayList<String> valores, String texto) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                p.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                p.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                p.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                p.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("color:")) {
                p.setStyle(valores.get(i));
            }
        }
        p.appendText(texto);
        return p;
    }

    public Img parametros_img(Img img, ArrayList<String> valores) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("src=")) {
                img.setSrc(valores.get(i).substring(4, valores.get(i).length()));
            } else if (valores.get(i).contains("alt=")) {
                img.setAlt(valores.get(i).substring(4, valores.get(i).length()));
            } else if (valores.get(i).contains("id=")) {
                img.setId(valores.get(i).substring(4, valores.get(i).length()));
            } else if (valores.get(i).contains("height=")) {
                img.setHeight(valores.get(i).substring(4, valores.get(i).length()));
            } else if (valores.get(i).contains("width=")) {
                img.setWidth(valores.get(i).substring(4, valores.get(i).length()));
            }
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

    public Button parametros_button(Button boton, ArrayList<String> valores, String texto) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                boton.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                boton.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                boton.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                boton.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("color:")) {
                boton.setStyle(valores.get(i));
            } else if (valores.get(i).contains("background-color:")) {
                boton.setStyle(valores.get(i));
            } else if (valores.get(i).contains("onclick=")) {
                boton.setAttribute("onclick", valores.get(i).substring(8, valores.get(i).length()));
            }
        }
        boton.appendText(texto);
        return boton;
    }
    
     public Select parametros_select(Select select, ArrayList<String> valores, List<Node> opciones) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                select.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                select.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                select.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                select.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("color:")) {
                select.setStyle(valores.get(i));
            }
        }
        select.appendChild(opciones);
        return select;
    }

    public Br param_br() {
        return new Br();
    }

    public Body parametros_body(Body body, String bg) {
        body.setStyle("background: " + bg + ";");
        return body;
    }

    public Input parametros_input(Input input, ArrayList<String> valores) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                input.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                input.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                input.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                input.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("color:")) {
                input.setStyle(valores.get(i));
            } else if (valores.get(i).contains("type=")) {
                input.setType(valores.get(i).substring(5, valores.get(i).length()));
            }
        }
        return input;
    }

    public Textarea parametros_textarea(Textarea txta, ArrayList<String> valores) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                txta.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                txta.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                txta.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                txta.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("cols=")) {
                txta.setCols(valores.get(i).substring(5, valores.get(i).length()));
            }else if (valores.get(i).contains("rows=")) {
                txta.setRows(valores.get(i).substring(5, valores.get(i).length()));
            }
        }
        return txta;
    }

    public Div parametros_div(Div div, ArrayList<String> valores, List<Node> comp) {
        for (int i = 0; i < valores.size(); i++) {
            if (valores.get(i).contains("font-family:")) {
                div.setStyle(valores.get(i));
            } else if (valores.get(i).contains("font-size:")) {
                div.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                div.setStyle(valores.get(i));
            } else if (valores.get(i).contains("text-align:")) {
                div.setStyle(valores.get(i));
            } else if (valores.get(i).contains("id=")) {
                div.setId(valores.get(i).substring(3, valores.get(i).length()));
            } else if (valores.get(i).contains("class=")) {
                div.setCSSClass(valores.get(i).substring(6, valores.get(i).length()));
            } else if (valores.get(i).contains("color:")) {
                div.setStyle(valores.get(i));
            } else if (valores.get(i).contains("background-color:")) {
                div.setStyle(valores.get(i));
            }  
        }
        div.appendChild(comp);
        return div;
    }
}
