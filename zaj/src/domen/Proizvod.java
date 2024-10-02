/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Proizvod implements ApstraktniDomenskiObjekat{
    private int proizvodID;
    private double cena;
    private String naziv;
    private String model;

    public Proizvod() {
    }

    public Proizvod(int proizvodID, double cena, String naziv, String model) {
        this.proizvodID = proizvodID;
        this.cena = cena;
        this.naziv = naziv;
        this.model = model;
    }

    public int getProizvodID() {
        return proizvodID;
    }

    public void setProizvodID(int proizvodID) {
        this.proizvodID = proizvodID;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proizvod other = (Proizvod) obj;
        if (this.proizvodID != other.proizvodID) {
            return false;
        }
        return Objects.equals(this.naziv, other.naziv);
    }

    @Override
    public String vratiNazivTabele() {
        return "proizvod";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int proizvodID = rs.getInt("proizvod.proizvodID");
            double cena = rs.getDouble("proizvod.cena");
            String naziv = rs.getString("proizvod.naziv");
            String model = rs.getString("proizvod.model");
            
            Proizvod p = new Proizvod(proizvodID, cena, naziv, model);
            lista.add(p);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "cena,naziv,model";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return cena+",'"+naziv+"','"+model+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "proizvod.proizvodID="+proizvodID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "cena="+cena+", naziv='"+naziv+"', model='"+model+"'";
    }
    
    
}
