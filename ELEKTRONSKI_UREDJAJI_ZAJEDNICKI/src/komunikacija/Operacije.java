/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package komunikacija;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */

public enum Operacije implements Serializable {
    LOGIN, 
    UCITAJ_PROIZVODE, 
    OBRISI_PROIZVOD, 
    DODAJ_PROIZVOD, 
    IZMENI_PROIZVOD, 
    DODAJ_KUPCA, 
    UCITAJ_KUPCE, 
    IZMENI_KUPCA, 
    DODAJ_NARUDZBENICU, 
    UCITAJ_NARUDZBENICE, 
    UCITAJ_STAVKE, 
    IZMENI_NARUDZBENICU;
}
