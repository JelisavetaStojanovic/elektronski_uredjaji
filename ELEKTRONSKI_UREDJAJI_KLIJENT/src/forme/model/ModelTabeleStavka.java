/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Kupac;
import domen.StavkaNarudzbenice;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleStavka extends AbstractTableModel {
    List<StavkaNarudzbenice> lista = new ArrayList<>();
    String[] kolone = {"proizvod","cena proizvoda","količina","cena stavke"};

    public ModelTabeleStavka(List<StavkaNarudzbenice> lista) {
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaNarudzbenice sn = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sn.getProizvod().getNaziv();
            case 1:
                return sn.getCenaProizvoda();
            case 2:
                return sn.getKolicina();
            case 3:
                return sn.getCenaStavke();
            default:
                return "NA";
        }
    }

    public List<StavkaNarudzbenice> getLista() {
        return lista;
    }

    public void obrisiStavku(StavkaNarudzbenice sn) {
        lista.remove(sn);
        fireTableDataChanged();
    }

    public void dodaj(StavkaNarudzbenice sn) {
        lista.add(sn);
        fireTableDataChanged();
    }
}
