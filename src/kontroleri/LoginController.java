/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kontroleri;

import domen.Zaposleni;
import forme.LoginForma;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import koordinator.Koordinator;

/**
 *
 * @author Korisnik
 */
public class LoginController {
    
    private final LoginForma lf;

    public LoginController(LoginForma lf) {
        this.lf = lf;
        AddActionListener();
        
    }

    private void AddActionListener() {
        
        lf.loginAddActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                prijava(e);
            }

            private void prijava(ActionEvent e) {
                String username = lf.getjTextFieldUsername().getText().trim();
                String password = String.valueOf(lf.getjPasswordFieldPassword().getPassword());
                
                if(username.isEmpty()){
                    JOptionPane.showMessageDialog(lf, "Niste uneli username", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(password.isEmpty()){
                    JOptionPane.showMessageDialog(lf, "Niste uneli password", "Greška!", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                komunikacija.Komunikacija.getInstance().konekcija();
                Zaposleni ulogovani = komunikacija.Komunikacija.getInstance().login(username,password);
                
                if(ulogovani == null){
                    JOptionPane.showMessageDialog(lf, "Sistem ne može da pronađe nalog zaposlenog", "Greška!", JOptionPane.ERROR_MESSAGE);
                }else{
                    Koordinator.getInstance().setUlogovani(ulogovani);
                    JOptionPane.showMessageDialog(lf, "Uspešno ste se prijavili na sistem", "Uspeh!", JOptionPane.INFORMATION_MESSAGE);
                    Koordinator.getInstance().otvoriGlavnuFormu();
                    lf.dispose();
                }
            }
        });
        
    }

    public void otvoriFormu() {
        lf.setVisible(true);
    }

 
}
