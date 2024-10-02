/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package niti;

import controller.Controller;
import domen.Kupac;
import domen.Narudzbenica;
import domen.Proizvod;
import domen.StavkaNarudzbenice;
import domen.Zaposleni;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import komunikacija.Odgovor;
import komunikacija.Posiljalac;
import komunikacija.Primalac;
import komunikacija.Zahtev;

/**
 *
 * @author Korisnik
 */
public class ObradaKlijentskihZahteva extends Thread {
    
    Socket socket;
    Posiljalac posiljalac;
    Primalac primalac;

    public ObradaKlijentskihZahteva(Socket socket) {
        this.socket = socket;
        posiljalac = new Posiljalac(socket);
        primalac = new Primalac(socket);
    }
    
    @Override
    public void run() {
        while(true){
            try {
                Zahtev zahtev = (Zahtev) primalac.primi();
                Odgovor odgovor = new Odgovor();
                switch (zahtev.getOperacija()) {
                    case LOGIN:
                        Zaposleni z = (Zaposleni) zahtev.getParametar();
                        z = controller.Controller.getInstance().login(z);
                        odgovor.setOdgovor(z);
                        break;
                    case UCITAJ_PROIZVODE:
                        List<Proizvod>  proizvodi = Controller.getInstance().ucitajProizvode();
                        odgovor.setOdgovor(proizvodi);
                        break;
                    case OBRISI_PROIZVOD:
                        try{
                            Proizvod p = (Proizvod) zahtev.getParametar();
                            controller.Controller.getInstance().obrisiProizvod(p);
                            odgovor.setOdgovor(null);
                        }catch (Exception e){
                            odgovor.setOdgovor(e);
                        }
                        break;
                    case DODAJ_PROIZVOD:
                        Proizvod proizvod = (Proizvod) zahtev.getParametar();
                        controller.Controller.getInstance().dodajProizvod(proizvod);
                        odgovor.setOdgovor(null);
                        break;
                    case IZMENI_PROIZVOD:
                        Proizvod pr = (Proizvod) zahtev.getParametar();
                        controller.Controller.getInstance().izmeniProizvod(pr);
                        odgovor.setOdgovor(null);
                        break;
                    case DODAJ_KUPCA:
                        Kupac kupac = (Kupac) zahtev.getParametar();
                        controller.Controller.getInstance().dodajKupca(kupac);
                        odgovor.setOdgovor(null);
                        break;
                    case UCITAJ_KUPCE:
                        List<Kupac> kupci = Controller.getInstance().ucitajKupce();
                        odgovor.setOdgovor(kupci);
                        break;
                    case IZMENI_KUPCA:
                        Kupac k = (Kupac) zahtev.getParametar();
                        controller.Controller.getInstance().izmeniKupca(k);
                        odgovor.setOdgovor(null);
                        break;
                    case DODAJ_NARUDZBENICU:
                        Narudzbenica n = (Narudzbenica) zahtev.getParametar();
                        controller.Controller.getInstance().dodajNarudzbenicu(n);
                        odgovor.setOdgovor(null);
                        break;
                    case UCITAJ_NARUDZBENICE:
                        List<Narudzbenica>  narudzbenice = Controller.getInstance().ucitajNarudzbenice();
                        odgovor.setOdgovor(narudzbenice);
                        break;
                    case UCITAJ_STAVKE:
                        int id = (int) zahtev.getParametar();
                        List<StavkaNarudzbenice> stavke = Controller.getInstance().ucitajStavke(id);
                        odgovor.setOdgovor(stavke);
                        break;
                    case IZMENI_NARUDZBENICU:
                        Narudzbenica narudzbenica = (Narudzbenica) zahtev.getParametar();
                        controller.Controller.getInstance().izmeniNarudzbenicu(narudzbenica);
                        odgovor.setOdgovor(null);
                        break;
                    default:
                        System.out.println("GRESKA, OPERACIJA NE POSTOJI!");
                }
                posiljalac.posalji(odgovor);
            } catch (Exception ex) {
                Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}
