/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gonza
 */
public class Mazo {

    private ArrayList<Carta> cartas = new ArrayList();

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    public void setCartas(ArrayList<Carta> cartas){
        this.cartas = cartas;
    }
    
}
