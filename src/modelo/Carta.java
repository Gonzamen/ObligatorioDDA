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
public class Carta {

    private int numero;
    private Palo palo;

    public Carta(int numero, Palo palo) {
        this.numero = numero;
        this.palo = palo;
    }

    public Carta() {
    }

    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        switch (this.numero) {
            case 11:
                return "J" + this.palo.getNombre().charAt(0) + ".gif";
            case 12:
                return "Q" + this.palo.getNombre().charAt(0) + ".gif";
            case 13:
                return "K" + this.palo.getNombre().charAt(0) + ".gif";
            case 14:
                return "A" + this.palo.getNombre().charAt(0) + ".gif";
            default:
                return this.numero + ""+this.palo.getNombre().charAt(0) + ".gif";
        }
    }

}
