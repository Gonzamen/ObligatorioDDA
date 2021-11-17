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
        Palo corazon = new Palo("corazón",4);
        Palo diamante = new Palo("diamante",3);
        Palo trebol = new Palo("trébol",2);
        Palo pique = new Palo("pique",1);
        Carta carta1 = new Carta(2,corazon);
        Carta carta2 = new Carta(3,corazon);
        Carta carta3 = new Carta(4,corazon);
        Carta carta4 = new Carta(5,corazon);
        Carta carta5 = new Carta(6,corazon);
        Carta carta6 = new Carta(7,corazon);
        Carta carta7 = new Carta(8,corazon);
        Carta carta8 = new Carta(9,corazon);
        Carta carta9 = new Carta(10,corazon);
        Carta carta10 = new Carta(11,corazon);
        Carta carta11 = new Carta(12,corazon);
        Carta carta12 = new Carta(13,corazon);
        Carta carta13 = new Carta(14,corazon);
        Carta carta14 = new Carta(2,diamante);
        Carta carta15 = new Carta(3,diamante);
        Carta carta16 = new Carta(4,diamante);
        Carta carta17 = new Carta(5,diamante);
        Carta carta18 = new Carta(6,diamante);
        Carta carta19 = new Carta(7,diamante);
        Carta carta20 = new Carta(8,diamante);
        Carta carta21 = new Carta(9,diamante);
        Carta carta22 = new Carta(10,diamante);
        Carta carta23 = new Carta(11,diamante);
        Carta carta24 = new Carta(12,diamante);
        Carta carta25 = new Carta(13,diamante);
        Carta carta26 = new Carta(14,diamante);
        Carta carta27 = new Carta(2,trebol);
        Carta carta28 = new Carta(3,trebol);
        Carta carta29 = new Carta(4,trebol);
        Carta carta30 = new Carta(5,trebol);
        Carta carta31 = new Carta(6,trebol);
        Carta carta32 = new Carta(7,trebol);
        Carta carta33 = new Carta(8,trebol);
        Carta carta34 = new Carta(9,trebol);
        Carta carta35 = new Carta(10,trebol);
        Carta carta36 = new Carta(11,trebol);
        Carta carta37 = new Carta(12,trebol);
        Carta carta38 = new Carta(13,trebol);
        Carta carta39 = new Carta(14,trebol);
        Carta carta40 = new Carta(2,pique);
        Carta carta41 = new Carta(3,pique);
        Carta carta42 = new Carta(4,pique);
        Carta carta43 = new Carta(5,pique);
        Carta carta44 = new Carta(6,pique);
        Carta carta45 = new Carta(7,pique);
        Carta carta46 = new Carta(8,pique);
        Carta carta47 = new Carta(9,pique);
        Carta carta48 = new Carta(10,pique);
        Carta carta49 = new Carta(11,pique);
        Carta carta50 = new Carta(12,pique);
        Carta carta51 = new Carta(13,pique);
        Carta carta52 = new Carta(14,pique);
        ArrayList<Carta> mazo = new ArrayList();
        Mazo mazoentero = new Mazo();
        
        mazo.add(carta1);
        mazo.add(carta2);
        mazo.add(carta3);
        mazo.add(carta4);
        mazo.add(carta5);
        mazo.add(carta6);
        mazo.add(carta7);
        mazo.add(carta8);
        mazo.add(carta9);
        mazo.add(carta10);
        mazo.add(carta11);
        mazo.add(carta12);
        mazo.add(carta13);
        mazo.add(carta14);
        mazo.add(carta15);
        mazo.add(carta16);
        mazo.add(carta17);
        mazo.add(carta18);
        mazo.add(carta19);
        mazo.add(carta20);
        mazo.add(carta21);
        mazo.add(carta22);
        mazo.add(carta23);
        mazo.add(carta24);
        mazo.add(carta25);
        mazo.add(carta26);
        mazo.add(carta27);
        mazo.add(carta28);
        mazo.add(carta29);
        mazo.add(carta30);
        mazo.add(carta31);
        mazo.add(carta32);
        mazo.add(carta33);
        mazo.add(carta34);
        mazo.add(carta35);
        mazo.add(carta36);
        mazo.add(carta37);
        mazo.add(carta38);
        mazo.add(carta39);
        mazo.add(carta40);
        mazo.add(carta41);
        mazo.add(carta42);
        mazo.add(carta43);
        mazo.add(carta44);
        mazo.add(carta45);
        mazo.add(carta46);
        mazo.add(carta47);
        mazo.add(carta48);
        mazo.add(carta49);
        mazo.add(carta50);
        mazo.add(carta51);
        mazo.add(carta52);
        mazoentero.setCartas(mazo);
        sistema.agregarMazo(mazoentero);
    }
}
