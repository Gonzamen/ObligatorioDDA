/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gonza
 */
public class Sistema {

    private ControlJuegos controlJuegos = new ControlJuegos();
    private ControlUsuarios controlUsuarios = new ControlUsuarios();

    public void agregarJuego(Juego juego) {
        controlJuegos.agregarJuego(juego);
    }

    public void agregarJugador(Jugador jug) {
        controlUsuarios.agregarJugador(jug);
    }

    public void agregarAdministrador(Administrador adm) {
        controlUsuarios.agregarAdministrador(adm);
    }

    public boolean inciarSesion(String nomUsuario, String password) {
        return controlUsuarios.inciarSesion(nomUsuario, password);
    }
    
    
}
