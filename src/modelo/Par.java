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
public class Par extends Figura {

    private Carta carta;

    public Par(Carta carta) {
        this.carta = carta;
    }

    public Par() {
        this.valor++;
    }

    @Override
    public Figura definirme(ArrayList<Carta> cartas) {
        Par p = null;
        int contadornum = 0;
        Carta carta = new Carta();
        boolean bandera = false;
        for (int i = 0; i < cartas.size() || bandera; i++) {
            for (int j = i + 1; j < cartas.size() || bandera; j++) {
                if (cartas.get(i).getNumero() == cartas.get(j).getNumero()) {
                    contadornum++;
                    if (contadornum == 2) {
                        p = new Par(carta);
                        bandera = true;
                    }
                }
            }
        }
        return p;
    }

}
