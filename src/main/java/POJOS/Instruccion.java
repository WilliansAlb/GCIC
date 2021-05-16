/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import com.hp.gagawa.java.Node;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author willi
 */
public class Instruccion {
    
    private String tipo;
    private HashMap<String,Object> variables;
    private List<Node> etiquetas;
    
    public Instruccion() {
        
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public HashMap<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(HashMap<String, Object> variables) {
        this.variables = variables;
    }

    public List<Node> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Node> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
