/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author raul
 */
public class AliquotasDAO {

    //----------------------------------------------------------------------------------------------------------------------------
    public AliquotasBean listarAliquotaAlcodigo(int alcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        AliquotasBean registro = new AliquotasBean();
        registro.setAlcodigo(1);
        registro.setNome("Aliq 18%");
        registro.setPercaliq(18.0);
        registro.setCodtrib("TA");
        registro.setOrigem("ORIGEM");
        registro.setDataalte(new Date());
        return registro;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<AliquotasBean> tabelaAliquota() throws SQLException, ClassNotFoundException, IOException, Exception {

        AliquotasBean registro1 = new AliquotasBean();
        registro1.setAlcodigo(1);
        registro1.setNome("Aliq 18%");
        registro1.setPercaliq(18.0);
        registro1.setCodtrib("TA");
        registro1.setOrigem("ORIGEM");
        registro1.setDataalte(new Date());

        AliquotasBean registro2 = new AliquotasBean();
        registro2.setAlcodigo(1);
        registro2.setNome("Aliq 12%");
        registro2.setPercaliq(18.0);
        registro2.setCodtrib("TA");
        registro2.setOrigem("DESTINO");
        registro2.setDataalte(new Date());

        return Arrays.asList(registro1,registro2);
    }
}