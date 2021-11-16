/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.awt.Frame;
import modelo.Juego;
import modelo.Participacion;
import modelo.Sistema;

/**
 *
 * @author tomas
 */
public class LoginJugador extends Login{

    public LoginJugador() {
        
    }

    @Override
    public Object invocarLogin(String usuario, String pwd) {
        Participacion p=Sistema.getInstancia().loginJugador(usuario,pwd);
        return p;
    }

    @Override
    public void proxCasoUso(Object obj) {
        new iuJuego(null,false,(Participacion)obj).setVisible(true);
    }
    
}
