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
public class Figura implements Comparable<Figura> {

    private String nombre;
    private String definicion;
    private int valor;

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
        if (this == null && o!=null) {
            return -1;
        } else if (o == null && this!=null) {
            return 1;
        } else {
            if (this.valor > o.getValor()) {
                return 1;
            } else if (this.valor < o.getValor()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
