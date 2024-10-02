/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Kupac;
import forme.PrikazKupacaForma;
import forme.model.ModelTabeleKupac;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;



/**
 *
 * @author Korisnik
 */
public class PrikazKupacaController {
    
    private final PrikazKupacaForma pkf;

    public PrikazKupacaController(PrikazKupacaForma pkf) {
        this.pkf = pkf;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        pkf.setVisible(true);
    }
    
    private void pripremiFormu() {
        List<Kupac> kupci = komunikacija.Komunikacija.getInstance().ucitajKupce();
        ModelTabeleKupac mtk = new ModelTabeleKupac(kupci);
        pkf.getjTableKupci().setModel(mtk);
    }

    private void addActionListener() {
        pkf.addBtnIzmeniActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = pkf.getjTableKupci().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(pkf, "Sistem ne može da učita kupca", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(pkf, "Sistem je učitao kupca", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ModelTabeleKupac mtk = (ModelTabeleKupac) pkf.getjTableKupci().getModel();
                    Kupac k = mtk.getLista().get(red);
                    
                    koordinator.Koordinator.getInstance().dodajParam("kupac", k);
                    koordinator.Koordinator.getInstance().otvoriIzmeniKupcaFormu();
                    
                    pripremiFormu();
                    pkf.getjTextFieldPretraga().setText("");
                }
            }
        });
        pkf.addBtnPretragaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pretraga = pkf.getjTextFieldPretraga().getText().trim();
                
                ModelTabeleKupac mtk = (ModelTabeleKupac) pkf.getjTableKupci().getModel();
                mtk.pretrazi(pretraga);
                
                if(mtk.getLista().isEmpty()){
                    JOptionPane.showMessageDialog(pkf, "Sistem ne može da nađe kupce po zadatoj vrednosti", "Greška", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(pkf, "Sistem je našao kupce po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                }
                
            }
        });
        pkf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                pkf.getjTextFieldPretraga().setText("");
            }
        });
    }

    public void osveziFormu() {
        pripremiFormu();
    }
}
