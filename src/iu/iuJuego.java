/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import controlador.ControladorJuego;
import controlador.VistaJuego;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.Carta;
import modelo.Juego;
import modelo.Participacion;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author gonza
 */
public class iuJuego extends javax.swing.JDialog implements VistaJuego {

    /**
     * Creates new form Juego
     */
    private ControladorJuego controlador;
    private Participacion part;

    public iuJuego(java.awt.Frame parent, boolean modal, Participacion participante) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorJuego(this, participante);
        part = participante;
        cargarSaldo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lListaParticipantes = new javax.swing.JList();
        bRetirarse = new javax.swing.JButton();
        bApostar = new javax.swing.JButton();
        bPasar = new javax.swing.JButton();
        bIgualar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lCarta5 = new javax.swing.JLabel();
        lCarta1 = new javax.swing.JLabel();
        lCarta2 = new javax.swing.JLabel();
        lCarta3 = new javax.swing.JLabel();
        lCarta4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tApostar = new javax.swing.JTextField();
        lTuSaldo = new javax.swing.JLabel();
        lSaldoJugador = new javax.swing.JLabel();
        lPozo = new javax.swing.JLabel();
        lApuestaActual = new javax.swing.JLabel();
        lFaltantes = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(null);

        lListaParticipantes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lListaParticipantesValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lListaParticipantes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(680, 20, 180, 230);

