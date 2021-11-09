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
public class Participacion {

    private int cantidadParticipantes;
    private Jugador jugador = new Jugador();
    private ArrayList<Carta> cartasJugador = new ArrayList();
    private Apuesta apuesta = new Apuesta();
    private Figura figura = new Figura();

    public int getCantidadParticipantes() {
        return cantidadParticipantes;
    }

    public void setCantidadParticipantes(int cantidadParticipantes) {
        this.cantidadParticipantes = cantidadParticipantes;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public ArrayList<Carta> getCartasJugador() {
        return cartasJugador;
    }

    public void setCartasJugador(ArrayList<Carta> cartasJugador) {
        this.cartasJugador = cartasJugador;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }

    public Figura getFigura() {
        return this.figura;     
    }

    public void setFigura() {
        int contadornum = 0;
        int contadorpalo = 0;
        for (int i = 0; i <= cartasJugador.size(); i++) {
            for (int j = 1; j <= cartasJugador.size(); j++) {
                if (cartasJugador.get(i).getNumero() == cartasJugador.get(j).getNumero()) {
                    contadornum++;
                }
                if (cartasJugador.get(i).getPalo() == cartasJugador.get(j).getPalo()) {
                    contadorpalo++;
                }
            }
        }
        if(contadorpalo == 4){
            this.figura = new Color();
        }
        if(contadornum == 1){
            this.figura = new Par();
        }else{
            this.figura = new Pierna();
        }  
    }

    public void apostar(double monto) {
        apuesta.setMonto(monto);
    }

}
