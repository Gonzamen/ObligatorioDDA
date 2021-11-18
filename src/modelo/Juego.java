/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import observador.Observable;

/**
 *
 * @author gonza
 */
public class Juego extends Observable {

    public enum Eventos {
        retirarJugador, actualizarPozo, juegoTerminado};

    private ArrayList<Participacion> jugadores = new ArrayList();
    private ArrayList<Mano> mano = new ArrayList();
    private int luz;
    private int jugadoresMax;
    private boolean iniciado = false;
    private Date fechaInicio;

    public Juego(int luz,int jugadoresMax) {
        this.fechaInicio = new Date();
        this.luz = luz;
        this.jugadoresMax = jugadoresMax;
        generarMano();
    }
    
    private String getFecha(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        return sdf.format(this.fechaInicio);
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
        mano.add(new Mano((luz * jugadores.size()) + pozoAnterior, this.jugadores));
        avisar(Eventos.actualizarPozo);
    }

    public void retirarParticipante(Participacion jugador) {
        jugadores.remove(jugador);
        avisar(Eventos.retirarJugador);
        if(jugadores.size() == 1){
            avisar(Eventos.juegoTerminado);
        }
    }

    public int getLuz() {
        return luz;
    }
    

    public int getTotalApostado() {
        int apostado = 0;
        for (Mano m : this.getManos()) {
            apostado += m.getPozo();
        }
        return apostado;
    }

}
