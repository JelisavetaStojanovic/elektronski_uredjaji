/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Narudzbenica implements ApstraktniDomenskiObjekat{
    private int narudzbenicaID;
    private double ukupnaCena;
    private Date datumKreiranja;
    private Zaposleni zaposleni;
    private Kupac kupac;
    private List<StavkaNarudzbenice> listaStavki = new ArrayList<>();

    public Narudzbenica() {
    }

    public Narudzbenica(int narudzbenicaID, double ukupnaCena, Date datumKreiranja, Zaposleni zaposleni, Kupac kupac, List<StavkaNarudzbenice> listaStavki) {
        this.narudzbenicaID = narudzbenicaID;
        this.ukupnaCena = ukupnaCena;
        this.datumKreiranja = datumKreiranja;
        this.zaposleni = zaposleni;
        this.kupac = kupac;
        this.listaStavki = listaStavki;
    }

    public int getNarudzbenicaID() {
        return narudzbenicaID;
    }

    public void setNarudzbenicaID(int narudzbenicaID) {
        this.narudzbenicaID = narudzbenicaID;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public Zaposleni getZaposleni() {
        return zaposleni;
    }

    public void setZaposleni(Zaposleni zaposleni) {
        this.zaposleni = zaposleni;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public List<StavkaNarudzbenice> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaNarudzbenice> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String toString() {
        return "narudzbenicaID=" + narudzbenicaID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Narudzbenica other = (Narudzbenica) obj;
        if (this.narudzbenicaID != other.narudzbenicaID) {
            return false;
        }
        if (!Objects.equals(this.zaposleni, other.zaposleni)) {
            return false;
        }
        return Objects.equals(this.kupac, other.kupac);
    }

    @Override
    public String vratiNazivTabele() {
        return "narudzbenica";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Kupac k = new Kupac(rs.getInt("kupacID"), rs.getString("email"), rs.getString("ime"), rs.getString("prezime"), rs.getString("brojTelefona"));
            Zaposleni z = new Zaposleni(rs.getInt("zaposleniID"), rs.getString("korisnickoIme"), rs.getString("lozinka"), rs.getString("ime"), rs.getString("prezime"));
            java.sql.Date sqlDate = rs.getDate("datumKreiranja");
            java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
            Narudzbenica narudzbenica = new Narudzbenica(rs.getInt("narudzbenicaID"), rs.getDouble("ukupnaCena"), utilDate, z, k, listaStavki);
            lista.add(narudzbenica);
        }

        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "ukupnaCena,datumKreiranja,zaposleni,kupac";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        java.sql.Date sqlDate = new java.sql.Date(datumKreiranja.getTime());
        return ukupnaCena+",'"+sqlDate+"',"+zaposleni.getZaposleniID()+","+kupac.getKupacID();
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "narudzbenica.narudzbenicaID="+narudzbenicaID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        java.sql.Date sqlDate = new java.sql.Date(datumKreiranja.getTime());
        return "ukupnaCena="+ukupnaCena+", datumKreiranja='"+sqlDate+"', zaposleni="+zaposleni.getZaposleniID()+", kupac="+kupac.getKupacID();
    }
    
    
}
