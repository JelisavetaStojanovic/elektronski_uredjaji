/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Narudzbenica;
import domen.Proizvod;
import forme.DodajKupcaForma;
import forme.FormaMod;
import forme.IzmenaNarudzbeniceForma;
import forme.model.ModelTabeleNarudzbenica;
import forme.model.ModelTabeleProizvod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class IzmenaNarudzbeniceController {
    private final IzmenaNarudzbeniceForma inf;

    public IzmenaNarudzbeniceController(IzmenaNarudzbeniceForma inf) {
        this.inf = inf;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        inf.setVisible(true);
    }

    private void addActionListener() {
        inf.addBtnPretragaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pretraga = inf.getjTextFieldPretraga().getText().trim();
                
                ModelTabeleNarudzbenica mtn = (ModelTabeleNarudzbenica) inf.getjTableNarudzbenica().getModel();
                mtn.pretrazi(pretraga);
                
                if(mtn.getLista().isEmpty()){
                    JOptionPane.showMessageDialog(inf, "Sistem ne može da nađe narudžbenice po zadatoj vrednosti", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(inf, "Sistem je našao narudžbenice po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });
        inf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                inf.getjTextFieldPretraga().setText("");
            }
        });
        inf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = inf.getjTableNarudzbenica().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(inf, "Sistem ne može da učita narudžbenicu", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(inf, "Sistem je učitao narudžbenicu", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ModelTabeleNarudzbenica mtn = (ModelTabeleNarudzbenica) inf.getjTableNarudzbenica().getModel();
                    Narudzbenica n = mtn.getLista().get(red);
                    inf.setN(n);
                    
                    koordinator.Koordinator.getInstance().otvoriIzmeniStavkeFormu(inf);
                    pripremiFormu();
                    inf.getjTextFieldPretraga().setText("");
                }
            }
        });
    }

    private void pripremiFormu() {
        List<Narudzbenica> narudzbenice = komunikacija.Komunikacija.getInstance().ucitajNarudzbenice();
        ModelTabeleNarudzbenica mtn = new ModelTabeleNarudzbenica(narudzbenice);
        inf.getjTableNarudzbenica().setModel(mtn);
    }
}
