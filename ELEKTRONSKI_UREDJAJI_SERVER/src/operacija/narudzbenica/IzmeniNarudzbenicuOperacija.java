/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.narudzbenica;

import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import java.util.Date;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class IzmeniNarudzbenicuOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param ==null || !(param instanceof Narudzbenica)){
            throw new Exception("Sistem ne moze da zapamti narudzbenicu");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        Narudzbenica n = (Narudzbenica) param;

        List<StavkaNarudzbenice> stavke = broker.getAll(new StavkaNarudzbenice(), " JOIN proizvod ON stavkanarudzbenice.proizvod = proizvod.proizvodID JOIN narudzbenica ON stavkanarudzbenice.narudzbenica = narudzbenica.narudzbenicaID WHERE narudzbenica="+n.getNarudzbenicaID());
        List<StavkaNarudzbenice> noveStavke = n.getListaStavki();
                
        for (StavkaNarudzbenice sn : stavke) {
            if(!noveStavke.contains(sn)){
                sn.setNarudzbenica(n);
                broker.delete(sn);
            }
        }
      
        for (StavkaNarudzbenice sn : noveStavke) {
            if(!stavke.contains(sn)){
                sn.setNarudzbenica(n);
                broker.add(sn);
            }
        }
        
        n.setDatumKreiranja(new Date());
        broker.edit(n);

    }
    
}
