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
public class Participacion implements Comparable<Participacion> {

    private Jugador jugador;
    private ArrayList<Carta> cartasJugador = new ArrayList();
    private Apuesta apuesta = new Apuesta();
    private Figura figura = null;
    private boolean noApuesta = false;

    public Participacion(Jugador jugador) {
        this.jugador = jugador;
        //this.setFigura();
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

    public void setCartasJugador(Carta carta) {
        this.cartasJugador.add(carta);
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
        for (Figura f : Sistema.getInstancia().getFiguras()) {
            Figura aux = f.definirme(cartasJugador);
            if (aux != null) {
                this.figura = aux;
                return;
            }
        }
    }

    public void apostar(double monto) {
        apuesta.setMonto(monto);
        setSaldoJugador(getSaldoJugador() - monto);
    }

    public double getSaldoJugador() {
        return this.jugador.getSaldo();
    }

    public void setSaldoJugador(double saldo) {
        this.jugador.setSaldo(saldo);
    }

    @Override
    public int compareTo(Participacion o) {
        if (this.figura == null && o.getFigura() == null) {
            if (this.compararCartas(o) == 1) {
                return 1;
            } else if (this.compararCartas(o) == -1) {
                return -1;
            }
        } else {
            if (this.cartasSinFigura(o) == 1) {
                return 1;
            } else if (this.cartasSinFigura(o) == -1) {
                return -1;
            } else {
                if (this.figura.compareTo(o.getFigura()) == 1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    private int compararCartas(Participacion o) {
        Carta aux1 = new Carta();
        Carta aux2 = new Carta();
        for (Carta c : this.cartasJugador) {
            if (c.getNumero() > aux1.getNumero()) {
                aux1 = c;
            }
        }
        for (Carta c : o.getCartasJugador()) {
            if (c.getNumero() > aux2.getNumero()) {
                aux2 = c;
            }
        }
        if (aux1.getNumero() > aux2.getNumero()) {
            return 1;
        } else if (aux1.getNumero() < aux2.getNumero()) {
            return -1;
        } else {
            if (aux1.getPalo().getvalor() > aux2.getPalo().getvalor()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private int cartasSinFigura(Participacion o) {
        if (this.figura != null && o.getFigura() == null) {
            return 1;
        } else if (this.figura == null && o.getFigura() != null) {
            return -1;
        } else {
            return 0;
        }
    }

    public boolean getNoApuesta() {
        return noApuesta;
    }

    public void setNoApuesta(boolean noApuesta) {
        this.noApuesta = noApuesta;
    }

}
