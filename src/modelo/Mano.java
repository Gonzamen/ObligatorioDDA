/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
import observador.Observable;

/**
 *
 * @author gonza
 */
public class Mano extends Observable {

    public enum Eventos {
        actualizarPozo, finalizaMano, seApuesta
    };

    private double pozo;
    private double apuesta;
    private Participacion ganador = null;
    private ArrayList<Participacion> participantes = new ArrayList();
    private Mazo mazo = new Mazo();
    private Juego juego;

    public Mano(double luz, ArrayList<Participacion> participantes) {
        this.pozo = luz;
        this.participantes = participantes;
        cargarMano();
    }

    public Mano() {
    }

    public void iniciarMano(Juego jue) {
        this.juego = jue;
        this.pozo = jue.getLuz() * participantes.size();
        avisar(Eventos.actualizarPozo);
        this.juego.setearIniciado();
        cargarMano();
    }

    public void agregarParticipante(Participacion p) {
        participantes.add(p);
    }

    public double getPozo() {
        return pozo;
    }

    public void setPozo(double pozo) {
        this.pozo = pozo;
        avisar(Eventos.actualizarPozo);
    }

    public Participacion getGanador() {
        return ganador;
    }

    public void setGanador(Participacion ganador) {
        this.ganador = ganador;
    }

    public double getApuesta() {
        return apuesta;
    }
   

    public Mazo getMazo() {
        return mazo;
    }

    public ArrayList<Participacion> getParticipantes() {
        return participantes;
    }

    public void barajarMazo() {
        mazo.barajar();
    }


    public void setearFiguras() {
        for (Participacion p : participantes) {
            p.setFigura();
        }
    }

    public void repartirCartas() {
        for (Participacion p : this.participantes) {
            p.setCartasJugador(this.mazo.darCartas(5));
        }
    }

    public boolean apostar(Participacion participante, double monto) {
        if (participante.getSaldoJugador() >= monto) {
            participante.apostar(monto);
            participante.setParticipa();
            this.pozo += monto;
            this.apuesta = monto;
            avisar(Eventos.actualizarPozo);
            avisar(Eventos.seApuesta);
            avisar(Juego.Eventos.seActualiza);
            return true;
        } else {
            return false;
        }
    }

    public void igualarApuesta(Participacion participante, double monto) {
        participante.setParticipa();
        if (monto == 0) {
            participante.setpasaApuesta();
        } else {
            participante.apostar(monto);
            participante.setParticipa();
            this.pozo += monto;
            avisar(Eventos.actualizarPozo);
            avisar(Eventos.seApuesta);
            avisar(Juego.Eventos.seActualiza);
        }
    }

    public Participacion ganadorMano() {
        Participacion ganador = null;
        ArrayList<Participacion> todos = new ArrayList(this.participantes);
        for (Participacion p : todos) {
            if (p.getpasaApuesta() == true) {
                this.participantes.remove(p);
            }
        }
        if (participantes.size() >= 1) {
            Collections.sort(participantes);
            for(int i = 0; i <participantes.size();i++){
                participantes.get(i).getJugador().setTotalGanado(0);
            }
            this.setGanador(participantes.get(participantes.size() - 1));
            ganador = this.ganador;
            ganador.setPozoJugador(pozo);
            ganador.getJugador().setTotalGanado(pozo);
            this.pozo = 0;
            juego.nuevaMano(this.pozo);
        } else {
            this.ganador = null;
            juego.nuevaMano(this.pozo);
        }
        avisar(Eventos.finalizaMano);
        return ganador;
    }

    private void cargarMano() {
        for (Participacion p : this.participantes) {
            p.vaciarCartas();
            p.setearBooleanos();   
        }
        this.ganador = null;
        this.barajarMazo();
        this.repartirCartas();
        this.setearFiguras();
        
    }
}
