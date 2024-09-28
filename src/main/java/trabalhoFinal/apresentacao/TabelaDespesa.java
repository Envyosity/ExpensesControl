/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoFinal.apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import trabalhoFinal.negocio.Despesa;
import trabalhoFinal.negocio.Familiar;

/**
 *
 * @author leokr
 */
public class TabelaDespesa implements TableModel {
      private ArrayList<Despesa> listaDespesa;

    public ArrayList<Despesa> getListaDespesa() {
        return listaDespesa;
    }

    public TabelaDespesa(ArrayList<Despesa> listaDespesa) {
        this.listaDespesa = listaDespesa;
    }

    @Override
    public int getRowCount() {
        return this.listaDespesa.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] title = {"Nome", "Categoria", "Familiar", "Valor", "Data"};
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
        Despesa d = listaDespesa.get(rowIndex);
        String[] dataQuebrada = d.getData().split("-");
        String dataReal = (dataQuebrada[2] + "/" + dataQuebrada[1] + "/" + dataQuebrada[0]);
        String[] campos = {d.getNome(), d.getCategoria().getNome(), d.getFamiliar().getNome(), String.valueOf(d.getValor()), dataReal};
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
