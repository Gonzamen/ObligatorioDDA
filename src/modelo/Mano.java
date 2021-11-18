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
        actualizarPozo, nuevaMano, seApuesta, echarDeLaMano
    };

    private double pozo;
    private Participacion ganador = null;
    private ArrayList<Participacion> losQuePasaron = new ArrayList();
    private ArrayList<Participacion> participantes = new ArrayList();
    private Mazo mazo = new Mazo();
    private Juego juego;

    public Mano(double luz, ArrayList<Participacion> participantes) {
        this.pozo = this.pozo + luz;
        avisar(Eventos.actualizarPozo);
        this.participantes = participantes;
        cargarMano();
    }

    public Mano() {

    }

    public void iniciarMano(Juego jue) {
        this.juego = jue;
        this.pozo = jue.getLuz() * participantes.size();
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
    }

    public Participacion getGanador() {
        return ganador;
    }

    public void setGanador(Participacion ganador) {
        this.ganador = ganador;
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

    public ArrayList<Participacion> getLosQuePasaron() {
        return losQuePasaron;
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
        for (Participacion p : this.participantes) {
            if (p.getSaldoJugador() < monto) {
                return false;
            }
        }
        participante.apostar(monto);
        participante.setNoApuesta(true);
        this.pozo += monto;
        avisar(Eventos.actualizarPozo);
        avisar(Eventos.seApuesta);
        return true;
    }

    public void igualarApuesta(Participacion participante, double monto) {
        if (monto == 0) {
            this.losQuePasaron.add(participante);
            avisar(Eventos.echarDeLaMano);
        } else {
            participante.apostar(monto);
            participante.setNoApuesta(true);
            this.pozo += monto;
            avisar(Eventos.actualizarPozo);
            avisar(Eventos.seApuesta);
        }
    }

    public Participacion ganadorMano() {
        Participacion ganador = null;
        if (participantes.size() >= 1) {
            Collections.sort(participantes);
            this.setGanador(participantes.get(participantes.size() - 1));
            ganador = this.ganador;
            ganador.setPozoJugador(pozo);
            this.pozo = 0;
            avisar(Eventos.actualizarPozo);
            juego.nuevaMano(this.pozo);       
        } else {
            juego.nuevaMano(this.pozo);
        }   
        avisar(Eventos.nuevaMano);
        return ganador;
    }

//    public boolean todosPasan() {
//        ArrayList<Participacion> pAux = new ArrayList();
//        for (Participacion p : this.participantes) {
//            if (p.getNoApuesta() == false) {
//                pAux.add(p);
//            }
//        }
//        if (pAux.size() == this.participantes.size()) {
//            return true;
//        } else {
//            return false;
//        }
//    }
    public void cargarMano() {
        for (Participacion p : this.participantes) {
            p.vaciarApuesta();
            p.vaciarCartas();
        }
        this.barajarMazo();
        this.repartirCartas();
        this.setearFiguras();
    }
}
