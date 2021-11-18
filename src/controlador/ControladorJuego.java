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
        this.mano = juego.getManos().get(juego.getManos().size() - 1);
        fachada.agregar(this);
        juego.agregar(this);
        mano.agregar(this);
        setearTitulo();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Sistema.Eventos.agregaParticipante)) {
            cargarParticipante();
            mostrarFaltantes();
        }
        if (evento.equals(Mano.Eventos.actualizarPozo)) {
            actualizarPozo();
        }
        if (evento.equals(Mano.Eventos.seApuesta)) {
            actualizarApuesta();
            actualizarSaldo();
            desactivarApuesta();
        }
        if (evento.equals(Mano.Eventos.nuevaMano)) {
            mostrarGanador();
            retirarDelJuego();
            finalizarJuego();
            actualizarSaldo();
            repartirCartas();
        }
        if (evento.equals(Mano.Eventos.echarDeLaMano)) {
            cargarParticipante();
        }
        if (evento.equals(Juego.Eventos.retirarJugador)) {
            cargarParticipante();
            finalizarJuego();
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
        if (mano.apostar(participante, monto)) {
            vista.mostrarApuesta(monto);
            vista.notificarApuesta();
        }
    }

    private void actualizarPozo() {
        vista.mostrarPozo(mano.getPozo());
    }

    private void actualizarApuesta() {
        
        double monto = 0;
        for (Participacion p : mano.getParticipantes()) {
            if (p.getNoApuesta()) {
                monto = p.getApuesta();
            }
        }
        vista.mostrarApuesta(monto);
    }

    private void actualizarSaldo() {
        vista.mostrarSaldo(participante.getSaldo());
    }

    public double cargarSaldo() {
        return participante.getSaldo();
    }

    public void getSaldoJugador(Participacion p) {
        vista.mostrarSaldoJugador(p.getSaldoJugador());
    }

    private void desactivarApuesta() {
        vista.notificarApuesta();
    }

    public void igualarOPasar(double monto) {
        mano.igualarApuesta(participante, monto);
    }

    public boolean verificarMano() {
        int contador = 0;
        for (Participacion p : mano.getParticipantes()) {
            if (p.getNoApuesta()) {
                contador++;
            }
        }
        if (contador == mano.getParticipantes().size()) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean verificarPasada(){
        ArrayList<Participacion> losQuePasaron = new ArrayList(mano.getLosQuePasaron());
        ArrayList<Participacion> participantes = new ArrayList(mano.getParticipantes());
        if(losQuePasaron.size() == participantes.size()){           
            for(Participacion p : losQuePasaron ){
                mano.getParticipantes().remove(p);
            }
            return true;
        }else{
            return false;
        }
    }


    public void manoTerminada() {
        mano.ganadorMano();     
    }

    private void mostrarGanador() {
        if(mano.getGanador() != null){
            vista.mostrarGanador(mano.getGanador());
        }else{
            vista.noHayGanador();
        }
        
        formatearVista();      
    }

    private void formatearVista() {
        vista.formatear();
    }

    public void retirarParticipante() {
        juego.retirarParticipante(participante);
    }

    private void finalizarJuego() {
        if (juego.getJugadores().size() == 1) {
            vista.juegoFinalizado();
        }
    }

    private void retirarDelJuego() {
        if (participante.getSaldo() <= juego.getLuz()) {
            juego.retirarParticipante(participante);
            vista.cerrarVentana();
        }
    }
    
    private void setearTitulo(){
        vista.cargarTitulo(participante.getNombre());
    }
}
