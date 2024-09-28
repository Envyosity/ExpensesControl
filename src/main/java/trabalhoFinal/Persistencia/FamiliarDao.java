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
import trabalhoFinal.negocio.Familiar;

/**
 *
 * @author leokr
 */
public class FamiliarDao implements IDao<Familiar, Integer> {

    @Override
    public void create(Familiar familiar) {
        String sql = "INSERT INTO familiar VALUES( ? );";

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, familiar.getNome());

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Familiar read(Integer id) {
        Familiar f = null;

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(
                    DataBaseConnectionManager.POSTGRESQL, "trabalhoFinal", "postgres", "postgres");

            String sql = "SELECT * FROM familiar WHERE id_pessoa= ?";

            dbcm.runPreparedQuerySQL(sql, id);

            ResultSet resultado = dbcm.getResultSet();

            if (resultado.isBeforeFirst()) // significa que o resultado não é vazio
            {
                resultado.next();

                String nome = resultado.getString("nome");

                f = new Familiar(nome, id);

            }
            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return f;
    }

    @Override
    public ArrayList<Familiar> readAll() {
        ArrayList<Familiar> listaFamiliar = new ArrayList();

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(
                    DataBaseConnectionManager.POSTGRESQL, "trabalhoFinal", "postgres", "postgres");

            String sql = "SELECT * FROM familiar;";

            dbcm.runQuerySQL(sql);

            ResultSet resultado = dbcm.getResultSet();

            if (resultado.isBeforeFirst()) // significa que o resultado não é vazio
            {
                resultado.next();

                while (!resultado.isAfterLast()) {
                    String nome = resultado.getString("nome");
                    int id = resultado.getInt("id_pessoa");
                    
                    Familiar f = new Familiar(nome , id);
                    listaFamiliar.add(f);

                    resultado.next();
                }
            }
            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaFamiliar;
    }

    @Override
    public ArrayList<Familiar> readAll(Filter<Familiar> filtro) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Familiar familiar) {
        String sql = "UPDATE familiar SET nome=? WHERE id_pessoa=?";
        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, familiar.getNome(), familiar.getId());

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM familiar WHERE id_pessoa=?";
        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, id);

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
