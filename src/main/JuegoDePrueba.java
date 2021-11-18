/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.ArrayList;
import modelo.Administrador;
import modelo.Carta;
import modelo.Juego;
import modelo.Jugador;
import modelo.Mano;
import modelo.Mazo;
import modelo.Palo;
import modelo.Participacion;
import modelo.Sistema;

/**
 *
 * @author gonza
 */
public class JuegoDePrueba {
    public static void cargarDatos(){
        Sistema sistema = Sistema.getInstancia();
        sistema.setCantJugadores(3);
        sistema.setLuz(5);
        Administrador admin1 = new Administrador("Admin1","123","Administrador Gonzalo");
        Administrador admin2= new Administrador("Admin2","123","Administrador Tomas");
        sistema.agregarAdministrador(admin1);
        sistema.agregarAdministrador(admin2);
        Jugador jug1 = new Jugador("Gonzamen","123","Gonzalo Méndez",150);
        Jugador jug2 = new Jugador("Tomas","123","Tomas Lanterna",150);
        Jugador jug3 = new Jugador("Pepito","123","Pepe Suarez",150);
        Jugador jug4 = new Jugador("Fulanito","123","Fulanito Perez",150);
        Jugador jug5 = new Jugador("Menganito","123","Menganito Godoy",150);
        Jugador jug6 = new Jugador("Fulanita","123","Fulanita Gonzalez",150);
        sistema.agregarJugador(jug1);
        sistema.agregarJugador(jug2);
        sistema.agregarJugador(jug3);
        sistema.agregarJugador(jug4);
        sistema.agregarJugador(jug5);
        sistema.agregarJugador(jug6);
        
    }
}
