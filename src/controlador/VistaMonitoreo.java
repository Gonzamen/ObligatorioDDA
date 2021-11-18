/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Juego;

/**
 *
 * @author gonza
 */
public interface VistaMonitoreo {

    public void mostrarJuegos(ArrayList<Juego> juegos);

    public void mostrarDatosJuego(Juego juegoSeleccionado);
    
}
