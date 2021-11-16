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

    public void agregarJugador(Jugador jug) {
        jugadores.add(jug);
    }

    public void agregarAdministrador(Administrador adm) {
        administradores.add(adm);
    }
    
    public Participacion loginJugador(String usuario,String pwd){
        Usuario u=login(usuario,pwd,jugadores);
        Participacion p=null;
        if(u!=null){
            Jugador j=(Jugador)u;
            p=new Participacion(j);
        }
        return p;
    }
    
    public Administrador loginAdmin(String usuario,String pwd){
        Usuario u=login(usuario,pwd,administradores);
        return (Administrador)u;
    }
    
    private Usuario login(String usuario,String pwd,ArrayList usuarios){
        for(Object ob:usuarios){
            Usuario u=(Usuario)ob;
            if(u.getNomUsuario().equals(usuario) && u.getContraseña().equals(pwd)){
                return u;
            }
        }
        return null;
    }

    public ArrayList<Administrador> getAdministradores() {
        return administradores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    
}
