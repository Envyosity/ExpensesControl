/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoFinal.Persistencia;

import br.univates.ogiva.persistence.DataBaseConnectionManager;
import br.univates.ogiva.persistence.DataBaseException;
import br.univates.ogiva.persistence.Filter;
import br.univates.ogiva.persistence.IDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import trabalhoFinal.negocio.Categoria;

/**
 *
 * @author leokr
 */
public class CategoriaDao implements IDao<Categoria, Integer> {

    @Override
    public void create(Categoria categoria) {
        String sql = "INSERT INTO categoria VALUES( ? );";

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, categoria.getNome());

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public ArrayList readAll() {
        ArrayList<Categoria> listaCategoria = new ArrayList();

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(
                    DataBaseConnectionManager.POSTGRESQL, "trabalhoFinal", "postgres", "postgres");

            String sql = "SELECT * FROM categoria;";

            dbcm.runQuerySQL(sql);

            ResultSet resultado = dbcm.getResultSet();

            if (resultado.isBeforeFirst()) // significa que o resultado não é vazio
            {
                resultado.next();

                while (!resultado.isAfterLast()) {
                    String nome = resultado.getString("nome");
                    int id = resultado.getInt("id_categoria");

                    Categoria c = new Categoria(nome, id);
                    listaCategoria.add(c);

                    resultado.next();
                }
            }
            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaCategoria;
    }

    @Override
    public ArrayList readAll(Filter filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Categoria despesa) {
        String sql = "UPDATE categoria SET nome=? WHERE id_categoria=?";
        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, despesa.getNome(), despesa.getId());

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM categoria WHERE id_categoria=?";
        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, id);

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Categoria read(Integer id) {
        Categoria c = null;

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(
                    DataBaseConnectionManager.POSTGRESQL, "trabalhoFinal", "postgres", "postgres");

            String sql = "SELECT * FROM categoria WHERE id_categoria = ?";

            dbcm.runPreparedQuerySQL(sql, id);

            ResultSet resultado = dbcm.getResultSet();
            if (resultado.isBeforeFirst()) // significa que o resultado não é vazio
            {
                resultado.next();

                String nome = resultado.getString("nome");

                c = new Categoria(nome, id);

            }
            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }

}
