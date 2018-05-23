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
public class ContasDAO {

    //---------------------------------------------------------------------------------------------------------------------
    public ContasBean contascoCodigo(String coCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        ContasBean registro = new ContasBean();
        registro.setCocodigo("1");
        registro.setNome("Conta Banco");
        registro.setAgencia("1");
        registro.setNumconta("1");
        registro.setDvagencia(1);
        registro.setDvconta(0);
        registro.setSaldo(0.0);
        registro.setEmcodigo(0);
        registro.setCodcontab("1");
        registro.setDataalte(new Date());
        registro.setNumbanco("104");
        registro.setCarteira("");
        return registro;
    }

}
