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
public class ControlJuegos {
    private ArrayList<Juego> juegos = new ArrayList();
    private ArrayList<Figura> figuras = new ArrayList();

    public ControlJuegos() {
        cargarFiguras();
    }
    
    
    
    public void agregarJuego(Juego juego){
        juegos.add(juego);
    }
    
    public ArrayList<Juego> getJuegos(){
        return this.juegos;
    }
    
    public void cargarFiguras(){
        figuras.add(new Par());
        figuras.add(new Pierna());
        figuras.add(new Color());
    }

    public ArrayList<Figura> getFiguras() {
        return figuras;
    }

    
    
    
}