        bRetirarse.setText("Retirarse");
        bRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRetirarseActionPerformed(evt);
            }
        });
        jPanel1.add(bRetirarse);
        bRetirarse.setBounds(30, 180, 100, 40);

        bApostar.setText("Apostar");
        bApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bApostarActionPerformed(evt);
            }
        });
        jPanel1.add(bApostar);
        bApostar.setBounds(30, 30, 100, 40);

        bPasar.setText("Pasar");
        bPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPasarActionPerformed(evt);
            }
        });
        jPanel1.add(bPasar);
        bPasar.setBounds(30, 130, 100, 40);

        bIgualar.setText("Igualar");
        bIgualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIgualarActionPerformed(evt);
            }
        });
        jPanel1.add(bIgualar);
        bIgualar.setBounds(30, 80, 100, 40);

        jLabel1.setText("Saldo jugador:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(460, 110, 90, 30);

        jLabel2.setText("Tu Saldo:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 110, 60, 30);
        jPanel1.add(lCarta5);
        lCarta5.setBounds(730, 390, 130, 210);
        jPanel1.add(lCarta1);
        lCarta1.setBounds(40, 390, 130, 210);
        jPanel1.add(lCarta2);
        lCarta2.setBounds(220, 390, 130, 210);
        jPanel1.add(lCarta3);
        lCarta3.setBounds(390, 390, 130, 210);
        jPanel1.add(lCarta4);
        lCarta4.setBounds(560, 390, 130, 210);

        jLabel3.setText("Pozo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 290, 50, 16);

        jLabel4.setText("Apuesta Actual:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 280, 90, 30);
        jPanel1.add(tApostar);
        tApostar.setBounds(160, 40, 100, 22);

        lTuSaldo.setText("$");
        jPanel1.add(lTuSaldo);
        lTuSaldo.setBounds(240, 110, 70, 30);

        lSaldoJugador.setText("$");
        jPanel1.add(lSaldoJugador);
        lSaldoJugador.setBounds(550, 116, 70, 20);

        lPozo.setText("$");
        jPanel1.add(lPozo);
        lPozo.setBounds(250, 290, 70, 20);

        lApuestaActual.setText("$");
        jPanel1.add(lApuestaActual);
        lApuestaActual.setBounds(490, 286, 90, 20);

        lFaltantes.setText(".");
        jPanel1.add(lFaltantes);
        lFaltantes.setBounds(680, 280, 180, 60);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 891, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bApostarActionPerformed
        apostar();

    }//GEN-LAST:event_bApostarActionPerformed

    private void lListaParticipantesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lListaParticipantesValueChanged
        // TODO add your handling code here:
        consultarSaldo();
    }//GEN-LAST:event_lListaParticipantesValueChanged

    private void bIgualarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIgualarActionPerformed
        // TODO add your handling code here:
        igualar();
    }//GEN-LAST:event_bIgualarActionPerformed

    private void bPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPasarActionPerformed
        // TODO add your handling code here:
        pasar();
    }//GEN-LAST:event_bPasarActionPerformed

    private void bRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRetirarseActionPerformed
        // TODO add your handling code here:
        retirar();
    }//GEN-LAST:event_bRetirarseActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bApostar;
    private javax.swing.JButton bIgualar;
    private javax.swing.JButton bPasar;
    private javax.swing.JButton bRetirarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lApuestaActual;
    private javax.swing.JLabel lCarta1;
    private javax.swing.JLabel lCarta2;
    private javax.swing.JLabel lCarta3;
    private javax.swing.JLabel lCarta4;
    private javax.swing.JLabel lCarta5;
    private javax.swing.JLabel lFaltantes;
    private javax.swing.JList lListaParticipantes;
    private javax.swing.JLabel lPozo;
    private javax.swing.JLabel lSaldoJugador;
    private javax.swing.JLabel lTuSaldo;
    private javax.swing.JTextField tApostar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void agregarParticipante(ArrayList<Participacion> participantes) {
        lListaParticipantes.setListData(participantes.toArray());
    }

    @Override
    public void mostrarFaltantes(int faltantes) {
        if (faltantes > 0) {
            lFaltantes.setText("<html>Esperando inicio de juego.<br/>Faltan ingresar: " + faltantes + " jugadores.</html>");
        } else if (faltantes == 0) {
            controlador.iniciarJuego();
            lFaltantes.setText("");
        }

    }

    @Override
    public void cargarCartas(ArrayList<Carta> cartasJugador) {
        Image image;

        try {
            image = ImageIO.read(new File("src/images/" + cartasJugador.get(0).toString()));
            lCarta1.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("src/images/" + cartasJugador.get(1).toString()));
            lCarta2.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("src/images/" + cartasJugador.get(2).toString()));
            lCarta3.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("src/images/" + cartasJugador.get(3).toString()));
            lCarta4.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("src/images/" + cartasJugador.get(4).toString()));
            lCarta5.setIcon(new ImageIcon(image));
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    }

    @Override
    public void mostrarApuesta(double monto) {
        String montoAux = String.valueOf(monto);
        lApuestaActual.setText(montoAux);
    }

    @Override
    public void mostrarPozo(double monto) {
        String montoAux = String.valueOf(monto);
        lPozo.setText(montoAux);
    }

    @Override
    public void mostrarSaldo(double saldo) {
        String montoAux = String.valueOf(saldo);
        lTuSaldo.setText(montoAux);
    }

    private void cargarSaldo() {
        String saldo = String.valueOf(controlador.cargarSaldo());
        lTuSaldo.setText(saldo);
    }

    private void consultarSaldo() {
        Participacion part = (Participacion) lListaParticipantes.getSelectedValue();
        if (part != null) {
            controlador.getSaldoJugador(part);
        }
    }

    @Override
    public void notificarApuesta() {
        lFaltantes.setText("<html>Se realizo una apuesta.<br/>Debes igualar o pasar.</html>");
        bApostar.setEnabled(false);
    }

    @Override
    public void mostrarSaldoJugador(double saldoJugador) {
        String saldo = String.valueOf(saldoJugador);
        lSaldoJugador.setText(saldo);
    }

    private void apostar() {
        double monto = Double.parseDouble(tApostar.getText());
        if (monto <= 0) {
            JOptionPane.showMessageDialog(this, "La apuesta debe ser mayor a 0");
        }
        controlador.apostar(monto);
        lFaltantes.setText("");
        bIgualar.setEnabled(false);
        bPasar.setEnabled(false);
    }

    private void igualar() {
        double monto = Double.parseDouble(lApuestaActual.getText());
        controlador.igualarOPasar(monto);
        bPasar.setEnabled(false);
        lFaltantes.setText("<html>Se ha igualado la apuesta.<html>");
        if (controlador.todosParticipan()) {
            controlador.manoTerminada();
            
        }
    }

    private void pasar() {
        bApostar.setEnabled(false);
        bIgualar.setEnabled(false);
        lFaltantes.setText("<html>Se ha pasado la apuesta.<br/>Quedas fuera de la mano<html>");
        controlador.igualarOPasar(0);
        if (controlador.todosParticipan()) {
            controlador.manoTerminada();
        }
    }

    @Override
    public void mostrarGanador(Participacion ganador) {
        JOptionPane.showMessageDialog(this, "El ganador de la mano es: " + ganador.getNombre());

    }

    @Override
    public void formatear() {
        lApuestaActual.setText("");
        lFaltantes.setText("");
        bIgualar.setEnabled(true);
        bApostar.setEnabled(true);
        bPasar.setEnabled(true);
    }

    @Override
    public void noHayGanador() {
        JOptionPane.showMessageDialog(this, "Todos pasan, siguiente mano.");
    }

    private void retirar() {
        JOptionPane.showMessageDialog(this, "Has sido retirado del juego");
        this.dispose();
        controlador.retirarParticipante();
    }

    @Override
    public void juegoFinalizado() {
        JOptionPane.showMessageDialog(null, "FELICITACIONES, HAS GANADO EL JUEGO!!");
        
    }

    @Override
    public void cerrarVentana() {
        JOptionPane.showMessageDialog(this, "Saldo insuficiente, seras retirado del juego");
        this.dispose();
    }

    @Override
    public void cargarTitulo(String nombre) {
        setTitle(nombre);
    }

    @Override
    public void cerrarTodo() {
        this.dispose();
    }

}
