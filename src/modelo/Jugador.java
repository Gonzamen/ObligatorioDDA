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
    private double totalApostado;
    private double totalGanado;
    private double saldoInicio;

    public double getTotalApostado() {
        return totalApostado;
    }

    public void setTotalApostado(double totalApostado) {
        this.totalApostado = this.totalApostado + totalApostado;
    }

    public double getTotalGanado() {
        return totalGanado;
    }

    public void setTotalGanado(double totalGanado) {
        this.totalGanado = totalGanado-this.totalApostado;
    }

    public double getSaldoInicio() {
        return saldoInicio;
    }

    public void setSaldoInicio(double saldoInicio) {
        this.saldoInicio = saldoInicio;
    }

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
        this.saldo = saldo;
    }

    
}
