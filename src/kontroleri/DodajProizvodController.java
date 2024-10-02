/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Proizvod;
import domen.Zaposleni;
import forme.DodajProizvodForma;
import forme.FormaMod;
import forme.PrikazProizvodaForma;
import forme.model.ModelTabeleProizvod;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import koordinator.Koordinator;

/**
 *
 * @author Korisnik
 */
public class DodajProizvodController {
    
    private final DodajProizvodForma dpf;

    public DodajProizvodController(DodajProizvodForma dpf) {
        this.dpf = dpf;
        addActionListener();
    }

    public void otvoriFormu(FormaMod mod) {
        pripremiFormu(mod);
        dpf.setVisible(true);
    }

    private void addActionListener() {
            dpf.dodajAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dodaj(e);
            }

            private void dodaj(ActionEvent e) {
                
                String naziv = dpf.getjTextFieldNaziv().getText().trim();
                String model = dpf.getjTextFieldModel().getText().trim();
                
                if(naziv.isEmpty()){
                    JOptionPane.showMessageDialog(dpf, "Niste uneli naziv proizvoda", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(model.isEmpty()){
                    JOptionPane.showMessageDialog(dpf, "Niste uneli model proizvoda", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double cena;
                try{
                    cena = Double.parseDouble(dpf.getjTextFieldCena().getText());
                } catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(dpf, "Greška, cena mora biti broj", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(cena < 0){
                    JOptionPane.showMessageDialog(dpf, "Cena mora biti broj veći od 0", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
        
                Proizvod p = new Proizvod(-1,cena,naziv,model);
                
                List<Proizvod> proizvodi = komunikacija.Komunikacija.getInstance().ucitajProizvode();
                for (Proizvod proizvod : proizvodi) {
                    if(proizvod.getNaziv().toLowerCase().equals(p.getNaziv().toLowerCase()) && proizvod.getModel().toLowerCase().equals(p.getModel().toLowerCase())){
                        JOptionPane.showMessageDialog(dpf, "Proizvod već postoji u bazi", "Greška!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                
                try{
                    komunikacija.Komunikacija.getInstance().dodajProizvod(p);
                    JOptionPane.showMessageDialog(dpf, "Sistem je kreirao proizvod", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    if(Koordinator.getInstance().ppController != null){
                        koordinator.Koordinator.getInstance().osveziTabeluProizvoda();
                    }
                    dpf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dpf, "Sistem ne može da kreira proizvod", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
            dpf.izmeniAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                izmeni(e);
            }

            private void izmeni(ActionEvent e) {
                
                String naziv = dpf.getjTextFieldNaziv().getText().trim();
                String model = dpf.getjTextFieldModel().getText().trim();
                
                if(naziv.isEmpty()){
                    JOptionPane.showMessageDialog(dpf, "Niste uneli naziv proizvoda", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(model.isEmpty()){
                    JOptionPane.showMessageDialog(dpf, "Niste uneli model proizvoda", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                double cena;
                try{
                    cena = Double.parseDouble(dpf.getjTextFieldCena().getText());
                } catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(dpf, "Greška, cena mora biti broj", "GREŠKA", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(cena < 0){
                    JOptionPane.showMessageDialog(dpf, "Cena mora biti broj veći od 0", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                Proizvod proizvod = (Proizvod) Koordinator.getInstance().vratiParam("proizvod");
                int id = proizvod.getProizvodID();
                
                Proizvod p = new Proizvod(id,cena,naziv,model);
                
                try{
                    komunikacija.Komunikacija.getInstance().izmeniProizvod(p);
                    JOptionPane.showMessageDialog(dpf, "Sistem je zapamtio proizvod", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                }catch(Exception exc){
                    JOptionPane.showMessageDialog(dpf, "Sistem ne može da zapamti proizvod", "Greška", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        dpf.addBtnObrisiActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int potvrda = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da obrišete proizvod?", "Potvrda", JOptionPane.YES_NO_OPTION);
                if(potvrda == JOptionPane.NO_OPTION || potvrda == JOptionPane.CLOSED_OPTION){
                    return;
                }
                Proizvod p = (Proizvod) Koordinator.getInstance().vratiParam("proizvod");
                try {
                    komunikacija.Komunikacija.getInstance().obrisiProizvod(p);
                    ///////////
                    JOptionPane.showMessageDialog(dpf, "Sistem je obrisao proizvod", "Uspeh", JOptionPane.INFORMATION_MESSAGE);
                    dpf.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(dpf, "Sistem ne može da obrise proizvod", "Greška", JOptionPane.ERROR_MESSAGE);
                }
                Koordinator.getInstance().ppController.osveziFormu();
            }
        });
    }

    private void pripremiFormu(FormaMod mod) {
        switch (mod) {
            case DODAJ:
                dpf.getjButtonIzmeni().setVisible(false);
                dpf.getjButtonObrisi().setVisible(false);
                dpf.getjButtonDodaj().setVisible(true);
                dpf.getjButtonDodaj().setEnabled(true);

                break;
            case IZMENI:
                dpf.getjButtonDodaj().setVisible(false);
                dpf.getjButtonIzmeni().setVisible(true);
                dpf.getjButtonIzmeni().setEnabled(true);
                dpf.getjButtonObrisi().setVisible(true);
                dpf.getjButtonObrisi().setEnabled(true);

                Proizvod p = (Proizvod) Koordinator.getInstance().vratiParam("proizvod");
                dpf.getjTextFieldCena().setText(p.getCena()+"");
                dpf.getjTextFieldNaziv().setText(p.getNaziv());
                dpf.getjTextFieldModel().setText(p.getModel());
                
                break;
            default:
                throw new AssertionError();
        }
    }
}
