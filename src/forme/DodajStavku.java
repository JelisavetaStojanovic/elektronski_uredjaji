/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package forme;

import domen.StavkaNarudzbenice;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Korisnik
 */
public class DodajStavku extends javax.swing.JDialog {

    /**
     * Creates new form DodajStavku
     */
    GlavnaForma parent;

    public DodajStavku(GlavnaForma parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        
    }

    public GlavnaForma getParent() {
        return parent;
    }

    public void setParent(GlavnaForma parent) {
        this.parent = parent;
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
        jTextFieldNaziv = new javax.swing.JTextField();
        jButtonPretraga = new javax.swing.JButton();
        jButtonResetujPretragu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProizvodi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldKolicina = new javax.swing.JTextField();
        jButtonIzaberi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonDodajUNarudzbenicu = new javax.swing.JButton();
        jLabelUkupnaCena = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretraži proizvode po nazivu:");

        jButtonPretraga.setText("Pretraži");

        jButtonResetujPretragu.setText("Resetuj pretragu");

        jTableProizvodi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProizvodi);

        jLabel2.setText("Količina proizvoda:");

        jButtonIzaberi.setText("Izaberi");

        jLabel3.setText("Ukupna cena:");

        jLabel4.setText("RSD");

        jButtonDodajUNarudzbenicu.setText("Dodaj u narudžbenicu");

        jLabelUkupnaCena.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonResetujPretragu, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldKolicina, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(jLabelUkupnaCena, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonIzaberi, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonDodajUNarudzbenicu, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPretraga)
                    .addComponent(jButtonResetujPretragu))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldKolicina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonIzaberi))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabelUkupnaCena))
                .addGap(32, 32, 32)
                .addComponent(jButtonDodajUNarudzbenicu)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDodajUNarudzbenicu;
    private javax.swing.JButton jButtonIzaberi;
    private javax.swing.JButton jButtonPretraga;
    private javax.swing.JButton jButtonResetujPretragu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelUkupnaCena;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProizvodi;
    private javax.swing.JTextField jTextFieldKolicina;
    private javax.swing.JTextField jTextFieldNaziv;
    // End of variables declaration//GEN-END:variables


    public void addBtnPretragaActionListener(ActionListener actionListener) {
        jButtonPretraga.addActionListener(actionListener);
    }
    
    public void addBtnResetujActionListener(ActionListener actionListener) {
        jButtonResetujPretragu.addActionListener(actionListener);
    }
    
    public void addBtnIzaberiActionListener(ActionListener actionListener) {
        jButtonIzaberi.addActionListener(actionListener);
    }
    
    public void addBtnDodajUNarudzbenicuActionListener(ActionListener actionListener) {
        jButtonDodajUNarudzbenicu.addActionListener(actionListener);
    }

    public JTextField getjTextFieldNaziv() {
        return jTextFieldNaziv;
    }

    public void setjTextFieldNaziv(JTextField jTextFieldNaziv) {
        this.jTextFieldNaziv = jTextFieldNaziv;
    }

    public JTable getjTableProizvodi() {
        return jTableProizvodi;
    }

    public void setjTableProizvodi(JTable jTableProizvodi) {
        this.jTableProizvodi = jTableProizvodi;
    }

    public JLabel getjLabelUkupnaCena() {
        return jLabelUkupnaCena;
    }

    public void setjLabelUkupnaCena(JLabel jLabelUkupnaCena) {
        this.jLabelUkupnaCena = jLabelUkupnaCena;
    }

    public JTextField getjTextFieldKolicina() {
        return jTextFieldKolicina;
    }

    public void setjTextFieldKolicina(JTextField jTextFieldKolicina) {
        this.jTextFieldKolicina = jTextFieldKolicina;
    }
    
    
    
}
