/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author raul
 */
public class CidadesDAO {

    //--------------------------------------------------------------------------------------------------------------------------
    public CidadesBean listarCidadesCiCodigo(int ciCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        CidadesBean registro = new CidadesBean();
        registro.setCicodigo(1);
        registro.setNome("SAO PAULO");
        registro.setUf("SP");
        registro.setCep("35.590-000");
        registro.setCodibge("3243");
        registro.setDataalte(new Date());
        registro.setCodpais("590");
        return registro;
    }

}
