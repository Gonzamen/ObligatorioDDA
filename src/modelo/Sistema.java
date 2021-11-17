/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author gonza
 */
public class Sistema extends Observable{

    private ControlJuegos controlJuegos = new ControlJuegos();
    private ControlUsuarios controlUsuarios = new ControlUsuarios();
    
    private static Sistema instancia = new Sistema();
    
    public enum Eventos{agregaParticipante,nuevoContactoAlgunaAgenda};

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


    public ArrayList<Figura> getFiguras() {
        return controlJuegos.getFiguras();
    }
    
    public ArrayList<Juego> getJuegos(){
        return controlJuegos.getJuegos();
    }

    public ArrayList<Administrador> getAdministradores() {
        return controlUsuarios.getAdministradores();
    }

    public ArrayList<Jugador> getJugadores() {
        return controlUsuarios.getJugadores();
    }

    public Participacion iniciarJuego(Jugador jugador){
        return controlJuegos.iniciarJuego(jugador);
    }

    public Participacion buscarJugador(Jugador jug, Juego jue) {
        return controlJuegos.buscarJugador(jug, jue);
    }

    public Participacion loginJugador(String usuario, String pwd) {
        return controlUsuarios.loginJugador(usuario, pwd);
    }

    public Administrador loginAdmin(String usuario, String pwd) {
        return controlUsuarios.loginAdmin(usuario, pwd);
    }
    
    public Mano getMano(Participacion jugador, Juego jue){
        return controlJuegos.getMano(jugador, jue);
    }

    public void agregarMazo(Mazo mazo) {
        controlJuegos.agregarMazo(mazo);
    }


    
}
