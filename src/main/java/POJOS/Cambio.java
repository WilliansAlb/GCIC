/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.ArrayList;

/**
 *
 * @author willi
 */
public class Cambio {
    private String id;
    private int metodo;
    private Object viejo;
    private Object nuevo;

    public Cambio(String id, int metodo, Object viejo, Object nuevo) {
        this.id = id;
        this.metodo = metodo;
        this.viejo = viejo;
        this.nuevo = nuevo;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMetodo() {
        return metodo;
    }

    public void setMetodo(int metodo) {
        this.metodo = metodo;
    }

    public Object getViejo() {
        return viejo;
    }

    public void setViejo(Object viejo) {
        this.viejo = viejo;
    }

    public Object getNuevo() {
        return nuevo;
    }

    public void setNuevo(Object nuevo) {
        this.nuevo = nuevo;
    }
    
    
    
}
