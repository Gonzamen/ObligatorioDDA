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
    private ArrayList<Mano> mano = new ArrayList();
    private int luz = 5;
    private boolean iniciado = false;

    public Juego() {
        this.iniciado = true;
    }

    public boolean getIniciado() {
        return iniciado;
    }
       
    
    public ArrayList<Participacion> getJugadores() {
        return jugadores;
    }

    public boolean agregarJugador(Participacion jugador) {
        if(jugador.getSaldoJugador()>=this.luz){
            return jugadores.add(jugador);        
        }
        return false;
    }

    public ArrayList<Mano> getManos() {
        return mano;
    }
    
    public void generarMano(double pozoAnterior){
        for(Participacion p : this.jugadores){
            if(p.getSaldoJugador()<this.luz){
                retirarParticipante(p);
            }
        }
        mano.add(new Mano(luz*jugadores.size()+pozoAnterior,this.jugadores));
    }
    
    
    
    public boolean retirarParticipante(Participacion jugador){
        return jugadores.remove(jugador);
    }

    public int getLuz() {
        return luz;
    }
    
    
}
