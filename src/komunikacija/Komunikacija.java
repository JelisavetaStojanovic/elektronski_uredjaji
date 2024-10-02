/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import domen.Kupac;
import domen.Narudzbenica;
import domen.Proizvod;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class Komunikacija {
    
    private Socket socket;
    private Posiljalac posiljalac;
    private Primalac primalac;
    private static Komunikacija instance;

    public Komunikacija() {
    }

    public static Komunikacija getInstance() {
        if(instance == null){
            instance = new Komunikacija();
        }
        return instance;
    }
    
    public void konekcija() {
        try {
            socket = new Socket("localhost", 9000);
            posiljalac = new Posiljalac(socket);
            primalac = new Primalac(socket);
        } catch (IOException ex) {
            System.out.println("Server nije povezan");
        }
    }

    public Zaposleni login(String username, String password) {
        Zaposleni z = new Zaposleni();
        z.setKorisnickoIme(username);
        z.setLozinka(password);
        Zahtev zahtev = new Zahtev(Operacije.LOGIN, z);
        
        posiljalac.posalji(zahtev);
        
        //////////////
        
        Odgovor odg = (Odgovor) primalac.primi();
        z = (Zaposleni) odg.getOdgovor();
        
        return z;
    }

    public List<Proizvod> ucitajProizvode() {
        List<Proizvod> proizvodi = new ArrayList<>();
        
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_PROIZVODE, null);
        
        posiljalac.posalji(zahtev);
        
        //////////////
        
        Odgovor odg = (Odgovor) primalac.primi();
        proizvodi = (List<Proizvod>) odg.getOdgovor();
        
        return proizvodi;
    }

    public void obrisiProizvod(Proizvod p) throws Exception {
        Zahtev zahtev = new Zahtev(Operacije.OBRISI_PROIZVOD, p);
        posiljalac.posalji(zahtev);
        ////////////
        Odgovor odg =  (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEH");
        }else{
            System.out.println("GREŠKA");
            throw new Exception("GREŠKA");
        }
        
        
    }

    public void dodajProizvod(Proizvod p) {
        Zahtev zahtev = new Zahtev(Operacije.DODAJ_PROIZVOD, p);
        posiljalac.posalji(zahtev);
        //////
        Odgovor odg =  (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEH");
        }else{
            System.out.println("GREŠKA");
        }
    }

    public void izmeniProizvod(Proizvod p) {
        Zahtev zahtev = new Zahtev(Operacije.IZMENI_PROIZVOD, p);
        posiljalac.posalji(zahtev);
        //////
        Odgovor odg =  (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEH");
            koordinator.Koordinator.getInstance().osveziTabeluProizvoda();
        }else{
            System.out.println("GREŠKA");
        }
    }

    public void dodajKupca(Kupac k) {
        Zahtev zahtev = new Zahtev(Operacije.DODAJ_KUPCA, k);
        posiljalac.posalji(zahtev);
        //////
        Odgovor odg =  (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEH");
        }else{
            System.out.println("GREŠKA");
        }
    }

    public List<Kupac> ucitajKupce() {
        List<Kupac> kupci = new ArrayList<>();
        
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_KUPCE, null);
        
        posiljalac.posalji(zahtev);
        
        //////////////
        
        Odgovor odg = (Odgovor) primalac.primi();
        kupci = (List<Kupac>) odg.getOdgovor();
        
        return kupci;
    }

    public void izmeniKupca(Kupac k) {
        Zahtev zahtev = new Zahtev(Operacije.IZMENI_KUPCA, k);
        posiljalac.posalji(zahtev);
        //////
        Odgovor odg =   (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEH");
            koordinator.Koordinator.getInstance().osveziFormuKupaca();
        }else{
            System.out.println("GREŠKA");
        }
    }

    public void dodajNarudzbenicu(Narudzbenica n) {
        Zahtev zahtev = new Zahtev(Operacije.DODAJ_NARUDZBENICU, n);
        posiljalac.posalji(zahtev);
        //////
        Odgovor odg =  (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEH");
        }else{
            System.out.println("GREŠKA");
        }
    }

    public List<Narudzbenica> ucitajNarudzbenice() {
        List<Narudzbenica> narudzbenice = new ArrayList<>();
        
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_NARUDZBENICE, null);
        
        posiljalac.posalji(zahtev);
        
        //////////////
        
        Odgovor odg = (Odgovor) primalac.primi();
        narudzbenice = (List<Narudzbenica>) odg.getOdgovor();
        
        return narudzbenice;
    }

    public List<StavkaNarudzbenice> ucitajStavkeNaOsnovuID(int narudzbenicaID) {
        List<StavkaNarudzbenice> stavke = new ArrayList<>();
        
        Zahtev zahtev = new Zahtev(Operacije.UCITAJ_STAVKE, narudzbenicaID);
        
        posiljalac.posalji(zahtev);
        
        //////////////
        
        Odgovor odg = (Odgovor) primalac.primi();
        stavke = (List<StavkaNarudzbenice>) odg.getOdgovor();
        
        return stavke;
    }

    public void izmeniNarudzbenicu(Narudzbenica n) {
        Zahtev zahtev = new Zahtev(Operacije.IZMENI_NARUDZBENICU, n);
        posiljalac.posalji(zahtev);
        //////
        Odgovor odg =  (Odgovor) primalac.primi();
        if(odg.getOdgovor()==null){
            System.out.println("USPEH");
        }else{
            System.out.println("GREŠKA");
        }
    }

    
}
