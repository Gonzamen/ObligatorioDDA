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

    private int cantidadParticipantes;
    private Jugador jugador = new Jugador();
    private ArrayList<Carta> cartasJugador = new ArrayList();
    private Apuesta apuesta = new Apuesta();
    private Figura figura = null;

    public Participacion() {
        this.setFigura();
    }

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
        if (contadorpalo == 4) {
            this.figura = new Color();
        }
        if (contadornum == 1) {
            this.figura = new Par();
        } else {
            this.figura = new Pierna();
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
        if (cartasSinFigura(o) == 1 || this.figura.compareTo(o.getFigura()) == 1) {
            return 1;
        } else if (cartasSinFigura(o) == -1 || this.figura.compareTo(o.getFigura()) == -1) {
            return -1;
        } else {
            if (this.figura instanceof Par) {
                if (this.compararCartas(o) == 1) {
                    return 1;
                } else if (this.compararCartas(o) == -1) {
                    return -1;
                } else {
                    return 0;
                }
            }
            if (this.figura instanceof Pierna) {
                if (this.compararCartas(o) == 1) {
                    return 1;
                } else {
                    return -1;
                }
            }
            if (this.figura instanceof Color) {
                if (this.cartasJugador.get(0).getPalo().compareTo(o.getCartasJugador().get(0).getPalo()) == 1) {
                    return 1;
                } else if (this.cartasJugador.get(0).getPalo().compareTo(o.getCartasJugador().get(0).getPalo()) == -1) {
                    return -1;
                }
            }
        }
        return 3;
    }

    private int compararCartas(Participacion o) {
        int aux1 = 0;
        int aux2 = 0;
        for (Carta c : this.cartasJugador) {
            if (c.getNumero() > aux1) {
                aux1 = c.getNumero();
            }
        }
        for (Carta c : o.getCartasJugador()) {
            if (c.getNumero() > aux2) {
                aux2 = c.getNumero();
            }
        }
        if (aux1 > aux2) {
            return 1;
        } else {
            return -1;
        }
    }

    private int cartasSinFigura(Participacion o) {
        if (this.figura != null && o.getFigura() == null) {
            return 1;
        } else if (this.figura == null && o.getFigura() != null) {
            return -1;
        } else {
            if (this.compararCartas(o) == 1) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
