
package trabalhoFinal.Persistencia;

import br.univates.ogiva.persistence.IDao;

//substitui por IDao dao = DaoFactory.criarCategoriaDao
public class DaoFactory {
    
    public static IDao criarCategoriaDao()
    {
    return new CategoriaDao();
    } 
    
    public static IDao criarFamiliarDao()
    {
        return new FamiliarDao();
    }
    
    public static IDao criarDespesaDao()
    {
        return new DespesaDao();
    }
}
