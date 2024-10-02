/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.login;

import domen.Zaposleni;
import java.util.List;
import operacija.ApstraktnaGenerickaOperacija;

/**
 *
 * @author Korisnik
 */
public class LoginOperacija extends ApstraktnaGenerickaOperacija {

    Zaposleni zaposleni;
    
    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param ==null || !(param instanceof Zaposleni)){
            throw new Exception("Sistem ne moze da pronadje nalog zaposlenog");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        List<Zaposleni> sviZaposleni = broker.getAll((Zaposleni) param, null);
        
        if(sviZaposleni.contains((Zaposleni)param)){
            for (Zaposleni z : sviZaposleni) {
            if(z.equals((Zaposleni)param)){
                zaposleni = z;
                return;
            }
            }
        }else{
            zaposleni = null;       
        }
        
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }
    
}
