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
public class Pierna extends Figura{
    private Carta carta;

    public Pierna(Carta carta) {
        this.carta = carta;
    }
    
    public Pierna(){
        this.ultimovalor++;
        valor = ultimovalor;
    }

    public Carta getCarta() {
        return carta;
    }
    
    
    
    @Override
    public Figura definirme(ArrayList<Carta> cartas) {
        Pierna p = null;
        int contadornum = 1;
        Carta carta = new Carta();
        for(int i=0;i<cartas.size();i++){
            for(int j = i+1;j<cartas.size();j++){
                if (cartas.get(i).getNumero() == cartas.get(j).getNumero()) {                    
                    contadornum++;
                    if(contadornum==3){
                        carta = cartas.get(i);
                        p = new Pierna(carta);
                    }
                }
            }
        }
        return p;
    }

    @Override
    public int desempatar(Figura o) {
        Pierna pierna1 = (Pierna) o;
        if(this.carta.getNumero() > pierna1.getCarta().getNumero()){
            return 1;
        }else{
            return -1;
        }
    }
    

    
}
