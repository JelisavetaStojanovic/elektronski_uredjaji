/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Narudzbenica;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleNarudzbenica extends AbstractTableModel {
    List<Narudzbenica> lista = new ArrayList<>();
    String[] kolone = {"kupac","ukupna cena"};

    public ModelTabeleNarudzbenica(List<Narudzbenica> lista) {
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
        Narudzbenica n = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return n.getKupac().toString();
            case 1:
                return n.getUkupnaCena();
            default:
                return "NA";
        }
    }

    public List<Narudzbenica> getLista() {
        return lista;
    }

    public void pretrazi(String pretraga) {
        List<Narudzbenica> filteredList = lista.stream()
                .filter(p -> (pretraga == null || pretraga.isEmpty() || p.getKupac().getIme().toLowerCase().contains(pretraga.toLowerCase()) || p.getKupac().getPrezime().toLowerCase().contains(pretraga.toLowerCase())))
                .collect(Collectors.toList());
        
        this.lista = filteredList;
        fireTableDataChanged();
    }
}
