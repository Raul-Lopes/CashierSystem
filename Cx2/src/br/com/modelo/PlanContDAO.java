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
public class PlanContDAO {

    //--------------------------------------------------------------------------------------------------------------
    public PlanContBean PlanContPlCodigo(String plCodigo) throws SQLException, ClassNotFoundException, IOException, Exception {

        PlanContBean registro = new PlanContBean();
        registro.setPlcodigo("12");
        registro.setNome("VENDAS EM CASH");
        registro.setTipo("C");
        registro.setTransfer("S");
        registro.setEmcodigo(1);
        registro.setDataalte(new Date());
        registro.setCobracnab("N");
        registro.setCobrapispasep("N");
        registro.setCodcontab("1");
        registro.setCodcontabdeb("1");
        registro.setCodcredbcnat("1");
        return registro;
    }

    //--------------------------------------------------------------------------------------------------------------
    public List<PlanContBean> listaPlanCont() throws SQLException, ClassNotFoundException, IOException, Exception {

        PlanContBean registro1 = new PlanContBean();
        registro1.setPlcodigo("12");
        registro1.setNome("VENDAS EM CASH");
        registro1.setTipo("C");
        registro1.setTransfer("S");
        registro1.setEmcodigo(1);
        registro1.setDataalte(new Date());
        registro1.setCobracnab("N");
        registro1.setCobrapispasep("N");
        registro1.setCodcontab("1");
        registro1.setCodcontabdeb("1");
        registro1.setCodcredbcnat("1");

        PlanContBean registro2 = new PlanContBean();
        registro2.setPlcodigo("12");
        registro2.setNome("VENDAS EM CASH");
        registro2.setTipo("C");
        registro2.setTransfer("S");
        registro2.setEmcodigo(1);
        registro2.setDataalte(new Date());
        registro2.setCobracnab("N");
        registro2.setCobrapispasep("N");
        registro2.setCodcontab("1");
        registro2.setCodcontabdeb("1");
        registro2.setCodcredbcnat("1");

        return asList(registro1, registro2);
    }

}
