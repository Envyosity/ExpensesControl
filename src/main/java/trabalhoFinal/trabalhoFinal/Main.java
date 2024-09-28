/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trabalhoFinal.trabalhoFinal;

import br.univates.ogiva.persistence.DataBaseConnectionManager;
import br.univates.ogiva.persistence.DataBaseException;
import trabalhoFinal.apresentacao.MenuPrincipal;

/**
 *
 * @author leokr
 */
public class Main {

    public static void main(String[] args) {

        try {
            DataBaseConnectionManager dbcm = new DataBaseConnectionManager(DataBaseConnectionManager.POSTGRESQL,
                    "trabalhoFinal", "postgres", "postgres");

            dbcm.connectionTest();

            MenuPrincipal tela = new MenuPrincipal();
            tela.setVisible(true);

        } catch (DataBaseException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
