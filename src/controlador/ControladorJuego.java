/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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

    public ControladorJuego(VistaJuego vista) {
        this.vista = vista;
        
    }
    
    

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
