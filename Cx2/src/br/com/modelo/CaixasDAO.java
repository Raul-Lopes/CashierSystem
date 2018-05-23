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
 * @author raul
 */
public class CaixasDAO {

    //----------------------------------------------------------------------------------------------------------------------------
    public CaixasBean caixasCacodigo(String caCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        CaixasBean registro = new CaixasBean();
        registro.setCacodigo("C1");
        registro.setNome("EQUIPAMENTO C1");
        registro.setData(new Date());
        registro.setPeriodo(1);
        registro.setFucodigo(1);
        registro.setHora("11:23");
        registro.setSaldo(1.22);
        registro.setFechamento(0.0);
        registro.setLeituraz("S");
        registro.setPathtxt_r("");
        registro.setCodecfdes(0);
        registro.setSetor("");
        registro.setDataalte(new Date());
        registro.setEcfseque("");
        registro.setEcfserie("");
        registro.setEcfmarca("");
        registro.setEcfmodelo("");
        registro.setEcftipo("");
        registro.setSwbversao("1.01");
        registro.setSwbdthrgr(new Date());
        registro.setSwbmfadic("");
        return registro;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<CaixasBean> listaCaixas() throws SQLException, ClassNotFoundException, IOException, Exception {

        CaixasBean registro2 = new CaixasBean();
        registro2.setCacodigo("C1");
        registro2.setNome("EQUIPAMENTO C1");
        registro2.setData(new Date());
        registro2.setPeriodo(1);
        registro2.setFucodigo(1);
        registro2.setHora("11:23");
        registro2.setSaldo(1.22);
        registro2.setFechamento(0.0);
        registro2.setLeituraz("S");
        registro2.setPathtxt_r("");
        registro2.setCodecfdes(0);
        registro2.setSetor("");
        registro2.setDataalte(new Date());
        registro2.setEcfseque("");
        registro2.setEcfserie("");
        registro2.setEcfmarca("");
        registro2.setEcfmodelo("");
        registro2.setEcftipo("");
        registro2.setSwbversao("1.01");
        registro2.setSwbdthrgr(new Date());
        registro2.setSwbmfadic("");

        CaixasBean registro1 = new CaixasBean();
        registro1.setCacodigo("C1");
        registro1.setNome("EQUIPAMENTO C1");
        registro1.setData(new Date());
        registro1.setPeriodo(1);
        registro1.setFucodigo(1);
        registro1.setHora("11:23");
        registro1.setSaldo(1.22);
        registro1.setFechamento(0.0);
        registro1.setLeituraz("S");
        registro1.setPathtxt_r("");
        registro1.setCodecfdes(0);
        registro1.setSetor("");
        registro1.setDataalte(new Date());
        registro1.setEcfseque("");
        registro1.setEcfserie("");
        registro1.setEcfmarca("");
        registro1.setEcfmodelo("");
        registro1.setEcftipo("");
        registro1.setSwbversao("1.01");
        registro1.setSwbdthrgr(new Date());
        registro1.setSwbmfadic("");

        return asList(registro1, registro2);
    }

}
