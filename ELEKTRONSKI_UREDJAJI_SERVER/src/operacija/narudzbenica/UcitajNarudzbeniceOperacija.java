/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.narudzbenica;

import domen.Narudzbenica;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajNarudzbeniceOperacija extends ApstraktnaGenerickaOperacija {
    
    private List<Narudzbenica> narudzbenice;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        String uslov = " JOIN kupac ON narudzbenica.kupac = kupac.kupacID JOIN zaposleni ON narudzbenica.zaposleni = zaposleni.zaposleniID";
        narudzbenice = broker.getAll(new Narudzbenica(), uslov);
    }

    public List<Narudzbenica> getNarudzbenice() {
        return narudzbenice;
    }

}
