/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import domen.Kupac;
import domen.Narudzbenica;
import domen.Proizvod;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import java.util.List;
import operacija.kupac.IzmeniKupcaOperacija;
import operacija.kupac.KreirajKupcaOperacija;
import operacija.kupac.UcitajKupceOperacija;
import operacija.login.LoginOperacija;
import operacija.narudzbenica.IzmeniNarudzbenicuOperacija;
import operacija.narudzbenica.KreirajNarudzbenicuOperacija;
import operacija.narudzbenica.UcitajNarudzbeniceOperacija;
import operacija.narudzbenica.UcitajStavkeOperacija;
import operacija.proizvod.IzmeniProizvodOperacija;
import operacija.proizvod.KreirajProizvodOperacija;
import operacija.proizvod.ObrisiProizvodOperacija;
import operacija.proizvod.UcitajProizvodeOperacija;

/**
 *
 * @author Korisnik
 */
public class Controller {
    
    private static Controller instance;

    private Controller() {
        
    }

    public static Controller getInstance() {
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public Zaposleni login(Zaposleni z) throws Exception {
        
        LoginOperacija operacija = new LoginOperacija();
        operacija.izvrsi(z, null);
        return operacija.getZaposleni();
    }

    public List<Proizvod> ucitajProizvode() throws Exception {
        UcitajProizvodeOperacija operacija = new UcitajProizvodeOperacija();
        operacija.izvrsi(null, null);
        return operacija.getProizvodi();
    }

    public void obrisiProizvod(Proizvod p) throws Exception {
        ObrisiProizvodOperacija operacija = new ObrisiProizvodOperacija();
        operacija.izvrsi(p, null);
    }

    public void dodajProizvod(Proizvod proizvod) throws Exception {
        KreirajProizvodOperacija operacija = new KreirajProizvodOperacija();
        operacija.izvrsi(proizvod, null);
    }

    public void izmeniProizvod(Proizvod pr) throws Exception {
        IzmeniProizvodOperacija operacija = new IzmeniProizvodOperacija();
        operacija.izvrsi(pr, null);
    }

    public void dodajKupca(Kupac kupac) throws Exception {
        KreirajKupcaOperacija operacija = new KreirajKupcaOperacija();
        operacija.izvrsi(kupac, null);
    }

    public List<Kupac> ucitajKupce() throws Exception {
        UcitajKupceOperacija operacija = new UcitajKupceOperacija();
        operacija.izvrsi(null, null);
        return operacija.getKupci();
    }

    public void izmeniKupca(Kupac k) throws Exception {
        IzmeniKupcaOperacija operacija = new IzmeniKupcaOperacija();
        operacija.izvrsi(k, null);
    }

    public void dodajNarudzbenicu(Narudzbenica n) throws Exception {
        KreirajNarudzbenicuOperacija operacija = new KreirajNarudzbenicuOperacija();
        operacija.izvrsi(n, null);
    }

    public List<Narudzbenica> ucitajNarudzbenice() throws Exception {
        UcitajNarudzbeniceOperacija operacija = new UcitajNarudzbeniceOperacija();
        operacija.izvrsi(null, null);
        return operacija.getNarudzbenice();
    }

    public List<StavkaNarudzbenice> ucitajStavke(int id) throws Exception {
        UcitajStavkeOperacija operacija = new UcitajStavkeOperacija();
        operacija.izvrsi(null, id+"");
        return operacija.getStavke();
    }

    public void izmeniNarudzbenicu(Narudzbenica narudzbenica) throws Exception {
        IzmeniNarudzbenicuOperacija operacija = new IzmeniNarudzbenicuOperacija();
        operacija.izvrsi(narudzbenica, null);
    }

}
