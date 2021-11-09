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
public class ControlUsuarios {
    private ArrayList<Administrador> administradores = new ArrayList();
    private ArrayList<Jugador> jugadores = new ArrayList();
    
    public void agregarJugador(Jugador jug){
        jugadores.add(jug);
    }
    
    public void agregarAdministrador(Administrador adm){
        administradores.add(adm);
    }
}
