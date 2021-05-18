/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author willi
 */
public class Captcha {
    private String id;
    private String nombre;
    private int veces;
    private int aciertos;
    private int fallos;
    private String fecha;
    private String url;
    private String titulo;

    public Captcha(String id, String nombre, int veces, int aciertos, int fallos, String fecha, String url, String titulo) {
        this.id = id;
        this.nombre = nombre;
        this.veces = veces;
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.fecha = fecha;
        this.url = url;
        this.titulo = titulo;
    }

    public Captcha() {
    }

    
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVeces() {
        return veces;
    }

    public void setVeces(int veces) {
        this.veces = veces;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    public int getFallos() {
        return fallos;
    }

    public void setFallos(int fallos) {
        this.fallos = fallos;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
