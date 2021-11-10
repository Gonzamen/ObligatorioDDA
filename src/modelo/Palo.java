/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gonza
 */
public class Palo implements Comparable<Palo>{
    private String nombre;
    private int valor;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getvalor() {
        return valor;
    }

    public void setvalor(int valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Palo o) {
        if(this.valor > o.getvalor()){
            return 1;
        }else if(this.valor < o.getvalor()){
            return -1;
        }else{
            return 0;
        }
    }  
}
