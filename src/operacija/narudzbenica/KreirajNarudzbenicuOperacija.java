/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operacija.narudzbenica;

import domen.Narudzbenica;
import domen.StavkaNarudzbenice;
import operacija.ApstraktnaGenerickaOperacija;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Korisnik
 */
public class KreirajNarudzbenicuOperacija extends ApstraktnaGenerickaOperacija {

    @Override
    protected void preduslovi(Object param) throws Exception {
        if(param ==null || !(param instanceof Narudzbenica)){
            throw new Exception("Sistem ne moze da kreira narudzbenicu");
        }
    }

    @Override
    protected void izvrsiOperaciju(Object param, String kljuc) throws Exception {
        
        Narudzbenica n = (Narudzbenica) param;
        PreparedStatement ps = broker.add(param);
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int nId = rs.getInt(1);
        n.setNarudzbenicaID(nId);
        
        for (StavkaNarudzbenice sn : n.getListaStavki()) {
            sn.setNarudzbenica(n);
            broker.add(sn);
        }
        
        
    }
    
}
