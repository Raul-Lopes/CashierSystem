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
public class DiCliNegDAO {

    //----------------------------------------------------------------------------------------------------------------------------
    public DiCliNegBean DiCliNeg(String cnCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        DiCliNegBean registro = new DiCliNegBean();
        registro.setCnCodigo("1");
        registro.setNome("NOME");
        registro.setData(new Date());
        return registro;
    }

}
