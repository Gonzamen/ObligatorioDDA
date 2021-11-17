/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author gonza
 */
public class Administrador extends Usuario{

    public Administrador(String nomUsuario, String password, String nombreCompleto) {
        super(nomUsuario, password, nombreCompleto);
    }

    @Override
    public String getNomUsuario() {
        return nomUsuario;
    }

    @Override
    public String getContraseña() {
        return contraseña;
    }

    @Override
    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
}
