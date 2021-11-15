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

    public String iniciarJuego(Jugador jugador) {
        int contador = 0;
        String resultado = "";
        for (Juego juego : this.juegos) {
            for (Participacion p : juego.getJugadores()) {
                if (jugador.equals(p.getJugador())) {
                    return resultado = "YaIngresado";
                }
            }
        }
        if (this.juegos.size() == 0) {
            Juego j = new Juego();
            this.agregarJuego(j);
            if (jugador.getSaldo() > j.getLuz()) {
                j.agregarJugador(new Participacion(jugador));
                return resultado = "Ingresado";
            }else{
                return resultado = "SinSaldo";
            }
        } else {
            for (Juego j : this.juegos) {
                if (!j.getIniciado()) {
                    if (jugador.getSaldo() > j.getLuz()) {
                        j.agregarJugador(new Participacion(jugador));
                        return resultado = "Ingresado";
                    }else{
                        return resultado = "SinSaldo";
                    }
                } else {
                    contador++;
                    if (contador == this.juegos.size()) {
                        Juego j3 = new Juego();
                        this.agregarJuego(j3);
                        if (jugador.getSaldo() > j3.getLuz()) {
                            j3.agregarJugador(new Participacion(jugador));
                            return resultado = "Ingresado";
                        }else{
                            return resultado = "SinSaldo";
                        }
                    }
                }
            }
        }
       return resultado; 
    }

}
