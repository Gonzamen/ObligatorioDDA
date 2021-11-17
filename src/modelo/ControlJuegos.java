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
    private Mazo mazo;

    public ControlJuegos() {
        cargarFiguras();
    }

    public Mazo getMazo() {
        return mazo;
    }

    public void setMazo(Mazo mazo) {
        this.mazo = mazo;
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

    public Participacion iniciarJuego(Jugador jugador){
        int contador = 0;
        ArrayList<Juego> juegos = this.juegos;
        Participacion part = new Participacion(jugador);
        for (Juego juego : this.juegos) {
            for (Participacion p : juego.getJugadores()) {
                if (jugador.equals(p.getJugador())) {
                    return null;
                }
            }
        }
        if (this.juegos.size() == 0) {
            Juego j = new Juego();
            j.setMazo(this.mazo);
            this.agregarJuego(j);
            if (jugador.getSaldo() > j.getLuz()) {
                j.agregarJugador(part);
                Sistema.getInstancia().avisar(Sistema.Eventos.agregaParticipante);
            }
        } else {
            for (Juego j : juegos) {
                if (!j.getIniciado()) {
                    if (jugador.getSaldo() > j.getLuz()) {
                        j.agregarJugador(part);
                        Sistema.getInstancia().avisar(Sistema.Eventos.agregaParticipante);
                    }
                } else {
                    contador++;
                    if (contador == this.juegos.size()) {
                        Juego j2 = new Juego();
                        j2.setMazo(this.mazo);
                        this.agregarJuego(j2);
                        if (jugador.getSaldo() > j2.getLuz()) {
                            j2.agregarJugador(part);
                            Sistema.getInstancia().avisar(Sistema.Eventos.agregaParticipante);
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

    public Mano getMano(Participacion jugador, Juego jue) {
        for (Juego j : juegos) {
            if (j.equals(jue)) {
                for (Mano m : j.getManos()) {
                    for (Participacion p : m.getParticipantes()) {
                        if (m.getEnJuego() == true && p.equals(jugador)) {
                            return m;
                        }
                    }
                }
            }
        }
        return null;
    }

    public void agregarMazo(Mazo mazo){
        this.setMazo(mazo);
    }
}
