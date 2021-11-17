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
public abstract class Usuario {
    protected String nomUsuario;
    protected String contraseña;
    protected String nombreCompleto;

    public Usuario(String nomUsuario, String contraseña, String nombreCompleto) {
        this.nomUsuario = nomUsuario;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
    }
    
    

    public abstract String getNomUsuario();

    public abstract String getContraseña();


    public abstract String getNombreCompleto();
    
    
}
