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
public class StavkaNarudzbenice implements ApstraktniDomenskiObjekat{
    private int stavkaID;
    private Narudzbenica narudzbenica;
    private double cenaProizvoda;
    private double cenaStavke;
    private int kolicina;
    private Proizvod proizvod;

    public StavkaNarudzbenice() {
    }

    public StavkaNarudzbenice(int stavkaID, Narudzbenica narudzbenica, double cenaProizvoda, double cenaStavke, int kolicina, Proizvod proizvod) {
        this.stavkaID = stavkaID;
        this.narudzbenica = narudzbenica;
        this.cenaProizvoda = cenaProizvoda;
        this.cenaStavke = cenaStavke;
        this.kolicina = kolicina;
        this.proizvod = proizvod;
    }

    public int getStavkaID() {
        return stavkaID;
    }

    public void setStavkaID(int stavkaID) {
        this.stavkaID = stavkaID;
    }

    public Narudzbenica getNarudzbenica() {
        return narudzbenica;
    }

    public void setNarudzbenica(Narudzbenica narudzbenica) {
        this.narudzbenica = narudzbenica;
    }

    public double getCenaProizvoda() {
        return cenaProizvoda;
    }

    public void setCenaProizvoda(double cenaProizvoda) {
        this.cenaProizvoda = cenaProizvoda;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Proizvod getProizvod() {
        return proizvod;
    }

    public void setProizvod(Proizvod proizvod) {
        this.proizvod = proizvod;
    }

    @Override
    public String toString() {
        return "stavkaID=" + stavkaID + ", narudzbenica=" + narudzbenica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final StavkaNarudzbenice other = (StavkaNarudzbenice) obj;
        if (this.stavkaID != other.stavkaID) {
            return false;
        }
        if (Double.doubleToLongBits(this.cenaProizvoda) != Double.doubleToLongBits(other.cenaProizvoda)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cenaStavke) != Double.doubleToLongBits(other.cenaStavke)) {
            return false;
        }
        if (this.kolicina != other.kolicina) {
            return false;
        }
        if (!Objects.equals(this.narudzbenica, other.narudzbenica)) {
            return false;
        }
        return Objects.equals(this.proizvod, other.proizvod);
    }
    
    @Override
    public String vratiNazivTabele() {
        return "stavkanarudzbenice";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Proizvod p = new Proizvod(rs.getInt("proizvodID"), rs.getDouble("cena"), rs.getString("naziv"), rs.getString("model"));
            StavkaNarudzbenice stavka = new StavkaNarudzbenice(rs.getInt("stavkaID"), narudzbenica, rs.getDouble("cenaProizvoda"), rs.getDouble("cenaStavke"), rs.getInt("kolicina"), p);
            lista.add(stavka);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "narudzbenica,cenaProizvoda,cenaStavke,kolicina,proizvod";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return narudzbenica.getNarudzbenicaID()+","+cenaProizvoda+","+cenaStavke+","+kolicina+","+proizvod.getProizvodID();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "stavkanarudzbenice.stavkaID="+stavkaID+" AND "+"stavkanarudzbenice.narudzbenica="+narudzbenica.getNarudzbenicaID();
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "narudzbenica="+narudzbenica.getNarudzbenicaID()+", cenaProizvoda="+cenaProizvoda+", cenaStavke="+cenaStavke+", kolicina="+kolicina+", proizvod="+proizvod.getProizvodID();
    }
    
    
}
