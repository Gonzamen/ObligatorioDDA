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
    private Carta cartaDesempate;

    public Par(Carta carta, Carta cartadesempate) {
        this.carta = carta;
        this.cartaDesempate = cartadesempate;
    }

    public Par() {
        this.ultimovalor++;
        valor = ultimovalor;
    }

    public Carta getCarta() {
        return carta;
    }

    public void setCartaAlta(Carta carta) {
        this.cartaDesempate = carta;
    }

    public Carta getCartaAlta() {
        return this.cartaDesempate;
    }

    @Override
    public Figura definirme(ArrayList<Carta> cartas) {
        Par p = null;
        int contadornum = 1;
        Carta carta = new Carta();
        Carta cartaAlta = new Carta();
        boolean bandera = false;
        for (int i = 0; i < cartas.size() && !bandera; i++) {
            for (int j = i + 1; j < cartas.size() && !bandera; j++) {
                if (cartas.get(i).getNumero() == cartas.get(j).getNumero()) {
                    contadornum++;
                    if (contadornum == 2) {
                        carta = cartas.get(i);
                        bandera = true;
                    }
                }
            }
        }
        if(contadornum==1){
            return null;
        }
        for (Carta c : cartas) {
            if (c.getNumero() != carta.getNumero() && c.getNumero() > cartaAlta.getNumero()) {
                cartaAlta = c;
                p = new Par(carta, cartaAlta);
            }
        }
        return p;
    }

    @Override
    public int desempatar(Figura f) {
        Par par1 = (Par) f;
        if (this.carta.getNumero() > par1.getCarta().getNumero()) {
            return 1;
        } else if (this.carta.getNumero() < par1.getCarta().getNumero()) {
            return -1;
        } else {
            if (this.cartaDesempate.getNumero() > par1.getCartaAlta().getNumero()) {
                return 1;
            } else if (this.cartaDesempate.getNumero() < par1.getCartaAlta().getNumero()) {
                return -1;
            } else {
                if (this.cartaDesempate.getPalo().getvalor() > par1.getCartaAlta().getPalo().getvalor()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
    }

}
