/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.modelo;

import java.io.IOException;
import java.sql.SQLException;
import static java.util.Arrays.asList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Raul
 */
public class CentCustDAO {

    //-------------------------------------------------------------------------------------------------------------------------------
    public CentCustBean listarCentCustCecodigo(String ceCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        CentCustBean registro = new CentCustBean();
        registro.setCecodigo("1");
        registro.setNome("Centro de Custo Unico");
        registro.setPai("");
        registro.setEmcodigo(0);
        registro.setDataalte(new Date());
        return registro;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<CentCustBean> tabelaCentCust() throws SQLException, ClassNotFoundException, IOException, Exception {

        CentCustBean registro1 = new CentCustBean();
        registro1.setCecodigo("1");
        registro1.setNome("Centro de Custo Unico");
        registro1.setPai("");
        registro1.setEmcodigo(0);
        registro1.setDataalte(new Date());

        CentCustBean registro2 = new CentCustBean();
        registro2.setCecodigo("1");
        registro2.setNome("Centro de Custo Especifico");
        registro2.setPai("");
        registro2.setEmcodigo(0);
        registro2.setDataalte(new Date());

        return asList(registro1, registro2);
    }

}
