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
public class Color extends Figura{
    private Palo palo;

    public Color(Palo palo) {
        this.palo = palo;
    }
    
    public Color(){
        this.ultimovalor++;
        this.valor = ultimovalor;
    }

    public Palo getPalo() {
        return palo;
    }
    
    
    
    
    @Override
    public Figura definirme(ArrayList<Carta> cartas) {
        int contadorpalo = 1;
        Palo palo = cartas.get(0).getPalo();
        for(int i=1;i<cartas.size();i++){
            if(cartas.get(i).getPalo() == palo){
                contadorpalo++;              
            }
        }
        if(contadorpalo==6){
            return new Color(palo);
        }else{
            return null;
        }
    }

    @Override
    public int desempatar(Figura o) {
        Color color1 = (Color) o;
        return this.getPalo().compareTo(color1.getPalo());
    }
    
    
}
