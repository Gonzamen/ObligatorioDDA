/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
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
        this.mano = juego.getManos().get(0);
        fachada.agregar(this);
        mano.agregar(this);

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
            actualizarSaldo();
            desactivarApuesta();
        }
    }

    private void cargarParticipante() {
        ArrayList<Participacion> participantes = new ArrayList(juego.getJugadores());
        participantes.remove(participante);
        vista.agregarParticipante(participantes);
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
            mano.iniciarMano(juego);
            repartirCartas();
            actualizarPozo();
        }
    }

    public void apostar(double monto) {
        if (fachada.getMano(participante, juego).apostar(participante, monto)) {
            vista.mostrarApuesta(monto);
            vista.notificarApuesta();
        }       
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
    
    private void actualizarSaldo(){
        vista.mostrarSaldo(participante.getSaldo());
    }
    
    public double cargarSaldo(){
        return participante.getSaldo();
    }
    
    public void getSaldoJugador(Participacion p){
        vista.mostrarSaldoJugador(p.getSaldoJugador());
    }
    
    private void desactivarApuesta(){
        vista.notificarApuesta();
    }

}
