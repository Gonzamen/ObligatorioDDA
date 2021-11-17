/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.awt.Frame;
import modelo.Juego;
import modelo.JuegoException;
import modelo.Jugador;
import modelo.Participacion;
import modelo.Sistema;

/**
 *
 * @author tomas
 */
public class LoginJugador extends Login{

    public LoginJugador(Frame parent, boolean modal) {
        super(parent, modal);
    }

    @Override
    public Object invocarLogin(String usuario, String pwd) {
        Participacion p=Sistema.getInstancia().loginJugador(usuario,pwd);
        return p.getJugador();
    }

    @Override
    public void proxCasoUso(Object obj) throws JuegoException{
        Jugador jugador1 = (Jugador)obj;
        Participacion part = sistema.iniciarJuego(jugador1);
        if(part == null){
            throw new JuegoException("Ya participa de una sala de espera"); 
        }else if(jugador1.getSaldo() < part.getJuego().getLuz()){
            throw new JuegoException("Saldo insuficiente");
        }else{
            new iuJuego(null,false,part).setVisible(true);
            Sistema.getInstancia().avisar(Sistema.Eventos.agregaParticipante);
        }       
    }

    @Override
    public String getTitulo() {
        return "Jugador, Inicie Sesión";
    }
    
}
