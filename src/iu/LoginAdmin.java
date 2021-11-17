/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import java.awt.Frame;
import modelo.Administrador;
import modelo.Participacion;
import modelo.Sistema;

/**
 *
 * @author tomas
 */
public class LoginAdmin extends Login{
    
    public LoginAdmin(Frame parent, boolean modal){
        super(parent, modal);
    }

    @Override
    public Object invocarLogin(String usuario, String pwd) {
        Administrador a= Sistema.getInstancia().loginAdmin(usuario,pwd);
        return a;
    }

    @Override
    public void proxCasoUso(Object obj) {
        new MonitorearJuegos(null,false,(Administrador)obj).setVisible(true);
    }

    @Override
    public String getTitulo() {
        return "Administrador, Inicie Sesión";
    }
    
}
