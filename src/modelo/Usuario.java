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

    public abstract String getNomUsuario();

    public abstract String getContraseña();


    public abstract String getNombreCompleto();
    
    
}
