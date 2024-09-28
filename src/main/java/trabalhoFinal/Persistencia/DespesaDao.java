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
import java.util.Date;
import trabalhoFinal.negocio.Categoria;
import trabalhoFinal.negocio.Despesa;
import trabalhoFinal.negocio.Familiar;

/**
 *
 * @author leokr
 */
public class DespesaDao implements IDao<Despesa, Integer> {

    @Override
    public void create(Despesa despesa) {
        String sql = "INSERT INTO despesa (id_pessoa, id_categoria, nome, valor, data) VALUES( ?,?,?,?,? );";

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, despesa.getFamiliar().getId(), despesa.getCategoria().getId(), despesa.getNome(), despesa.getValor(), despesa.getData());

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Despesa read(Integer id) {
        Despesa d = null;

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(
                    DataBaseConnectionManager.POSTGRESQL, "trabalhoFinal", "postgres", "postgres");

            String sql = "SELECT * FROM despesa WHERE id_despesa = ?";

            dbcm.runPreparedQuerySQL(sql, id);

            ResultSet resultado = dbcm.getResultSet();

            if (resultado.isBeforeFirst()) {
                resultado.next();

                String nome = resultado.getString("nome");
                int categoria = resultado.getInt("id_categoria");
                int familiar = resultado.getInt("id_familiar");
                Double valor = resultado.getDouble("valor");
                Date data = resultado.getDate("data");

                IDao<Categoria, Integer> daoC = DaoFactory.criarCategoriaDao();
                IDao<Familiar, Integer> daoF = DaoFactory.criarFamiliarDao();

                d = new Despesa(id, nome, daoC.read(categoria), daoF.read(familiar), valor, data);

            }
            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Deu pau no ResultSet");
        }

        return d;
    }

    @Override
    public ArrayList<Despesa> readAll() {
        ArrayList<Despesa> listaDespesa = new ArrayList();

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(
                    DataBaseConnectionManager.POSTGRESQL, "trabalhoFinal", "postgres", "postgres");

            String sql = "SELECT * FROM despesa;";

            dbcm.runQuerySQL(sql);

            ResultSet resultado = dbcm.getResultSet();

            if (resultado.isBeforeFirst()) // significa que o resultado não é vazio
            {
                resultado.next();

                while (!resultado.isAfterLast()) {
                    int id = resultado.getInt("id_despesa");
                    String nome = resultado.getString("nome");
                    int categoria = resultado.getInt("id_categoria");
                    int familiar = resultado.getInt("id_pessoa");
                    Double valor = resultado.getDouble("valor");
                    Date data = resultado.getDate("data");
                    
                    IDao<Categoria, Integer> daoC = DaoFactory.criarCategoriaDao();
                    IDao<Familiar, Integer> daoF = DaoFactory.criarFamiliarDao();
                    
                    Despesa d = new Despesa(id, nome, daoC.read(categoria), daoF.read(familiar), valor, data);
                    listaDespesa.add(d);

                    resultado.next();
                }
            }
            dbcm.closeConnection();
        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaDespesa;
    }

    @Override
    public void update(Despesa despesa) {
        String sql = "UPDATE despesa SET nome=?, id_categoria=?, id_pessoa=?, valor=?, data=? WHERE id_despesa=?";
        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.runPreparedSQL(sql, despesa.getNome(), despesa.getCategoria().getId(), despesa.getFamiliar().getId(), despesa.getValor(), despesa.getData(), despesa.getId());

            dbcm.closeConnection();

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM despesa WHERE id_despesa=?";
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
    public ArrayList<Despesa> readAll(Filter<Despesa> filtro) {
        ArrayList<Despesa> todosResultados = readAll();
        ArrayList<Despesa> filtrado = new ArrayList<Despesa>();

        for (Despesa despesa : todosResultados) {
            if (filtro.isAccept(despesa)) {
                filtrado.add(despesa);
            }
        }

        return filtrado;
    }

}
