/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Kupac;
import domen.Proizvod;
import forme.DodajKupcaForma;
import forme.FormaMod;
import forme.model.ModelTabeleProizvod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import koordinator.Koordinator;

/**
 *
 * @author Korisnik
 */
public class DodajKupcaController {
    
    private final DodajKupcaForma dkf;

    public DodajKupcaController(DodajKupcaForma dkf) {
        this.dkf = dkf;
        addActionListener();
    }

    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        dkf.setVisible(true);
    }
      
    private void addActionListener() {
        dkf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                String email = dkf.getjTextFieldEmail().getText().trim();
                String ime = dkf.getjTextFieldIme().getText().trim();
                String prezime = dkf.getjTextFieldPrezime().getText().trim();
                String brTelefona = dkf.getjTextFieldBrojTelefona().getText().trim();
              
                if(email.isEmpty() || ime.isEmpty() || prezime.isEmpty() || brTelefona.isEmpty()){
                    JOptionPane.showMessageDialog(dkf, "Niste uneli sve potrebne podatke", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                boolean pozivNaBroj = brTelefona.startsWith("+381");
                String cifre = brTelefona.substring(1, brTelefona.length());
                boolean samoCifre = cifre.matches("[0-9]+");
                
                if(!(pozivNaBroj && samoCifre)){
                    JOptionPane.showMessageDialog(dkf, "Broj telefona mora da počinje sa +381 i da sadrži samo cifre nakon poziva na broj (na primer +381643825614)", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                        
                Kupac k = new Kupac(-1,email, ime, prezime, brTelefona);
                
                List<Kupac> kupci = komunikacija.Komunikacija.getInstance().ucitajKupce();
                for (Kupac kupac : kupci) {
                    if(kupac.getEmail().toLowerCase().equals(k.getEmail().toLowerCase())){
                        JOptionPane.showMessageDialog(dkf, "U bazi već postoji kupac sa unetim email-om", "Greška!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(kupac.getBrojTelefona().equals(k.getBrojTelefona())){
                        JOptionPane.showMessageDialog(dkf, "U bazi već postoji kupac sa unetim brojem telefona", "Greška!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                
                try{
                    komunikacija.Komunikacija.getInstance().dodajKupca(k);
                    JOptionPane.showMessageDialog(dkf, "Sistem je kreirao kupca", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    if(Koordinator.getInstance().pkController != null){
                        koordinator.Koordinator.getInstance().osveziFormuKupaca();
                    }
                    Koordinator.getInstance().glavnaFormaController.pripremiFormuKupaca();
                    dkf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dkf, "Sistem ne može da kreira kupca", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dkf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeni(e);
            }

            private void izmeni(ActionEvent e) {
                
                String email = dkf.getjTextFieldEmail().getText().trim();
                String ime = dkf.getjTextFieldIme().getText().trim();
                String prezime = dkf.getjTextFieldPrezime().getText().trim();
                String brTelefona = dkf.getjTextFieldBrojTelefona().getText().trim();
                
                if(email.isEmpty() || ime.isEmpty() || prezime.isEmpty() || brTelefona.isEmpty()){
                    JOptionPane.showMessageDialog(dkf, "Niste uneli sve potrebne podatke", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                 
                boolean pozivNaBroj = brTelefona.startsWith("+381");
                String cifre = brTelefona.substring(1, brTelefona.length());
                boolean samoCifre = cifre.matches("[0-9]+");
                
                if(!(pozivNaBroj && samoCifre)){
                    JOptionPane.showMessageDialog(dkf, "Broj telefona mora da počinje sa +381 i da sadrži samo cifre nakon poziva na broj (na primer +381643825614)", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                        
                Kupac k = (Kupac) Koordinator.getInstance().vratiParam("kupac");
                
                int id = k.getKupacID();
                
                Kupac kupac = new Kupac(id, email, ime, prezime, brTelefona);
                
                try{
                    komunikacija.Komunikacija.getInstance().izmeniKupca(kupac);
                    JOptionPane.showMessageDialog(dkf, "Sistem je zapamtio kupca", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    Koordinator.getInstance().glavnaFormaController.pripremiFormuKupaca();
                    dkf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dkf, "Sistem ne može da zapamti kupca", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dkf.getjButtonIzmeni().setVisible(false);
                dkf.getjButtonDodaj().setVisible(true);
                dkf.getjButtonDodaj().setEnabled(true);

                break;
            case IZMENI:
                dkf.getjButtonDodaj().setVisible(false);
                dkf.getjButtonIzmeni().setVisible(true);
                dkf.getjButtonIzmeni().setEnabled(true);

                Kupac k = (Kupac) Koordinator.getInstance().vratiParam("kupac");
                dkf.getjTextFieldEmail().setText(k.getEmail()+"");
                dkf.getjTextFieldIme().setText(k.getIme());
                dkf.getjTextFieldPrezime().setText(k.getPrezime());
                dkf.getjTextFieldBrojTelefona().setText(k.getBrojTelefona());
                
                break;
            default:
                throw new AssertionError();
        }
    }

}
