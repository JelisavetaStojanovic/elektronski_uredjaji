/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.kupac;

import domen.Kupac;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class KreirajKupcaOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param ==null || !(param instanceof Kupac)){
            throw new Exception("Sistem ne moze da kreira kupca");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        broker.add((Kupac)param);
    }
    
}
