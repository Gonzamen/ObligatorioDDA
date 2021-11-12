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
    
    public int getNumero() {
        return numero;
    }

    public Palo getPalo() {
        return palo;
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }
    
}
