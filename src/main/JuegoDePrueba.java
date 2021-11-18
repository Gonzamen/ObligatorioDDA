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
        Administrador admin1 = new Administrador("a","a","aa");
        Jugador jug1 = new Jugador("a","a","aa",150);
        Jugador jug2 = new Jugador("b","b","bb",150);
        Jugador jug3 = new Jugador("c","c","cc",150);
        Jugador jug4 = new Jugador("d","d","dd",150);
        Jugador jug5 = new Jugador("e","e","ee",150);
        sistema.agregarJugador(jug1);
        sistema.agregarJugador(jug2);
        sistema.agregarJugador(jug3);
        sistema.agregarJugador(jug4);
        sistema.agregarJugador(jug5);
        
    }
}
