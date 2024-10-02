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
public class Kupac implements ApstraktniDomenskiObjekat{
    
    private int kupacID;
    private String email;
    private String ime;
    private String prezime;
    private String brojTelefona;

    public Kupac() {
    }

    public Kupac(int kupacID, String email, String ime, String prezime, String brojTelefona) {
        this.kupacID = kupacID;
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
    }

    public int getKupacID() {
        return kupacID;
    }

    public void setKupacID(int kupacID) {
        this.kupacID = kupacID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
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
        final Kupac other = (Kupac) obj;
        if (this.kupacID != other.kupacID) {
            return false;
        }
        return Objects.equals(this.email, other.email);
    }

    @Override
    public String vratiNazivTabele() {
        return "kupac";
    }

    @Override
    public List<ApstraktniDomenskiObjekat> vratiListu(ResultSet rs) throws Exception {
        List<ApstraktniDomenskiObjekat> lista = new ArrayList<>();
        while(rs.next()){
            int kupacID = rs.getInt("kupac.kupacID");
            String email = rs.getString("kupac.email");
            String ime = rs.getString("kupac.ime");
            String prezime = rs.getString("kupac.prezime");
            String brojTelefona = rs.getString("kupac.brojTelefona");
            
            Kupac k = new Kupac(kupacID, email, ime, prezime, brojTelefona);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String vratiKoloneZaUbacivanje() {
        return "email,ime,prezime,brojTelefona";
    }

    @Override
    public String vratiVrednostiZaUbacivanje() {
        return "'"+email+"','"+ime+"','"+prezime+"','"+brojTelefona+"'";
    }

    @Override
    public String vratiPrimarniKljuc() {
        return "kupac.kupacID="+kupacID;
    }

    @Override
    public ApstraktniDomenskiObjekat vratiObjekatIzRs(ResultSet rs) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vratiVrednostiZaIzmenu() {
        return "email='"+email+"', ime='"+ime+"', prezime='"+prezime+"', brojTelefona='"+brojTelefona+"'";
    }
    
    
}
