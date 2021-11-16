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
public class ControlJuegos {

    private ArrayList<Juego> juegos = new ArrayList();
    private ArrayList<Figura> figuras = new ArrayList();

    public ControlJuegos() {
        cargarFiguras();
    }

    public void agregarJuego(Juego juego) {
        juegos.add(juego);
    }

    public ArrayList<Juego> getJuegos() {
        return this.juegos;
    }

    public void cargarFiguras() {
        figuras.add(new Color());
        figuras.add(new Pierna());
        figuras.add(new Par());
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public Juego iniciarJuego(Jugador jugador) {
        int contador = 0;
        Juego resultado = null;
        for (Juego juego : this.juegos) {
            for (Participacion p : juego.getJugadores()) {
                if (jugador.equals(p.getJugador())) {
                    return resultado;
                }
            }
        }
        if (this.juegos.size() == 0) {
            Juego j = new Juego();
            this.agregarJuego(j);
            if (jugador.getSaldo() > j.getLuz()) {
                j.agregarJugador(new Participacion(jugador));
                Sistema.getInstancia().avisar(Sistema.Eventos.agregaParticipante);
                resultado = j;
            }
        } else {
            for (Juego j : this.juegos) {
                if (!j.getIniciado()) {
                    if (jugador.getSaldo() > j.getLuz()) {
                        j.agregarJugador(new Participacion(jugador));
                        Sistema.getInstancia().avisar(Sistema.Eventos.agregaParticipante);
                        resultado = j;
                    }
                } else {
                    contador++;
                    if (contador == this.juegos.size()) {
                        Juego j2 = new Juego();
                        this.agregarJuego(j2);
                        if (jugador.getSaldo() > j2.getLuz()) {
                            j2.agregarJugador(new Participacion(jugador));
                            Sistema.getInstancia().avisar(Sistema.Eventos.agregaParticipante);
                            resultado = j2;
                        }
                    }
                }
            }
        }
       return resultado; 
    }
    
    public Participacion buscarJugador(Jugador jug, Juego jue){
        Participacion part = null; 
        for(Participacion p : jue.getJugadores()){
            if(p.getJugador().equals(jug)){
                part = p;
            }
        }
        return part;
    }

}
