/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import iu.MenuPrincipal;

/**
 *
 * @author gonza
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JuegoDePrueba.cargarDatos();
        new MenuPrincipal().setVisible(true);
    }
    
}
