/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author gonza
 */
public class Mazo {

    public Mazo() {
        setCartas();
    }
      

    private ArrayList<Carta> cartas = new ArrayList();

    public void barajar() {
        Collections.shuffle(cartas);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
    
    
    public void setCartas(){
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
        cartas.add(carta1);
        cartas.add(carta2);
        cartas.add(carta3);
        cartas.add(carta4);
        cartas.add(carta5);
        cartas.add(carta6);
        cartas.add(carta7);
        cartas.add(carta8);
        cartas.add(carta9);
        cartas.add(carta10);
        cartas.add(carta11);
        cartas.add(carta12);
        cartas.add(carta13);
        cartas.add(carta14);
        cartas.add(carta15);
        cartas.add(carta16);
        cartas.add(carta17);
        cartas.add(carta18);
        cartas.add(carta19);
        cartas.add(carta20);
        cartas.add(carta21);
        cartas.add(carta22);
        cartas.add(carta23);
        cartas.add(carta24);
        cartas.add(carta25);
        cartas.add(carta26);
        cartas.add(carta27);
        cartas.add(carta28);
        cartas.add(carta29);
        cartas.add(carta30);
        cartas.add(carta31);
        cartas.add(carta32);
        cartas.add(carta33);
        cartas.add(carta34);
        cartas.add(carta35);
        cartas.add(carta36);
        cartas.add(carta37);
        cartas.add(carta38);
        cartas.add(carta39);
        cartas.add(carta40);
        cartas.add(carta41);
        cartas.add(carta42);
        cartas.add(carta43);
        cartas.add(carta44);
        cartas.add(carta45);
        cartas.add(carta46);
        cartas.add(carta47);
        cartas.add(carta48);
        cartas.add(carta49);
        cartas.add(carta50);
        cartas.add(carta51);
        cartas.add(carta52);       
    }
    
}
