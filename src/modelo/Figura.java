/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author gonza
 */
public abstract class Figura implements Comparable<Figura> {

    protected String nombre;
    protected String definicion;
    protected static int valor;

    public Figura() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public int compareTo(Figura o) {
        if (this.valor < o.getValor()) {
            return 1;
        } else if (this.valor > o.getValor()) {
            return -1;
        } else {
            return this.desempatar(o);
        }
    }

    public abstract Figura definirme(ArrayList<Carta> cartas);
    
    public abstract int desempatar(Figura o);
}
