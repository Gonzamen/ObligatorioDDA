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
public class Mano {
    private double pozo;
    private Participacion ganador = new Participacion();
    private ArrayList<Participacion> participantes = new ArrayList();
    private Mazo mazo = new Mazo();

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

    public ArrayList<Participacion> getParticipantes() {
        return participantes;
    }
    
    public void barajarMazo(){
        mazo.barajar();
    }
    
    public void repartirCartas(){
        for(int i=0;i<=(this.participantes.size()*5) - 1;i++){
            for(Participacion p : this.participantes){
                p.setCartasJugador(mazo.getCartas().get(i));
                i++;
            }
        }
    }
    
}
