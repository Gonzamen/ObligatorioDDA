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
public class iuJuego extends javax.swing.JDialog implements VistaJuego{

    /**
     * Creates new form Juego
     */
    private ControladorJuego controlador;
    
    public iuJuego(java.awt.Frame parent, boolean modal, Participacion participante, Juego juego) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorJuego(this,participante,juego);
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
        tSaldoPropio = new javax.swing.JTextField();
        tSaldoJugador = new javax.swing.JTextField();
        lCarta5 = new javax.swing.JLabel();
        lCarta1 = new javax.swing.JLabel();
        lCarta2 = new javax.swing.JLabel();
        lCarta3 = new javax.swing.JLabel();
        lCarta4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tPozo = new javax.swing.JTextField();
        tApuestaActual = new javax.swing.JTextField();
        tSalaEspera = new javax.swing.JTextField();

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

        jScrollPane2.setViewportView(lListaParticipantes);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(680, 20, 180, 230);

        bRetirarse.setText("Retirarse");
        jPanel1.add(bRetirarse);
        bRetirarse.setBounds(30, 180, 100, 40);

        bApostar.setText("Apostar");
        jPanel1.add(bApostar);
        bApostar.setBounds(30, 30, 100, 40);

        bPasar.setText("Pasar");
        jPanel1.add(bPasar);
        bPasar.setBounds(30, 130, 100, 40);

        bIgualar.setText("Igualar");
        jPanel1.add(bIgualar);
        bIgualar.setBounds(30, 80, 100, 40);

        jLabel1.setText("Saldo jugador:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(460, 110, 90, 30);

        jLabel2.setText("Tu Saldo:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 110, 60, 30);
        jPanel1.add(tSaldoPropio);
        tSaldoPropio.setBounds(240, 110, 64, 22);
        jPanel1.add(tSaldoJugador);
        tSaldoJugador.setBounds(550, 110, 64, 22);
        jPanel1.add(lCarta5);
        lCarta5.setBounds(730, 350, 130, 210);
        jPanel1.add(lCarta1);
        lCarta1.setBounds(40, 350, 130, 210);
        jPanel1.add(lCarta2);
        lCarta2.setBounds(210, 350, 130, 210);
        jPanel1.add(lCarta3);
        lCarta3.setBounds(380, 350, 130, 210);
        jPanel1.add(lCarta4);
        lCarta4.setBounds(550, 350, 130, 210);

        jLabel3.setText("Pozo:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(220, 290, 29, 16);

        jLabel4.setText("Apuesta Actual:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(390, 280, 90, 30);
        jPanel1.add(tPozo);
        tPozo.setBounds(260, 290, 64, 22);
        jPanel1.add(tApuestaActual);
        tApuestaActual.setBounds(490, 290, 64, 22);
        jPanel1.add(tSalaEspera);
        tSalaEspera.setBounds(680, 280, 180, 50);

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
    private javax.swing.JLabel lCarta1;
    private javax.swing.JLabel lCarta2;
    private javax.swing.JLabel lCarta3;
    private javax.swing.JLabel lCarta4;
    private javax.swing.JLabel lCarta5;
    private javax.swing.JList lListaParticipantes;
    private javax.swing.JTextField tApuestaActual;
    private javax.swing.JTextField tPozo;
    private javax.swing.JTextField tSalaEspera;
    private javax.swing.JTextField tSaldoJugador;
    private javax.swing.JTextField tSaldoPropio;
    // End of variables declaration//GEN-END:variables

    @Override
    public void agregarParticipante(ArrayList<Participacion> participantes) {
        lListaParticipantes.setListData(participantes.toArray());
    }

    @Override
    public void mostrarFaltantes(int faltantes) {
        tSalaEspera.setText("Esperando inicio de juego, faltan ingresar: "+ faltantes + " jugadores");
    }

    @Override
    public void cargarCartas(ArrayList<Carta> cartasJugador) {
        Image image;
        try{
            image = ImageIO.read(new File("images/"+cartasJugador.get(0).toString()));
            lCarta1.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("images/"+cartasJugador.get(1).toString()));
            lCarta2.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("images/"+cartasJugador.get(2).toString()));
            lCarta3.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("images/"+cartasJugador.get(3).toString()));
            lCarta4.setIcon(new ImageIcon(image));
            image = ImageIO.read(new File("images/"+cartasJugador.get(4).toString()));
            lCarta5.setIcon(new ImageIcon(image));
        }catch(IOException ex){
            JOptionPane.showMessageDialog(this, ex);;
        }
    }
}
