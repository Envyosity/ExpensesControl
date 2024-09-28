/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoFinal.apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import trabalhoFinal.negocio.Familiar;

/**
 *
 * @author leokr
 */
public class TabelaFamiliar implements TableModel {

    private ArrayList<Familiar> listaFamiliar;

    public ArrayList<Familiar> getListaFamiliar() {
        return listaFamiliar;
    }

    public TabelaFamiliar(ArrayList<Familiar> listaFamiliar) {
        this.listaFamiliar = listaFamiliar;
    }

    @Override
    public int getRowCount() {
        return this.listaFamiliar.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] title = {"Nome"};
        return title[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Familiar f = listaFamiliar.get(rowIndex);
        String[] campos = {f.getNome()};
        return campos[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
