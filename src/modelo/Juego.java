/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author gonza
 */
public class Juego extends Observable {

    private ArrayList<Participacion> jugadores = new ArrayList();
    private ArrayList<Mano> mano = new ArrayList();
    private int luz = 5;
    private int jugadoresMax = 3;
    private boolean iniciado = false;
    

    public Juego() {
        generarMano();
    }

    public boolean getIniciado() {
        return iniciado;
    }

    public void setearIniciado() {
        this.iniciado = true;
    }

    public int getJugadoresMax() {
        return jugadoresMax;
    }

    public void setJugadoresMax(int jugadoresMax) {
        this.jugadoresMax = jugadoresMax;
    }

    public ArrayList<Participacion> getJugadores() {
        return jugadores;
    }

    public void agregarJugador(Participacion jugador) {
        jugador.setJuego(this);
        jugadores.add(jugador);
        this.mano.get(0).agregarParticipante(jugador);
    }

    public ArrayList<Mano> getManos() {
        return mano;
    }

    public void generarMano() {
        mano.add(new Mano());
    }

    public void nuevaMano(double pozoAnterior) {
        for (Participacion p : this.jugadores) {
            if (p.getSaldoJugador() < this.luz) {
                retirarParticipante(p);
            }
        }
        mano.add(new Mano(luz * jugadores.size() + pozoAnterior, this.jugadores));
    }

    public boolean retirarParticipante(Participacion jugador) {
        return jugadores.remove(jugador);
    }

    public int getLuz() {
        return luz;
    }
    
    public int getTotalApostado(){
        int apostado=0;
        for(Mano m:this.getManos()){
            apostado+=m.getPozo();
        }
        return apostado;
    }

}
