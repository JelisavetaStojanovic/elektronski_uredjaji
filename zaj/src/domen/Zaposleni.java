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
public class Zaposleni implements ApstraktniDomenskiObjekat{
    private int zaposleniID;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;

    public Zaposleni() {
    }

    public Zaposleni(int zaposleniID, String korisnickoIme, String lozinka, String ime, String prezime) {
        this.zaposleniID = zaposleniID;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + prezime;
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
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        return Objects.equals(this.lozinka, other.lozinka);
    }

    @Override
    public String vratiNazivTabele() {
        return "zaposleni";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int zaposleniID = rs.getInt("zaposleni.zaposleniID");
            String korisnickoIme = rs.getString("zaposleni.korisnickoIme");
            String lozinka = rs.getString("zaposleni.lozinka");
            String ime = rs.getString("zaposleni.ime");
            String prezime = rs.getString("zaposleni.prezime");
            
            Zaposleni z = new Zaposleni(zaposleniID, korisnickoIme, lozinka, ime, prezime);
            lista.add(z);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "korisnickoIme,lozinka,ime,prezime";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+korisnickoIme+"','"+lozinka+"','"+ime+"','"+prezime+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "zaposleni.zaposleniID="+zaposleniID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "korisnickoIme='"+korisnickoIme+"', lozinka='"+lozinka+"', ime='"+ime+"', prezime='"+prezime+"'";
    }
    
    
    
}
