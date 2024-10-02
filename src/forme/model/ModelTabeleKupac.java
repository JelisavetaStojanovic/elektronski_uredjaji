/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Kupac;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleKupac extends AbstractTableModel {
    List<Kupac> lista = new ArrayList<>();
    String[] kolone = {"id","email","ime","prezime","broj telefona"};

    public ModelTabeleKupac(List<Kupac> lista) {
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
        Kupac k = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return k.getKupacID();
            case 1:
                return k.getEmail();
            case 2:
                return k.getIme();
            case 3:
                return k.getPrezime();
            case 4:
                return k.getBrojTelefona();
            default:
                return "NA";
        }
    }

    public List<Kupac> getLista() {
        return lista;
    }

    public void pretrazi(String pretraga) {
        List<Kupac> filteredList = lista.stream()
                .filter(p -> (pretraga == null || pretraga.isEmpty() || p.getIme().toLowerCase().contains(pretraga.toLowerCase()) || p.getPrezime().toLowerCase().contains(pretraga.toLowerCase())))
                .collect(Collectors.toList());
        
        this.lista = filteredList;
        fireTableDataChanged();
    }
    
}
