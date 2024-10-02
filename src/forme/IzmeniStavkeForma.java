/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.Narudzbenica;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author Korisnik
 */
public class IzmeniStavkeForma extends javax.swing.JDialog {

    /**
     * Creates new form IzmeniStavkeForma
     */
    IzmenaNarudzbeniceForma parent;
    
    public IzmeniStavkeForma(IzmenaNarudzbeniceForma parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        
    }

    public IzmenaNarudzbeniceForma getParent() {
        return parent;
    }

    public void setParent(IzmenaNarudzbeniceForma parent) {
        this.parent = parent;
    }

    public JTable getjTableStavke() {
        return jTableStavke;
    }

    public void setjTableStavke(JTable jTableStavke) {
        this.jTableStavke = jTableStavke;
    }
    
    public void addBtnObrisiStavkuActionListener(ActionListener actionListener) {
        jButtonObrisi.addActionListener(actionListener);
    }
    
    public void addBtnSacuvajStavkuActionListener(ActionListener actionListener) {
        jButtonSacuvaj.addActionListener(actionListener);
    }
    
    public void addBtnDodajStavkuActionListener(ActionListener actionListener) {
        jButtonDodaj.addActionListener(actionListener);
    }
    
    public void addBtnIzvestajActionListener(ActionListener actionListener) {
        jButtonIzvestaj.addActionListener(actionListener);
    }

    public JLabel getjLabelUkupnaCena() {
        return jLabelUkupnaCena;
    }

    public void setjLabelUkupnaCena(JLabel jLabelUkupnaCena) {
        this.jLabelUkupnaCena = jLabelUkupnaCena;
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
        jTableStavke = new javax.swing.JTable();
        jButtonDodaj = new javax.swing.JButton();
        jButtonObrisi = new javax.swing.JButton();
        jButtonSacuvaj = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabelUkupnaCena = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonIzvestaj = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableStavke);

        jButtonDodaj.setText("Dodaj");

        jButtonObrisi.setText("Obriši");

        jButtonSacuvaj.setText("Sačuvaj promene");

        jLabel1.setText("Ukupna cena: ");

        jLabelUkupnaCena.setText("0");

        jLabel3.setText("RSD");

        jButtonIzvestaj.setText("Prikaži izveštaj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUkupnaCena, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButtonIzvestaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelUkupnaCena)
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonDodaj)
                            .addComponent(jButtonObrisi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonIzvestaj)
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodaj;
    private javax.swing.JButton jButtonIzvestaj;
    private javax.swing.JButton jButtonObrisi;
    private javax.swing.JButton jButtonSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelUkupnaCena;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableStavke;
    // End of variables declaration//GEN-END:variables
}
