/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forme;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import repository.db.DbConnectionFactory;
import server.Server;

/**
 *
 * @author Korisnik
 */
public class ServerskaForma extends javax.swing.JFrame {

    /**
     * Creates new form ServerskaForma
     */
    
    Server server;
    
    public ServerskaForma() {
        initComponents();
        //setExtendedState(ServerskaForma.MAXIMIZED_BOTH);
        
        jLabelStatus.setText("SERVER NIJE POKRENUT!");
        jButtonZaustaviServer.setEnabled(false);
        
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonPokreniServer = new javax.swing.JButton();
        jButtonZaustaviServer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jButtonIzvestaj = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemBaza = new javax.swing.JMenuItem();
        jMenuItemPort = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonPokreniServer.setText("POKRENI SERVER");
        jButtonPokreniServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPokreniServerActionPerformed(evt);
            }
        });

        jButtonZaustaviServer.setText("ZAUSTAVI SERVER");
        jButtonZaustaviServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonZaustaviServerActionPerformed(evt);
            }
        });

        jLabel1.setText("Status:");

        jLabelStatus.setText("SERVER NIJE POKRENUT!");

        jButtonIzvestaj.setText("IZVEŠTAJ");
        jButtonIzvestaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIzvestajActionPerformed(evt);
            }
        });

        jMenu1.setText("KONFIGURACIJA");

        jMenuItemBaza.setText("Baza");
        jMenuItemBaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBazaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemBaza);

        jMenuItemPort.setText("Port");
        jMenuItemPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPortActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemPort);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPokreniServer)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonZaustaviServer, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonIzvestaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPokreniServer)
                    .addComponent(jButtonZaustaviServer))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButtonIzvestaj, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemBazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBazaActionPerformed
        FormaKonfiguracijaBaza baza = new FormaKonfiguracijaBaza(this, false);
        baza.setVisible(true);
    }//GEN-LAST:event_jMenuItemBazaActionPerformed

    private void jMenuItemPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPortActionPerformed
        FormaKonfiguracijaPort port = new FormaKonfiguracijaPort(this, false);
        port.setVisible(true);
    }//GEN-LAST:event_jMenuItemPortActionPerformed

    private void jButtonPokreniServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPokreniServerActionPerformed
        server = new Server(this);
        server.start();
        jLabelStatus.setText("SERVER JE POKRENUT!");
        jButtonZaustaviServer.setEnabled(true);
        jButtonPokreniServer.setEnabled(false);
    }//GEN-LAST:event_jButtonPokreniServerActionPerformed

    private void jButtonZaustaviServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonZaustaviServerActionPerformed
        try {
            server.getServerSoket().close();
            jLabelStatus.setText("SERVER JE ZAUSTAVLJEN!");
            jButtonPokreniServer.setEnabled(true);
            jButtonZaustaviServer.setEnabled(false);
        } catch (IOException ex) {
            //Logger.getLogger(ServerskaForma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButtonZaustaviServerActionPerformed

    private void jButtonIzvestajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIzvestajActionPerformed

        try {
            String imagePath = getClass().getResource("/image/logo3.png").getPath();
            
            Map<String, Object> map = new HashMap<>();
            map.put("imagePath", imagePath);
            
            JasperPrint jprint = JasperFillManager.fillReport("report.jasper", map, DbConnectionFactory.getInstance().getConnection());
            JasperViewer.viewReport(jprint, false);
            
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonIzvestajActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIzvestaj;
    private javax.swing.JButton jButtonPokreniServer;
    private javax.swing.JButton jButtonZaustaviServer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemBaza;
    private javax.swing.JMenuItem jMenuItemPort;
    // End of variables declaration//GEN-END:variables
}