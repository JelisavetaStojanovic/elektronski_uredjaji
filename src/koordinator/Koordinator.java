/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koordinator;

import domen.Zaposleni;
import forme.DodajKupcaForma;
import forme.DodajProizvodForma;
import forme.DodajStavku;
import forme.FormaMod;
import forme.GlavnaForma;
import forme.IzmenaNarudzbeniceForma;
import forme.IzmeniStavkeForma;
import forme.LoginForma;
import forme.PrikazKupacaForma;
import forme.PrikazProizvodaForma;
import java.util.HashMap;
import java.util.Map;
import kontroleri.DodajKupcaController;
import kontroleri.DodajProizvodController;
import kontroleri.DodajStavkuController;
import kontroleri.GlavnaFormaController;
import kontroleri.IzmenaNarudzbeniceController;
import kontroleri.IzmeniStavkeController;
import kontroleri.LoginController;
import kontroleri.PrikazKupacaController;
import kontroleri.PrikazProizvodaController;

/**
 *
 * @author Korisnik
 */
public class Koordinator {
    private static Koordinator instance;
    private Zaposleni ulogovani;
    private LoginController loginController;
    public GlavnaFormaController glavnaFormaController;
    public PrikazProizvodaController ppController;
    private DodajProizvodController dpController;
    
    private DodajKupcaController dkController;
    public PrikazKupacaController pkController;
    
    private DodajStavkuController dsController;
    
    private IzmenaNarudzbeniceController inController;
    private IzmeniStavkeController isController;
    
    private Map<String, Object> parametri;

    public Koordinator() {
        parametri = new HashMap<>();
    }

    public static Koordinator getInstance() {
        if(instance == null){
            instance = new Koordinator();
        }
        return instance;
    }

    public void otvoriLoginFormu() {
        loginController = new LoginController(new LoginForma());
        loginController.otvoriFormu();
    }

    public void otvoriGlavnuFormu() {
        glavnaFormaController = new GlavnaFormaController(new GlavnaForma());
        glavnaFormaController.otvoriFormu();
    }

    public void otvoriPrikazProizvodaFormu() {
        ppController = new PrikazProizvodaController(new PrikazProizvodaForma());
        ppController.otvoriFormu();
    }
    
    public Zaposleni getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(Zaposleni ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void otvoriDodajProizvodFormu() {
        dpController = new DodajProizvodController(new DodajProizvodForma());
        dpController.otvoriFormu(FormaMod.DODAJ);
    }

    public void osveziTabeluProizvoda() {
        ppController.osveziFormu();
    }
    
    public void dodajParam(String s, Object o){
        parametri.put(s, o);
    }
    
    public Object vratiParam(String s){
        return parametri.get(s);
    }

    public void otvoriIzmeniProizvodFormu() {
        dpController = new DodajProizvodController(new DodajProizvodForma());
        dpController.otvoriFormu(FormaMod.IZMENI);
    }

    public void otvoriDodajKupcaFormu() {
        dkController = new DodajKupcaController(new DodajKupcaForma());
        dkController.otvoriFormu(FormaMod.DODAJ);
    }

    public void otvoriPrikazKupacaFormu() {
        pkController = new PrikazKupacaController(new PrikazKupacaForma());
        pkController.otvoriFormu();
    }

    public void otvoriIzmeniKupcaFormu() {
        dkController = new DodajKupcaController(new DodajKupcaForma());
        dkController.otvoriFormu(FormaMod.IZMENI);
    }

    public void osveziFormuKupaca() {
        pkController.osveziFormu();
    }

    public void otvoriDodajStavkuFormu(GlavnaForma gf) {
        dsController = new DodajStavkuController(new DodajStavku(gf, true));
        dsController.otvoriFormu();
    }

    public void otvoriIzmenaNarudzbeniceFormu() {
        inController = new IzmenaNarudzbeniceController(new IzmenaNarudzbeniceForma());
        inController.otvoriFormu();
    }

    public void otvoriIzmeniStavkeFormu(IzmenaNarudzbeniceForma inf) {
        isController = new IzmeniStavkeController(new IzmeniStavkeForma(inf, true));
        isController.otvoriFormu();
    }

    
}
