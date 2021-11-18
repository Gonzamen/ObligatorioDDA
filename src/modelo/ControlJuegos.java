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
    private int luz;
    private int cantJugadores;

    public ControlJuegos() {
        cargarFiguras();
    }

    public void setLuz(int luz) {
        this.luz = luz;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }
    

    
    public void agregarJuego(Juego juego) {
        juegos.add(juego);
        Sistema.getInstancia().avisar(Sistema.Eventos.agregaJuego);
    }

    public ArrayList<Juego> getJuegos() {
        return this.juegos;
    }

    public void cargarFiguras() {
        figuras.add(new Par());
        figuras.add(new Pierna());
        figuras.add(new Color());
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    public Participacion iniciarJuego(Jugador jugador){
        int contador = 0;
        ArrayList<Juego> juegos = new ArrayList(this.juegos);
        Participacion part = new Participacion(jugador);
        for (Juego juego : this.juegos) {
            for (Participacion p : juego.getJugadores()) {
                if (jugador.equals(p.getJugador()) && juego.getIniciado() == false) {
                    return null;
                }
            }
        }
        if (this.juegos.size() == 0) {
            Juego j = new Juego(luz,cantJugadores);
            this.agregarJuego(j);           
            if (jugador.getSaldo() >= j.getLuz()) {
                j.agregarJugador(part);
                part.getJugador().setSaldoInicio(part.getJugador().getSaldo());
            }
        } else {
            for (Juego j : juegos) {
                if (!j.getIniciado()) {
                    if (jugador.getSaldo() >= j.getLuz()) {
                        j.agregarJugador(part);
                        part.getJugador().setSaldoInicio(part.getJugador().getSaldo());
                    }
                } else {
                    contador++;
                    if (contador == this.juegos.size()) {
                        Juego j2 = new Juego(luz,cantJugadores);
                        this.agregarJuego(j2);
                        if (jugador.getSaldo() >= j2.getLuz()) {
                            j2.agregarJugador(part);
                            part.getJugador().setSaldoInicio(part.getJugador().getSaldo());
                        }
                    }
                }
            }
        }
        return part;
    }

    public Participacion buscarJugador(Jugador jug, Juego jue) {
        Participacion part = null;
        for (Participacion p : jue.getJugadores()) {
            if (p.getJugador().equals(jug)) {
                part = p;
            }
        }
        return part;
    }


}
