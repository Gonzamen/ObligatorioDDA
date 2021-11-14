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
public class Sistema {

    private ControlJuegos controlJuegos = new ControlJuegos();
    private ControlUsuarios controlUsuarios = new ControlUsuarios();
    
    private static Sistema instancia = new Sistema();

    public static Sistema getInstancia() {
        return instancia;
    }

    private Sistema() {
    }

    public void agregarJuego(Juego juego) {
        controlJuegos.agregarJuego(juego);
    }

    public void agregarJugador(Jugador jug) {
        controlUsuarios.agregarJugador(jug);
    }

    public void agregarAdministrador(Administrador adm) {
        controlUsuarios.agregarAdministrador(adm);
    }

    public Usuario iniciarSesion(String nomUsuario, String password) {
        return controlUsuarios.iniciarSesion(nomUsuario, password);
    }

    public ArrayList<Figura> getFiguras() {
        return controlJuegos.getFiguras();
    }
    
    
}
