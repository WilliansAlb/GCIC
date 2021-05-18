/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.Random;

/**
 *
 * @author willi
 */
public class Variable {

    public final int INT = 0;
    public final int STRING = 1;
    public final int DECIMAL = 2;
    public final int CHAR = 3;
    public final int BOOLEAN = 4;
    public final int ERROR = 5;
    public final int ERROR0 = 6;
    private int posicion;
    private String id;
    private int tipo;
    private Object valor;
    private String modo;
    private String metodo;
    private int ejecucion;

    public Variable() {
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public int getEjecucion() {
        return ejecucion;
    }

    public void setEjecucion(int ejecucion) {
        this.ejecucion = ejecucion;
    }
    
    @Override
    public String toString(){
        switch(tipo){
            case INT:
                return "integer";
            case STRING:
                return "string";
            case DECIMAL:
                return "decimal";
            case CHAR:
                return "char";
            case BOOLEAN:
                return "boolean";
            case ERROR:
                return "error";
            case ERROR0:
                return "error";
            default:
                return "error inesperado";
        }
    }
    
    public void setValorNull(int c){
        switch(c){
            case INT:
                setValor(0);
                break;
            case STRING:
                setValor("");
                break;
            case DECIMAL:
                setValor((double)0.0);
                break;
            case CHAR:
                setValor(' ');
                break;
            case BOOLEAN:
                setValor(false);
                break;
            default:
                setValor("");
                break;
        }
    }

    public void asc(String palabra) {
        if (palabra.contains("ERROR:")) {
            setTipo(ERROR);
            setValor(palabra.substring(6, palabra.length()));
        } else {
            int[] arreglo = new int[palabra.length()];
            for (int i = 0; i < palabra.length(); i++) {
                arreglo[i] = (int) palabra.charAt(i);
            }
            for (int i = 0; i < palabra.length() - 1; i++) {
                for (int j = 0; j < palabra.length() - i - 1; j++) {
                    if (arreglo[j + 1] < arreglo[j]) {
                        int temp = arreglo[j + 1];
                        arreglo[j + 1] = arreglo[j];
                        arreglo[j] = temp;
                    }
                }
            }
            String res = "";
            for (int i = 0; i < arreglo.length; i++) {
                res += (char) arreglo[i];
            }
            setTipo(STRING);
            setValor(res);
        }
    }

    public void desc(String palabra) {
        if (palabra.contains("ERROR:")) {
            setTipo(ERROR);
            setValor(palabra.substring(6, palabra.length()));
        } else {
            asc(palabra);
            String desc = (String) getValor();
            palabra = "";
            for (int i = desc.length() - 1; i >= 0; i--) {
                palabra += desc.charAt(i);
            }
            setTipo(STRING);
            setValor(palabra);
        }
    }

    public void reverse(String palabra) {
        if (palabra.contains("ERROR:")) {
            setTipo(ERROR);
            setValor(palabra.substring(6, palabra.length()));
        } else {
            String desc = "";
            for (int i = palabra.length() - 1; i >= 0; i--) {
                desc += palabra.charAt(i);
            }
            setTipo(STRING);
            setValor(desc);
        }
    }

    public void num_aleatorio() {
        Random n = new Random(System.currentTimeMillis());
        int generado = n.nextInt(10);
        setTipo(INT);
        setValor(generado);
    }

    public void char_aleatorio() {
        Random n = new Random(System.currentTimeMillis());
        int aleatorio1 = n.nextInt(2);
        int aleatorio2 = n.nextInt(25);
        char generado;
        if (aleatorio1 == 1) {
            generado = (char) (aleatorio2+65);
        } else {
            generado = (char) (aleatorio2+97);
        }
        setTipo(CHAR);
        setValor(generado);
    }

    public void letpar_num(String palabra) {
        if (palabra.contains("ERROR:")) {
            setTipo(ERROR);
            setValor(palabra.substring(6, palabra.length()));
        } else {
            String res = "";
            for (int i = 0; i < palabra.length(); i++) {
               if (i%2==0){
                   res += (int)palabra.charAt(i)+"";
               }
            }
            setTipo(STRING);
            setValor(res);
        }
    }
    public void letimpar_num(String palabra) {
        if (palabra.contains("ERROR:")) {
            setTipo(ERROR);
            setValor(palabra.substring(6, palabra.length()));
        } else {
            String res = "";
            for (int i = 0; i < palabra.length(); i++) {
               if (i%2!=0){
                   res += (int)palabra.charAt(i)+"";
               }
            }
            setTipo(STRING);
            setValor(res);
        }
    }
}
