/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Narudzbenica;
import domen.Proizvod;
import domen.StavkaNarudzbenice;
import forme.DodajStavku;
import forme.model.ModelTabeleProizvod;
import forme.model.ModelTabeleStavka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class DodajStavkuController {
    
    private final DodajStavku ds;

    public DodajStavkuController(DodajStavku ds) {
        this.ds = ds;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        ds.setVisible(true);
     
    }

    private void pripremiFormu() {
        List<Proizvod> proizvodi = komunikacija.Komunikacija.getInstance().ucitajProizvode();
        ModelTabeleProizvod mtp = new ModelTabeleProizvod(proizvodi);
        ds.getjTableProizvodi().setModel(mtp);
    }

    private void addActionListener() {
        
        StavkaNarudzbenice stavka = new StavkaNarudzbenice();
        
        ds.addBtnIzaberiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = ds.getjTableProizvodi().getSelectedRow();
                Proizvod p;
                if(red == -1){
                    JOptionPane.showMessageDialog(ds, "Niste odabrali proizvod", "Greška", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else{
                    ModelTabeleProizvod mtp = (ModelTabeleProizvod) ds.getjTableProizvodi().getModel();
                    p = mtp.getLista().get(red);
                    
                }
                
                int kolicina;
                try{
                    kolicina = Integer.parseInt(ds.getjTextFieldKolicina().getText());
                } catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(ds, "Greška, niste ispravno uneli količinu", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(kolicina == 0){
                    JOptionPane.showMessageDialog(ds, "Greška, količina ne može biti 0", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double cenaProizvoda = p.getCena();
                double cenaStavke = cenaProizvoda*kolicina;
                
                ds.getjLabelUkupnaCena().setText(cenaStavke+"");
                
                stavka.setCenaProizvoda(cenaProizvoda);
                stavka.setCenaStavke(cenaStavke);
                stavka.setKolicina(kolicina);
                stavka.setProizvod(p);
                
            }
        });
        ds.addBtnDodajUNarudzbenicuActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stavka.getCenaStavke() == 0){
                    JOptionPane.showMessageDialog(ds, "Greška, niste uneli sve potrebne podatke", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(ds.getParent() != null){//kad pozivas u delu gde dodajes
                    
                    Narudzbenica n = ds.getParent().getN();
                    stavka.setNarudzbenica(n);
                    
                    ModelTabeleStavka mts = (ModelTabeleStavka) ds.getParent().getjTableStavke().getModel();
                    List<StavkaNarudzbenice> stavke = mts.getLista();
                    for (StavkaNarudzbenice sn : stavke) {
                        if(sn.getProizvod().equals(stavka.getProizvod())){
                            int novaKolicina = sn.getKolicina()+stavka.getKolicina();
                            mts.obrisiStavku(sn);
                            sn.setKolicina(novaKolicina);
                            sn.setCenaStavke(sn.getCenaProizvoda()*novaKolicina);
                            mts.dodaj(sn);
                            koordinator.Koordinator.getInstance().glavnaFormaController.pripremiFormuStavki();
                            
                            JOptionPane.showMessageDialog(ds, "Uspešno ste dodali stavku u narudžbenicu", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                            ds.dispose();
                            return;
                        }
                    }
                    
                    ds.getParent().getN().getListaStavki().add(stavka);
                }
                else{//kad pozivas u delu za izmenu
                    
                    koordinator.Koordinator.getInstance().dodajParam("stavka", stavka);
                }
                JOptionPane.showMessageDialog(ds, "Uspešno ste dodali stavku u narudžbenicu", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                ds.dispose();
            }
            
        });
        ds.addBtnPretragaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String naziv = ds.getjTextFieldNaziv().getText().trim();
                
                ModelTabeleProizvod mtp = (ModelTabeleProizvod) ds.getjTableProizvodi().getModel();
                mtp.pretrazi(naziv);
                JOptionPane.showMessageDialog(ds, "Sistem je našao proizvode po zadatoj vrednosti", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        ds.addBtnResetujActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pripremiFormu();
                ds.getjTextFieldNaziv().setText("");
            }
        });
    }

   
    
}
