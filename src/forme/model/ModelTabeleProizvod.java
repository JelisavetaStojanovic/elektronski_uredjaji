/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme.model;

import domen.Proizvod;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleProizvod extends AbstractTableModel {

    List<Proizvod> lista = new ArrayList<>();
    String[] kolone = {"id","cena","naziv","model"};

    public ModelTabeleProizvod(List<Proizvod> lista) {
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
        Proizvod p = lista.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getProizvodID();
            case 1:
                return p.getCena();
            case 2:
                return p.getNaziv();
            case 3:
                return p.getModel();
            default:
                return "NA";
        }
    }

    public List<Proizvod> getLista() {
        return lista;
    }

    public void pretrazi(String naziv) {
        List<Proizvod> filteredList = lista.stream()
                .filter(p -> (naziv == null || naziv.isEmpty() || p.getNaziv().toLowerCase().contains(naziv.toLowerCase())))
                .collect(Collectors.toList());
        
        this.lista = filteredList;
        fireTableDataChanged();
    }
    
    
}
