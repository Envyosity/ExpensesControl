package trabalhoFinal.apresentacao;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import trabalhoFinal.negocio.Categoria;

public class TabelaCategoria implements TableModel
{
    private ArrayList<Categoria> listaCategorias;

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    
    
    public TabelaCategoria( ArrayList<Categoria> listaCategorias )
    {
        this.listaCategorias = listaCategorias;
    }

    @Override
    public int getRowCount()
    {
        return this.listaCategorias.size();
    }

    @Override
    public int getColumnCount()
    {
        return 1;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        String[] title = { "Nome" };
        return title[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Categoria c = listaCategorias.get(rowIndex);
        String[] campos = { c.getNome()};
        return campos[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l)
    {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l)
    {

    }
    
}
