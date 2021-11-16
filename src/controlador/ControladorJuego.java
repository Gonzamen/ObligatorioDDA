/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Juego;
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

    public ControladorJuego(VistaJuego vista, Participacion participante) {
        this.vista = vista;
        this.participante = participante;
        this.juego = participante.getJuego();
        fachada.agregar(this);
    }
      

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Sistema.Eventos.agregaParticipante)){ 
            cargarParticipante();
            mostrarFaltantes();
        }
    }

    private void cargarParticipante() {
        vista.agregarParticipante(juego.getJugadores());
    }

    private void mostrarFaltantes() {
        int faltantes = juego.getJugadoresMax() - juego.getJugadores().size();      
        vista.mostrarFaltantes(faltantes);
    }
    
    private void repartirCartas(){
        if(iniciarJuego()){
            vista.cargarCartas(participante.getCartasJugador());
        }
    }
    
    private boolean iniciarJuego(){
        if(juego.getJugadoresMax() == juego.getJugadores().size()){
            juego.generarMano(juego.getLuz()*juego.getJugadoresMax());
            return true;
        }else{
            return false;
        }      
    }
    
    public void apostar(double monto){
        if(fachada.getMano(participante.getJugador(), juego).apostar(participante, monto)){
            participante.setNoApuesta(true);
            participante.getJugador().setSaldo(monto);
        }
        vista.mostrarApuesta(monto);
    }
}
