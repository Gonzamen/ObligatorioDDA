/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Carta;
import modelo.Participacion;

/**
 *
 * @author gonza
 */
public interface VistaJuego {

    public void agregarParticipante(ArrayList<Participacion> participantes);

    public void mostrarFaltantes(int faltantes);

    public void cargarCartas(ArrayList<Carta> cartasJugador);

    public void mostrarApuesta(double monto);

    public void mostrarPozo(double monto);

    public void mostrarSaldo(double saldo);

    public void mostrarSaldoJugador(double saldoJugador);

    public void notificarApuesta();

    public void mostrarGanador(Participacion ganador);

    public void formatear();

    public void noHayGanador();

    public void juegoFinalizado();

    public void cerrarVentana();

    public void cargarTitulo(String nombre);

    public void cerrarTodo();

    public void mostrarFigura(String nombreFigura);

}
