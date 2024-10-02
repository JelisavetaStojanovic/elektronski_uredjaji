/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Kupac;
import domen.Narudzbenica;
import domen.Proizvod;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import forme.GlavnaForma;
import forme.model.ModelTabeleKupac;
import forme.model.ModelTabeleProizvod;
import forme.model.ModelTabeleStavka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class GlavnaFormaController {
    private final GlavnaForma gf;
    double ukupnaCena;

    public GlavnaFormaController(GlavnaForma gf) {
        this.gf = gf;
        addActionListeners();
    }

    private void addActionListeners() {
        gf.addBtnIzaberiProizvodActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(gf.getN().getKupac()==null){
                    JOptionPane.showMessageDialog(gf, "Niste izabrali kupca", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                do{
                    koordinator.Koordinator.getInstance().otvoriDodajStavkuFormu(gf);
                    pripremiFormuStavki();
                    ukupnaCena = 0;
                    for (StavkaNarudzbenice sn : gf.getN().getListaStavki()) {
                        ukupnaCena += sn.getCenaStavke();
                        gf.getjLabelUkupnaCena().setText(ukupnaCena+"");
                    }
                    gf.getN().setUkupnaCena(ukupnaCena);
                }while(JOptionPane.showConfirmDialog(null, "Da li želite da dodate još stavki u narudžbenicu?", "Potvrda", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
                
            }
        });
        gf.addBtnPretragaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pretraga = gf.getjTextFieldPretraga().getText().trim();
                
                ModelTabeleKupac mtk = (ModelTabeleKupac) gf.getjTableKupci().getModel();
                mtk.pretrazi(pretraga);
                JOptionPane.showMessageDialog(gf, "Sistem je našao kupce po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        gf.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormuKupaca();
                gf.getjTextFieldPretraga().setText("");
            }

        });
        gf.addBtnIzaberiKupcaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = gf.getjTableKupci().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(gf, "Sistem ne može da učita kupca", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(gf, "Sistem je učitao kupca", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    ModelTabeleKupac mtk = (ModelTabeleKupac) gf.getjTableKupci().getModel();
                    Kupac k = mtk.getLista().get(red);
                    
                    gf.getjLabelIzabraniKupac().setText(k.getIme()+" "+k.getPrezime());
                    gf.getN().setKupac(k);
                }
            }

        });
        gf.addBtnSacuvajNarudzbenicuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                double ukupnaCena = Double.parseDouble(gf.getjLabelUkupnaCena().getText());
                if(ukupnaCena <= 0){
                    JOptionPane.showMessageDialog(gf, "Niste izabrali proizvod", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Narudzbenica n = gf.getN();
                n.setDatumKreiranja(new Date());
                n.setZaposleni(koordinator.Koordinator.getInstance().getUlogovani());
                
                try{
                    komunikacija.Komunikacija.getInstance().dodajNarudzbenicu(n);
                    JOptionPane.showMessageDialog(gf, "Sistem je kreirao narudžbenicu", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li želite da kreirate novu narudžbenicu?", "Potvrda", JOptionPane.YES_NO_OPTION);
                    if(potvrda == JOptionPane.YES_OPTION){
                        koordinator.Koordinator.getInstance().otvoriGlavnuFormu();
                    }
                    gf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(gf, "Sistem ne može da kreira narudžbenicu", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        gf.addBtnObrisiStavkuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = gf.getjTableStavke().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(gf, "Niste izabrali stavku koju želite da obrišete", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete stavku narudžbenice?", "Potvrda", JOptionPane.YES_NO_OPTION);
                    if(potvrda == JOptionPane.NO_OPTION || potvrda == JOptionPane.CLOSED_OPTION){
                        return;
                    }
                    ModelTabeleStavka mts = (ModelTabeleStavka) gf.getjTableStavke().getModel();
                    StavkaNarudzbenice sn = mts.getLista().get(red);
                    
                    mts.obrisiStavku(sn);
                    pripremiFormuStavki();
                    
                    ukupnaCena -= sn.getCenaStavke();
                    gf.getN().setUkupnaCena(ukupnaCena);
                    gf.getjLabelUkupnaCena().setText(ukupnaCena+"");
                }
            }

        });
    }

    public void otvoriFormu() {
        Zaposleni ulogovani = koordinator.Koordinator.getInstance().getUlogovani();
        String imePrezime = ulogovani.getIme()+" "+ulogovani.getPrezime();
        pripremiFormuStavki();
        pripremiFormuKupaca();
        gf.setVisible(true);
        gf.getjLabelUlogovani().setText(imePrezime);
    }
    
    public void pripremiFormuStavki() {
        List<StavkaNarudzbenice> stavke = gf.getN().getListaStavki();
        ModelTabeleStavka mts = new ModelTabeleStavka(stavke);
        gf.getjTableStavke().setModel(mts);
    }
    
    public void pripremiFormuKupaca() {//public, ako dodam kupca da se azurira
        List<Kupac> kupci = komunikacija.Komunikacija.getInstance().ucitajKupce();
        ModelTabeleKupac mtk = new ModelTabeleKupac(kupci);
        gf.getjTableKupci().setModel(mtk);
    }
}
