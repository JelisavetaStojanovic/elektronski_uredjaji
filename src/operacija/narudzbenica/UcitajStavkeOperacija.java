/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.narudzbenica;

import domen.StavkaNarudzbenice;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajStavkeOperacija extends ApstraktnaGenerickaOperacija {
    private List<StavkaNarudzbenice> stavke;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        int id = Integer.parseInt(kljuc);
        String uslov = " JOIN proizvod ON stavkanarudzbenice.proizvod = proizvod.proizvodID WHERE narudzbenica="+id;
        stavke = broker.getAll(new StavkaNarudzbenice(), uslov);
    }

    public List<StavkaNarudzbenice> getStavke() {
        return stavke;
    }

    
}
