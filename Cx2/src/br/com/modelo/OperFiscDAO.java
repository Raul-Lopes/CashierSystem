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
public class OperFiscDAO {

    //----------------------------------------------------------------------------------------------------------------------------
    public OperFiscBean operFiscOfcodigo(int ofcodigo) throws SQLException, ClassNotFoundException, IOException, Exception {
        
        OperFiscBean registro = new OperFiscBean();
        registro.setOfcodigo(1);
        registro.setTiponf("S");
        registro.setNome("VENDA CONSUMIDOR FINAL");
        registro.setRegicms("");
        registro.setBaixaest("S");
        registro.setVenda("S");
        registro.setDataalte(new Date());
        registro.setCalcpiscofins("N");
        registro.setAtzcustos("N");
        return registro;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<OperFiscBean> listarOperFisc() throws SQLException, ClassNotFoundException, IOException, Exception {
        
        OperFiscBean registro1 = new OperFiscBean();
        registro1.setOfcodigo(5112);
        registro1.setTiponf("S");
        registro1.setNome("VENDA CONSUMIDOR FINAL");
        registro1.setRegicms("");
        registro1.setBaixaest("S");
        registro1.setVenda("O");  //orcamento
        registro1.setDataalte(new Date());
        registro1.setCalcpiscofins("N");
        registro1.setAtzcustos("N");
        
        OperFiscBean registro2 = new OperFiscBean();
        registro2.setOfcodigo(6112);
        registro2.setTiponf("S");
        registro2.setNome("VENDA FORA DO ESTADO");
        registro2.setRegicms("");
        registro2.setBaixaest("S");
        registro2.setVenda("S");
        registro2.setDataalte(new Date());
        registro2.setCalcpiscofins("N");
        registro2.setAtzcustos("N");
        
        return Arrays.asList(registro1, registro2);
    }
    
}
