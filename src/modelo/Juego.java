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
public class Juego {
    private ArrayList<Participacion> jugadores = new ArrayList();
    private Mano mano;
    private int luz = 5;

    public Juego() {
        this.mano = new Mano(luz*jugadores.size());
    }
    
    public ArrayList<Participacion> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Participacion> jugadores) {
        this.jugadores = jugadores;
    }

    public Mano getManos() {
        return mano;
    }

    public void setManos(Mano mano) {
        this.mano = mano;
    }
    
    public void verificarSaldoJugadores(){
        
    }
    
    public void retirarParticipante(){
        
    }
}
