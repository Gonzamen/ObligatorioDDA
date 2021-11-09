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
    private Palo palo = new Palo(); 

    public int getNumero() {
        return numero;
    }

    public String getPalo() {
        return palo.getNombre();
    }

    public void setPalo(Palo palo) {
        this.palo = palo;
    }
    
}
