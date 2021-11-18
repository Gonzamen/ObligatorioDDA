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
    private ArrayList<Juego> juegos= new ArrayList();

    public ControladorMonitoreo(VistaMonitoreo vista, ArrayList<Juego> juegos) {
        this.vista = vista;
        this.juegos=juegos;
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
