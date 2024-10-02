/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domen;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class IzvestajKlijent implements Serializable{
    
    private int stavkaID;
    private int narudzbenicaID;
    private double cenaProizvoda;
    private double cenaStavke;
    private int kolicina;
    private String nazivProizvoda;
    private String modelProizvoda;

    public IzvestajKlijent(int stavkaID, int narudzbenicaID, double cenaProizvoda, double cenaStavke, int kolicina, String nazivProizvoda, String modelProizvoda) {
        this.stavkaID = stavkaID;
        this.narudzbenicaID = narudzbenicaID;
        this.cenaProizvoda = cenaProizvoda;
        this.cenaStavke = cenaStavke;
        this.kolicina = kolicina;
        this.nazivProizvoda = nazivProizvoda;
        this.modelProizvoda = modelProizvoda;
    }

    public int getStavkaID() {
        return stavkaID;
    }

    public void setStavkaID(int stavkaID) {
        this.stavkaID = stavkaID;
    }

    public int getNarudzbenicaID() {
        return narudzbenicaID;
    }

    public void setNarudzbenicaID(int narudzbenicaID) {
        this.narudzbenicaID = narudzbenicaID;
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

    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    public String getModelProizvoda() {
        return modelProizvoda;
    }

    public void setModelProizvoda(String modelProizvoda) {
        this.modelProizvoda = modelProizvoda;
    }

    @Override
    public String toString() {
        return "IzvestajKlijent{" + "stavkaID=" + stavkaID + ", narudzbenicaID=" + narudzbenicaID + ", cenaProizvoda=" + cenaProizvoda + ", cenaStavke=" + cenaStavke + ", kolicina=" + kolicina + ", nazivProizvoda=" + nazivProizvoda + ", modelProizvoda=" + modelProizvoda + '}';
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
        final IzvestajKlijent other = (IzvestajKlijent) obj;
        if (this.stavkaID != other.stavkaID) {
            return false;
        }
        if (this.narudzbenicaID != other.narudzbenicaID) {
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
        if (!Objects.equals(this.nazivProizvoda, other.nazivProizvoda)) {
            return false;
        }
        return Objects.equals(this.modelProizvoda, other.modelProizvoda);
    }
    
    
    
}
