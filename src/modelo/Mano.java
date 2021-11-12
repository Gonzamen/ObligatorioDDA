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
public class Mano {

    private double pozo;
    private Participacion ganador = null;
    private ArrayList<Participacion> participantes = new ArrayList();
    private Mazo mazo = new Mazo();
    private Juego juego = new Juego();

    public Mano(double luz, ArrayList<Participacion> participantes) {
        this.pozo = luz;
        this.participantes = participantes;
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
    
    public void setMazo(Mazo mazo){
        this.mazo = mazo;
    }

    public ArrayList<Participacion> getParticipantes() {
        return participantes;
    }

    public void barajarMazo() {
        mazo.barajar();
    }

    public void repartirCartas() {
        for (int i = 0; i <= (this.participantes.size() * 5); i++) {
            for (Participacion p : this.participantes) {
                p.setCartasJugador(mazo.getCartas().get(i));
                i++;
            }
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
        return true;
    }

    public void igualarApuesta(Participacion participante, double monto) {
        if (monto == 0) {
            this.participantes.remove(participante);
        } else {
            participante.apostar(monto);
            participante.setNoApuesta(true);
            this.pozo += monto;
        }
    }

    public Participacion ganadorMano() {
        Participacion ganador = null;
        if (!this.todosPasan()) {
            Collections.sort(participantes);
            this.setGanador(participantes.get(participantes.size()));
            ganador = this.ganador;
        }
        juego.generarMano(this.pozo);
        return ganador;
    }
    

    public boolean todosPasan() {
        ArrayList<Participacion> pAux = new ArrayList();
        for (Participacion p : this.participantes) {
            if (p.getNoApuesta() == false) {
                pAux.add(p);
            }
        }
        if (pAux.size() == 4) {
            return true;
        } else {
            return false;
        }
    }
}
