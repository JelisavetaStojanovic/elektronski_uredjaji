/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;


import domen.IzvestajKlijent;
import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import forme.IzmeniStavkeForma;
import forme.model.ModelTabeleStavka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Korisnik
 */
public class IzmeniStavkeController {
    private final IzmeniStavkeForma isf;
    private double ukupnaCena = 0;

    public IzmeniStavkeController(IzmeniStavkeForma isf) {
        this.isf = isf;
        addActionListener();
    }

    public void otvoriFormu() {
        pripremiFormu();
        isf.setVisible(true);
     
    }

    private void pripremiFormu() {
        List<StavkaNarudzbenice> stavke = komunikacija.Komunikacija.getInstance().ucitajStavkeNaOsnovuID(isf.getParent().getN().getNarudzbenicaID());
        ModelTabeleStavka mts = new ModelTabeleStavka(stavke);
        isf.getjTableStavke().setModel(mts);
        
        for (StavkaNarudzbenice sn : stavke) {
            ukupnaCena += sn.getCenaStavke();
        }
        isf.getjLabelUkupnaCena().setText(ukupnaCena+"");
    }

    private void addActionListener() {
        isf.addBtnObrisiStavkuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int red = isf.getjTableStavke().getSelectedRow();
                if(red == -1){
                    JOptionPane.showMessageDialog(isf, "Niste izabrali stavku koju želite da obrišete", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete stavku narudžbenice?", "Potvrda", JOptionPane.YES_NO_OPTION);
                    if(potvrda == JOptionPane.NO_OPTION || potvrda == JOptionPane.CLOSED_OPTION){
                        return;
                    }
                    ModelTabeleStavka mts = (ModelTabeleStavka) isf.getjTableStavke().getModel();
                    StavkaNarudzbenice sn = mts.getLista().get(red);
                    
                    mts.obrisiStavku(sn);
                    ukupnaCena -= sn.getCenaStavke();
                    isf.getParent().getN().setUkupnaCena(ukupnaCena);
                    isf.getjLabelUkupnaCena().setText(ukupnaCena+"");
                }
            }

        });
        isf.addBtnDodajStavkuActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                do{
                    koordinator.Koordinator.getInstance().otvoriDodajStavkuFormu(null);
                
                    StavkaNarudzbenice sn = (StavkaNarudzbenice) koordinator.Koordinator.getInstance().vratiParam("stavka");
                    if(sn == null){
                        return;
                    }
                
                    sn.setNarudzbenica(isf.getParent().getN());
                    ModelTabeleStavka mts = (ModelTabeleStavka) isf.getjTableStavke().getModel();
                
                
                
                    List<StavkaNarudzbenice> stavke = mts.getLista();
                        for (StavkaNarudzbenice stavkaNarudzbenice : stavke) {
                            if(stavkaNarudzbenice.getProizvod().equals(sn.getProizvod())){
                                int novaKolicina = stavkaNarudzbenice.getKolicina()+sn.getKolicina();
                                mts.obrisiStavku(stavkaNarudzbenice);
                                stavkaNarudzbenice.setKolicina(novaKolicina);
                                stavkaNarudzbenice.setCenaStavke(sn.getCenaProizvoda()*novaKolicina);
                                mts.dodaj(stavkaNarudzbenice);
                            
                            
                                ukupnaCena += sn.getCenaStavke();
                                isf.getParent().getN().setUkupnaCena(ukupnaCena);
                                isf.getjLabelUkupnaCena().setText(ukupnaCena+""); 
                
                                return;
                            }
                        }
                
                    
                    
                    mts.dodaj(sn);
                
                    ukupnaCena += sn.getCenaStavke();
                    isf.getParent().getN().setUkupnaCena(ukupnaCena);
                    isf.getjLabelUkupnaCena().setText(ukupnaCena+"");
                    }while(JOptionPane.showConfirmDialog(null, "Da li želite da dodate još stavki u narudžbenicu?", "Potvrda", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
                
                
                
            }
            
        });
        
        isf.addBtnSacuvajStavkuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Narudzbenica n = isf.getParent().getN();
                n.setDatumKreiranja(new Date());
                
                ModelTabeleStavka mts = (ModelTabeleStavka) isf.getjTableStavke().getModel();
                n.setListaStavki(mts.getLista());

                n.setUkupnaCena(ukupnaCena);
                
                try{
                    komunikacija.Komunikacija.getInstance().izmeniNarudzbenicu(n);
                    JOptionPane.showMessageDialog(isf, "Sistem je zapamtio narudžbenicu", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    isf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(isf, "Sistem ne može da zapamti narudžbenicu", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        isf.addBtnIzvestajActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Narudzbenica n = isf.getParent().getN();
                List<StavkaNarudzbenice> stavke = komunikacija.Komunikacija.getInstance().ucitajStavkeNaOsnovuID(n.getNarudzbenicaID());
               
                List<IzvestajKlijent> lista = new ArrayList<>();
                for (StavkaNarudzbenice sn : stavke) {
                    sn.setNarudzbenica(n);
                    IzvestajKlijent ik = new IzvestajKlijent(sn.getStavkaID(),sn.getNarudzbenica().getNarudzbenicaID(),sn.getCenaProizvoda(),sn.getCenaStavke(),sn.getKolicina(),sn.getProizvod().getNaziv(),sn.getProizvod().getModel());
                    lista.add(ik);
                }
               
                try{
                    String imagePath = getClass().getResource("/image/logo3.png").getPath();
                    Map<String, Object> map = new HashMap<>();
                    map.put("imagePath", imagePath);
                    JasperPrint jprint = JasperFillManager.fillReport("klijent.jasper", map, new JRBeanCollectionDataSource(lista));
                    JasperViewer.viewReport(jprint, false);
                }catch(Exception exc){
                    exc.printStackTrace();
                    JOptionPane.showMessageDialog(isf.getParent(), exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

    }
 
}
