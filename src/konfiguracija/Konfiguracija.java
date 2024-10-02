/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konfiguracija;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Konfiguracija {
    private static Konfiguracija instance;
    private Properties konfiguracija;
   
    public Konfiguracija() {
        try {
            konfiguracija = new Properties();
            konfiguracija.load(new FileInputStream("E:\\Korisnik\\Documents\\NetBeansProjects\\ELEKTRONSKI_UREDJAJI_SERVER\\config\\config.properties"));
            
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Konfiguracija getInstance() {
        if(instance == null){
            instance = new Konfiguracija();
        }
        return instance;
    }

    public String getProperty(String key) {
        return konfiguracija.getProperty(key, "n/a");
    }

    public void setProperty(String key, String value) {
        konfiguracija.setProperty(key, value);
    }
    
    public void sacuvajIzmene() throws IOException {
        try {
            konfiguracija.store(new FileOutputStream("E:\\Korisnik\\Documents\\NetBeansProjects\\ELEKTRONSKI_UREDJAJI_SERVER\\config\\config.properties"), null);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(Konfiguracija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
