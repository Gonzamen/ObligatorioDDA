/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Juego;
import modelo.Sistema;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author gonza
 */
public class ControladorMonitoreo implements Observador{
    
    private VistaMonitoreo vista;
    private Sistema fachada=Sistema.getInstancia();
    private ArrayList<Juego> juegos = fachada.getJuegos();
    private Juego juegoSeleccionado = new Juego();

    public ControladorMonitoreo(VistaMonitoreo vista) {
        this.vista = vista;
        this.juegos=juegos;
        fachada.agregar(this);
        juegoSeleccionado.agregar(this);
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Sistema.Eventos.agregaJuego)){
            refrescarTablaJuegos();
        }
        if(evento.equals(Juego.Eventos.seActualiza)){
            refrescarTablaDetalles();
        }
    }

    private void refrescarTablaJuegos() {
        vista.mostrarJuegos(this.juegos);
    }
    
    public ArrayList<Juego> getJuegos(){
        return this.juegos;
    }

    private void refrescarTablaDetalles() {
        vista.mostrarDatosJuego(this.juegoSeleccionado);
    }
    
    public void setearJuegoSeleccionado(Juego juego){
        this.juegoSeleccionado = juego;
    }
    
}
