/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iu;

import controlador.ControladorMonitoreo;
import controlador.VistaMonitoreo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Administrador;
import modelo.Juego;
import modelo.Participacion;

/**
 *
 * @author gonza
 */
public class MonitorearJuegos extends javax.swing.JDialog implements VistaMonitoreo {

    private ControladorMonitoreo controlador;
    /**
     * Creates new form MonitorearJuegos
     */
    public MonitorearJuegos(java.awt.Frame parent, boolean modal, Administrador admin) {
        super(parent, modal);
        initComponents();
        controlador = new ControladorMonitoreo(this);
        mostrarJuegos(controlador.getJuegos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPartidas = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tJugadores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("PARTIDAS");

        tPartidas.setModel(new javax.swing.table.DefaultTableModel(
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
        tPartidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPartidasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPartidas);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("JUGADORES");

        tJugadores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tJugadores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(jLabel2)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tPartidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPartidasMouseClicked
        mostrarDatosJuego(seleccionarJuego(tPartidas.getSelectedRow()));
    }//GEN-LAST:event_tPartidasMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tJugadores;
    private javax.swing.JTable tPartidas;
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void mostrarJuegos(ArrayList<Juego> juegos) {

        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Fecha de Inicio");
        tabla.addColumn("Cantidad Jugadores");
        tabla.addColumn("Total Apostado");
        tabla.addColumn("Cantidad de Manos");

        int fila = 0;
        tabla.setNumRows(juegos.size());
        SimpleDateFormat date = new SimpleDateFormat();

        for (Juego j : juegos) {
            tabla.setValueAt(j.getFecha(), fila, 0);
            tabla.setValueAt(j.getJugadores().size(), fila, 1);
            tabla.setValueAt(j.getTotalApostado(), fila, 2);
            tabla.setValueAt(j.getManos().size(), fila, 3);
            fila++;
        }
        tPartidas.setModel(tabla);

    }

    private Juego seleccionarJuego(int pos) {
        Juego elegido = null;
        if (pos != -1) {
            elegido = controlador.getJuegos().get(pos);
        }
        controlador.setearJuego(elegido);
        return elegido;
    }
    
    

    @Override
    public void mostrarDatosJuego(Juego jue) {
        
        DefaultTableModel tabla = new DefaultTableModel();
        tabla.addColumn("Nombre Completo");
        tabla.addColumn("Total Apostado");
        tabla.addColumn("Saldo Inicio");
        tabla.addColumn("Total Ganado");
        
        int fila=0;
        tabla.setNumRows(jue.getJugadores().size());
        
        for(Participacion p: jue.getJugadores()){
            tabla.setValueAt(p.getJugador().getNombreCompleto(), fila, 0);
            tabla.setValueAt(p.getJugador().getTotalApostado(), fila, 1);
            tabla.setValueAt(p.getJugador().getSaldoInicio(), fila, 2);
            tabla.setValueAt(p.getJugador().getTotalGanado(), fila, 3);
            fila++;
        }
        tJugadores.setModel(tabla);

    }
}
