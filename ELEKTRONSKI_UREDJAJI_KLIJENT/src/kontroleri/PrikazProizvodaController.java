/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Proizvod;
import forme.PrikazProizvodaForma;
import forme.model.ModelTabeleProizvod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import koordinator.Koordinator;

/**
 *
 * @author Korisnik
 */
public class PrikazProizvodaController {
    
    private final PrikazProizvodaForma ppf;

    public PrikazProizvodaController(PrikazProizvodaForma ppf) {
        this.ppf = ppf;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        ppf.setVisible(true);
     
    }

    private void pripremiFormu() {
        List<Proizvod> proizvodi = komunikacija.Komunikacija.getInstance().ucitajProizvode();
        ModelTabeleProizvod mtp = new ModelTabeleProizvod(proizvodi);
        ppf.getjTableProizvodi().setModel(mtp);
    }

    private void addActionListener() {

        ppf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ppf.getjTableProizvodi().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(ppf, "Sistem ne može da učita proizvod", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(ppf, "Sistem je učitao proizvod", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ModelTabeleProizvod mtp = (ModelTabeleProizvod) ppf.getjTableProizvodi().getModel();
                    Proizvod p = mtp.getLista().get(red);
                    
                    koordinator.Koordinator.getInstance().dodajParam("proizvod", p);
                    koordinator.Koordinator.getInstance().otvoriIzmeniProizvodFormu();
                    pripremiFormu();
                    ppf.getjTextFieldNaziv().setText("");
                }
            }
        });
        ppf.addBtnPretragaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = ppf.getjTextFieldNaziv().getText().trim();
                
                ModelTabeleProizvod mtp = (ModelTabeleProizvod) ppf.getjTableProizvodi().getModel();
                mtp.pretrazi(naziv);
                if(mtp.getLista().isEmpty()){
                    JOptionPane.showMessageDialog(ppf, "Sistem ne može da nađe proizvode po zadatoj vrednosti", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(ppf, "Sistem je našao proizvode po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });
        ppf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                ppf.getjTextFieldNaziv().setText("");
            }
        });
    }

    public void osveziFormu() {
        pripremiFormu();
    }
    
    
}
