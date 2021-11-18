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
    private boolean pasaApuesta = false;
    private boolean interactua = false;
    private boolean sigue = false;
    private boolean participa = false;
    private Juego juego;

    public Participacion(Jugador jugador) {
        this.jugador = jugador;
    }
    
    public void setearBooleanos(){
        this.sigue = false;
        this.pasaApuesta = false;
        this.interactua = false;
        this.participa = false;
    }
    
    public void setSigue(){
        this.sigue = true;
    }
    
    public boolean getSigue(){
        return this.sigue;
    }
    
    public void setInteractua(){
        this.interactua = true;
    }
    
    public boolean getInteractua(){
        return this.interactua;
    }
    
    public void setpasaApuesta(){
        this.pasaApuesta = true;
    }
    
    public boolean getpasaApuesta(){
        return this.pasaApuesta;
    }
    
    public void setParticipa(){
        this.participa = true;
    }
    
    public boolean getParticipa(){
        return this.participa;
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
    
    public void setCartasJugador(ArrayList<Carta> cartas){
        this.cartasJugador=cartas;
    }

    public void setCartasJugador(Carta carta) {
        this.cartasJugador.add(carta);
    }

    public double getApuesta() {
        return apuesta.getMonto();
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }
    
    public double getSaldo(){
        return this.jugador.getSaldo();
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
        this.participa = true;
        setSaldoJugador(monto);
    }

    public double getSaldoJugador() {
        return this.jugador.getSaldo();
    }

    public void setSaldoJugador(double saldo) {
        this.jugador.setSaldo(getSaldoJugador() - saldo);
    }
    
    public void setPozoJugador(double pozo){
        this.jugador.setSaldo(getSaldoJugador() + pozo);
    }
    
    public String getNombre(){
        return this.jugador.nombreCompleto;
    }
    
    public void vaciarCartas(){
        ArrayList<Carta> vacio = new ArrayList();
        this.cartasJugador = vacio;
    }

    @Override
    public int compareTo(Participacion o) {
        if (this.figura == null && o.getFigura() == null) {
            return this.compararCartas(o);
        } else {
            if (this.cartasSinFigura(o) == 1) {
                return 1;
            } else if (this.cartasSinFigura(o) == -1) {
                return -1;
            } else {
                return this.figura.compareTo(o.getFigura());
            }
        }
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

    @Override
    public String toString() {
        return jugador.getNomUsuario();
    }

}
