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
public class Jugador extends Usuario{
    
    private double saldo;

    public Jugador(String nomUsuario, String password, String nombreCompleto, double saldo) {
        super(nomUsuario, password, nombreCompleto);
        this.saldo = saldo;
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
       

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = this.saldo + saldo;
    }

    
}
