/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Juego;
import modelo.Mano;
import modelo.Participacion;
import modelo.Sistema;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author gonza
 */
public class ControladorJuego implements Observador {

    private VistaJuego vista;
    private Sistema fachada = Sistema.getInstancia();
    private Participacion participante;
    private Juego juego;
    private Mano mano;

    public ControladorJuego(VistaJuego vista, Participacion participante) {
        this.vista = vista;
        this.participante = participante;
        this.juego = participante.getJuego();
        this.mano = fachada.getMano(participante, juego);
        fachada.agregar(this);
        //mano.agregar(this);

    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Sistema.Eventos.agregaParticipante)) {
            cargarParticipante();
            mostrarFaltantes();
        }
        if (evento.equals(Mano.Eventos.actualizarPozo)) {
            actualizarPozo();
            actualizarApuesta();
        }
    }

    private void cargarParticipante() {
        vista.agregarParticipante(juego.getJugadores());
    }

    private void mostrarFaltantes() {
        int faltantes = juego.getJugadoresMax() - juego.getJugadores().size();
        vista.mostrarFaltantes(faltantes);
    }

    private void repartirCartas() {
        vista.cargarCartas(participante.getCartasJugador());
    }

    public void iniciarJuego() {
        if (juego.getJugadoresMax() == juego.getJugadores().size()) {
            juego.generarMano(juego.getLuz() * juego.getJugadoresMax());
            repartirCartas();
        }
    }

    public void apostar(double monto) {
        if (fachada.getMano(participante, juego).apostar(participante, monto)) {
            participante.setNoApuesta(true);
            participante.getJugador().setSaldo(monto);
        }
        vista.mostrarApuesta(monto);
    }

    private void actualizarPozo() {
        vista.mostrarPozo(mano.getPozo());
    }

    private void actualizarApuesta() {
        double monto = 0;
        for(Participacion p : mano.getParticipantes()){
            if(p.getNoApuesta()){
                monto = p.getApuesta();
            }
        }
        vista.mostrarApuesta(monto);
    }
}
