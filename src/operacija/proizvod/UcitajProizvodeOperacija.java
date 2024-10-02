/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.proizvod;

import domen.Proizvod;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class UcitajProizvodeOperacija extends ApstraktnaGenerickaOperacija {

    private List<Proizvod> proizvodi;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        proizvodi = broker.getAll(new Proizvod(), "");
    }

    public List<Proizvod> getProizvodi() {
        return proizvodi;
    }
    
    
}
